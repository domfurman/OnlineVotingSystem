package pl.dfurman.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final JdbcUserRepository jdbcUserRepository;

    @Autowired
    public UserService(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return jdbcUserRepository.findAll();
    }

    public void addNewUser(User user) {
        User userByEmail = jdbcUserRepository.findByEmail(user.getEmail());
        jdbcUserRepository.save(user);
    }

    public void deleteUser(int voterId) {
        boolean exists = jdbcUserRepository.existsById(voterId);
        if (!exists) {
            throw new IllegalStateException("User with id " + voterId + " does not exist");
        }
        jdbcUserRepository.deleteById(voterId);
    }

    @Transactional
    public void updateUser(int userId, String firstName, String lastName, String email) {
        User user = jdbcUserRepository.findById(userId);

        if (firstName != null && !firstName.isEmpty() && !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty() && !Objects.equals(user.getLastName(), lastName)) {
            user.setLastName(lastName);
        }
        if (email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)) {
            User userOptional = jdbcUserRepository.findByEmail(email);
            user.setEmail(email);
        }
    }
}
