package me.svistoplyas.graphics;


import me.svistoplyas.Answer;

import javax.swing.*;

//J means Java, P means Police:)
public class PButton extends JButton{
    Answer answer;

    PButton(Answer answer){
        setAnswer(answer);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
