package me.svistoplyas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    @DisplayName("Initialisation")
    public void AnswerInitialisation(){
        new Answer(0);
    }


}