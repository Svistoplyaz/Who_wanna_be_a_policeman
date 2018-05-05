package me.svistoplyas.graphics;

import me.svistoplyas.Answer;
import me.svistoplyas.PolicemanGame;
import me.svistoplyas.Question;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

//J means Java, P means Police:)
public class PFrame extends JFrame {
    private PolicemanGame game;
    private Question curQuestion;
    private JLabel qLabel;
    private JLabel levelLabel;
    private ArrayList<PButton> buttons = new ArrayList<>();
    //You can ask higher rank policeman for help, he will tell you right answer with 75% chance
    private JButton askHigher;
    //You can give bribe for a question, you will get right answer with 90% chance, or with 10% chance you loose
    private JButton bribe;

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

        try {
            askHigher = new JButton(new ImageIcon(ImageIO.read(PFrame.class.getResourceAsStream("/higher.png"))));
            askHigher.setBounds(395, 20, 40, 43);

            askHigher.addActionListener(e -> {
                Random r = new Random();
                int chance = r.nextInt(100);
                if (chance < 75)
                    JOptionPane.showMessageDialog(this, curQuestion.getAnswers().get(curQuestion.getRightAnswer()).getValue());
                else
                    JOptionPane.showMessageDialog(this, curQuestion.getAnswers().get(r.nextInt(4)).getValue());
            });

            add(askHigher);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            bribe = new JButton(new ImageIcon(ImageIO.read(PFrame.class.getResourceAsStream("/money.png"))));
            bribe.setBounds(395, 70, 40, 43);

            bribe.addActionListener(e -> {
                Random r = new Random();
                int chance = r.nextInt(100);
                if (chance < 90){
                    Answer answer = curQuestion.getAnswers().get(curQuestion.getRightAnswer());
                    for(PButton button : buttons)
                        button.setAnswer(answer);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Вас ловят за руку и садят в тюрьму " +
                            "за мошенничество, чего вы ожидали начиная карьеру милиционера с коррупции?");
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            });

            add(bribe);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

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
