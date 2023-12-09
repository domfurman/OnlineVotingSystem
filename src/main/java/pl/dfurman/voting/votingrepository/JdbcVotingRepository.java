package pl.dfurman.voting.votingrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dfurman.voting.Voting;

import java.util.List;
import java.util.UUID;

@Repository
public class JdbcVotingRepository  implements VotingRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Voting> findAll() {
        return jdbcTemplate.query("SELECT * FROM votings",
                BeanPropertyRowMapper.newInstance(Voting.class));
    }

    @Override
    public int saveVoting(Voting voting) {
        jdbcTemplate.update("INSERT INTO votings (voteuuid, vote_name, votes_for, votes_against, creation_date, validity_date) VALUES (?, ?, ?, ?, ?, ?)",
                new Object[] {
                        voting.getVoteUUID(),
                        voting.getVoteName(),
                        voting.getVotesFor(),
                        voting.getVotesAgainst(),
                        voting.getCreationDate(),
                        voting.getValidityDate()
                }
        );
        return 200;
    }

    @Override
    public int deleteByUUID(UUID uuid) {
        if (existsByUUID(uuid)) {
            jdbcTemplate.update("DELETE FROM votings WHERE voteuuid= ?", uuid);
        }
        return 200;
    }

    @Override
    public boolean existsByUUID(UUID uuid) {
        try {
            Voting votingByUUID = jdbcTemplate.queryForObject("SELECT * FROM votings WHERE voteuuid= ?",
                    BeanPropertyRowMapper.newInstance(Voting.class), uuid);
            return true;
        } catch (IncorrectResultSizeDataAccessException e) {
            return false;
        }
    }

    @Override
    public Voting findByUUID(UUID uuid) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM votings WHERE voteuuid= ?",
                    BeanPropertyRowMapper.newInstance(Voting.class), uuid);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Voting findByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM votings WHERE vote_name= ?",
                    BeanPropertyRowMapper.newInstance(Voting.class), name);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int updateVotingName(Voting voting) {
        Voting votingToUpdate = findByUUID(voting.getVoteUUID());

        return jdbcTemplate.update("UPDATE votings SET vote_name= ? WHERE voteuuid= ?",
                new Object[]{ voting.getVoteName(), voting.getVoteUUID() });
    }

    @Override
    public int updateVotingValidityDate(Voting voting) {
        Voting votingToUpdate = findByUUID(voting.getVoteUUID());

        return jdbcTemplate.update("UPDATE votings SET validity_date= ? WHERE voteuuid= ?",
                new Object[]{ voting.getValidityDate(), voting.getVoteUUID() });
    }


}
