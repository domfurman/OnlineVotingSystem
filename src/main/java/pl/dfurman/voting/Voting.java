package pl.dfurman.voting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "votings")
public class Voting {
    @Id
    private UUID voteUUID;
    @Column(name = "vote_name")
    private String voteName;
    @Column(name = "votes_for")
    private Integer votesFor;
    @Column(name = "votes_against")
    private Integer votesAgainst;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "validity_date")
    private LocalDate validityDate;

    public Voting(UUID voteUUID, String voteName, Integer votesFor, Integer votesAgainst, LocalDate creationDate, LocalDate validityDate) {
        this.voteUUID = voteUUID;
        this.voteName = voteName;
        this.votesFor = 0;
        this.votesAgainst = 0;
        this.creationDate = creationDate;
        this.validityDate = validityDate;
    }

    public Voting() {
    }

    public UUID getVoteUUID() {
        return voteUUID;
    }

    public String getVoteName() {
        return voteName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(LocalDate validityDate) {
        this.validityDate = validityDate;
    }

}
