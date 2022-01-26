package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Common {

    //public String url = "http://private.proverki.local/";
    public String url = "http://private.proverki.local/private/knms";
    // public String url ="http://private.proverki.local/";

    String message = "Подтверждаю ознакомление с информацией";
    String messageButton = "//button[text()='Подтверждаю ознакомление с информацией']"; //кнопка на временной форме с информацией
    public String nameProsecutor = "Сергеев Прокурор Пётр";
    //public String nameSupervisor = "Петров КНО Сергей";
    //public String nameSupervisor = "Петров Сергей";
    public String nameSupervisor = "Иванов Семён";
    public String nameOmbudsman = "Иванов Омбудсмен Семён";
    public String nameAdmin = "Администратор системы";
    public String exitButton = "//*[text()= 'Выйти']";

    //режимы ЕРКНМ и ЕРП
    public String modeERKNM = "//*[text()='ЕРКНМ']";
    public String modeERP = "//*[text()='ЕРП']";

    public String nameKNO = "Федеральная служба по надзору в сфере здравоохранения";
    public String viewKNO = "066 - Федеральный государственный контроль (надзор) в сфере обращения лекарственных средств";
    public String prosecutorsOffice = "РОССИЯ - состав федеральных округов, Генеральная прокуратура Российской Федерации";

    public String loginProsecutor = "prosecutor"; //логин прокурора
    //public String loginSupervisor = "supervisor"; //логин сотрудника КНО
    public String loginSupervisor = "supervisor1"; //логин сотрудника КНО
    public String loginOmbudsman = "ombudsman"; //логин омбудсмена
    public String loginAdmin = "admin"; //логин администратора
    public String password = "%%%%%%%%"; //пароль ко всем ролям
    //public String password = "%%%%%%%%"; //пароль к сотруднику КНО на СГК
    public String wrongLogin = "wrongLogin"; //некорректный логин
    public String wrongPassword = "wrongPassword"; //некорректный пароль
    public String loginText = "Вход в систему"; //приветствие на странице авторизации
    public String loginWrongMessage = "Пользователь с таким именем не найден."; //сообщение при некорректной авторизации

    //Основное меню (на всех страницах)
    public String listEvents = "Список КНМ";
    public String listPreventionEvents = "Список ПМ";
    public String listPlans = "Список планов";
    public String importExport = "Импорт/Экспорт";
    public String matchResolution = "Разрешение совпадений";
    public String searchEvents = "Поиск мероприятий";
    public String news = "Новости";
    public String reports = "Отчеты";
    public String feedback = "Обратная связь";

    //Виды КНМ
    public String controlPurchase = "Контрольная закупка";
    public String raidInspection = "Рейдовый осмотр";
    public String selectiveControl = "Выборочный контроль";
    public String inspectionVisit = "Инспекционный визит";
    public String monitoringPurchase = "Мониторинговая закупка";
    public String documentaryVerification = "Документарная проверка";
    public String onsiteInspection = "Выездная проверка";

    //Характер КНМ
    public String plannedCheck = "Плановое КНМ";
    public String plannedCheckFZ = "Плановая проверка по 248-ФЗ(утвержденная по плану 294-ФЗ)";
    public String unplannedCheck = "Внеплановое КНМ";


    //страница авторизации
    String loginField = "//*[@name='username']"; //поле Логин
    String passwordField = "//*[@name='password']"; //поле Пароль
    String enterButton = "//*[@type='submit']"; //кнопка Войти

    String searchField = "//*[@name='searchString']"; //поле Поиска
    String searchButton = "//button[text()='Искать']"; //кнопка Искать
    String addButton = "//*[text()='Добавить']"; //кнопка Добавить
    String saveButton = "//*[text()='Сохранить']"; //кнопка Сохранить
    String createButton = "//*[text()='Создать']"; //кнопка Создать
    String uploadButton = "//button[text()='Загрузить']"; //кнопка Загрузить
    //String actionsButton = "/html/body/div/div/main/form/div[1]/div[1]/div[2]/button[2]"; //кнопка для открытия выпадающего списка Действия
    // String actionsButton = "//button[text()='Действия']"; //кнопка для открытия выпадающего списка Действия
    String actionsButton = "//*[@id=\"root\"]/div/header/div/div[2]/button[2]"; //кнопка для открытия выпадающего списка Действия
    public String deleteButton = "//button[text()='Удалить']";
    public String signatureButton = "//button[text()='Подписать']";
    String openRequest = "//*[(@class='shared-table-link')]"; // открытие найденной записи

    public String INN = "7811689828";

    public String menuButton = "//header//div[contains(@class,'Dropdown')]//button";

    /**
     * Нажатие на кнопку подтверждающая ознакомеление с информацией
     */
    public void clickMessageButton() {
        $(By.xpath(messageButton)).shouldHave(text(message)).click();
    }

    /**
     * Переключиться в режим ЕРКНМ
     */
    public void choiceERKNM() {
        $(By.xpath(modeERKNM)).click();
    }

    /**
     * Переключиться в режим ЕРП
     */
    public void choiceERP() {
        $(By.xpath(modeERP)).click();
    }

    /**
     * Заполнение поля Логин
     *
     * @param login
     */
    public void setLogin(String login) {
        $(By.xpath(loginField)).setValue(login);
    }

    /**
     * Заполнение поля Пароль
     *
     * @param pass
     */
    public void setPassword(String pass) {
        $(By.xpath(passwordField)).setValue(pass);
    }

    /**
     * Нажатие на кнопку Войти
     */
    public void clickEnterButton() {
        $(By.xpath(enterButton)).shouldHave(text("Войти")).click();
        //$(By.xpath(enterButton)).click();
    }

    /**
     * Нажатие на кнопку Загрузить
     */
    public void clickUploadButton() {
        $(By.xpath(uploadButton)).click();
    }

    /**
     * Нажатие на кнопку Подписать
     */
    public void clickSignatureButton() {
        $(By.xpath(signatureButton)).click();
    }

    /**
     * Заполнение поиска
     *
     * @param value
     */
    public void setSearchField(String value) {
        $(By.xpath(searchField)).setValue(value);
    }

    /**
     * Кнопка Искать
     */
    public void clickSearchButton() {
        $(By.xpath(searchButton)).shouldHave(text("Искать")).click();
    }

    /**
     * Поиск
     *
     * @param value
     */
    public void searchRequest(String value) {
        setSearchField(value);
        clickSearchButton();
    }

    /**
     * Открытие найденной карточки
     */
    public void openRequest(String value) {
        setSearchField(value);
        clickSearchButton();
        $(By.xpath(openRequest)).click();

    }

    /**
     * Кнопка Добавить
     */
    public void clickAddButton() {
        $(By.xpath(addButton)).shouldHave(Condition.text("Добавить")).click();
    }


    /**
     * Кнопка Сохранить
     */
    public void clickSaveButton() {
        $(By.xpath(saveButton)).shouldHave(text("Сохранить")).click();
    }

    /**
     * Переход в список КНМ
     */
    public void gotoListKNMPage() {
        // $(By.xpath(tests.listEvents)).shouldHave(text("Список КНМ")).click();
        clickToText(listEvents);
    }

    /**
     * Переход в список ПМ
     */
    public void gotoListPreventionEventsPage() {
        // $(By.xpath(tests.listPreventionEvents)).shouldHave(text("Список ПМ")).click();
        clickToText(listPreventionEvents);
    }

    /**
     * Переход в список планов
     */
    public void gotoListPlansPage() {
        // $(By.xpath(tests.listPlans)).shouldHave(text("Список планов")).click();
        clickToText(listPlans);
    }

    /**
     * Переход в отчеты
     */
    public void gotoReportsPage() {
        //$(By.xpath(tests.reports)).shouldHave(text("Отчеты")).click();
        clickToText(reports);
    }

    /**
     * Переход в новости
     */
    public void gotoNewsPage() {
        clickToText(news);
    }


    /**
     * Универсальный метод для поиска по тексту и клик на это место
     *
     * @param text
     */
    public void clickToText(String text) {
        String newXpath = "//*[text()='" + text + "']";
        $(By.xpath(newXpath)).click();
    }


    /**
     * Нажать кнопку Создать
     */
    public void clickCreateButton() {
        $(By.xpath(createButton)).click();
    }

    /**
     * Авторизация в системе
     *
     * @param person
     */
    public void authorization(String person) {
        authorization(person, true);
        clickMessageButton();
    }

    public void authorization(String person, boolean message){
        open(url);
        if (person == "admin") {
            setLogin(loginAdmin);
        } else if (person == "prosecutor") {
            setLogin(loginProsecutor);
        } else if (person == "supervisor") {
            setLogin(loginSupervisor);
        } else if (person == "ombudsmen") {
            setLogin(loginOmbudsman);
        }
        setPassword(password);
        clickEnterButton();
        //проверка 2
    }

    /**
     * Проверка созданного объекта
     */
    public void checkObject(String name) {
        $(By.xpath("//*[contains(text(),'" + name + "')]")).shouldBe(visible);
    }

    /**
     * Проверка отсутствия объекта
     */
    public void checkAbsenceObject(String name) {
        $(By.xpath("//*[contains(text(),'" + name + "')]")).shouldBe(exist);
    }

    /**
     * Нажатие на кнопку Действия
     */
    public void clickActionButton() {
        $(By.xpath(actionsButton)).click();
    }

    /**
     * Нажать на кнопку Удалить
     */
    public void clickDeleteButton() {
        $(By.xpath(deleteButton)).shouldBe(visible).click();
    }

    /**
     * Нажать на кнопку Выйти
     */
    public void logout() {
        $(By.xpath(menuButton)).click();
        $(By.xpath(exitButton)).click();
    }
}


