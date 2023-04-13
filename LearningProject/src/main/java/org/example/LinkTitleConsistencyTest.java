package org.example;

import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.test.TestExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


@GraphWalker(value = "random(edge_coverage(100))", start = "v_HomePage")
@Model(file = "LinkTitleConsistency.json")
public class LinkTitleConsistencyTest {

    public WebDriver driver;
    public LinkTitleConsistency graph;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/hemenyolda/Desktop/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        graph = new LinkTitleConsistency() {

            @Override
            public void v_Phones() {

            }

            @Override
            public void v_ProductPage() {

            }

            @Override
            public void e_clickProduct() {

            }

            @Override
            public void v_HomePage() {

            }

            @Override
            public void e_clickHouseholds() {

            }

            @Override
            public void e_clickPhones() {

            }

            @Override
            public void v_Household() {

            }

            @Override
            public void v_Motorbikes() {

            }

            @Override
            public void e_clickHome() {

            }

            @Override
            public void e_clickElectronics() {

            }

            @Override
            public void e_clickMotorbikes() {

            }

            @Override
            public void v_Cars() {

            }

            @Override
            public void v_Electronics() {

            }

            @Override
            public void e_clickCars() {

            }
        };
    }

    @AfterExecution
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void testLinkTitleConsistency() throws IOException {
        driver.get("https://letgo.com");
        new TestExecutor(LinkTitleConsistencyTest.class).execute();
    }
}
