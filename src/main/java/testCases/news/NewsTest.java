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

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавление новости")
    public void createNewsERPTest() throws InterruptedException {
        authorization("admin");
        choiceERKNM();
        goToManagementNews();
        clickAddNewsButton();
        setTypeNewsField(typeItemNews);
        setVisibleNewsDropDown(visibleNewsItemProsecutor);
        String prefix = UUID.randomUUID().toString();
        setTitleNewsField(prefix + "автотест Заголовок");
        setShortTextNewsField(prefix + "автотест Краткий текст новости");
        setTextNewsField(prefix + "автотест Текст новости");
        setDataPublicationField();
        clickSaveNewsButton();
        searchNewsInTableAdmin(prefix + "автотест Заголовок", true);
        logout();
        authorization("prosecutor");
        choiceERKNM();
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотест Заголовок", true);
        logout();
    }

    @Test(description = "2 - Редактирование новости")
    public void editNewsERPTest() throws InterruptedException {
        authorization("admin", false);
        choiceERKNM();
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
        choiceERKNM();
        gotoNewsPage();
        searchNewsInTableUser(prefix + "автотест Заголовок", true);
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }

    @Test(description = "3 - Удаление новости")
    public void deleteNewsERPTest() throws InterruptedException {
        authorization("admin");
        choiceERKNM();
        goToManagementNews();
        goToNews();
        String lastTitleNewsField = getTitleNewsField();
        clickRemoveFromPublicationNewsButton();
        clickBackButton();
        logout();
        authorization("prosecutor", false);
        choiceERKNM();
        gotoNewsPage();
        searchNewsInTableUser(lastTitleNewsField, false);
        logout();
    }



}
