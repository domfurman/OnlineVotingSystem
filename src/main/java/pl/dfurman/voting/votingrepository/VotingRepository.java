package pl.dfurman.voting.votingrepository;

import pl.dfurman.voting.Voting;

import java.util.List;
import java.util.UUID;

//@Repository
public interface VotingRepository {

    List<Voting> findAll();

    int saveVoting(Voting voting);

    int deleteByUUID(UUID uuid);

    boolean existsByUUID(UUID uuid);

}
