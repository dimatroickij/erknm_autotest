package testPages;

import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.conditions.Value;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ListEventsPage extends Common {
//раздел Список КНМ

    public String prefix = UUID.randomUUID().toString();
    public String placeDecision = prefix + " автотестМесто"; // Значение для поля Место вынесения решения или похожих полей
    public String nameTitle = prefix + "авто"; // Значение для поля Наименование в блоке ОТ
    public String officialField = prefix + " autoFIO"; // Значение для поля ФИО должностного лица
    String numberKNM = "//*[contains(@class, 'KnmHeader_Title_') and (contains(string(), 'КНМ 0') or contains(string(), 'КНМ 7'))]";//объект для получения номера КНМ
    String statusKNM = "//span[contains(@class, 'KnmHeader_Status')]";
    String nameKNODropDown = "//*[@id='knoOrganizationErknm']"; //выпадающий список Наименование органа контроля
    String kindControlAndNumberDropDown = "//*[@id='kindControl']/div"; //выпадающий список Вид контроля (надзора) и его номер
    String kindKNMDropDown = "//*[@id='kindKnm']/div/div[1]"; // выпадающий список Вид КНМ
    String characterKNMDropDown = "//*[@id='typeErknm']/div/div[1]"; // выпадающий список Характер КНМ
    String startKNMDate = "//*[@id='startDateBlock']/div[2]/div[1]/div/div/input"; //Дата начала КНМ
    String nameProsecutorDropDown = "//*[@id='prosecutorOrganizationErknm']/div/div[1]"; //Наименование прокуратуры
    String innField = "//*[@name='organizations[0].inn']"; //ИНН
    String innListField = "//*[@id='autoCompleteList']"; //появившийся спискок ИНН

    String numberPlanField = "//*[@id='planId']"; //номер плана
    String durationDaysField = "//*[@name='durationDays']"; //срок проведения(дней)
    String addGroundsIncludePlanButton = "//*[@id='addReasonButton']"; //Кнопка добавить в раздел Основания включения в план
    String groundsIncludePlanDropDown = "//*[@id='reasonsErknm[0].type']";//основания включения в план
    String GIP = "4.0.1 (ФЗ 248) Истечение установленного федеральным законом о виде контроля, положением о виде контроля период времени с даты окончания проведения последнего планового контрольного (надзорного) мероприятия";
    String dateGIPField = "/html/body/div/div/main/form/div[2]/section[1]/div[13]/div[2]/div/div/div[2]/div/div[1]/div/div/input";//дата основания включения в план TODO Должнен быть идентификатор

    String addObjectControlKNMButton = "//*[@id='erknmObjectsAddButton']";//кнопка Добавить в разделе Сведения об объектах контроля в карточке КНМ
    String addressField = "//*[@name='objectsErknm[0].addressText']";//поле Местонахождение
    String typeObjectDropDown = "//*[@id='objectsErknm[0].objectType']";//тип объекта
    String typeObject = "Деятельность и действия";
    String kindObjectDropDown = "//*[@id='objectsErknm[0].objectKind']";//вид объекта
    String kingObject = "используемые контролируемыми лицами при осуществлении деятельности в сфере обращения лекарственных средств помещения, к которым предъявляются обязательные требования";
    String subkindObjectDropDown = "//*[@id='objectsErknm[0].objectSubKind']";//подвид объекта
    String dangerClassDropDown = "//*[@id='objectsErknm[0].dangerClass']";//класс опасности
    String dangerClass = "Первый";

    String addListActionsButton = "//*[@id='erknmEventsAddButton']";//кнопка Добавить в разделе Перечень действий
    String typeActionsDropDown = "//*[@id='eventsErknm[0].type']";//Выберете тип действия
    String typeActions = "Осмотр";
    String dateStartActions = "/html/body/div/div/main/form/div[2]/section[3]/div[8]/div[2]/div/div[2]/div/div[1]/div/div/input"; //Дата начала
    String dateEndActions = "/html/body/div/div/main/form/div[2]/section[3]/div[8]/div[2]/div/div[3]/div/div[1]/div/div/input"; //Дата окончания

    String addVenueButton = "//*[@id ='erknmPlacesAddButton']"; //Кнопка добавить в разделе Место (места) проведение КНМ
    String venueField = "//*[@name='places[0].value']"; //поле для введения Места


    String dateTimePublicationDecisionField = "/html/body/div/div/main/form/div[2]/section[1]/div[7]/div[1]/div[2]/div[1]/div/div/input"; // поле Дата и время издания решения в разделе о проведении КНМ
    String solutionNumberField = "//*[@id='numberDecision']"; //поле Номер решения в разделе Решение о проведении КНМ
    String placeDecisionField = "//*[@id='placeDecision']";// поле Место вынесения решения
    String nameOfficialField = "//*[@id='fioSigner']";// поле ФИО должностного лица
    String positionPersonSignedDecisionsDropDown = "//*[@id='titleSigner']";// поле Должность лица, подписавшего решение
    String durationEventHoursField = "//*[@name='durationHours']";//поле срок проведения (часов)
    String addGroundConductingButton = "//*[@id ='addReasonButton']";//кнопка Добавить в разделе Основания проведения КНМ
    String groundConductingDropDown = "//*[@id ='reasonsErknm[0].type']"; //выпадающий список Основание регистрации КНМ
    String groundConduction = "4.0.15 (Постановление 336) Непосредственная угроза причинения вреда жизни и тяжкого вреда здоровью граждан, факты причинения вреда жизни и тяжкого вреда здоровью граждан";
    String needCoordinationDropDown = "//*[@id='approveRequired']/div/div[1]";//выпадающий список Необходимость согласования
    String addFoundationButton = "//*[text()='Добавить основание']";
    String typeDocumentDropDown = "//*[@id='reasonDocuments[0].type']"; // выпадающий список Тип документа
    String typeDocument = "Мотивированное представление о проведении контрольного (надзорного)";
    String addFileButton = "/html/body/div/div/main/form/div[2]/section[1]/div[14]/div[2]/div/div/div[2]/button";//кнопка Добавить у блока Файл

    String addMandatoryRequirementsButton = "//button[@id='erknmRequirementsAddButton']";//кнопка Добавить в блоке обязательные требования, подлежащие проверке
    String mandatoryRequirementsDropDown = "//*[@id='requirementsErknm[0].requirement']/div/div[1]/div[1]";//выпадающий список Обязательные требования
    String addNewSampleButton = "Создать новый"; //создать новый шаблон TODO Должен быть идентификатор
    String nameMandatoryRequirementsField = "//*[@id='requirementsErknm[0].manualTitle']";//поле Наименование в блоке ОТ
    String createdNameMandatoryRequirementsField = "//*[@id='requirementsErknm[0].requirement']";//поле Наименование в блоке ОТ после сохранения
    String npaMandatoryRequirementsField = "//*[@id='requirementsErknm[0].manualNameNpa']";//поле Наименование НПА в блоке ОТ
    String dateNPAMandatoryRequirementsField = "/html/body/div/div/main/form/div[2]/section[4]/div[2]/table/tbody/tr/td[4]/div/div/div/div/input";//поле Дата НПА

    String documentGroundsConductingInput = "//input[@id='reasonDocuments[0].attachmentsUploadDocument']"; // input для добавления документа в блоке Основания провердения КНМ
    String signatureGroundsConductingInput = "//input[@id='reasonDocuments[0].attachmentsUploadSign']"; // input для добавления подписи в блоке Основания провердения КНМ

    String approvalButton = "//button[text()='На согласование']";//кнопка в подменю На согласование

    String decisionApplicationDropDown = "//*[@id='approved']/div/div[1]"; //Выпадающий список Решение по заявлению

    //Блок Сведения об акте
    String addInformationAboutActsButton = "/html/body/div/div/main/form/div[2]/section[6]/div/button";//Кнопка Добавить в блоке Сведения об акте
    String addFileActButton = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[1]/div/span/button"; //Кнопка добавить Файл акта
    String documentInformationAboutActsInput = "//input[@id='acts[0].document.attachmentsUploadDocument']"; // input для добавления документа в блоке Файл акта
    String signatureInformationAboutActsInput = "//input[@id='acts[0].document.attachmentsUploadSign']"; // input для добавления подписи в блоке Файл акта
    String numberActField = "//*[@name='acts[0].numberAct']";//поле Номер акта КНМ
    String dateDrawingUpAct = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[3]/div/div[2]/div/div/div/input"; //поле Дата и время составления акта КНМ
    String dateStartKNM = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input"; //поле Дата и время начала проведения КНМ
    String durationDaysActField = "//*[@name='acts[0].durationDays']";//поле Срок проведения (в днях)
    String nameSignatoryActField = "//*[@name='acts[0].fioSigner']"; //поле ФИО подписавшего акт
    String positionSignatoryActDropDown = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[6]/div[2]/div[2]/div/div/div[1]";//Выпадающий список Должность лица, подписавшего акт
    String addOfficialsParticipatedButton = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[7]/div[1]/button"; //Кнопка Добавить в блоке Должностные лица КНО, участвовавшие в КНМ
    String officialsParticipatedEventField = "//*[@name='acts[0].knoInspectors[0].fullName']";//поле Введите ФИО в блоке Должностные лица КНО, участвовавшие в КНМ
    String positionOfficialsParticipatedDropDown = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[7]/div[2]/div/div[2]/div[1]/div/div[1]/div";//выпадающий список Выберете должность в блоке Должностные лица КНО, участвовавшие в КНМ
    String factField = "//*[@name='acts[0].isViolationResolvedNote']";//Факт устранения выявленного нарушения
    String informationAboutRecognitionDropDown = "/html/body/div/div/main/form/div[2]/section[6]/div[2]/div[2]/div[12]/div[1]/div/div/div[1]";//выпадающий список Сведения об ознакомлении контролируемых лиц с результатами КНМ
    String whoFamiliarWithField = "//*[@name='acts[0].fioReader']";// поле Кто ознакомлен
    String positionFamiliarWithField = "//*[@name='acts[0].titleReader']";// поле Должность

    String addInformationAboutOfficialsParticipatingButton = "//*[@id ='erknmInspectorsAddButton']"; //кнопка Добавить в разделе Сведения о должностных лицах, участвующих в КНМ
    String addFIOParticipatingField = "//*[@name='inspectorsErknm[0].fullName']"; //поле Введите ФИО должностного лица
    String addPositionParticipatingDropDown = "//*[@id='inspectorsErknm[0].position']/div/div"; //выпадающий список Выберете должность

    String checklistCheckbox = "//*[@id='isChecklistsUsed']";// чек-бокс Отметка об использовании проверочного листа
    String addChecklistButton = "/html/body/div/div/main/form/div[2]/section[4]/div[6]/div/div/button"; //Добавить проверочный лист
    String nameChecklistDropDown = "/html/body/div/div/main/form/div[2]/section[4]/div[6]/div/ul/li/div/div[2]/div[2]/div[2]/div/div/div/div[1]/div"; //Выпадающий список Наименовние проверочного листа
    String nameChecklistField = "//*[@name='checklistsErknm[0].newTitle']"; //поле для ввода наименования нового проверочного листа

    public ListEventsPage() throws Exception {
    }

    /**
     * Проверка статуса КНМ
     *
     * @param status Статус, который должен быть у проверки
     */
    public void checkStatusKNM(String status) {
        $(By.xpath(statusKNM)).should(Text.text(status));
    }

    /**
     * Выбор из выпадающего списка Наименование органа контроля
     *
     * @param name Наименование органа контроля
     */
    @Step("Выбор из выпадающего списка Наименование органа контроля - {name}")
    public void setNameKNODropDown(String name) {
        $(By.xpath(nameKNODropDown)).click(); // клик на выпадающем списке Наименование органа контроля
        clickToText(name); // клик на нужной организации
    }

    /**
     * Выбор из выпадающего списка Вид контроля
     *
     * @param kind Вид контроля
     */
    @Step("Выбор из выпадающего списка Вид контроля - {kind}")
    public void setKindControlAndNumberDropDown(String kind) {
        $(By.xpath(kindControlAndNumberDropDown)).click(); // клик на выпадающем списке Вид контроля
        clickToText(kind); // клик на нужном виде контроля
    }

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param kind Вид КНМ
     */
    @Step("Выбор из выпадающего списка Вид КНМ - {kind}")
    public void setKindKNMDropDown(String kind) {
        $(By.xpath(kindKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        clickToText(kind); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка Характер КНМ
     *
     * @param kind Характер КНМ
     */
    @Step("Выбор из выпадающего списка Характер КНМ - {kind}")
    public void setCharacterKNMDropDown(String kind) {
        $(By.xpath(characterKNMDropDown)).click(); // клик на выпадающем списке Характер КНМ
        clickToText(kind); // клик на нужном характере КНМ
    }

    /**
     * Заполнение поля Дата начала КНМ
     */
    @Step("Заполнение поля Дата начала КНМ - {date}")
    public void setStartKNMDate(String date) {
        $(By.xpath(startKNMDate)).setValue(date);
    }

    /**
     * Выбор из выпадающего списка Наименование прокуратуры
     *
     * @param name Наименование прокуратуры
     */
    @Step("Выбор из выпадающего списка Наименование прокуратуры - {name}")
    public void setNameProsecutorDropDown(String name) {
        $(By.xpath(nameProsecutorDropDown)).click(); // клик на выпадающем списке Наименование прокуратуры
        clickToText(name); // клик на нужной прокуратуре
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
     * Получение номера КНМ
     */
    @Step("Получение номера КНМ")
    public String getNumberKNM() {
        String number = $(By.xpath(numberKNM)).getOwnText();
        number = number.substring(4, 25);
        System.out.println("НОМЕР - " + number);
        return number;
    }

    /**
     * Заполнение поля Номер плана
     *
     * @param number Номер плана
     */
    @Step("Заполнение поля Номер плана - {number}")
    public void setNumberPlanField(String number) {
        $(By.xpath(numberPlanField)).setValue(number);
    }

    /**
     * Заполнение поля Срок проведения(дней)
     *
     * @param days Срок проведения(дней)
     */
    @Step("Заполнение поля Срок проведения(дней) - {days} дней")
    public void setDurationDaysField(String days) {
        $(By.xpath(durationDaysField)).setValue(days);
    }

    /**
     * Заполнение поля Срок проведения(часов)
     *
     * @param hours Срок проведения(часов)
     */
    @Step("Заполнение поля Срок проведения(часов) - {hours} часов")
    public void setDurationEventHoursField(String hours) {
        $(By.xpath(durationEventHoursField)).setValue(hours);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Основания включения в план
     */
    @Step("Нажатие на кнопку Добавить в разделе Основания включения в план")
    public void clickAddGroundsIncludePlanButton() {
        $(By.xpath(addGroundsIncludePlanButton)).click();
    }

    /**
     * Выбор основания регистрации КНМ
     */
    @Step("Выбор основания регистрации КНМ - {GIP}")
    public void setGroundsIncludePlanDropDown() {
        $(By.xpath(groundsIncludePlanDropDown)).click();
        clickToText(GIP);
    }

    /**
     * Заполнение основания включения в план
     */
    @Step("Заполнение основания включения в план")
    public void addGroundsIncludePlan(String date) {
        clickAddGroundsIncludePlanButton();
        setGroundsIncludePlanDropDown();
        setDateGIPField(date);
    }

    /**
     * Заполнение даты в разделе Основания включения в план
     *
     * @param date Дата
     */
    @Step("Заполнение даты в разделе Основания включения в план")
    public void setDateGIPField(String date) {
        $(By.xpath(dateGIPField)).setValue(date);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Сведения об объектах контроля в карточке КНМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Сведения об объектах контроля в карточке КНМ")
    public void clickAddObjectControlKNMButton() {
        $(By.xpath(addObjectControlKNMButton)).click();
    }

    /**
     * Заполнение поля Местонахождение
     *
     * @param address Местонахождение
     */
    @Step("Заполнение поля Местонахождение - {address}")
    public void setAddressField(String address) {
        $(By.xpath(addressField)).setValue(address);
    }

    /**
     * Выбор Типа объекта
     */
    @Step("Выбор Типа объекта - {typeObject}")
    public void setTypeObjectDropDown() {
        $(By.xpath(typeObjectDropDown)).click();
        clickToText(typeObject);
    }

    /**
     * Выбор Вида объекта
     */
    @Step("Выбор Вида объекта - {kindObject}")
    public void setKindObjectDropDown() {
        $(By.xpath(kindObjectDropDown)).click();
        clickToText(kingObject);
    }

    /**
     * Выбор Подвида объекта
     */
    @Step("Выбор Подвида объекта - {}")
    public void setSubkindObjectDropDown() {
        $(By.xpath(subkindObjectDropDown)).click();
        clickToText(kingObject);
    }

    /**
     * Выбор Класса опасности
     */
    @Step("Выбор Класса опасности - {dangerClass}")
    public void setDangerClassDropDown() {
        $(By.xpath(dangerClassDropDown)).click();
        clickToText(dangerClass);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Перечень действий, осуществляемый в рамках КНМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Перечень действий, осуществляемый в рамках КНМ")
    public void clickAddListActionsButton() {
        $(By.xpath(addListActionsButton)).click();
    }

    /**
     * Выберете Тип действия в разделе Перечень действий
     */
    @Step("Выберете Тип действия в разделе Перечень действий - {typeActions}")
    public void setTypeActionsDropDown() {
        $(By.xpath(typeActionsDropDown)).click();
        clickToText(typeActions);
    }

    /**
     * Заполнение Дата начала в Перечне действий
     *
     * @param date Дата начала
     */
    @Step("Заполнение Дата начала в Перечне действий - {date}")
    public void setDateStartActions(String date) {
        $(By.xpath(dateStartActions)).setValue(date);
    }

    /**
     * Заполнение Дата окончания в Перечне действий
     *
     * @param date Дата окончания
     */
    @Step("Заполнение Дата окончания в Перечне действий - {date}")
    public void setDateEndActions(String date) {
        $(By.xpath(dateEndActions)).setValue(date);
    }

    /**
     * Заполнение блока Перечень действий, осуществляемый в рамках КНМ
     *
     * @param startDate Дата начала
     * @param endDate   Дата окончания
     */
    @Step("Заполнение блока Перечень действий, осуществляемый в рамках КНМ")
    public void addListActions(String startDate, String endDate) {
        clickAddListActionsButton();
        setTypeActionsDropDown();
        setDateStartActions(startDate);
        setDateEndActions(endDate);
    }

    /**
     * Нажать кнопку Добавить в разделе Место (места) проведения КНМ
     */
    @Step("Нажать кнопку Добавить в разделе Место (места) проведения КНМ")
    public void clickAddVenueButton() {
        $(By.xpath(addVenueButton)).click();
    }

    /**
     * Заполнение поля Введите место
     *
     * @param venue Место
     */
    @Step("Заполнение поля Введите место - {venue}")
    public void setVenueField(String venue) {
        $(By.xpath(venueField)).setValue(venue);
    }

    /**
     * Заполнение поля Дата и время издания решения в разделе о проведении КНМ
     *
     * @param date Дата и время издания решения
     */
    @Step("Заполнение поля Дата и время издания решения в разделе о проведении КНМ - {date}")
    public void setDateTimePublicationDecisionField(String date) {
        $(By.xpath(dateTimePublicationDecisionField)).setValue(date);
    }

    /**
     * Заполнение поля Номер решения в разделе Решение о проведении КНМ
     *
     * @param number Номер решения
     */
    @Step("Заполнение поля Номер решения в разделе Решение о проведении КНМ - {number}")
    public void setSolutionNumberField(String number) {
        $(By.xpath(solutionNumberField)).setValue(number);
    }

    /**
     * Заполнение поля Место вынесения решения
     *
     * @param place Место вынесения решения
     */
    @Step("Заполнение поля Место вынесения решения - {place}")
    public void setPlaceDecisionField(String place) {
        $(By.xpath(placeDecisionField)).setValue(place);
    }

    /**
     * Заполнение поля ФИО должностного лица
     *
     * @param name ФИО должностного лица
     */
    @Step("Заполнение поля ФИО должностного лица - {name}")
    public void setNameOfficialField(String name) {
        $(By.xpath(nameOfficialField)).setValue(name);
    }

    /**
     * Выбор из выпадающего списка Должность лица, подписавшего решение
     */
    @Step("Выбор из выпадающего списка Должность лица, подписавшего решение - {positionDirector}")
    public void setPositionPersonSignedDecisionsDropDown() {
        $(By.xpath(positionPersonSignedDecisionsDropDown)).click();
        clickToText(positionDirector);
    }

    /**
     * Нажатие на кнопку Добавить в блоке Основания проведения КНМ
     */
    @Step("Нажатие на кнопку Добавить в блоке Основания проведения КНМ")
    public void clickAddGroundConductingButton() {
        $(By.xpath(addGroundConductingButton)).click();
    }

    /**
     * Заполнение выпадающего списка Основание регистрации КНМ
     */
    @Step("Заполнение выпадающего списка Основание регистрации КНМ - {groundConduction}")
    public void setGroundConductingDropDown() {
        $(By.xpath(groundConductingDropDown)).click();
        clickToText(groundConduction);
    }

    /**
     * Заполнение выпадающего списка Необходимость согласования
     *
     * @param parameter необходимый параметр
     */
    @Step("Заполнение выпадающего списка Необходимость согласования - {needCoordination}")
    public void setNeedCoordinationDropDown(String parameter) {
        $(By.xpath(needCoordinationDropDown)).click();
        clickToText(parameter);
    }

    /**
     * Нажатие на кнопку Добавить основание
     */
    @Step("Нажатие на кнопку Добавить основание")
    public void clickAddFoundationButton() {
        $(By.xpath(addFoundationButton)).click();
    }

    /**
     * Выбор из выпадающего списка Тип документа
     */
    @Step("Выбор из выпадающего списка Тип документа - {typeDocument}")
    public void setTypeDocumentDropDown() {
        $(By.xpath(typeDocumentDropDown)).click();
        clickToText(typeDocument);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Файл
     */
    @Step("Нажатие на кнопку Добавить в разделе Файл")
    public void clickAddFileButton() {
        $(By.xpath(addFileButton)).click();
    }

    /**
     * Добавление решения по заявлению
     *
     * @param result решение
     */
    @Step("Добавление решения по заявлению - {result}")
    public void setDecisionApplicationDropDown(String result) {
        $(By.xpath(decisionApplicationDropDown)).should(visible, Duration.ofSeconds(10)).click();
        clickToText(result);
    }

    /**
     * Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки
     */
    @Step("Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки")
    public void clickAddMandatoryRequirementsButton() {
        $(By.xpath(addMandatoryRequirementsButton)).shouldBe(visible).click();
    }

    /**
     * Открытие выпадающего списка ОТ и нажатие на кнопку Создать новое ОТ
     */
    @Step("Открытие выпадающего списка ОТ и нажатие на кнопку Создать новое ОТ")
    public void setMandatoryRequirementsDropDown() {
        $(By.xpath(mandatoryRequirementsDropDown)).scrollIntoView(false).click();
        clickToText(addNewSampleButton);
    }

    /**
     * Заполнение Наименования ОТ
     *
     * @param name Наименование ОТ
     */
    @Step("Заполнение Наименования ОТ - {name}")
    public void setNameMandatoryRequirementsField(String name) {
        $(By.xpath(nameMandatoryRequirementsField)).setValue(name);
    }

    /**
     * Заполнение поля Наименование НПА в блоке ОТ
     *
     * @param nameNPA Наименование НПА
     */
    @Step("Заполнение поля Наименование НПА в блоке ОТ - {nameNPA}")
    public void setNpaMandatoryRequirementsField(String nameNPA) {
        $(By.xpath(npaMandatoryRequirementsField)).setValue(nameNPA);
    }

    /**
     * Заполнение даты НПА
     *
     * @param date дата НПА
     */
    @Step("Заполнение даты НПА - {date}")
    public void setDateNPAMandatoryRequirementsField(String date) {
        $(By.xpath(dateNPAMandatoryRequirementsField)).setValue(date);
    }

    /**
     * Добавление нового обязательного требования
     *
     * @param name    Название ОТ
     * @param nameNPA Название НПА
     * @param date    Дата
     */
    @Step("Добавление нового обязательного требования")
    public void createMandatoryRequirements(String name, String nameNPA, String date) {
        $(By.xpath("//*[text()='Предмет контрольного (надзорного) мероприятия']")).scrollIntoView(false);
        clickAddMandatoryRequirementsButton();
        setMandatoryRequirementsDropDown();
        setNameMandatoryRequirementsField(name);
        setNpaMandatoryRequirementsField(nameNPA);
        setDateNPAMandatoryRequirementsField(date);
    }

    /**
     * Создание КНМ
     *
     * @param nameKNO        Наименование органа контроля
     * @param viewKNO        Вид контроля (надзора) и его нормер
     * @param kind           Вид КНМ
     * @param nameProsecutor Наименование прокуратуры
     * @param inn            ИНН
     */
    @Step("Создание внеплановой КНМ: Наименование органа контроля - {nameKNO}, Вид контроля (надзора) - {viewKNO}, " +
            "Вид КНМ - {kind}, Дата начала КНМ - {date}, Наименование прокуратуры - {nameProsecutor}, ИНН - {inn}")
    public void addUnplannedKNM(String nameKNO, String viewKNO, String kind, String date, String nameProsecutor,
                                String inn) {
        clickAddButton();
        setNameKNODropDown(nameKNO);
        setKindControlAndNumberDropDown(viewKNO);
        setKindKNMDropDown(kind);
        setCharacterKNMDropDown(unplannedCheck);
        setStartKNMDate(date);
        setNameProsecutorDropDown(nameProsecutor);
        setInnField(inn);
        setTypeObjectDropDown();
        setKindObjectDropDown();
        setDangerClassDropDown();
        clickSaveButton();
        closeNotification();
    }

    /**
     * Добавление документа и подписи в блоке Основания проведения КНМ
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление документа и подписи в блоке Основания проведения КНМ")
    public void addDocumentAndSignatureGroundsConducting(String fPath, String sPath) {
        $(By.xpath(documentGroundsConductingInput)).uploadFile(new File(fPath));
        $(By.xpath(signatureGroundsConductingInput)).uploadFile(new File(sPath));
    }

    /**
     * Добавление блока Основания проведения КНМ для внеплановой КНМ
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     * @param param параметр требует/не требует согласования
     */
    @Step("Добавление блока Основания проведения КНМ для внеплановой КНМ")
    public void addGroundsConductingUnscheduled(String fPath, String sPath, String param) {
        clickAddGroundConductingButton();
        setGroundConductingDropDown();
        setNeedCoordinationDropDown(param);
        clickAddFoundationButton();
        setTypeDocumentDropDown();
        clickAddFileButton();
        addDocumentAndSignatureGroundsConducting(fPath, sPath);
        clickUploadButton();
    }

    /**
     * Добавление блока Основания проведения КНМ для плановой КНМ
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление блока Основания проведения КНМ для плановой КНМ")
    public void addGroundsConductingPlanned(String fPath, String sPath) {
        clickAddGroundConductingButton();
        setGroundConductingDropDown();
        clickAddFoundationButton();
        setTypeDocumentDropDown();
        clickAddFileButton();
        addDocumentAndSignatureGroundsConducting(fPath, sPath);
        clickUploadButton();
    }

    /**
     * Нажатие на кнопку На согласование
     */
    @Step("Нажатие на кнопку На согласование")
    public void clickForApprovalButton() {
        $(By.xpath(approvalButton)).click();
    }

    /**
     * Нажатие на Кнопку Добавить в блоке Сведения об акте
     */
    @Step("Нажатие на Кнопку Добавить в блоке Сведения об акте")
    public void clickAddInformationAboutActsButton() {
        $(By.xpath(addInformationAboutActsButton)).should(visible, Duration.ofSeconds(10)).click();
    }

    /**
     * Нажатие на кнопку добавить файл акта
     */
    @Step("Нажатие на кнопку добавить файл акта")
    public void clickAddFileActButton() {
        $(By.xpath(addFileActButton)).click();
    }

    /**
     * Добавление документа и подписи в блоке Файл акта
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление документа и подписи в блоке Файл акта")
    public void addDocumentAndSignatureFileAct(String fPath, String sPath) {
        $(By.xpath(documentInformationAboutActsInput)).uploadFile(new File(fPath));
        $(By.xpath(signatureInformationAboutActsInput)).uploadFile(new File(sPath));
    }

    /**
     * Заполнение поля Номер акта КНМ
     *
     * @param numberAct Номер акта КНМ
     */
    @Step("Заполнение поля Номер акта КНМ")
    public void setNumberActField(String numberAct) {
        $(By.xpath(numberActField)).setValue(numberAct);
    }

    /**
     * Заполнение поля Дата и время составления акта КНМ
     *
     * @param date Дата и время составления акта КНМ
     */
    @Step("Заполнение поля Дата и время составления акта КНМ")
    public void setDateDrawingUpAct(String date) {
        $(By.xpath(dateDrawingUpAct)).setValue(date);
    }

    /**
     * Заполнение поля Дата и время начала проведения КНМ
     *
     * @param date Дата и время начала проведения КНМ
     */
    @Step("Заполнение поля Дата и время начала проведения КНМ")
    public void setDateStartKNM(String date) {
        $(By.xpath(dateStartKNM)).setValue(date);
    }

    /**
     * Заполнение поля Срок проведения (в днях)
     *
     * @param day Срок проведения (в днях)
     */
    @Step("Заполнение поля Срок проведения (в днях)")
    public void setDurationDaysActField(String day) {
        $(By.xpath(durationDaysActField)).setValue(day);
    }

    /**
     * Заполнение поля ФИО подписавшего акт
     *
     * @param name ФИО подписавшего акт
     */
    @Step("Заполнение поля ФИО подписавшего акт")
    public void setNameSignatoryActField(String name) {
        $(By.xpath(nameSignatoryActField)).setValue(name);
    }

    /**
     * Выбор Должность лица, подписавшего акт из выпадающего списка
     *
     * @param signPosition Должность лица, подписавшего акт
     */
    @Step("Выбор Должность лица, подписавшего акт из выпадающего списка")
    public void setPositionSignatoryActDropDown(String signPosition) {
        $(By.xpath(positionSignatoryActDropDown)).click();
        clickToText(signPosition);
    }

    /**
     * Нажатие на кнопку Добавить в блоке Должностные лица КНО, участвовавшие в КНМ
     */
    @Step("Нажатие на кнопку Добавить в блоке Должностные лица КНО, участвовавшие в КНМ")
    public void clickAddOfficialsParticipatedButton() {
        $(By.xpath(addOfficialsParticipatedButton)).click();
    }

    /**
     * Заполнение поля Введите ФИО в блоке Должностные лица КНО, участвовавшие в КНМ
     *
     * @param name ФИО
     */
    @Step("Заполнение поля Введите ФИО в блоке Должностные лица КНО, участвовавшие в КНМ")
    public void setOfficialsParticipatedEventField(String name) {
        $(By.xpath(officialsParticipatedEventField)).setValue(name);
    }

    /**
     * Выбор Выберете должность в блоке Должностные лица КНО, участвовавшие в КНМ - Специалист-эксперт отдела Территориального органа Росздравнадзора
     */
    @Step("Выбор Выберете должность в блоке Должностные лица КНО, участвовавшие в КНМ - Специалист-эксперт отдела Территориального органа Росздравнадзора")
    public void setPositionOfficialsTerritorialAuthorityParticipatedDropDown() {
        $(By.xpath(positionOfficialsParticipatedDropDown)).click();
        clickToText(positionSpecialistExpert);
    }

    /**
     * Заполнение поля Факт устранения выявленного нарушения
     *
     * @param fact Факт устранения выявленного нарушения
     */
    @Step("Заполнение поля Факт устранения выявленного нарушения")
    public void setFactField(String fact) {
        $(By.xpath(factField)).setValue(fact);
    }

    /**
     * Выбор результата из выпадающего списка Сведения об ознакомлении контролируемых лиц с результатами КНМ
     *
     * @param result Результат
     */
    @Step("Выбор результата из выпадающего списка Сведения об ознакомлении контролируемых лиц с результатами КНМ")
    public void setInformationAboutRecognitionDropDown(String result) {
        $(By.xpath(informationAboutRecognitionDropDown)).click();
        clickToText(result);
    }

    /**
     * Заполнение поля Кто ознакомлен
     *
     * @param whoFamiliar Кто ознакомлен
     */
    @Step("Заполнение поля Кто ознакомлен")
    public void setWhoFamiliarWithField(String whoFamiliar) {
        $(By.xpath(whoFamiliarWithField)).setValue(whoFamiliar);
    }

    /**
     * Заполнение поля Должность
     *
     * @param position Должность
     */
    @Step("Заполнение поля Должность")
    public void setPositionFamiliarWithField(String position) {
        $(By.xpath(positionFamiliarWithField)).setValue(position);
    }

    /**
     * Заполнение блока сведения об акте
     * @param fPath
     * @param sPath
     * @param numberAct
     * @param date
     * @param startDate
     * @param day
     * @param name
     * @param nameOfficials
     * @param fact
     * @param result
     * @param who
     * @param position
     */
    @Step("Заполнение блока сведения об акте")
    public void addInformationAboutAct(String fPath, String sPath, String numberAct, String date, String startDate, String day, String name, String nameOfficials, String fact, String result, String who, String position) {
        clickAddInformationAboutActsButton();
        clickAddFileActButton();
        addDocumentAndSignatureFileAct(fPath, sPath);
        clickUploadButton();
        setNumberActField(numberAct);
        setDateDrawingUpAct(date);
        setDateStartKNM(startDate);
        setDurationDaysActField(day);
        setNameSignatoryActField(name);
        setPositionSignatoryActDropDown(position);
        clickAddOfficialsParticipatedButton();
        setOfficialsParticipatedEventField(nameOfficials);
        setPositionOfficialsTerritorialAuthorityParticipatedDropDown();
        setFactField(fact);
        setInformationAboutRecognitionDropDown(result);
        setWhoFamiliarWithField(who);
        setPositionFamiliarWithField(position);
        closeNotification();
    }

    /**
     * Добавление информации в раздел Сведения о должностных лицах, участвующих в КНМ
     * @param fio ФИО
     */
    @Step("Добавление информации в раздел Сведения о должностных лицах, участвующих в КНМ")
    public void addInformationAboutOfficialsParticipatingInTheKNM(String fio) {
        $(By.xpath(addInformationAboutOfficialsParticipatingButton)).click();
        $(By.xpath(addFIOParticipatingField)).setValue(fio);
        $(By.xpath(addPositionParticipatingDropDown)).click();
        clickToText(positionSpecialistExpert);
    }

    /**
     * Добавление проверочного листа в КНМ
     *
     * @param name Наименование проверочного листа
     */
    @Step("Добавление проверочного листа в КНМ")
    public void addCheckList(String name) {
        $(By.xpath(checklistCheckbox)).click(); //выбор чек-бокса
        $(By.xpath(addChecklistButton)).click(); //нажать кнопку Добавить у блока Проверочные листы
        $(By.xpath(nameChecklistDropDown)).click(); //нажатие на выпадающий список Наименование проверочного листа
        clickToText(addNewSampleButton);
        $(By.xpath(nameChecklistField)).setValue(name);
    }

    /**
     * Поиск должностного лица в карточке КНМ
     *
     * @param text ФИО должностного лица
     */
    @Step("Поиск должностного лица в карточке КНМ")
    public void checkOfficialsParticipatingInTheKNM(String text) {
        $(By.xpath(addFIOParticipatingField)).should(Value.value(text));
    }

    /**
     * Проверка на существование Наименования ОТ в карточке КНМ
     *
     * @param name Наименование ОТ
     */
    @Step("Проверка на существование Наименования ОТ в карточке КНМ - {name}")
    public void checkNameMandatoryRequirementsField(String name) {
        $(By.xpath(createdNameMandatoryRequirementsField)).should(Text.text(name));
    }

    /**
     * Проверка на существование проверочного листа в КНМ
     *
     * @param name Наименование проверочного листа
     */
    @Step("Проверка на существование проверочного листа в КНМ")
    public void checkCheckList(String name) {
        $(By.xpath("//li[contains(@id, 'checklists')][1]")).click();
        $(By.xpath("//li[contains(@id, 'checklists')][1]//div[contains(@class, 'SelectInput_SingleValue')]")).should(Text.text(name));
    }

    /**
     * Создание ОТ
     */
    @Step("Создание ОТ")
    public void createTemplateMandatoryRequirements() {
        createMandatoryRequirements(nameTitle, nameTitle, currentDate);
        clickSaveButton();
        closeNotification();
        checkNameMandatoryRequirementsField(nameTitle);
    }

    /**
     * Перевод проверки из статуса В процессе заполнения в статус Готово к согласованию
     *
     * @param dateTimePublication Дата и время издания решения
     * @param startDate           Дата начала действий, осуществляемый в рамках КНМ
     * @param stopDate            Дата окончания действий, осуществляемый в рамках КНМ
     */
    @Step("Перевод проверки из статуса В процессе заполнения в статус Готово к согласованию")
    public void transferEventStatusReadyApproval(String dateTimePublication, String startDate, String stopDate) {
        setDateTimePublicationDecisionField(dateTimePublication);
        setSolutionNumberField(prefix);
        setPlaceDecisionField(placeDecision);
        setNameOfficialField(officialField);
        setPositionPersonSignedDecisionsDropDown();
        setDurationDaysField("1");
        addGroundsConductingUnscheduled(filePath, signPath, needCoordination);
        addListActions(startDate, stopDate);
        clickAddVenueButton();
        setVenueField(placeDecision);
        closeNotification();
        clickSaveButton();
        closeNotification();
        checkStatusKNM(statusReadyApproval);
        clickActionsOnCardButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        closeNotification();
        closeNotification();
        checkSuccessfullySignNotification();
        closeNotification();
    }

    /**
     * Перевод проверки из статуса Готово к согласованию в статус На согласование
     */
    @Step("Перевод проверки из статуса Готово к согласованию в статус На согласование")
    public void transferEventStatusOnApproval() {
        clickActionsOnCardButton();
        clickForApprovalButton();
        checkStatusKNM(statusOnApproval);
        closeNotification();
    }

    /**
     * Перевод проверки из статуса На согласованию в статус Ожидает завершения, Ожидает проведения, Не согласована
     * (в зависимости от даты начала КНМ)
     *
     * @param checkStatus    В какой статус должна перейти проверка: В процессе завершения,
     *                       Ожидает проведения, Не согласована
     * @param statusDecision Решение по заявлению: Согласовано или Отклонено
     */
    @Step("Перевод проверки из статуса На согласованию в статус Ожидает завершения, Ожидает проведения, Не согласована")
    public void transferEventStatusAgreed(String statusDecision, String checkStatus) {
        setDecisionApplicationDropDown(statusDecision);
        clickSaveButton();
        checkStatusKNM(checkStatus);
        closeNotification();
    }

    /**
     * Перевод КНМ из статуса Ожидает завершения в статус Завершено
     */
    @Step("Перевод КНМ из статуса Ожидает завершения в статус Завершено")
    public void transferEventStatusWaitCompleted() {
        addInformationAboutAct(filePath, signPath, number, currentDate, currentDate, number, officialField,
                officialField, "Факт устранения", familiarWith, officialField, positionDirectorTerritorialAuthority);
        clickSaveButton();
        checkStatusKNM(statusCompleted);
    }
}
