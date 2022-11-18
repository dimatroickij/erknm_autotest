package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Thread.sleep;

public class Common {

    // Основные параметры
    public ReadParameters readParameters = new ReadParameters();

    public String url = readParameters.getParameter("url", "test");
    public String openUrl = readParameters.getParameter("url", "testOpen");
    public String employee = "supervisor";  // работник КНО
    public String prosecutor = "prosecutor";  // прокурор
    public String ombudsman = "ombudsman";  // омбудсмен
    public String INN = readParameters.getParameter("information", "inn");
    public String INNIndividual = "123456789101";
    public String INNForeignLegalEntity = "9909380589";
    public String prosecutorPlan = "Генеральная прокуратура Российской Федерации";
    public String prosecutorsOffice = "РОССИЯ";
    public String numberPlan = "2024003601";

    public String urlPlugin = "https://chrome.google.com/webstore/detail/cryptopro-extension-for-c/iifchhfnnmpdbibifmljnfjhpififfog"; //ссылка для установки браузера
    public String installPluginButton = "//*[text()='Установить']"; //кнопка Установить плагин
    public String prefix = UUID.randomUUID().toString();
    public String randomNumber = numberRandom();

    public String filePath = "./file/sign.docx";
    public String signPath = "./file/sign.docx.sig";


    String messageButton = "//div[contains(@class, 'CheckNotificationModal')]//button"; //кнопка на временной форме с информацией TODO должен быть идентификатор
    public String exitButton = "//*[@id='logoutButton']";

    public String confirmButton = "//*[@id='confirmButton']"; // Кнопка Применить
    public String backButton = "//button[text()='Назад']"; // TODO должен быть идентификатор

    //режимы ЕРКНМ и ЕРП
    public String modeERKNM = "//*[text()='ЕРКНМ']"; // TODO должен быть идентификатор
    public String modeERP = "//*[text()='ЕРП']"; // TODO должен быть идентификатор

    // типы проверяемого лица
    public String viewIndividual = "Физические лица";
    public String viewEntity = "Юридические лица";
    public String viewMerchant = "Индивидуальные предприниматели";
    public String viewForeignLegalEntity = "Иностранные юридические лица";
    public String viewForeignLegalEntityNotRegistered = "Иностранные";  // иностранные юридические лица с чекбоксом не зарегистрированные на территории РФ

    // Органы контроля
    public String nameKNO = "Федеральная служба по надзору в сфере здравоохранения";
    public String knoName = "ФЕДЕРАЛЬНАЯ СЛУЖБА ПО НАДЗОРУ В СФЕРЕ ЗДРАВООХРАНЕНИЯ";
    public String nameKNOFNS = "Федеральная налоговая служба";
    public String knoNameTransport = "Федеральная служба по надзору в сфере транспорта";
    public String knoNameGO = "ГЛАВНОЕ УПРАВЛЕНИЕ МИНИСТЕРСТВА РОССИЙСКОЙ ФЕДЕРАЦИИ ПО ДЕЛАМ ГРАЖДАНСКОЙ ОБОРОНЫ";

    // виды контроля
    public String viewKNOFNSForPlan = "017 - Федеральный государственный лицензионный контроль (надзор) за производством и " +
            "реализацией защищенной от подделок полиграфической продукции";
    public String viewKNOFNS = "051 - Федеральный государственный контроль (надзор) за организацией и проведением " +
            "азартных игр";
    public String viewKNO_037 = "037 - Федеральный государственный контроль (надзор) качества и безопасности медицинской деятельности";
    public String viewKNO_066 = "066 - Федеральный государственный контроль (надзор) в сфере обращения лекарственных средств";
    public String viewKNO_069 = "069 - Федеральный государственный контроль (надзор) в области транспортной безопасности";
    public String viewKNOERP = "1.111 294 ФЗ  - Федеральный государственный контроль (надзор) в сферах естественных монополий.";


