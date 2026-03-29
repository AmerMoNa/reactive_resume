package ReactiveResume.ReactiveResume;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class resumeTest extends testData {

	@BeforeTest
	public void setUp() {

		mySetup();

	}

	@Test(priority = 1)
	public void registerAccount() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid.grid-cols-2.gap-4")));

		WebElement createAccountButton = driver.findElement(By.partialLinkText("Create"));
		createAccountButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid.grid-cols-2.gap-4")));

		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys(fullName);

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

		WebElement menuButton = wait.until(
				ExpectedConditions.elementToBeClickable((By.xpath("//button[@data-slot='dropdown-menu-trigger']"))));
		menuButton.click();

		WebElement logOutButton = driver.findElement(By.cssSelector(".relative.flex.cursor-default"));
		logOutButton.click();

	}

	@Test(priority = 3, enabled = true)
	public void login() {
		WebElement emailField = driver.findElement(By.name("identifier"));
		emailField.sendKeys(email);

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(password);

		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
		signinButton.click();

	}

	@Test(priority = 4, enabled = true)
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
		enterNewResumeName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		enterNewResumeName.sendKeys(newJobTitle);

		WebElement saveChangesButton = driver.findElement(By.xpath("//button[text()='Save Changes']"));
		saveChangesButton.click();

		driver.navigate().refresh();

		Thread.sleep(2000);
		List<WebElement> resumeCards = driver.findElements(By.cssSelector(".truncate.font-medium"));

		String actualResumeName = resumeCards.get(2).getText();

		assertEquals(actualResumeName, newJobTitle, "Resume name did not update correctly!");

	}

	@Test(priority = 6, enabled = true)
	public void uploadImage() {
		WebElement resumeCard = driver.findElement(By.cssSelector(".select-none.cursor-default"));
		resumeCard.click();

		WebElement imageUrlInput = driver.findElement(By.name("url"));
		imageUrlInput.sendKeys("https://i.imgur.com/8Km9tLL.jpg");

		WebElement checkUploadedImage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".page-picture.shrink-0.overflow-hidden")));
		Assert.assertTrue(checkUploadedImage.isDisplayed());

//		driver.navigate().back();

	}

	@Test(priority = 7)
	public void resumeInformation() {

		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys(name);

		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.sendKeys(email);

	}

	@Test(priority = 8, enabled = true)
	public void downloadResume() throws InterruptedException {

		List<WebElement> exportList = driver.findElements(By.cssSelector(".flex.flex-1.flex-col.gap-y-1"));
		WebElement downloadPDF = exportList.get(2);
		downloadPDF.click();

		driver.navigate().back();

	}

	@Test(priority = 9, enabled = true)
	public void deleteResume() {

		WebElement resumeCard = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select-none.cursor-default")));

		actions.contextClick(resumeCard).perform();

		WebElement deleteButton = driver.findElement(By.xpath("//div[text()='Delete']"));
		deleteButton.click();

		WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirmButton.click();

	}

	@Test(priority = 10, enabled = true)
	public void languageSwitching() throws InterruptedException {

		WebElement menuButton = wait.until(
				ExpectedConditions.elementToBeClickable((By.xpath("//button[@data-slot='dropdown-menu-trigger']"))));
		menuButton.click();

		WebElement languageButton = driver.findElement(By.xpath("//div[text()='Language']"));
		languageButton.click();

		WebElement selectedArabic = driver.findElement(By.xpath("//div[text()='Arabic']"));
		selectedArabic.click();

		driver.navigate().refresh();

		String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		assertEquals(actualLang, "ar-SA", "Error: Website language was not updated to Arabic!");
	}

}
