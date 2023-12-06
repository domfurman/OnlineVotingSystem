package pl.dfurman.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Override
//    public Optional<User> findByEmail(String email) {
//        Optional<User> user = jdbcTemplate.query("SELECT * FROM users",
//                BeanPropertyRowMapper.newInstance(User.class));
//    }


    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                BeanPropertyRowMapper.newInstance(User.class));
    }


}
