package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class ListEventsERPPage extends Common {
    //Список проверок
    String viewKNMDropDown = "//div[@id='typeBlock']/div[2]"; //выпадающий список Вид КНМ
    String formKMNDropDown = "//div[@id='kindBlock']/div[2]"; //Выпадающий список Форма КНМ
    String typeSubjectDropDown = "//div[@id='subjectTypeBlock']/div[2]"; // Выпадающий список Тип субъекта КНМ
    String numberOrdersField = "//*[@name='orderNumber']"; //поле Номер приказа
    String dateOrdersField = "//*[@id='orderDateBlock']//input"; // поле Дата приказа
    String dateStartKNMField = "//*[@id='startDateBlock']//input"; //поле Дата начала КНМ
    String dateStopKNMField = "//*[@id='stopDateBlock']//input"; //поле Дата окончания КНМ
    String monthKNMDropDown = "//*[@id='monthBlock']//div[2]"; // Выпадающий список Месяц проведения КНМ

    String addLegalGroundsConductingButton = "//*[@id='legalBasesTitle']/span/button"; //кнопка Добавить в разделе Правовые основания проведения КНМ
    String absenceDirectoryRadioButton = "//*[@id='legalBasesNotExist']"; //радиобатон Отсутствует в справочнике
    String LegalGroundsConductingField = "//textarea[@name='notExistLegalBasisText']"; // поле для ввода в разделе Выберите нормативно-правовые акты
    String saveLegalGroundsConductingButton = "//div[contains(@class, 'ModalActions_Container')]/button[1]"; //кнопка Сохранить в разделе Выберите нормативно-правовые акты
    String goalsTasksSubjectField = "//*[@id='check-sheets']/div[3]/textarea"; // текстовое поле Цели, задачи, предмет КНМ
    String durationEventDaysField = "//*[@id='durationDays']"; //поле Срок проведения (дней)
    String durationEventHoursField = "//*[@id='durationHours']";//поле Срок проведения (часов)

    String addListControlMeasuresButton = "//*[@id='eventsBlock']//button"; // кнопка Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
    String listControlMeasuresField = "//textarea[@name='events[0].name']"; // поле для ввода в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ

    String addGroundRegistrationButton = "//*[@id='reasonsTitleBlock']/span/button"; // кнопка Добавить в разделе Основания регистрации  КНМ
    String groundRegistrationDropDown = "//*[@id ='reasonsTitleBlock']/../ul/li[1]//div[contains(@class, 'SelectInput_Control')]"; //выпадающий список Основание регистрации КНМ
    String groundRegistration = "1.2.27 (99-ФЗ) Наличие приказа (распоряжения), изданного лицензирующим органом в соответствии с поручением Президента Российской Федерации или Правительства Российской Федерации.";

    String nameKNODropDown = "//div[@id='knoOrganizationBlock']/div[2]"; //выпадающий список Наименование органа контроля
    String kindControlDropDown = "//*[@id='supervisionTypeBlock']/div[2]"; // выпадающий список Вид государственного контроля (надзора)

    String innField = "//*[@id='inn']"; //ИНН
    //String innListField = "//li[contains(@class,'AutoComplete_OptionItem')]"; //появившийся спискок ИНН

    String namePersonCheckField = "//*[@name='organizationName']";

    String addMandatoryRequirementsButton = "//*[@id='requirementsTitleBlock']//button";//кнопка Добавить в блоке Подлежащие проверке обязательные требования
    String mandatoryRequirementsDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[2]";//выпадающий список Обязательные требования
    String saveButtonMandatoryRequirementsButton = "//div[contains(@class, 'ModalActions_Container')]//*[text()='Добавить']"; // Кнопка Добавить в модальном окне Добавление обязательного требования

    String KNMNumberText = "//h3[contains(@class, 'KnmInfo_Title')]"; // Заголовок на странице с КНМ, в котором находится номер КНМ
    String knmListCell = "//td[contains(@class, 'KnmListTable_ErpIdCell')]"; // ячейка с номером КНМ из списка КНМ на страние Список проверок

    String objectsKNMButton = "//*[@id='objectsBlock']/div[1]//button"; // Кнопка Добавить в блоке "Объекты проведения КНМ"
    String addressField = "//textarea[@name='objects[0].addressText']"; // поле Местоположение в блоке Объекты проведения КНМ
    String addressTypeDropDown = "//*[@id='objects[0].addressType']"; // Выпадающий список Тип места в блоке Объекты проведения КНМ
    String typeObjectDropDown = "//*[@id='objects[0].objectType']"; // Выпадающий список Тип объекта проведения в блоке Объекты проведения КНМ
    String riskCategoryDropDown = "//*[@id='objects[0].riskCategory']"; // Выпадающий список Категория риска в блоке Объекты проведения КНМ

    String listResultButton = "//*[@id='results']/div[1]//button"; // кнопка Добавить в блоке Список результатов
    String objectKNMDropDown = "//div[contains(@id, 'objectsResults')]/div[2]/div[1]/div[2]"; // Объект проведения КНМ в блоке Список результатов
    String dateTimeActField = "//div[contains(@id, 'objectsResults')]/div[2]/div[2]/div[2]//input"; // Дата и время составления акта о проведении КНМ в блоке Список результатов
    String resultAddressField = "//textarea[@name='objectsResults[0].actAddress']"; // Место составления акта о проведении КНМ в блоке Список результатов
    String resultAddressTypeDropDown = "//div[contains(@id, 'objectsResults')]/div[2]/div[4]/div[2]/div[1]"; // Тип места в блоке Список результатов
    String dateTimeKNMField = "//div[contains(@id, 'objectsResults')]/div[2]/div[5]/div[2]//input"; // Дата и время проведения КНМ в блоке Список результатов

    String addInspectorsButton = "//div[@id='inspectorsTitle']";
    String inspectorsDropDown = "//li[contains(@id,'inspectors')]/div[1]/div[1]";

    String actionButton = "//div[contains(@class, 'KnmHeader_Header')]//div[contains(@class, 'KnmHeaderButtons_Container')]/div/button"; // кнопка Действия

    // Значения переменных для создания проверки
    public String numberOrders = "122345"; // Номер приказа
    public String legalGroundsConducting = "НПА"; // Название нормативно-правового акта
    public String goalsTasksSubject = "Автотест"; // Поле Цели, задачи, предмет КНМ
    public String durationEventDays = "30"; // Срок проведения (дней)
    public String durationEventHours = "30"; // Срок проведения (часов)
    public String listControlMeasures = "Автотест"; // Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
    public String nameINN = "Тест"; // Наименование проверяемого лица
    public String address = "Автотест"; // Местонахождение в блоке Объекты проведения КНМ

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param view Вид КНМ
     */
    @Step("Выбор из выпадающего списка Вид КНМ - {view}")
    public void setViewKNMDropDown(String view) {
        $(By.xpath(viewKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        clickToText(view); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка форма КНМ
     *
     * @param form Значение поля
     */
    @Step("Выбор из выпадающего списка форма КНМ - {form}")
    public void setFormKMNDropDown(String form) {
        $(By.xpath(formKMNDropDown)).click(); // клик на выпадающем списке форма КНМ
        clickToText(form); // клик на нужной форме КНМ
    }

    /**
     * Выбор из выпадающего списка тип субъекта КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор из выпадающего списка тип субъекта КНМ - {type}")
    public void setTypeSubjectDropDown(String type) {
        $(By.xpath(typeSubjectDropDown)).click(); // клик на выпадающем списке тип субъекта КНМ
        clickToText(type); // клик на нужном типе субъекта КНМ
    }

    /**
     * Заполнение поля Номер приказа
     *
     * @param number Номер приказа
     */
    @Step("Заполнение поля Номер приказа - {number}")
    public void setNumberOrdersField(String number) {
        $(By.xpath(numberOrdersField)).setValue(number);
    }

    /**
     * Заполнение поля Дата приказа
     */
    @Step("Заполнение поля Дата приказа текущей датой")
    public void setDateOrdersField(String date) {
        $(By.xpath(dateOrdersField)).setValue(date);
    }

    /**
     * Заполнение поля Дата начала КНМ
     */
    @Step("Заполнение поля Дата начала КНМ. Значение поля - текущая дата - 1 день")
    public void setDateStartKNMField(String date) {
//        Calendar calendar = GregorianCalendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(GregorianCalendar.DAY_OF_MONTH, -1);
//        $(By.xpath(dateStartKNMField)).setValue(new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
        $(By.xpath(dateStartKNMField)).setValue(date);
    }

    /**
     * Заполнение поля Дата окончания КНМ
     */
    @Step("Заполнение поля Дата окончания КНМ. Значение поля - текущая дата + 2 дня")
    public void setDateStopKNMField(String date) {
//        Calendar calendar = GregorianCalendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(GregorianCalendar.DAY_OF_MONTH, 2);
        $(By.xpath(dateStopKNMField)).setValue(date);
    }

    /**
     * Выбор значения в выпадающем списке Месяц проведения КНМ
     * @param month номер месяца
     */
    //TODO Доделать
    public void setMonthKNMDropDown(Integer month){
        $(By.xpath(monthKNMDropDown)).click(); // клик на выпадающем списке Месяц проведения КНМ
        System.out.println($(By.xpath(monthKNMDropDown)).innerHtml());
        //clickToText(month); // клик на нужном месяце
    }

    /**
     * Нажатие на кнопку Добавить в разделе Правовые основания проведения КНМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Правовые основания проведения КНМ")
    public void clickAddLegalGroundsConductingButton() {
        $(By.xpath(addLegalGroundsConductingButton)).click();
    }

    /**
     * Нажатие на радиобатон Отсутствует в справочнике
     */
    @Step("Нажатие на радиобатон Отсутствует в справочнике")
    public void clickAbsenceDirectoryRadioButton() {
        $(By.xpath(absenceDirectoryRadioButton)).click();
    }

    /**
     * Заполнение поля Нормативно-правовые акты
     *
     * @param npa НПА
     */
    @Step("Заполнение поля Нормативно-правовые акты - {npa}")
    public void setLegalGroundsConductingField(String npa) {
        $(By.xpath((LegalGroundsConductingField))).setValue(npa);
    }

    /**
     * Нажатие на кнопку Сохранить в модальном окне Выберите нормативно-правовые акты
     */
    @Step("Нажатие на кнопку Сохранить в модальном окне Выберите нормативно-правовые акты")
    public void clickSaveLegalGroundsConductingButton() {
        $(By.xpath(saveLegalGroundsConductingButton)).click();
    }

    /**
     * Заполнение поля Цели, задачи, предмет КНМ
     *
     * @param text Значение поля
     */
    @Step("Заполнение поля Цели, задачи, предмет КНМ - {text}")
    public void setGoalsTasksSubjectField(String text) {
        $(By.xpath(goalsTasksSubjectField)).setValue(text);
    }

    /**
     * Заполнение поля Срок проведения (дней)
     *
     * @param days Значение поля
     */
    @Step("Заполнение поля Срок проведения (дней) - {days}")
    public void setDurationEventDaysField(String days) {
        $(By.xpath(durationEventDaysField)).setValue(days);
    }

    /**
     * Заполнение поля Срок проведения (часов)
     *
     * @param hours Значение поля
     */
    @Step("Заполнение поля Срок проведения (часов) - {hours}")
    public void setDurationEventHoursField(String hours) {
        $(By.xpath(durationEventHoursField)).setValue(hours);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ")
    public void clickAddListControlMeasuresButton() {
        $(By.xpath(addListControlMeasuresButton)).click();
    }

    /**
     * Заполнение поля в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
     *
     * @param text Значение поля
     */
    @Step("Заполнение поля в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ - {text}")
    public void setListControlMeasuresField(String text) {
        $(By.xpath(listControlMeasuresField)).setValue(text);
    }

    /**
     * Нажатие на кнопку Добавить в блоке Основания регистрации КНМ
     */
    @Step("Нажатие на кнопку Добавить в блоке Основания регистрации КНМ")
    public void clickAddGroundRegistrationButton() {
        $(By.xpath(addGroundRegistrationButton)).click();
    }

    /**
     * Заполнение выпадающего списка Основание регистрации КНМ
     */
    @Step("Заполнение выпадающего списка Основание регистрации КНМ")
    public void setGroundRegistrationDropDown() {
        $(By.xpath(groundRegistrationDropDown)).click();
        clickToText(groundRegistration);
    }

    /**
     * Выбор из выпадающего списка Наименование органа контроля
     *
     * @param name Орган контроля
     */
    @Step("Выбор из выпадающего списка Наименование органа контроля - {name}")
    public void setNameKNODropDown(String name) {
        $(By.xpath(nameKNODropDown)).click(); // клик на выпадающем списке Наименование органа контроля
        clickToText(name); // клик на нужной организации
    }

    /**
     * Выбор из выпадающего списка Вид контроля
     *
     * @param kind вид контроля
     */
    @Step("Выбор из выпадающего списка Вид контроля - {kind}")
    public void setKindControlDropDown(String kind) {
        $(By.xpath(kindControlDropDown)).click(); // клик на выпадающем списке Вид контроля
        clickToText(kind); // клик на нужном виде контроля
    }

    /**
     * Заполнение поля ИНН и выбор значения из появившегося окна
     *
     * @param INN  ИНН
     * @param name Наименование проверяемого лица
     */
    @Step("Заполнение поля ИНН и выбор значения из появившегося окна - {INN} - {name}")
    public void setInnField(String INN, String name) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(namePersonCheckField)).setValue(name);
        //$(By.xpath(innListField)).click();
    }

    /**
     * Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки
     *
     * @param addedTest true - заполнение ранее добавленными значениями, false - выбор любого значения из списка
     */
    @Step("Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки")
    public void setMandatoryRequirementsDropDown(boolean addedTest) {
        $(By.xpath(addMandatoryRequirementsButton)).scrollIntoView(false).click(); // Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки
        $(By.xpath(mandatoryRequirementsDropDown)).click(); // Открытие выпадающего списка ОТ
        if (addedTest)
            $(By.xpath(mandatoryRequirementsDropDown +
                    "//div[contains(@class,'select-field__menu-list')]//div[contains(text(), '" +
                    templateMandatoryRequirements + "')]")).click();
        else {
            System.out.println($(By.xpath(mandatoryRequirementsDropDown)).innerHtml());
            $(By.xpath(mandatoryRequirementsDropDown +
                    "//div[contains(@class,'select-field__menu-list')]/div[1]")).click();
        }
        $(By.xpath(saveButtonMandatoryRequirementsButton)).click();
    }

    /**
     * Проверка существования КНМ на странице Список проверок
     *
     * @param knm    Номер КНМ
     * @param exist  Должна ли найтись проверка с указанным статусом
     * @param status Наименование статуса, на который нужно провести проверку
     */
    @Step("Проверка существования КНМ на странице Список проверок - {knm}, {status}, {exist}")
    public void checkKNM(String knm, String status, boolean exist) {
        if (exist)
            $(By.xpath(knmListCell)).should(Text.text(knm)).parent().should(Text.text(status));
        else
            $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Нажатие на кнопку Добавить в блоке Объекты проведения КНМ
     */
    @Step("Нажатие на кнопку Добавить в блоке Объекты проведения КНМ")
    public void clickObjectsKNMButton() {
        $(By.xpath(objectsKNMButton + "//..//..")).click();
        $(By.xpath(objectsKNMButton)).scrollIntoView(false).click();
    }

    /**
     * Заполнение поля Местонахождение в блоке Объекты проведения КНМ
     *
     * @param location Местонахождение
     */
    @Step("Заполнение поля Местонахождение в блоке Объекты проведения КНМ - {location}")
    public void setAddressField(String location) {
        $(By.xpath(addressField)).setValue(location);
    }

    /**
     * Выбор значений в выпадающем списке Тип места в блоке Объекты проведения КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор значений в выпадающем списке Тип места в блоке Объекты проведения КНМ {type}")
    public void setAddressTypeDropDown(String type) {
        $(By.xpath(addressTypeDropDown)).click();
        clickToText(type);
    }

    /**
     * Выбор значения в выпадающем списке Тип объекта проведения в блоке Объекты проведения КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор значения в выпадающем списке Тип объекта проведения в блоке Объекты проведения КНМ - {type}")
    public void setTypeObjectDropDown(String type) {
        $(By.xpath(typeObjectDropDown)).click();
        clickToText(type);
    }

    /**
     * Выбор значения в выпадающем списке Категория риска в блоке Объекты проведения КНМ
     *
     * @param risk Значение поля
     */
    @Step("Выбор значения в выпадающем списке Категория риска в блоке Объекты проведения КНМ - {risk}")
    public void setRiskCategoryDropDown(String risk) {
        $(By.xpath(riskCategoryDropDown)).click();
        clickToText(risk);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Список результатов
     */
    @Step("Нажатие на кнопку Добавить в разделе Список результатов")
    public void clickListResultButton() {
        $(By.xpath(listResultButton)).click();
    }

    /**
     * Выбор значения в выпадающем списке Объекты проведения КНМ в блоке Список результатов
     */
    @Step("Выбор значения в выпадающем списке Объекты проведения КНМ в блоке Список результатов")
    public void setObjectKNMDropDown() {
        $(By.xpath(objectKNMDropDown)).click();
        $(By.xpath(objectKNMDropDown + "//div[contains(@class,'select-field__menu-list')]/div[1]")).click();
    }

    /**
     * Ввод даты формирования акта
     *
     * @param date Дата формирования акта
     */
    @Step("Ввод даты формирования акта")
    public void setDateTimeActField(String date) {
        $(By.xpath(dateTimeActField)).setValue(date);
    }

    /**
     * Выбор значения в выпадающем списке Место составления акта о проведении КНМ в блоке Список результатов
     *
     * @param location Значение поля
     */
    @Step("Выбор значения в выпадающем списке Место составления акта о проведении КНМ в блоке Список результатов - {location}")
    public void setResultAddressField(String location) {
        $(By.xpath(resultAddressField)).setValue(location);
    }

    /**
     * Выбор значения в выпадающем списке Тип места в блоке Список результатов
     *
     * @param type Значение поля
     */
    @Step("Выбор значения в выпадающем списке Тип места в блоке Список результатов - {type}")
    public void setResultAddressTypeDropDown(String type) {
        $(By.xpath(resultAddressTypeDropDown)).click();
        clickToText(type);
    }

    /**
     * Заполнение поля Дата и время проведения КНМ в блоке Список результатов
     */
    @Step("Заполнение поля Дата и время проведения КНМ в блоке Список результатов")
    public void setDateTimeKNMField(String dateTime) {
        $(By.xpath(dateTimeKNMField)).setValue(dateTime);
    }

    /**
     * Заполнение блока Уполномоченные на проведение КНМ
     *
     * @param addedTest true - заполнение созданными ранее данными, false - случайный выбор значения поля
     */
    @Step("Заполнение блока Уполномоченные на проведение КНМ - {addedTest}")
    public void setResresentativesDropDown(boolean addedTest) {
        $(By.xpath(addInspectorsButton)).click();
        $(By.xpath(inspectorsDropDown)).click();
        System.out.println($(By.xpath(inspectorsDropDown)).innerHtml());
        if (addedTest)
            $(By.xpath(inspectorsDropDown +
                    "//div[contains(@class, 'SelectInput_Option')]")).should(Condition.text(resresentative)).click();
        else
            $(By.xpath(inspectorsDropDown + "//div[contains(@class, 'SelectInput_Option')][1]")).click();
    }

    /**
     * Нажатие на кнопку Действия на странице КНМ
     */
    @Step("Нажатие на кнопку Действия на странице КНМ")
    public void clickActionsButton() {
        $(By.xpath(actionButton)).click();
    }

    /**
     * Создание внеплановой проверки
     *
     * @param dateOrders              Дата приказа
     * @param dateStart               Дата начала КНМ
     * @param dateStop                Дата окончания КНМ
     * @param isMandatoryRequirements - true - Берется обязательное требование, созданное автотестом
     * @param isResresentatives       - true - Берется уполномоченный, созданный автотестом
     */
    @Step("Создание внеплановой проверки - {dateOrders}, {dateStart}, {dateStop}, {isMandatoryRequirements}, " +
            "{isResresentatives}")
    public String createUnscheduledEvent(String dateOrders, String dateStart, String dateStop,
                                         boolean isMandatoryRequirements, boolean isResresentatives) {
        clickAddButton();
        setViewKNMDropDown(unscheduledCheck);
        setFormKMNDropDown(exitAndDocumentaryForm);
        setTypeSubjectDropDown(legalEntity);
        setNumberOrdersField(numberOrders);
        setDateOrdersField(dateOrders);
        setDateStartKNMField(dateStart);
        setDateStopKNMField(dateStop);
        clickAddLegalGroundsConductingButton();
        clickAbsenceDirectoryRadioButton();
        setLegalGroundsConductingField(legalGroundsConducting);
        clickSaveLegalGroundsConductingButton();
        setGoalsTasksSubjectField(goalsTasksSubject);
        setDurationEventDaysField(durationEventDays);
        setDurationEventHoursField(durationEventHours);
        clickAddListControlMeasuresButton();
        setListControlMeasuresField(listControlMeasures);
        clickAddGroundRegistrationButton();
        setGroundRegistrationDropDown();
        setNameKNODropDown(nameKNO);
        setKindControlDropDown(viewKNOERP);
        setInnField(INN, nameINN);
        setMandatoryRequirementsDropDown(isMandatoryRequirements);
        setResresentativesDropDown(isResresentatives);
        clickSaveButton();
        closeNotification();
        return $(By.xpath(KNMNumberText)).getText().split(" ")[1];
    }

    /**
     * Создание внеплановой проверки
     *
     * @param dateOrders              Дата приказа
     * @param dateStart               Дата начала КНМ
     * @param dateStop                Дата окончания КНМ
     * @param isMandatoryRequirements - true - Берется обязательное требование, созданное автотестом
     * @param isResresentatives       - true - Берется уполномоченный, созданный автотестом
     */
    // TODO Доделать
    @Step("Создание плановой проверки - {dateOrders}, {dateStart}, {dateStop}, {isMandatoryRequirements}, " +
            "{isResresentatives}")
    public String createScheduledEvent(String dateOrders, String dateStart, String dateStop,
                                         boolean isMandatoryRequirements, boolean isResresentatives) {
        clickAddButton();
        setViewKNMDropDown(scheduleCheck);
        setFormKMNDropDown(exitAndDocumentaryForm);
        setTypeSubjectDropDown(legalEntity);
        //setNumberOrdersField(numberOrders);
        //setDateOrdersField(dateOrders);
        setDateStartKNMField(dateStart);
        //setDateStopKNMField(dateStop);

        setMonthKNMDropDown(1);
        clickAddLegalGroundsConductingButton();
        clickAbsenceDirectoryRadioButton();
        setLegalGroundsConductingField(legalGroundsConducting);
        clickSaveLegalGroundsConductingButton();
        setGoalsTasksSubjectField(goalsTasksSubject);
        setDurationEventDaysField(durationEventDays);
        setDurationEventHoursField(durationEventHours);
        clickAddListControlMeasuresButton();
        setListControlMeasuresField(listControlMeasures);
        clickAddGroundRegistrationButton();
        setGroundRegistrationDropDown();
        setNameKNODropDown(nameKNO);
        setKindControlDropDown(viewKNOERP);
        setInnField(INN, nameINN);
        setMandatoryRequirementsDropDown(isMandatoryRequirements);
        setResresentativesDropDown(isResresentatives);
        clickSaveButton();
        closeNotification();
        return $(By.xpath(KNMNumberText)).getText().split(" ")[1];
    }
}
