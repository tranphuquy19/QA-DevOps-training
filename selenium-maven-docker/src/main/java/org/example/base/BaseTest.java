package org.example.base;

import org.example.shared.Config;
import org.example.shared.Path;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.shared.ConfigLoader;

import java.time.Duration;
import java.util.Objects;

public class BaseTest {
    protected WebDriver driver;

    protected String BASE_URL = "";
    protected String URL = "";
    protected Config configInstance;

    private String CHROME_PATH = "";
    private String CHROME_DRIVE_PATH = "";
    private final String[] chromeOptions = {"--disable-notifications", "--window-size=1300,900"};

    protected void waitPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public BaseTest() {

    }

    public BaseTest(String pathUrl) {
        ConfigLoader.loadFromEnvVar();
        Config configInstance = Config.getInstance();
        this.BASE_URL = configInstance.getVariable("BASE_URL");
        this.URL = Path.join(this.BASE_URL, pathUrl);
        System.out.println("URL: " + URL);
        this.CHROME_PATH = configInstance.getVariable("CHROME_PATH");
        this.CHROME_DRIVE_PATH = configInstance.getVariable("CHROME_DRIVER_PATH");
    }

    public BaseTest(String baseUrl, String pathUrl) {
        this.URL = Path.join(baseUrl, pathUrl);
    }

    @BeforeMethod()
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();

        if (!Objects.equals(this.CHROME_PATH, "") && this.CHROME_PATH != null) {
            options.setBinary(this.CHROME_PATH);
        }

        if (Objects.equals(Config.getInstance().getVariable("ENV"), "docker")) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
        } else {
            for (String option : this.chromeOptions) {
                options.addArguments(option);
            }
        }

        System.setProperty("webdriver.chrome.driver", this.CHROME_DRIVE_PATH);
        driver = new ChromeDriver(options);
        System.out.println("URL: " + URL);
        driver.get(URL);
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
