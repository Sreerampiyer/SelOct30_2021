package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContact {
	
	public static void main(String[] args) throws InterruptedException {

		// Step 1: Download and attach the chrome driver to this test case
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL
		driver.get("http://leaftaps.com/opentaps/");
		
		// Step 4: Maximize the browser 
		driver.manage().window().maximize();
		
		// Step 5: Find the user name and enter the data
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		// Step 6: Find the password and enter the data
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Step 7: Find the Login button and click
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Step 8: Click CRM/SFA 
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Step 9: Click Leads
		driver.findElement(By.linkText("Contacts")).click();
		
		// Step 10: Find Leads
		driver.findElement(By.linkText("Find Contacts")).click();
		
		// Type the first name
		driver.findElement(
				By.xpath("//label[text()='Contact Id:']/following::input[@name='firstName']")).sendKeys("Babu");
		
		// Click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		
		// Add sleep of 5 seconds
		Thread.sleep(5000);
		
		// Get the text
		String contact = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(contact);
		
		// Click on the first match
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
	}

}
