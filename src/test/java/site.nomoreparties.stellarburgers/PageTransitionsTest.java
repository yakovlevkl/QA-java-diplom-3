package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PageTransitionsTest extends DataForTests {
    /*
    Проверь:
        Переход в личный кабинет
            - Проверь переход по клику на «Личный кабинет».
        Переход из личного кабинета в конструктор
            - Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
        Выход из аккаунта
            - Проверь выход по кнопке «Выйти» в личном кабинете.
*/
    @Test
    @Feature("Переход в личный кабинет по клику на «Личный кабинет», затем клик на на «Конструктор»")
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет», затем клик на на «Конструктор»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void transitionToConstructorTest() {
        burgersSite.clickEnterInAccount();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonPlaceAnOrderOnDisplay();
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickConstructor();
    }

    @Test
    @Feature("Переход в личный кабинет по клику на «Личный кабинет», затем клик на логотип Stellar Burgers")
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет», затем клик на логотип Stellar Burgers")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void transitionFromLogoTest() {
        burgersSite.clickEnterInAccount();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonPlaceAnOrderOnDisplay();
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickLinkMainPage();
    }

    @Test
    @Feature("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void logoutTest() {
        burgersSite.clickEnterInAccount();
        burgersSite.loginUser(userEmail, userPassword);
        burgersSite.buttonPlaceAnOrderOnDisplay();
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickButtonExit();
    }
}
