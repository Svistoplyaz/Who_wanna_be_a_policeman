package me.svistoplyas;

import java.util.Random;

/**
 * Class for answer of this game,
 */
public class Answer {
    int num;

    Answer(int n){
        if(n < 0)
            throw new IndexOutOfBoundsException("Negative number");

        if(n > 3)
            throw new IndexOutOfBoundsException("Number is too big");
        num = n;
    }

    public int getNum(){
        return new Random().nextInt();
    }
}
