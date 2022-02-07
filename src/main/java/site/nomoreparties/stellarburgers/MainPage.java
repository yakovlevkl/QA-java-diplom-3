package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class MainPage extends PersonalAccountPage {

    //Кнопка входа в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    SelenideElement buttonEnterInAccount;

    // Кнопка Оформить заказ, доступна после входа в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    SelenideElement buttonPlaceAnOrder;

    @Step("Входим в личный кабинет")
    void clickEnterInAccount(){
        if (buttonEnterInAccount.isDisplayed()) {
            buttonEnterInAccount.shouldBe(Condition.visible).click();
        }
    }

    void clickButtonPlaceAnOrder(){
        if (buttonPlaceAnOrder.isDisplayed()) {
            buttonPlaceAnOrder.shouldBe(Condition.visible).click();
        }
    }

    boolean buttonPlaceAnOrderOnDisplay(){
        return buttonPlaceAnOrder.shouldBe(Condition.visible).exists();
    }
}
