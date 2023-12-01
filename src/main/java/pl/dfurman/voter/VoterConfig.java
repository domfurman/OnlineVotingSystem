package pl.dfurman.voter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class VoterConfig {

    @Bean
    CommandLineRunner commandLineRunner(VoterRepository repository) {
        return args -> {
            Voter john = new Voter(
                    "John",
                    "Travolta",
                    "jtrav@band.com",
                    LocalDate.of(2001, Month.APRIL, 20)
            );
            Voter edgar = new Voter(
                    "Edgar",
                    "Davids",
                    "edavids@band.com",
                    LocalDate.of(2003, Month.SEPTEMBER, 11)
            );
        repository.saveAll(List.of(john, edgar));
        };
    }
}
