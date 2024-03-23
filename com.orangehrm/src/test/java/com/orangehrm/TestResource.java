package com.orangehrm;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;



public class TestResource {
	static WebDriver driver;
	
	WebDriver getWebDriver() {
		driver = new ChromeDriver();
		return driver;
	}
	
	//opens a web site
	void openWebsite(WebDriver driver, String url) {
		driver.get(url);
	}
	
	//closes driver
	void closeWebsite(WebDriver driver) {
		driver.close();
	}
	
	//navigates to a web site
	void navigateWebsite(WebDriver driver, String url) {
		driver.navigate().to(url);
	}
	
	//navigates to a forward page
	void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	//navigates to the previous
	void backward(WebDriver driver) {
		driver.navigate().back();
	}
	
	//opens a new tab
	void newTab (WebDriver driver) {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	//switch to a tab
	void switchToHandle (WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	
	
	//finds the x path element and writes in the field
	void findAndType(WebDriver driver, String xpath, String message) {
		driver.findElement(By.xpath(xpath)).sendKeys(message);
	}
	
	//finds the x path element and clicks it
	void click(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	//verifies two string title
	boolean verify (String title1, String title2) {
		return title1.equals(title2);
	}
	
	//fetches a page title
	String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	//selects from a drop down menu
	void selectDropDown (WebDriver driver, String xpath, String visibleText) {
		Select se = new Select(driver.findElement(By.xpath(xpath)));
		se.selectByVisibleText(visibleText);
	}
	
	//switches to the captcha iframe
	void captcha (WebDriver driver, String xpath) {
		driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
	}
	
	//switches back to the default page from captcha iframe
	void captchaSwitch (WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	//Takes Screenshot of the current page
	void screenshot (WebDriver driver, String path) throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File(path));
	}
	
	//finds the CSS Selector element and clicks it
	void clickCss (WebDriver driver, String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	//get window handle
	String windowHandle (WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	//scrolls the web page
	void scroll (WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
	}
	
	//Implicitly waits
	void implicitWait (WebDriver driver, int timeInSec) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
	}
}
