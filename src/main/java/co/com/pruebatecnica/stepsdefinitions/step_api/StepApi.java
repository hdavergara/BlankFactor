package co.com.pruebatecnica.stepsdefinitions.step_api;

import co.com.pruebatecnica.controllers.api.ControllerApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepApi {

    private String endPoint;
    private String path;
    private ControllerApi controllerApi;
    private String respuesta;
    private String nombreCerveceria;

    @Given("^Que tenemos la api de cervecerias$")
    public void queTenemosLaApiDeCervecerias() {
        controllerApi = new ControllerApi();
        endPoint = "https://api.openbrewerydb.org";
        path = "/breweries";
    }

    @When("^Ejecutamos el servicio para buscar la cerverceria (.*?)$")
    public void ejecutamosElServicioParaBuscarLaCerverceria(String cerveceria) {
        nombreCerveceria = cerveceria;
        respuesta = controllerApi.consultarApi(endPoint, path.concat("?name").concat(cerveceria));
    }

    @Then("^Obtenemos la respuesta del parametro dado$")
    public void obtenemosLaRespuestaDelParametroDado() {
        controllerApi.validarBusquedaCerveceria(respuesta, nombreCerveceria);
    }

    @Then("^Obtenemos las cervecerias filtradas por el nombre buscado$")
    public void obtenemosLasCerveceriasFiltradasPorElNombreBuscado(){

    }
}
