package co.com.pruebatecnica.pages;

import co.com.pruebatecnica.exceptions.WebActionsException;
import co.com.pruebatecnica.logs.Log;
import com.github.javafaker.Faker;
import gherkin.lexer.De;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static co.com.pruebatecnica.stepsdefinitions.step_test.StepTest.webAction;

public class PageTest {

    public PageTest() {
    }

    private int DEFAULT_TIME = 60;


    @FindBy(how = How.XPATH, using = "//li[@id='menu-item-4436']")
    private WebElement lnkInsights;

    @FindBy(how = How.XPATH, using = "//*[@class='insights-pages']/a [@href='https://blankfactor.com/insights/blog/']")
    private WebElement btnGoToBlog;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Why your gateway needs an API gateway pattern')]")
    private WebElement lnkWhyYourGateway;

    @FindBy(how = How.XPATH, using = "//*[@class='container px-5']/div/section/div")
    private WebElement btnLetsTalk;

    @FindBy(how = How.NAME, using = "email")
    private WebElement inputEmail;

    @FindBy(how = How.XPATH, using = "//*[@class='btn btn-dark' and contains(text(),' Subscribe ')]")
    private WebElement btnSuscribe;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Go to homepage')]")
    private WebElement btnGoToHome;

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Java Design Pattern')]")
    private WebElement txtJavaDesign;

    @FindBy(how = How.XPATH, using = "//*[@class='theiaStickySidebar']/article[..]/div/h2/a")
    private List<WebElement> gridTitles;



    public void HoverOverInsights() throws WebActionsException, InterruptedException {
        Actions actions = new Actions(webAction.getDriver());
        actions.moveToElement(lnkInsights).perform();
        Thread.sleep(3000);
    }

    public void clikBtnGoToBlog() throws WebActionsException {
        webAction.click(btnGoToBlog, DEFAULT_TIME);
    }

    public void enterBlogWhyYourGateway() throws WebActionsException {

        Actions actions = new Actions(webAction.getDriver());
        actions.moveToElement(lnkWhyYourGateway).perform();
        webAction.click(lnkWhyYourGateway, DEFAULT_TIME);
    }

    public boolean isCorrectUrl(String url) {
        return url.equals(webAction.getDriver().getCurrentUrl());
    }

    public boolean isVisibleJavaDesignText() throws InterruptedException {
        Actions actions = new Actions(webAction.getDriver());
        actions.moveToElement(txtJavaDesign).perform();
        Thread.sleep(3000);
        return webAction.isVisible(txtJavaDesign, DEFAULT_TIME);
    }

    public boolean isPresentBtnLetsTalk() throws InterruptedException {
        //Thread.sleep(3000);
        webAction.waitVisible(btnLetsTalk,DEFAULT_TIME);
        Actions actions = new Actions(webAction.getDriver());
        actions.moveToElement(btnLetsTalk).perform();
        return webAction.isVisible(btnLetsTalk);
    }

    public void enterEmail() throws WebActionsException {
        Faker faker = new Faker();
        webAction.sendText(inputEmail, faker.internet().emailAddress(), DEFAULT_TIME);
    }

    public void clickSuscribe() throws WebActionsException {
        webAction.click(btnSuscribe, DEFAULT_TIME);
        webAction.waitVisible(btnGoToHome,DEFAULT_TIME);
    }

    public void printListTitles(){
        for (WebElement element: gridTitles) {
            Log.LOGGER.info("Title: "+ element.getText());
        }
    }

}
