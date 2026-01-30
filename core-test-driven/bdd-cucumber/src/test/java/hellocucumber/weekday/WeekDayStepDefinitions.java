package hellocucumber.weekday;

import com.example.main.FridayChecker;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WeekDayStepDefinitions {

    private String today;
    private String actualAnswer;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    // TODO. 补充另外一个Given测试的前提条件
    @Given("today is Friday")
    public void today_is_Friday() {
        today = "Friday";
    }

    // TODO. 通过Examples传递多个测试值
    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }


    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = FridayChecker.isFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
