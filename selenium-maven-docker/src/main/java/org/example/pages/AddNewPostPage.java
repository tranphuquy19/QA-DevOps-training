package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewPostPage {
    @FindBy(css = "#title")
    @CacheLookup //Locator được gọi nhiều lần nếu WebElement được gọi nhiều lần (query many times). Dùng annotation để cacheElement
    WebElement txtTitle;

    @FindBy(css = "#body")
    WebElement txtContent;

    @FindBy(css = "#submit-btn")
    WebElement btnSubmit;

    WebDriver driver;
    WebDriverWait waiter;

    public AddNewPostPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void addNewPost(String title, String content) {
//        txtTitle.click();
        txtTitle.sendKeys(title);

//        txtContent.click();
        txtContent.sendKeys(content);

        btnSubmit.submit();
    }
}
