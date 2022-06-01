package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;

public class ListPreventionEventsPage extends Common {
    //список ПМ

    public String prefix = UUID.randomUUID().toString();
    String statusPM = "//span[contains(@class, 'KnmHeader_Status')]"; // Статус КНМ
    public String officialPost = "Руководитель Территориального органа Росздравнадзора";
    String nameKNOPMDropDown = "//*[@id='knoOrganizationPm']"; // выпадающий список Контрольный надзорный орган
    String kindControlAndNumberPMDropDown = "//*[@id='supervisionTypePm']"; // выпадающий список Вид контроля (надзора) и его номер
    String kindPMDropDown = "//*[@id='pmType']"; // выпадающий список Вид ПМ
    public String typeAnnouncementWarningsPM = "Объявление предостережения";
    public String typePreventiveVisitPM = "Профилактический визит";
    public String typeObject = "Деятельность и действия";
    public String viewObject = "используемые контролируемыми лицами при осуществлении деятельности в " +
            "сфере обращения лекарственных средств помещения, к которым предъявляются обязательные требования";
    public String classDanger = "Первый";
    public String classDanger2 = "Второй";

    String startDateField = "//*[@id='startDateBlock']//input"; // поле Дата начала
    String stopDateField = "//*[@id='stopDateBlock']//input"; // поле Дата окончания
    String innField = "//*[@name='inn']"; // Поле ИНН
    String innListField = "//li[contains(@class,'AutoComplete_OptionItem')]"; // выбор из выпадающего списка ИНН

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

    String numberPM = "//h3[contains(@class, 'KnmHeader_Title')]";

    String documentNoteWarningInput = "//input[@id='contentWarningAttachmentsUploadDocument']"; // input для добавления документа в содержание предостережения
    String signatureNoteWarningInput = "//input[@id='contentWarningAttachmentsUploadSign']"; // input для добавления подписи в содержание предостережения


    String addInformationDirectionObjectionButton = "//*[@id='pmObjectionWarningAddButton']"; // кнопка Добавить в разделе Сведения о направлении возражения на предостережение
    String resultPMField = "//*[@id='resultOfInspection']"; // поле результат ПМ

    String documentInformationDirectionObjectionInput = "//input[@id='objectionWarningAttachmentsUploadDocument']"; // input для добавления документа в сведения о направлении возражения на предостережение
    String signatureInformationDirectionObjectionInput = "//input[@id='objectionWarningAttachmentsUploadSign']"; // input для добавления подписи в сведения о направлении возражения на предостережение

    String presenceOfDisagreementDropDown = "//*[@id='isRejectSubjectBlock']//div[contains(@class, 'SelectInput_SelectInput')]"; // Выпадающий список Наличие несогласия в блоке Информация о несогласии контролируемого лица на проведение мероприятия TODO Должен быть идентификатор
    String datePresenceOfDisagreementField = "//*[@id='isRejectSubjectBlock']//input[contains(@class, 'DatePicker_Input')]"; // Поле Дата информации о несогласии контролируемого лица на проведение мероприятия TODO Должен быть идентификатор
    public String statusWarningAnnounced = "Предостережение объявлено";
    public String statusAnObjection = "Есть возражение";

