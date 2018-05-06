import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PolicemanGame {
    private File file;
    public Question[] questions;
    static int questionLimit = 10;

    public PolicemanGame() {

    }

    public void load(String s) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(s));

        int len = Integer.parseInt(in.readLine());
        questions = new Question[len];

        String[] str;
        for (int i = 0; i < len; i++) {
            str = in.readLine().split(" ");

            for(int j = 1 ; j < str.length - 1; j++){
                str[0] += " " + str[j];
            }

            questions[i] = new Question(i, str[0], Integer.parseInt(str[str.length - 1]));

            for (int j = 0; j < Question.answerLimit; j++)
                questions[i].addAnswer(new Answer(j, in.readLine()));

        }
    }
}
