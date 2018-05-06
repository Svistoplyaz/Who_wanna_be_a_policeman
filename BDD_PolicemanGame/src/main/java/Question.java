import java.util.ArrayList;

public class Question {
    public static final int answerLimit = 4;

    int index;
    String value;
    ArrayList<Answer> answers = new ArrayList<>();
    int rightAnswer;

    Question(int i, String _value, int ans){
        setIndex(i);
        setValue(_value);
        setRightAnswer(ans);
    }

    public void addAnswer(Answer answer){
        if(answers.size() > answerLimit)
            throw new RuntimeException("Too many answers");
        else {
            if (!hasNum(answer.getNum()))
                answers.add(answer);
            else
                throw new RuntimeException("Already has this num");
        }
    }

    private boolean hasNum(int num){
        for(Answer answer : answers)
            if(answer.getNum() == num)
                return true;

        return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if(index > PolicemanGame.questionLimit)
            throw new IndexOutOfBoundsException("Question index bigger than limit");
        else if(index < 0)
            throw new IndexOutOfBoundsException("Question index lower than 0");
        else
            this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if(value.length() > 400)
            throw new RuntimeException();
        else
            this.value = value;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        if(rightAnswer > answerLimit)
            throw new IndexOutOfBoundsException("Right Answer index bigger than limit");
        else if(rightAnswer < 0)
            throw new IndexOutOfBoundsException("Right Answer index lower than 0");
        else
            this.rightAnswer = rightAnswer;
    }

    public ArrayList<Answer> getAnswers(){
        return answers;
    }

    public boolean choose(int i){
        return i == rightAnswer;
    }
}
