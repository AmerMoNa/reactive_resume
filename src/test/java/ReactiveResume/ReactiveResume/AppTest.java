package ReactiveResume.ReactiveResume;

import static org.testng.Assert.assertEquals;

import java.util.List;

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

	@Test(priority = 2, enabled = true)
	public void logout() {
		WebElement menuButton = driver.findElement(By.id("radix-_r_7_"));
		menuButton.click();

		WebElement logOutButton = driver.findElement(By.cssSelector(".relative.flex.cursor-default"));
		logOutButton.click();

	}

	@Test(priority = 3, enabled = true)
	public void login() {
		WebElement emailFeild = driver.findElement(By.name("identifier"));
		emailFeild.sendKeys(email);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(password);

		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
		signinButton.click();

	}

	@Test(priority = 4)
	public void createResume() {
		List<WebElement> resumeSections = driver
				.findElements(By.cssSelector(".absolute.inset-0.flex.items-center.justify-center"));
		resumeSections.get(0).click();

		WebElement enterResumeName = driver.findElement(By.name("name"));
		enterResumeName.sendKeys(jobTitle);

		WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
		createButton.click();

	}

	@Test(priority = 5, enabled = true)
	public void editTheResume() throws InterruptedException {

		WebElement newResumeCard = driver.findElement(By.cssSelector(".select-none.cursor-default"));
		actions.contextClick(newResumeCard).perform();

		WebElement updateButton = driver.findElement(By.xpath("//div[text()='Update']"));
		updateButton.click();

		WebElement enterNewResumeName = driver.findElement(By.name("name"));
		enterNewResumeName.clear();
		enterNewResumeName.sendKeys(newJobTitle);

		WebElement saveChangesButton = driver.findElement(By.xpath("//button[text()='Save Changes']"));
		saveChangesButton.click();

		driver.navigate().refresh();

		Thread.sleep(2000);

		List<WebElement> resumeCards = driver.findElements(By.cssSelector(".truncate.font-medium"));

		String actualResumeName = resumeCards.get(2).getText();

		assertEquals(actualResumeName, newJobTitle, "Resume name did not update correctly!");

	}

	@Test(priority = 6)
	public void deleteResume() {

		WebElement resumeCard = driver.findElement(By.cssSelector(".select-none.cursor-default"));
		actions.contextClick(resumeCard).perform();

		WebElement deleteButton = driver.findElement(By.xpath("//div[text()='Delete']"));
		deleteButton.click();

		WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirmButton.click();

	}

}
