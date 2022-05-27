package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListEventsERPPage extends Common {
    //Список проверок
    String viewKNMDropDown = "//*[@id='type']"; //выпадающий список Вид КНМ
    String formKMNDropDown = "//*[@id='kind']"; //Выпадающий список Форма КНМ
    String typeSubjectDropDown = "//*[@id='subjectType']"; // Выпадающий список Тип субъекта КНМ
    String numberOrdersField = "//*[@name='orderNumber']"; //поле Номер приказа
    String dateOrdersField = "//*[@id='orderDateBlock']//input"; // поле Дата приказа TODO Должен быть идентификатор
    String dateStartKNMField = "//*[@id='startDateBlock']//input"; //поле Дата начала КНМ TODO Должен быть идентификатор
    String dateStopKNMField = "//*[@id='stopDateBlock']//input"; //поле Дата окончания КНМ TODO Должен быть идентификатор
    String monthKNMDropDown = "//*[@id='monthBlock']//div[2]"; // Выпадающий список Месяц проведения КНМ TODO Должен быть идентификатор

    String addLegalGroundsConductingButton = "//*[@id='legalBasesTitle']//button"; //кнопка Добавить в разделе Правовые основания проведения КНМ TODO Должен быть идентификатор
    String absenceDirectoryRadioButton = "//*[@id='legalBasesNotExist']"; //радиобатон Отсутствует в справочнике
    String LegalGroundsConductingField = "//*[@name='notExistLegalBasisText']"; // поле для ввода в разделе Выберите нормативно-правовые акты
    String goalsTasksSubjectField = "//*[@name='inspectionTarget']"; // текстовое поле Цели, задачи, предмет КНМ
    String durationEventDaysField = "//*[@id='durationDays']"; //поле Срок проведения (дней)
    String durationEventHoursField = "//*[@id='durationHours']";//поле Срок проведения (часов)

    String addListControlMeasuresButton = "//*[@id='knmErpEventsAddButton']"; // кнопка Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
    String listControlMeasuresField = "//textarea[@name='events[0].name']"; // поле для ввода в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ

    String addGroundRegistrationButton = "//*[@id='reasonsTitleBlock']//button"; // кнопка Добавить в разделе Основания регистрации  КНМ TODO должен быть идентификатор
    String groundRegistrationDropDown = "//*[@id ='reasons[0].type']"; //выпадающий список Основание регистрации КНМ

    String nameKNODropDown = "//div[@id='knoOrganizationBlock']/div[2]"; //выпадающий список Наименование органа контроля TODO должен быть идентификатор
    String kindControlDropDown = "//*[@id='supervisionTypeBlock']/div[2]"; // выпадающий список Вид государственного контроля (надзора) TODO должен быть идентификатор

    String innField = "//*[@id='inn']"; //ИНН
    String innListField = "//li[contains(@class,'AutoComplete_OptionItem')]"; // Появившийся спискок ИНН

    String namePersonCheckField = "//*[@name='organizationName']"; // Наименование проверяемого лица

    String addMandatoryRequirementsButton = "//*[@id='requirements']//button"; // кнопка Добавить в блоке Подлежащие проверке обязательные требования TODO должен быть идентификатор

    String addTemplateSheetsButton = "//*[@id='check-sheets']/div[2]//button"; // кнопка Добавить в блоке Проверочные листы TODO должен быть идентификатор
    String modalTemplateDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[2]"; // Выпадающий список в модальном окне Добавление проверочного листа TODO должен быть идентификатор

    String templateSheetsObjectDropDown = "//section[contains(@id, 'check-sheets')]//div[contains(@class, 'KnmCollapse_Body')]/div[4]/div[1]/div[2]"; // Объект проведения КНМ в блоке Проверочные листы TODO должен быть идентификатор

    String KNMNumberText = "//h3[contains(@class, 'KnmInfo_Title')]"; // Заголовок на странице с КНМ, в котором находится номер КНМ TODO должен быть идентификатор
    String knmListCell = "//td[contains(@class, 'KnmListTable_CellErpId')]"; // ячейка с номером КНМ из списка КНМ на страние Список проверок

    String deleteObjectButton = "//button[contains(@class, 'KnmCollapse_DeleteButton')]"; // крестик у блока Объект в разделе Объекты проведения КНМ TODO должен быть идентификатор
    String objectsKNMButton = "//*[@id='objectsBlock']/div[1]//button"; // Кнопка Добавить в блоке "Объекты проведения КНМ" TODO должен быть идентификатор
    String addressField = "//*[@name='objects[0].addressText']"; // поле Местоположение в блоке Объекты проведения КНМ
    String addressTypeDropDown = "//*[@id='objects[0].addressType']"; // Выпадающий список Тип места в блоке Объекты проведения КНМ
    String typeObjectDropDown = "//*[@id='objects[0].objectType']"; // Выпадающий список Тип объекта проведения в блоке Объекты проведения КНМ
    String riskCategoryDropDown = "//*[@id='objects[0].riskCategory']"; // Выпадающий список Категория риска в блоке Объекты проведения КНМ

    String listResultButton = "//*[@id='results']/div[1]//button"; // кнопка Добавить в блоке Список результатов TODO должен быть идентификатор
    String objectKNMDropDown = "//div[contains(@id, 'objectsResults')]/div[2]/div[1]/div[1]/div[2]"; // Объект проведения КНМ в блоке Список результатов TODO должен быть идентификатор
    String dateTimeActField = "//div[contains(@id, 'objectsResults')]/div[2]/div[2]/div[1]/div[2]//input"; // Дата и время составления акта о проведении КНМ в блоке Список результатов TODO должен быть идентификатор
    String resultAddressField = "//*[@name='objectsResults[0].actAddress']"; // Место составления акта о проведении КНМ в блоке Список результатов
    String resultAddressTypeDropDown = "//div[contains(@id, 'objectsResults')]/div[2]/div[4]/div[1]/div[2]/div[1]"; // Тип места в блоке Список результатов TODO должен быть идентификатор
    String dateTimeKNMField = "//div[contains(@id, 'objectsResults')]/div[2]/div[5]/div[1]/div[2]//input"; // Дата и время проведения КНМ в блоке Список результатов TODO должен быть идентификатор

    String addInspectorsButton = "//div[@id='inspectorsTitle']//button"; // Кнопка Добавить в блоке Уполномоченные на проведение проверки TODO должен быть идентификатор
    String inspectorsDropDown = "//div[@id='inspectorsTitle']/div[2]/div[1]/div[1]/div[1]/div[1]"; // Выпадающий список ФИО уполномоченного TODO должен быть идентификатор

    public String groundRegistration = "1.2.27 (99-ФЗ) Наличие приказа (распоряжения), изданного лицензирующим органом в соответствии с поручением Президента Российской Федерации или Правительства Российской Федерации.";
    public String groundPlannedRegistration = "1.1.4 Повторное КНМ в связи с отсутствием или фактическим неосуществлением деятельности или иным действием (бездействием) проверяемого лица повлекшим невозможность проведения КНМ.";

    // Значения переменных для создания проверки
    public String numberOrders = "122345"; // Номер приказа
    public String legalGroundsConducting = "НПА"; // Название нормативно-правового акта
    public String goalsTasksSubject = "Автотест"; // Поле Цели, задачи, предмет КНМ
    public String durationEventDays = "30"; // Срок проведения (дней)
    public String durationEventHours = "30"; // Срок проведения (часов)
    public String listControlMeasures = "Автотест"; // Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
    public String nameINN = "Тест"; // Наименование проверяемого лица
    public String address = "Автотест"; // Местонахождение в блоке Объекты проведения КНМ

    public ListEventsERPPage() throws Exception {
    }

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param view Вид КНМ
     */
    @Step("Выбор из выпадающего списка Вид КНМ - {view}")
    public void setViewKNMDropDown(String view) {
        $(By.xpath(viewKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        setValueDropDownToText(view); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка форма КНМ
     *
     * @param form Значение поля
     */
    @Step("Выбор из выпадающего списка форма КНМ - {form}")
    public void setFormKMNDropDown(String form) {
        $(By.xpath(formKMNDropDown)).click(); // клик на выпадающем списке форма КНМ
        setValueDropDownToText(form); // клик на нужной форме КНМ
    }

    /**
     * Выбор из выпадающего списка тип субъекта КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор из выпадающего списка тип субъекта КНМ - {type}")
    public void setTypeSubjectDropDown(String type) {
        $(By.xpath(typeSubjectDropDown)).click(); // клик на выпадающем списке тип субъекта КНМ
        setValueDropDownToText(type); // клик на нужном типе субъекта КНМ
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
        $(By.xpath(dateStartKNMField)).setValue(date);
    }

    /**
     * Заполнение поля Дата окончания КНМ
     */
    @Step("Заполнение поля Дата окончания КНМ. Значение поля - текущая дата + 2 дня")
    public void setDateStopKNMField(String date) {
        $(By.xpath(dateStopKNMField)).setValue(date);
    }

    /**
     * Выбор значения в выпадающем списке Месяц проведения КНМ
     *
     * @param month номер месяца
     */
    public void setMonthKNMDropDown(Integer month) {
        $(By.xpath(monthKNMDropDown)).click(); // клик на выпадающем списке Месяц проведения КНМ
        setValueDropDownToNumber(month);
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
     *
     * @param text Основание регистрации КНМ
     */
    @Step("Заполнение выпадающего списка Основание регистрации КНМ")
    public void setGroundRegistrationDropDown(String text) {
        $(By.xpath(groundRegistrationDropDown)).click();
        setValueDropDownToText(text);
    }

    /**
     * Выбор из выпадающего списка Наименование органа контроля
     *
     * @param name Орган контроля
     */
    @Step("Выбор из выпадающего списка Наименование органа контроля - {name}")
    public void setNameKNODropDown(String name) {
        $(By.xpath(nameKNODropDown)).click(); // клик на выпадающем списке Наименование органа контроля
        setValueDropDownToText(name); // клик на нужной организации
    }

    /**
     * Выбор из выпадающего списка Вид контроля
     *
     * @param kind вид контроля
     */
    @Step("Выбор из выпадающего списка Вид контроля - {kind}")
    public void setKindControlDropDown(String kind) {
        $(By.xpath(kindControlDropDown)).click(); // клик на выпадающем списке Вид контроля
        setValueDropDownToText(kind); // клик на нужном виде контроля
    }

    /**
     * Заполнение поля ИНН и выбор значения из появившегося окна
     *
     * @param INN ИНН
     */
    @Step("Заполнение поля ИНН и выбор значения из появившегося окна - {INN}")
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).click();
    }

    /**
     * Заполнение блока Обязательные требования, подлежащие проверке
     *
     * @param addedTest true - заполнение ранее добавленными значениями, false - выбор любого значения из списка
     */
    @Step("Заполнение блока Обязательные требования, подлежащие проверке")
    public void setMandatoryRequirementsDropDown(boolean addedTest) {
        $(By.xpath(addMandatoryRequirementsButton)).scrollIntoView(false).click(); // Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки
        clickModalTemplateDropDown(); // Открытие выпадающего списка ОТ
        if (addedTest) setValueDropDownToText(templateMandatoryRequirements);
        else {
            setValueDropDownToNumber(1);
        }
        clickAddModalButton();
    }

    /**
     * Проверка существования КНМ на странице Список проверок
     *
     * @param knm    Номер КНМ
     * @param exist  Должна ли найтись проверка с указанным статусом
     * @param status Наименование статуса, на который нужно провести проверку
     */
    // TODO Может не работать
    @Step("Проверка существования КНМ на странице Список проверок - {knm}, {status}, {exist}")
    public void checkKNM(String knm, String status, boolean exist) {
        if (exist) $(By.xpath(knmListCell)).should(Text.text(knm)).parent().should(Text.text(status));
        else $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Проверка существования КНМ на странице Список проверок
     *
     * @param knm   Номер КНМ
     * @param exist Должна ли найтись проверка с указанным статусом
     */
    @Step("Проверка существования КНМ на странице Список проверок - {knm}, {exist}")
    public void checkKNM(String knm, boolean exist) {
        if (exist) $(By.xpath(knmListCell)).should(Text.text(knm));
        else $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Нажатие на кнопку Добавить в блоке Объекты проведения КНМ
     */
    @Step("Нажатие на кнопку Добавить в блоке Объекты проведения КНМ")
    public void clickObjectsKNMButton() {
        $(By.xpath(objectsKNMButton + "//..//..")).click(); // ? TODO проверить работоспособность
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
        setValueDropDownToText(type);
    }

    /**
     * Выбор значения в выпадающем списке Тип объекта проведения в блоке Объекты проведения КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор значения в выпадающем списке Тип объекта проведения в блоке Объекты проведения КНМ - {type}")
    public void setTypeObjectDropDown(String type) {
        $(By.xpath(typeObjectDropDown)).click();
        setValueDropDownToText(type);
    }

    /**
     * Выбор значения в выпадающем списке Категория риска в блоке Объекты проведения КНМ
     *
     * @param risk Значение поля
     */
    @Step("Выбор значения в выпадающем списке Категория риска в блоке Объекты проведения КНМ - {risk}")
    public void setRiskCategoryDropDown(String risk) {
        $(By.xpath(riskCategoryDropDown)).click();
        setValueDropDownToText(risk);
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
        setValueDropDownToNumber(1);
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
     * Заполнение поля Место составления акта о проведении КНМ в блоке Список результатов
     *
     * @param location Значение поля
     */
    @Step("Заполнение поля Место составления акта о проведении КНМ в блоке Список результатов - {location}")
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
        setValueDropDownToText(type);
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
    public void setRepresentativesDropDown(boolean addedTest) {
        $(By.xpath(addInspectorsButton)).click();
        $(By.xpath(inspectorsDropDown)).click();
        if (addedTest) setValueDropDownToText(representative);
        else setValueDropDownToNumber(1);
    }

    /**
     * Создание внеплановой проверки
     *
     * @param dateOrders              Дата приказа
     * @param dateStart               Дата начала КНМ
     * @param dateStop                Дата окончания КНМ
     * @param groundRegistration      Основание регистрации КНМ
     * @param isMandatoryRequirements true - Берется обязательное требование, созданное автотестом
     * @param isResresentatives       true - Берется уполномоченный, созданный автотестом
     * @param isDeleteObject          Удаление объекта проведения КНМ, который создался автоматически из-за поиска ИНН
     * @param isNewObject             true - В карточке Объекты проведения КНМ не было заполнено автоматически Местонахождение и Тип места
     */
    @Step("Создание внеплановой проверки - {dateOrders}, {dateStart}, {dateStop}, {isMandatoryRequirements}, " + "{isResresentatives}, {isDeleteObject}, {isNewObject}")
    public String createUnscheduledEvent(String dateOrders, String dateStart, String dateStop, String groundRegistration, boolean isMandatoryRequirements, boolean isResresentatives, boolean isDeleteObject, boolean isNewObject) {
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
        clickModalSaveButton();
        setGoalsTasksSubjectField(goalsTasksSubject);
        setDurationEventDaysField(durationEventDays);
        setDurationEventHoursField(durationEventHours);
        clickAddListControlMeasuresButton();
        setListControlMeasuresField(listControlMeasures);
        return fillingCard(groundRegistration, isMandatoryRequirements, isResresentatives, isDeleteObject, isNewObject);
    }

    /**
     * Создание плановой проверки
     *
     * @param dateStart               Дата начала КНМ
     * @param groundRegistration      Основание регистрации КНМ
     * @param isMandatoryRequirements true - Берется обязательное требование, созданное автотестом
     * @param isResresentatives       true - Берется уполномоченный, созданный автотестом
     * @param isDeleteObject          Удаление объекта проведения КНМ, который создался автоматически из-за поиска ИНН
     * @param isNewObject             true - В карточке Объекты проведения КНМ не было заполнено автоматически Местонахождение и Тип места
     * @return Номер созданной КНМ
     */
    @Step("Создание плановой проверки - {dateOrders}, {dateStart}, {dateStop}, {isMandatoryRequirements}, " + "{isResresentatives}, {isDeleteObject}, {isNewObject}")
    public String createScheduledEvent(String dateStart, String groundRegistration, boolean isMandatoryRequirements, boolean isResresentatives, boolean isDeleteObject, boolean isNewObject) {
        clickAddButton();
        setViewKNMDropDown(scheduleCheck);
        setFormKMNDropDown(exitAndDocumentaryForm);
        setTypeSubjectDropDown(legalEntity);
        setDateStartKNMField(dateStart);
        setMonthKNMDropDown(Integer.parseInt(dateStart.split("\\.")[1]));
        setGoalsTasksSubjectField(goalsTasksSubject);
        setDurationEventDaysField(durationEventDays);
        setDurationEventHoursField(durationEventHours);
        return fillingCard(groundRegistration, isMandatoryRequirements, isResresentatives, isDeleteObject, isNewObject);
    }

    /**
     * Общий код для заполнения карточки плановой и внеплановой КНМ
     *
     * @param groundRegistration      Основание регистрации КНМ
     * @param isMandatoryRequirements true - Берется обязательное требование, созданное автотестом
     * @param isRepresentative        true - Берется уполномоченный, созданный автотестом
     * @param isDeleteObject          true - Удаление объекта проведения КНМ, который создался автоматически из-за поиска ИНН
     * @param isNewObject             true - В карточке Объекты проведения КНМ не было заполнено автоматически Местонахождение и Тип места
     * @return Номер созданной КНМ
     */
    @Step("Общий код для заполнения карточки плановой и внеплановой КНМ {groundRegistration}, {isMandatoryRequirements}," + " {isRepresentative}, {isDeleteObject}, {isDeleteObject}, {isNewObject}")
    private String fillingCard(String groundRegistration, boolean isMandatoryRequirements, boolean isRepresentative, boolean isDeleteObject, boolean isNewObject) {
        clickAddGroundRegistrationButton();
        setGroundRegistrationDropDown(groundRegistration);
        setNameKNODropDown(nameKNO);
        setKindControlDropDown(viewKNOERP);
        setInnField(INN);
        if (isDeleteObject) $(By.xpath(deleteObjectButton)).click();
        else {
            setObjectKNM(address, locationLE, branch, righRisk, isNewObject);
        }
        setMandatoryRequirementsDropDown(isMandatoryRequirements);
        setRepresentativesDropDown(isRepresentative);
        clickSaveButton();
        closeNotification();
        return $(By.xpath(KNMNumberText)).getText().split(" ")[1];
    }

    /**
     * Заполнение блока Проверочные листы
     *
     * @param addedTest true - заполнение ранее добавленными значениями, false - выбор любого значения из списка
     */
    @Step("Заполнение блока Проверочные листы {addedTest}")
    public void setTemplateSheetsDropDown(boolean addedTest) {
        $(By.xpath(addTemplateSheetsButton)).scrollIntoView(false).click();
        clickModalTemplateDropDown();
        if (addedTest) setValueDropDownToText(templateSheets);
        else setValueDropDownToNumber(1);
        clickAddModalButton();
        $(By.xpath(templateSheetsObjectDropDown)).click();
        setValueDropDownToNumber(1);
    }

    /**
     * Заполнение блока Объекты проведения КНМ
     *
     * @param address     Местонахождение
     * @param locationLE  Тип места
     * @param branch      Тип объекта проведения
     * @param righRisk    Категория риска
     * @param isNewObject true - В карточке Объекты проведения КНМ не было заполнено автоматически Местонахождение и Тип места
     */
    @Step("Заполнение блока Объекты проведения КНМ {address}, {locationLE}, {branch}, {righRisk}, {isNewObject}")
    public void setObjectKNM(String address, String locationLE, String branch, String righRisk, boolean isNewObject) {
        if (isNewObject) {
            clickObjectsKNMButton();
            setAddressField(address);
            setAddressTypeDropDown(locationLE);
        }
        setTypeObjectDropDown(branch);
        setRiskCategoryDropDown(righRisk);
    }

    /**
     * Нажатие на выпадающий список в модальном окне Добавление обязательного требования и Добавление проверочных листов
     */
    @Step("Нажатие на выпадающий список в модальном окне Добавление обязательного требования и Добавление проверочных листов")
    public void clickModalTemplateDropDown() {
        $(By.xpath(modalTemplateDropDown)).click();
    }
}
