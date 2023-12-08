package pl.dfurman.voting.votingrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dfurman.user.User;
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
        return 0;
    }

    @Override
    public boolean existsByUUID(UUID uuid) {
        return false;
    }
}
