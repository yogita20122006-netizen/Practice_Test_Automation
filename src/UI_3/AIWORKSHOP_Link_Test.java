package UI_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AIWORKSHOP_Link_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://practicetestautomation.com/");
		driver.findElement(By.xpath("//*[@id=\"menu-primary-items\"]")).click();
		System.out.println("AI Workshop link clicked successfully");
        driver.quit();


	}

}
