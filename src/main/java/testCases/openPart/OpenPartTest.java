package testCases.openPart;

import org.testng.annotations.Test;
import testPages.NewsPage;
import testPages.OpenPartPage;


import java.util.Random;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class OpenPartTest extends OpenPartPage {
    //открытая часть реестра
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);
    String titleNews = prefix + "автотест ЗаголовокОЧ";
    String shortText = prefix + "автотест Краткий текст новостиОЧ";
    String textNews = prefix + "автотест Текст новостиОЧ";
    String captcha ="12345";

    public OpenPartTest() throws Exception {
    }

    /**
     * Цель: Проверка поиска на главной странице
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3322
     * @author Frolova S.I 03.2022
     */
    @Test(description = "1 - Проверка поиска на главной странице")
    public void checkSearchMainPage() {
        clearBrowserCookies();
        open(openUrl);
        gotoHomeOpenPage();
        searchEventsWithCaptcha(numberPublishedKNMBVT, captcha);
        checkObject(numberPublishedKNMBVT);
        gotoHomeOpenPage();
        searchEventsWithoutCaptcha(numberUnpublishedKNMBVT);
        checkAbsenceObject(numberUnpublishedKNMBVT);
    }

    /**
     * Цель: Проверка поиска на странице поиска проверок
     * HP ALM
     *
     * @author Frolova S.I 03.2022
     */
    @Test(description = "2 - Проверка поиска на странице поиска проверок")
    public void checkSearchSearchPage() {
        clearBrowserCookies();
        open(openUrl);
        gotoSearchCheckOpenPage();
        searchEventsWithCaptcha(numberPublishedKNMBVT,captcha);
        checkObject(numberPublishedKNMBVT);
        gotoSearchCheckOpenPage();
        searchEventsWithoutCaptcha(numberUnpublishedKNMBVT);
        checkAbsenceObject(numberUnpublishedKNMBVT);

    }

    /**
     * Цель: Проверка доступности новости для открытой части
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=54
     * @author Frolova S.I 02.2022
     */
    @Test(description = "3 - Проверка доступности новости для открытой части")
    public void displayNewsOnNewsPage() throws Exception, Exception {
        authorization("admin");
        choiceMode(true);NewsPage news = new NewsPage();
        news.goToManagementNews();
        news.addNews(typeItemNews, visibleNewsItemOpenPart, titleNews, shortText, textNews, currentDate);
        logout();
        openERKNM();
        gotoNewsOpenPage();
        news.searchNewsInTableUser(prefix + "автотест ЗаголовокОЧ",true);

    }


}
