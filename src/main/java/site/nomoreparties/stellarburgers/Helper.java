package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class Helper {
   private static ThreadLocal<Object> driver = new ThreadLocal<>();
    String userName;
    String userPassword;
    String userMail;
    ConstructorPage burgersSite;

    private WebDriver getDriver() {
        return (WebDriver) driver.get();
    }

    private MutableCapabilities capabilities;

    Helper() {
        this.capabilities = new ChromeOptions();
    }

    @Before
    public void setUp() throws Exception {

        RemoteWebDriver webDriver = new RemoteWebDriver(
                new URL("http://10.74.24.173:4444/wd/hub"),
                this.capabilities);
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.set(webDriver);


        // chrome, edge, firefox
        //Configuration.holdBrowserOpen = false;
        String typeBrowser = "chrome";
        System.setProperty("selenide.browser", typeBrowser);
        Configuration.browser = typeBrowser;
        Configuration.headless = false;
        Configuration.baseUrl = "https://stellarburgers.nomoreparties.site/";
        Configuration.reportsUrl = "http://10.74.24.173:4444";

        //Url удалённого веб драйвера
        Configuration.remote = "http://10.74.24.173:4444/wd/hub";
        //Размер окна браузера
        Configuration.browserSize = "1920x1080";
        //Создаём объект класса DesiredCapabilities, используется как настройка  вашей конфигурации с помощью пары ключ-значение
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Включить поддержку отображения экрана браузера во время выполнения теста
        capabilities.setCapability("enableVNC", true);
        //Включение записи видео в процессе выполнения тестов
        capabilities.setCapability("enableVideo", true);
        //Переопределяем Browser capabilities
        Configuration.browserCapabilities = capabilities;

        burgersSite = open(
                "https://stellarburgers.nomoreparties.site/", ConstructorPage.class);

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
