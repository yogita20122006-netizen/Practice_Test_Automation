package UI_1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_login_page {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://practicetestautomation.com/practice");
	    driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a")).click();
		System.out.println("Test_login_page clicked successfully");
        driver.quit();

	}

}