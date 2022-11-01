package ru.yandex.SamokatPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    private By buttonUp = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private By buttonDown = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");
    private final String url = "https://qa-scooter.praktikum-services.ru/";  //Адрес сайта

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickButtonUp() {
        driver.findElement(buttonUp).click();
    }
    public void clickButtonDown() {
        WebElement element = driver.findElement(buttonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonDown).click();
    }
    public String getTextAccordion(int num) {
        String accordionHeading_id = "accordion__heading-" + num; //Локатор "вопрос о важном"
        String accordionPanel_id = "accordion__panel-" + num; //Локатор "ответ на вопрос"
        By accordionHeading = By.id(accordionHeading_id);
        By accordionPanel = By.id(accordionPanel_id);
        WebElement element = driver.findElement(accordionHeading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(accordionHeading).click();
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(accordionPanel)).getText();
    }
}