package me.svistoplyas.graphics;

import me.svistoplyas.Answer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PButtonTest {
    @Test
    @DisplayName("PButton initialization test")
    void initTest() {
        new PButton(new Answer(1, ""));
    }

    @Test
    @DisplayName("PButton text equals answers value")
    void textTest() {
        Answer ans = new Answer(1, "Test");
        PButton pButton = new PButton(ans);
        assertEquals(pButton.getText(), "<html>" + ans.getValue());
    }
}