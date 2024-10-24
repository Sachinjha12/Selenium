package testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;


public class sendKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/en-gb?route=account/register");
		
		driver.findElement(By.id("input-firstname")).sendKeys("Sachin");
		
		driver.findElement(By.id("input-firstname")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("input-lastname")).sendKeys("Keys.NUMPAD7");

}
}
