package UI_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Image_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://practicetestautomation.com/");
		driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]")).click();
		System.out.println("Image Tested Successfully");
        driver.quit();

	}

}
