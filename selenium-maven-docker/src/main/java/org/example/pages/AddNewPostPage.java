package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewPostPage {
    @FindBy(id = "content_ifr")
    WebElement iframe;

    @FindBy(css = "#post-title-0")
    @CacheLookup //Locator được gọi nhiều lần nếu WebElement được gọi nhiều lần (query many times). Dùng annotation để cacheElement
    WebElement txtTitle;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/div[2]/div[2]/div/p")
    WebElement txtContent;

    @FindBy(css = "#publish")
    WebElement btnSubmit;

    @FindBy(css = "#message a")
    WebElement linkNewPost;

    @FindBy(css = "#edit-slug-box > strong")
    WebElement permalink;

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

    public void gotoDetailPage() {
        linkNewPost.click();
    }
}
