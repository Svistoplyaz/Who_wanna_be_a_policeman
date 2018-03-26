package me.svistoplyas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    @DisplayName("Initialisation")
    public void AnswerInitialisation(){
        new Answer(0, "");
    }


    @ParameterizedTest
    @MethodSource("badNumbers")
    @DisplayName("Number check")
    public void badNumberTest(int num){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new Answer(num, ""));
    }

    private static Stream<Arguments> badNumbers() {
        return Stream.of(
                           Arguments.of(-1),
                          Arguments.of(4)
        );
    }


    @ParameterizedTest
    @MethodSource("goodNumbers")
    @DisplayName("Good numbers check")
    public void goodNumberTest(int num){
        new Answer(num, "");
    }

    private static Stream<Arguments> goodNumbers() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
        );
    }

    @ParameterizedTest
    @MethodSource("goodNumbers")
    @DisplayName("Number getter")
    void getNum(int num) {
        Answer answer = new Answer(num, "");
        assertEquals(answer.getNum(),num);
    }

    @Test
    void getValue() {
        Answer answer = new Answer(0,"Штраф 100 рублей");
        assertEquals("Штраф 100 рублей", answer.getValue());
    }

    @Test
    void setValue() {
        Answer answer = new Answer(0,"Штраф 100 рублей");
        answer.setValue("Штраф 1000 рублей");
        assertEquals("Штраф 1000 рублей", answer.getValue());
    }

    @Test
    @DisplayName("Big value insert in constructor")
    void tooLongValue(){
        StringBuilder s = new StringBuilder();
        while(s.length() < 500)
            s.append("1");
        Assertions.assertThrows(RuntimeException.class, ()-> new Answer(0,s.toString()));
    }

    @Test
    @DisplayName("Big value set")
    void tooLongValue1(){
        StringBuilder s = new StringBuilder();
        while(s.length() < 500)
            s.append("1");
        Assertions.assertThrows(RuntimeException.class, ()-> new Answer(0,"").setValue(s.toString()));

    }
}