package co.com.pruebatecnica.controllers.api;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class ControllerApi {

    public String consultarApi(String endPoint, String path) {
        RestAssured.baseURI = endPoint;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(path);
        return response.asString();
    }

    public void validarBusquedaCerveceria(String jsonRespuesta, String cerveceria) {
        boolean existeNombreCerveceria = false;
        int cantidadRegistros = JsonPath.read(jsonRespuesta, "$.length()");
        for (int i = 0; i < cantidadRegistros; i++) {
            String valorName = JsonPath.read(jsonRespuesta, "$.[" + i + "].name");
            if (valorName.equals(cerveceria))
                existeNombreCerveceria = true;
        }
        Assert.assertTrue("No se encontro la cerveceria " + cerveceria, existeNombreCerveceria);
    }

}
