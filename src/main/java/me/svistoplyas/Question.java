package me.svistoplyas;

import java.util.ArrayList;

public class Question {
    int index;
    String value;
    ArrayList<Answer> answers = new ArrayList<>();

    Question(int i, String _value){
        setIndex(i);
        setValue(_value);
    }

    public void addAnswer(Answer answer){
        if (!hasNum(answer.getNum()))
            answers.add(answer);
        else
            throw new RuntimeException("Already has this num");
    }

    private boolean hasNum(int num){
        for(Answer answer : answers)
            if(answer.getNum() == num)
                return true;

        return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if(index > PolicemanGame.questionLimit)
            throw new IndexOutOfBoundsException("Question index bigger than limit");
        else
            this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if(value.length() > 400)
            throw new RuntimeException();
        else
            this.value = value;
    }
}
