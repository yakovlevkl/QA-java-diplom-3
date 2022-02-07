package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class PasswordRecoveryPage extends HeaderPage {
    // Ссылка на страницу регистрации
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    SelenideElement linkLoginFromRecovery;

    @Step("Переход по ссылке в форму восстановления пароля")
    void clickLinkLoginFromRecovery() {
        if (linkLoginFromRecovery.isDisplayed()) {
            linkLoginFromRecovery.shouldBe(Condition.visible).click();
        }
    }


}
