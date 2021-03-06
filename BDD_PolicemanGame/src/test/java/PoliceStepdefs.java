import cucumber.api.java8.En;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class PoliceStepdefs implements En {
    private PolicemanGame policemanGame;
    private Question curQuestion;
    private Answer curAnswer;

    public PoliceStepdefs() {
        Given("^I have my policeman game$", () -> {
            this.policemanGame = new PolicemanGame();
        });
        When("^I load my set of question from this \"([^\"]*)\" file$", (String arg0) -> {
            try {
                policemanGame.load("D:\\WorkPlaces\\IdeaProjects\\Verify\\Who_wanna_be_a_policeman\\BDD_PolicemanGame\\" + arg0);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Then("^number of questions must be more then (\\d+)$", (Integer arg0) -> {
            if(policemanGame.questions.length <= arg0)
                Assertions.fail("Less than " + (arg0+1) + "questions");
        });
        And("^questions have (\\d+) answers$", (Integer arg0) -> {
            int len = policemanGame.questions.length;
            for(int i = 0; i < len; i++) {
                if (policemanGame.questions[i].answers.size() != arg0)
                    Assertions.fail("Question has not " + arg0 + " answers");
            }
        });
        And("^every question has right answer$", () -> {
            int len = policemanGame.questions.length;
            for(int i = 0; i < len; i++) {
                int answer = policemanGame.questions[i].rightAnswer;
                if (answer != 0 && answer != 1 && answer != 2 && answer != 3){
                    Assertions.fail("Question has invalid right answer");
                }
            }
        });
        And("^you see question number \"([^\"]*)\"$", (String arg0) -> {
            curQuestion = policemanGame.questions[Integer.parseInt(arg0)];
        });
        And("^you choose answer number \"([^\"]*)\"$", (String arg0) -> {
            curAnswer = curQuestion.answers.get(Integer.parseInt(arg0));
        });
        Then("^result will be this \"([^\"]*)\"$", (String arg0) -> {
            Assert.assertEquals(curQuestion.rightAnswer == curAnswer.getNum(), Boolean.parseBoolean(arg0));
        });
        Then("^Question length must be less then (\\d+)$", (Integer arg0) -> {
            curQuestion = policemanGame.questions[0];

            StringBuilder s = new StringBuilder();
            while(s.length() <= arg0)
                s.append("1");

            Assertions.assertThrows(RuntimeException.class, () -> curQuestion.setValue(s.toString()));
        });
        And("^Answer length must be less then (\\d+)$", (Integer arg0) -> {
            curAnswer = policemanGame.questions[0].answers.get(0);

            StringBuilder s = new StringBuilder();
            while(s.length() <= arg0)
                s.append("1");

            Assertions.assertThrows(RuntimeException.class, () -> curAnswer.setValue(s.toString()));
        });
        And("^any existing question must not let add more answer to it$", () -> {
            curQuestion = policemanGame.questions[0];

            Assertions.assertThrows(RuntimeException.class, () -> curQuestion.addAnswer(new Answer(0, "")));
        });
        Given("^I have empty quesion$", () -> {
            curQuestion = new Question(0 , "", 0);
        });
        When("^I creating answer with number \"([^\"]*)\"$", (String arg0) -> {
            curAnswer = new Answer(Integer.parseInt(arg0), "");
        });
        Then("^I expecting result \"([^\"]*)\"$", (String arg0) -> {
            if(Boolean.parseBoolean(arg0)){
                curQuestion.addAnswer(curAnswer);
            }else{
                curQuestion.addAnswer(curAnswer);
                Assertions.assertThrows(RuntimeException.class, () -> curQuestion.addAnswer(curAnswer));
            }
        });
    }
}
