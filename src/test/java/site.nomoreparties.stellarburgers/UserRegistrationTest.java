package site.nomoreparties.stellarburgers;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class UserRegistrationTest extends DataForTests {
    /*
        Проверь:
           - Успешную регистрацию.
           - Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
     */

    @Test
    @Feature("Регистрация нового пользователя с валидными данными")
    @DisplayName("Регистрация нового пользователя с валидными данным")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void registrationUser() {
        burgersSite.clickEnterInAccount();
        burgersSite.clickLinkRegistration();
        burgersSite.registrationNewUser(userName + "1", userEmail + "c", userPassword);
        burgersSite.buttonEnterOnDisplay();
    }

    @Test
    @Feature("Регистрация нового пользователя с невалидным паролем [5 символов]")
    @DisplayName("Регистрация нового пользователя с невалидным паролем [5 символов]")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void registrationUserBadPassword() {
        burgersSite.clickEnterInAccount();
        burgersSite.clickLinkRegistration();
        userPassword = "12345";
        burgersSite.registrationNewUser(userName, userEmail, userPassword);
        burgersSite.messageWrongPasswordOnDisplay();
    }
}
