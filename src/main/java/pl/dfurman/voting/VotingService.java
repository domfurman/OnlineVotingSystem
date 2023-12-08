package pl.dfurman.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.dfurman.voting.votingrepository.VotingRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
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
}