    // виды объекта
    public String kingObjectForFNSInPlaned = "Деятельность по производству и реализации защищенной от подделок полиграфической продукции";
    public String kingObjectForFNS = "Деятельность юридических лиц, имеющих разрешение на осуществление деятельности по " +
            "организации и проведению азартных игр в игорной зоне";
    public String kingObjectFor_037 = "деятельность медицинских организаций (в том числе медицинских работников)";
    public String kingObjectFor_066 = "деятельность контролируемых лиц в сфере обращения лекарственных средств для ветеринарного применения";
    public String kingObjectFor_069 = "строящиеся объекты транспортной инфраструктуры";


    // основания
    public String grounds = "5.0.3 (ФЗ 248) В связи с отношением объектов контроля к категориям чрезвычайно высокого, высокого и значительного риска";

    //Основное меню (на всех страницах)
    public String listEvents = "//div[@id='/private/knms']/a"; // Список КНМ
    public String listEventsERP = "//*[@id='/private/knms']/a"; // Список проверок
    public String listPreventionEvents = "//*[@id='/private/preventions']/a"; // "Список ПМ";
    public String listPlans = "//*[@id='/private/templates']/a"; // Список планов
    public String analytics = "//div[@id=\"/private/analytics\"]"; // Вкладка Аналитика
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
    public String plannedCheckFZ = "Плановая проверка по 248-ФЗ (утвержденная по плану 294-ФЗ)";
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
    public String promptCheck = "Незамедлительная проверка, ст. 66";

    //Типы документов для основания проведения КНМ
    public String motivatedPerformance = "Мотивированное представление о проведении контрольного (надзорного)";

    // результат ознакомления
    public String familiarWith = "Ознакомлен";
    public String refusalToFamiliarize = "Отказ в ознакомлении";
    public String absenceAtLocation = "В связи с отсутствием контролируемого лица по месту нахождения  (осуществления деятельности)";

    // Тип места блока Объекты проведения КНМ
    public String locationLE = "Место нахождения юридического лица";

    // тип объекта проведения блока Объекты проведения КНМ
    public String branch = "Филиал";

    // Категория риска
    public String righRisk = "Высокий риск (2 класс)";

    // Статусы публикации
    public String statusPublished = "Опубликовано";
    public String statusNotPublished = "Не опубликовано";

    // Статусы проверки
    public String statusProcessConducting = "В процессе проведения";
    public String statusProcessFormation = "В процессе формирования";
    public String statusProcessCompletion = "Ожидает завершения";//
    public String statusProcessAwaiting = "Ожидает проведения";//
    public String statusReadyApproval = "Готово к согласованию";//
    public String statusCompleted = "Завершено";//
    public String statusProcessFilling = "В процессе заполнения";//
    public String statusOnApproval = "На согласовании";//
    public String statusDeleted = "Удалено";//
    public String statusExcluded = "Исключена"; //

    public String statusNotAgreed = "Не согласована";

    public String approved = "Согласовано";
    public String rejected = "Отклонено";

    public String statusPlanUnderConsideration = "На рассмотрении";
    public String statusPlanReviewed = "Рассмотрен";
    public String approvedPlan = "Утверждён";
    //есть замечания
    //исключение обжаловано
    public String statusCannotBeHeld = "Не может быть проведено";
    //решение обжаловано

    // Переменные для поиска созданной информации во время bvt теста
    public static String templateSheets; // Проверочный лист, созданный при помощи bvt
    public static String templateMandatoryRequirements; // Обязательное требование, созданное при помощи bvt
    public static String representative; // Уполномоченный на проведение проверки, созданный при помощи bvt

    public static String numberPublishedKNMBVT;//номер опубликованной внеплановой КНМ, созданной при bvt
    public static String numberUnpublishedKNMBVT; //номер неопубликованной КНМ, созданной при bvt
    public static String numberPMEventWarningPublished; // Номер ПМ
    public static String numberPMPreventiveVisitPublished; // Номер ПМ

    public String numberKNM = "//div[contains(@class, 'TitleBlock')]/h3"; // Объект для получения номера КНМ
    String selectValueByText = "//div[contains(text(),'%s')]"; // Локатор для выбора значения в выпадающем списке по тексту

    String valueOfPlaceholder = "//*[@placeholder='%s']"; // локатор плэйсхолдера
    String electronicSignature = "//*[@id='certs']/div/div[1]/div[1]";  // ключ электронной подписи из списка
    public String successfullySignNotification = "//div[contains(@class, 'ClosingNotificationText') and text() ='Паспорт КНМ успешно подписан']";

