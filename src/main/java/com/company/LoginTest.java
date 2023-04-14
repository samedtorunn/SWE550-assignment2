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
public class LoginTest extends ExecutionContext implements Login {

    public WebDriver driver;

    @Override
    public void e_correctInputs(){
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-aut-id='btnLogin']"));
        loginButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Email ile giriş
        WebElement emailLoginButton = driver.findElement(By.cssSelector("button[data-aut-id='emailLogin']"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        emailLoginButton.click();
        if (emailLoginButton != null) {
            emailLoginButton.click();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Email inputu gir
        WebElement emailInput = driver.findElement(By.id("email_input_field"));
        emailInput.sendKeys("samedtorunn@gmail.com");
        emailInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement passwordField = driver.findElement(By.id("password"));

        if(passwordField != null) {
            passwordField.sendKeys("others123");
            emailInput.sendKeys(Keys.ENTER);
        } else {
            System.out.println("Could not test it with a bot.");
            WebElement closeButton = driver.findElement(By.cssSelector("span[data-aut-id='btnClose']"));
            closeButton.click();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void e_falseInputs(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-aut-id='btnLogin']"));
        loginButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Email inputu gir
        WebElement emailInput = driver.findElement(By.id("email_input_field"));
        emailInput.sendKeys("asdfghjk@asdfghjk.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emailInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kampanyalara izin ver
        WebElement marketingCheckbox = driver.findElement(By.id("marketing_email"));
        if (marketingCheckbox == null) {
            System.out.println("Could not pass bot wall");
        } else {
        marketingCheckbox.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // KVKK Aydınlatma metni
        WebElement dataPrivacyCheckbox = driver.findElement(By.id("data_privacy_tnc"));
        dataPrivacyCheckbox.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement continue_button = driver.findElement(By.cssSelector("button[data-aut-id=''][class*='rui-3mpqt']"));
        continue_button.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement otpBox1 = driver.findElement(By.cssSelector("input[data-aut-id='otp-box-1']"));
        otpBox1.sendKeys("0"); // Replace "1" with the digit you want to enter

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement otpBox2 = driver.findElement(By.cssSelector("input[data-aut-id='otp-box-2']"));
        otpBox2.sendKeys("0");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement otpBox3 = driver.findElement(By.cssSelector("input[data-aut-id='otp-box-3']"));
        otpBox3.sendKeys("0");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement otpBox4 = driver.findElement(By.cssSelector("input[data-aut-id='otp-box-4']"));
        otpBox4.sendKeys("0");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement svgIcon = driver.findElement(By.cssSelector("svg[data-aut-id='icon']"));
        svgIcon.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
        WebElement closeButton = driver.findElement(By.cssSelector("span[data-aut-id='btnClose']"));
        closeButton.click();

    }

    @Override
    public void e_openHome(){
        driver.get("https://www.letgo.com/");
    }

    @Override
    public void v_Start(){
        System.setProperty("webdriver.chrome.driver", "/Users/hemenyolda/Desktop/chromedriver_mac64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Override
    public void v_LoggedIn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.cssSelector("[data-aut-id='iconProfile'] svg[data-aut-id='icon']"));
        element.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element2 = driver.findElement(By.cssSelector("span[data-aut-id='btnProfileLogout']"));

        if(element2 != null) {
            System.out.println("We are logged in!");
        } else {
            System.out.println("I think we could not login, bye");
            driver.quit();
        }

    }

    @Override
    public void e_logOut(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = driver.findElement(By.cssSelector("[data-aut-id='iconProfile'] svg[data-aut-id='icon']"));
        element.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement element2 = driver.findElement(By.cssSelector("span[data-aut-id='btnProfileLogout']"));
        element2.click();
    }

    @Override
    public void v_HomePage(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement login_button = driver.findElement(By.cssSelector("button[data-aut-id='btnLogin']"));
        if (login_button != null) {
            System.out.println("We are on homepage!");
        } else {
            driver.quit();
        }

    }


}