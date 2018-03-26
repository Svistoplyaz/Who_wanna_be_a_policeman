package me.svistoplyas;

import java.io.*;

public class PolicemanGame {
    static int questionLimit = 10;
    Question[] questions;

    void readSet(File file) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(file));

        int len = Integer.parseInt(in.readLine());
        questions = new Question[len];

        String[] str;
        for(int i = 0; i < len; i++){
            str = in.readLine().split(" ");
            questions[i] = new Question(i, str[0], Integer.parseInt(str[1]));

            for(int j = 0; j < Question.answerLimit; j++)
                questions[i].addAnswer(new Answer(j, in.readLine()));
        }
    }

    public Question[] getQuestions() {
        return questions;
    }
}
