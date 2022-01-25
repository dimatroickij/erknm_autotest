package testCases.news;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testPages.NewsERPPage;

import java.util.UUID;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class NewsERPTest extends NewsERPPage {

    // Новости в режиме ЕРП
    String prefix = UUID.randomUUID().toString(); //"bcca8d09-6487-486f-9fb8-cb52c02fe89";

    String newPrefix = UUID.randomUUID().toString();

    /*
     author Troickij D. I. 01.2022
     */
    @Test(description = "1 - Добавление новости в режиме ЕРП")
    public void createNewsERPTest() {
        authorization("admin");
        choiceERP(); // переход в режим ЕРП
        System.out.println("Идентификатор - " + prefix);
        goToManagmentNews();
        clickAddNewsButton();
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        setTitleNewsField(prefix + "автотест Заголовок");
        setShortTextNewsField(prefix + "автотест Краткий текст новости");
        setTextNewsField(prefix + "автотест Текст новости");

        clickSaveNewsButton();
        clickSaveWithPublicationsNewsButton();
        $(By.xpath("//*[contains(@class, 'NewsTable_Cell') and contains(string(), '" + prefix + "')]")).should(appear);
        //проверить на видимость у пользователя

        System.out.println("STOP");
    }

//    @Test(description = "2 - Редактирование новости в режиме ЕРП")
//    public void editNewsERPTest() {
//        authorization("admin");
//        choiceERP(); // переход в режим ЕРП
//        System.out.println("Идентификатор - " + prefix);
//        goToManagmentNews();
//        goToNews(prefix);
//
//        setTypeNewsField(typeItemNews);
//        setTitleNewsField(newPrefix + "автотест Заголовок");
//        setShortTextNewsField(newPrefix + "автотест Краткий текст новости");
//        setTextNewsField(newPrefix + "автотест Текст новости");
//        clickSaveNewsButton();
//        clickApplyWithPublicationsNewsButton();
//        $(By.xpath("//*[contains(@class, 'NewsTable_Cell') and contains(string(), '" + newPrefix + "')]")).should(appear);
//        $(By.xpath("//*[contains(@class, 'NewsTable_Cell') and not contains(string(), '" + prefix + "')]")).should(appear);
//    }
}
