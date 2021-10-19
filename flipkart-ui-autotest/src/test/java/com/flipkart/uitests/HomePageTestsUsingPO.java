package com.flipkart.uitests;

import com.flipkart.pages.HomePage;
import com.flipkart.pages.ResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTestsUsingPO {


    private static final String IPHONE_13 = "iphone 13";
    private WebDriver driver;
    private HomePage homePage;
    private ResultPage resultPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void searchProduct() {
        homePage.goTo("https://www.flipkart.com");
        homePage.closeLoginPopup();
        resultPage = homePage.searchProduct(IPHONE_13);
        assertThat(resultPage.getResults().get(0)).containsIgnoringCase(IPHONE_13);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
