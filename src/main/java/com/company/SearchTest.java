package com.company;

import org.graphwalker.java.annotation.*;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertTrue;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class SearchTest extends ExecutionContext implements Search {

    public WebDriver driver;

    @Override
    public void v_ProductPage(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        WebElement itemTitle = driver.findElement(By.cssSelector("h1[data-aut-id='itemTitle']"));
        String titleText = itemTitle.getText();
        System.out.println(titleText);

        if(currentUrl.contains("sandalye")){
            System.out.println("evet url sandalye içeriyor.");
        } else {
            driver.quit();
        }

        if(titleText.contains("sandalye")){
            System.out.println("evet title sandalye içeriyor.");
        } else {
            driver.quit();
        }
    }

    @Override
    public void v_SearchResults(){

    }

    @Override
    public void e_clickHome(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement logo = driver.findElement(By.cssSelector("a[data-aut-id='btnOlxLogo']"));
        logo.click();


    }

    @Override
    public void e_clickProduct(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Locate the itemBox element
        WebElement firstItemImage = driver.findElement(By.cssSelector("figure[data-aut-id='itemImage']"));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        firstItemImage.click();
        System.out.println("Clicked on the ItemImage element.");

    }


    @Override
    public void e_searchKeyword(){
        // locate the search box element
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized");
        }

        // locate the search box element
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchBox = driver.findElement(By.cssSelector("input[data-aut-id='searchBox']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // enter a search query
        searchBox.sendKeys("sandalye");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchBox.sendKeys(Keys.ENTER);


    }

    @Override
    public void e_openHomePage() {
        // Implement the code to perform the action of this edge
        driver.get("https://www.letgo.com/");
    }

    @Override
    public void v_Start() {
        System.setProperty("webdriver.chrome.driver", "/Users/hemenyolda/Desktop/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Override
    public void v_HomePage() {
        Duration timeout = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, timeout);

    }
}
