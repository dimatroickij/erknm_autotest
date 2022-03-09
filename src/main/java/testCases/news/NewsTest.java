package testCases.news;

import org.testng.annotations.Test;
import testPages.NewsPage;

import java.util.Random;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;

public class NewsTest extends NewsPage {
    // раздел Новости
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);
    String titleNews = prefix + "автотест Заголовок";
    String shortText = prefix + "автотест Краткий текст новости";
    String textNews = prefix + "автотест Текст новости";

    /**
     * Цель: Добавление новости
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=54
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавление новости")
    public void createNewsTest() {
        authorization("admin");
        choiceERKNM();
        goToManagementNews();
        addNews(typeItemNews, visibleNewsItemProsecutor, titleNews, shortText, textNews, currentDate);
        searchNewsInTableAdmin(titleNews, true);
        logout();
        authorization("prosecutor");
        choiceERKNM();
        gotoNewsPage();
        searchNewsInTableUser(titleNews, true);
        logout();
    }

    /**
     * Цель: Редактирование новости
     * HP ALM
     *
     * @author Troickij D. I. 01.2022
     */
    @Test(description = "2 - Редактирование новости")
    public void editNewsTest() {
        authorization("admin");
        choiceERKNM();
        goToManagementNews();
        goToNews();
        String prefix = UUID.randomUUID().toString();
        String lastTitleNewsField = getTitleNewsField();
        setTitleNewsField(prefix + "автотест Заголовок");
        setShortTextNewsField(prefix + "автотест Краткий текст новости");
        setTextNewsField(prefix + "автотест Текст новости");
        clickSaveButton();
        clickApplyButton();
        clickBackButton();
        searchNewsInTableAdmin(prefix + "автотест Заголовок", true);
        searchNewsInTableAdmin(lastTitleNewsField, false);
        logout();
        authorization("prosecutor");
        choiceERKNM();
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотест Заголовок", true);
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }

    /**
     * Цель: Удаление новости
     * HP ALM
     *
     * @author Troickij D. I. 01.2022
     */
    @Test(description = "3 - Удаление новости")
    public void deleteNewsTest() {
        authorization("admin");
        choiceERKNM();
        goToManagementNews();
        goToNews();
        String lastTitleNewsField = getTitleNewsField();
        clickRemoveFromPublicationNewsButton();
        clickBackButton();
        logout();
        authorization("prosecutor");
        choiceERKNM();
        gotoNewsPage();
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }


}
