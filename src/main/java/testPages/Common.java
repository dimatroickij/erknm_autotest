package testPages;

import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Common {

    public ReadParameters readParameters = new ReadParameters();

    public String url = readParameters.getParameter("url", "demo");
    public String openUrl = readParameters.getPublicUrl("demo");
    public String urlPlugin = "https://chrome.google.com/webstore/detail/cryptopro-extension-for-c/iifchhfnnmpdbibifmljnfjhpififfog"; //ссылка для установки браузера
    public String installPluginButton = "//*[text()='Установить']"; //кнопка Установить плагин

    public String filePath = ".\\file\\sign.docx";
    public String signPath = ".\\file\\sign.docx.sig";


    String messageButton = "//div[contains(@class, 'CheckNotificationModal')]//button"; //кнопка на временной форме с информацией TODO должен быть идентификатор
    public String exitButton = "//*[@id='logoutButton']";

    public String confirmButton = "//*[@id='confirmButton']"; // Кнопка Применить
    public String backButton = "//button[text()='Назад']"; // TODO должен быть идентификатор

    //режимы ЕРКНМ и ЕРП
    public String modeERKNM = "//*[text()='ЕРКНМ']"; // TODO должен быть идентификатор
    public String modeERP = "//*[text()='ЕРП']"; // TODO должен быть идентификатор

    public String nameKNO = "Федеральная служба по надзору в сфере здравоохранения";
    public String viewKNO = "066 - Федеральный государственный контроль (надзор) в сфере обращения лекарственных средств";
    public String viewKNOERP = "1.176 294 ФЗ  - Выборочный контроль качества биомедицинских клеточных продуктов.";
    public String prosecutorPlan = "Генеральная прокуратура Российской Федерации";
    public String prosecutorsOffice = "РОССИЯ - состав федеральных округов, Генеральная прокуратура Российской Федерации";
    public String grounds = "5.0.3 (ФЗ 248) В связи с отношением объектов контроля к категориям чрезвычайно высокого, высокого и значительного риска";

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

    //Необходимость согласования
    public String needCoordination = "Требует согласования";
    public String doesNotRequire = "Не требует согласования";

    public String approved = "Согласовано";
    public String positionDirector = "Руководитель Росздравнадзора";
    public String positionDirectorTerritorialAuthority = "Руководитель Территориального органа Росздравнадзора";
    public String positionSpecialistExpert = "Специалист-эксперт отдела Территориального органа Росздравнадзора";
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
    public static String templateSheets; // Проверочный лист, созданный при помощи bvt
    public static String templateMandatoryRequirements; // Обязательное требование, созданное при помощи bvt
    public static String representative; // Уполномоченный на проведение проверки, созданный при помощи bvt

    public static String numberPublishedKNMBVT;//номер опубликованной внеплановой КНМ, созданной при bvt
    public static String numberUnpublishedKNMBVT; //номер неопубликованной КНМ, созданной при bvt

    String selectValueByText = "//div[contains(@class, 'SelectInput_Option') and text()='%s']"; // Локатор для выбора значения в выпадающем списке по тексту
    String selectValueByNumber = "//div[contains(@class, 'SelectInput_Option')][%s]"; // Локатор для выбора значения в выпадающем списке по номеру

    public String successfullySignNotification = "//div[contains(@class, 'Notification_ClosingNotificationText') and text() ='Паспорт КНМ успешно подписан']";
    //информация для заполнения КНМ
    public String number = "1";
    public String place = "место";
    public String fio = "ФИО";

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
    String actionsHeaderButton = "//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия, в header TODO должен быть идентификатор
    public String deleteButton = "//*[@id='deleteButton']";
    public String deleteOnCardButton = "//button[text()='Удалить']"; // TODO должен быть идентификатор
    public String signatureButton = "//*[@id='signButton']";
    String openRequest = "//*[(@class='shared-table-link')]"; // открытие найденной записи
    public String closeMessageButton = "//*[contains(@class,'Notification_CloseButton')]"; //крестик у сообщения в правом верхнем углу TODO должен быть идентификатор

    //общее для новостей
    public String visibleNewsItemProsecutor = "//*[text()='Работник прокуратуры']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String typeItemNews = "//*[text()='Новость']";
    public String INN = readParameters.getParameter("information", "inn");// "7811689828";
    public String menuButton = "//*[@id='userMenuButton']";
    public static String currentDate = "";
    public static String currentDateTime = "";
    public static String futureDate = "";
    public String choiceSignature = "//*[@id='certs']/div/div[1]";

    public String exclusionGround = "В связи с ликвидацией организации, прекращением гражданином деятельности в качестве индивидуального предпринимателя, влекущими невозможность проведения контрольного (надзорного) мероприятия";

    public Common() throws Exception {
    }

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

        try {
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
        } catch (ElementNotFound ignored) {
        }
    }

    /**
     * Нажатие на кнопку подтверждающая ознакомление с информацией
     */
    @Step("Нажатие на кнопку подтверждающая ознакомление с информацией")
    public void clickMessageButton() {
        try {
            $(By.xpath(messageButton)).click();
            sleep(2000); // TODO Костыль из-за перезагрузки страницы после авторизации
        } catch (ElementNotFound ignored) {
        }
    }

    /**
     * Переключение в режимы ЕРКНМ / ЕРП
     *
     * @param mode true - ЕРКНМ, false - ЕРП
     */
    public void choiceMode(boolean mode) {
        if (mode)
            $(By.xpath(modeERKNM)).click();
        else
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
        sleep(5000);
        $(By.xpath(choiceSignature)).click();
        setValueDropDownToNumber(2);
//        clickToText(signatureName);
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
     * Открытие найденной карточки проверки или ПМ
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
    @Step("Переход в Поиск проверок, режим ЕРП")
    public void gotoSearchEvents() {
        $(By.xpath(searchEventsERP)).click();
    }

    /**
     * Переход в раздел Обратная связь
     */
    @Step("Переход в раздел Обратная связь")
    public void gotoFeedBack() {
        $(By.xpath(feedback)).click();
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
    public void authorization(String person) throws Exception {
        clearBrowserCookies();
        open(url);
        setLogin(person);
        String password = readParameters.getParameter("user", person);
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
        $(By.xpath("//*[contains(text(),'" + name + "')]")).shouldNotBe(exist);
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
        $(By.xpath("//div[@id='root']")).scrollIntoView(false);
        //$(By.xpath(actionsOnCardButton)).click();
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
     * Нажатие на кнопку Удалить в карточке КНМ
     */
    @Step("Нажатие на кнопку Удалить в карточке КНМ")
    public void clickDeleteOnCardButton() {
        $(By.xpath(deleteOnCardButton)).scrollTo().shouldBe(visible, Duration.ofSeconds(15)).click();
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

    /**
     * Проверка сообщения об успешном подписании
     */
    @Step("Проверка сообщения об успешном подписании")
    public void checkSuccessfullySignNotification() {
        $(By.xpath(successfullySignNotification)).should(visible, Duration.ofSeconds(10));
    }
}


