package ReactiveResume.ReactiveResume;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class testData {

	WebDriver driver = new ChromeDriver();
	String theURL = "https://rxresu.me/auth/login?redirect=/dashboard";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	Faker faker = new Faker();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String name = firstName + " " + lastName;
	String userName = firstName + "." + lastName;
	String email = faker.internet().emailAddress();
	String password = faker.internet().password(6, 12, true, true, true);

	String jobTitle = faker.job().title();
	Actions actions = new Actions(driver);
	String newJobTitle = faker.job().title();

	public void mySetup() {

		driver.get(theURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

	}

}
