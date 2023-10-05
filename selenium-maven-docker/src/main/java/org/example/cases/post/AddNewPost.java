package org.example.cases.post;

import org.example.base.BaseTest;
import org.example.shared.Path;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.AddNewPostPage;
import org.example.pages.LoginPage;
import org.example.shared.User;

public class AddNewPost extends BaseTest {
    private AddNewPostPage postPage;

    public AddNewPost() {
        super("wp-login.php");
    }

    @BeforeMethod()
    public void beforeMethod() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login(User.getValidUsername(), User.getValidUserPassword());
    }

    @Test()
    public void addNewPost() throws InterruptedException {
        this.driver.get(Path.join(this.BASE_URL, "wp-admin/post-new.php"));
        AddNewPostPage addNewPostPage = new AddNewPostPage(this.driver);
        addNewPostPage.addNewPost("Test title", "Test Content");
        Thread.sleep(10_000);
        addNewPostPage.gotoDetailPage();
        Thread.sleep(10_000);
    }

}
