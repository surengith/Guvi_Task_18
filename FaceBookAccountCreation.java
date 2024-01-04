package com.SeleniumPracticeTask18.org;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookAccountCreation {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the ChromeDriver that includes WebDriver setup
		WebDriver driver = new ChromeDriver();

		// Maximizes the browser window
		driver.manage().window().maximize();

		// ImplicitlyWait for 10 seconds to get the URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");

		// Verifying that the user successfully redirected to the FacebookHomepage after
		// Enter the URL
		String actualTitle = "Facebook – log in or sign up";
		String expectedTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("URL Verification Successful: " + expectedTitle);
		} else {
			System.out.println("URL Verification Unsuccessful");
		}

		// Click on the "Create New Account" button
		WebElement createNewAccount = driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
		createNewAccount.click();

		// Enter the First name on FirstName filed
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Test");

		// Enter the Surname on Surname filed
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("User");

		// Enter the valid Email id on the email field
		WebElement emailId = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		emailId.sendKeys("surendharpalaniswamy@gamil.com");

		// Re-Enter the valid Email id on the Re-Enter email field
		WebElement emailIdRenter = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		emailIdRenter.sendKeys("surendharpalaniswamy@gamil.com");

		// Enter the Strong Password on the Password field
		WebElement password = driver.findElement(By.xpath("//input[@data-type='password']"));
		password.sendKeys("TestUser@321$");

		// Use select method to select the Day
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select selDay = new Select(day);
		selDay.selectByValue("11");

		// Use select method to select the May
		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select selMonth = new Select(month);
		selMonth.selectByVisibleText("May");

		// Use select method to select the Year
		WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select selYear = new Select(year);
		selYear.selectByVisibleText("1985");

		// Select the gender
		WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		gender.click();

		// Click the SignUp button
		WebElement signUp = driver.findElement(By.xpath("//button[@name='websubmit']"));
		signUp.click();

		// Verifying that the user successfully registered and redirected to the
		// FacebookHomepage
		String actualTitle1 = "Facebook – log in or sign up";
		String expectedTitle1 = driver.getTitle();

		if (actualTitle1.equals(expectedTitle1)) {
			System.out.println("Verifying the WebPage After Clicking the SignUp Button: " + expectedTitle1);
		} else {
			System.out.println("Page Landed On Wrong Page");
		}

		// Wait for 2 seconds
		Thread.sleep(2000);

		// Quit the driver or close
		driver.close();
	}

}
