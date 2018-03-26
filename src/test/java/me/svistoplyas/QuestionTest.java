package me.svistoplyas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    @DisplayName("Question initalisation")
    void initTest(){
        Question q = new Question(2, "");
        assertEquals(2, q.index);
    }

    @Test
    @DisplayName("Question index getter")
    void getIndex() {
        Question q = new Question(2, "");
        assertEquals(2, q.getIndex());
    }

    @Test
    @DisplayName("Question index setter")
    void setIndex() {
        Question q = new Question(2, "");
        q.setIndex(5);
        assertEquals(5, q.index);
    }

    @Test
    @DisplayName("Question constructor index limit test")
    void indexLimit(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new Question(PolicemanGame.questionLimit+1, ""));
    }

    @Test
    @DisplayName("Question setter index limit test")
    void indexLimit1(){
        Question q = new Question(2, "");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> q.setIndex(PolicemanGame.questionLimit+1));
    }

    @Test
    @DisplayName("Question setter index lower than 0")
    void indexLimit2(){
        Question q = new Question(2, "");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> q.setIndex(-1));
    }

    @Test
    @DisplayName("Question value length limit")
    void valueLimit(){
        Question q = new Question(2, "");

        StringBuilder s = new StringBuilder();
        while(s.length() < 500)
            s.append("1");

        Assertions.assertThrows(RuntimeException.class, () -> q.setValue(s.toString()));
    }

    @Test
    @DisplayName("Answer number repeat test")
    void addAnswer() {
        Question q = new Question(1, "");
        q.addAnswer(new Answer(1, ""));
        Assertions.assertThrows(RuntimeException.class, () -> q.addAnswer(new Answer(1,"1")));
    }

    @Test
    @DisplayName("Answer list limit")
    void addAnswer1(){
        Question q = new Question(1, "");
        for(int i = 0; i < 3; i++)
            q.addAnswer(new Answer(i, ""));
        Assertions.assertThrows(RuntimeException.class, () -> q.addAnswer(new Answer(4,"1")));
    }
}