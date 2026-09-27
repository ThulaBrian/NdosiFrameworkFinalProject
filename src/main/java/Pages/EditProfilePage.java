package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProfilePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div/div[1]/form/div[1]/label")
    WebElement verifyEditProfilePage;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div/div[1]/form/div[7]/div/div[2]/label")
    WebElement choosePhotoLabel;

    @FindBy(id = "profilePicture")
    WebElement photoUpload;

    @FindBy(xpath = "//*[@id=\"app-main-content\"]/section/div/div[1]/form/div[8]/button[1]")
    WebElement saveChangesBtn;

    public EditProfilePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyEditProfileP()
    {
        wait.until(ExpectedConditions.visibilityOf(verifyEditProfilePage));
        //Assert.assertTrue(verifyLoginHeading.isDisplayed());
        verifyEditProfilePage.isDisplayed();
    }

    public void pictureUpload(String pictureAddress)
    {
        photoUpload.sendKeys(pictureAddress);
    }

    public void clickChoosePhotoLabel()
    {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                choosePhotoLabel
        );
        wait.until(ExpectedConditions.elementToBeClickable(choosePhotoLabel));
        choosePhotoLabel.click();
    }
    public void clickSaveChangesBtn()
    {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                saveChangesBtn
        );
        wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn));
        saveChangesBtn.click();
    }

}
