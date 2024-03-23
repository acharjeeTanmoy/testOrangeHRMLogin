package com.orangehrm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestOrangeHrm {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		TestResource tr = new TestResource();
		
		//1. Launch the browser.
		WebDriver driver = tr.getWebDriver();
		tr.implicitWait(driver, 5);
		
		//2. Enter the URL,“https://google.com” 
		tr.openWebsite(driver, "https://google.com");
		String windowHandle1 = tr.windowHandle(driver);
		String title1 = tr.getPageTitle(driver);
		driver.manage().window().maximize();
		
		//3. Enter the value in search or Edit box "Orange HRM demo”.
		tr.findAndType(driver, "//textarea[@id='APjFqb']", "Orange HRM demo");
		
		//4. Click on Search or press Enter. 
		tr.click(driver, "(//input[@name='btnK'])[1]");
		
		//5. Search Result will be displayed.
		String title3 = tr.getPageTitle(driver);
		
		//6. Click on Back arrow button and verify if the Google Page is appeared.
		tr.backward(driver);
		String title2 = tr.getPageTitle(driver);
		boolean verifyTitles1 = tr.verify(title1, title2);
		System.out.println("Google page appeared verifiaction: " + verifyTitles1);
		
		// 7. Click on Forward arrow button and verify if it is redirected to the results page.
		tr.forward(driver);
		String title4 = tr.getPageTitle(driver);
		boolean verifyTitles2 = tr.verify(title3, title4);
		System.out.println("Google searrch page appeared verification: " + verifyTitles2);
		
		//8. Navigate to the page https://www.orangehrm.com/
		tr.newTab(driver);
		tr.openWebsite(driver, "https://www.orangehrm.com/");
		
		//9. Click CONTACT SALES and fill the all the fields as below.
		tr.click(driver, "//div[@class='d-flex web-menu-btn']//li[2]/a/button");
		
		//10. Your full Name: Vikram Rathode"
		tr.findAndType(driver, "//input[@id='Form_getForm_FullName']", "Vikram Rathode");
		
		//11. Phone Number: 1234567890 
		tr.findAndType(driver, "//input[@id='Form_getForm_Contact']", "1234567890");

		//12. JobTitle: Fresher 
		tr.findAndType(driver, "//input[@id='Form_getForm_JobTitle']", "Fresher");
		
		//13. Country: India 
		tr.click(driver, "//select[@id='Form_getForm_Country']");
		tr.selectDropDown(driver, "//select[@id='Form_getForm_Country']", "India");

		//14. No of Employees: 11-15 
		tr.click(driver, "//select[@id='Form_getForm_NoOfEmployees']");
		tr.selectDropDown(driver, "//select[@id='Form_getForm_NoOfEmployees']", "11 - 15");
		
		//15. Business Email: rathodeitsolutions.test@test.com 
		tr.findAndType(driver, "//input[@id='Form_getForm_Email']", "rathodeitsolutions.test@test.com");

		//16. Do not enter any message in the “your message” text box.
		tr.scroll(driver);
		
		//17. Select Check box (I am not robot) and click submit button.
		tr.captcha(driver, "//iframe[@title='reCAPTCHA']");
		tr.clickCss(driver, ".recaptcha-checkbox-border");
		Thread.sleep(40000);
		tr.captchaSwitch(driver);
		tr.click(driver, "//input[@id='Form_getForm_action_submitForm']");
		
		//18. Take Screenshot of the page. 
		tr.screenshot(driver, "C:\\Users\\2318235\\OneDrive - Cognizant\\Pictures\\MiniProject\\sc1.jpg");
		
		//19. Enter any message in the “your message” text box. 
		tr.findAndType(driver, "//textarea[@id='Form_getForm_Comment']", "dummy text");
		
		//20.  Select Check box (I am not robot) and click submit button. 
		tr.click(driver, "//input[@id='Form_getForm_action_submitForm']");

		//21. Close the current tab and verify if it is navigating to previous tab. 
		tr.closeWebsite(driver);
		tr.switchToHandle(driver, windowHandle1);
		String windowHandle2 = tr.windowHandle(driver);
		boolean verifyLastTab = tr.verify(windowHandle1, windowHandle2);
		System.out.println("Verification for if its navigating to previous tab: " + verifyLastTab);
		driver.quit();
	}

}
