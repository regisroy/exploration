package zenika.jbehave.calculator;

import zenika.jbehave.util.StepsDefinition;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@StepsDefinition
public class CalculatriceSteps {

    @BeforeScenario
    public void inializeScenario() {
        CalculatriceContext.initialize();
    }

    @AfterScenario
    public void disposeScenario() {
        CalculatriceContext.dispose();
    }

    @Given("a variable $variable with value $value")
    public void defineNamedVariableWithValue(String variable, int value) {
        CalculatriceContext.calculator().defineVariable(variable, value);
    }

    @When("I add $value to $variable")
    public void addValueToVariable(@Named("variable") String variable,
                                   @Named("value") String value) {
        try {
            if (value.matches("\\d+")) {
                CalculatriceContext.calculator().addToVariable(variable, Integer.parseInt(value));
            } else {
                CalculatriceContext.calculator().addToVariable(variable, value);
            }
        } catch (Exception e) {
            CalculatriceContext.context().setLastError(e);
        }
    }

    @Then("$variable should equal to $expected")
    public void assertVariableEqualTo(String variable, int expectedValue) {
        MatcherAssert.assertThat(CalculatriceContext.calculator().getVariableValue(variable), equalTo(expectedValue));
    }

    @Then("the calculator should display the message '$errorMessage'")
    public void assertErrorMessageIsDisplayed(String errorMessage) {
        Exception lastError = CalculatriceContext.context().getLastError();
        assertThat("Not in error situtation", lastError, notNullValue());
        assertThat("Wrong error message", lastError.getMessage(), equalTo(errorMessage));
    }

    @Then("the calculator should not be in error")
    public void assertNoErrorMessageIsDisplayed() {
        Exception lastError = CalculatriceContext.context().getLastError();
        assertThat(lastError, nullValue());
    }
}
