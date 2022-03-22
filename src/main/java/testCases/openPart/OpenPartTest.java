package testCases.openPart;

import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.NewsPage;
import testPages.OpenPartPage;

import java.util.Random;

public class OpenPartTest extends OpenPartPage {
    //открытая часть реестра
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);
    String titleNews = prefix + "автотест ЗаголовокОЧ";
    String shortText = prefix + "автотест Краткий текст новостиОЧ";
    String textNews = prefix + "автотест Текст новостиОЧ";
    String kod ="12345";

    /**
     * Цель: Проверка поиска на главной странице
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3322
     * @author Frolova S.I 02.2022
     */
    @Test(description = "1 - Проверка поиска на главной странице")
    public void checkSearchMainPage() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        ListEventsPage event = new ListEventsPage();
        //не требует согласования
        event.addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        //опубликовать эту кнм и найти ее
        //  searchRequest(numberKNM);
        //  checkObject(numberKNM);
        //переходим в оч
        //переход на гл страницу
        //searchEventsWithCaptcha(numberKNO);
        //опубликовать КНМ
        //проверить, что появилась


    }

    /**
     * Цель: Проверка поиска на странице поиска проверок
     * HP ALM
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "2 - Проверка поиска на странице поиска проверок")
    public void checkSearchSearchPage() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        ListEventsPage event = new ListEventsPage();
        //не требует согласования
        event.addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        //опубликовать эту кнм и найти ее
        //  searchRequest(numberKNM);
        //  checkObject(numberKNM);
        //переходим в оч
        //переход на страницу поиск проверок
        //searchEventsWithCaptcha(numberKNO);
        //опубликовать КНМ
        //проверить, что появилась

    }

    /**
     * Цель: Проверка доступности новости для открытой части
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=54
     * @author Frolova S.I 02.2022
     */
    @Test(description = "3 - Проверка доступности новости для открытой части")
    public void displayNewsOnNewsPage() {
        authorization("admin");
        choiceERKNM();NewsPage news = new NewsPage();
        news.goToManagementNews();
        news.addNews(typeItemNews, visibleNewsItemOpenPart, titleNews, shortText, textNews, currentDate);
        logout();
        openERKNM();
        gotoNewsOpenPage();
        news.searchNewsInTableUser(prefix + "автотест ЗаголовокОЧ",true);

    }


}
