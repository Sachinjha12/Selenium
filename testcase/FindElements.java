package testcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class FindElements {

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        driver.get("https://demo.opencart.com/en-gb?route=account/register");
	        List<WebElement> ele = driver.findElements(By.xpath("//input[@class='form-control']"));
	        for (WebElement i : ele) {
	System.out.println("WebElement:" + i);
	}
	}
	}
