package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {
	public static void main(String[] args) {
		//Launch the browser
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	//https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Enter the username as ramkumar.ramaiah@testleaf.com
				WebElement elementUserName = driver.findElement(By.id("username"));
				elementUserName.sendKeys("ramkumar.ramaiah@testleaf.com");
				
				//Enter the password as Password#123
				WebElement elementPassword = driver.findElement(By.id("password"));
				elementPassword.sendKeys("Password#123");
				
				//click on the login button
				driver.findElement(By.id("Login")).click();
				
				//click on the learn more option in the Mobile publisher
				driver.findElement(By.xpath("//span[text()='Learn More']")).click();

				//Switch to the next window using Windowhandles
				Set<String> SecondwindowHandles = driver.getWindowHandles();
				List<String>listHandle=new ArrayList<String>(SecondwindowHandles);
				driver.switchTo().window(listHandle.get(1));
				
				//click on the confirm button in the redirecting page
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				
				//Get the title
				String title = driver.getTitle();
				System.out.println(title);
				
				//Get back to the parent window
				driver.switchTo().window(listHandle.get(0));
			
				//close the browser
				driver.close();
}
}
