package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage {
     WebDriver driver;
     private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")
    WebElement homepageLoginBtn;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/button[1]/span[2]")
    WebElement verifyHomepage;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean verifyHomeP()
    {
        //Assert.assertTrue(verifyWhatsappOTPPage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(verifyHomepage));
        verifyHomepage.isDisplayed();
        return true;
    }

    public void clickLoginBtn()
    {
        homepageLoginBtn.click();
    }

}
