package pl.dfurman.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User john = new User(
                    "John",
                    "Travolta",
                    "jtrav@band.com",
                    LocalDate.of(2001, Month.APRIL, 20)
            );
            User edgar = new User(
                    "Edgar",
                    "Davids",
                    "edavids@band.com",
                    LocalDate.of(2003, Month.SEPTEMBER, 11)
            );
        repository.saveAll(List.of(john, edgar));
        };
    }
}
