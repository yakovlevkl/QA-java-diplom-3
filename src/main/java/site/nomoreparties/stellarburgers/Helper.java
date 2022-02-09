package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class Helper {
   static ThreadLocal<Object> driver = new ThreadLocal<>();
    String userName;
    String userPassword;
    String userMail;
    ConstructorPage burgersSite;

    public WebDriver getDriver() {
        return (WebDriver) driver.get();
    }

    public MutableCapabilities capabilities;

    public Helper() {
        this.capabilities = new ChromeOptions();
    }

    @Before
    public void setUp() throws Exception {
        RemoteWebDriver webDriver = new RemoteWebDriver(
                new URL("http://62.84.123.154:4444/wd/hub"),
                capabilities);
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.set(webDriver);


        // chrome, edge, firefox
        Configuration.holdBrowserOpen = false;
        String typeBrowser = "chrome";
        System.setProperty("selenide.browser", typeBrowser);
        Configuration.browser = typeBrowser;
        Configuration.startMaximized = true;
        Configuration.headless = true;
        Configuration.baseUrl = "http://62.84.123.154:4444/wd/hub";
        Configuration.reportsUrl = "http://62.84.123.154:4444";
        burgersSite = open(
                 "https://stellarburgers.nomoreparties.site/", ConstructorPage.class);
        //WebDriver burgersSite = getDriver();
        //burgersSite.navigate().to("https://stellarburgers.nomoreparties.site/");

        // fake user
        Faker faker = new Faker();
        userName = faker.name().firstName(); // Emory
        userPassword = faker.name().lastName() + "12345"; // Barton
        userMail = userName + "." + userPassword + "@ya.ru"; // Emory.Barton@ya.ru


    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

}
