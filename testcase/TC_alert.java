package testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get(" https://mail.rediff.com/cgi-bin/login.cgi");
		
		// simple alert
		
		driver.findElement(By.id("login1")).sendKeys("uname1");
		driver.findElement(By.name("proceed")).click();
		Alert simplealert=driver.switchTo().alert();
		
		System.out.println("Alter meesage:"+simplealert.getText());
		simplealert.accept();
		
		// confirmation alert
		
		driver.navigate().to("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert confirm=driver.switchTo().alert();
		System.out.println("Alter meesage:"+confirm.getText());
		confirm.accept();
		
		//prompt alert
		
		
		driver.findElement(By.id("prompt")).click();
		Alert prompt=driver.switchTo().alert();
		System.out.println("Alter meesage:"+prompt.getText());
		prompt.sendKeys("kkkkkk");
		prompt.accept();
		
		
		
		
		
		
 
	}
 

		
	}


