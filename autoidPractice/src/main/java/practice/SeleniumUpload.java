package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/upload-download");
		WebElement choosen = driver.findElement(By.cssSelector("#uploadFile"));
		choosen.sendKeys("C:\\Users\\HARITHA\\Downloads\\Final PPT.pdf");
		String msg=driver.findElement(By.id("uploadedFilePath")).getText();
		System.out.println("the message was:"+msg);
		driver.close();

	}

}
