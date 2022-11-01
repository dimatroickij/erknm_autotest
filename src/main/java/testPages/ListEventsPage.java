package testPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.conditions.Value;
import io.netty.util.Timeout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ListEventsPage extends Common {
//раздел Список КНМ

    public String buttonExit = "//div[contains(@class,'HeaderContent')]/a";  // иконка выхода назад
    public String placeDecision = prefix + " автотестМесто"; // Значение для поля Место вынесения решения или похожих полей
    public String nameTitle = prefix + "авто"; // Значение для поля Наименование в блоке ОТ
    public String officialField = prefix + " autoFIO"; // Значение для поля ФИО должностного лица
    String statusKNM = "//div[contains(@class,\"TitleBlock\")]/span[contains(@class, 'Status')]"; // Статус КНМ
    String statusPublication = "//div[contains(@class,\"PublishedStatus\")]/span[contains(@class, 'Status')]"; // Статус публикации
    public String nameKNODropDown = "//*[@id='knoOrganizationErknm']"; // Выпадающий список Наименование органа контроля
    public String nameKNOFiledText = "//*[@id='knoOrganizationErknm']//div[contains(@class,'SingleValue')]"; // Текст в поле Наименование органа контроля
    public String kindControlAndNumberDropDown = "//*[@id='kindControl']"; // Выпадающий список Вид контроля (надзора) и его номер

    String kindKNMDropDown = "//*[@id='kindKnm']"; // Выпадающий список Вид КНМ
    String kindKnmDropDownText = "//*[@id='kindKnm']//div[contains(@class,'SingleValue')]"; // текст в поле Вид КНМ
    public String characterKNMDropDown = "//*[@id='typeErknm']"; // Выпадающий список Характер КНМ
    public String characterKNMFieldText = "//*[@id='typeErknm']//div[contains(@class,'SingleValue')]"; // Текст в поле Характер КНМ
    String startKNMDate = "//*[@id='startDateBlock']//input"; // Дата начала КНМ
    public String stopKNMDate = "//div[@id='stopDateBlock']//input"; // Дата окончания КНМ
    public String nameInputStopKNMDate = "Дата окончания КНМ"; // Название поля Дата окончания КНМ
    public String errorStopKNMDate = "//div[contains(@class,'DatePickerError')]"; // Текст ошибки под полем Дата окончания КНМ
    public String interactionTimeDays = "//div[@id='directDurationDaysBlock']//input"; // Срок непосредственного взаимодействия дней
    public String errorInteractionTimeDays = "//div[@id='directDurationDaysBlock']//div[contains(@class,'TextInputError')]"; // Текст ошибки под полем Срок непосредственного взаимодействия дней
    public String interactionTimeHours = "//div[@id='durationHoursBlock']//input"; // Срок непосредственного взаимодействия часов
    public String errorInteractionTimeHours = "//div[@id='durationHoursBlock']//div[contains(@class,'TextInputError')]"; // Текст ошибки под полем Срок непосредственного взаимодействия часов

    String nameProsecutorDropDown = "//*[@id='prosecutorOrganizationErknm']"; // Наименование прокуратуры
    public String nameProsecutorFieldText = "//*[@id='prosecutorOrganizationErknm']//div[contains(@class,'SingleValue')]"; // текст в поле Наименование прокуратуры
    String innField = "//*[@name='organizations[0].inn']"; // ИНН
    String innListField = "//*[@id='autoCompleteList']/li"; // Появившийся список ИНН

    String numberPlanField = "//*[@id='planId']"; // Номер плана
    public String durationDaysField = "//*[@name='durationDays']"; // Срок проведения(дней)
    public String nameInputDurationDaysField = "Срок проведения (дней)"; // Название поля Срок проведения (дней)
    public String clearDurationDays = "//div[@id=\"durationDaysBlock\"]//button"; // Иконка [X] удаления данных из поля Срок проведения(дней)
    public String textUnderDurationDaysField = "//div[contains(@class,'CanBeChangedInNonWorkDaysMessage')]"; // Текс под полем Срок проведения (дней)
    String addGroundsIncludePlanButton = "//*[@id='addReasonButton']"; // Кнопка добавить в раздел Основания включения в план
    String groundsIncludePlanDropDown = "//*[@id='reasonsErknm[0].type']"; // Основания включения в план
    String deleteGroundRegistrationButton = "//div[@id=\"reasonsBlock\"]//button[contains(@class,'Close')]"; // иконка [X] удаления основания регистрации КНМ
    public String orderNumberInput = "//*[@id=\"reasonsErknm[0].assignmentNumber\"]"; // Поле Номер поручения в блоке Основания проведения КНМ
    public String textUnderOrderNumberInput = "//div[contains(@class,\"TextareaError\")]"; // Текст под полем Номер поручения в блоке Основания проведения КНМ
    public String orderDateInput = "//div[@id=\"reasonsBlock\"]//input[contains(@class, 'Input')]"; // Поле Дата поручения в блоке Основания проведения КНМ
    public String textUnderOrderDateInput = "//div[contains(@class,\"DatePickerError\")]"; // Текст под полем Дата поручения в блоке Основания проведения КНМ
    public String detailsRequirementInput = "//*[@id=\"reasonsErknm[0].requirementDetails\"]"; // Поле Реквизиты требования в блоке Основания проведения КНМ
    public String groundsRegistrationInput = "//*[@id=\"reasonsErknm[0].text\"]"; // Поле Иные основания регистрации КНМ
    public String textUnderDetailsRequirement = "//div[contains(@class,'TextareaError')]"; // Текст под полем Реквизиты требования в блоке Основания проведения КНМ
    String GIP = "4.0.1 (ФЗ 248) Истечение установленного федеральным законом о виде контроля, положением о виде " +
            "контроля период времени с даты окончания проведения последнего планового контрольного (надзорного) " +
            "мероприятия"; // Основание включения в план
    String causeLackOfDocuments = "(248-ФЗ) Отсутствие документов, прилагаемых к заявлению о согласовании проведения внепланового" +
            " контрольного (надзорного) мероприятия";
    String dateGIPField = "//*[@id='reasonsBlock']//div[contains(@class, 'ErknmReasons_ReasonDateFieldWrapper')]//input"; // Дата основания включения в план TODO Должен быть идентификатор

    String addObjectControlKNMButton = "//*[@id='erknmObjectsAddButton']"; // Кнопка Добавить в разделе Сведения об объектах контроля в карточке КНМ
    String addressField = "//*[@name='objectsErknm[0].addressText']"; // Поле Местонахождение
    String typeObjectDropDown = "//*[@id='objectsErknm[0].objectType']"; // Тип объекта
    String typeObject = "Деятельность и действия";
    String kindObjectDropDown = "//*[@id='objectsErknm[0].objectKind']"; // Вид объекта
    String subkindObjectDropDown = "//*[@id='objectsErknm[0].objectSubKind']"; // Подвид объекта
    String dangerClassDropDown = "//*[@id='objectsErknm[0].dangerClass']"; // Класс опасности
    String deleteObjectButton = "//div[@id=\"objects-info\"]//button[contains(@class,\"DeleteButton\")]"; // Иконка [X] удаления объекта
    String dangerClass = "Первый"; // Класс опасности для заполнения dangerClassDropDown

    String addListActionsButton = "//*[@id='erknmEventsAddButton']"; // Кнопка Добавить в разделе Перечень действий
    String typeActionsDropDown = "//*[@id='eventsErknm[0].type']"; // Выберите тип действия
    String typeActions = "Истребование документов";
    String dateStartActions = "//*[@id='checklist-info']//div[contains(@class, 'Row_kfkhv')]/div[2]//input"; // Дата начала TODO Должен быть идентификатор
    String dateEndActions = "//*[@id='checklist-info']//div[contains(@class, 'Row_kfkhv')]/div[3]//input"; // Дата окончания TODO Должен быть идентификатор

    String addVenueButton = "//*[@id ='erknmPlacesAddButton']"; // Кнопка добавить в разделе Место (места) проведение КНМ
    String venueField = "//*[@name='places[0].value']"; // поле для введения Места


    String dateTimePublicationDecisionField = "//section[@id='info']//div[contains(@class, 'Row_kfkhv')][6]/div[1]//input"; // Поле Дата и время издания решения в разделе о проведении КНМ TODO Должен быть идентификатор
    String solutionNumberField = "//*[@id='numberDecision']"; // Поле Номер решения в разделе Решение о проведении КНМ
    String placeDecisionField = "//*[@id='placeDecision']"; // Поле Место вынесения решения
    String nameOfficialField = "//*[@id='fioSigner']"; // Поле ФИО должностного лица
    String positionPersonSignedDecisionsDropDown = "//*[@id='titleSigner']"; // Поле Должность лица, подписавшего решение
    String durationEventHoursField = "//*[@name='durationHours']"; // поле срок проведения (часов)
    String addGroundConductingButton = "//*[@id ='addReasonButton']"; // кнопка Добавить в разделе Основания проведения КНМ
    String groundConductingDropDown = "//*[@id ='reasonsErknm[0].type']"; // выпадающий список Основание регистрации КНМ
    String groundConduction = "4.0.15 (Постановление 336) Непосредственная угроза причинения вреда жизни и тяжкого " +
            "вреда здоровью граждан, факты причинения вреда жизни и тяжкого вреда здоровью граждан";
    String needCoordinationDropDown = "//*[@id='approveRequired']/div/div[1]"; // выпадающий список Необходимость согласования
    String addFoundationButton = "//div[@id=\"reasonDocumentsBlock\"]//button"; // кнопка Добавить основание при необходимости согласования КНМ
    String typeDocumentDropDown = "//*[@id='reasonDocuments[0].type']"; // выпадающий список Тип документа
    String typeDocument = "Мотивированное представление о проведении контрольного (надзорного)";
    String addFileButton = "//*[@id='reasonDocumentsBlock']/div[2]//button"; // кнопка Добавить у блока Файл TODO Должен быть идентификатор

    String addMandatoryRequirementsButton = "//button[@id=\"erknmRequirementsNpaAddButton\"]"; // кнопка Добавить в блоке обязательные требования, подлежащие проверке
    String mandatoryRequirementsDropDown = "//*[@id='requirementsErknm[0].requirement']"; // выпадающий список Обязательные требования
    String addNewSampleButton = "Создать новый"; // создать новый шаблон TODO Должен быть идентификатор
    String nameMandatoryRequirementsField = "//*[@id='requirementsErknm[0].manualTitle']"; // поле Наименование в блоке ОТ
    String createdNameMandatoryRequirementsField = "//*[@id='requirementsErknm[0].requirement']"; //поле Наименование в блоке ОТ после сохранения
    String npaMandatoryRequirementsField = "//*[@id='requirementsErknm[0].manualNameNpa']"; // поле Наименование НПА в блоке ОТ
    String dateNPAMandatoryRequirementsField = "//tr[contains(@id, 'requirements')]//td[contains(@class, 'DateNpaTbodyCell')]//input"; // поле Дата НПА TODO Должен быть идентификатор
    String addGroundsButton = "//div[@id=\"reasonDocumentsBlock\"]//button"; // кнопка Добавить в разделе Основания проведения КНМ
    String addFileInGroundsButton = "//div[contains(@id,\"reasonDocuments\")]/button"; // Кнопка Добавить файл в разделе Основания проведения КНМ
    String selectDocType = "//div[@id=\"reasonDocuments[0].type\"]"; // Поле Выбора типа документа в разделе Основания проведения КНМ
    String documentType = "//div[@id=\"reasonDocumentsBlock\"]//div[contains(@class, 'SelectInput')][1]"; // первый из списка тип документа
    String documentGroundsConductingInput = "//input[@id='reasonDocuments[0].attachmentsUploadDocument']"; // input для добавления документа в блоке Основания проведения КНМ
    String signatureGroundsConductingInput = "//input[@id='reasonDocuments[0].attachmentsUploadSign']"; // input для добавления подписи в блоке Основания проведения КНМ
    String uploadFileButton = "//button[@id=\"uploadButton\"]"; // кнопка Загрузить в блоке загрузки документов

    String approvalButton = "//button[text()='На согласование']"; // кнопка в подменю На согласование

    // Сведения о согласовании проведения КНМ с органами прокуратуры
    String decisionApplicationDropDown = "//*[@id='approved']"; // Выпадающий список Решение по заявлению
    String inputDecisionNumber = "//input[@id=\"approveNumberDecision\"]"; // поле Номер решения
    String inputDecisionDate = "//*[@id=\"approve-info\"]//div[contains(@class,\"react-datepicker-wrapper\")]//input"; // поле Дата решения
    String inputDecisionSubject = "//*[@id=\"approveFioSigner\"]"; // поле Кем принято решение
    String inputPosition = "//*[@id=\"approveTitleSigner\"]"; // поле Должность лица, подписавшего решения
    String selectRejectionReason = "//div[@id=\"rejectReasonType\"]"; // выпадающий список Причина отказа
    String inputRejectReasonNote = "//textarea[@id=\"rejectReasonNote\"]"; // поле Мотивировка отказа
    String inputRejectionDate = "//*[@id=\"approve-info\"]/div[contains(@class,'_Row_')][6]//input[contains(@class,'_Input_')]"; // поле Дата отказа

    // Блок Сведения о контролируемом лице
    String addButtonInInformationControlledPerson = "//*[@id=\"verified-person\"]//*[@class=\"shared-no-wrap-text\"]/button"; // кнопка Добавить в разделе Сведения о контролируемом лице
    String typesControlledPersons = "//div[@id=\"organizations[0].subjectType\"]"; // выпадающий список Тип контролируемых лиц

    // Информация об уведомлении проверяемого лица о проведении КНМ
    String inputNoticeDate = "//*[@id=\"noticeDateBlock\"]//input[contains(@class,'_Input')]"; // поле Дата уведомления
    String inputNotificationMethod = "//*[@id=\"noticeDateBlock\"]//input[contains(@id,'react-select')]"; // поле Способ уведомления

    //Блок Сведения об акте
    String addInformationAboutActsButton = "//*[@id='act']//button"; // Кнопка Добавить в блоке Сведения об акте TODO Должен быть идентификатор
    String selectTypeOfAct = "//*[@id='act']//input[contains(@id,'react-select')]"; // поле Вид акта
    String selectReasonForImpossibility = "//*[@id='react-select-28-input']"; // поле Причина невозможности проведения
    String addFileActButton = "//*[@id='act']//div[contains(@class, 'ErknmActDocument_ActDocument')]//button"; //Кнопка добавить Файл акта TODO Должен быть идентификатор
    String documentInformationAboutActsInput = "//input[@id='acts[0].document.attachmentsUploadDocument']"; // input для добавления документа в блоке Файл акта
    String signatureInformationAboutActsInput = "//input[@id='acts[0].document.attachmentsUploadSign']"; // input для добавления подписи в блоке Файл акта
    String numberActField = "//*[@name='acts[0].numberAct']"; // поле Номер акта КНМ
    String dateDrawingUpAct = "//*[contains(@id, 'acts[')][1]/div[2]/div[3]//input"; // поле Дата и время составления акта КНМ TODO Должен быть идентификатор
    String dateStartKNM = "//*[contains(@id, 'acts[')][1]/div[2]/div[4]//input"; // поле Дата и время начала проведения КНМ TODO Должен быть идентификатор
    String durationDaysActField = "//*[@name='acts[0].durationDays']"; // поле Срок проведения (в днях)
    String nameSignatoryActField = "//*[@name='acts[0].fioSigner']"; // поле ФИО подписавшего акт
    String positionSignatoryActDropDown = "//*[contains(@id, 'acts[')][1]/div[2]/div[6]//div[contains(@class, 'SelectInput_SelectInput')]"; // Выпадающий список Должность лица, подписавшего акт TODO Должен быть идентификатор
    String addOfficialsParticipatedButton = "//*[contains(@id, ']].knoInspectors')]//button[1]"; // Кнопка Добавить в блоке Должностные лица КНО, участвовавшие в КНМ TODO Должен быть идентификатор
    String officialsParticipatedEventField = "//*[@name='acts[0].knoInspectors[0].fullName']"; // поле Введите ФИО в блоке Должностные лица КНО, участвовавшие в КНМ
    String positionOfficialsParticipatedDropDown = "//*[contains(@id, ']].knoInspectors')]//div[contains(@class, 'SelectInput_SelectInput')]"; // выпадающий список Выберите должность в блоке Должностные лица КНО, участвовавшие в КНМ TODO Должен быть идентификатор
    String factField = "//*[@name='acts[0].isViolationResolvedNote']";//Факт устранения выявленного нарушения
    String informationAboutRecognitionDropDown = "//*[contains(@id, 'acts[')][1]/div[2]/div[12]//div[contains(@class, 'SelectInput_SelectInput')]"; // выпадающий список Сведения об ознакомлении контролируемых лиц с результатами КНМ TODO Должен быть идентификатор
    String whoFamiliarWithField = "//*[@name='acts[0].fioReader']"; // поле Кто ознакомлен
    String positionFamiliarWithField = "//*[@name='acts[0].titleReader']"; // поле Должность

    String addInformationAboutOfficialsParticipatingButton = "//*[@id ='erknmInspectorsAddButton']"; // кнопка Добавить в разделе Сведения о должностных лицах, участвующих в КНМ
    String addFIOParticipatingField = "//*[@name='inspectorsErknm[0].fullName']"; // поле Введите ФИО должностного лица
    String addPositionParticipatingDropDown = "//*[@id='inspectorsErknm[0].position']"; // выпадающий список Выберите должность

    String checklistCheckbox = "//*[@id='isChecklistsUsed']"; // чек-бокс Отметка об использовании проверочного листа
    String addChecklistButton = "//*[@id='event-subject']/div[6]//button"; // Добавить проверочный лист TODO Должен быть идентификатор
    String nameChecklistDropDown = "//*[contains(@id, 'checklists')]//div[contains(@class, 'SelectInput_SelectInput')]"; // Выпадающий список Наименование проверочного листа TODO Должен быть идентификатор
    String nameChecklistField = "//*[@name='checklistsErknm[0].newTitle']"; // поле для ввода наименования нового проверочного листа
    String actionButtonInKNM = "//div[@class=\"_Container_1hdsc_1 _Buttons_5dm4o_89\"]//*[@id=\"visibleChangeActionsButton\"]"; // Кнопка Действие

    String excludeKNMFromPlanButton = "//*[text()='Исключить из плана']"; // кнопка Исключить из плана TODO Должен быть идентификатор
    String exclusionGroundDropDown = "//div[contains(@class, 'ModalBody')]//div[contains(@class, '_ValueContainer_nx4nv_75')]"; // выпадающий список Основание исключение TODO Должен быть идентификатор
    String docInput = "//input[@id='document']"; // выбор документа
    String exclusionButton = "//div[contains(@class, '_Container_1yq2a_1')]//button[1]"; //кнопка Исключить на форме Исключение КНМ из плана TODO Должен быть идентификатор
    public String completePPButton = "//div[contains(@class,\"HeaderContent\")]//button[@id=\"complete336Button\"]"; // кнопка Завершить 336
    String buttonNotForModalCompletePP = "//div[@id=\"modal\"]//button[2]"; // кнопка Нет в модальном окне завершения по 336
    String buttonYesForModalCompletePP = "//div[@id=\"modal\"]//button[1]"; // Кнопка Да в модальном окне завершения по 336
    public String textModalForCompletePP = "//div[contains(@class,\"BodyText\")]//p"; // текст в модальном окне после Завершить 336

    // Блок обязательные требования, подлежащие проверке
    public String buttonAddForRequirements = "//button[@id=\"erknmRequirementsNpaAddButton\"]"; // кнопка Добавить в разделе Обязательные требования подлежащие проверке
    public String requirementsNPA = "//div[@id=\"requirementsNpa\"]//span[contains(@class, \"OpenButtonBody\")]"; // НПА в обязательных требованиях подлежащих проверке
    public String contentOfRequirements = "//div[contains(@class, 'BodyIsActive')]//div[contains(@class, 'MandatoryBlockBody')]"; // Текст содержания требования
    String inputNameNPA = "//input[@id=\"npaSearchString\"]"; // поле наименование НПА в форме добавления обязательного требования
    String buttonSearchNPA = "//div[contains(@class,'ModalBody')]//button"; // кнопка Искать в форме добавления обязательного требования
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
    String buttonAddSE = "//div[contains(@class,'_ModalBody')]/div[contains(@class,'Row')][3]//button"; // кнопка Добавить в блоке Структурные единицы
    String selectInitField = "//div[contains(@class,'NewStructuralUnitItem')]//div[contains(@class,'_SelectInputSizeLarge')]"; // поле выбора типа Структурной единицы
    String inputValueSE = "//*[contains(@name,'newStructuralUnits[0].components[0].v')]"; // поле Значение СЕ
    String buttonSaveNewNPA = "//div[contains(@class,'_ModalActionsWithBack')]/div/button[1]"; // кнопка Сохранить при создании НПА
    String buttonCancelNewNPA = "//div[contains(@class,'_ModalActionsWithBack')]/div/button[2]"; // кнопка Отмена при создании НПА
    String messageErrorForValidationCreateNPA = "//div[@id='modal']//div[contains(@class,'ClosingNotificationText')]"; // сообщение об ошибке при попытке создать одинаковый НПА
    String iconEditNPA = "//div[contains(@class,'NpaNameBlock')]/button"; // иконка редактирования НПА
    public String numberNPAInTableSearchResults = "//div[contains(@class,'TableContent')]/div[1]"; // номер НПА в таблице найденных

    // Фильтрация КНМ
    String filtersButton = "//div[@class=\"_Filters_1uab2_15\"]/button"; // Кнопка фильтры
    String savedFilter = "//button[contains(text(), 'автотест')]"; // сохраненный фильтр
    String territorialUnit = "//div[@id=\"domains\"]"; // Выпадающий список Территориальная единица
    String checkboxTerritorialUnit = "//input[@id=\"includeDomainChild\"]"; // Чекбокс под полем Территориальная единица
    String characterKNMField = "//div[@id=\"knmTypes\"]//div[contains(@class, 'Indicators')]"; // поле Характер КНМ в блоке фильтров
    String deleteCharacterKNMValue = "//div[@id=\"knmTypes\"]//div[contains(@class, 'MultiValueRemove')]"; // иконка [X] удаления значения характера КНМ
    String nameKNODropDownFiltrationBlock = "//div[@id=\"controllingOrganizations\"]"; // Выпадающий список Наименование органа контроля (надзора) в блоке фильтров
    String deleteNameKNO = "//div[@id=\"kinds\"]//div[contains(@class, 'MultiValueRemove')]"; // иконка [X] удаления КНО
    String addButtonFilters = "//div[contains(@class,\"_FilterPanelBody\")]//button[contains(@class,'ButtonPrimar')]"; // кнопка Добавить в блоке фильтров
    String inputSearchFilters = "//input[@id=\"select-table-search-value\"]"; // Поле поиска дополнительных параметров фильтрации
    String parameterFilter = "//div[@class=\"_Field_19ems_106\"]"; // Параметр фильтрации из списка
    String buttonUpdateNewFilters = "//div[@class=\"_FilterFooterButtons_1ifag_24\"]//button[1]"; // Кнопка применить при добавлении фильтров поиска
    String deleteButtonAdditionalFilter = "//button[@class=\"_Close_onqbf_1\"]"; // Иконка [X] удаления поля дополнительного фильтра
    String buttonUpdateFilters = "//div[@class=\"_FilterFooter_bspy4_46\"]//button[1]"; // Кнопка Применить в блоке фильтров
    String statusKNMFieldFilter = "//div[@id='statuses']"; // поле Статус КНМ в дополнительных фильтрах

    // Дополнительные фильтры
    public String requirementDetailsFilterInput = "//input[@name=\"requirementDetails\"]"; // Поле Реквизиты требования в дополнительных фильтрах
    public String orderDateFilterInput = "//div[@class=\"react-datepicker__input-container\"]//input"; // Поле Дата поручения в дополнительных фильтрах
    public String orderDateStartIntervalInput = "//div[contains(@class,\"FilterFormDateGroup\")]/div[1]//input"; // поле Дата начала периода в дополнительном фильтре Дата поручения по периоду
    public String orderDateStopIntervalInput = "//div[contains(@class,\"FilterFormDateGroup\")]/div[2]//input"; // поле Дата окончания периода в дополнительном фильтре Дата поручения по периоду
    public String orderNumberFilterInput = "//input[@name=\"assignmentNumber\"]"; // Поле Номер поручения в дополнительных фильтрах

    public String numberKNMInList = "//tr[contains(@class,\"TBodyRow\")]//td[2]/a"; // Номер КНМ в таблице Список КНМ

    // Боковое меню навигации
    public String linkInfoHistoryOfChanges = "//li[@id=\"#knm-history\"]/a"; // ссылка в боковом меню навигации История изменений
    String buttonOpenHistoryOfChanges = "//*[@id=\"knm-history\"]//button[contains(@class,'OpenButton')]"; // поле/кнопка История изменения
    public String buttonSubjectOfVerification = " //li[@id=\"#event-subject\"]/a"; // поле/кнопка Предмет КНМ


    public ListEventsPage() throws Exception {
    }

    /**
     * Выйти из КНМ
     */
    @Step("Выйти из КНМ")
    public void exitFromEvent() {
        $(By.xpath(buttonExit)).click();
    }

    /**
     * Нажать на кнопку Завершить ПП 336
     */
    @Step("Нажать на кнопку Завершить ПП 336")
    public void clickButtonCompletePP() {
        $(By.xpath(completePPButton)).click();
    }

    /**
     * Нажать на кнопку Да в модальном окне при Завершить ПП 336
     */
    @Step("Нажать на кнопку Да в модальном окне при Завершить ПП 336")
    public void clickYesButtonForModalCompletePP() {
        $(By.xpath(buttonYesForModalCompletePP)).click();
    }

    /**
     * Нажать на кнопку Нет в модальном окне при Завершить ПП 336
     */
    @Step("Нажать на кнопку Нет в модальном окне при Завершить ПП 336")
    public void clickNotButtonForModalCompletePP() {
        $(By.xpath(buttonNotForModalCompletePP)).click();
    }

    /**
     * Проверка статуса КНМ
     *
     * @param status Статус, который должен быть у проверки
     */
    @Step("Проверка статуса КНМ - {status}")
    public void checkStatusKNM(String status) {
        $(By.xpath(statusKNM)).should(Text.text(status));
    }

    /**
     * Проверка статуса Публикации
     *
     * @param status Статус, который должен быть у проверки
     */
    @Step("Проверка статуса Публикации - {status}")
    public void checkStatusPublication(String status) {
        $(By.xpath(statusPublication)).should(Text.text(status));
    }

    /**
     * Выбор из выпадающего списка Наименование органа контроля
     *
     * @param name Наименование органа контроля
     */
    @Step("Выбор из выпадающего списка Наименование органа контроля - {name}")
    public void setNameKNODropDown(String name) {
        if(name == null) {
            return;
        }
        $(By.xpath(nameKNODropDown)).click(); // клик на выпадающем списке Наименование органа контроля
        setValueDropDownToText(name); // клик на нужной организации
    }

    /**
     * Выбор из выпадающего списка Вид контроля
     *
     * @param kind Вид контроля
     */
    @Step("Выбор из выпадающего списка Вид контроля - {kind}")
    public void setKindControlAndNumberDropDown(String kind) {
        if (kind == null) {
            return;
        }
        $(By.xpath(kindControlAndNumberDropDown)).click(); // клик на выпадающем списке Вид контроля
        setValueDropDownToText(kind); // клик на нужном виде контроля
    }

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param kind Вид КНМ
     */
    @Step("Выбор из выпадающего списка Вид КНМ - {kind}")
    public void setKindKNMDropDown(String kind) {
        if (kind == null) {
            return;
        }
        $(By.xpath(kindKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        setValueDropDownToText(kind); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка Характер КНМ
     *
     * @param kind Характер КНМ
     */
    @Step("Выбор из выпадающего списка Характер КНМ - {kind}")
    public void setCharacterKNMDropDown(String kind) {
        if (kind == null) {
            $(By.xpath(characterKNMDropDown)).click();
            $(By.xpath("//div[@class='_Body_xki1m_23']")).click();
            return;
        }
        $(By.xpath(characterKNMDropDown)).click(); // клик на выпадающем списке Характер КНМ
        setValueDropDownToText(kind); // клик на нужном характере КНМ
    }

    /**
     * Проверка на отсутствие значений в выпадающем списке Характер КНМ
     *
     * @param listValue Список проверяемых значений
     */
    @Step("Проверка на отсутствие значений - {listValue} в выпадающем списке Характер КНМ")
    public void checkInVisibleListCharacterKNMDropDown(String[] listValue) {
        $(By.xpath(characterKNMDropDown)).click();
        for(String value : listValue){
            $(By.xpath(String.format(selectValueByText, value))).shouldNotBe(visible);
        }
        $(By.xpath(characterKNMDropDown)).click();
    }

    /**
     * Проверка на отсутствие значений в выпадающем списке Вид контроля (надзора) и его номер
     *
     * @param listValue Список проверяемых значений
     */
    @Step("Проверка на отсутствие значений - {listValue} в выпадающем списке Вид контроля (надзора) и его номер")
    public void checkInVisibleListKindOfControlDropDown(String[] listValue) {
        $(By.xpath(kindControlAndNumberDropDown)).scrollIntoView(false).click();
        for(String value : listValue){
            $(By.xpath(String.format(selectValueByText, value))).shouldNotBe(visible);
        }
        $(By.xpath(kindControlAndNumberDropDown)).scrollIntoView(false).click();
    }

    /**
     * Заполнение поля Дата начала КНМ
     *
     * @param date дата ДД.ММ.ГГГГ
     */
    @Step("Заполнение поля Дата начала КНМ - {date}")
    public void setStartKNMDate(String date) {
        try {
            if(date == null) {
                return;
            }
            $(By.xpath(startKNMDate)).setValue(date);
        } catch (Exception e) {
            System.out.println("Ошибка на шаге заполнения поля Дата начала КНМ");
        }

    }

    /**
     * Заполнение поля Дата окончания КНМ
     *
     * @param date дата ДД.ММ.ГГГГ
     */
    @Step("Заполнение поля Дата окончания КНМ - {date}")
    public void setStopKNMDate(String date) {
        try {
            if (date == null) {
                return;
            }
            $(By.xpath(stopKNMDate)).setValue(date);
        } catch (Exception e) {
            System.out.println("Ошибка на шаге заполнения поля Дата окончания КНМ");
        }
    }

    /**
     * Заполнение поля Срок непосредственного взаимодействия дней
     *
     * @param days колличество дней до 365
     */
    @Step("Заполнение поля Срок непосредственного взаимодействия дней - {days}")
    public void interactionTimeDays(String days) {
        try {
            if (days == null) {
                return;
            }
            $(By.xpath(interactionTimeDays)).setValue(days);
        } catch (Exception e) {
            System.out.println("Ошибка на шаге заполнения поля Срок непосредственного взаимодействия дней");
        }
    }

    /**
     * Заполнение поля Срок непосредственного взаимодействия часов
     *
     * @param hours колличество часов до 256
     */
    @Step("Заполнение поля Срок непосредственного взаимодействия часов - {hours}")
    public void interactionTimeHours(String hours) {
        try {
            if (hours == null) {
                return;
            }
            $(By.xpath(interactionTimeHours)).setValue(hours);
        } catch (Exception e) {
            System.out.println("Ошибка на шаге заполнения поля Срок непосредственного взаимодействия часов");
        }
    }

    /**
     * Редактирование полей сроков непосредственного взаимодействия
     *
     * @param value Вводимое значение
     */
    @Step("Редактирование полей сроков непосредственного взаимодействия")
    public void editInteractionTime(String value) {
        try {
            webdriver().object().findElement(By.xpath(interactionTimeDays)).clear();
            webdriver().object().findElement(By.xpath(interactionTimeDays)).sendKeys(value);
            //$(By.xpath(interactionTimeDays)).sendKeys(value);
        } catch (Exception e) {
            clearInput("Срок непосредственного взаимодействия (часов)", interactionTimeHours);
            interactionTimeHours(value);
        }
    }

    /**
     * Выбор из выпадающего списка Наименование прокуратуры
     *
     * @param name Наименование прокуратуры
     */
    @Step("Выбор из выпадающего списка Наименование прокуратуры - {name}")
    public void setNameProsecutorDropDown(String name) {
        if (name == null) {
            return;
        }
        $(By.xpath(nameProsecutorDropDown)).click(); // клик на выпадающем списке Наименование прокуратуры
        setValueDropDownToText(name); // клик на нужной прокуратуре
    }

    /**
     * Заполнить поле ИНН, выбрать из появившегося окна
     *
     * @param INN ИНН
     */
    @Step("Заполнить поле ИНН, выбрать из появившегося окна - {INN}")
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).shouldBe(visible, Duration.ofSeconds(10000)).click();
    }

    /**
     * Получение номера КНМ
     */
    @Step("Получение номера КНМ")
    public String getNumberKNM() throws InterruptedException {
        sleep(4000);
        String number = $(By.xpath(numberKNM)).shouldBe(visible, Duration.ofSeconds(15)).getText().split(" ")[1];
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
        try {
            $(By.xpath(durationDaysField)).setValue(days);
        } catch (Exception e) {
            System.out.println("Ошибка при заполнении поля Срок проведения дней");
        }
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
        $(By.xpath(addGroundsIncludePlanButton)).scrollIntoView(false).click();
    }

    /**
     * Выбор основания включения в план
     *
     * @param grounds Основание включения в план
     */
    @Step("Выбор основания включения в план - {grounds}")
    public void setGroundsIncludePlanDropDown(String grounds) {
        $(By.xpath(groundsIncludePlanDropDown)).click();
        setValueDropDownToText(grounds);
    }

    /**
     * Удалить основание регистрации КНМ
     */
    @Step("Удалить основание регистрации КНМ")
    public void deleteGroundsConductingKNM() {
        $(By.xpath(deleteGroundRegistrationButton)).scrollIntoView(false).click(); // клик на Х у основания регистрации КНМ
    }

    /**
     * Заполнение основания включения в план
     *
     * @param grounds Основание включения в план
     */
    @Step("Заполнение основания включения в план - {grounds}")
    public void addGroundsIncludePlan(String grounds) {
        clickAddGroundsIncludePlanButton();
        setGroundsIncludePlanDropDown(grounds);
        setDateGIPField(currentDate);
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
        setValueDropDownToText(typeObject);
    }

    /**
     * Выбор Вида объекта
     *
     * @param view Вид объекта
     */
    @Step("Выбор Вида объекта - {view}")
    public void setKindObjectDropDown(String view) {
        $(By.xpath(kindObjectDropDown)).click();
        setValueDropDownToText(view);
    }

    /**
     * Выбор Подвида объекта
     */
    @Step("Выбор Подвида объекта - {}")
    public void setSubkindObjectDropDown() {
        $(By.xpath(subkindObjectDropDown)).click();
        setValueDropDownToText(kingObjectForFNS);
    }

    /**
     * Выбор Класса опасности
     */
    @Step("Выбор Класса опасности - {dangerClass}")
    public void setDangerClassDropDown() {
        $(By.xpath(dangerClassDropDown)).click();
        setValueDropDownToText(dangerClass);
    }

    /**
     * Удаление объекта
     */
    @Step("Удаление объекта")
    public void deleteObject() {
        $(By.xpath(deleteObjectButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить в разделе Перечень действий, осуществляемый в рамках КНМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Перечень действий, осуществляемый в рамках КНМ")
    public void clickAddListActionsButton() {
        $(By.xpath(addListActionsButton)).click();
    }

    /**
     * Выберите Тип действия в разделе Перечень действий
     */
    @Step("Выберите Тип действия в разделе Перечень действий - {typeActions}")
    public void setTypeActionsDropDown() {
        $(By.xpath(typeActionsDropDown)).click();
        setValueDropDownToText(typeActions);
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
        $(By.xpath(dateTimePublicationDecisionField)).scrollIntoView(false).setValue(date);
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
        setValueDropDownToText(positionDirector);
    }

    /**
     * Нажатие на кнопку Добавить в блоке Основания проведения КНМ
     */
    @Step("Нажатие на кнопку Добавить в блоке Основания проведения КНМ")
    public void clickAddGroundConductingButton() {
        $(By.xpath(addGroundConductingButton)).scrollIntoView(false).click();
    }

    /**
     * Заполнение выпадающего списка Основание регистрации КНМ
     *
     * @param parameter Необходимое основание из списка
     */
    @Step("Заполнение выпадающего списка Основание регистрации КНМ - {parameter}")
    public void setGroundConductingDropDown(String parameter) {
        $(By.xpath(groundConductingDropDown)).click();
        setValueDropDownToText(parameter);
    }

    /**
     * Заполнение выпадающего списка Необходимость согласования
     *
     * @param parameter необходимый параметр
     */
    @Step("Заполнение выпадающего списка Необходимость согласования - {parameter}")
    public void setNeedCoordinationDropDown(String parameter) {
        if(parameter == null) {
            return;
        }
        $(By.xpath(needCoordinationDropDown)).click();
        setValueDropDownToText(parameter);
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
        setValueDropDownToText(typeDocument);
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
     * @param result Решение
     * @param date   Дата принятия решения
     */
    @Step("Добавление решения по заявлению - {result}, дата принятия решения - {date}")
    public void setDecisionApplicationDropDown(String result, String date) {
        $(By.xpath(decisionApplicationDropDown)).should(visible, Duration.ofSeconds(10)).click();
        setValueDropDownToText(result);
        setFieldsInInformationAboutApproval(date);
        if(result == rejected){
            setFieldsCaseOfRejectionProsecutor(date); // заполнение доп полей
        }
    }

    /**
     * Заполнение полей в сведениях о согласовании
     *
     * @param date Дата принятия решения
     */
    @Step("Заполнение полей в сведениях о согласовании")
    public void setFieldsInInformationAboutApproval(String date) {
        $(By.xpath(inputDecisionNumber)).setValue(prefix); // заполнение поля Номер решения
        $(By.xpath(inputDecisionDate)).setValue(date);  // заполнение поля Дата решения
        $(By.xpath(inputDecisionSubject)).setValue(prefix + " Авто ФИО"); // заполнение поля Лицо принявшее решение
        $(By.xpath(inputPosition)).setValue(prefix + " Авто должность"); // заполнение поля Должность лица принявшего решение
    }

    /**
     * Заполнение дополнительных полей при отклонении прокурором в сведениях о согласовании
     *
     * @param date Дата принятия решения
     */
    @Step("Заполнение дополнительных полей при отклонении прокурором в сведениях о согласовании")
    public void setFieldsCaseOfRejectionProsecutor(String date) {
        setRejectionReason(causeLackOfDocuments);  // выбор причины отказа
        $(By.xpath(inputRejectReasonNote)).setValue(prefix + " Авто Мотивировка");  // заполнение мотивировки отказа
        $(By.xpath(inputRejectionDate)).setValue(date);  // заполнение даты отказа
    }

    /**
     * Выбор причины отказа из выпадающего списка
     *
     * @param param  Причина отказа
     */
    @Step("Выбор причины отказа - {param} из выпадающего списка")
    public void setRejectionReason(String param) {
        $(By.xpath(selectRejectionReason)).click();
        setValueDropDownToText(param);
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
        setValueDropDownToText(addNewSampleButton);
    }

    /**
     * Выбор из выпадающего списка ОТ
     *
     * @param name Наименование ОТ
     */
    @Step("Выбор из выпадающего списка ОТ - {name}")
    public void selectMandatoryRequirementsDropDown(String name) {
        $(By.xpath(mandatoryRequirementsDropDown)).scrollIntoView(false).click();
        setValueDropDownToText(name);
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
     * Добавление существующего обязательного требования
     *
     * @param name    Название ОТ
     */
    @Step("Добавление нового обязательного требования")
    public void addMandatoryRequirements(String name) {
        $(By.xpath("//*[text()='Предмет контрольного (надзорного) мероприятия']")).scrollIntoView(false);
        clickAddMandatoryRequirementsButton();
        selectMandatoryRequirementsDropDown(name);
    }

    /**
     * Добавление сведений о контролируемом лице
     *
     * @param typePerson    Тип контролируемого лица
     * @param inn           ИНН
     * @param view          Вид объекта
     */
    @Step("Добавление сведений о контролируемом лице: Тип контролируемого лица - {typePerson}, ИНН - {inn}, " +
            "Вид объекта - {view}")
    public void addInformationControlledPerson(String typePerson, String inn, String view) {
        clickAddButtonInInformationControlledPerson();
        setTypeControlledPersonDropDown(typePerson);
        setInnField(inn);
        if(view == null) {
            deleteObject();
            return;
        }
        setTypeObjectDropDown();
        setKindObjectDropDown(view);
        setDangerClassDropDown();

    }

    /**
     * Нажать на кнопку Добавить в Сведения о контролируемом лице
     */
    @Step("Нажать на кнопку Добавить в Сведения о контролируемом лице")
    public void clickAddButtonInInformationControlledPerson() {
        $(By.xpath(addButtonInInformationControlledPerson)).click();
    }

    /**
     * Выбор типа контролируемого лица
     *
     * @param typePerson    Тип контролируемого лица
     */
    @Step("Выбор типа контролируемого лица - {typePerson}")
    public void setTypeControlledPersonDropDown(String typePerson) {
        $(By.xpath(typesControlledPersons)).scrollIntoView(false).click();
        setValueDropDownToText(typePerson);
    }

    /**
     * Создание КНМ
     *
     * @param nameKNO        Наименование органа контроля
     * @param viewKNO        Вид контроля (надзора) и его нормер
     * @param kind           Вид КНМ
     * @param character      Характер КНМ
     * @param startDate      Дата начала КНМ
     * @param stopDate       Дата окончания КНМ
     * @param days           Срок непосредственного взаимодействия дней
     * @param hours          Срок непосредственного взаимодействия часов
     * @param nameProsecutor Наименование прокуратуры
     * @param typePerson     Тип контролируемого лица
     * @param inn            ИНН
     * @param viewObject     Вид объекта
     */
    @Step("Создание внеплановой КНМ: Наименование органа контроля - {nameKNO}, Вид контроля (надзора) - {viewKNO}, " +
            "Вид КНМ - {kind}, Характер КНМ - {character}, Дата начала КНМ - {startDate}, Дата окончания КНМ - {stopDate}, " +
            "Срок непосредственного взаимодействия дней - {days}, Срок непосредственного взаимодействия часов - {hours}," +
            " Наименование прокуратуры - {nameProsecutor}, Тип контролируемого лица - {typePerson}, ИНН - {inn}, Вид объекта - {viewObject}")
    public void addKNM(String nameKNO, String viewKNO, String kind, String character, String startDate, String stopDate,
                                String days, String hours, String nameProsecutor, String typePerson, String inn, String viewObject) {
        clickAddButton();
        setRequiredFieldsKNM(nameKNO, viewKNO, kind, character, startDate, stopDate, days, hours, nameProsecutor,
                typePerson, inn, viewObject);
        clickSaveButton();
    }


    /**
     * Заполнение обязательных полей при создании КНМ
     *
     * @param nameKNO        Наименование органа контроля
     * @param viewKNO        Вид контроля (надзора) и его нормер
     * @param kind           Вид КНМ
     * @param character      Характер КНМ
     * @param startDate      Дата начала КНМ
     * @param stopDate       Дата окончания КНМ
     * @param days           Срок непосредственного взаимодействия дней
     * @param hours          Срок непосредственного взаимодействия часов
     * @param nameProsecutor Наименование прокуратуры
     * @param typePerson     Тип контролируемого лица
     * @param inn            ИНН
     * @param viewObject     Вид объекта
     */
    @Step("Заполнение обязательных полей КНМ: Наименование органа контроля - {nameKNO}, Вид контроля (надзора) - {viewKNO}, " +
            "Вид КНМ - {kind}, Характер КНМ - {character}, Дата начала КНМ - {startDate}, Дата окончания КНМ - {stopDate}, " +
            "Срок непосредственного взаимодействия дней - {days}, Срок непосредственного взаимодействия часов - {hours}," +
            " Наименование прокуратуры - {nameProsecutor}, Тип контролируемого лица - {typePerson}, ИНН - {inn}, Вид объекта - {viewObject}")
    public void setRequiredFieldsKNM(String nameKNO, String viewKNO, String kind, String character, String startDate,
                                String stopDate, String days, String hours, String nameProsecutor, String typePerson,
                                     String inn, String viewObject) {
        setNameKNODropDown(nameKNO);
        setKindControlAndNumberDropDown(viewKNO);
        setKindKNMDropDown(kind);
        setCharacterKNMDropDown(character);
        if(character == plannedCheck) {
            setNumberPlanField(numberPlan);
        }
        setStartKNMDate(startDate);
        setStopKNMDate(stopDate);
        interactionTimeDays(days);
        interactionTimeHours(hours);
        setNameProsecutorDropDown(nameProsecutor);
        if (viewKNO != null) {
            addInformationControlledPerson(typePerson, inn, viewObject);
        }
    }

    /**
     * Создание плановой КНМ через план
     *
     * @param viewKNO        Вид контроля (надзора) и его нормер
     * @param kind           Вид КНМ
     * @param startDate      Дата начала КНМ
     * @param stopDate       Дата окончания КНМ
     * @param days           Срок непосредственного взаимодействия дней
     * @param hours          Срок непосредственного взаимодействия часов
     * @param typePerson     Тип контролируемого лица
     * @param inn            ИНН
     * @param viewObject     Вид объекта
     */
    @Step("Создание плановой КНМ через план: Вид контроля (надзора) - {viewKNO}, Вид КНМ - {kind}, Дата начала КНМ - " +
            "{startDate}, Дата окончания КНМ - {stopDate}, Срок непосредственного взаимодействия дней - {days}, Срок " +
            "непосредственного взаимодействия часов - {hours}, Тип контролируемого лица - {typePerson}, ИНН - {inn}, " +
            "Вид объекта - {viewObject}")
    public String addPlannedKNM(String viewKNO, String kind, String startDate, String stopDate, String days, String hours,
                                String typePerson, String inn, String viewObject) throws InterruptedException {
        setKindControlAndNumberDropDown(viewKNO);
        setKindKNMDropDown(kind);
        setStartKNMDate(startDate);
        setStopKNMDate(stopDate);
        interactionTimeDays(days);
        interactionTimeHours(hours);
        if (viewKNO != null) {
            addInformationControlledPerson(typePerson, inn, viewObject);
        }
        clickSaveButton();
        closeNotification();
        return getNumberKNM();
    }

    /**
     * Заполнение выпадающего списка Тип документа в блоке Основание проведения КНМ
     */
    @Step("Заполнение выпадающего списка Тип документа в блоке Основание проведения КНМ - {docType}")
    public void setDocumentTypeDropDown() {
        $(By.xpath(selectDocType)).click();
        setValueDropDownToText("Мотивированное представление");
    }

    /**
     * Добавление документа и подписи в блоке Основания проведения КНМ
     */
    @Step("Добавление документа и подписи в блоке Основания проведения КНМ")
    public void addDocumentAndSignatureGroundsConducting() {
        $(By.xpath(addGroundsButton)).click(); // нажимаем добавить документ основания
        setDocumentTypeDropDown(); // выбираем тип документа
        $(By.xpath(addFileInGroundsButton)).click();  // нажимаем добавить файл
        $(By.xpath(documentGroundsConductingInput)).uploadFile(new File(filePath)); // загружаем файл
        //$(By.xpath(signatureGroundsConductingInput)).uploadFile(new File(sPath));
        $(By.xpath(uploadFileButton)).click(); // нажать кнопку загрузить
    }

    /**
     * Добавление блока Основания проведения КНМ для внеплановой КНМ
     *
     * @param grounds            Основания проведения КНМ
     * @param orderNumber        Номер поручения
     * @param orderDate          Дата поручения
     * @param detailsRequirement Реквизиты требования
     * @param param              Параметр требует/не требует согласования
     */
    @Step("Добавление блока Основания проведения КНМ для внеплановой КНМ: Основания проведения КНМ - {grounds}, " +
            "Номер поручения - {orderNumber}, Дата поручения - {orderDate}, Реквизиты требования - {detailsRequirement}," +
            "Параметр требует/не требует согласования - {param}")
    public void addGroundsConductingUnscheduled(String grounds, String orderNumber, String orderDate,
                                                String detailsRequirement, String param) throws InterruptedException {
        clickAddGroundConductingButton();
        setGroundConductingDropDown(grounds);
        if(grounds == "4.0.18" || grounds == "4.0.19" || grounds == "4.0.20") {
            sleep(3000);
            setOrderNumber(orderNumber);
            setOrderDate(orderDate);
        } else if(grounds == "4.0.21") {
            setDetailsRequirement(detailsRequirement);
        } else if(grounds == "4.0.11" || grounds == "4.0.12" || grounds == "4.0.14" ) {
            return;
        } else if(grounds == "4.0.1" || grounds == "4.0.2" || grounds == "4.0.3" || grounds == "4.0.13" ) {
            setOrderDate(orderDate);
            return;
        } else if(grounds == "4.0.4") {
            setOtherBasisForRegistration(detailsRequirement);
            return;
        }
        setNeedCoordinationDropDown(param);
        if(param.equals(needCoordination)) {
            addDocumentAndSignatureGroundsConducting();
        }
    }

    /**
     * Заполнение поля Реквизиты требования в блоке Основания проведения КНМ
     *
     * @param detailsRequirement Реквизиты требования
     */
    @Step("Заполнение поля Реквизиты требования в блоке Основания проведения КНМ: Реквизиты требования - {detailsRequirement}")
    public void setDetailsRequirement(String detailsRequirement) {
        if(detailsRequirement == null) {
            return;
        }
        $(By.xpath(detailsRequirementInput)).setValue(detailsRequirement);
    }

    /**
     * Заполнение поля Иное основание регистрации КНМ
     *
     * @param grounds Основание
     */
    @Step("Заполнение поля Иное основание регистрации КНМ: Основание - {grounds}")
    public void setOtherBasisForRegistration(String grounds) {
        if(grounds == null) {
            return;
        }
        $(By.xpath(groundsRegistrationInput)).setValue(grounds);
    }

    /**
     * Заполнение поля Дата поручения в блоке Основания проведения КНМ
     *
     * @param orderDate Дата поручения
     */
    @Step("Заполнение поля Дата поручения в блоке Основания проведения КНМ: Дата поручения - {orderDate}")
    public void setOrderDate(String orderDate) {
        if(orderDate == null) {
            return;
        }
        $(By.xpath(orderDateInput)).setValue(orderDate);
    }

    /**
     * Заполнение поля Номер поручения в блоке Основания проведения КНМ
     *
     * @param orderNumber Номер поручения
     */
    @Step("Заполнение поля Номер поручения в блоке Основания проведения КНМ: Номер поручения - {orderNumber}")
    public void setOrderNumber(String orderNumber) {
        if(orderNumber == null) {
            return;
        }
        $(By.xpath(orderNumberInput)).setValue(orderNumber);
    }

    /**
     * Добавление блока Основания проведения КНМ для плановой КНМ
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
//    @Step("Добавление блока Основания проведения КНМ для плановой КНМ")
//    public void addGroundsConductingPlanned(String fPath, String sPath) {
//        clickAddGroundConductingButton();
//        setGroundConductingDropDown();
//        clickAddFoundationButton();
//        setTypeDocumentDropDown();
//        clickAddFileButton();
//        addDocumentAndSignatureGroundsConducting(fPath, sPath);
//        clickUploadButton();
//    }

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
        $(By.xpath(addInformationAboutActsButton)).scrollIntoView(false).should(visible, Duration.ofSeconds(10)).click();
    }

    /**
     * Выбор Вида акта
     *
     * @param typeOfAct  Вид акта
     */
    @Step("Выбор Вида акта - {typeOfAct}")
    public void setTypeOfActDropDown(String typeOfAct) {
        $(By.xpath(selectTypeOfAct)).click();
        setValueDropDownToText(typeOfAct);
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
     */
    @Step("Добавление документа и подписи в блоке Файл акта")
    public void addDocumentAndSignatureFileAct() {
        $(By.xpath(documentInformationAboutActsInput)).uploadFile(new File(filePath));
        //$(By.xpath(signatureInformationAboutActsInput)).uploadFile(new File(sPath));
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
        setValueDropDownToText(signPosition);
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
     * Выбор должности в блоке Должностные лица КНО, участвовавшие в КНМ
     *
     * @param name Название должности
     */
    @Step("Выбор должности - {name} в блоке Должностные лица КНО, участвовавшие в КНМ")
    public void setPositionOfficialsDropDown(String name) {
        $(By.xpath(positionOfficialsParticipatedDropDown)).click();
        setValueDropDownToText(name);
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
        setValueDropDownToText(result);
    }

    /**
     * Выбор причины невозможности проведения
     *
     * @param cause Причина невозможности проведения
     */
    @Step("Выбор причины невозможности проведения - {cause}")
    public void setReasonForImpossibilityDropDown(String cause) {
        $(By.xpath(selectReasonForImpossibility)).click();
        setValueDropDownToText(cause);
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
     *
     * @param typeOfAct  Вид акта
     * @param numberAct  Номер акта
     * @param result     Результат ознакомления
     */
    @Step("Заполнение блока сведения об акте: Вид акта - {typeOfAct}, Номер акта - {numberAct}, Результат ознакомления - {result}")
    public void addInformationAboutAct(String typeOfAct, String numberAct, String result) {
        clickAddInformationAboutActsButton();
        setTypeOfActDropDown(typeOfAct);
        clickAddFileActButton();
        addDocumentAndSignatureFileAct();
        clickUploadButton();
        if(typeOfAct == supervisoryAct) {
            setNumberActField(numberAct);
            setDateDrawingUpAct(currentDateTime);
            setDateStartKNM(currentDateTime);
            setDurationDaysActField("1");
            setNameSignatoryActField(prefix + " Авто ФИО");
            setPositionSignatoryActDropDown(positionDirector);
            clickAddOfficialsParticipatedButton();
            setOfficialsParticipatedEventField(prefix + " Авто ФИО");
            setPositionOfficialsDropDown(positionDirector);
            setFactField(prefix);
            setInformationAboutRecognitionDropDown(result);
            if(result == familiarWith || result == refusalToFamiliarize) {
                setWhoFamiliarWithField(prefix + " Авто ФИО");
                setPositionFamiliarWithField(positionDirector);
            }
        } else {
            setReasonForImpossibilityDropDown(absenceAtLocation);
        }
    }

    /**
     * Добавление информации в раздел Сведения о должностных лицах, участвующих в КНМ
     *
     * @param fio ФИО
     */
    @Step("Добавление информации в раздел Сведения о должностных лицах, участвующих в КНМ")
    public void addInformationAboutOfficialsParticipatingInTheKNM(String fio) {
        $(By.xpath(addInformationAboutOfficialsParticipatingButton)).click();
        $(By.xpath(addFIOParticipatingField)).setValue(fio);
        $(By.xpath(addPositionParticipatingDropDown)).click();
        setValueDropDownToText("Начальник");
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
        setValueDropDownToText(addNewSampleButton);
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
     * Перевод проверки из статуса В процессе заполнения в статус Готово к согласованию|Ожидает проведения
     *
     * @param dateTimePublication Дата и время издания решения
     * @param startDate           Дата начала действий, осуществляемый в рамках КНМ
     * @param stopDate            Дата окончания действий, осуществляемый в рамках КНМ
     * @param grounds             Основание включения в план
     * @param param               Необходимость согласования
     */
    @Step("Перевод проверки из статуса В процессе заполнения в статус Готово к согласованию|Ожидает проведения. " +
            "Основание включения в план - {grounds}, Необходимость согласования - {param}")
    public void transferEventStatusReadyApproval(String dateTimePublication, String startDate, String stopDate,
                                                 String grounds, String param) throws InterruptedException {
        String kindKNM = getValueOfField("Вид КНМ", kindKnmDropDownText);
        setDateTimePublicationDecisionField(dateTimePublication);
        setSolutionNumberField(prefix);
        setPlaceDecisionField(placeDecision);
        setNameOfficialField(officialField);
        setPositionPersonSignedDecisionsDropDown();
        addGroundsConductingUnscheduled(grounds, prefix, currentDate, prefix, param);
        if (param == doesNotRequire) {
            addInformationAboutOfficialsParticipatingInTheKNM(prefix + " Авто ФИО");
        }
        addListActions(startDate, stopDate);
        setBlockOfRequirements("правительство");
        if (!kindKNM.equals(documentaryVerification)) {
            clickAddVenueButton();
            setVenueField(placeDecision);
        }
        if (kindKNM.equals(onsiteInspection)) {
            setFieldsNotificationInformation(currentDate, "Иное");
        }
        clickSaveButton();
        closeNotification();
        sleep(5000);
    }

    /**
     * Подписание КНМ электронной подписью
     */
    @Step("Подписание КНМ электронной подписью")
    public void electronicSignatureInBrowser() throws InterruptedException {
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
     * Заполнение полей необходимых для согласования КНМ
     *
     * @param date               Даты в блоке перечень действий
     * @param grounds            Основания проведения КНМ
     */
    @Step("Заполнение полей необходимых для согласования КНМ")
    public void setFieldsNecessaryForHarmonization(String grounds, String date) throws InterruptedException {
        setDateTimePublicationDecisionField(currentDateTime);
        setSolutionNumberField(prefix);
        setPlaceDecisionField(placeDecision);
        setNameOfficialField(officialField);
        setPositionPersonSignedDecisionsDropDown();
        addGroundsConductingUnscheduled(grounds, null, null, null, needCoordination);
        addListActions(date, date);
        clickAddVenueButton();
        setVenueField(placeDecision);
        addMandatoryRequirements("требование 1");
    }

    /**
     * Перевод проверки из статуса Готово к согласованию в статус На согласовании
     */
    @Step("Перевод проверки из статуса Готово к согласованию в статус На согласовании")
    public void transferEventStatusOnApproval() throws InterruptedException {
        electronicSignatureInBrowser();
        clickActionsOnCardButton();
        clickForApprovalButton();
        closeNotification();
    }

    /**
     * Рассмотрение прокурором
     *
     * @param statusDecision Решение по заявлению: Согласовано или Отклонено
     * @param date           Дата принятия решения
     */
    @Step("Рассмотрение прокурором с решением - {statusDecision}, датой - {date}")
    public void transferEventStatusAgreed(String statusDecision, String date) {
        setDecisionApplicationDropDown(statusDecision, date);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Перевод КНМ из статуса Ожидает завершения в статус Завершено
     *
     * @param typeOfAct  Вид акта
     */
    @Step("Перевод КНМ из статуса Ожидает завершения в статус Завершено. Вид акта - {typeOfAct}")
    public void transferEventStatusWaitCompleted(String typeOfAct) {
        addInformationAboutAct(typeOfAct, randomNumber, familiarWith);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Исключение из плана КНМ
     */
    @Step("Исключение из плана КНМ")
    public void excludeKNMFromPlan() {
        $(By.xpath(actionButtonInKNM)).click();  // нажать кнопку Действия
        $(By.xpath(excludeKNMFromPlanButton)).click(); // выбрать исключить из плана
        $(By.xpath(exclusionGroundDropDown)).click();
        setValueDropDownToText(exclusionGround);
        $(By.xpath(docInput)).uploadFile(new File(filePath));
        $(By.xpath(exclusionButton)).click();
        closeNotification();
        checkStatusKNM(statusExcluded);
    }

    /**
     * Открыть форму фильтрации
     */
    @Step("Открыть форму фильтрации")
    public void openFiltrationForm() throws InterruptedException {
        $(By.xpath(filtersButton)).click();
    }

    /**
     * Заполнить блок Основные параметры
     *
     * @param nameKNO                  Наименование органа контроля
     * @param character                Характер КНМ
     */
    @Step("Заполнение блока Основные параметры: Наименование органа контроля - {nameKNO}, Характер КНМ - {character}")
    public void setBasicFilterParameters(String nameKNO, String character) throws InterruptedException {
        setTerritorialUnit(territorialUnitName);
        clickCheckboxUnderTerritorialUnit();
        setNameKNOForBlockFiltration(nameKNO);
        selectCharacterKNMForBlockFiltration(character);
    }

    /**
     * Выбор значения в выпадающем списке Территориальная единица
     *
     * @param name Наименование территориальной единицы
     */
    @Step("Выбор значения в выпадающем списке Территориальная единица - {name}")
    public void setTerritorialUnit(String name) {
        $(By.xpath(territorialUnit)).click();
        setValueDropDownToText(name);
    }

    /**
     * Выбор значения в выпадающем списке Наименование органа контроля (надзора) в блоке фильтров
     *
     * @param name Наименование органа контроля (надзора)
     */
    @Step("Выбор значения в выпадающем списке Наименование органа контроля (надзора) в блоке фильтров - {name}")
    public void setNameKNOForBlockFiltration(String name) throws InterruptedException {
        if(name != null) {
            $(By.xpath(nameKNODropDownFiltrationBlock)).click();
            setValueDropDownToText(name);
        } else {
            return;
        }
    }

    /**
     * Выбор характера КНМ в блоке фильтров
     *
     * @param character Характер КНМ
     */
    @Step("Выбор характера КНМ - {character} в блоке фильтров")
    public void selectCharacterKNMForBlockFiltration(String character) throws InterruptedException {
        if (character != null) {
            ElementsCollection elements = $$(By.xpath(deleteCharacterKNMValue));
            for (int i = 0; i < elements.size(); i++) {
                $(By.xpath(deleteCharacterKNMValue)).click();
            }
            $(By.xpath(characterKNMField)).click();
            setValueDropDownToText(character);
        } else {
            return;
        }
    }

    /**
     * Включить чекбокс Включая подчиненные организации под полем Территориальные единицы
     *
     */
    @Step("Включить чекбокс Включая подчиненные организации под полем Территориальные единицы")
    public void clickCheckboxUnderTerritorialUnit() {
        $(By.xpath(checkboxTerritorialUnit)).click();
    }

    /**
     * Нажать на кнопку Добавить в блоке фильтров
     */
    @Step("Нажать на кнопку Добавить в блоке фильтров")
    public void clickButtonForFiltersBlock() {
        $(By.xpath(addButtonFilters)).scrollIntoView(false).click();
    }

    /**
     * Поиск дополнительного фильтра
     *
     * @param parameter Параметр фильтрации
     */
    @Step("Поиск дополнительного фильтра - {parameter}")
    public void searchAdditionalFilter(String parameter) {
        $(By.xpath(inputSearchFilters)).setValue(parameter);
        $(By.xpath(parameterFilter)).click();
    }

    /**
     * Нажать на кнопку Применить при выборе дополнительного фильтра
     */
    @Step("Нажать на кнопку Добавить в блоке фильтров")
    public void clickButtonUpdateForNewFilters() {
        $(By.xpath(buttonUpdateNewFilters)).click();
    }

    /**
     * Добавление дополнительного параметра фильтрации
     *
     * @param parameter Параметр фильтрации
     */
    @Step("Добавление дополнительного параметра фильтрации - {parameter}")
    public void addAdditionalFilter(String parameter) {
        clickButtonForFiltersBlock();
        searchAdditionalFilter(parameter);
        clickButtonUpdateForNewFilters();
    }

    /**
     * Заполнение поля дополнительного параметра фильтрации
     *
     * @param locator Локатор поля
     * @param text    Заполняемый текст
     */
    @Step("Заполнение поля дополнительного параметра фильтрации - {text}")
    public void setAdditionalFilterInput(String locator, String text) {
        $(By.xpath(locator)).scrollIntoView(false).setValue(text);
    }

    /**
     * Выбор статуса КНМ в блоке дополнительного параметра фильтрации
     *
     * @param status Статус КНМ
     */
    @Step("Выбор статуса КНМ - {status} в блоке дополнительного параметра фильтрации")
    public void selectStatusKNMInFiltration(String status) {
        $(By.xpath(statusKNMFieldFilter)).scrollIntoView(false).click();
        setValueDropDownToText(status);
    }

    /**
     * Удаление поля дополнительного параметра фильтрации
     *
     */
    @Step("Удаление поля дополнительного параметра фильтрации")
    public void deleteAdditionalFilterInput() {
        ElementsCollection elements = $$(By.xpath(deleteButtonAdditionalFilter));
        elements.first().click();
    }

    /**
     * Нажать кнопку Применить в блоке фильтров
     *
     */
    @Step("Нажать кнопку Применить в блоке фильтров")
    public void clickButtonUpdateForFilterBlock() {
        $(By.xpath(buttonUpdateFilters)).click();
    }

    /**
     * Открыть сохраненный фильтр
     */
    @Step("Открыть сохраненный фильтр")
    public void openSavedFilter() throws InterruptedException {
        $(By.xpath(savedFilter)).scrollIntoView(false).click();
        $(By.xpath(savedFilter)).scrollIntoView(false).click();
    }

    /**
     * Проверка номера КНМ из таблицы Список КНМ на соответствие
     *
     * @param numberKNM  Ожидаемый номер КНМ
     */
    @Step("Проверка номера КНМ из таблицы Список КНМ на соответствие ожидаемому номеру - {numberKNM}")
    public void checkNumberKNMFromTable(String numberKNM) {
        $(By.xpath(numberKNMInList))
                .should(visible, Duration.ofSeconds(15))
                .scrollIntoView(false)
                .should(Text.text(numberKNM));
    }

    /**
     * Заполнение поля дополнительного параметра фильтрации датами по периоду
     *
     * @param locatorStartDate Локатор поля даты начала
     * @param locatorStopDate  Локатор поля даты окончания
     * @param startDate        Дата начала
     * @param stopDate         Дата окончания
     */
    @Step("Заполнение поля дополнительного параметра фильтрации датами по периоду: Дата начала  - {startDate}, " +
            "Дата окончания - {stopDate}")
    public void setAdditionalFilterIntervalInput(String locatorStartDate, String locatorStopDate, String startDate,
                                         String stopDate) {
        $(By.xpath(locatorStartDate)).scrollIntoView(false).setValue(startDate);
        $(By.xpath(locatorStopDate)).scrollIntoView(false).setValue(stopDate);
    }

    /**
     * Фильтрация КНМ по параметрам
     *
     * @param nameKNO                  Наименование органа контроля
     * @param character                Характер КНМ
     * @param parameters               Дополнительные параметры фильтрации
     * @param stopDate                 Финальная дата для начала проведения КНМ
     * @param status                   Статус КНМ
     */
    @Step("Фильтрация КНМ по параметрам: Наименование органа контроля  - {nameKNO}, Характер КНМ - {character}, Дополнительные параметры фильтрации" +
            " - {parameters}, Статус КНМ - {status}")
    public void filtrationEventsForParameters(String nameKNO, String character, String[] parameters, String stopDate,
                                              String status) throws InterruptedException {
        openFiltrationForm();
        openSavedFilter();
        setBasicFilterParameters(nameKNO, character);
        deleteAdditionalFilterInput();
        if(parameters != null) {
            for(String parameter : parameters) {
                addAdditionalFilter(parameter);
                sleep(3000);
                if (parameter == "Дата начала проведения КНМ (интервал)") {
                    setAdditionalFilterIntervalInput(orderDateStartIntervalInput, orderDateStopIntervalInput,
                            "01.01.2021", stopDate);
                }
                if (parameter == "Статус КНМ") {
                    selectStatusKNMInFiltration(status);
                }
                if (parameter == "Реквизиты требования") {
                    setAdditionalFilterInput(requirementDetailsFilterInput, "1");
                }
                if (parameter == "Дата поручения правительства о проведении КНМ (интервал)") {
                    setAdditionalFilterIntervalInput(orderDateStartIntervalInput, orderDateStopIntervalInput,
                            "01.01.2021", futureDate);
                }

            }
        }
        clickButtonUpdateForFilterBlock();
    }

    /**
     * Заполнение блока Обязательные требования, подлежащие проверке
     *
     * @param nameNPA Наименование НПА
     */
    @Step("Заполнение блока Обязательные требования, подлежащие проверке: Наименование НПА - {nameNPA}")
    public String setBlockOfRequirements(String nameNPA) throws InterruptedException {
        String numberNPA = randomNumber;
        clickButtonAddForRequirements();
        searchNameNPA(nameNPA);
        Selenide.sleep(3000);
        try {
            selectNPAFromTable();
            Selenide.sleep(3000);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            addNewNPA(numberNPA);
        }
        finally {
            selectSEFromList();
            return numberNPA;
        }
    }

    /**
     * Нажать Добавить в обязательные требования подлежащие проверке
     */
    @Step("Нажать Добавить в обязательные требования подлежащие проверке")
    public void clickButtonAddForRequirements() {
        $(By.xpath(buttonAddForRequirements)).click();
    }

    /**
     * Поиск НПА в форме добавления обязательного требования
     *
     * @param nameNPA Наименование НПА
     */
    @Step("Поиск НПА - {nameNPA} в форме добавления обязательного требования")
    public void searchNameNPA(String nameNPA) throws InterruptedException {
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
     * Нажать Сохранить в обязательные требования подлежащие проверке
     */
    @Step("Нажать Сохранить в обязательные требования подлежащие проверке")
    public void clickButtonSaveForRequirements() {
        $(By.xpath(buttonSaveInFormRequirement)).click();
    }

    /**
     * Заполнение Информации об уведомлении проверяемого лица
     *
     * @param date     Дата уведомления
     * @param method   Способ уведомления
     */
    @Step("Заполнение Информации об уведомлении проверяемого лица: Дата уведомления - {date}, Способ уведомления - {method}")
    public void setFieldsNotificationInformation(String date, String method) {
        $(By.xpath(inputNoticeDate)).setValue(date);
        $(By.xpath(inputNotificationMethod)).click();
        setValueDropDownToText(method);
    }

    /**
     * Раскрыть раздел История изменений
     */
    @Step("Раскрыть раздел История изменений")
    public void openHistoryOfChanges() {
        $(By.xpath(buttonOpenHistoryOfChanges)).click();
    }
}
