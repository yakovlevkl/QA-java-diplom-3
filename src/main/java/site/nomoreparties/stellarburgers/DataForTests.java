package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

class DataForTests extends BaseUrls{

    String userName;
    String userPassword;
    String userEmail;
    ConstructorPage burgersSite;
    private CreateDeleteUser user;

    private void configBrowser() {
        // chrome, edge, firefox
        Configuration.holdBrowserOpen = false;
        String typeBrowser = "edge";
        System.setProperty("selenide.browser", typeBrowser);
        Configuration.browser = typeBrowser;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        burgersSite = open(getSiteUrl(), ConstructorPage.class);
    }
    private void generateUserData(){
        // fake user
        Faker faker = new Faker();
        userName = faker.name().firstName(); // Emory
        userPassword = faker.name().lastName() + "12345"; // Barton
        userEmail = userName + "." + userPassword + "@ya.ru"; // Emory.Barton@ya.ru


        // Создаем пользователя, запоминаем токен доступа.
        user = new CreateDeleteUser(userPassword, userName, userEmail);
        user.getResponse();
    }

    @Before
    public void getData() {
        //Настройка параметров браузера
        configBrowser();
        //Генерация данных уникального пользователя
        generateUserData();
    }

    @After
    public void rollBck() {
        Selenide.closeWebDriver();
        Allure.attachment("User name: ", userName);
        Allure.attachment("User password: ", userPassword);
        Allure.attachment("User mail: ", userEmail);
        user.delete();
    }
}
