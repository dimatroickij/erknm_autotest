package testCases.news;

import org.testng.annotations.Test;
import testPages.NewsPage;

import java.util.UUID;

public class NewsERPTest extends NewsPage {
    // Новости в режиме ЕРП

    /*
     author Troickij D. I. 01.2022
     */
    @Test(description = "1 - Добавление новости в режиме ЕРП")
    public void createNewsERPTest() throws InterruptedException {
        authorization("admin");
        choiceERP();
        goToManagementNews();
        clickAddNewsButton();
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        String prefix = UUID.randomUUID().toString();
        setTitleNewsField(prefix + "автотест Заголовок");
        setShortTextNewsField(prefix + "автотест Краткий текст новости");
        setTextNewsField(prefix + "автотест Текст новости");
        setDataPublicationField(currentDate);
        clickSaveNewsButton();
        searchNewsInTableAdmin(prefix + "автотест Заголовок", true);
        logout();
        authorization("prosecutor");
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотест Заголовок", true);
        logout();
        authorization("supervisor");
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотест Заголовок", false);
        logout();
    }

    @Test(description = "2 - Редактирование новости в режиме ЕРП")
    public void editNewsERPTest() {
        authorization("admin", false);
        choiceERP();
        goToManagementNews();
        goToNews();
        String prefix = UUID.randomUUID().toString();
        String lastTitleNewsField = getTitleNewsField();
        setTitleNewsField(prefix + "автотест Заголовок");
        setShortTextNewsField(prefix + "автотест Краткий текст новости");
        setTextNewsField(prefix + "автотест Текст новости");
        clickSaveNewsButton();
        clickApplyWithPublicationsNewsButton();
        clickBackButton();
        searchNewsInTableAdmin(prefix + "автотест Заголовок", true);
        searchNewsInTableAdmin(lastTitleNewsField, false);
        logout();
        authorization("prosecutor", false);
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотест Заголовок", true);
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }

    @Test(description = "3 - Удаление новости в режиме ЕРП")
    public void deleteNewsERPTest() throws InterruptedException {
        authorization("admin", false);
        choiceERP();
        goToManagementNews();
        goToNews();
        String lastTitleNewsField = getTitleNewsField();
        clickRemoveFromPublicationNewsButton();
        clickBackButton();
        logout();
        authorization("prosecutor", false);
        choiceERP();
        gotoNewsPage();
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }
}
