package erknm_gui_autotest.src.java.testPages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends Common{
    // раздел Новости
    public String managementNewsItemMenu = "//*[text()='Управление новостями']";
    public String addNewsButton = "//button[text()='Добавить новость']";
    public String typeNewsDropDown = "//*[contains(@class, 'SelectInput_SelectInput') and contains(string(), 'Тип')]";
    public String typeItemNews = "//*[text()='Новость']";
    public String typeItemAnnouncement = "//*[text()='Анонс']";
    public String typeItemSurvey = "//*[text()='Опрос']";
    public String visibleNewsDropDown = "//*[contains(@class, 'SelectInput_SelectInput') and contains(string(), 'Для кого видна новость')]";
    public String visibleNewsItemKNO = "//*[text()='Сотрудник КНО']";
    public String visibleNewsItemProsecutor = "//*[text()='Работник прокуратуры']";
    public String visibleNewsItemOmbudsmen = "//*[text()='Омбудсмен']";
    public String visibleNewsItemAdmin = "//*[text()='Администратор']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String titleField = "//*[@name='title']"; //поле Заголовок
    public String shortTextField = "//*[@name='shortText']"; //поле Краткий текст новости
    public String textNewsField = "//*[@role= 'textbox']"; //поле Текст новости - TODO: не успевает?
   // public String dataPublicationField =""; //TODO: поле Дата публикация пока без даты сохраняем
    public String saveNewsButton = "//*[@type='submit']";
    public String saveWithoutPublicationsNewsButton = "//button[text()='Сохранить без публикации']";
    public String saveWithPublicationsNewsButton = "//button[text()='Опубликовать']";
    public String removeFromPublicationNewsButton = "//button[text()='Убрать из публикации']";



    /**
     * Переход в пункт меню Управление новостями
     */
    public void goToManagmentNews() {
        $(By.xpath(managementNewsItemMenu)).click();
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
        $(By.xpath(typeNewsDropDown)).click(); // клик на выпадающем списке Тип
        $(By.xpath(type)).click(); // клик на типе Новость
    }

    /**
     * Выбор Для кого видна новость
     */
    public void setVisibleNewsDropDown(String visible) {
        $(By.xpath(visibleNewsDropDown)).click(); // клик на выпадающем списке Для кого видна новость
        $(By.xpath(visible)).click(); // клик на роли
    }

    /**
    Заполнение заголовка новости
     */
    public void setTitleNewsField(String title){
        $(By.xpath(titleField)).setValue(title); // Префикс - рандом+авто
    }

    /**
     Заполнение краткого текста новости
     */
    public void setShortTextNewsField(String shortText){
        $(By.xpath(shortTextField)).setValue(shortText); // Префикс - рандом+авто
    }

    /**
     Заполнение текста новости
     */
    public void setTextNewsField(String text){
        $(By.xpath(textNewsField)).setValue(text); // Префикс - рандом+авто
    }

    /**
     * Клик по кнопке Сохранить при создании новости
     */
    public void clickSaveNewsButton(){
        $(By.xpath(saveNewsButton)).shouldHave(text("Сохранить"), Duration.ofSeconds(3)).click();
    }

    /**
     * Клик по кнопке Сохранить без публикации
     */
    public void clickSaveWithoutPublicationsNewsButton(){
        $(By.xpath(saveWithoutPublicationsNewsButton)).click();
    }

    /**
     * Клик по кнопке Опубликовать
     */
    public void clickSaveWithPublicationsNewsButton(){
        $(By.xpath(saveWithPublicationsNewsButton)).click();
    }

    /**
     * Клик по кнопке Убрать из публикации
     */
    public void clickRemoveFromPublicationNewsButton(){
        $(By.xpath(removeFromPublicationNewsButton)).click();
    }


}
