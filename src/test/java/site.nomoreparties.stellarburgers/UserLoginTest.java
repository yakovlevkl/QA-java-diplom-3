package site.nomoreparties.stellarburgers;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class UserLoginTest extends DataForTests {
    /*
        Проверь:
           - вход по кнопке «Войти в аккаунт» на главной,
           - вход через кнопку «Личный кабинет»,
           - вход через кнопку в форме регистрации,
           - вход через кнопку в форме восстановления пароля.
    */

    @Test
    @Feature("Вход по кнопке «Войти в аккаунт» на главной")
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void loginViaLogInAccountTest() {
        burgersSite.clickEnterInAccount();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @Test
    @Feature("Вход через кнопку «Личный кабинет»")
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void loginViaPersonalAccountTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @Test
    @Feature("Вход через кнопку в форме регистрации")
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void loginViaRegistrationFormTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickLinkRegistration();
        burgersSite.clickLinkLoginPage();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

    @Test
    @Feature("Вход через кнопку в форме восстановления пароля")
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void loginViaPasswordRecoveryFormTest() {

        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickLinkPasswordRecovery();
        burgersSite.clickLinkLoginFromRecovery();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonEnterOnDisplay();
        burgersSite.buttonPlaceAnOrderOnDisplay();
    }

}
