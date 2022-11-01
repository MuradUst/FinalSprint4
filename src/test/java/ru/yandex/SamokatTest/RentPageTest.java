package ru.yandex.SamokatTest;

import static org.hamcrest.CoreMatchers.containsString;

import main.BrowserRule;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.SamokatPOM.MainPage;
import ru.yandex.SamokatPOM.OrderPage;

public class RentPageTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void shouldOrderScooterForSendLoginFirstVersionToClickButtonUp() {
        OrderPage objOrderPageScooter = new OrderPage(browserRule.getDriver());
        MainPage objMainPageScooter = new MainPage(browserRule.getDriver());
        objMainPageScooter.open();
        objMainPageScooter.clickButtonUp();
        objOrderPageScooter.sendLoginFirstVersion(
                "Иванов",
                "Иван",
                "Ивнович",
                "Черкизовская",
                "+7915489465",
                "тестовый комментарий");
        objOrderPageScooter.sendApproveForRentScooter();
        String expected = "Заказ оформлен";
        String actual = objOrderPageScooter.sendTextSuccessfullyForRentScooter();
        MatcherAssert.assertThat(actual, containsString(expected));
    }

    @Test
    public void shouldOrderScooterForSendLoginSecondVersionToClickButtonDown() {
        OrderPage objOrderPageScooter = new OrderPage(browserRule.getDriver());
        MainPage objMainPageScooter = new MainPage(browserRule.getDriver());
        objMainPageScooter.open();
        objMainPageScooter.clickButtonDown();
        objOrderPageScooter.sendLoginSecondVersion(
                "Сергеев",
                "Сергей",
                "Сергеевич",
                "Сокольники",
                "+79993332210",
                "");
        objOrderPageScooter.sendApproveForRentScooter();
        String expected = "Заказ оформлен";
        String actual = objOrderPageScooter.sendTextSuccessfullyForRentScooter();
        MatcherAssert.assertThat(actual, containsString(expected));
    }
}