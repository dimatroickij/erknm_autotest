package testPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OpenPartPage extends Common {
    //для открытой части

    String searchField = "//*[@type='text']"; //поле для ввода поискового запроса
    String captchaField = "//*[@name='captcha']"; //поле для ввода капчи
    String sendButton = "//*[text()='Отправить']"; //кнопка отправить на форме капчи

    String homePage = "//*[@id='root']/div/header/nav/a[1]"; //пункт меню Главная страница
    String openDataPage = "//*[@id='root']/div/header/nav/a[2]"; //пункт меню Открытые данные
    String searchCheckPage = "//*[@id='root']/div/header/nav/a[3]";//пункт меню Поиск проверок
    String newsPage = "//*[@id='root']/div/header/nav/a[4]"; //пункт меню Новости

    //открытые данные

    //новости

    /**
     * Переход на Главную страницу в открытой части
     */
    @Step("Переход на Главную страницу в открытой части")
    public void gotoHomeOpenPage() {
        $(By.xpath(homePage)).click();
    }

    /**
     * Переход на страницу Открытые данные в открытой части
     */
    @Step("Переход на страницу Открытые данные в открытой части")
    public void gotoOpenDataOpenPage(){
        $(By.xpath(openDataPage)).click();
    }

    /**
     * Переход на страницу Поиск проверок в открытой части
     */
    @Step("Переход на страницу Поиск проверок в открытой части")
    public void gotoSearchCheckOpenPage(){
        $(By.xpath(searchCheckPage)).click();
    }

    /**
     * Переход на страницу Новости в открытой части
     */
    @Step("Переход на страницу Новости в открытой части")
    public void gotoNewsOpenPage(){
        $(By.xpath(newsPage)).click();
    }

    /**
     * Поиск мероприятия с вводом капчи
     * @param number
     */
    @Step("Поиск мероприятия {number} с вводом капчи - {captcha}")
    public void searchEventsWithCaptcha(String number, String captcha) {
        $(By.xpath(searchField)).setValue(number); //ввод поискового запроса
        clickSearchButton(); //нажатие на кнопку Искать
        $(By.xpath(captchaField)).setValue(captcha); //ввод капчи
        $(By.xpath(sendButton)).click(); //нажатие на кнопку Отправить
    }

    /**
     * Поиск мероприятия без ввода капчи
     * @param number
     */
    @Step("Поиск мероприятия без ввода капчи - {number}")
    public void searchEventsWithoutCaptcha(String number) {
        $(By.xpath(searchField)).setValue(number); //ввод поискового запроса
        clickSearchButton(); //нажатие на кнопку Искать
    }
}
