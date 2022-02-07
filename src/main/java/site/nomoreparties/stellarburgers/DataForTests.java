package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.open;

class DataForTests {

    String userName;
    String userPassword;
    String userMail;
    ConstructorPage burgersSite;

    void getData() {
        // chrome, edge, firefox
        Configuration.holdBrowserOpen = false;
        String typeBrowser = "chrome";
        System.setProperty("selenide.browser", typeBrowser);
        Configuration.browser = typeBrowser;
        Configuration.startMaximized = true;
        Configuration.headless = true;
        burgersSite = open("https://stellarburgers.nomoreparties.site/", ConstructorPage.class);
        // fake user
        Faker faker = new Faker();
        userName = faker.name().firstName(); // Emory
        userPassword = faker.name().lastName() + "12345"; // Barton
        userMail = userName + "." + userPassword + "@ya.ru"; // Emory.Barton@ya.ru
    }
}
