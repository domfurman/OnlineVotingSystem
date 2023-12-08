package pl.dfurman.voting;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dfurman.voting.votingrepository.VotingRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class VotingService {
    private final VotingRepository votingRepository;

    @Autowired
    public VotingService(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    public List<Voting> getVotings() {
        return votingRepository.findAll();
    }

    public void addNewVoting(Voting voting) {
        votingRepository.saveVoting(voting);
    }

    public Voting getVotingByUUID(UUID uuid) {
        return votingRepository.findByUUID(uuid);
    }

    public Voting getVotingByName(String name) {
        return votingRepository.findByName(name);
    }

    public void deleteVotingByUUID(UUID uuid) {
        votingRepository.deleteByUUID(uuid);
    }

    @Transactional
    public void updateVoting(UUID uuid, String newName, LocalDate newValidityDate) {
        Voting voting = votingRepository.findByUUID(uuid);

        if (!newName.isEmpty() && !Objects.equals(voting.getVoteName(), newName)) {
            voting.setVoteName(newName);
        }

        if (!newValidityDate.isBefore(voting.getCreationDate())) {
            voting.setValidityDate(newValidityDate);
        }

    }
}
