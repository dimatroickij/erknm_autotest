package erknm_gui_autotest.src.java.testCases.auth;

import org.testng.annotations.Test;
import erknm_gui_autotest.src.java.testPages.Common;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest extends Common {

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "1 - Авторизация")
    public void authorizationSomeTest() {
        open(url);
        setLogin(loginProsecutor);
        setPassword(password);
        clickEnterButton();
        //TODO или добавить проверку для теста или сделать метод - Авторизация
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "2 - Проверка изменения раздела при переключении режимов ЕРКНМ и ЕРП")
    public void choiсeModeERKNMTest(){
        authorization("prosecutor");
        choiceERKNM();
        checkObject("Список КНМ");
        checkObject("Список ПМ");
        checkObject("Список планов");
        checkObject("Аналитика");
        checkObject("Импорт/Экспорт");
        checkObject("Поиск мероприятий");
        checkObject("Новости");
        checkObject("Отчеты");
        checkObject("Обратная связь");
        choiceERP();
        checkObject("Список проверок");
        checkObject("Список планов");
        checkObject("Аналитика");
        checkObject("Импорт/Экспорт");
        checkObject("Разрешение совпадений");
        checkObject("Поиск проверок");
        checkObject("Новости");
        checkObject("Отчеты");
        checkObject("Обратная связь");
    }

}