    //информация для заполнения КНМ
    public String number = "1";
    public String place = "место";

    // типы акта
    public String supervisoryAct = "Акт контрольного (надзорного) мероприятия";
    public String actOfImpossibility = "Акт о невозможности проведения контрольного (надзорного) мероприятия";

    //страница авторизации
    String loginField = "//*[@name='username']"; //поле Логин
    String passwordField = "//*[@name='password']"; //поле Пароль
    String enterButton = "//*[@type='submit']"; //кнопка Войти

    // основная навигация
    String searchField = "//*[@name='searchString']"; //поле Поиска
    String searchButton = "//*[@id='searchButton']"; //кнопка Искать
    String upButton = "//*[@id=\"root\"]/div[1]/button"; // кнопка вверх
    String addButton = "//*[@id='addButton']"; //кнопка Добавить
    String modalSaveButton = "//div[contains(@class, '_Container_1yq2a_1')]//button[contains(text(), 'Сохранить')]"; // Кнопка Сохранить в модальном окне TODO должен быть идентификатор
    String modalAddButton = "//div[contains(@class, '_ModalBody_9nshc_41')]//button[1]"; // Кнопка Добавить в модальном окне TODO должен быть идентификатор
    String saveButton = "//*[contains(@class,'_Container_')]//*[@id='saveButton']"; //кнопка Сохранить
    String createButton = "//*[@id='createButton']"; //кнопка Создать
    String uploadButton = "//button[text()='Загрузить']"; //кнопка Загрузить
    String actionsButton = "//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия в таблице
    String actionsOnCardButton = "(//*[@id='visibleChangeActionsButton'])[2]"; //кнопка для открытия выпадающего списка Действия на карточке TODO должен быть идентификатор
    String actionsHeaderButton = "//*[contains(@class,'HeaderContent')]//*[@id='visibleChangeActionsButton']"; //кнопка для открытия выпадающего списка Действия, в header TODO должен быть идентификатор
    public String deleteButton = "//*[@id='deleteButton']";
    public String deleteOnCardButton = "//button[text()='Удалить']"; // TODO должен быть идентификатор
    public String signatureButton = "//*[@id='signButton']";
    String openRequest = "//*[contains(@class,'TBodyRow')]/td[2]//a"; // открытие найденной записи
    String openRequestForPlan   = "//*[contains(@class,'TBodyRow')]/td[3]//a"; // открытие найденной карточки в плане
    public String closeMessageButton = "//button[contains(@class,'_CloseButton')]"; //крестик у сообщения в правом верхнем углу TODO должен быть идентификатор
    public String textMessage = "//div[contains(@class,'ClosingNotificationText')]"; // текст сообщения
    public String iconError = "//div[contains(@class,'TitleBlock')]//div[contains(@class,'Errors')]/span";  // [!] иконка сообщающая об ошибке при заполнении
    public String emptyFields = "//div[contains(@class,'ErrorsTooltip')]//a"; // незаполненные поля под [!]
    public String textErrorNotNullInput = "Поле не может быть пустым"; // Текст сообщения об ошибке при незаполненном поле
    public String textErrorIncorrectlyInput = "Номер поручения указан неверно"; // Текст сообщения об ошибке при некорректно заполненном поле

    //общее для новостей
    public String visibleNewsItemProsecutor = "//*[text()='Работник прокуратуры']";
    public String visibleNewsItemOpenPart = "//*[text()='Открытая часть']";
    public String typeItemNews = "//*[text()='Новость']";

    public String menuButton = "//*[@id='userMenuButton']";
    public static String currentDate = ""; // Формирует сегодняшнюю дату
    public static String currentDateTime = "";
    public static String futureDate = ""; // Формирует дату на год позже
    public String weekendDate = "21.01.2023"; // Дата выходного дня
    public String dateOfOneStage = "01.08.2022"; // Дата доработок для первого этапа
    public static String interactionDays = "1"; // Дней непосредственного взаимодействия
    public static String interactionHours = "1"; // Часов непосредственного взаимодействия
    public String choiceSignature = "//*[@id='certs']/div/div[1]";

