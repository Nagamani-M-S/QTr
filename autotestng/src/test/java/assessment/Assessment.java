package assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import generic.GenericLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment extends GenericLaunch {

	public WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		Assessment assessment = new Assessment();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		assessment.driver = driver;
		driver.manage().window().maximize();
		
		driver.get("https://qtrecognition.testqtwiz.com/");
		driver.findElement(By.name("username")).sendKeys("nagamani.ms@qualitestgroup.com");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("P@ssw0rd");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Login']")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "QTRecognition");
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='shoutout_to_me']//i[1]"));
		for (WebElement colors : ele) {
			String color = colors.getCssValue("color");
			
			if(color.equals("rgb(254, 204, 22)"))
			{
				System.out.println("Gold is present");
			}
			else if (color.equals("rgb(42, 37, 89)")) 
			{
				System.out.println("Navy is present");
			}
			else if (color.equals("rgb(147, 149, 152)")) 
			{
				System.out.println("white is present");
			}
			
		}
		
		
		
	/*public void validateHomePageElements(WebDriver driver) {
		
		List<String> qualitestColors = Arrays.asList("rgb(254, 204, 22)","rgb(42, 37, 89)","rgb(147, 149, 152)");
		List<String> validColorsList = new ArrayList<String>();
		List<String> invalidColorsList = new ArrayList<String>();
		List<WebElement> kudos = driver.findElements(By.xpath("//div[@id='shoutout_to_me']/div"));
		
		for (int i = 1; i <= kudos.size(); i++) {
			
			WebElement kudo = kudos.get(i);
			
			String id = kudo.getAttribute("id");
			String text = kudo.getText();
			
			WebElement kudoIcon = driver.findElement(By.xpath("(//div[@id='shoutout_to_me']/div)["+i+"]//i[@style]"));
			String color = kudoIcon.getAttribute("style");
			//#fecc16   #2a2559   #939598
			//style="color: #fecc16;font-size:50px"
			String iconColor = StringUtils.substringBetween(color, "color: ", "; font-size:");
			
			
			if (!qualitestColors.contains(iconColor)) {
				System.out.println("color didn't match for:");
				System.out.println("color: "+iconColor);
				System.out.println("id: "+id);
				System.out.println(text);
				System.out.println();
			}
		}*/
	}
}
