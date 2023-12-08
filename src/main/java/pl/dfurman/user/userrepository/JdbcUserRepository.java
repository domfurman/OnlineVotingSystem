package pl.dfurman.user.userrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dfurman.user.User;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                BeanPropertyRowMapper.newInstance(User.class));
    }
    @Override
    public User findByEmail(String email) {
        try {
            User userByEmail = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email= ?",
                    BeanPropertyRowMapper.newInstance(User.class), email);
            return userByEmail;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public User findById(int id) {
        try {
            User userById = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id= ?",
                    BeanPropertyRowMapper.newInstance(User.class), id);
            return userById;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int save(User user) {
        jdbcTemplate.update("INSERT INTO users (email, first_name, last_name, date_of_birth) VALUES (?, ?, ?, ?)",
                new Object[] {
//                        user.getId(),
                        user.getEmail(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getDateOfBirth()
                }
                );
        return 200;
    }

    @Override
    public int deleteById(int id) {
        if (existsById(id)) {
            jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
        }
        return 200;
    }

    @Override
    public boolean existsById(int id) {
        try {
            User userById = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id= ?",
                    BeanPropertyRowMapper.newInstance(User.class), id);
            return true;
        } catch (IncorrectResultSizeDataAccessException e) {
            return false;
        }
    }
}
