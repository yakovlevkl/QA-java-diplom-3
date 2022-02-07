package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class PersonalAccountPage extends LoginPage {

    // кнопка 'Выйти' в акаунт пользователя //button[contains(text(),'Выход')]
    @FindBy(how = How.XPATH, using = "//button[@type='button' and text()='Выход']")
    SelenideElement buttonExit;

    @Step("Клик по кнопке выхода из аккаунта")
    void clickButtonExit(){
        System.out.println(buttonExit.isDisplayed());
        buttonExit.shouldBe(Condition.visible).click();
    }

    boolean buttonExitOnDisplay(){
        return buttonExit.shouldBe(Condition.visible).exists();
    }

}
