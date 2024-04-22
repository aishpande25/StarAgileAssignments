package org.example;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonUsingEdgeBrowser {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.edge.driver", "D:\\SeleniumSoft\\Driver_Notes\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();

        WebElement ddown = driver.findElement(By.cssSelector("select#searchDropdownBox"));
        Select select = new Select(ddown);
        select.selectByVisibleText("Electronics");
        driver.findElement(By.id("nav-search-submit-button")).click();

        TakesScreenshot tc = (TakesScreenshot) driver;
        File src = tc.getScreenshotAs(OutputType.FILE);
        File login = new File(".\\images\\Amazon.png");
        FileUtils.copyFile(src, login);
    }
}


