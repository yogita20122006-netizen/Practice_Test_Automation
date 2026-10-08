
package UI_1;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_Table {

    static WebDriver driver;
    static String url = "https://practicetestautomation.com/practice-test-table/";

    static void openPage() {
        driver.get(url);
    }

    static List<WebElement> rows() {
        return driver.findElements(By.xpath("//table/tbody/tr"));
    }

    static void result(String test, boolean pass) {
        System.out.println(test + (pass ? " PASS" : " FAIL"));
    }

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // TC1: Verify Table
        openPage();
        result("TC1: Table Display", driver.findElement(By.tagName("table")).isDisplayed());

        // TC2: Verify Beginner Filter
        openPage();
        ((org.openqa.selenium.JavascriptExecutor) driver)
        .executeScript("arguments[0].click();",
        driver.findElement(By.xpath("//label[normalize-space()='Intermediate']")));
        driver.findElement(By.xpath("//label[normalize-space()='Advanced']")).click();

        boolean pass = true;
        for (WebElement r : rows()) {
            if (!r.findElement(By.xpath("./td[4]")).getText().equals("Beginner"))
                pass = false;
        }
        result("TC2: Beginner Filter", pass);

        // TC3: Minimum Enrollment 10,000+
        openPage();
        new Select(driver.findElements(By.tagName("select")).get(0))
                .selectByVisibleText("10,000+");

        pass = true;
        for (WebElement r : rows()) {
            int n = Integer.parseInt(r.findElement(By.xpath("./td[5]"))
                    .getText().replace(",", ""));
            if (n < 10000) pass = false;
        }
        result("TC3: Enrollment Filter", pass);

        // TC4: Python + Beginner + 10,000+
        openPage();
        driver.findElement(By.xpath("//label[normalize-space()='Python']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Intermediate']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Advanced']")).click();

        new Select(driver.findElements(By.tagName("select")).get(0))
                .selectByVisibleText("10,000+");

        pass = !rows().isEmpty();
        for (WebElement r : rows()) {
            int n = Integer.parseInt(r.findElement(By.xpath("./td[5]"))
                    .getText().replace(",", ""));
            if (!r.findElement(By.xpath("./td[3]")).getText().equals("Python")
                    || !r.findElement(By.xpath("./td[4]")).getText().equals("Beginner")
                    || n < 10000) pass = false;
        }
        result("TC4: Combined Filter", pass);

        // TC5: No Results
        openPage();
        driver.findElement(By.xpath("//label[normalize-space()='Python']")).click();
        new Select(driver.findElements(By.tagName("select")).get(0))
                .selectByVisibleText("50,000+");

        result("TC5: No Results", driver.getPageSource().contains("No matching courses."));

        // TC6: Reset Button
        openPage();
        driver.findElement(By.xpath("//label[normalize-space()='Python']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();

        result("TC6: Reset", rows().size() == 9);

        // TC7: Sort by Enrollment
        openPage();
        new Select(driver.findElements(By.tagName("select")).get(1))
                .selectByVisibleText("Enrollments");

        pass = true;
        int previous = 0;
        for (WebElement r : rows()) {
            int n = Integer.parseInt(r.findElement(By.xpath("./td[5]"))
                    .getText().replace(",", ""));
            if (n < previous) pass = false;
            previous = n;
        }
        result("TC7: Enrollment Sort", pass);

        // TC8: Sort by Course Name
        openPage();
        new Select(driver.findElements(By.tagName("select")).get(1))
                .selectByVisibleText("Course Name");

        pass = true;
        List<String> names = new ArrayList<>();
        for (WebElement r : rows())
            names.add(r.findElement(By.xpath("./td[2]")).getText());

        List<String> sorted = new ArrayList<>(names);
        sorted.sort(String.CASE_INSENSITIVE_ORDER);

        result("TC8: Course Name Sort", names.equals(sorted));

        //driver.quit();
    }
}