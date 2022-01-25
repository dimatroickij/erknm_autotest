package testPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends Common {
    // раздел Новости
    public String managementNewsItemMenu = "//*[text()='Управление новостями']";
    public String addNewsButton = "//button[text()='Добавить новость']";
    public String typeNewsDropDown = "//form//div[@class='shared-row'][1]//*[contains(@class, 'SelectInput_SelectInput')]";
    public String typeItemNews = "//*[text()='Новость']";
    public String typeItemAnnouncement = "//*[text()='Анонс']";
    public String typeItemSurvey = "//*[text()='Опрос']";
    public String visibleNewsDropDown = "//form//div[@class='shared-row'][2]//*[contains(@class, 'SelectInput_SelectInput')]";
    public String visibleNewsItemKNO = "//*[text()='Сотрудник КНО']";
    public String visibleNewsItemProsecutor = "//*[text()='Работник прокуратуры']";
    public String visibleNewsItemOmbudsmen = "//*[text()='Омбудсмен']";
    public String visibleNewsItemAdmin = "//*[text()='Администратор']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String titleField = "//*[@name='title']"; //поле Заголовок
    public String shortTextField = "//*[@name='shortText']"; //поле Краткий текст новости
    public String textNewsField = "//*[@role= 'textbox']//span[@data-offset-key='key-0-0']"; //поле Текст новости
    public String dataPublicationField = "/html/body/div/div/main/div/form/div[7]/div/div[2]/div/div/div/input"; //поле Дата публикации
    public String saveNewsButton = "//*[@type='submit']";
    public String saveWithoutPublicationsNewsButton = "//button[text()='Сохранить без публикации']";
    public String saveWithPublicationsNewsButton = "//button[text()='Опубликовать']";
    public String removeFromPublicationNewsButton = "//button[text()='Убрать из публикации']";
    public String applyButton = "//button[text()='Применить']";
    public String backButton = "//button[text()='Назад']";


    /**
     * Переход в пункт меню Управление новостями
     */
    public void goToManagementNews() {
        $(By.xpath(managementNewsItemMenu)).click();
    }

    /**
     * Переход в редактирование новости
     */
    public void goToNews() {
        $(By.xpath("//*[contains(@class, 'NewsTable_Cell') and contains(string(), 'Опубликована')]")).click();
    }

    /**
     * Нажатие на кнопку Добавить новость
     */
    public void clickAddNewsButton() {
        $(By.xpath(addNewsButton)).click();
    }

    /**
     * Выбор Типа новости
     */
    public void setTypeNewsField(String type) {
        $(By.xpath(typeNewsDropDown)).should(exist).click(); // клик на выпадающем списке Тип
        $(By.xpath(type)).click(); // клик на типе Новость
    }

    /**
     * Выбор Для кого видна новость
     */
    public void setVisibleNewsDropDown(String visible) {
        $(By.xpath(visibleNewsDropDown)).should(exist).click(); // клик на выпадающем списке Для кого видна новость
        $(By.xpath(visible)).click(); // клик на роли
    }

    /**
     * Заполнение заголовка новости
     */
    public void setTitleNewsField(String title) {
        $(By.xpath(titleField)).should(exist).sendKeys(Keys.CONTROL + "A");
        $(By.xpath(titleField)).sendKeys(Keys.BACK_SPACE);
        $(By.xpath(titleField)).append(title);
    }

    public String getTitleNewsField() {
        return $(By.xpath(titleField)).should(exist).getValue();
    }

    /**
     * Заполнение краткого текста новости
     */
    public void setShortTextNewsField(String shortText) {
        $(By.xpath(shortTextField)).sendKeys(Keys.CONTROL + "A");
        $(By.xpath(shortTextField)).sendKeys(Keys.BACK_SPACE);
        $(By.xpath(shortTextField)).setValue(shortText);
    }

    /**
     * Заполнение текста новости
     */
    public void setTextNewsField(String text) {
        $(By.xpath(textNewsField)).append(text);
    }

    /**
     * Клик по кнопке Сохранить при создании новости
     */
    public void clickSaveNewsButton() {
        $(By.xpath(saveNewsButton)).shouldHave(text("Сохранить"), Duration.ofSeconds(3)).click();
    }

    /**
     * Клик по кнопке Сохранить без публикации
     */
    public void clickSaveWithoutPublicationsNewsButton() {
        $(By.xpath(saveWithoutPublicationsNewsButton)).click();
    }

    /**
     * Клик по кнопке Опубликовать
     */
    public void clickSaveWithPublicationsNewsButton() {
        $(By.xpath(saveWithPublicationsNewsButton)).click();
    }

    /**
     * Клик по кнопке Убрать из публикации
     */
    public void clickRemoveFromPublicationNewsButton() {
        $(By.xpath(removeFromPublicationNewsButton)).click();
    }

    /**
     * Клик по кнопке Применить при редактировании опубликованной новости
     */
    public void clickApplyWithPublicationsNewsButton() {
        $(By.xpath(applyButton)).click();
    }

    /**
     * Клик по кнопке Назад для возврата на страницу "Управление новостями"
     */
    public void clickBackButton() {
        $(By.xpath(backButton)).click();
    }

    /**
     * Заполнение поля Дата публикации
     */
    public void setDataPublicationField() {
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        $(By.xpath(dataPublicationField)).setValue(currentDate);
    }

    /**
     * Поиск новости в таблице новостей у админа
     */

    public void searchNewsInTableAdmin(String news, boolean exist) {
        Condition condition = exist ? appear : not(appear);
        $(By.xpath("//*[contains(@class, 'NewsTable_Cell') and contains(string(), '" + news + "')]")).should(condition);
    }

    /**
     * Поиск новости в таблице новостей у Пользователя
     */
    public void searchNewsInTableUser(String news, boolean exist) {
        Condition condition = exist ? appear : not(appear);
        $(By.xpath("//*[contains(@class, 'NewsItem_Title_') and contains(string(), '" + news + "')]")).should(condition);
    }




}
