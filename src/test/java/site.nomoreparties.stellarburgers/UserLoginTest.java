package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserLoginTest extends DataForTests {
    /*
        Проверь:
           - вход по кнопке «Войти в аккаунт» на главной,
           - вход через кнопку «Личный кабинет»,
           - вход через кнопку в форме регистрации,
           - вход через кнопку в форме восстановления пароля.
    */
    @Before
    public void setUp() {
        getData();
        // user
        userName = "Emogene";
        userPassword = "123456";
        userMail = "Emogene.Ebert@ya.ru";
    }

    @Test
    @Feature("Вход по кнопке «Войти в аккаунт» на главной")
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void LoginViaLogInAccountTest() {
        burgersSite.clickEnterInAccount();
        burgersSite.loginUser(userMail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @Test
    @Feature("Вход через кнопку «Личный кабинет»")
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void LoginViaPersonalAccountTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.loginUser(userMail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @Test
    @Feature("Вход через кнопку в форме регистрации")
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void LoginViaRegistrationFormTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickLinkRegistration();
        burgersSite.clickLinkLoginPage();
        burgersSite.loginUser(userMail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @Test
    @Feature("Вход через кнопку в форме восстановления пароля")
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void LoginViaPasswordRecoveryFormTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickLinkPasswordRecovery();
        burgersSite.clickLinkLoginFromRecovery();
        burgersSite.loginUser(userMail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @After
    public void rollBck() {
        Selenide.closeWebDriver();
        Allure.attachment("User name: ", userName);
        Allure.attachment("User password: ", userPassword);
        Allure.attachment("User mail: ", userMail);
    }
}
