package UI_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Open Test Login Page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username
        driver.findElement(By.id("username")).sendKeys("student");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click Submit
        driver.findElement(By.id("submit")).click();

        // Verify successful login
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("logged-in-successfully")) {
            System.out.println("PASS: Login successful.");
        } else {
            System.out.println("FAIL: Login unsuccessful.");
        }

        // Keep browser open for checking
        // driver.quit();
    }
}