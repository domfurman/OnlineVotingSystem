package pl.dfurman.voter;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class VoterService {

    @GetMapping
    public List<Voter> getVoters() {
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
