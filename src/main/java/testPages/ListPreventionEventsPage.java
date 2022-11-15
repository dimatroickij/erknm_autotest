package testPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ListPreventionEventsPage extends Common {
    //список ПМ

    public String prefix = UUID.randomUUID().toString();
    String sortingByPeriod = "//div[@data-id=\"startDateEn\"]"; // сортировка по периоду проведения
    String statusPM = "//div[contains(@class,'TitleBlock')]/span[contains(@class, 'Status')]"; // Статус ПМ
    String statusPublication = "//div[contains(@class,\"PublishedStatus\")]/span[contains(@class, 'Status')]"; // Статус публикации
    public String officialPost = "Руководитель";
    String nameKNOPMDropDown = "//*[@id='knoOrganizationPm']"; // выпадающий список Контрольный надзорный орган
    String kindControlAndNumberPMDropDown = "//*[@id='supervisionTypePm']"; // выпадающий список Вид контроля (надзора) и его номер
    String kindPMDropDown = "//*[@id='pmType']"; // выпадающий список Вид ПМ
    public String valueOfFieldKindPM = "//*[@id='pmType']//div[contains(@class,'_SingleValue')]"; // значение в поле Вид ПМ
    public String typeAnnouncementWarningsPM = "Объявление предостережения";
    public String typePreventiveVisitPM = "Профилактический визит";
    public String typeObject = "Деятельность и действия";
    public String viewObject = "используемые контролируемыми лицами при осуществлении деятельности в сфере обращения " +
            "лекарственных средств для медицинского применения помещения, к которым предъявляются обязательные требования";
    public String classDanger = "Первый";
    public String classDanger2 = "Второй";

    String startDateField = "//*[@id='startDateBlock']//input"; // поле Дата начала
    public String nameFieldForStartDate = "//div[@id=\"startDateBlock\"]//label"; // наименование поля даты начала при Объявление предостережения
    public String stopDateField = "//*[@id='stopDateBlock']//input"; // поле Дата окончания
    String placeOfEventField = "//*[@name=\"location\"]"; // поле Место проведения профилактического мероприятия
    String innField = "//*[@name='inn']"; // Поле ИНН
    String innListField = "//*[@id='autoCompleteList']/li"; // выбор из выпадающего списка ИНН

    String addObjectControlPMButton = "//*[@id='pmObjectsAddButton']";//кнопка Добавить в разделе Сведения об объектах контроля в карточке ПМ
    String typeObjectDropDown = "//*[@id='objectsPm[0].objectType']"; // выбор типа объекта
    String viewObjectDropDown = "//*[@id='objectsPm[0].objectKind']"; // выбор вида объекта
    String classDangerDropDown = "//*[@id='objectsPm[0].dangerClass']"; // выбор класса опасности
    String noteWarningField = "//*[@id='noteWarning']"; // поле Описание предостережения
    String addNoteWarningButton = "//*[@id='pmContentWarningAddButton']"; // кнопка Добавить у блока Содержание предостережения
    String addDocumentButton = "//*[@for='contentWarningAttachmentsUploadDocument']"; // кнопка Добавить документ
    String addSignatureButton = "//*[@for='contentWarningAttachmentsUploadSign']"; // кнопка Добавить подпись

    String addGroundsPMButton = "//*[@id='pmReasonsAddButton']"; // кнопка Добавить в блоке основания проведения профилактических мероприятий

    String choiceGroundDropDown = "//*[contains(@class,'select-field__placeholder ')]"; // выпадающий список Выберите основание проведения ПМ
    String addOfficialPMButton = "//*[@id='erknmInspectorsAddButton']"; // кнопка Добавить должностное лицо
    String officialField = "//*[@name='inspectorsErknm[0].fullName']"; // поле Введите ФИО должностного лица
    String officialPostPMDropDown = "//*[@id='inspectorsErknm[0].position']"; // выпадающий список Выберите должность в ПМ
    String deleteOfficialPost = "//div[@id=\"inspectors\"]//span[contains(@class,'Icon')]"; // иконка [X] удаления должностного лица

    String numberPM = "//div[contains(@class, 'TitleBloc')]/h3"; // номер ПМ

    String documentNoteWarningInput = "//input[@id='contentWarningAttachmentsUploadDocument']"; // input для добавления документа в содержание предостережения
    String signatureNoteWarningInput = "//input[@id='contentWarningAttachmentsUploadSign']"; // input для добавления подписи в содержание предостережения


    String addInformationDirectionObjectionButton = "//*[@id='pmObjectionWarningAddButton']"; // кнопка Добавить в разделе Сведения о направлении возражения на предостережение
    String resultPMField = "//*[@id='resultOfInspection']"; // поле результат ПМ

    String documentInformationDirectionObjectionInput = "//input[@id='objectionWarningAttachmentsUploadDocument']"; // input для добавления документа в сведения о направлении возражения на предостережение
    String signatureInformationDirectionObjectionInput = "//input[@id='objectionWarningAttachmentsUploadSign']"; // input для добавления подписи в сведения о направлении возражения на предостережение

    String presenceOfDisagreementDropDown = "//*[@id='isRejectSubject']/div/div[2]"; // Выпадающий список Наличие несогласия в блоке Информация о несогласии контролируемого лица на проведение мероприятия TODO Должен быть идентификатор
    String datePresenceOfDisagreementField = "//*[@id='isRejectSubjectBlock']//input[contains(@class, '_Input')]"; // Поле Дата информации о несогласии контролируемого лица на проведение мероприятия TODO Должен быть идентификатор
    public String statusWarningAnnounced = "Предостережение объявлено";
    public String statusAnObjection = "Есть возражение";

    public String statusRefusalToConduct = "Отказ в проведении";


    // Блок обязательные требования, подлежащие проверке
    public String buttonAddForRequirements = "//button[@id=\"pmRequirementsAddButton\"]"; // кнопка Добавить в разделе Обязательные требования подлежащие проверке
    public String requirementsNPA = "//div[@id=\"requirementsNpa\"]//span[contains(@class, \"OpenButtonBody\")]"; // НПА в обязательных требованиях подлежащих проверке
    public String contentOfRequirements = "//div[contains(@class, 'BodyIsActive')]//div[contains(@class, 'MandatoryBlockBody')]"; // Текст содержания требования
    String inputNameNPA = "//input[@id=\"npaSearchString\"]"; // поле наименование НПА в форме добавления обязательного требования
    String buttonSearchNPA = "//div[contains(@class,'_Row_')]/button"; // кнопка Искать в форме добавления обязательного требования
    String npaInTable = "//div[contains(@class,'NpaNameBlock')]"; // найденный НПА в таблице
    public String buttonAddInFormRequirement = "//form/div[contains(@class,'Container')]//button[1]"; // Кнопка Далее в форме добавления обязательного требования
    String listOfStructuralUnits = "//input[@name=\"structuralUnits\"]"; // список СЕ в форме добавления обязательного требования
    String checkboxContentOfRequirement = "//div[@id=\"mandatoryBlock\"]//input"; // чекбокс содержания требования в форме добавления обязательного требования
    public String buttonSaveInFormRequirement = "//div[contains(@class,'ModalActionsWithBack')]/div/button[1]"; //  кнопка Сохранить в форме добавления обязательного требования
    String buttonAddContentOfRequirement = "//div[@id='modal']//div[contains(@class, 'Row')]/button[contains(@class, 'ButtonDefault')]"; // кнопка Добавить формулировку в форме добавления обязательного требования
    String textInputContentOfRequirement = "//textarea[contains(@class, 'NewMandatoryInputField')]"; // текстовое поле ввода Содержание формулировки в форме добавления обязательного требования
    String buttonAddNewNPA = "//div[contains(@class,'_CountResultsRow')]/button"; // кнопка Создать новый НПА
    String inputNumberNPA = "//input[@name='number']"; // поле номер НПА
    String inputDateNPA = "//div[@id='modal']//div[@class=\"react-datepicker-wrapper\"]//input"; // поле Дата утверждения НПА
    public String textErrorUnderInputDateNPA = "//div[@id='modal']//div[contains(@class,\"DatePickerError\")]"; // текст ошибки под полем Дата утверждения НПА
    String inputTitleNPA = "//div[@id='modal']//textarea[@name='title']"; // поле Наименование НПА
    public String textErrorUnderInputTitleNPA = "//div[@id='modal']//div[contains(@class, '_TextareaError')]"; // текст ошибки под полем Наименование НПА
    String buttonAddSE = "//div[contains(@class,'Row')][3]//button"; // кнопка Добавить в блоке Структурные единицы
    String selectInitField = "//div[contains(@class,'_SelectInputSizeLarge')]"; // поле выбора типа Структурной единицы
    String inputValueSE = "//*[contains(@name,'newStructuralUnits[0].components[0].v')]"; // поле Значение СЕ
    String buttonSaveNewNPA = "//div[contains(@class,'_ModalActionsWithBack')]/div/button[1]"; // кнопка Сохранить при создании НПА
    String buttonCancelNewNPA = "//div[contains(@class,'_ModalActionsWithBack')]/div/button[2]"; // кнопка Отмена при создании НПА
    String messageErrorForValidationCreateNPA = "//div[@id='modal']//div[contains(@class,'ClosingNotificationText')]"; // сообщение об ошибке при попытке создать одинаковый НПА
    String iconEditNPA = "//div[contains(@class,'NpaNameBlock')]/button"; // иконка редактирования НПА
    public String numberNPAInTableSearchResults = "//div[contains(@class,'TableContent')]/div[1]"; // номер НПА в таблице найденных

    // Боковое меню навигации
    public String linkInfoSubjectOfPreventionEvent = "//li[@id=\"#requirementsNpa\"]/a"; // ссылка в боковом меню навигации Сведения о предмете профилактического мероприятия
    public String linkInfoHistoryOfChanges = "//li[@id=\"#knm-history\"]/a"; // ссылка в боковом меню навигации История изменений
    public String linkInfoAboutDissent = "//li[@id=\"#is-reject-subject\"]/a"; // ссылка в боковом меню навигации информация о несогласии


    // История изменений
    public String logTextInHistoryOfChanges = "//*[contains(@class,'WrapperOpened')]//*[contains(@class,'Patch')]"; // запись в логировании Истории изменений
    String buttonOpenHistoryOfChanges = "//*[@id=\"knm-history\"]//button[contains(@class,'OpenButton')]"; // поле/кнопка История изменения профилактических мероприятий



    public ListPreventionEventsPage() throws Exception {
    }

    /**
     * Заполнение выпадающего списка Контрольный (надзорный) орган
     *
     * @param name Контрольный (надзорный) орган
     */
    @Step("Заполнение выпадающего списка Контрольный (надзорный) орган - {name}")
    public void setNameKNOPMDropDown(String name) {
        $(By.xpath(nameKNOPMDropDown)).click(); // клик по списку КНО
        setValueDropDownToText(name); // выбор конкретной КНО
    }

    /**
     * Заполнение выпадающего списка Вид контроля (надзора) и его номер
     *
     * @param kind Вид контроля (надзора)
     */
    @Step("Заполнение выпадающего списка Вид контроля (надзора) и его номер - {kind}")
    public void setKindControlAndNumberPMDropDown(String kind) {
        $(By.xpath(kindControlAndNumberPMDropDown)).click(); // клик по списку Вид контроля (надзора) и его номер
        setValueDropDownToText(kind); // выбор конкретного Вида контроля
    }

    /**
     * Заполнение выпадающего списка Вид профилактического мероприятия
     *
     * @param kindPM Вид профилактического мероприятия
     */
    @Step("Заполнение выпадающего списка Вид профилактического мероприятия - {kindPM}")
    public void setKindPMDropDown(String kindPM) {
        $(By.xpath(kindPMDropDown)).click(); // клик по списку Вид профилактического мероприятия
        setValueDropDownToText(kindPM); // выбор конкретного Вид профилактического мероприятия
    }

    /**
     * Заполнение поля Дата начала
     *
     * @param date Дата начала
     */
    @Step("Заполнение поля Дата начала - {date}")
    public void setStartDate(String date) {
        $(By.xpath(startDateField)).setValue(date);
    }

    /**
     * Заполнение поля Дата окончания
     *
     * @param date Дата окончания
     */
    @Step("Заполнение поля Дата окончания - {date}")
    public void setStopDate(String date) {
        $(By.xpath(stopDateField)).scrollIntoView(false).setValue(date);
    }

    /**
     * Заполнение поля Место профилактического мероприятия
     *
     * @param place Место профилактического мероприятия
     */
    @Step("Заполнение поля Место профилактического мероприятия - {place}")
    public void setPlaceOfPreventionEvent(String place) {
        $(By.xpath(placeOfEventField)).setValue(place);
    }

    /**
     * Заполнить поле ИНН, выбрать из появившегося окна
     *
     * @param INN ИНН
     */
    @Step("Заполнить поле ИНН, выбрать из появившегося окна - {INN}")
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).click();
    }

    /**
     * Выбор Тип объекта
     *
     * @param type Тип объекта
     */
    @Step("Выбор Тип объекта - {type}")
    public void setTypeObjectDropDown(String type) {
        $(By.xpath(typeObjectDropDown)).click();
        setValueDropDownToText(type);
    }

    /**
     * Выбор Вид объекта
     *
     * @param view Вид объекта
     */
    @Step("Выбор Вид объекта - {view}")
    public void setViewObjectDropDown(String view) {
        $(By.xpath(viewObjectDropDown)).click();
        setValueDropDownToText(view);
    }

    /**
     * Выбор класса опасности
     *
     * @param classDanger Класс опасности
     */
    @Step("Выбор класса опасности - {classDanger}")
    public void setClassDangerDropDown(String classDanger) {
        $(By.xpath(classDangerDropDown)).click();
        setValueDropDownToText(classDanger);
    }

    /**
     * Заполнение поля Описание предостережения
     *
     * @param note Описание предостережения
     */
    @Step("Заполнение поля Описание предостережения")
    public void setNoteWarningField(String note) {
        $(By.xpath(noteWarningField)).setValue(note);
    }

    /**
     * Нажатие на кнопку Добавить у блока Содержание предостережение
     */
    @Step("Нажатие на кнопку Добавить у блока Содержание предостережение")
    public void clickAddContentWarningButton() {
        $(By.xpath(addNoteWarningButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить документ
     */
    @Step("Нажатие на кнопку Добавить документ")
    public void clickAddDocumentButton() {
        $(By.xpath(addDocumentButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить подпись
     */
    @Step("Нажатие на кнопку Добавить подпись")
    public void clickAddSignatureButton() {
        $(By.xpath(addSignatureButton)).click();
    }

    /**
     * Получение номера ПМ
     */
    public String getNumberPM() {
        String number = $(By.xpath(numberPM)).getText().split(" ")[1];
        System.out.println("НОМЕР ПМ - " + number);
        return number;
    }

    /**
     * Нажатие на кнопку Добавить в блоке основания проведения ПМ
     */
    @Step("Нажатие на кнопку Добавить в блоке основания проведения ПМ")
    public void clickAddGroundsPMButton() {
        $(By.xpath(addGroundsPMButton)).click();
    }


    /**
     * Заполнение выпадающего списка Выберите основание проведения ПМ
     *
     * @param ground Выберите основание проведения ПМ
     */
    @Step("Заполнение выпадающего списка Выберите основание проведения ПМ - {ground}")
    public void setGroundDropDown(String ground) {
        $(By.xpath(choiceGroundDropDown)).click(); //клик по списку
        setValueDropDownToText(ground);
    }

    /**
     * Нажатие на кнопку Добавить должностное лицо
     */
    @Step("Нажатие на кнопку Добавить должностное лицо")
    public void clickOfficialPMButton() {
        $(By.xpath(addOfficialPMButton)).click();
    }

    /**
     * Заполнить поле ФИО должностного лица
     *
     * @param name ФИО
     */
    @Step("Заполнить поле ФИО должностного лица - {name}")
    public void setOfficialField(String name) {
        $(By.xpath(officialField)).setValue(name);
    }

    /**
     * Заполнение выпадающего списка Выберите должность для объявления предостережения
     *
     * @param post Должность
     */
    @Step("Заполнение выпадающего списка Выберите должность для объявления предостережения - {post}")
    public void setOfficialPostPMDropDown(String post) {
        $(By.xpath(officialPostPMDropDown)).click(); // клик по списку
        setValueDropDownToText(post);
    }


    /**
     * Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение
     */
    @Step("Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение")
    public void clickAddInformationDirectionObjectionButton() {
        $(By.xpath(addInformationDirectionObjectionButton)).scrollIntoView(false).click();
    }

    /**
     * Заполнение поля результат ПМ
     *
     * @param result Результат
     */
    @Step("Заполнение поля результат ПМ - {result}")
    public void setResultPMField(String result) {
        $(By.xpath(resultPMField)).setValue(result);
    }

    /**
     * Заполнение блока Объект
     *
     * @param type        тип объекта
     * @param view        вид объекта
     * @param classDanger класс опасности
     */
    @Step("Заполнение блока Объект")
    public void addObjectData(String type, String view, String classDanger) {
        setTypeObjectDropDown(type);
        setViewObjectDropDown(view);
        setClassDangerDropDown(classDanger);
    }

    /**
     * Добавление основания проведения ПМ
     *
     * @param grounds Основание проведения ПМ
     */
    @Step("Добавление основания проведения ПМ - {grounds}")
    public void addGroundsPM(String grounds) {
        clickAddGroundsPMButton();
        setGroundDropDown(grounds);
    }

    /**
     * Добавление должностного лица для ПМ
     *
     * @param name Название
     * @param post Должность
     */
    @Step("Добавление должностного лица для ПМ - {name}, {post}")
    public void addOfficialPM(String name, String post) {
        try {
            $(By.xpath(deleteOfficialPost)).click(); // клик по [X]
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {}
        finally {
            clickOfficialPMButton();
            setOfficialField(name);
            setOfficialPostPMDropDown(post);
        }
    }

    /**
     * Создание ПМ
     *
     * @param name        Название контрольного (надзорного) органа
     * @param view        Вид контроля (надзора) и его номер
     * @param typePM      Вид ПМ
     * @param date        Дата начала
     * @param inn         ИНН
     * @param viewObject  вид объекта
     */
    @Step("Создание ПМ: Название контрольного (надзорного) органа - {name}, Вид контроля (надзора) и его номер - {view}," +
            " Вид ПМ - {typePM}, Дата начала - {date}, ИНН - {inn}, Вид объекта - {viewObject}")
    public void addPreventionEvent(String name, String view, String typePM, String date, String inn, String viewObject) {
        clickAddButton();
        setFieldsForPreventionEvent(name, view, typePM, date, inn, viewObject);
        clickSaveButton();
        clickConfirmButton();
        closeNotification();
    }

    /**
     * Заполнение необходимых полей для создания ПМ
     *
     * @param name        Название контрольного (надзорного) органа
     * @param view        Вид контроля (надзора) и его номер
     * @param typePM      Вид ПМ
     * @param date        Дата начала
     * @param inn         ИНН
     * @param viewObject  вид объекта
     */
    @Step("Заполнение необходимых полей для создания ПМ: Название контрольного (надзорного) органа - {name}, " +
            "Вид контроля (надзора) и его номер - {view}, Вид ПМ - {typePM}, Дата начала - {date}, ИНН - {inn}, " +
            "Вид объекта - {viewObject}")
    public void setFieldsForPreventionEvent(String name, String view, String typePM, String date, String inn, String viewObject) {
        setNameKNOPMDropDown(name);
        setKindControlAndNumberPMDropDown(view);
        setKindPMDropDown(typePM);
        if(typePM == typePreventiveVisitPM) {
            setPlaceOfPreventionEvent("Автотест");
        }
        setStartDate(date);
        setInnField(inn);
        addObjectData(typeObject, viewObject, classDanger);
    }

    /**
     * Добавление документа и подписи в Содержание предостережения
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление документа и подписи в Содержаение предостережения")
    public void addDocumentAndSignatureNoteWarning(String fPath, String sPath) {
        $(By.xpath(documentNoteWarningInput)).uploadFile(new File(fPath));
        //$(By.xpath(signatureNoteWarningInput)).uploadFile(new File(sPath));
    }

    /**
     * Добавление документа и подписи в Сведения о направлении возражения на предостережение
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление документа и подписи в Сведения о направлении возражения на предостережение")
    public void addDocumentAndSignatureInformationDirectionObjection(String fPath, String sPath) {
        $(By.xpath(documentInformationDirectionObjectionInput)).uploadFile(new File(fPath));
        //$(By.xpath(signatureInformationDirectionObjectionInput)).uploadFile(new File(sPath));
    }

    /**
     * Заполнение выпадающего списка Наличие несогласия в блоке Информация о несогласии контролируемого
     * лица на проведение мероприятия
     *
     * @param approval Да или Нет
     */
    @Step("Заполнение выпадающего списка Наличие несогласия в блоке Информация о несогласии контролируемого " +
            "лица на проведение мероприятия")
    public void setPresenceOfDisagreementDropDown(String approval) {
        $(By.xpath(presenceOfDisagreementDropDown)).scrollIntoView(false).click();
        $(By.xpath(String.format("//div[text()='%s']", approval))).click();
    }

    /**
     * Заполнение даты в блоке Информация о несогласии контролируемого лица на проведение мероприятия
     *
     * @param date Дата
     */
    @Step("Заполнение даты в блоке Информация о несогласии контролируемого лица на проведение мероприятия")
    public void setDatePresenceOfDisagreementField(String date) throws InterruptedException {
        sleep(2000);
        $(By.xpath(datePresenceOfDisagreementField)).setValue(date);
    }

    /**
     * Проверка статуса ПМ
     *
     * @param status Статус, который должен быть у ПМ
     */
    @Step("Проверка статуса ПМ - {status}")
    public void checkStatusPM(String status) throws InterruptedException {
        $(By.xpath(statusPM)).should(Text.text(status));
    }

    /**
     * Получение статуса ПМ
     */
    @Step("Получение статуса ПМ")
    public String getStatusPM() {
        return $(By.xpath(statusPM)).getText();
    }

    /**
     * Проверка статуса Публикации ПМ
     *
     * @param status Статус, который должен быть у проверки
     */
    @Step("Проверка статуса Публикации - {status}")
    public void checkStatusPublicationPM(String status) {
        $(By.xpath(statusPublication)).should(Text.text(status));
    }

    /**
     * Перевод Объявление предостережения в статус Предостережение объявлено
     *
     */
    @Step("Перевод Объявление предостережения в статус Предостережение объявлено")
    public String transferPMEventWarningAnnouncementStatusWarningAnnounced() throws InterruptedException {
        setFieldsForSavePMStatusWarningDeclared(currentDate);
        String numberNPA = setBlockOfRequirements("правительство");
        clickSaveButton();
        closeNotification();
        electronicSignatureInBrowser();
        sleep(5000);
        clickConfirmButton();
        //closeNotification();
        return numberNPA;
    }


    /**
     * Подписание ПМ электронной подписью в браузере
     */
    @Step("Подписание ПМ электронной подписью в браузере")
    public void electronicSignatureInBrowser() throws InterruptedException {
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        //closeNotification();
    }

    /**
     * Заполнение полей необходимых для перевода ПМ Объявление предостережения в статус Предостережение объявлено
     *
     * @param date Дата окончания ПМ
     */
    @Step("Заполнение полей необходимых для перевода ПМ Объявление предостережения в статус Предостережение объявлено")
    public void setFieldsForSavePMStatusWarningDeclared(String date) {
        setNoteWarningField(prefix + "Автотест");
        clickAddContentWarningButton();
        addDocumentAndSignatureNoteWarning(filePath, signPath);
        clickUploadButton();
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
    }

    /**
     * Перевод Объявление предостережения в статус Есть возражение
     */
    @Step("Перевод Объявление предостережения в статус Есть возражение")
    public void transferPMEventWarningAnnouncementStatusAnObjection() throws InterruptedException {
        clickAddInformationDirectionObjectionButton();
        addDocumentAndSignatureInformationDirectionObjection(filePath, signPath);
        clickUploadButton();
        closeNotification();
        clickSaveButton();
        closeNotification();
    }

    /**
     * Перевод Профилактического визита из статуса В процессе заполнения в статус Ожидает проведения
     *
     */
    @Step("Перевод Профилактического визита из статуса В процессе заполнения в статус Ожидает проведения")
    public String transferPMEventPreventiveVisitStatusLookingForward() throws InterruptedException {
        setStopDate(currentDate);
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        String numberNPA = setBlockOfRequirements("правительство");
        clickSaveButton();
        closeNotification();
        electronicSignatureInBrowser();
        sleep(5000);
        clickConfirmButton();
        closeNotification();
        closeNotification();
        return numberNPA;
    }

    /**
     * Заполнение полей необходимых для перевода ПМ Профилактического визита в статус Ожидает проведения
     *
     * @param date Дата окончания ПМ
     */
    @Step("Заполнение полей необходимых для перевода ПМ Профилактического визита в статус Ожидает проведения")
    public void setFieldsForSavePMStatusPreventiveVisit(String date) {
        setStopDate(date);
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
    }

    /**
     * Перевод Профилактического визита из статуса Ожидает проведения в статус Завершено
     */
    @Step("Перевод Профилактического визита из статуса Ожидает проведения в статус Завершено")
    public void transferPMEventPreventiveVisitStatusCompleted() {
        setResultPMField(prefix + " Авто результат");
        closeNotification();
        clickSaveButton();
        clickConfirmButton();
        closeNotification();
    }

    /**
     * Перевод Профилактического визита из статуса Ожидает проведения в статус Отказ в проведении
     *
     */
    @Step("Перевод Профилактического визита из статуса Ожидает проведения в статус Отказ в проведении")
    public void transferPMEventPreventiveVisitStatusRefusalToConduct() throws InterruptedException {
        clickedOnNavigationMenuItem(linkInfoAboutDissent);
        setPresenceOfDisagreementDropDown("Да");
        setDatePresenceOfDisagreementField(currentDate);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Нажать Добавить в обязательные требования подлежащие проверке
     */
    @Step("Нажать Добавить в обязательные требования подлежащие проверке")
    public void clickButtonAddForRequirements() {
        $(By.xpath(buttonAddForRequirements)).click();
    }

    /**
     * Нажать Сохранить в обязательные требования подлежащие проверке
     */
    @Step("Нажать Сохранить в обязательные требования подлежащие проверке")
    public void clickButtonSaveForRequirements() {
        $(By.xpath(buttonSaveInFormRequirement)).click();
    }

    /**
     * Поиск НПА в форме добавления обязательного требования
     *
     * @param nameNPA Наименование НПА
     */
    @Step("Поиск НПА - {nameNPA} в форме добавления обязательного требования")
    public void searchNameNPA(String nameNPA) {
        clearInput("Поиск НПА", inputNameNPA);
        $(By.xpath(inputNameNPA)).setValue(nameNPA);
        $(By.xpath(buttonSearchNPA)).click();
    }

    /**
     * Выбор НПА из таблицы в форме добавления обязательного требования
     */
    @Step("Выбор НПА из таблицы в форме добавления обязательного требования")
    public void selectNPAFromTable() {
        $(By.xpath(npaInTable)).click();
        $(By.xpath(buttonAddInFormRequirement)).click();
    }

    /**
     * Выбор СЕ из списка в форме добавления обязательного требования
     */
    @Step("Выбор СЕ из списка в форме добавления обязательного требования")
    public void selectSEFromList() {
        $(By.xpath(listOfStructuralUnits)).click();
        $(By.xpath(buttonSaveInFormRequirement)).click();
    }

    /**
     * Выбор содержания требования из списка в форме добавления обязательного требования
     */
    @Step("Выбор содержания требования из списка в форме добавления обязательного требования")
    public void selectContentFromList() {
        $(By.xpath(checkboxContentOfRequirement)).click();
    }

    /**
     * Добавление формулировки содержания требования в форме добавления обязательного требования
     */
    @Step("Добавление формулировки содержания требования в форме добавления обязательного требования")
    public void addContentFromList() {
        $(By.xpath(buttonAddContentOfRequirement)).click();
        $(By.xpath(textInputContentOfRequirement)).setValue("Автотест содержание");
        selectContentFromList();
    }

    /**
     * Раскрыть НПА в разделе Обязательные требования подлежащие проверке
     */
    @Step("Раскрыть НПА в разделе Обязательные требования подлежащие проверке")
    public void clickOnRequirements() {
        $(By.xpath(requirementsNPA)).click();
    }

    /**
     * Проверка заполненности Содержание требования
     */
    @Step("Проверка заполненности Содержание требования")
    public void checkValueOfFieldRequirement() {
        ElementsCollection requirements = $$ (By.xpath(contentOfRequirements));
        for (SelenideElement requirement : requirements) {
            requirement.shouldNotHave(exactText(""));
        }
    }

    /**
     * Заполнение блока Обязательные требования, подлежащие проверке
     *
     * @param nameNPA Наименование НПА
     */
    @Step("Заполнение блока Обязательные требования, подлежащие проверке: Наименование НПА - {nameNPA}")
    public String setBlockOfRequirements(String nameNPA) {
        String numberNPA = null;
        clickButtonAddForRequirements();
        searchNameNPA(nameNPA);
        Selenide.sleep(3000);
        try {
            selectNPAFromTable();
            Selenide.sleep(3000);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            numberNPA = addNewNPA(randomNumber);
        }
        finally {
            selectSEFromList();
            try {
                selectContentFromList();
            }catch (com.codeborne.selenide.ex.ElementNotFound e) {
                addContentFromList();
            }
            finally {
                clickButtonSaveForRequirements();
            }
            return numberNPA;
        }
    }

    /**
     * Создание нового НПА
     *
     * @param numberNPA Номер НПА
     */
    @Step("Создание нового НПА с номером - {numberNPA}")
    public String addNewNPA(String numberNPA) {
        clickButtonAddNewNPA();
        setFieldsForCreateNewNPA(numberNPA);
        clickButtonAddSE();
        setFieldsForNewSE("Статья", numberNPA);
        clickButtonSaveForCreateNewNPA();
        return numberNPA;
    }

    /**
     * Нажать кнопку Создать новый НПА
     */
    @Step("Нажать кнопку Создать новый НПА")
    public void clickButtonAddNewNPA() {
        $(By.xpath(buttonAddNewNPA)).click();
    }

    /**
     * Заполнение основных полей при создании НПА
     *
     * @param numberNPA  Номер НПА
     */
    @Step("Заполнение основных полей при создании НПА")
    public String setFieldsForCreateNewNPA(String numberNPA) {
        $(By.xpath(inputNumberNPA)).setValue(numberNPA);
        $(By.xpath(inputDateNPA)).setValue(currentDate);
        $(By.xpath(inputTitleNPA)).setValue("Автотест ");
        return numberNPA;
    }

    /**
     * Нажать Добавить в Структурные единицы
     */
    @Step("Нажать Добавить в Структурные единицы")
    public void clickButtonAddSE() {
        $(By.xpath(buttonAddSE)).click();
    }

    /**
     * Заполнение новой структурной единицы
     *
     * @param nameUnit Наименование единицы
     * @param value    Значение
     */
    @Step("Заполнение новой структурной единицы - {nameUnit} значением - {value}")
    public void setFieldsForNewSE(String nameUnit, String value) {
        $(By.xpath(selectInitField)).click();
        setValueDropDownToText(nameUnit);
        $(By.xpath(inputValueSE)).setValue(value);
    }

    /**
     * Нажать кнопку Сохранить при создании НПА
     */
    @Step("Нажать кнопку Сохранить при создании НПА")
    public void clickButtonSaveForCreateNewNPA() {
        $(By.xpath(buttonSaveNewNPA)).click();
    }

    /**
     * Нажать кнопку Отменить при создании НПА
     */
    @Step("Нажать кнопку Отменить при создании НПА")
    public void clickButtonCancelForCreateNewNPA() {
        $(By.xpath(buttonCancelNewNPA)).click();
    }

    /**
     * Проверка валидации при создании одинаковых НПА
     */
    @Step("Проверка валидации при создании одинаковых НПА")
    public void checkValidationForCreateNewNPA() {
        $(By.xpath(messageErrorForValidationCreateNPA)).shouldHave(text("Сохранение НПА невозможно. Данное НПА существует"));
    }

    /**
     * Редактирование НПА
     *
     * @param numberNPA  Номер НПА
     */
    @Step("Редактирование НПА")
    public String editFieldsNPA(String numberNPA) {
        $(By.xpath(iconEditNPA)).click();  // нажать иконку редактировать
        String[] fields = {inputNumberNPA, inputDateNPA, inputTitleNPA};
        for (String field : fields) {
            clearInput("{field}", field);
        }   // отчистить поля в цикле
        setFieldsForCreateNewNPA(numberNPA);  // заполнить поля
        clickButtonAddSE();
        setFieldsForNewSE("Пункт", numberNPA);
        clickButtonSaveForCreateNewNPA();
        clickConfirmButton();
        return numberNPA;
    }

    /**
     * Раскрыть раздел История изменений профилактических мероприятий
     */
    @Step("Раскрыть раздел История изменений профилактических мероприятий")
    public void openHistoryOfChangesPM() {
        $(By.xpath(buttonOpenHistoryOfChanges)).click();
    }

    /**
     * Проверка номера НПА из таблицы на соответствие
     *
     * @param numberNPA Номер НПА
     */
    @Step("Проверка номера НПА из таблицы на соответствие - {numberNPA}")
    public void checkNumberNPAFromTable(String numberNPA) {
        $(By.xpath(numberNPAInTableSearchResults)).should(Text.text(numberNPA));
    }

    /**
     * Сортировка по периоду проведения
     *
     * @param parameter Параметр сортировки true - возрастание/false - убывание
     */
    @Step("Сортировка по периоду проведения")
    public void sortingByPeriod(boolean parameter) {
        if (parameter) {
            $(By.xpath(sortingByPeriod)).click();
        } else {
            $(By.xpath(sortingByPeriod)).doubleClick();
        }
    }

    /**
     * Удаление карточки ПМ
     */
    @Step("Удаление карточки ПМ")
    public void deletePM() {
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        closeNotification();
    }




}
