package co.com.pruebatecnica.controllers.webpage;

import co.com.pruebatecnica.exceptions.WebActionsException;
import co.com.pruebatecnica.helpers.Browser;
import co.com.pruebatecnica.helpers.Properties;
import co.com.pruebatecnica.logs.Log;
import co.com.pruebatecnica.pages.PageTest;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static co.com.pruebatecnica.stepsdefinitions.step_test.StepTest.webAction;

public class MainController {

    private Properties properties = new Properties();
    private PageTest pageTest;


    public void startBrowser() {

        try {
            webAction.startWebApp(configureBrowser(), properties.getFieldProperties("urlAplication"));
        } catch (Throwable e) {
            Log.LOGGER.error("Ocuarrio un error realizando una de las acciones de la prueba" + e);
            Assert.fail();
        }
    }

    public Browser configureBrowser() {
        Browser browserConfig = new Browser();
        browserConfig.setIncognito(true);
        browserConfig.setDriverVersion(properties.getFieldProperties("versionBrowser"));
        browserConfig.setBrowser(Browser.Browsers.CHROME);
        browserConfig.setMaximized(true);
        return browserConfig;
    }

    public void homeBlankFactor(){

        Log.LOGGER.info("Opening URL BlankFactor");
        pageTest = PageFactory.initElements(webAction.getDriver(),PageTest.class);
        try {
            Assert.assertTrue("We are not on the main page",pageTest.isPresentBtnLetsTalk());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginAndSearchBlog(){
        pageTest = PageFactory.initElements(webAction.getDriver(),PageTest.class);
        try {
            pageTest.HoverOverInsights();
            pageTest.clikBtnGoToBlog();
            pageTest.enterBlogWhyYourGateway();
        } catch (WebActionsException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validations() throws InterruptedException {
        pageTest = PageFactory.initElements(webAction.getDriver(),PageTest.class);
        Assert.assertTrue("The URL is not correct", pageTest.isCorrectUrl(properties.getFieldProperties("urlValidate")));
        Assert.assertTrue("Title with text What's a Java Design Pattern is not displayed", pageTest.isVisibleJavaDesignText());
    }

    public void suscribe(){
        pageTest = PageFactory.initElements(webAction.getDriver(),PageTest.class);
        try {
            pageTest.enterEmail();
            pageTest.clickSuscribe();
        } catch (WebActionsException e) {
            e.printStackTrace();
        }
    }

    public void countTitles(){
        pageTest = PageFactory.initElements(webAction.getDriver(),PageTest.class);
        try {
            pageTest.HoverOverInsights();
            pageTest.clikBtnGoToBlog();
            pageTest.printListTitles();
        } catch (WebActionsException | InterruptedException e) {
            e.printStackTrace();
        }
    }




}
