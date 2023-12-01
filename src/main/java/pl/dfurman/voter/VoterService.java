package pl.dfurman.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class VoterService {
    private final VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @GetMapping
    public List<Voter> getVoters() {
        return voterRepository.findAll();
    }

    public void addNewVoter(Voter voter) {
        Optional<Voter> voterOptional = voterRepository.findByEmail(voter.getEmail());
        if (voterOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        voterRepository.save(voter);
    }
}
