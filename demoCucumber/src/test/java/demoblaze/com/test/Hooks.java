package demoblaze.com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        System.out.println("========= ONE TIME SETUP =========");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/");
    }

    @AfterAll
    public static void teardown() {
        System.out.println("========= ONE TIME TEARDOWN =========");
        driver.quit();
    }
}