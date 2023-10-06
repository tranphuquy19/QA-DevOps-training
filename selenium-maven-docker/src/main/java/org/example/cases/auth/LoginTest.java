package org.example.cases.auth;

import org.example.base.BaseTest;
import org.example.shared.Path;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;
import org.example.shared.User;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    public LoginTest () {
        super("login");
    }

    @Test()
    public void loginWithInvalidUser() throws InterruptedException {
        loginPage = new LoginPage(this.driver);
        loginPage.login(User.getInvalidUsername(), User.getInvalidUserPassword());
        this.waitPageLoading();
        System.out.println("[loginWithInvalidUser] Current URL: " + this.driver.getCurrentUrl());
        Assert.assertTrue(this.driver.getCurrentUrl().endsWith("login"));
    }

    @Test()
    public void loginWithValidUser() throws InterruptedException {
        loginPage = new LoginPage(this.driver);
        System.out.println("User: " + User.getValidUsername());
        System.out.println("Password: " + User.getValidUserPassword());
        loginPage.login(User.getValidUsername(), User.getValidUserPassword());
        this.waitPageLoading();
        System.out.println("[loginWithValidUser] Current URL: " + this.driver.getCurrentUrl());
        Assert.assertTrue(this.driver.getCurrentUrl().endsWith("welcome"));
    }

}
