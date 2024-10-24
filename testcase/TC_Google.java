package testcase;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Google {

    public static void main(String[] args) throws InterruptedException {
        // Setting up the WebDriver for Chrome using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Implicit wait: Specifies the maximum amount of time WebDriver will wait for elements to appear
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Launch Google
        driver.get("https://www.google.com/");
        
        // Using JavaScript Executor to create an alert
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Search testing method');");
        
        // Page Load Timeout: Sets a timeout for the page to load completely
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        
        // Get and print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        
        // Explicit wait: Waits until the element (Google search box) is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        
        // Fluent wait: Waits for elements with more flexibility, polling the DOM at regular intervals
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                                        .withTimeout(Duration.ofSeconds(30))  // Maximum wait time of 30 seconds
                                        .pollingEvery(Duration.ofSeconds(5))  // Polling every 5 seconds
                                        .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException
        
        // Enter text in the Google search box
        ele.sendKeys("Testing Method");
        
        // Submit the search form
        ele.submit();
        
        // Print the updated title of the page after the search
        System.out.println("Title of the page: " + driver.getTitle());
        
        // Navigate to Yahoo
        driver.navigate().to("https://www.yahoo.com/");
        System.out.println("Title of the page: " + driver.getTitle());
        
        // Navigate back to Google
        driver.navigate().back();
        System.out.println("Title of the page: " + driver.getTitle());
        
        // Navigate forward to Yahoo again
        driver.navigate().forward();
        System.out.println("Title of the page: " + driver.getTitle());
        
        // Print the current URL
        System.out.println("URL is: " + driver.getCurrentUrl());
        
        // Print the page source and check if it contains 'yahoo'
        System.out.println("Page source contains 'yahoo': " + driver.getPageSource().contains("yahoo"));
        
        // Close the browser
        driver.close();
    }
}
