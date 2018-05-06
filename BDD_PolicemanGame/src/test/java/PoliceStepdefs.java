import cucumber.api.PendingException;
import cucumber.api.java.gl.E;
import cucumber.api.java8.En;

public class PoliceStepdefs implements En {
    private PolicemanGame policemanGame;

    public PoliceStepdefs() {
        Given("^I have my policeman game$", () -> {
            this.policemanGame = new PolicemanGame();
        });
        And("^I load my set of question from this \"([^\"]*)\" file$", (String arg0) -> {
            try {
                policemanGame.load(arg0);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
