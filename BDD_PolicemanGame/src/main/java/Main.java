import javax.swing.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(getLookAndFeel());
        Locale.setDefault(Locale.ENGLISH);

        new PolicemanGame();
    }

    public static String getLookAndFeel(){
        return UIManager.getSystemLookAndFeelClassName();
    }
}
