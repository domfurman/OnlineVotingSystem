package pl.dfurman.OnlineVotingSystem;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    void firstTest() {
        assert true == true;
    }

    @Test
    void secondTest() {
        String s1 = "Welcome";
        String s2 = String.format("%s in my project!", s1);
        assert s2.equals("Welcome in my project!");
    }
}
