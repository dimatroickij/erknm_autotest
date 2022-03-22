package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Common {

    public String url = "http://private.proverki.local/";
    public String openUrl = "http://proverki.local/portal"; //открытая часть

    //public String url = "http://private.proverki.local/private/auth";
    //public String openUrl = "http://proverki.local/portal"; //открытая часть

    //public String url = "http://private.proverki.local/private/knms";
    //public String openUrl = "http://proverki.local"; //открытая часть
    // public String url ="http://private.proverki.local/";

    //public String INN = "7811689828"; //инн для дев и демо стенда
    public String INN = "1215043750"; //инн для тестового стенда

    public String urlPlugin = "https://chrome.google.com/webstore/detail/cryptopro-extension-for-c/iifchhfnnmpdbibifmljnfjhpififfog"; //ссылка для установки браузера
    public String installPluginButton = "//*[text()='Установить']"; //кнопка Установить плагин

    public String filePath = ".\\file\\sign.docx";
    public String signPath = ".\\file\\sign.docx.sig";

    String message = "Подтверждаю ознакомление с информацией";
    String messageButton = "//button[text()='Подтверждаю ознакомление с информацией']"; //кнопка на временной форме с информацией
    public String exitButton = "//*[text()= 'Выйти']";

    //режимы ЕРКНМ и ЕРП
    public String modeERKNM = "//*[text()='ЕРКНМ']";
    public String modeERP = "//*[text()='ЕРП']";

    public String nameKNO = "Федеральная служба по надзору в сфере здравоохранения";
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
    public String listEvents = "Список КНМ";
    public String listEventsERP = "Список проверок";
    public String listPreventionEvents = "Список ПМ";
    public String listPlans = "Список планов";
    public String importExport = "Импорт/Экспорт";
    public String matchResolution = "Разрешение совпадений";
    public String searchEvents = "Поиск мероприятий";
    public String searchEventsERP = "Поиск проверок";
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

    //Необходимость согласования
    public String needCoordination = "Требует согласования";
    public String doesNotRequire = "Не требует согласования";

    public String approved = "Согласовано";
    public String positionDirector = "Руководитель Росздравнадзора";
    public String positionDirectorTerritorialAuthority = "Руководитель Территориального органа Росздравнадзора";
    public String familiarWith = "Ознакомлен";

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
    public String templateSheets; // Проверочный лист, созданный при помощи bvt
    public String templateMandatoryRequirements; // Обязательное требование, созданное при помощи bvt
    public String resresentative; // Уполномоченный на проведение проверки, созданный при помощи bvt

    //информация для заполнения КНМ
    public String number = "1";
    public String place = "место";
    public String fio = "ФИО";

    //страница авторизации
    String loginField = "//*[@name='username']"; //поле Логин
    String passwordField = "//*[@name='password']"; //поле Пароль
    String enterButton = "//*[@type='submit']"; //кнопка Войти

    String searchField = "//*[@name='searchString']"; //поле Поиска
    String searchButton = "//button[@id='searchButton']"; //кнопка Искать
    String addButton = "//button[@id='addButton']"; //кнопка Добавить
    String saveButton = "//button[@id='saveButton']"; //кнопка Сохранить
    String createButton = "//*[@id='createButton']"; //кнопка Создать
    String uploadButton = "//*[@id='uploadButton']"; //кнопка Загрузить
    //String actionsOnCardButton = "//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия на карточке
    String actionsOnCardButton = "/html/body/div/div/main/form/div[1]/div[1]/div[2]/div/button"; //кнопка для открытия выпадающего списка Действия на карточке
    //TODO:
    String actionsHeaderButton = "//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия, в header
    String actionsButton = "//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия

    public String deleteButton = "//*[@id='deleteButton']"; //кнопка Удалить
    public String confirmDeleteButton = "//*[@id='confirmButton']"; //кнопка Удалить на форме подтверждения удаления
    public String signatureButton = "//button[@id='signButton']"; //кнопка Подписать
    String openRequest = "//*[(@class='shared-table-link')]"; // открытие найденной записи
    public String closeMessageButton = "//*[contains(@class,'Notification_CloseButton')]"; //крестик у сообщения в правом верхнем углу

    //общее для новостей
    public String visibleNewsItemProsecutor = "//*[text()='Работник прокуратуры']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String typeItemNews = "//*[text()='Новость']";

    public String menuButton = "//header/div/div[last()]//button";
    public String currentDate = "";
    public String futureDate = "";
    public String choiceSignature ="//*[@id='certs']/div/div[1]";
    public String signatureName ="12005D4AC72E6F833CFE5DE8CF0001005D4AC7; Восход; 20.01.2022-20.04.2022;";

    @BeforeSuite //для отчетов
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // либо для тонкой настройки:
       /* SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );*/
    }

    @BeforeSuite //получение текущей даты и будущей даты
    public void setupDate() {
        currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        Calendar calendar = Calendar.getInstance();
        futureDate = calendar.get(Calendar.DAY_OF_MONTH) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + (calendar.get(Calendar.YEAR) + 1);

    }
