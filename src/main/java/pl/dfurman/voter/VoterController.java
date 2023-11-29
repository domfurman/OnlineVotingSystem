package pl.dfurman.voter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "voter")
public class VoterController {

    @GetMapping
    public List<Voter> hello() {
        return List.of(
                new Voter(
                        1L,
                        "John",
                        "Travolta",
                        "jtrav@band.com",
                        LocalDate.of(2001, Month.APRIL, 20)
                )
        );
    }
}
