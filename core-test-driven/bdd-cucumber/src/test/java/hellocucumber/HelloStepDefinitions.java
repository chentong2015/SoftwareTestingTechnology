package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloStepDefinitions {

    private int value;

    // 获取传递的整形参数的值
    @Given("I have {int} input value")
    public void i_have_n_input_value(int base) {
        value = base;
    }

    @When("I ask to double it")
    public void i_ask_to_double_it() {
        value += value;
    }

    @Then("I should get {int}")
    public void i_should_get(Integer answer) {
        assertThat(value).isEqualTo(answer);
    }

}
