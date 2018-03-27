package me.svistoplyas.graphics;

import me.svistoplyas.PolicemanGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PFrameTest {
    @Test
    @DisplayName("Initalization test")
    void initTest(){
        new PFrame(loadGame());
    }

    private PolicemanGame loadGame(){
        PolicemanGame ans = new PolicemanGame();
        return ans;
    }
}