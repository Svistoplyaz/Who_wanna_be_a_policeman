import java.io.BufferedReader;
import java.io.FileReader;

public class PolicemanGame {
    static int questionLimit = 10;
    Question[] questions;
    private int curQuestion = 0;
    private PFrame frame;
    private String[] levels = new String[]{"Рядовой", "Ефрейтор", "Сержант", "Старшина", "Прапорщик", "Лейтенант",
            "Майор", "Полковник", "Генерал", "Маршал", "Министр обороны"};

    public PolicemanGame() {
        try {
            load("set1.in");
            frame = new PFrame(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public Question[] getQuestions() {
        return questions;
    }

    public Question getCurrentQuestion() {
        if (curQuestion > questions.length - 1)
            return null;

        return questions[curQuestion];
    }

    public void nextQuestion(){
        curQuestion++;
    }

    public Question getNextQuestion(){
        nextQuestion();
        return getCurrentQuestion();
    }

    public String getLevelName() {
        return levels[curQuestion % levels.length] + ", количество опыта: " + curQuestion / levels.length;
    }

    public String getLevelName(int lev) {
        return levels[lev % levels.length] + ", количество опыта: " + lev / levels.length;
    }
}
