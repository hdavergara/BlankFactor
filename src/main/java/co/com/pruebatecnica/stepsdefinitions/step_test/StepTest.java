package co.com.pruebatecnica.stepsdefinitions.step_test;

import co.com.pruebatecnica.controllers.webpage.MainController;
import co.com.pruebatecnica.generalactions.WebAction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepTest {

    public static WebAction webAction;
    private MainController mainController;

    @Before
    public void setUp() {
        webAction = new WebAction("Logs", "Fravega");
    }

    @After
    public void tearDown() {
        webAction.closeBrowser();
    }

    @Given("^We are on the BlankFactor main page$")
    public void weAreOnTheBlankFactorMainPage() {
        mainController = new MainController();
        mainController.startBrowser();
        mainController.homeBlankFactor();
    }

    @When("^We look for a given blog$")
    public void weLookForAgivenBlog() {
        mainController.loginAndSearchBlog();
    }

    @Then("^We validate that the page shown is the correct one$")
    public void weValidateThatThePageShownIsTheCorrectOne() throws InterruptedException {
        mainController.validations();
        mainController.suscribe();
        mainController.countTitles();
    }
}
