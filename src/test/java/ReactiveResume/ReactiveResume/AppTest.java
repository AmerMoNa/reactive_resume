package ReactiveResume.ReactiveResume;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends testData {

	@BeforeTest
	public void setUp() {

		mySetup();

	}

	@Test(priority = 1)
	public void registerAccount() {
		WebElement createAccountButton = driver.findElement(By.linkText("Create one now"));
		createAccountButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid.grid-cols-2.gap-4")));

		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys(name);

		WebElement userNameField = driver.findElement(By.name("username"));
		userNameField.sendKeys(userName);

		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys(email);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(password);

		WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
		signUpButton.click();

		WebElement continueButton = driver.findElement(By.linkText("Continue"));
		continueButton.click();

	}

	@Test(priority = 2)
	public void logout() {
		WebElement menuButton = driver.findElement(By.id("radix-_r_7_"));
		menuButton.click();

		WebElement logOutButton = driver.findElement(By.cssSelector(".relative.flex.cursor-default"));
		logOutButton.click();

	}

	@Test(priority = 3)
	public void login() {
		WebElement emailFeild = driver.findElement(By.name("identifier"));
		emailFeild.sendKeys(email);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(password);

		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
		signinButton.click();

	}

}
