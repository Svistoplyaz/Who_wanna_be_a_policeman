import cucumber.api.PendingException;
import cucumber.api.java.gl.E;
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
            while(s.length() < 500)
                s.append("1");

            Assertions.assertThrows(RuntimeException.class, () -> curQuestion.setValue(s.toString()));
        });
    }
}