    public String exclusionGround = "В связи с ликвидацией организации, прекращением гражданином деятельности в качестве индивидуального предпринимателя, влекущими невозможность проведения контрольного (надзорного) мероприятия";

    String knmListCell = "//td[contains(@class, 'KnmListTable_CellErpId')]"; // ячейка с номером КНМ или ПМ в таблицах на страницах Список проверок (ЕРП), Список КНМ (ЕРКНМ) и Список ПМ (ЕРКНМ)

    public String numberPlanNotificationText = "//div[contains(@class, 'ClosingNotificationText')]//a"; // Номер созданного плана из уведомления после создания TODO Должен быть идентификатор
    public String planCheckBox = "//*[@id='%s']"; // Чекбокс у номера плана в списке планов
    public String fillingTextInputs = "Автотест"; // Для заполнения свободных текстовых инпутов
    public String phoneNumber = "77777777777"; // Для заполнения номера телефона
    public String email = "autotest@autotest.ru"; // Для заполнения адреса электронной почты


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
    public void installPlugin() throws InterruptedException {
        open(urlPlugin);
        try {
            $(By.xpath(installPluginButton)).click();
            sleep(2000);
            try {
                Robot r = new Robot();
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000));
                r.keyPress(KeyEvent.VK_TAB);
                r.keyRelease(KeyEvent.VK_TAB);
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1000));
                r.keyPress(KeyEvent.VK_ENTER);
                r.keyRelease(KeyEvent.VK_ENTER);
                sleep(10000);
                refresh();
            } catch (AWTException e) {
                e.printStackTrace();
            }
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
            $(By.xpath(modeERKNM)).should(visible, Duration.ofSeconds(10)).click();
        else
            $(By.xpath(modeERP)).should(visible, Duration.ofSeconds(10)).click();
    }

    /**
     * Нажать на пункт в боковом меню навигации
     *
     * @param locator Локатор пункта меню
     */
    @Step("Нажать на пункт в боковом меню навигации")
    public void clickedOnNavigationMenuItem(String locator) {
        $(By.xpath(locator)).click();
    }


    /**
     * Выбор режима ЕРП
     *
     */
    @Step("Переключение в режим ЕРП")
    public void selectionERP() {
        choiceMode(false);
    }

    /**
     * Выбор режима ЕРКНМ
     *
     */
    @Step("Переключение в режим ЕРКНМ")
    public void selectionERKNM() {
        choiceMode(true);
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
    public void choiceSignature() throws InterruptedException {
        sleep(5000);
        $(By.xpath(choiceSignature)).click();
        setValueDropDownToNumber(1);
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
    public void openCard(String value) throws InterruptedException {
        setSearchField(value);
        clickSearchButton();
        sleep(4000);
        $(By.xpath(openRequest)).click();
        switchTo().window(getWebDriver().getWindowHandle()).close();
        switchTo().window(0);

    }

    /**
     * Открытие найденной карточки проверки в плане
     *
     * @param value Номер карточки
     */
    @Step("Открытие найденной карточки - {value} в плане")
    public void openCardForPlan(String value) {
        setSearchField(value);
        clickSearchButton();
        $(By.xpath(openRequestForPlan)).click();
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
        reloadPage();
        //switchTo().window(0);

    }

    /**
     * Нажатие на кнопку [^] вверх
     */
    @Step("Нажатие на кнопку [^] вверх")
    public void clickUpButton() {
        try {
            $(By.xpath(upButton)).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {}
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
        $(By.xpath(saveButton)).scrollIntoView(false).click();
    }

    /**
     * Переход в список КНМ
     */
    @Step("Переход в список КНМ")
    public void gotoListKNMPage() {
        clickUpButton();
        $(By.xpath(listEvents)).scrollTo().click();
    }

    /**
     * Переход в список КНМ в режиме ЕРП
     */
    @Step("Переход в список КНМ в режиме ЕРП")
    public void gotoERPListKNMPage() {
        clickUpButton();
        $(By.xpath(listEventsERP)).click();
    }

    /**
     * Переход в список ПМ
     */
    @Step("Переход в список ПМ")
    public void gotoListPreventionEventsPage() {
        clickUpButton();
        $(By.xpath(listPreventionEvents)).click();
    }

    /**
     * Переход в список планов
     */
    @Step("Переход в список планов")
    public void gotoListPlansPage() {
        clickUpButton();
        $(By.xpath(listPlans)).scrollIntoView(false).click();
    }

    /**
     * Переход во вкладку Аналитика для ЕРКНМ
     */
    @Step("Переход во вкладку Аналитика для ЕРКНМ")
    public void gotoAnalyticsPage() {
        $(By.xpath(analytics)).click();
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
        sleep(4000);
        if (person.equals("voskhod_qa")) {
            try {
                $(By.xpath("//*[@id='modal']//button")).click(); // закрыть модалку
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {}
        }
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
        $(By.xpath(actionsOnCardButton)).shouldBe(visible).click();
    }

    /**
     * Нажатие на кнопку Действия, когда она в header
     */
    @Step("Нажатие на кнопку Действия, когда она в header")
    public void clickActionsHeaderButton() {
        $(By.xpath("//div[@id='root']")).scrollIntoView(false);
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
        $(By.xpath(closeMessageButton)).should(visible, Duration.ofSeconds(15)).scrollIntoView(false).click();
    }

    /**
     * Проверка текста сообщения на соответствие
     *
     * @param text Ожидаемый текст сообщения
     */
    @Step("Проверка текста из сообщения")
    public void checkTextNotification(String text) {
        $(By.xpath(textMessage)).should(visible, Duration.ofSeconds(15)).should(Text.text(text));
    }

    /**
     * Проверка названий не заполненных полей в блоке [!]
     *
     * @param namesInput Строковый массив названий полей
     */
    @Step("Проверка названий не заполненных полей в блоке [!] - {namesInput}")
    public void checkNamesEmptyFields(String[] namesInput) {
        $(By.xpath(iconError)).scrollIntoView(false).click();
        for(int i = 0; i < namesInput.length; i++) {
            $$ (By.xpath(emptyFields)).findBy(text(namesInput[i])).shouldBe(visible);
        }
    }

    /**
     * Проверка текста под полем на соответствие
     *
     * @param nameInput Наименование поля
     * @param locator Локатор проверяемого поля
     * @param text Ожидаемый текст ошибки
     */
    @Step("Проверка текста под полем - {nameInput}, {text}")
    public void checkTextErrorField(String nameInput, String locator, String text) {
        $(By.xpath(locator)).should(visible, Duration.ofSeconds(15)).scrollIntoView(false).should(Text.text(text));
    }

    /**
     * Проверка названия поля на соответствие
     *
     * @param nameInput Ожидаемое наименование поля
     * @param locator   Локатор наименования поля
     */
    @Step("Проверка названия поля - {nameInput}")
    public void checkNameField(String nameInput, String locator) {
        $(By.xpath(locator)).should(visible, Duration.ofSeconds(15)).scrollIntoView(false).should(Text.text(nameInput));
    }

    /**
     * Получение значения поля
     *
     * @param nameInput Наименование поля
     * @param locator   Локатор поля
     */
    @Step("Получение значения поля - {nameInput}")
    public String getValueOfField(String nameInput, String locator) {
        return $(By.xpath(locator)).getText();
    }

    /**
     * Проверка содержания текста
     *
     * @param locator Локатор проверяемого поля
     * @param text Ожидаемый текст ошибки
     */
    @Step("Проверка содержания текста - {text}")
    public void checkTextContent(String locator, String text) {
        //$(By.xpath(locator)).should(visible, Duration.ofSeconds(15)).scrollIntoView(false).should(Text.text(text));
        ElementsCollection elements = $$ (By.xpath(locator));
        String[] messageText = new String[elements.size()];
        for(int i = 0; i < elements.size(); i++) {
            SelenideElement element = elements.get(i);
            messageText[i] = element.text();
        }
        String resultAllText = Arrays.toString(messageText);
        Assert.assertEquals(text, resultAllText, "Текст не совпадает");
    }

    /**
     * Проверка на отсутствие(невидимость) элемента на странице
     *
     * @param nameElement Название проверяемого элемента
     * @param locator Локатор проверяемого элемента
     */
    @Step("Проверка на отсутствие элемента на странице - {nameElement}")
    public void checkElementInvisible(String nameElement, String locator) {
        $(By.xpath(locator)).shouldNotBe(visible);
    }

    /**
     * Проверка на присутствие(видимость) элемента на странице
     *
     * @param nameElement Название проверяемого элемента
     * @param locator Локатор проверяемого элемента
     */
    @Step("Проверка на присутствие(видимость) на странице - {nameElement}")
    public void checkElementVisible(String nameElement,  String locator) {
        $(By.xpath(locator)).shouldBe(visible);
    }

    /**
     * Проверка на то что элемент не доступен для нажатия, редактирования
     *
     * @param nameElement Название проверяемого элемента
     * @param locator Локатор проверяемого элемента
     */
    @Step("Проверка на недоступность элемента - {nameElement}")
    public void checkElementNotAvailable(String nameElement, String locator) {
       $(By.xpath(locator)).scrollIntoView(false).shouldBe(disabled);
    }

    /**
     * Проверка на то что элемент доступен для нажатия, редактирования
     *
     * @param nameElement Название проверяемого элемента
     * @param locator Локатор проверяемого элемента
     */
    @Step("Проверка на доступность элемента - {nameElement}")
    public void checkElementAvailable(String nameElement, String locator) {
        $(By.xpath(locator)).scrollIntoView(false).shouldNotBe(disabled);
    }

    /**
     * Получение значения из поля и сравнение с ожидаемым значением
     *
     * @param nameField Название поля
     * @param locator Локатор проверяемого поля
     * @param value Ожидаемое значение
     */
    @Step("Проверка: значения в поле - {nameField} соответствует ожидаемому значению: {value}")
    public void checkValueOfField(String nameField, String locator, String value) throws InterruptedException {
        sleep(4000);
        $(By.xpath(locator)).scrollIntoView(false).shouldHave(value(value));
    }

    /**
     * Получение выбранного значения из выпадающего списка и сравнение с ожидаемым значением
     *
     * @param nameField Название поля
     * @param locator Локатор проверяемого поля
     * @param value Ожидаемое значение
     */
    @Step("Проверка: выбранного из списка значения в поле - {nameField} соответствует ожидаемому значению: {value}")
    public void checkValueForDropDownOfField(String nameField, String locator, String value) throws InterruptedException {
        sleep(4000);
        $(By.xpath(locator)).scrollIntoView(false).shouldHave(text(value));
    }

    /**
     * Проверка на отсутствие значений в выпадающем списке
     *
     * @param nameField Наименование поля
     * @param locator Локатор
     */
    @Step("Проверка на отсутствие значений в выпадающем - {nameField}")
    public void checkInVisibleValueOfDropDown(String nameField, String locator) {
        $(By.xpath(locator)).scrollIntoView(false).click();
        $(By.xpath(String.format(selectValueByText, "Значение отсутствует"))).shouldBe(visible);
    }

    /**
     * Проверка на логирование записи в истории
     *
     * @param text    Текст записи
     */
    @Step("Проверка на логирование записи - {text} в истории")
    public void checkLogInHistory(String text) {
        $(By.xpath(String.format(selectValueByText, text))).shouldBe(visible);
    }

    /**
     * Отчистка поля нажатием на [X]
     *
     * @param nameField Название поля
     * @param locator Локатор элемента [X]
     */
    @Step("Отчистка поля - {nameField}")
    public void clickButtonClearField(String nameField, String locator) {
        $(By.xpath(locator)).click();
    }

    /**
     * Стереть данные из поля ввода
     *
     * @param nameInput Название поля
     * @param locator Локатор поля
     */
    @Step("Стереть данные из - {nameInput}")
    public void clearInput(String nameInput, String locator) {
        $(By.xpath(locator)).sendKeys(Keys.CONTROL + "a");
        $(By.xpath(locator)).sendKeys(Keys.BACK_SPACE);
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
        //$(By.xpath(String.format(selectValueByNumber, number))).click();
        $(By.xpath(electronicSignature)).click();
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
        try {
            $(By.xpath(confirmButton)).should(visible, Duration.ofSeconds(10)).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {}
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

    /**
     * Перезагрузка страницы для включения плагина подписания
     */
    @Step("Перезагрузка страницы для включения плагина подписания")
    public void reloadPage() {
        refresh();
    }

    /**
     * Проверка существования КНМ или ПМ на страницах Список проверок, Список КНМ и Список ПМ
     *
     * @param knm    Номер КНМ
     * @param exist  Должна ли найтись проверка с указанным статусом
     * @param status Наименование статуса, на который нужно провести проверку
     */
    @Step("Проверка существования КНМ или ПМ на страницах Список проверок, Список КНМ и Список ПМ - {knm}, {status}, {exist}")
    public void checkKNMOrPM(String knm, String status, boolean exist) {
        if (exist) $(By.xpath(knmListCell)).should(Text.text(knm)).parent().should(Text.text(status));
        else $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Проверка существования КНМ или ПМ на страницах Список проверок, Список КНМ и Список ПМ
     *
     * @param knm   Номер КНМ
     * @param exist Должна ли найтись проверка с указанным статусом
     */
    @Step("Проверка существования КНМ или ПМ на страницах Список проверок, Список КНМ и Список ПМ - {knm}, {exist}")
    public void checkKNMOrPM(String knm, boolean exist) {
        if (exist) $(By.xpath(knmListCell)).should(Text.text(knm));
        else $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Получение номера плана
     */
    @Step("Получение номера плана - {number}")
    public String getNumberPlan() {
        String number = $(By.xpath(numberPlanNotificationText)).getText();
        System.out.println("НОМЕР ПЛАНА - " + number);
        return number;
    }

    /**
     * Выбор чек-бокса по номеру плана
     *
     * @param number Номер плана
     */
    @Step("Выбор чек-бокса по номеру плана {number}")
    public void clickPlanCheckBox(String number) {
        $(By.xpath(String.format(planCheckBox, number))).scrollIntoView(false).click();
    }

    /**
     * Поиск плана по номеру
     *
     * @param number  Номер плана
     * @param isExist true - план должен быть в списке, false - план должен отсутствовать в списке
     */
    @Step("Поиск плана по номеру {number} {isExist}")
    public void searchPlan(String number, boolean isExist) {
        setSearchField(number);
        clickSearchButton();
        if (isExist) $(By.xpath(String.format(planCheckBox, number))).should(Condition.exist);
        else $(By.xpath(String.format(planCheckBox, number))).shouldNot(Condition.exist);
    }

    /**
     * Проверка существования КНМ на странице Поиск проверок или поиск Мероприятий
     *
     * @param exist true - проверка на существование КНМ в списке, false - проверка на отсутствие КНМ
     * @param knm   Номер КНМ
     */
    @Step("Проверка существования КНМ на странице Поиск проверок или поиск Мероприятий - {knm} - {exist}")
    public void checkKNMOrPMSearch(String knm, boolean exist) {
        setSearchField(knm);
        clickSearchButton();
        String knmListCell = "//tbody//td";
        if (exist)
            $(By.xpath(knmListCell)).should(Text.text(knm));
        else
            $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Получение случайной карточки проверки из таблицы
     */
    @Step("Получение случайной карточки проверки из таблицы")
    public String getNumberRandomEvent() throws InterruptedException {
        sleep(4000);
        ElementsCollection numbersEvents = $$ (By.xpath(openRequest));
        int a = (int) ( Math.random() * numbersEvents.size() );
        String number = numbersEvents.get(a).getText();
        System.out.println("НОМЕР - " + number);
        return number;
    }

    /**
     * Случайный номер
     */
    public String numberRandom() {
        int a = (int) ( Math.random() * 1000 ) + 100;
        String randNumber = Integer.toString(a);
        return randNumber;
    }

    /**
     * Проверка текста плэйсхолдера
     *
     * @param text Текст
     */
    @Step("Проверка текста плэйсхолдера - {text}")
    public void checkTextInPlaceholder(String text) {
        $(By.xpath(String.format(valueOfPlaceholder, text))).shouldBe(visible);
    }

}


