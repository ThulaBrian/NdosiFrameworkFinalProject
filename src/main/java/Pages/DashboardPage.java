package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    // I used the my learning Button-Dropdown list
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/button")
    WebElement verify_dashboardpage;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement LearnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMetrialoption;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/button/span[2]")
    WebElement menuBtn;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/div/button[1]/span[2]")
    WebElement myprofileBtn;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyDashBoardPage()
    {
        wait.until(ExpectedConditions.visibilityOf(verify_dashboardpage));
        verify_dashboardpage.isDisplayed();
    }
    public void clickMenuBtn()
    {
        menuBtn.click();
    }
    public void clickMyprofileBtn()
    {
        myprofileBtn.click();
    }

}
