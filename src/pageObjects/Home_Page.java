
package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Home_Page {

private static WebElement element = null;

public static void goToSearchPage(WebDriver driver)
{
	driver.findElement(By.xpath("//a/img[contains(@src, 'start_searching')]")).click();
	}

public static WebElement lnk_StartSearching(WebDriver driver){

//element = driver.findElement(By.id("account"));
	element = driver.findElement(By.xpath("//a/img[contains(@src, 'start_searching')]"));
return element;

}

public static WebElement lnk_LogOut(WebDriver driver){

element = driver.findElement(By.id("account_logout"));

return element;

}

}