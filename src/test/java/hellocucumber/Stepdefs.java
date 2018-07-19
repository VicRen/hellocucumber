package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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

    static String isItBlackFriday(String weekday, int date) {
        if (isItFriday(weekday).equals("是的") && date == 13) {
            return "是的";
        }
        return "不是";
    }
}

public class Stepdefs {
    private String today;
    private int date;
    private String actualAnswer;

    @Given("^今天是 \"([^\"]*)\"$")
    public void today_is(String someday) {
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

    @Given("^今天是星期五$")
    public void 我问今天是星期五() {
       this.today = "星期五";
    }

    @And("^今天是(\\d+)日$")
    public void 今天是日(int date) {
        this.date = date;
    }

    @When("^我提问今天是黑色星期五么？$")
    public void 我提问今天是黑色星期五么() {
        this.actualAnswer = IsItFriday.isItBlackFriday(today, date);
    }

    @Then("^我被告知 \"([^\"]*)\"$")
    public void 我被告知是的(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
