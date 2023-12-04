package pl.dfurman.OnlineVotingSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dfurman.user.User;
import pl.dfurman.user.UserRepository;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class DbTest {

    @Autowired
    UserRepository userRepository;
    public User thereIsVoter() {
        return new User(
                "Cristiano",
                "Ronaldo",
                "cr7@gmail.com",
                LocalDate.of(1985, Month.FEBRUARY, 25)
        );
    }

    @Test
    void itAllowsToAddVoterToDatabase() {
        User exampleUser = thereIsVoter();
        userRepository.save(exampleUser);
        assert userRepository.findByEmail("cr7@gmail.com").isPresent();
    }
}
