package testCases.news;

import org.testng.annotations.Test;
import testPages.NewsPage;

import java.util.UUID;

import static java.lang.Thread.sleep;

public class NewsTest extends NewsPage {
    // Общий класс для работы с разделом Новости
    boolean mode;

    public NewsTest() throws Exception {
    }

    /**
     * Цель: Добавление новости
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=54
     *
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Добавление новости")
    public void createNewsTest() throws Exception {
        authorization("admin");
        closeNotification();
        closeNotification();
        choiceMode(mode);
        goToManagementNews();
        System.out.println("Идентификатор созданной новости " + prefixNews);
        addNews(typeItemNews, visibleNewsItemProsecutor, prefixNews + titleNews,
                prefixNews + shortTextNews, prefixNews + textNews, currentDate);
        searchNewsInTableAdmin(prefixNews + titleNews, true);
        logout();
        authorization("prosecutor");
        choiceMode(mode);
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + titleNews, true);
        logout();
        authorization("supervisor");
        choiceMode(mode);
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + titleNews, false);
        logout();
    }

    /**
     * Цель: Редактирование новости
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=549
     *
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Редактирование новости")
    public void editNewsTest() throws Exception {
        authorization("admin");
        closeNotification();
        closeNotification();
        choiceMode(mode);
        goToManagementNews();
        System.out.println("Идентификатор созданной новости " + prefixNews);
        goToNews(prefixNews + titleNews);
        String lastTitleNewsField = getTitleNewsField();
        prefixNews = UUID.randomUUID().toString();
        System.out.println("Новый идентификатор новости " + prefixNews);
        sleep(2000);
        setTitleNewsField(prefixNews + titleNews);
        setShortTextNewsField(prefixNews + shortTextNews);
        setTextNewsField(prefixNews + textNews);
        clickSaveButton();
        clickConfirmButton();
        closeNotification();
        clickBackButton();
        searchNewsInTableAdmin(prefixNews + titleNews, true);
        searchNewsInTableAdmin(lastTitleNewsField, false);
        logout();
        authorization("prosecutor");
        choiceMode(mode);
        gotoNewsPage();
        searchNewsInTableUser(prefixNews + titleNews, true);
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }

    /**
     * Цель: Удаление новости
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=545
     *
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Удаление новости", dependsOnMethods = {"editNewsTest"})
    public void deleteNewsTest() throws Exception {
        authorization("admin");
        closeNotification();
        closeNotification();
        choiceMode(mode);
        goToManagementNews();
        System.out.println("Идентификатор удаляемой новости " + prefixNews);
        goToNews(prefixNews + titleNews);
        String lastTitleNewsField = getTitleNewsField();
        clickRemoveFromPublicationNewsButton();
        clickBackButton();
        logout();
        authorization("prosecutor");
        choiceMode(mode);
        gotoNewsPage();
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }
}
