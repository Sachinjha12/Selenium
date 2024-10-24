package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
   public class MouseHover {
	 
	 
	    public static void main(String[] args) {
	        // Setup WebDriver using WebDriverManager
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        driver.get("https://www.snapdeal.com");
	 
	        Actions actions = new Actions(driver);
	        
	        // Locate the "Men's Fashion" element
	        WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
	        
	        // Perform mouse hover on "Men's Fashion"
	        actions.moveToElement(mensFashion).perform();
	        
	        // Add explicit wait for the "Sunglasses" link to be visible and clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement sunglasses = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sunglasses']")));
	        
	        // Click on "Sunglasses"
	        sunglasses.click();
	 
	        // Close the browser
	        driver.quit();
	    }
	}
 
//package testcase;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class MouseHover {
//
//    public static void main(String[] args) {
//        // Setup WebDriver using WebDriverManager
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        
//        // Maximize the browser window
//        driver.manage().window().maximize();
//        
//        // Implicit wait to handle general delays
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        
//        // Navigate to Snapdeal website
//        driver.get("https://www.snapdeal.com");
//        
//        // Initialize Actions class for performing mouse hover
//        Actions actions = new Actions(driver);
//        
//        // Locate the "Men's Fashion" element
//        WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
//        
//        // Perform mouse hover on "Men's Fashion"
//        actions.moveToElement(mensFashion).perform();
//        
//        // Explicit wait for the "Sunglasses" link to be clickable
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement sunglasses = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sunglasses']")));
//        
//        // Scroll the element into view in case it's not visible
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sunglasses);
//        
//        // Use JavaScript Executor to click the "Sunglasses" link if a normal click fails
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", sunglasses);
//        
//        // Verify if the click was successful by checking the page title or URL
//        System.out.println("Current page title is: " + driver.getTitle());
//        
//        // Close the browser
//        driver.quit();
//    }
//}




