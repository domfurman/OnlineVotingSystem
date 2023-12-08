package pl.dfurman.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

//    @GetMapping(path = "/{uuid}")
//    public Voting getVotingByUUID(@PathVariable UUID uuid) {
//        return votingService.getVotingByUUID(uuid);
//    }

//    @GetMapping(path = "/{voting_name}")
//    public Voting getVotingByName(@PathVariable String voting_name) {
//        return votingService.getVotingByName(voting_name);
//    }

    @PostMapping
    public void addNewVoting(@RequestBody Voting voting) {
        votingService.addNewVoting(voting);
    }

    @DeleteMapping(path = "{uuid}")
    public void deleteVotingByUUID(@PathVariable("uuid") UUID uuid) {
        votingService.deleteVotingByUUID(uuid);
    }

    @PutMapping(path = "{uuid}")
    public void updateVoting(@PathVariable("uuid") UUID uuid,
                             @RequestParam(required = false) String newName,
                             @RequestParam(required = false) LocalDate newValidityDate) {
        votingService.updateVoting(uuid, newName, newValidityDate);
    }



}
