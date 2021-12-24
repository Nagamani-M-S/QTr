package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericLaunch {
	
	public WebDriver driver;
	

	public void launchChromeBrowser() {
		
		WebDriverManager.chromedriver().setup();
		 this.driver = new ChromeDriver();
	}

	
	public void closeBrowser() {
		
		driver.quit();
	}
}
