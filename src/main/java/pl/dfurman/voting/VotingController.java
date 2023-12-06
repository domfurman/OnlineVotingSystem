package pl.dfurman.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/votings")
public class VotingController {
    private final VotingService votingService;

    @Autowired
    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @GetMapping
    public List<Voting> getVotings() {
        return votingService.getVotings();
    }

    @PostMapping
    public void addNewVoting(@RequestBody Voting voting) {
        votingService.addNewVoting(voting);
    }

}
