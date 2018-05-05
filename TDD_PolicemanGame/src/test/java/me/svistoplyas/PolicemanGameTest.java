package me.svistoplyas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;


class PolicemanGameTest {
    @Test
    public void mainClassInitialisation(){
        new PolicemanGame();
    }

    @Test
    void readSet() throws Exception{
        File file = new File("set2.in");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("2\n" +
                "Вопрос1 2\n" +
                "йОтвет1\n" +
                "цОтвет2\n" +
                "уОтвет3\n" +
                "кОтвет4\n" +
                "Вопрос2 3\n" +
                "еОтвет1\n" +
                "нОтвет2\n" +
                "гОтвет3\n" +
                "шОтвет4\n");
        out.close();

        PolicemanGame game = new PolicemanGame();
        game.readSet(file);

        Question[] questions = game.getQuestions();

        assertEquals("Вопрос1", questions[0].getValue());
        assertTrue(questions[0].choose(2));

        assertEquals("Вопрос2", questions[1].getValue());
        assertTrue(questions[1].choose(3));
    }

    @Test
    @DisplayName("Is there infinite levels")
    void getLevelName() {
        PolicemanGame pGame = new PolicemanGame();
        for(int i = 0 ; i < 50; i++)
            System.out.println(pGame.getLevelName(i));
    }

}