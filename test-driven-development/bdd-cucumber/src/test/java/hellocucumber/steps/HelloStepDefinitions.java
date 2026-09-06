package hellocucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

// TODO. 在Cucumber / Gherkin里只有特定关键字才会被当成步骤执行
// Given / When / Then / And / But
public class HelloStepDefinitions {

    private int value;

    // TODO. 获取传递的整形参数的值
    @Given("I have {int} input value")
    public void i_have_n_input_value(Integer base) {
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


    // TODO. 测试全流程Scenario逻辑判断
    @Given("the first value is {int}")
    public void the_first_value_is(Integer base) {
        value = base;
    }
    @When("double the first value")
    public void double_the_first_value() {
        value += value;
    }
    @When("plus {int}")
    public void plus(Integer newValue) {
        value += newValue;
    }
    @Then("the answer should be {int}")
    public void the_answer_should_be(Integer answer) {
        assertThat(value).isEqualTo(answer);
    }
}
