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
import org.apache.commons.text.*;
import java.text.Normalizer;


import java.text.Normalizer;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertTrue;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class SlugandTitleTest extends ExecutionContext implements SlugandTitle {


    public WebDriver driver;
    public WebElement itemTitle;
    public String slug;
    public String passingTitle;

    public int counter = 0;

    @Override
    public void v_ProductPage(){

        System.out.println("Entered the product page");
        System.out.println(passingTitle);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        System.out.println(title);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(title.contains(passingTitle)){
            System.out.println("evet title ürün başlığını içeriyor.");
        } else {
            driver.quit();
        }
    }

    @Override
    public void e_openHome(){
        driver.get("https://www.letgo.com/");
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
        counter = counter + 1;
    }

    @Override
    public void e_clickProduct(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Locate the itemBox element
        List<WebElement> itemTitles = driver.findElements(By.cssSelector("span[data-aut-id='itemTitle']"));
        WebElement theItemTitle = itemTitles.get(counter);


        String titleText = theItemTitle.getText();
        passingTitle = titleText;

        theItemTitle.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void v_Start(){
        System.setProperty("webdriver.chrome.driver", "/Users/hemenyolda/Desktop/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Override
    public void v_HomePage(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("We are at homepage!");
        if (counter == 5) {
            driver.quit();
        }
    }





}
