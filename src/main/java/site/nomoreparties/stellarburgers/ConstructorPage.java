package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class ConstructorPage extends PersonalAccountPage {

    //Кнопка входа в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    SelenideElement buttonEnterInAccount;

    // Кнопка Оформить заказ, доступна после входа в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    SelenideElement buttonPlaceAnOrder;

    // Кнопка Булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    SelenideElement buttonBuns;

    // Признак открытого раздела Булки по булке Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = "//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6d']")
    SelenideElement buttonBunFluorescent;

    // Кнопка закрыть карточку по булке Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = "//div/section[1]/div[1]/button")
    SelenideElement buttonCloseCard;

    // Кнопка «Соусы»
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    SelenideElement buttonSauces;

    // Признак открытого раздела Соусы по соусу Соус Spicy-X
    @FindBy(how = How.XPATH, using = "//a[@href='/ingredient/61c0c5a71d1f82001bdaaa72']")
    SelenideElement buttonSauceSpicyX;

    // Кнопка «Начинки»
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    SelenideElement buttonFilling;

    // Признак открытого раздела Начинки по Мясо бессмертных моллюсков Protostomia
    @FindBy(how = How.XPATH, using = "//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6f']")
    SelenideElement buttonProtostomia;

    @Step("Входим в личный кабинет")
    void clickEnterInAccount(){
        buttonEnterInAccount.shouldBe(Condition.visible).click();
    }

    void clickButtonPlaceAnOrder(){
        buttonPlaceAnOrder.shouldBe(Condition.visible).click();
    }

    boolean buttonPlaceAnOrderOnDisplay(){
        return buttonPlaceAnOrder.shouldBe(Condition.visible).exists();
    }

    void clickButtonBuns(){
        buttonBuns.shouldBe(Condition.visible).click();
    }

    void clickButtonBunFluorescent(){
        buttonBunFluorescent.shouldBe(Condition.visible).click();
    }

    void clickButtonCloseCard(){
        buttonCloseCard.shouldBe(Condition.visible).click();
    }

    boolean searchButtonBunFluorescent(){
        return buttonBunFluorescent.shouldBe(Condition.visible).exists();
    }

    void clickButtonSauces(){
        buttonSauces.shouldBe(Condition.visible).click();
    }

    boolean searchButtonSauceSpicyX(){
        return buttonSauceSpicyX.shouldBe(Condition.visible).exists();
    }

    void clickButtonSauceSpicyX(){
        buttonSauceSpicyX.shouldBe(Condition.visible).click();
    }

    void clickButtonFilling(){
        buttonFilling.shouldBe(Condition.visible).click();
    }

    void clickButtonProtostomia(){
        buttonProtostomia.shouldBe(Condition.visible).click();
    }

}
