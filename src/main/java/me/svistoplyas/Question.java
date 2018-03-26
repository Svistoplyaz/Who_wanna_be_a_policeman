package me.svistoplyas;

public class Question {
    int index;

    Question(int i){
        setIndex(i);
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
}
