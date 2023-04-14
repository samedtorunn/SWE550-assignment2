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

@GraphWalker(value = "random(edge_coverage(100))", start = "v_StartHere")
public class LinkandTitleTest extends ExecutionContext implements LinkandTitle {

    private boolean isCarsChecked = false;
    private boolean isPhonesChecked = false;
    private boolean isMotorbikesChecked = false;
    private boolean isHouseholdChecked = false;
    private boolean isElectronicsChecked = false;

    public WebDriver driver;


    @Override
    public  void v_Phones() {
        //1 URL Testi
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("telefon")){
            //System.out.println("evet url telefon içeriyor.");
        } else {
            driver.quit();
        }

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.className("_1ojKB"));
        String text = element.getText();
        boolean isTextIncluded;
        if (text.contains("Telefon")) isTextIncluded = true;
        else isTextIncluded = false;
        isPhonesChecked = true;
    }

    @Override
    public  void v_StartHere(){
        System.setProperty("webdriver.chrome.driver", "/Users/hemenyolda/Desktop/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Override
    public  void e_openHome(){
        driver.get("https://www.letgo.com/");
    }

    @Override
    public  void v_HomePage(){
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ((isHouseholdChecked == true) && (isMotorbikesChecked == true) && (isCarsChecked == true) && (isPhonesChecked == true) && (isElectronicsChecked == true)){
            driver.quit();
        }
    }

    @Override
    public  void e_clickHousehold(){
        if (isElectronicsChecked == false) {
            WebElement householdLink = driver.findElement(By.xpath("//span[@data-aut-id='header_link' and text()='Ev Eşyaları']"));
            householdLink.click();
        }
    }
    @Override
    public void e_clickPhones(){
        if (isPhonesChecked == false) {
            WebElement phoneLink = driver.findElement(By.xpath("//span[@data-aut-id='header_link' and text()='Telefon']"));
            phoneLink.click();
        }
    }
    @Override
    public void v_Household(){
        //1 URL Testi
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("ev-esyalari")){
            //System.out.println("evet url ev-esyalari içeriyor.");
        } else {
            driver.quit();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.className("_1ojKB"));
        String text = element.getText();
        boolean isTextIncluded;
        if (text.contains("Ev Eşyaları")) isTextIncluded = true;
        else isTextIncluded = false;


        isHouseholdChecked = true;
    }

    @Override
    public   void v_Motorbikes(){
        //1 URL Testi
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("motosiklet")){
            System.out.println("evet url motosiklet içeriyor.");
        } else {
            driver.quit();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.className("_1ojKB"));
        String text = element.getText();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isTextIncluded;
        if (text.contains("Motosiklet")) isTextIncluded = true;
        else isTextIncluded = false;
        isMotorbikesChecked = true;
    }

    @Override
    public void e_clickHome(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Clicked on Home!");

        WebElement logo = driver.findElement(By.cssSelector("a[data-aut-id='btnOlxLogo']"));
        logo.click();
    }

    @Override
    public void e_clickElectronics(){
        if (isElectronicsChecked == false){
            WebElement elektronikLink = driver.findElement(By.xpath("//span[@data-aut-id='header_link' and text()='Elektronik']"));
            elektronikLink.click();
        }
    }

    @Override
    public void e_clickMotorbikes(){
        if (isMotorbikesChecked == false) {
            WebElement motosikletLink = driver.findElement(By.xpath("//span[@data-aut-id='header_link' and text()='Motosiklet']"));
            motosikletLink.click();
        }
    }

    @Override
    public void v_Cars(){
        //1 URL Testi
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("araba")){
            System.out.println("evet url araba içeriyor.");
        } else {
            driver.quit();
        }

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.className("_1ojKB"));
        String text = element.getText();
        // boolean isTextIncluded = text.contains("Araba");


        isCarsChecked = true;

    }

    @Override
    public void v_Electronics(){
        //1 URL Testi
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("elektronik")){
            System.out.println("evet url elektronik içeriyor.");
        } else {
            driver.quit();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.className("_1ojKB"));
        String text = element.getText();

        boolean isTextIncluded;
        if (text.contains("Elektronik")) {
            isTextIncluded = true;
        }
        else {
            isTextIncluded = false;
            System.out.println("Bu title ile kategori uyumsuz ");
        }

        isElectronicsChecked = true;
    }
    @Override
    public void e_clickCars(){
        if (isCarsChecked == false) {
            WebElement arabaLink = driver.findElement(By.xpath("//span[@data-aut-id='header_link' and text()='Araba']"));
            arabaLink.click();
        }
    }
}



