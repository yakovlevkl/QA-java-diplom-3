package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class ConstructorTest extends Helper {
    /*
    Раздел «Конструктор»
         Проверь, что работают переходы к разделам:
           - «Булки»,
           - «Соусы»,
           - «Начинки».
    */
    @Test
    @Feature("Раздел «Конструктор» переходы к разделу «Булки»")
    @DisplayName("Раздел «Конструктор» переходы к разделу «Булки»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void constructorBunsTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickConstructor();
        burgersSite.clickButtonSauces();
        burgersSite.clickButtonBuns();
        burgersSite.clickButtonBunFluorescent();
        burgersSite.clickButtonCloseCard();
    }

    @Test
    @Feature("Раздел «Конструктор» переходы к разделу «Соусы»")
    @DisplayName("Раздел «Конструктор» переходы к разделу «Соусы»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void constructorSaucesTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickConstructor();
        burgersSite.clickButtonSauces();
        burgersSite.clickButtonSauceSpicyX();
        burgersSite.clickButtonCloseCard();
    }

    @Test
    @Feature("Раздел «Конструктор» переходы к разделу «Начинки»")
    @DisplayName("Раздел «Конструктор» переходы к разделу «Начинки»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void constructorFillingTest() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickConstructor();
        burgersSite.clickButtonFilling();
        burgersSite.clickButtonProtostomia();
        burgersSite.clickButtonCloseCard();
    }

    @After
    public void rollBck() {
        Allure.attachment("User name: ", userName);
        Allure.attachment("User password: ", userPassword);
        Allure.attachment("User mail: ", userMail);
    }
}
