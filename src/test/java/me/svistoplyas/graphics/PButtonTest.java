package me.svistoplyas.graphics;

import me.svistoplyas.Answer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PButtonTest {
    @Test
    @DisplayName("PButton initalization test")
    void initTest() {
        new PButton(new Answer(1, ""));
    }
}