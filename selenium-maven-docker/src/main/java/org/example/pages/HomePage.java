package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    private static final String messageIcon_xpath = "/html/body/div[1]/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[2]/span";
    private static final String messageDropdown_css = "div[class='l9j0dhe7'][data-testid='mwthreadlist-item']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMessageDropdown() {
        WebElement btnMessageIcon = driver.findElement(By.xpath(messageIcon_xpath));
        btnMessageIcon.click();
    }
}
