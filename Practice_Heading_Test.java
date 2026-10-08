package UI_1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Heading_Test {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        
        driver.get("https://www.google.com");
        driver.navigate().to("https://practicetestautomation.com/practice/");
        driver.findElement(By.tagName("h1"));
        System.out.println("Practice heading checked successfully");
        driver.quit();
    }
}
