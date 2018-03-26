package me.svistoplyas;

public class Question {
    int index;
    String value;

    Question(int i, String _value){
        setIndex(i);
        setValue(_value);
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
