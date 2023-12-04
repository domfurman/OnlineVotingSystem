package pl.dfurman.OnlineVotingSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dfurman.voter.Voter;
import pl.dfurman.voter.VoterRepository;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class DbTest {

    @Autowired
    VoterRepository voterRepository;
    public Voter thereIsVoter() {
        return new Voter(
                "Cristiano",
                "Ronaldo",
                "cr7@gmail.com",
                LocalDate.of(1985, Month.FEBRUARY, 25)
        );
    }

    @Test
    void itAllowsToAddVoterToDatabase() {
        Voter exampleVoter = thereIsVoter();
        voterRepository.save(exampleVoter);
        assert voterRepository.findByEmail("cr7@gmail.com").isPresent();
    }
}
