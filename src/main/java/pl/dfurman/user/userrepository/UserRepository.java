package pl.dfurman.user.userrepository;

import pl.dfurman.user.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findByEmail(String email);

    User findById(int id);

    int save(User user);

    int deleteById(int id);

    boolean existsById(int id);


}
