package com.flipkart.uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class HomePageTests {

    private static final String IPHONE_13 = "iphone 12";

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
    }

    @Test
    public void searchProduct() {
        driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebElement closeButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        closeButton.click();

        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys(IPHONE_13);
        search.sendKeys(Keys.ENTER);

        By resultXpath = By.xpath("(//div[@class='_1YokD2 _3Mn1Gg'])[2]//div[@class='_4rR01T']");

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(15));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(resultXpath, 0));

        List<WebElement> results = driver.findElements(resultXpath);

        Assertions.assertThat(results.get(0).getText()).containsIgnoringCase(IPHONE_13);

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