//при проблемах с предустановкой плагина, разобраться с запуском браузера с плагином
    // @BeforeSuite //настройка браузера
    //public void setupBrowser() {
      /*ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\MyWork\\AppData\\Local\\Google\\Chrome\\User Data\\Default");*/

    // Configuration.baseUrl = url;
       /*ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--enable-extensions");
        options.addArguments("C:\\Users\\MyWork\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;*/

    //запуск через chrome c плагином, проблема с генерацией файла *.crx
      /* ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\soft\\chromePl\\1.2.8_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);*/

       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\MyWork\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        Configuration.browserCapabilities = options;*/

    //запуск фф, предсозданный профиль autotest, по умолчанию хром. слишком большое время ответа от фф
       /* System.setProperty("selenide.browser", "firefox");
        System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\MyWork\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\xv3rzf2u.autotest"));
        FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(profile);
               // .setAcceptInsecureCerts(true)
               // .addPreference("general.useragent.override", "some UA string");
                //.merge(capabilities);
         new FirefoxDriver(firefoxOptions);*/

    /*    System.setProperty("selenide.browser", "firefox");
        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(new File("C:\\soft\\pl\\cryptopro_extension_for_cades_browser_plug_in-1.1.1-an+fx-windows.xpi"));
        profile.setPreference("extensions.firebug.showFirstRunPage", false);
        profile.setPreference("extensions.firebug.allPagesActivation", "on");
        profile.setPreference("intl.accept_languages", "no,en-us,en");
        profile.setPreference("extensions.firebug.console.enableSites", "true");
        return profile;*/

        /*Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(SOME_CAP, "SOME_VALUE_FROM_CONFIGURATION");*/
       /* ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(("load-extension=C:\\Users\\MyWork\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions"));
        chromeOptions.addExtensions(new File("/path/to/extension.crx"));
        //Configuration.browserCapabilities = new DesiredCapabilities();
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        ChromeDriver driver = new ChromeDriver(capabilities);*/
    //Configuration.browser = (getPropertyConfig("browser"));
    // System.setProperty("chromeoptions.prefs", "profile.default_content_settings.popups=0,download.default_directory=<Download folder Location>");
    // }

    /**
     * Установка плагина для подписания
     */
    @Step("Установка плагина для подписания")
    public void installPlugin() {
        open(urlPlugin);
        $(By.xpath(installPluginButton)).click();
        try {
            Robot r = new Robot();
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000));
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_TAB);
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000));
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Нажатие на кнопку подтверждающая ознакомеление с информацией
     */
    @Step("Нажатие на кнопку подтверждающая ознакомеление с информацией")
    public void clickMessageButton() {
        $(By.xpath(messageButton)).shouldHave(text(message)).click();
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
     * Выбор подписи из выпадающего списка
     */
    @Step("Выбор подписи из выпадающего списка")
    public void choiceSignature() {
        $(By.xpath(choiceSignature)).click();
        clickToText(signatureName);
    }

    /**
     * Заполнение поиска
     *
     * @param value Поисковый запрос
     */
    @Step("Заполнение поиска - {value}")
    public void setSearchField(String value) {
        $(By.xpath(searchField)).setValue(value);
    }

    /**
     * Нажатие на кнопку Искать
     */
    @Step("Нажатие на кнопку Искать")
    public void clickSearchButton() {
        $(By.xpath(searchButton)).shouldHave(text("Искать")).click();
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
     * Открытие найденной карточки проверки или ПМ
     *
     * @param value Номер карточки
     */
    @Step("Открытие найденной карточки - {value}")
    public void openCard(String value) {
        setSearchField(value);
        clickSearchButton();
        $(By.xpath(openRequest)).click();
        switchTo().window(1);

    }

    /**
     * Открытие найденной карточки плана
     *
     * @param value Номер карточки
     */
    @Step("Открытие найденной карточки плана- {value}")
    public void openCardPlan(String value) {
        setSearchField(value);
        clickSearchButton();
        $(By.xpath(openRequest)).click();

    }

    /**
     * Нажатие на кнопку Добавить
     */
    @Step("Нажатие на кнопку Добавить")
    public void clickAddButton() {
        $(By.xpath(addButton)).shouldHave(Condition.text("Добавить")).click();
    }


    /**
     * Нажатие на кнопку Сохранить
     */
    @Step("Нажатие на кнопку Сохранить")
    public void clickSaveButton() {
        $(By.xpath(saveButton)).shouldHave(text("Сохранить")).click();
    }

    /**
     * Переход в список КНМ
     */
    @Step("Переход в список КНМ")
    public void gotoListKNMPage() {
        // $(By.xpath(tests.listEvents)).shouldHave(text("Список КНМ")).click();
        clickToText(listEvents);
    }

    /**
     * Переход в список КНМ в режиме ЕРП
     */
    public void gotoERPListKNMPage() {
        // $(By.xpath(tests.listEvents)).shouldHave(text("Список КНМ")).click();
        clickToText(listEventsERP);
    }

    /**
     * Переход в список ПМ
     */
    @Step("Переход в список ПМ")
    public void gotoListPreventionEventsPage() {
        // $(By.xpath(tests.listPreventionEvents)).shouldHave(text("Список ПМ")).click();
        clickToText(listPreventionEvents);
    }

    /**
     * Переход в список планов
     */
    @Step("Переход в список планов")
    public void gotoListPlansPage() {
        // $(By.xpath(tests.listPlans)).shouldHave(text("Список планов")).click();
        clickToText(listPlans);
    }

    /**
     * Переход в отчеты
     */
    @Step("Переход в отчеты")
    public void gotoReportsPage() {
        //$(By.xpath(tests.reports)).shouldHave(text("Отчеты")).click();
        clickToText(reports);
    }

    /**
     * Переход в новости
     */
    @Step("Переход в новости")
    public void gotoNewsPage() {
        clickToText(news);
    }

    /**
     * Переход в Поиск проверок, режим ЕРП
     */
    @Step("Переход в Поиск проверок, режим ЕРП")
    public void gotoSearchEvents() {
        clickToText(searchEventsERP);
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
        authorization(person, true);
        clickMessageButton();
    }

    @Step("Авторизация. Пользователь - {person}")
    public void authorization(String person, boolean message) {
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
        //$(By.xpath("//*[contains(text(),'" + name + "')]")).shouldBe(exist);
        $(By.xpath("//*[contains(text(),'" + name + "')]")).shouldBe(visible);
    }

    /**
     * Нажатие на кнопку Действия на странице с таблицей
     */
    @Step("Нажатие на кнопку Действия на странице с таблицей")
    public void clickActionButton() {
        $(By.xpath(actionsButton)).click();
    }

    /**
     * Нажатие на кнопку Действия на странице КНМ
     */
    @Step("Нажатие на кнопку Действия на странице КНМ")
    public void clickActionsOnCardButton() {
        $(By.xpath(actionsOnCardButton)).shouldBe(visible).click();
    }

    /**
     * Нажатие на кнопку Действия, когда она в header
     */
    @Step("Нажатие на кнопку Действия, когда она в header")
    public void clickActionsHeaderButton() {
        $(By.xpath(actionsHeaderButton)).shouldBe(visible).click();
    }

    /**
     * Нажатие на кнопку Удалить
     */
    @Step("Нажатие на кнопку Удалить")
    public void clickDeleteButton() {
        $(By.xpath(deleteButton)).shouldBe(visible).click();
    }

    /**
     * Нажатие на крестик закрытия сообщения
     */
    @Step("Нажатие на крестик закрытия сообщения")
    public void closeNotification() {
        $(By.xpath(closeMessageButton)).should(visible, Duration.ofSeconds(10)).click();
    }

    /**
     * Нажатие на кнопку Удалить на форме подтверждения удаления
     */
    @Step("Нажатие на кнопку Удалить на форме подтверждения удаления")
    public void clickConfirmDeleteButton() {
        $(By.xpath(confirmDeleteButton)).shouldBe(visible).click();
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


}


