package testcase;
 
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;


public class Lab_05_a {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch App
        driver.get("https://demo.opencart.com/en-gb?route=account/register");

        // Personal Details
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Sachin");

        // Validate First Name
        String longFirstName = "Sachin";
        firstName.clear();
        firstName.sendKeys(longFirstName);
        String enteredFirstName = firstName.getAttribute("value");

        if (enteredFirstName.length() > 32) {
            System.out.println("Exceeded character limit for First Name.");
        } else {
            System.out.println("First Name accepted: " + enteredFirstName);
        }

        // Last Name
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Jha");

        // Email
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("ascendion@gmail.com"); // Update to a valid email

        // Password
        WebElement password = driver.findElement(By.id("input-password"));
        String passwordValue = "Pass123";
        password.sendKeys(passwordValue);

        if (passwordValue.length() < 4 || passwordValue.length() > 20) {
            System.out.println("Password must be between 4 and 20 characters.");
        } else {
            System.out.println("Password is valid.");
        }

        // Newsletter
        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsletterYes);

        // Agree to Privacy Policy
        WebElement agreePrivacy = driver.findElement(By.name("agree"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreePrivacy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreePrivacy);

        // Continue Button
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(Exception.class);

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit' or @value='Continue' or contains(text(), 'Continue')]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);

        // Check Account Creation Success
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), 'Your Account Has Been Created!')]")));
            System.out.println("Account successfully created.");
        } catch (Exception e) {
            System.out.println("Account creation failed. Please check for errors.");
        }

        // Wait for order history link to be available
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement orderHistoryLink = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.linkText("View your order history")));
            orderHistoryLink.click();
        } catch (NoSuchElementException e) {
            System.out.println("Order history link not found. Account creation may have failed.");
        }

        driver.quit();
    }
}
