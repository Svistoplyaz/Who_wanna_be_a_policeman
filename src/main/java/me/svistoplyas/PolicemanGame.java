package me.svistoplyas;

import me.svistoplyas.graphics.PFrame;

import java.io.*;

public class PolicemanGame {
    static int questionLimit = 10;
    private Question[] questions;
    private int curQuestion = 0;
    private PFrame frame;

    public PolicemanGame() {
        try {
            readSet(new File("set1.in"));
            frame = new PFrame(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void readSet(File file) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(file));

        int len = Integer.parseInt(in.readLine());
        questions = new Question[len];

        String[] str;
        for (int i = 0; i < len; i++) {
            str = in.readLine().split(" ");
            questions[i] = new Question(i, str[0], Integer.parseInt(str[1]));

            for (int j = 0; j < Question.answerLimit; j++)
                questions[i].addAnswer(new Answer(j, in.readLine()));
        }
    }

    public Question[] getQuestions() {
        return questions;
    }

    public Question getNextQuestion() {
        if(curQuestion >= questions.length - 1)
            return null;
        curQuestion += 1;
        return questions[curQuestion - 1];
    }
}
