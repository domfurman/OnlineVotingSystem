package pl.dfurman.voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "voter")
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
}
