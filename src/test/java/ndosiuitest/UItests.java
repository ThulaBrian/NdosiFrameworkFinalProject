package ndosiuitest;

import base.Base;
import org.testng.annotations.Test;
import utils.ReadFromExcelFile;
import java.net.URL;
import java.nio.file.Paths;

import java.net.URL;

@Test
public class UItests extends Base {
    @Test
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
    public void pictureupload() throws Exception {

        editProfilePage.clickChoosePhotoLabel();
        System.out.println("Edit label clicked");

        // Get the picture from src/main/resources/Profile.jpg
        URL picture = getClass().getClassLoader()
                .getResource("Profile.jpg");

        if (picture == null) {
            throw new RuntimeException(
                    "Profile.jpg not found in src/main/resources/"
            );
        }
        // Convert the resource URL to an absolute file path
        String picturePath = Paths.get(picture.toURI())
                .toAbsolutePath()
                .toString();

        // Upload the picture
        editProfilePage.pictureUpload(picturePath);
        System.out.println("Picture uploaded");

        // Capture screenshot
        TakeScreenshots.takeSnapShots(
                driver,
                "Uploadpicture_screenshot006"
        );
    }
    @Test(dependsOnMethods = "pictureupload")
    public void clickSaveChanges()
    {
        editProfilePage.clickSaveChangesBtn();
        System.out.println("SaveChanges Button clicked");
        TakeScreenshots.takeSnapShots(driver, "Savechanges_screenshot007");
    }

}
