package pl.dfurman.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dfurman.user.userrepository.JdbcUserRepository;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(JdbcUserRepository repository) {
        return args -> {
            try {
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
//        repository.saveAll(List.of(john, edgar));
//                repository.save(john);
//                repository.save(edgar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
