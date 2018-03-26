package me.svistoplyas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    @Test
    @DisplayName("Question initalisation")
    void initTest(){
        Question q = new Question(2);
        assertEquals(2, q.index);
    }

    @Test
    @DisplayName("Question index getter")
    void getIndex() {
        Question q = new Question(2);
        assertEquals(2, q.getIndex());
    }

    @Test
    @DisplayName("Question inde setter")
    void setIndex() {
        Question q = new Question(2);
        q.setIndex(5);
        assertEquals(5, q.index);
    }
}