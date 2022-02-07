package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



class RegistrationPage extends PasswordRecoveryPage {
    // Кнопка регистрации
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    SelenideElement buttonRegistration;

    // Поле имя пользователя
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[1]/div/div/input")
    SelenideElement fieldName;

    // Поле почта пользователя
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[2]/div/div/input")
    SelenideElement fieldEmail;

    // Поле пароль пользователя
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[3]/div/div/input")
    SelenideElement fieldPassword;

    // Сообщение о существующем пользователе
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Такой пользователь уже существует')]")
    SelenideElement messageExistUser;

    // Сообщение о некорректном пароле
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Некорректный пароль')]")
    SelenideElement messageWrongPassword;

    // Ссылка на страницу входа
    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    SelenideElement linkLoginPage;

    void setName(String nameUser) {
        fieldName.shouldBe(Condition.visible).setValue(nameUser);
    }

    void setEmail(String email) {
        fieldEmail.shouldBe(Condition.visible).setValue(email);
    }

    void setPassword(String password) {
        fieldPassword.shouldBe(Condition.visible).setValue(password);
    }

    void clickButtonRegistration() {
        if (buttonRegistration.isDisplayed()) {
            buttonRegistration.shouldBe(Condition.visible).click();
        }
    }

    Boolean messageUserExistOnDisplay(){
        return messageExistUser.shouldBe(Condition.visible).exists();
    }

    Boolean messageWrongPasswordOnDisplay(){
        return messageWrongPassword.shouldBe(Condition.visible).exists();
    }

    @Step("Вводим данные для регистрации пользователя")
    void registrationNewUser(String name,
                             String email,
                             String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickButtonRegistration();
    }

    @Step("Переходим по ссылке на страницу логина")
    void clickLinkLoginPage() {
        if (linkLoginPage.isDisplayed()) {
            linkLoginPage.shouldBe(Condition.visible).click();
        }
    }
}
