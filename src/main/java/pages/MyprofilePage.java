package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyprofilePage {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/h2")
    WebElement verifyMyprofilePage;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div/div[1]/div[9]/button[1]")
    WebElement editprofileBtn;

    public MyprofilePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyMyProfilePage()
    {
        wait.until(ExpectedConditions.visibilityOf(verifyMyprofilePage));
        //Assert.assertTrue(verifyLoginHeading.isDisplayed());
        verifyMyprofilePage.isDisplayed();
    }
    public void clickEditProfileBtn()
    {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                editprofileBtn
        );
        wait.until(ExpectedConditions.visibilityOf(editprofileBtn));
        editprofileBtn.click();
    }


}
