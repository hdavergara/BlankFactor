package co.com.pruebatecnica.pages;

import co.com.pruebatecnica.exceptions.WebActionsException;
import org.apache.velocity.runtime.directive.Parse;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static co.com.pruebatecnica.stepsdefinitions.step_fravega.StepTestFravega.webAction;

public class PageFravega {

    public PageFravega() {
    }

    private int DEFAULT_TIME = 60;

    @FindBy(how = How.XPATH, using = "//*[@id='__next']//input[@class='InputBar__SearchInput-t6v2m1-1 iJaFAt']")
    private WebElement inputBuscarProductos;

    @FindBy(how = How.XPATH, using = "//*[@id='__next']//button[@class='InputBar__SearchButton-t6v2m1-2 jRChuZ']")
    private WebElement btnBuscarProductos;

    @FindBy(how = How.XPATH, using = "//a[@href='/l/?categorias=heladeras-freezers-y-cavas%2Fheladeras&keyword=heladeras']/h4")
    private WebElement lnkHeladeras;

    @FindBy(how = How.XPATH, using = "//*[@class='styled__Toggle-c638c2-2 fHtnBi']//label[contains(text(),'Patrick')]")
    private WebElement chkMarca;

    @FindBy(how = How.XPATH, using = "//*[@class='styled__Toggle-c638c2-2 fHtnBi']//label[contains(text(),'Patrick')]/span")
    private WebElement lblCantidadMarca;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Heladeras')]")
    private WebElement lblHeladeras;

    @FindBy(how = How.XPATH, using = "//button[@class='GeolocalizationDesktop__Button-wgxe4i-14 dVYNNn']")
    private WebElement btnCloseModal;

    @FindBy(how = How.XPATH, using = "//*[@name='itemsGrid']/li")
    private List<WebElement> gridResultados;

    @FindBy(how = How.XPATH, using = "//*[@name='breadcrumb']/ul/li")
    private List<WebElement> breadCrumb;


    public boolean verificarPagina() throws WebActionsException {
        if (btnCloseModal.isDisplayed())
            webAction.click(btnCloseModal, DEFAULT_TIME);
        return webAction.isVisible(btnBuscarProductos, DEFAULT_TIME);
    }

    public void articuloBuscar(String articulo) throws WebActionsException {
        webAction.sendText(inputBuscarProductos, articulo, DEFAULT_TIME);
    }

    public void clicBtnBuscar() throws WebActionsException {
        webAction.click(btnBuscarProductos, DEFAULT_TIME);
    }

    public void clicHeladeras() throws WebActionsException {
        webAction.click(lnkHeladeras, DEFAULT_TIME);
    }

    public void seleccionarMarca() throws WebActionsException {
        webAction.click(chkMarca, DEFAULT_TIME);
    }

    public boolean verificarFiltroHeladeras() {
        return webAction.isVisible(lblHeladeras, DEFAULT_TIME);
    }

    public void validarTitulos() {
        for (WebElement e : gridResultados) {
            Assert.assertTrue("Los titiulos no contienen la marca", e.getText().contains("Patrick"));
        }
    }

    public void validarCantidadResultados(){
        String cantidad = lblCantidadMarca.getText().substring(1,3);
        Assert.assertTrue("La cantidad no coincide ", gridResultados.size()== Integer.parseInt(cantidad));
    }

    public void validarBreadCrumb(){
        boolean existeHeladeras = false;
        for (int i=0; i< breadCrumb.size();i++ ) {
            if (breadCrumb.get(i).getText().equals("Heladeras"))
                existeHeladeras = true;
        }
        Assert.assertTrue("No se encontro Heladera",existeHeladeras);
    }

}
