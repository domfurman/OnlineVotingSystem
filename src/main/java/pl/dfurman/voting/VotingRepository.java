package pl.dfurman.voting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VotingRepository extends JpaRepository<Voting, UUID> {

}
