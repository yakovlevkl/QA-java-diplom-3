package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


class LoginPage extends RegistrationPage {
    // Ссылка на страницу регистрации
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    SelenideElement linkRegistration;

    // кнопка 'ВОЙТИ' в акаунт пользователя
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти')]")
    SelenideElement buttonEnter;

    // Поле почта пользователя
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[1]/div/div/input")
    SelenideElement fieldEmail_;

    // Поле пароль пользователя
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[2]/div/div/input")
    SelenideElement fieldPassword_;

    // Ссылка на страницу восстановления пароля
    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    SelenideElement linkPasswordRecovery;

    @Step("Клик по кнопке Регистрация")
    void clickLinkRegistration() {
        linkRegistration.shouldBe(Condition.visible).click();
    }

    @Step("Клик по кнопке Войти")
    void clickButtonEnter(){
        if (buttonEnter.isDisplayed()) {
            buttonEnter.shouldBe(Condition.visible).click();
        }
    }

    boolean buttonEnterOnDisplay(){
        return buttonEnter.shouldBe(Condition.visible).exists();
    }

    @Step("email: {email}")
    void setEmail_(String email) {
        fieldEmail_.shouldBe(Condition.visible).setValue(email);
    }

    @Step("password: {password}")
    void setPassword_(String password) {
        fieldPassword_.shouldBe(Condition.visible).setValue(password);
    }

    @Step("Регистрируем пользователя")
    void loginUser(String email, String password) {
        setEmail_(email);
        setPassword_(password);
        clickButtonEnter();
    }

    @Step("Клик по кнопке восстановить пароль")
    void clickLinkPasswordRecovery() {
        if (linkPasswordRecovery.isDisplayed()) {
            linkPasswordRecovery.shouldBe(Condition.visible).click();
        }
    }
}
