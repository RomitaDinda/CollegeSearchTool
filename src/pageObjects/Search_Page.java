
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
	boolean present;
	try {
		driver.findElement(By.xpath("//div[@class='matchingSection']/div[contains(text(), '" + keyFound + "')]"));
	   present = true;
	} catch (NoSuchElementException e) {
	   present = false;
	}


//paso 7.2: WebElement UniversityFound = driver.findElement(By.Xpath(//div[@class="matchingSection"]/div[contains(text(), "Miami University-Oxford")]));

//WebElement UniversityFound = wrap.findElement(By.xpath("//div[@class='percentMatch' and contains(text(), '100%')"));
	 
	
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