package pl.dfurman.voter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {

    @Query("SELECT v FROM Voter v WHERE v.email = ?1")
    Optional<Voter> findByEmail(String email);
}