    public String statusRefusalToConduct = "Отказ в проведении";

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
        $(By.xpath(stopDateField)).setValue(date);
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
        clickOfficialPMButton();
        setOfficialField(name);
        setOfficialPostPMDropDown(post);
    }

    /**
     * Добавление ПМ
     *
     * @param name        Название контрольного (надзорного) органа
     * @param view        Вид контроля (надзора) и его номер
     * @param typePM      Вид ПМ
     * @param date        Дата начала
     * @param inn         ИНН
     * @param typeObject  тип объекта
     * @param viewObject  вид объекта
     * @param classDanger класс опасности
     */
    @Step("Добавление ПМ")
    public void addPreventionEvent(String name, String view, String typePM, String date, String inn, String typeObject, String viewObject, String classDanger) {
        clickAddButton();
        setNameKNOPMDropDown(name);
        setKindControlAndNumberPMDropDown(view);
        setKindPMDropDown(typePM);
        setStartDate(date);
        setInnField(inn);
        addObjectData(typeObject, viewObject, classDanger);
        clickSaveButton();
        clickConfirmButton();
        closeNotification();
        checkStatusPM(statusProcessFilling);
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
        $(By.xpath(signatureNoteWarningInput)).uploadFile(new File(sPath));
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
        $(By.xpath(signatureInformationDirectionObjectionInput)).uploadFile(new File(sPath));
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
        $(By.xpath(presenceOfDisagreementDropDown)).click();
        setValueDropDownToText(approval);
    }

    /**
     * Заполнение даты в блоке Информация о несогласии контролируемого лица на проведение мероприятия
     *
     * @param date Дата
     */
    @Step("Заполнение даты в блоке Информация о несогласии контролируемого лица на проведение мероприятия")
    public void setDatePresenceOfDisagreementField(String date) {
        $(By.xpath(datePresenceOfDisagreementField)).setValue(date);
    }

    /**
     * Проверка статуса ПМ
     *
     * @param status Статус, который должен быть у ПМ
     */
    @Step("Проверка статуса ПМ - {status}")
    public void checkStatusPM(String status) {
        $(By.xpath(statusPM)).should(Text.text(status));
    }

    /**
     * Перевод Объявление предостережения в статус Предостережение объявлено
     *
     * @param date Дата окончания ПМ
     */
    @Step("Перевод Объявление предостережения в статус Предостережение объявлено")
    public void transferPMEventWarningAnnouncementStatusWarningAnnounced(String date) {
        clickConfirmButton();
        setStopDate(date);
        setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        addDocumentAndSignatureNoteWarning(filePath, signPath);
        clickUploadButton();
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        closeNotification();
        clickSaveButton();
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        closeNotification();
        closeNotification();
        clickConfirmButton();
        closeNotification();
        checkStatusPM(statusWarningAnnounced);
    }

    /**
     * Перевод Объявление предостережения в статус Есть возражение
     */
    @Step("Перевод Объявление предостережения в статус Есть возражение")
    public void transferPMEventWarningAnnouncementStatusAnObjection() {
        clickAddInformationDirectionObjectionButton();
        addDocumentAndSignatureInformationDirectionObjection(filePath, signPath);
        clickUploadButton();
        closeNotification();
        clickSaveButton();
        checkStatusPM(statusAnObjection);
        closeNotification();
    }

    /**
     * Перевод Профилактического визита из статуса В процессе заполнения в статус Ожидает проведения
     *
     * @param date Дата окончания ПМ
     */
    @Step("Перевод Профилактического визита из статуса В процессе заполнения в статус Ожидает проведения")
    public void transferPMEventPreventiveVisitStatusLookingForward(String date) {
        clickConfirmButton();
        setStopDate(date);
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        clickSaveButton();
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        closeNotification();
        closeNotification();
        clickConfirmButton();
        closeNotification();
        checkStatusPM(statusProcessAwaiting);
    }

    /**
     * Перевод Профилактического визита из статуса Ожидает проведения в статус Завершено
     */
    @Step("Перевод Профилактического визита из статуса Ожидает проведения в статус Завершено")
    public void transferPMEventPreventiveVisitStatusCompleted() {
        clickConfirmButton();
        setResultPMField(prefix + "авто результат");
        clickSaveButton();
        clickConfirmButton();
        closeNotification();
        checkStatusPM(statusCompleted);
    }

    /**
     * Перевод Профилактического визита из статуса Ожидает заполнения в статус отказ в проведении
     *
     * @param date Дата поля Наличие несогласия
     */
    @Step("Перевод Профилактического визита из статуса Ожидает заполнения в статус отказ в проведении")
    public void transferPMEventPreventiveVisitStatusRefusalToConduct(String date) {
        setPresenceOfDisagreementDropDown("Да");
        setDatePresenceOfDisagreementField(date);
        clickSaveButton();
        closeNotification();
        checkStatusPM(statusRefusalToConduct);
    }
}
