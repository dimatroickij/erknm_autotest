package erknm_gui_autotest.src.java.testPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OpenPartPage extends Common {
    //для открытой части

    String homePage = "Главная страница";
    String openDataPage = "Открытые данные";
    String searchEventsPage = "Поиск проверок";
    String newsPage = "Новости";

    //главная страница и поиск проверок
    String searchField = "//*[@type='text']"; //поле для ввода поискового запроса
    String captchaField = "//*[@name='captcha']"; //поле для ввода капчи
    String sendButton = "//*[text()='Отправить']"; //кнопка отправить на форме капчи

    //открытые данные

    //новости

    /**
     * Поиск мероприятия с вводом капчи
     *
     * @param number
     */
    public void searchEventsWithCaptcha(String number, String captha) {
        $(By.xpath(searchField)).setValue(number); //ввод поискового запроса
        clickSearchButton(); //нажатие на кнопку Искать
        $(By.xpath(captchaField)).setValue(captha); //ввод капчи
        $(By.xpath(sendButton)).click(); //нажатие на кнопку Отправить

    }

    /**
     * Поиск мероприятия без ввода капчи
     *
     * @param number
     */
    public void searchEventsWithoutCaptcha(String number) {
        $(By.xpath(searchField)).setValue(number); //ввод поискового запроса
        clickSearchButton(); //нажатие на кнопку Искать
    }
}
