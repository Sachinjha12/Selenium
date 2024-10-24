package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Lab_06 {


	
	public static void main(String[] args) throws InterruptedException {
        // Step 1: Setup WebDriver for Edge browser
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        
        // Maximize the browser window and clear cookies
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        // Step 2: Navigate to login page
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        
        // Step 3: Enter login credentials
        driver.findElement(By.id("input-email")).sendKeys("hussainengineer2026@gmail.com"); // Email from Lab 1
        driver.findElement(By.id("input-password")).sendKeys("Opencart@2025");               // Password from Lab 1
        
        // Step 4: Click login button using JavaScript Executor to bypass any potential issues
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary')]")));
        js.executeScript("arguments[0].click();", loginButton);
        
        // Step 5: Navigate to Components tab
        WebElement componentsTab = driver.findElement(By.xpath("//a[text()='Components']"));
        componentsTab.click();
        
        // Step 6: Select 'Monitors' from the dropdown
        WebElement monitorsLink = driver.findElement(By.xpath("//a[text()='Monitors (2)']"));
        js.executeScript("arguments[0].click();", monitorsLink);
        
        // Step 7: Set the limit to 25 products per page
        WebElement limitDropdown = driver.findElement(By.id("input-limit"));
        js.executeScript("arguments[0].value='https://demo.opencart.com/en-gb/catalog/component/monitor?limit=25';", limitDropdown);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", limitDropdown);
        
        // Step 8: Add the first monitor to the cart
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        WebElement cartButton = driver.findElement(By.xpath("//div[@id='product-list']/div[1]//button[@type='submit' and @aria-label='Add to Cart']"));
        js3.executeScript("arguments[0].click();", cartButton);
        
        // Step 9: Close the browser
driver.quit();
	    }
	}



