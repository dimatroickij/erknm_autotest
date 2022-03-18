package testPages;

import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Common {

    public String url = "http://private.proverki.local/";
    public String openUrl = "http://proverki.local"; //открытая часть


    public String scriptAddDocument = ".\\testUtils\\choiceDoc.exe";
    public String scriptAddSignature = ".\\testUtils\\choiceSign.exe";


    String messageButton = "//div[contains(@class, 'CheckNotificationModal')]//button"; //кнопка на временной форме с информацией TODO должен быть идентификатор
    public String exitButton = "//*[@id='logoutButton']";

    public String confirmButton = "//*[@id='confirmButton']"; // Кнопка Применить
    public String backButton = "//button[text()='Назад']"; // TODO должен быть идентификатор

    //режимы ЕРКНМ и ЕРП
    public String modeERKNM = "//*[text()='ЕРКНМ']"; // TODO должен быть идентификатор
    public String modeERP = "//*[text()='ЕРП']"; // TODO должен быть идентификатор

    public String nameKNO = "Федеральная служба по надзору в сфере здравоохранения";
    public String codeKNO = "10000001127";
    public String viewKNO = "066 - Федеральный государственный контроль (надзор) в сфере обращения лекарственных средств";
    public String viewKNOERP = "1.176 294 ФЗ  - Выборочный контроль качества биомедицинских клеточных продуктов.";
    public String prosecutorsOffice = "РОССИЯ - состав федеральных округов, Генеральная прокуратура Российской Федерации";
    public String grounds = "5.0.3 (ФЗ 248) В связи с отношением объектов контроля к категориям чрезвычайно высокого, высокого и значительного риска";

    public String loginProsecutor = "prosecutor"; //логин прокурора
    public String loginSupervisor = "supervisor"; //логин сотрудника КНО
    public String loginOmbudsman = "ombudsman"; //логин омбудсмена
    public String loginAdmin = "sysadmin"; //логин администратора
    public String password = "%%%%%%%%"; //пароль ко всем ролям
    //public String password = "%%%%%%%%"; //пароль к сотруднику КНО на СГК
    public String wrongLogin = "wrongLogin"; //некорректный логин
    public String wrongPassword = "wrongPassword"; //некорректный пароль
    public String loginText = "Вход в систему"; //приветствие на странице авторизации
    public String loginWrongMessage = "Пользователь с таким именем не найден."; //сообщение при некорректной авторизации

    //Основное меню (на всех страницах)
    public String listEvents = "//*[@id='/private/knms']/a"; // Список КНМ
    public String listEventsERP = "//*[@id='/private/knms']/a"; // Список проверок
    public String listPreventionEvents = "//*[@id='/private/preventions']/a"; // "Список ПМ";
    public String listPlans = "//*[@id='/private/templates']/a"; // Список планов
    public String importExport = "//*[@id='/private/import']/a"; // Импорт/Экспорт
    public String matchResolution = "//*[@id='/private/similarities']/a"; // Разрешение совпадений
    public String searchEvents = "//*[@id='/private/search']/a"; // Поиск мероприятий
    public String searchEventsERP = "//*[@id='/private/search']/a"; // Поиск проверок
    public String news = "//*[@id='/private/news']/a"; // Новости
    public String reports = "//*[@id='/private/reports']/a"; // Отчеты
    public String feedback = "//*[@id='/private/feedback']/a"; // Обратная связь

    //Виды КНМ
    public String controlPurchase = "Контрольная закупка";
    public String raidInspection = "Рейдовый осмотр";
    public String selectiveControl = "Выборочный контроль";
    public String inspectionVisit = "Инспекционный визит";
    public String monitoringPurchase = "Мониторинговая закупка";
    public String documentaryVerification = "Документарная проверка";
    public String onsiteInspection = "Выездная проверка";
    public String unscheduledCheck = "Внеплановая проверка";
    public String scheduleCheck = "Плановая проверка";

    //Характер КНМ
    public String plannedCheck = "Плановое КНМ";
    public String plannedCheckFZ = "Плановая проверка по 248-ФЗ(утвержденная по плану 294-ФЗ)";
    public String unplannedCheck = "Внеплановое КНМ";

    // Форма КНМ
    public String exitForm = "Выездная";
    public String documentaryForm = "Документарная";
    public String exitAndDocumentaryForm = "Документарная и выездная";

    // Тип субъекта КНМ
    public String legalEntity = "ЮЛ/ИП";
    public String publicAuthority = "ОГВ";
    public String localGovernment = "ОМС";

    // Тип места блока Объекты проведения КНМ
    public String locationLE = "Место нахождения юридического лица";

    // тип объекта проведения блока Объекты проведения КНМ
    public String branch = "Филиал";

    // Категория риска
    public String righRisk = "Высокий риск (2 класс)";

    // Статусы проверки в режиме ЕРП
    public String statusProcessConducting = "В процессе проведения";
    public String statusProcessFormation = "В процессе формирования";
    public String statusCompleted = "Завершено";
    public String statusDeleted = "Удалено";

    // Переменные для поиска созданной информации во время bvt теста
    public static String templateSheets; // Проверочный лист, созданный при помощи bvt
    public static String templateMandatoryRequirements; // Обязательное требование, созданное при помощи bvt
    public static String resresentative; // Уполномоченный на проведение проверки, созданный при помощи bvt

    String selectValueByText = "//div[contains(@class, 'SelectInput_Option') and text()='%s']"; // Локатор для выбора значения в выпадающем списке по тексту
    String selectValueByNumber = "//div[contains(@class, 'SelectInput_Option')][%s]"; // Локатор для выбора значения в выпадающем списке по номеру

    //страница авторизации
    String loginField = "//*[@name='username']"; //поле Логин
    String passwordField = "//*[@name='password']"; //поле Пароль
    String enterButton = "//*[@type='submit']"; //кнопка Войти

    String searchField = "//*[@name='searchString']"; //поле Поиска
    String searchButton = "//*[@id='searchButton']"; //кнопка Искать
    String addButton = "//*[@id='addButton']"; //кнопка Добавить
    String modalSaveButton = "//div[contains(@class, 'ModalActions_Container')]//button[contains(text(), 'Сохранить')]"; // Кнопка Сохранить в модальном окне TODO должен быть идентификатор
    String modalAddButton = "//div[contains(@class, 'ModalActions_Container')]//button[1]"; // Кнопка Добавить в модальном окне TODO должен быть идентификатор
    String saveButton = "//*[@id='saveButton']"; //кнопка Сохранить
    String createButton = "//*[@id='createButton']"; //кнопка Создать
    String uploadButton = "//button[text()='Загрузить']"; //кнопка Загрузить
    String actionsButton = "//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия в таблице
    String actionsOnCardButton = "(//*[@id='visibleChangeActionsButton'])[2]"; //кнопка для открытия выпадающего списка Действия на карточке TODO должен быть идентификатор
    public String deleteButton = "//*[@id='deleteButton']";
    public String deleteOnCardButton = "//button[text()='Удалить']"; // TODO должен быть идентификатор
    public String signatureButton = "//*[@id='signButton']";
    String openRequest = "//*[(@class='shared-table-link')]"; // открытие найденной записи
    public String closeMessageButton = "//*[contains(@class,'Notification_CloseButton')]"; //крестик у сообщения в правом верхнем углу TODO должен быть идентификатор

    //общее для новостей
    public String visibleNewsItemProsecutor = "//*[text()='Работник прокуратуры']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String typeItemNews = "//*[text()='Новость']";

    public String INN = "1215212198";

    public String menuButton = "//*[@id='userMenuButton']";
    public static String currentDate = "";
    public static String currentDateTime = "";
    public static String futureDate = "";

    @BeforeSuite
    protected static void setupAllureReports() {
        currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        currentDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());
        Calendar calendar = Calendar.getInstance();
        futureDate = calendar.get(Calendar.DAY_OF_MONTH) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + (calendar.get(Calendar.YEAR) + 1);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // либо для тонкой настройки:
       /* SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );*/
    }

