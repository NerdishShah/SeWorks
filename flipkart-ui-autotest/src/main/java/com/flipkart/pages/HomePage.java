package com.flipkart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

    private WebDriver driver;
    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;
    @FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
    private WebElement closeLogin;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ResultPage searchProduct(String productName) {
        super.type(this.search, productName);
        super.keypress(this.search, Keys.ENTER);
        return new ResultPage(driver);
    }

    public void goTo(String url) {
        super.get(url);
    }

    public void closeLoginPopup() {
        super.click(this.closeLogin);
    }

}
