
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Search_Page {

private static WebElement element = null;

public static void selectLocation(WebDriver driver, String locationSelected)
{
	driver.switchTo().defaultContent(); // outside both frames
	driver.switchTo().frame("supermatch");
	// click on Location
	driver.findElement(By.xpath("//a[@id='critHeader0']")).click(); 
	//click on Location selected
	System.out.println("CLICK ON LOCATION: " + locationSelected);
	driver.findElement(By.xpath("//span[text()='" + locationSelected + "']")).click();
	driver.findElement(By.className("matchingSection"));
	System.out.println("CHECK SEARCH IS LOADED FOR " + locationSelected);
	driver.switchTo().defaultContent();
}

public static void selectMajors(WebDriver driver, String majorType, String majorName)
{
	driver.switchTo().defaultContent(); // outside both frames
	driver.switchTo().frame("supermatch");
	// click on Location
	driver.findElement(By.xpath("//a[@id='critHeader1']")).click(); 
	//click on Location selected
	System.out.println("CLICK ON MAJORS: " + majorType);
	driver.findElement(By.xpath("//span[contains(text(),'" + majorType + "')]/preceding-sibling::input")).click();
	System.out.println("WRITE ON TEXTBOX KEYWORDS " + majorName);
	WebElement careerText = driver.findElement(By.id("majorSearchText"));
	careerText.sendKeys(Keys.RETURN);
	careerText.sendKeys(majorName);
	careerText.sendKeys(Keys.ENTER);
	//driver.findElement(By.xpath("//div[@id='matchingMajors']/span[0]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'" + majorType + "')]")).click();
	driver.findElement(By.className("matchingSection"));
	System.out.println("***CHECK SEARCH IS LOADED FOR " + majorName);
}

public static void verifySearchResult100Percent(WebDriver driver, String keyFound)
{
	driver.switchTo().defaultContent(); // outside both frames
	driver.switchTo().frame("supermatch");
	boolean keyPresent, hundredPresent;
	System.out.println("CHECK IF UNIVERSITY '" + keyFound + "' IS A 100% MATCH");
	WebElement UniversityFound = null;
	try {
		UniversityFound = driver.findElement(By.xpath("//div[@class='matchingSection']/div[contains(text(), '" + keyFound + "')]"));
	   keyPresent = true;
	} catch (NoSuchElementException e) {
	   keyPresent = false;
	   System.out.println("KEY UNIVERSITY WAS NOT FOUND: " + keyFound);
	}
	if(keyPresent)
	{
		try {
			UniversityFound.findElement(By.xpath("//div[@class='percentMatch' and contains(text(), '100%')"));
			hundredPresent = true;
		} catch (NoSuchElementException e) {
			hundredPresent = false;
		}
	}
	else
	{
		System.out.println("KEY UNIVERSITY IS NOT A 100% MATCH");
	}

}

public static WebElement lnk_MyAccount(WebDriver driver){

element = driver.findElement(By.id("account"));

return element;

}

public static WebElement lnk_LogOut(WebDriver driver){

element = driver.findElement(By.id("account_logout"));

return element;

}

}