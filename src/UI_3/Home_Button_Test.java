package UI_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Home_Button_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://practicetestautomation.com/");
		driver.findElement(By.xpath("//*[@id=\"menu-item-43\"]/a")).click();
		System.out.println("Home button clicked successfully");
        driver.quit();

	}

}

properties pr= new properties();
FileInputStream fs= new FileInputStream("")
pr.load(fs);
System.out.println(pr.getProperty())
