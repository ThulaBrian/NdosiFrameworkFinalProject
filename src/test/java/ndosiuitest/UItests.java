package ndosiuitest;

import base.Base;
import org.testng.annotations.Test;
import utils.ReadFromExcelFile;

@Test
public class UItests extends Base {

    public void verifyHomePage()
    {
        homePage.verifyHomeP();
        System.out.println("Homepage verified");
        TakeScreenshots.takeSnapShots(driver, "Homepage_screenshot001");
    }
    @Test(dependsOnMethods = "verifyHomePage")
    public void clickhomeLoginButton()
    {
        homePage.clickLoginBtn();
        System.out.println("Homepage login button clicked");
    }

    @Test(dependsOnMethods = "clickhomeLoginButton")
    public void verifyLoginPage()
    {
        loginPage.verifyLoginPageIsDisplayed();
        System.out.println("Loginpage verified");
        TakeScreenshots.takeSnapShots(driver, "Loginpage_screenshot002");
    }
    @Test(dependsOnMethods = "verifyLoginPage")
    public void clickLoginButton()
    {
        loginPage.enterEmail(ReadFromExcelFile.email);
        System.out.println("Email entered");
        loginPage.enterPassword(ReadFromExcelFile.password);
        System.out.println("Password entered");
        loginPage.clickLoginButton();
        System.out.println("Login Clicked");
    }

    @Test(dependsOnMethods = "clickLoginButton" )
    public void verifyDashboard()
    {
        dashboardPage.verifyDashBoardPage();
        System.out.println("Dashboardpage verified");
        TakeScreenshots.takeSnapShots(driver, "Dashboardpage_screenshot003");
    }
    @Test(dependsOnMethods = "verifyDashboard")
    public void clickMenuBtn()
    {
        dashboardPage.clickMenuBtn();
        System.out.println("menu button clicked");
        dashboardPage.clickMyprofileBtn();
        System.out.println("My profile selected");
    }

    @Test(dependsOnMethods = "clickMenuBtn")
    public void verifyMyProfilepage()
    {
        myprofilePage.verifyMyProfilePage();
        System.out.println("Myprofilepage verified");
        TakeScreenshots.takeSnapShots(driver, "Myprofilepage_screenshot004");
    }
    @Test(dependsOnMethods = "verifyMyProfilepage")
    public void clickEditButton()
    {
        myprofilePage.clickEditProfileBtn();
        System.out.println("Edit button clicked");
    }

    @Test(dependsOnMethods = "clickEditButton")
    public void verifyEditProfilePage()
    {
        editProfilePage.verifyEditProfileP();
        System.out.println("Editprofilepage verified");
        TakeScreenshots.takeSnapShots(driver, "Editprofilepage_screenshot005");
    }
    @Test(dependsOnMethods = "verifyEditProfilePage")
    public void pictureupload()
    {
        editProfilePage.clickChoosePhotoLabel();
        System.out.println("Edit label clicked");
        editProfilePage.pictureUpload("C:\\Users\\USER\\Downloads\\20250405_153507.jpg");
        System.out.println("Picture uploaded");
        TakeScreenshots.takeSnapShots(driver, "Uploadpicture_screenshot006");
    }
    @Test(dependsOnMethods = "pictureupload")
    public void clickSaveChanges()
    {
        editProfilePage.clickSaveChangesBtn();
        System.out.println("SaveChanges Button clicked");
        TakeScreenshots.takeSnapShots(driver, "Savechanges_screenshot007");
    }

}
