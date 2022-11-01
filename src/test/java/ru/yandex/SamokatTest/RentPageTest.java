package ru.yandex.SamokatTest;

import static org.hamcrest.CoreMatchers.containsString;

import main.BrowserRule;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.SamokatPOM.MainPage;
import ru.yandex.SamokatPOM.OrderPage;

@RunWith(Parameterized.class)
public class RentPageTest {
    private final String button;
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public RentPageTest(String button) {
        this.button = button;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getLocator() {
        return new Object[][]{
                {".Header_Nav__AGCXC .Button_Button__ra12g"},
                {".Home_FinishButton__1_cWm .Button_Button__ra12g"},
        };
    }

    @Test
    public void shouldOrderScooterForSendLoginFirstVersionToClickButtonUp() {
        OrderPage objOrderPageScooter = new OrderPage(browserRule.getDriver());
        MainPage objMainPageScooter = new MainPage(browserRule.getDriver());
        objMainPageScooter.open();
        objMainPageScooter.clickButton(button);
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
}