package pl.dfurman.voter;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VoterService {
    private final VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @GetMapping
    public List<Voter> getVoters() {
        return voterRepository.findAll();
    }

    public void addNewVoter(Voter voter) {
        Optional<Voter> voterOptional = voterRepository.findByEmail(voter.getEmail());
        if (voterOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        voterRepository.save(voter);
    }

    public void deleteVoter(Long voterId) {
        boolean exists = voterRepository.existsById(voterId);
        if (!exists) {
            throw new IllegalStateException("Voter with id " + voterId + " does not exist");
        }
        voterRepository.deleteById(voterId);
    }

    @Transactional
    public void updateVoter(Long voterId, String firstName, String email) {
        Voter voter = voterRepository.findById(voterId).orElseThrow(
                () -> new IllegalStateException("voter with id " + voterId + " not found")
        );
        if (firstName != null && !firstName.isEmpty() && !Objects.equals(voter.getFirstName(), firstName)) {
            voter.setFirstName(firstName);
        }
        if (email != null && !email.isEmpty() && !Objects.equals(voter.getEmail(), email)) {
            Optional<Voter> voterOptional = voterRepository.findByEmail(email);
            if (voterOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            voter.setEmail(email);
        }

    }
}
