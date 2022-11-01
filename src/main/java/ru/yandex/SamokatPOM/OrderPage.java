package ru.yandex.SamokatPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private By name = By.xpath(".//input[@placeholder='* Имя']"); //Поле "Имя"
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']"); //Поле "Фамилия"
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //Поле "Адресс"
    private By metrostation = By.cssSelector(".select-search__value .select-search__input"); //Поле "Станция метро"
    private By metrostation1 = By.xpath(".//input[@placeholder='* Станция метро']"); //Поле ввода "Станция метро"
    private By metroValueInput = By.xpath(".//li[@data-index='0']"); // Выбор первого значения в выпадающем списке
    private By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Поле "Телефон"
    private By next = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); //Кнопка "Далее"
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //Поле "Когда привезти самокат"
    private By date1 = By.xpath(".//div[@class='react-datepicker__week']/div[@aria-label='Choose вторник, 1-е ноября 2022 г.']"); //Поле выбора даты
    private By date2 = By.xpath(".//div[@class='react-datepicker__week']/div[@aria-label='Choose воскресенье, 2-е октября 2022 г.']"); //Поле выбора даты
    private By time = By.className("Dropdown-control"); //Поле выбора времени
    private By time1 = By.xpath(".//div[@class='Dropdown-menu']/div[3]"); //Поле выбора времени для теста
    private By time2 = By.xpath(".//div[@class='Dropdown-menu']/div[5]"); //Поле выбора времени для теста
    private By colourBlack = By.id("black"); //Поле выбора цвета, чёрный
    private By colourGrey = By.id("grey"); //Поле выбора цвета, серый
    private By comment = By.cssSelector(".Input_InputContainer__3NykH .Input_Responsible__1jDKN"); //Поле "Комментарии"
    private By rent = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]"); //Кнокпка "Заказать", для открытия модального окна
    private By approve = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]"); //Кнопка "Да" в сплывающем окне заказа
    private By successfully = By.className("Order_ModalHeader__3FDaJ"); //Локатор теста успешного заказа


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendLoginFirstVersion(String nameText, String surnameText, String addressText, String metrostationText, String telephoneNumber, String commentText) {
        driver.findElement(name).sendKeys(nameText);
        driver.findElement(surname).sendKeys(surnameText);
        driver.findElement(address).sendKeys(addressText);
        driver.findElement(metrostation).click();
        driver.findElement(metrostation1).sendKeys(metrostationText);
        driver.findElement(metroValueInput).click();
        driver.findElement(telephone).sendKeys(telephoneNumber);
        driver.findElement(next).click();
        driver.findElement(date).click();
        driver.findElement(date1).click();
        driver.findElement(time).click();
        driver.findElement(time1).click();
        driver.findElement(colourBlack).click();
        driver.findElement(comment).sendKeys(commentText);
        driver.findElement(rent).click();
    }

    public void sendLoginSecondVersion(String nameText, String surnameText, String addressText, String metrostationText, String telephoneNumber, String commentText) {
        driver.findElement(name).sendKeys(nameText);
        driver.findElement(surname).sendKeys(surnameText);
        driver.findElement(address).sendKeys(addressText);
        driver.findElement(metrostation).click();
        driver.findElement(metrostation1).sendKeys(metrostationText);
        driver.findElement(metroValueInput).click();
        driver.findElement(telephone).sendKeys(telephoneNumber);
        driver.findElement(next).click();
        driver.findElement(date).click();
        driver.findElement(date2).click();
        driver.findElement(time).click();
        driver.findElement(time2).click();
        driver.findElement(colourGrey).click();
        driver.findElement(comment).sendKeys(commentText);
        driver.findElement(rent).click();
    }
    public void sendApproveForRentScooter() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(approve)).click();
    }

    public String sendTextSuccessfullyForRentScooter() {
        return driver.findElement(successfully).getText();
    }
}