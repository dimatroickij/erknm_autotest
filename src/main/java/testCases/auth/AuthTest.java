package testCases.auth;

import org.testng.annotations.Test;
import testPages.Common;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest extends Common {

    public AuthTest() throws Exception {
    }

    /**
     * Цель: Авторизация
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Авторизация")
    public void authorizationSomeTest() throws Exception {
        open(url);
        setLogin("supervisor");
        setPassword(readParameters.getParameter("user", "supervisor"));
        clickEnterButton();
        logout();
    }

    /**
     * Цель: Проверка изменения раздела при переключении режимов ЕРКНМ и ЕРП
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Проверка изменения раздела при переключении режимов ЕРКНМ и ЕРП")
    public void choiceModeERKNMTest() throws Exception {
        authorization("prosecutor");
        choiceMode(true);
        checkObject("Список КНМ");
        checkObject("Список ПМ");
        checkObject("Список планов");
        checkObject("Аналитика");
        checkObject("Импорт/Экспорт");
        checkObject("Поиск мероприятий");
        checkObject("Новости");
        checkObject("Отчеты");
        checkObject("Обратная связь");
        choiceMode(false);
        checkObject("Список проверок");
        checkObject("Список планов");
        checkObject("Аналитика");
        checkObject("Импорт/Экспорт");
        checkObject("Разрешение совпадений");
        checkObject("Поиск проверок");
        checkObject("Новости");
        checkObject("Отчеты");
        checkObject("Обратная связь");
        Common.setupAllureReports(); // TODO Костыль
        logout();
    }

}
