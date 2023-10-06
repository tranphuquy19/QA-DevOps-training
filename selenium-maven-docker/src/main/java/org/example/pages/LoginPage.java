package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(css = "#username")
    WebElement txtEmail;

    @FindBy(css = "#password")
    WebElement txtPassword;

    @FindBy(css = "#submit_btn")
    WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
//        String txtEmail_css = "#user_login";
//        WebElement txtEmail = driver.findElement(By.cssSelector(txtEmail_css));
//        String txtPassword_css = "#user_pass";
//        WebElement txtPassword = driver.findElement(By.cssSelector(txtPassword_css));
//        String btnLogin_css = "#wp-submit";
//        WebElement btnLogin = driver.findElement(By.cssSelector(btnLogin_css));

        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.submit();
    }
}
