package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
     // Import package pageObject.*
import pageObjects.Home_Page;
import pageObjects.Search_Page;

public class PageObjectModel {

 private static WebDriver driver = null;

 public static void main(String[] args) {
	 //C:\seleniumConfig\geckodriver
	 System.setProperty("webdriver.gecko.driver", "bin/geckodriver/geckodriver.exe");
	 driver = new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://www.collegeview.com/index.jsp");
	 
	 Home_Page.lnk_StartSearching(driver).click();
	 Search_Page.selectLocation(driver, "Ohio");
	 Search_Page.selectMajors(driver, "Bachelor", "Computer Software Engineering");
	 Search_Page.verifySearchResult100Percent(driver, "Miami University-Oxford");
	 //driver.quit();
 }

}