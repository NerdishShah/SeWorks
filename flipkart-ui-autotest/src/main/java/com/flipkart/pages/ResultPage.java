package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends Page {

    @FindBy(xpath = "(//div[@class='_1YokD2 _3Mn1Gg'])[2]//div[@class='_4rR01T']")
    private List<WebElement> results;

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOfAllElements(results));
    }

    public List<String> getResults() {
        return results.stream().filter(WebElement::isDisplayed).map(WebElement::getText).collect(Collectors.toList());
    }


}
