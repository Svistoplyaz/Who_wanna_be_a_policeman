package me.svistoplyas;

import java.util.Random;

/**
 * Class for answer of this game,
 */
public class Answer {
    private int num;
    private String value;

    Answer(int n, String _value){
        if(n < 0)
            throw new IndexOutOfBoundsException("Negative number");

        if(n > 3)
            throw new IndexOutOfBoundsException("Number is too big");
        num = n;

        value = _value;
    }

    public int getNum(){
        return num;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
