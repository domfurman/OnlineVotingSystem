package pl.dfurman.voting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dfurman.voting.votingrepository.JdbcVotingRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@Configuration
public class VotingConfig {

    @Bean
    CommandLineRunner commandLineRunner2(JdbcVotingRepository repository) {
        return args -> {
            Voting voting1 = new Voting(
                    UUID.randomUUID(),
                    "Election1",
                    0,
                    0,
                    LocalDate.of(2011, Month.FEBRUARY, 22),
                    LocalDate.of(2025, Month.APRIL, 16)
            );
            repository.saveVoting(voting1);
        };
    }

}
