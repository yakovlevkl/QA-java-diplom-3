package site.nomoreparties.stellarburgers;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest extends DataForTests {
    /*
        Проверь:
           - Успешную регистрацию.
           - Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
     */

    @Before
    public void setUp() {
        getData();
    }

    @Test
    @Feature("Регистрация нового пользователя с валидными данными")
    @DisplayName("Регистрация нового пользователя с валидными данным")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void registrationUser() {
        burgersSite.clickEnterInAccount();
        burgersSite.clickLinkRegistration();
        burgersSite.registrationNewUser(userName, userMail, userPassword);
        burgersSite.buttonEnterOnDisplay();
    }

    @Test
    @Feature("Регистрация нового пользователя с невалидным паролем [5 символов]")
    @DisplayName("Регистрация нового пользователя с невалидным паролем [5 символов]")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void registrationUserBadPassword() {
        burgersSite.clickEnterInAccount();
        burgersSite.clickLinkRegistration();
        burgersSite.registrationNewUser(userName, userMail, "12345");
        burgersSite.messageWrongPasswordOnDisplay();
    }

    @After
    public void rollBck() {
        Allure.attachment("User name: ", userName);
        Allure.attachment("User password: ", userPassword);
        Allure.attachment("User mail: ", userMail);
    }
}
