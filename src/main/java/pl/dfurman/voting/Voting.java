package pl.dfurman.voting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

public class Voting {
    private UUID voteUUID;
    private String voteName;
    private Integer votesFor;
    private Integer votesAgainst;
    private LocalDate creationDate;
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

    public void setVoteUUID(UUID voteUUID) {
        this.voteUUID = voteUUID;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public Integer getVotesFor() {
        return votesFor;
    }

    public void setVotesFor(Integer votesFor) {
        this.votesFor = votesFor;
    }

    public Integer getVotesAgainst() {
        return votesAgainst;
    }

    public void setVotesAgainst(Integer votesAgainst) {
        this.votesAgainst = votesAgainst;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(LocalDate validityDate) {
        this.validityDate = validityDate;
    }

    public String getUUIDStringRepresentation() {
        return getVoteUUID().toString();
    }
}
