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
        new Answer(0);
    }


    @ParameterizedTest
    @MethodSource("badNumbers")
    @DisplayName("Number check")
    public void numberTest(int num){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> new Answer(num));
    }

    private static Stream<Arguments> badNumbers() {
        return Stream.of(
                           Arguments.of(-1),
                          Arguments.of(4)
        );
    }
}