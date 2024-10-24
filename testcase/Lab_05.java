
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
 
public class Lab_05
{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        driver.get("https://demo.opencart.com/en-gb?route=account/register");
 
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Sachin");
 
        String longFirstName = "Sachin";
        firstName.clear();
        firstName.sendKeys(longFirstName);
        String enteredFirstName = firstName.getAttribute("value");
 
        if (enteredFirstName.length() > 32) {
            System.out.println("Exceeded character limit for First Name.");
        } else {
            System.out.println("First Name accepted: " + enteredFirstName);
        }
 
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Jha");
 
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("jhash@example.com");
 
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Password123");
 
        WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsletterYes);
 
        WebElement agreePrivacy = driver.findElement(By.name("agree"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreePrivacy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreePrivacy);
      
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(Exception.class);
 
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit' or @value='Continue' or contains(text(), 'Continue')]")));
 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
 
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), 'Your Account Has Been Created!')]")));
            System.out.println("Account successfully created.");
        } catch (Exception e) {
            System.out.println("Account creation failed. Please check for errors.");
        }
 
        if (driver.getPageSource().contains("Your Account Has Been Created!")) {
            System.out.println("Account successfully created.");
        } else {
            System.out.println("Account creation failed.");
        }
 
        WebElement orderHistoryLink = driver.findElement(By.linkText("View your order history"));
        orderHistoryLink.click();
 
        driver.quit();
    }
}
 
 
