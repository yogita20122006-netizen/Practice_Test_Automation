package UI_3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavBar_display_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ChromeDriver driver = new ChromeDriver();
         driver.get("https://practicetestautomation.com/");
	     driver.manage().window().maximize();
         driver.findElement(By.tagName("nav"));
         System.out.println("Test Passed: Navigation Bar is displayed");

         driver.quit();
     }
 }


