package me.svistoplyas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

class MainTest {
    @Test
    @EnabledOnOs(MAC)
    @DisplayName("Mac look and feel")
    void getLookAndFeelMac() {
        assertEquals("javax.swing.plaf.mac.MacLookAndFeel", Main.getLookAndFeel());
    }

    @Test
    @EnabledOnOs(LINUX)
    @DisplayName("Linux look and feel")
    void getLookAndFeelLinux() {
        assertEquals("javax.swing.plaf.metal.MetalLookAndFeel", Main.getLookAndFeel());
    }


    @Test
    @EnabledOnOs(WINDOWS)
    @DisplayName("Windows look and feel")
    void getLookAndFeelWindows() {
        assertEquals("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", Main.getLookAndFeel());
    }
}