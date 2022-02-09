package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class PageTransitionsTest extends Helper {
    /*
    Проверь:
        Переход в личный кабинет
            - Проверь переход по клику на «Личный кабинет».
        Переход из личного кабинета в конструктор
            - Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
        Выход из аккаунта
            - Проверь выход по кнопке «Выйти» в личном кабинете.
*/
    @Before
    public void setUp_() {

        // user
        userName = "Emogene";
        userPassword = "123456";
        userMail = "Emogene.Ebert@ya.ru";
        // логинимся зарегестрированным пользователем
        burgersSite.clickEnterInAccount();
        burgersSite.loginUser(userMail, userPassword);
        burgersSite.buttonEnterOnDisplay();
    }

    @Test
    @Feature("Переход в личный кабинет по клику на «Личный кабинет», затем клик на на «Конструктор»")
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет», затем клик на на «Конструктор»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void transitionToConstructorTest() {
        burgersSite.buttonPlaceAnOrderOnDisplay();
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickConstructor();
    }

    @Test
    @Feature("Переход в личный кабинет по клику на «Личный кабинет», затем клик на логотип Stellar Burgers")
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет», затем клик на логотип Stellar Burgers")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void transitionFromLogoTest() {
        burgersSite.buttonPlaceAnOrderOnDisplay();
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickLinkMainPage();
    }

    @Test
    @Feature("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void logoutTest() {
        burgersSite.buttonPlaceAnOrderOnDisplay();
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickButtonExit();
    }

    @After
    public void rollBck() {
        Selenide.closeWebDriver();
        Allure.attachment("User name: ", userName);
        Allure.attachment("User password: ", userPassword);
        Allure.attachment("User mail: ", userMail);
    }
}