//    @BeforeSuite //получение текущей даты и будущей даты
//    public void setupDate() {
//        currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
//        currentDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());
//        Calendar calendar = Calendar.getInstance();
//        futureDate = calendar.get(Calendar.DAY_OF_MONTH) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + (calendar.get(Calendar.YEAR) + 1);
//
//    }

    /**
     * Нажатие на кнопку подтверждающая ознакомление с информацией
     */
    @Step("Нажатие на кнопку подтверждающая ознакомление с информацией")
    public void clickMessageButton() {
        try {
            $(By.xpath(messageButton)).click();
        } catch (ElementNotFound ignored) {
        }
    }

    /**
     * Переключение в режим ЕРКНМ
     */
    @Step("Переключение в режим ЕРКНМ")
    public void choiceERKNM() {
        $(By.xpath(modeERKNM)).click();
    }

    /**
     * Переключение в режим ЕРП
     */
    @Step("Переключение в режим ЕРП")
    public void choiceERP() {
        $(By.xpath(modeERP)).click();
    }

    /**
     * Заполнение поля Логин
     *
     * @param login Логин
     */
    @Step("Заполнение поля Логин - {login}")
    public void setLogin(String login) {
        $(By.xpath(loginField)).setValue(login);
    }

    /**
     * Заполнение поля Пароль
     *
     * @param pass Пароль
     */
    @Step("Заполнение поля Пароль - {pass}")
    public void setPassword(String pass) {
        $(By.xpath(passwordField)).setValue(pass);
    }

    /**
     * Нажатие на кнопку Войти
     */
    @Step("Нажатие на кнопку Войти")
    public void clickEnterButton() {
        $(By.xpath(enterButton)).shouldHave(text("Войти")).click();
    }

    /**
     * Нажатие на кнопку Загрузить
     */
    @Step("Нажатие на кнопку Загрузить")
    public void clickUploadButton() {
        $(By.xpath(uploadButton)).click();
    }

    /**
     * Нажатие на кнопку Подписать
     */
    @Step("Нажатие на кнопку Подписать")
    public void clickSignatureButton() {
        $(By.xpath(signatureButton)).click();
    }

    /**
     * Заполнение поиска
     *
     * @param value Поисковый запрос
     */
    @Step("Заполнение поиска - {value}")
    public void setSearchField(String value) {
        $(By.xpath(searchField)).scrollIntoView(false).setValue(value);
    }

    /**
     * Нажатие на кнопку Искать
     */
    @Step("Нажатие на кнопку Искать")
    public void clickSearchButton() {
        $(By.xpath(searchButton)).click();
    }


    /**
     * Поиск
     *
     * @param value Поисковый запрос
     */
    @Step("Поиск по значению - {value}")
    public void searchRequest(String value) {
        setSearchField(value);
        clickSearchButton();
    }

    /**
     * Открытие найденной карточки
     *
     * @param value Номер карточки
     */
    @Step("Открытие найденной карточки - {value}")
    public void openCard(String value) {
        setSearchField(value);
        clickSearchButton();
        $(By.xpath(openRequest)).click();
        switchTo().window(getWebDriver().getWindowHandle()).close();
        switchTo().window(0);

    }

    /**
     * Нажатие на кнопку Добавить
     */
    @Step("Нажатие на кнопку Добавить")
    public void clickAddButton() {
        $(By.xpath(addButton)).click();
    }

    /**
     * Нажатие на кнопку Сохранить
     */
    @Step("Нажатие на кнопку Сохранить")
    public void clickSaveButton() {
        $(By.xpath(saveButton)).click();
    }

    /**
     * Переход в список КНМ
     */
    @Step("Переход в список КНМ")
    public void gotoListKNMPage() {
        $(By.xpath(listEvents)).click();
    }

    /**
     * Переход в список КНМ в режиме ЕРП
     */
    @Step("Переход в список КНМ в режиме ЕРП")
    public void gotoERPListKNMPage() {
        $(By.xpath(listEventsERP)).click();
    }

    /**
     * Переход в список ПМ
     */
    @Step("Переход в список ПМ")
    public void gotoListPreventionEventsPage() {
        $(By.xpath(listPreventionEvents)).click();
    }

    /**
     * Переход в список планов
     */
    @Step("Переход в список планов")
    public void gotoListPlansPage() {
        $(By.xpath(listPlans)).click();
    }

    /**
     * Переход в отчеты
     */
    @Step("Переход в отчеты")
    public void gotoReportsPage() {
        $(By.xpath(reports)).click();
    }

    /**
     * Переход в новости
     */
    @Step("Переход в раздел Новости")
    public void gotoNewsPage() {
        $(By.xpath(news)).click();
    }

    /**
     * Переход в Поиск проверок, режим ЕРП
     */
    public void gotoSearchEvents() {
        $(By.xpath(searchEventsERP)).click();
    }


    /**
     * Универсальный метод для поиска по тексту и клик на это место
     *
     * @param text Название поля
     */
    public void clickToText(String text) {
        String newXpath = "//*[text()='" + text + "']";
        $(By.xpath(newXpath)).click();
    }


    /**
     * Нажатие на кнопку Создать
     */
    @Step("Нажатие на кнопку Создать")
    public void clickCreateButton() {
        $(By.xpath(createButton)).click();
    }

    /**
     * Авторизация в системе
     *
     * @param person Логин
     */
    @Step("Авторизация. Пользователь - {person}")
    public void authorization(String person) {
        clearBrowserCookies();
        open(url);
        if (Objects.equals(person, "sysadmin")) {
            setLogin(loginAdmin);
        } else if (Objects.equals(person, "prosecutor")) {
            setLogin(loginProsecutor);
        } else if (Objects.equals(person, "supervisor")) {
            setLogin(loginSupervisor);
        } else if (Objects.equals(person, "ombudsmen")) {
            setLogin(loginOmbudsman);
        }
        setPassword(password);
        clickEnterButton();
        clickMessageButton();
    }

    /**
     * Переход в открытую часть ЕРКНМ
     */
    @Step("Переход в открытую часть ЕРКНМ")
    public void openERKNM() {
        open(openUrl);
    }

    /**
     * Проверка созданного объекта
     *
     * @param name Объект
     */
    @Step("Проверка созданния - {name}")
    public void checkObject(String name) {
        $(By.xpath("//*[contains(text(),'" + name + "')]")).shouldBe(visible);
    }

    /**
     * Проверка отсутствия объекта
     *
     * @param name Объект
     */
    @Step("Проверка отсутствия - {name}")
    public void checkAbsenceObject(String name) {
        $(By.xpath("//*[contains(text(),'" + name + "')]")).shouldBe(exist);
    }

    /**
     * Нажатие на кнопку Действия на странице с таблицей
     */
    @Step("Нажатие на кнопку Действия на странице с таблицей")
    public void clickActionButton() {
        $(By.xpath(actionsButton)).click();
    }

    /**
     * Нажатие на кнопку Действия на карточке
     */
    @Step("Нажатие на кнопку Действия на карточке")
    public void clickActionsOnCardButton() {
        $(By.xpath("//div[@id='root']")).scrollIntoView(false);
        $(By.xpath(actionsOnCardButton)).click();
    }

    /**
     * Нажатие на кнопку Удалить
     */
    @Step("Нажатие на кнопку Удалить")
    public void clickDeleteButton() {
        $(By.xpath(deleteButton)).shouldBe(visible).click();
    }

    /**
     * Нажатие на кнопку Удалить в карточке КНМ
     */
    @Step("Нажатие на кнопку Удалить в карточке КНМ")
    public void clickDeleteOnCardButton() {
        $(By.xpath(deleteOnCardButton)).scrollTo().shouldBe(visible).click();
    }

    /**
     * Нажатие на крестик закрытия сообщения
     */
    @Step("Нажатие на крестик закрытия сообщения")
    public void closeNotification() {
        $(By.xpath(closeMessageButton)).should(visible, Duration.ofSeconds(10)).click();
    }

    /**
     * Нажатие на кнопку Выйти
     */
    @Step("Нажатие на кнопку Выйти")
    public void logout() {
        $(By.xpath("//div[@id='root']")).scrollIntoView(false);
        $(By.xpath(menuButton)).click();
        $(By.xpath(exitButton)).click();
    }

    /**
     * Выбор значения из выпадающего списка по номеру записи
     *
     * @param number Номер в списке
     */
    @Step("Выбор значения из выпадающего списка по номеру записи {number}")
    public void setValueDropDownToNumber(Integer number) {
        $(By.xpath(String.format(selectValueByNumber, number))).click();
    }

    /**
     * Выбор значения из выпадающего списка по тексту
     *
     * @param text Текст
     */
    @Step("Выбор значения из выпадающего списка по тексту {text}")
    public void setValueDropDownToText(String text) {
        $(By.xpath(String.format(selectValueByText, text))).click();
    }

    /**
     * Клик по кнопке Применить или Удалить в модальном окне при подтверждении действия
     */
    @Step("Клик по кнопке Применить или Удалить в модальном окне при подтверждении действия")
    public void clickConfirmButton() {
        $(By.xpath(confirmButton)).click();
    }

    /**
     * Клик по кнопке Назад
     */
    @Step("Клик по кнопке Назад")
    public void clickBackButton() {
        $(By.xpath(backButton)).click();
    }

    /**
     * Скролл по странице в начало
     */
    @Step("Скролл по странице в начало")
    public void scrollTopHtml() {
        $(By.xpath("//h1[contains(@class, 'PersonalAccount_Header')]")).scrollIntoView(false);
    }

    /**
     * Нажатие на кнопку Сохранить в модальном окне
     */
    @Step("Нажатие на кнопку Сохранить в модальном окне")
    public void clickModalSaveButton() {
        $(By.xpath(modalSaveButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить в модальном окне
     */
    @Step("Нажатие на кнопку Добавить в модальном окне")
    public void clickAddModalButton() {
        $(By.xpath(modalAddButton)).click();
    }
}


