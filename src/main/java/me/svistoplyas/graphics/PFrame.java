package me.svistoplyas.graphics;

import me.svistoplyas.Answer;
import me.svistoplyas.PolicemanGame;
import me.svistoplyas.Question;

import javax.swing.*;
import java.util.ArrayList;

//J means Java, P means Police:)
public class PFrame extends JFrame{
    private PolicemanGame game;
    private Question curQuestion;
    private ArrayList<PButton> buttons = new ArrayList<>();

    public PFrame(PolicemanGame game){
        this.game = game;
        setLayout(null);
        this.setLocation(300,300);
        curQuestion = game.getNextQuestion();

        for(Answer answer : curQuestion.getAnswers()){
            addButton(new PButton(answer));
        }

        this.setSize(buttons.get(1).getWidth() + buttons.get(1).getX() + 30,
                buttons.get(buttons.size() - 1).getHeight() + buttons.get(buttons.size() - 1).getY() + 50);
        this.setVisible(true);
    }

    private void addButton(PButton button){
        int cur = buttons.size();
        button.setBounds(20 + (cur % 2) * 220, 200 + (cur/2) * 75, 200, 68);
        this.add(button);
        buttons.add(button);
    }

    public ArrayList<PButton> getButtons() {
        return buttons;
    }
}
