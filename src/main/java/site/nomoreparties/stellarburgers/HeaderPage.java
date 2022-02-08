package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class HeaderPage {
    //Линк на главную старницу
    @FindBy(how = How.XPATH, using = "//a[@href='/']")
    SelenideElement linkMainPage;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    SelenideElement buttonConstructor;

    // Кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    SelenideElement buttonPersonalAccount;

    void clickConstructor(){
        buttonConstructor.scrollTo().shouldBe(Condition.visible).click();
    }

    @Step("Входим в личный кабинет")
    void clickButtonPersonalAccount(){
        if (buttonPersonalAccount.isDisplayed()) {
            buttonPersonalAccount.shouldBe(Condition.visible).click();
        }
    }

    @Step("Клик на логотип Stellar Burgers ")
    void clickLinkMainPage() {
        if (linkMainPage.isDisplayed()) {
            linkMainPage.shouldBe(Condition.visible).click();
        }
    }
}
