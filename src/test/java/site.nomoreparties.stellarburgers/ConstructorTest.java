package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class ConstructorTest extends DataForTests {
    /*
    Раздел «Конструктор»
         Проверь, что работают переходы к разделам:
           - «Булки»,
           - «Соусы»,
           - «Начинки».
    */
    @Before
    public void setUp_() {
        burgersSite.clickButtonPersonalAccount();
        burgersSite.clickConstructor();
    }

    @Test
    @Feature("Раздел «Конструктор» переходы к разделу «Булки»")
    @DisplayName("Раздел «Конструктор» переходы к разделу «Булки»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void constructorBunsTest() {
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
        burgersSite.clickButtonSauces();
        burgersSite.clickButtonSauceSpicyX();
        burgersSite.clickButtonCloseCard();
    }

    @Test
    @Feature("Раздел «Конструктор» переходы к разделу «Начинки»")
    @DisplayName("Раздел «Конструктор» переходы к разделу «Начинки»")
    @Description("Test for https://stellarburgers.nomoreparties.site frontend")
    public void constructorFillingTest() {
        burgersSite.clickButtonFilling();
        burgersSite.clickButtonProtostomia();
        burgersSite.clickButtonCloseCard();
    }

}
