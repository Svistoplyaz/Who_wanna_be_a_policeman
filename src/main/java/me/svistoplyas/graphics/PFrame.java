package me.svistoplyas.graphics;

import me.svistoplyas.Answer;
import me.svistoplyas.PolicemanGame;
import me.svistoplyas.Question;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

//J means Java, P means Police:)
public class PFrame extends JFrame {
    private PolicemanGame game;
    private Question curQuestion;
    private JLabel qLabel;
    private JLabel levelLabel;
    private ArrayList<PButton> buttons = new ArrayList<>();

    public PFrame(PolicemanGame game) {
        setLayout(null);
        this.setLocation(300, 300);
        this.setTitle("Кто хочет быть миллиционером?");

        this.game = game;
        curQuestion = game.getCurrentQuestion();

        levelLabel = new JLabel(game.getLevelName());
        levelLabel.setBounds(20, 20, 300, 24);
        add(levelLabel);

        qLabel = new JLabel("<html>" + curQuestion.getValue());
        qLabel.setBounds(20, 60, 330, 200);
        add(qLabel);

        for (Answer answer : curQuestion.getAnswers()) {
            addButton(new PButton(answer));
        }

        this.setSize(buttons.get(1).getWidth() + buttons.get(1).getX() + 30,
                buttons.get(buttons.size() - 1).getHeight() + buttons.get(buttons.size() - 1).getY() + 50);
        this.setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addButton(PButton button) {
        int cur = buttons.size();
        button.setBounds(20 + (cur % 2) * 220, 200 + (cur / 2) * 75, 200, 68);
        this.add(button);

        button.addActionListener(e -> {
            if (clickButton(button)) {
                if (!askNextQuestion()) {
                    JOptionPane.showMessageDialog(this, "Вы прошли игру и достигли звания: " + game.getLevelName() + ", поздравляем!!!");
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Вы проиграли, не быть вам миллиционером");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });

        buttons.add(button);
    }

    boolean clickButton(PButton button) {
        int right = curQuestion.getRightAnswer();
        return button.getAnswer().getNum() == right;
    }

    public ArrayList<PButton> getButtons() {
        return buttons;
    }

    public JLabel getqLabel() {
        return qLabel;
    }

    public Question getCurQuestion() {
        return curQuestion;
    }

    public JLabel getLevelLabel() {
        return levelLabel;
    }

    public boolean askNextQuestion() {
        curQuestion = game.getNextQuestion();
        levelLabel.setText(game.getLevelName());

        if (curQuestion != null) {
            qLabel.setText("<html>" + curQuestion.getValue());

            int i = 0;
            for (Answer answer : curQuestion.getAnswers()) {
                buttons.get(i).setAnswer(answer);
                i++;
            }

            repaint();

            return true;
        } else
            return false;
    }
}
