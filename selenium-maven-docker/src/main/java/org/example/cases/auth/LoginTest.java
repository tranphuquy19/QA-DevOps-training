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
        super("wp-login.php");
    }

    @Test()
    public void loginWithInvalidUser() throws InterruptedException {
        loginPage = new LoginPage(this.driver);
        loginPage.login(User.getInvalidUsername(), User.getInvalidUserPassword());
        Thread.sleep(1_000);
        Assert.assertNotEquals(this.driver.getCurrentUrl(), Path.join(this.BASE_URL, "wp-admin/"));
    }

    @Test()
    public void loginWithValidUser() throws InterruptedException {
        loginPage = new LoginPage(this.driver);
        loginPage.login(User.getValidUsername(), User.getValidUserPassword());
        Thread.sleep(1_000);
        Assert.assertEquals(this.driver.getCurrentUrl(), Path.join(this.BASE_URL, "wp-admin/"));
    }

}
