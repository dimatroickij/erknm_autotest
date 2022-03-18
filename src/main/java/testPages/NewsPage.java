package testPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.UUID;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class NewsPage extends Common {
    // раздел Новости
    public String managementNewsItemMenu = "//*[@id='/private/lk/news']/a"; // Кнопка перехода в раздел Управление новостями
    public String typeNewsDropDown = "//*[@id='type']"; // Выпадающий список Тип новости

    public String typeItemAnnouncement = "//*[text()='Анонс']";
    public String typeItemSurvey = "//*[text()='Опрос']";
    public String visibleNewsDropDown = "//form//div[@class='shared-row'][2]//*[contains(@class, 'SelectInput_SelectContainer')]"; // Выпадающий список Для кого видна новость TODO Должен быть идентификатор
    public String visibleNewsItemKNO = "//*[text()='Сотрудник КНО']";

    public String visibleNewsItemOmbudsmen = "//*[text()='Омбудсмен']";
    public String visibleNewsItemAdmin = "//*[text()='Администратор']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String titleField = "//*[@name='title']"; // Поле Заголовок
    public String shortTextField = "//*[@name='shortText']"; // Поле Краткий текст новости
    public String textNewsField = "//*[@role= 'textbox']//span[@data-offset-key='key-0-0']"; // Поле Текст новости
    public String dataPublicationField = "//form/div[7]//input"; // Поле Дата публикации TODO Должен быть идентификатор
    public String saveWithPublicationsNewsButton = "//button[text()='Опубликовать']"; // Кнопка Опубликовать TODO Должен быть идентификатор
    public String removeFromPublicationNewsButton = "//button[text()='Убрать из публикации']"; // Кнопка Убрать из публикации TODO Должен быть идентификатор
    public String titleNewsOrStatusCell = "//*[contains(@class, 'NewsTable_Cell') and contains(string(), '%s')]"; // Шаблон для поиска ячейки с заголовком новости или статуса для роли Администратор TODO Должен быть идентификатор
    public String titleNewsCell = "//*[contains(@class, 'NewsItem_Title_') and contains(string(), '%s')]"; // Шаблон для поиска новости по заголовку TODO Должен быть идентификатор


    // Переменные, которые будут использоваться совместно несколькими тестами
    public String prefixNews = UUID.randomUUID().toString(); // Префикс для уникальных названий
    public String titleNews = "автотест Заголовок"; // Заголовок новости
    public String shortTextNews = "автотест Краткий текст новости"; // Краткий текст новости
    public String textNews = "автотест Текст новости";


    /**
     * Переход в пункт меню Управление новостями
     */
    @Step("Переход в пункт меню Управление новостями")
    public void goToManagementNews() {
        $(By.xpath(managementNewsItemMenu)).click();
    }

    /**
     * Переход в редактирование случайной опубликованной новости
     */
    @Step("Переход в редактирование случайной опубликованной новости")
    public void goToNews() {
        $(By.xpath(String.format(titleNewsOrStatusCell, "Опубликована"))).click();
    }

    /**
     * Переход в редактирование новости по префиксу
     *
     * @param prefix Префикс
     */
    @Step("Переход в редактирование новости по префиксу - {prefix}")
    public void goToNews(String prefix) {
        $(By.xpath(String.format(titleNewsOrStatusCell, prefix))).click();
    }

    /**
     * Выбор из выпадающего списка Типа новости
     *
     * @param type Тип новости
     */
    @Step("Выбор из выпадающего списка Типа новости - {type}")
    public void setTypeNewsField(String type) {
        $(By.xpath(typeNewsDropDown)).should(exist).click(); // клик на выпадающем списке Тип
        $(By.xpath(type)).click(); // клик на типе Новость
    }

    /**
     * Выбор из выпадающего списка Для кого видна новость
     *
     * @param visible Значение поля
     */
    @Step("Выбор из выпадающего списка Для кого видна новость - {visible}")
    public void setVisibleNewsDropDown(String visible) {
        $(By.xpath(visibleNewsDropDown)).should(exist).click(); // клик на выпадающем списке Для кого видна новость
        $(By.xpath(visible)).click(); // клик на роли
    }

    /**
     * Заполнение заголовка новости
     *
     * @param title Заголовок новости
     */
    @Step("Заполнение заголовка новости - {title}")
    public void setTitleNewsField(String title) {
        $(By.xpath(titleField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(titleField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(titleField)).append(title); // Ввод нового значения поля
    }

    /**
     * Получение заголовка новости
     */
    @Step("Получение заголовка новости")
    public String getTitleNewsField() {
        return $(By.xpath(titleField)).should(exist).getValue();
    }

    /**
     * Заполнение краткого текста новости
     *
     * @param shortText Кратний текст новости
     */
    @Step("Заполнение краткого текста новости - {shortText}")
    public void setShortTextNewsField(String shortText) {
        $(By.xpath(shortTextField)).sendKeys(Keys.CONTROL + "A");
        $(By.xpath(shortTextField)).sendKeys(Keys.BACK_SPACE);
        $(By.xpath(shortTextField)).setValue(shortText);
    }

    /**
     * Заполнение текста новости
     *
     * @param text Текст новости
     */
    @Step("Заполнение текста новости - {text}")
    public void setTextNewsField(String text) {
        $(By.xpath(textNewsField)).append(text);
    }

    /**
     * Клик по кнопке Опубликовать
     */
    @Step("Клик по кнопке Опубликовать")
    public void clickSaveWithPublicationsNewsButton() {
        $(By.xpath(saveWithPublicationsNewsButton)).click();
    }

    /**
     * Клик по кнопке Убрать из публикации
     */
    @Step("Клик по кнопке Убрать из публикации")
    public void clickRemoveFromPublicationNewsButton() {
        $(By.xpath(removeFromPublicationNewsButton)).click();
    }

    /**
     * Заполнение поля Дата публикации
     *
     * @param date Дата публикации
     */
    @Step("Заполнение поля Дата публикации")
    public void setDataPublicationField(String date) {
        $(By.xpath(dataPublicationField)).setValue(date);
    }

    /**
     * Поиск новости в таблице новостей у админа
     *
     * @param exist true - проверка на сущестовование новости
     * @param news  Название новости
     */
    @Step("Поиск новости - {news}, в таблице новостей у админа - {news}")
    public void searchNewsInTableAdmin(String news, boolean exist) {
        Condition condition = exist ? appear : not(appear);
        $(By.xpath(String.format(titleNewsOrStatusCell, news))).should(condition);
    }

    /**
     * Поиск новости в таблице новостей у Пользователя
     *
     * @param exist true - проверка на сущестовование новости
     * @param news  Название новости
     */
    @Step("Поиск новости - {news} в таблице новостей у Пользователя")
    public void searchNewsInTableUser(String news, boolean exist) {
        Condition condition = exist ? appear : not(appear);
        $(By.xpath(String.format(titleNewsCell, news))).should(condition);
    }

    /**
     * Добавление новости
     *
     * @param text      Текст новости
     * @param shortText Краткий текст новости
     * @param title     Заголовок новости
     * @param typeItem  Тип новости
     * @param visible   Для кого видна новость
     */
    @Step("Добавление новости")
    public void addNews(String typeItem, String visible, String title, String shortText, String text, String date) {
        clickAddNewsButton();
        setTypeNewsField(typeItem);
        setVisibleNewsDropDown(visible);
        setTitleNewsField(title);
        setShortTextNewsField(shortText);
        setTextNewsField(text);
        setDataPublicationField(date);
        clickSaveButton();
    }

    /**
     * Нажатие на кнопку Добавить новость
     */
    @Step("Нажатие на кнопку Добавить")
    public void clickAddNewsButton() {
        $(By.xpath(addButton)).click();
        refresh();
    }


}
