package pl.dfurman.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Service
public class VotingService {
    private final VotingRepository votingRepository;

    @Autowired
    public VotingService(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    public List<Voting> getVotings() {
        return votingRepository.findAll();
    }

    public void addNewVoting(Voting voting) {
        votingRepository.save(voting);
    }

//    public void addNewStaticVoting(Voting voting) {
//        votingRepository.save(
//                new Voting(
//                        UUID.randomUUID(),
//                        "Election1",
//                        0,
//                        0,
//                        LocalDate.of(2011, Month.FEBRUARY, 22),
//                        LocalDate.of(2025, Month.APRIL, 16)
//                        )
//        );
//    }
}
