package testCases.news;

import org.testng.annotations.Test;
import testPages.NewsPage;

import java.util.UUID;

public class NewsERPTest extends NewsPage {
    // Новости в режиме ЕРП

    /**
     * Цель: Добавление новости в режиме ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=54
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Добавление новости в режиме ЕРП")
    public void createNewsERPTest() {
        authorization("sysadmin");
        closeNotification();
        closeNotification();
        choiceERP();
        goToManagementNews();
        clickAddNewsButton();
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        setTitleNewsField(prefixNews + titleNews);
        setShortTextNewsField(prefixNews + shortTextNews);
        setTextNewsField(prefixNews + textNews);
        setDataPublicationField(currentDate);
        clickSaveNewsButton();
        searchNewsInTableAdmin(prefixNews + titleNews, true);
        logout();
        authorization("prosecutor");
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + titleNews, true);
        logout();
        authorization("supervisor");
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + titleNews, false);
        logout();
    }

    /**
     * Цель: Редактирование новости в режиме ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=549
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Редактирование новости в режиме ЕРП")
    public void editNewsERPTest() {
        authorization("sysadmin");
        closeNotification();
        closeNotification();
        choiceERP();
        goToManagementNews();
        //prefixNews = "bce30994-b55d-490b-bc8b-a7d502de7fa0";
        goToNews(prefixNews + titleNews);
        String lastTitleNewsField = prefixNews + titleNews;
        prefixNews = UUID.randomUUID().toString();
        setTitleNewsField(prefixNews + titleNews);
        setShortTextNewsField(prefixNews + shortTextNews);
        setTextNewsField(prefixNews + textNews);
        clickSaveNewsButton();
        clickApplyWithPublicationsNewsButton();
        clickBackButton();
        searchNewsInTableAdmin(prefixNews + titleNews, true);
        searchNewsInTableAdmin(lastTitleNewsField, false);
        logout();
        authorization("prosecutor");
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + titleNews, true);
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }

    /**
     * Цель: Удаление новости в режиме ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=545
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Удаление новости в режиме ЕРП")
    public void deleteNewsERPTest() {
        authorization("sysadmin");
        closeNotification();
        closeNotification();
        choiceERP();
        goToManagementNews();
        //prefixNews = "004c8543-0c2b-4ef0-b44e-b5acd79b5afd";
        goToNews(prefixNews + titleNews);
        clickRemoveFromPublicationNewsButton();
        clickBackButton();
        logout();
        authorization("prosecutor");
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + textNews, false);
        logout();
    }
}
