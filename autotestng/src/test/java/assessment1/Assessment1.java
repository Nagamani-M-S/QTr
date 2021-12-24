package assessment1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import generic.GenericLaunch;
	public WebDriver driver
	public class Assessment1 extends GenericLaunch{

	@Test
	public void basepageNav() throws AWTException{
		
        RecentContact rc = new RecentContact(driver);
         rc.clickRc().click();
         rc.Taketab().click();
    try {
		Thread.sleep(5000l);
	}
	catch(Exception e){
			e.printStackTrace();
		}
    rc.Comments().sendKeys("Hard Worker");
    try {
		Thread.sleep(5000l);
	}
	catch(Exception e){
			e.printStackTrace();
		}
	rc.Submit().click();
	
	//log.info("Recent Contacts Upadted");
	rc.closebtn().click();



	}

	
	@BeforeMethod
	public void fin() {
		 RecentContact rc = new RecentContact(driver);
	        rc.Clickusername().sendKeys("nagamani.ms@qualitestgroup.com");
	        rc.ClickPassword().sendKeys("P@ssw0rd");
			rc.ClickLogin().click();
	}
	
	@BeforeClass
	
	public void findurl() throws Exception {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	
	public void submitt() {
		driver.close();
		
	}
	
}
