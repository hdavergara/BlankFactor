package co.com.pruebatecnica.stepsdefinitions.step_fravega;

import co.com.pruebatecnica.controllers.fravega.MainController;
import co.com.pruebatecnica.generalactions.WebAction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepTestFravega {

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

    @Given("^Que estamos en la pagina principal Fravega$")
    public void queEstamosEnLaPaginaPrincipalFravega() {
        mainController = new MainController();
        mainController.startBrowser();
        mainController.homeFravega();
    }

    @When("^Busque el articulo Heladera$")
    public void busqueElArticuloHeladera() {
        mainController.escribirArticuloBuscar("Heladeras");
    }

    @And("^Aplique los filtros Heladeras$")
    public void apliqueLosFiltrosHeladeras() {
        mainController.filtrarHeladeras();
    }

    @And("^Filtre por marca$")
    public void filtrePorMarca() {
        mainController.filtrarMarca();
    }

    @Then("^Se muestran los articulos filtrados y se hacen validaciones$")
    public void seMuestranLosArticulosFiltradosYSeHacenValidaciones() {
        mainController.validaciones();
    }
}
