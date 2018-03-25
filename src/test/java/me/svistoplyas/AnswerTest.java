package me.svistoplyas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    @DisplayName("Initialisation")
    public void AnswerInitialisation(){
        new Answer(0);
    }

    @Test
    @DisplayName("Negative number")
    public void numberTest1(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new Answer(-1));
    }

    @Test
    @DisplayName("Too big number")
    public void numberTest2(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new Answer(4));
    }
}