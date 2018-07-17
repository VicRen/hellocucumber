package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        if (today.equals("星期五") || today.equals("周五")) {
            return "是的";
        }
        return "不是";
    }
}

public class Stepdefs {
    private String today;
    private String actualAnswer;

    @Given("^今天是 \"([^\"]*)\"$")
    public void today_is(String someday) throws Exception {
        this.today = someday;
    }

    @When("^我问今天是星期五了么$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^我应该被告知 \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
