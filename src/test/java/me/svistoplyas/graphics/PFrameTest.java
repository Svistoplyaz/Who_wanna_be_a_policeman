package me.svistoplyas.graphics;

import me.svistoplyas.PolicemanGame;
import me.svistoplyas.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PFrameTest {
    @Test
    @DisplayName("Initialization test")
    void initTest() {
        new PFrame(loadGame());
    }

    @Test
    @DisplayName("Have created buttons")
    void buttonsCreated() {
        PolicemanGame game = loadGame();
        PFrame frame = new PFrame(game);
        assertTrue(frame.getButtons().size() != 0);
    }

    @Test
    @DisplayName("Have filled buttons")
    void buttonsFilledCorrect() {
        PolicemanGame game = loadGame();
        PFrame frame = new PFrame(game);

        HashSet<Integer> set = new HashSet<>();
        for(PButton button : frame.getButtons()){
            set.add(button.getAnswer().getNum());
        }

        assertTrue(set.size() == Question.answerLimit);
    }


    @Test
    @DisplayName("Have filled question label")
    void labelFilled() {
        PolicemanGame game = loadGame();
        PFrame frame = new PFrame(game);
        assertEquals("<html>"+frame.getCurQuestion().getValue(),frame.getqLabel().getText());
    }

    private PolicemanGame loadGame() {
        PolicemanGame ans = new PolicemanGame();
        return ans;
    }

}