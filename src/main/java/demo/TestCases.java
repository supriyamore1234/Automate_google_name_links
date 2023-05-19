package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase04() throws InterruptedException {
        // navigate google url
        driver.get("https://www.google.com/");
        // go to search tab Using Locator "Name" q
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.name("q"));
        // enter name supriya
        search.sendKeys("supriya");
        // press ENTER key from keyboard supriya
        search.sendKeys(Keys.ENTER);
        // Wait for the search results to load. Thread.sleep(3000)
        Thread.sleep(5000);
        // find all search result links Using Locator "Tag Name" h3
        List<WebElement> resultLinks = driver.findElements(By.tagName("h3"));

        // Iterate through each search result link:
        List<String> ar = new ArrayList<String>();
        for (WebElement iterable_element : resultLinks) {
            String ar_ = iterable_element.getText().toString();
            ar.add(ar_);
        }
        // Check if the link contains your name.
        int count = 0;
        // If it does, increment the count variable.
        for (String ar1 : ar) {
            if (ar1.contains("supriya")) {
                count++;
            }

        }
        // Print the count of links with your name.
        System.out.println("Lint count containing name SUPRIYA is " + count);

        // Close the web browser.
        driver.close();
    }
}
