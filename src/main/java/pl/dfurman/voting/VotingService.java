package pl.dfurman.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
        votingRepository.save(voting);
    }
}
