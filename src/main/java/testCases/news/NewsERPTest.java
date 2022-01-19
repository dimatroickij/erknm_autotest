package testCases.news;

import org.testng.annotations.Test;
import testPages.NewsPage;

import java.util.Random;

public class NewsERPTest extends NewsPage {
    //новости в режиме ЕРП
    Random rnd = new Random();
    int randomNumber = rnd.nextInt(1000000);

    /*
     author Frolova S.I 01.2022
     */
    //TODO рефактор
    @Test(description = "1 - Добавление новости в режиме ЕРП")
    public void createNewsERPTest() {
        //TODO отредактировать
        authorization("admin");
        //double randomNumber = Math.random();
        //перейти в режим ЕРП
        System.out.println(randomNumber);
        goToManagmentNews();
        clickAddNewsButton();
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        clickSaveNewsButton();
        setTitleNewsField(randomNumber + "автотестЗаголовок");
        setShortTextNewsField(randomNumber + "автотестКраткий текст новости");
        setTextNewsField(randomNumber + "автотестТекст новости");



        System.out.println(":le");


    }
}
