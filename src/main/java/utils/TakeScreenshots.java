package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {
    private static final String screenshotDir = System.getProperty("user.dir") + "/screenshots";

    public void takeSnapShots(WebDriver driver, String screenShotName){

        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;

        File src = takeScreenshot.getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotDir, screenShotName + ".jpeg");

        try{
            FileUtils.copyFile(src,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
