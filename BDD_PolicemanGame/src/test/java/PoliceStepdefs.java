import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class PoliceStepdefs implements En {
    private PolicemanGame policemanGame;

    public PoliceStepdefs() {
        Given("^I have my policeman game$", () -> {
            this.policemanGame = new PolicemanGame();
        });
    }
}
