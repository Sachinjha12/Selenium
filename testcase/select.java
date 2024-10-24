package testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Desktop")).click();
		driver.findElement(By.linkText("Mac(1)")).click();
		
		Select sort=new Select(driver.findElement(By.id("input.sort")));
		
		sort.selectByIndex(5);
		
		sort.selectByVisibleText("Rating(Lowest)");
		List<WebElement> count=sort.getOptions();
		
		for(int i=0; i<count.size();i++)
		{
			String  str=count.get(i).getText();
			System.out.println("Values are:"+str);
		}
	}

}
