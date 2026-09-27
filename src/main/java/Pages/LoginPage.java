package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement verifyLoginHeading;

    @FindBy(id = "login-email")
    WebElement emailField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void verifyLoginPageIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(verifyLoginHeading));
        //Assert.assertTrue(verifyLoginHeading.isDisplayed());
        verifyLoginHeading.isDisplayed();
    }
    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        submitButton.click();
    }


}
