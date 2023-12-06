package pl.dfurman.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

//    public void addNewUser(User user) {
//        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
//        if (userOptional.isPresent()) {
//            throw new IllegalStateException("email taken");
//        }
//        userRepository.save(user);
//    }
//
//    public void deleteUser(Long voterId) {
//        boolean exists = userRepository.existsById(voterId);
//        if (!exists) {
//            throw new IllegalStateException("User with id " + voterId + " does not exist");
//        }
//        userRepository.deleteById(voterId);
//    }
//
//    @Transactional
//    public void updateUser(Long userId, String firstName, String lastName, String email) {
//        User user = userRepository.findById(userId).orElseThrow(
//                () -> new IllegalStateException("User with id " + userId + " not found")
//        );
//        if (firstName != null && !firstName.isEmpty() && !Objects.equals(user.getFirstName(), firstName)) {
//            user.setFirstName(firstName);
//        }
//        if (lastName != null && !lastName.isEmpty() && !Objects.equals(user.getLastName(), lastName)) {
//            user.setLastName(lastName);
//        }
//        if (email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)) {
//            Optional<User> userOptional = userRepository.findByEmail(email);
//            if (userOptional.isPresent()) {
//                throw new IllegalStateException("email taken");
//            }
//            user.setEmail(email);
//        }
//    }
}
