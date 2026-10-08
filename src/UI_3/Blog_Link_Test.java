package UI_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Blog_Link_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://practicetestautomation.com/");
		driver.findElement(By.xpath("//*[@id=\"menu-item-19\"]/a")).click();
		System.out.println("Blog link clicked successfully");
        driver.quit();


	}

}
