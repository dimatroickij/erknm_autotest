package testCases.news;

import org.testng.annotations.Test;
import testPages.NewsPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class NewsTest extends NewsPage {
// раздел Новости
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавление новости")
    public void createNewsTest() throws InterruptedException {
        authorization("admin");
        goToManagmentNews();
        clickAddNewsButton();
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        setTitleNewsField(prefix + "автотестЗаголовок");
        setShortTextNewsField(prefix + "автотестКраткий текст новости");
        setTextNewsField(prefix + "автотестТекст новости");
        setDataPublicationField();
        clickSaveNewsButton();
        //clickSaveWithPublicationsNewsButton();
        searchNewsInTableAdmin(prefix + "автотестЗаголовок");
        clickToText(nameAdmin);
        clickExitButton();
        authorization("prosecutor");
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотестЗаголовок");


    }

  /*  @Test(description = "2 - Редактирование новости")
    public void editNews() {
//поиск  созданной новости/редактирование
        authorization("admin");
        //double randomNumber = Math.random();
        System.out.println(randomNumber);
        goToManagmentNews();
        //переход в созданную новость
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        setTitleNewsField(randomNumber + "автотестРедЗаголовок");
        setShortTextNewsField(randomNumber + "автотестКраткий текст ред новости");
        setTextNewsField(randomNumber + "автотестТекст Ред новости ");
        clickSaveNewsButton();
        clickSaveWithPublicationsNewsButton();
//проверить,что есть новые название и нет старых Проверка на изменеие типа и видящего, что есть у новых и нет у старых
        System.out.println("STOP");

    }

    @Test(description = "3 -  Удаление новости")
    public void deleteNews() {
//поиск предыдущей новости/ удаление
        authorization("admin");
        //double randomNumber = Math.random();
        System.out.println(randomNumber);
        goToManagmentNews();
        //переход в созданную новость
        clickRemoveFromPublicationNewsButton();

    }*/



}
