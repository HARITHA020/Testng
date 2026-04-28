package com.test;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class listenerScreenshot {

    public static void captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            File dest = new File("screenshots/" + testName + ".png");
            FileHandler.copy(src, dest);
            System.out.println("Screenshot taken: " + testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}