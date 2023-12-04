package pl.dfurman.voter;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "voters")
public class VoterController {
    private final VoterService voterService;

    @Autowired
    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @GetMapping
    public List<Voter> getVoters() {
        return voterService.getVoters();
    }

    @PostMapping
    public void registerNewVoter(@RequestBody Voter voter) {
        voterService.addNewVoter(voter);
    }

    @DeleteMapping(path = "{voterId}")
    public void deleteVoter(@PathVariable("voterId") Long voterId) {
        voterService.deleteVoter(voterId);
    }

    @PutMapping(path = "{voterId}")
    public void updateVoter(@PathVariable("voterId") Long voterId,
                            @RequestParam(required = false) String firstName,
                            @RequestParam(required = false) String lastName,
                            @RequestParam(required = false) String email) {
        voterService.updateVoter(voterId, firstName, lastName, email);
    }
}
