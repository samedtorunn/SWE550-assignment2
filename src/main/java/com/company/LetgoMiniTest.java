package com.company;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class LetgoMiniTest extends ExecutionContext implements LetgoMini {

    public WebDriver driver;


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
        Duration timeout = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        driver.quit();
    }

}
