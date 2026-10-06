package base;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BrowserFactory;
import config.ConfigReader;
import utils.ReadFromExcelFile;
import utils.TakeScreenshots;

public class Base {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected EditProfilePage editProfilePage;
    protected MyprofilePage myprofilePage;
    protected TakeScreenshots TakeScreenshots = new TakeScreenshots();


    @BeforeClass
    public void setUp() {
       // boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

       // driver = BrowserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/",headless);
        boolean headless =
                Boolean.parseBoolean(
                        ConfigReader.getProperty("headless")
                );
        String browser =
                ConfigReader.getProperty("browser");

        String url =
                ConfigReader.getProperty("ui.base.url");

        driver = BrowserFactory.startBrowser(
                browser,
                url,
                headless
        );

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        editProfilePage = new EditProfilePage(driver);
        myprofilePage = new MyprofilePage(driver);

        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, dashboardPage);
        PageFactory.initElements(driver, editProfilePage);
        PageFactory.initElements(driver, myprofilePage);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


