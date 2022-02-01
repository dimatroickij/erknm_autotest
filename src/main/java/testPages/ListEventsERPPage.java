package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ListEventsERPPage extends Common {
    //Список проверок
    String actionButton = "//div[contains(@class, 'KnmHeader_Header')]//div[contains(@class, 'KnmHeaderButtons_Container')]/div/button"; // кнопка Действия
    String viewKNMDropDown = "//form/div[2]/div[1]/div[1]/div[2]/div"; //выпадающий список Вид КНМ
    String formKMNDropDown = "//form/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]"; //Выпадающий список Форма КНМ
    String typeSubjectDropDown = "//form/div[2]/div[1]/div[3]/div[2]/div[1]/div/div[1]"; //выпадающий список Тип субъекта КНМ
    String numberOrdersField = "//*[@name='orderNumber']"; //поле Номер приказа
    //String dateOrdersField = "/html/body/div/div/main/form/div[2]/div[2]/div[3]/div[2]/div[1]/div/div/input"; // поле Дата приказа
    String dateOrdersField = "//*[@id='orderDateBlock']/div[2]/div[1]/div/div/input"; // поле Дата приказа
    // String dateStartKNMField = "/html/body/div/div/main/form/div[2]/div[2]/div[5]/div[2]/div[1]/div/div/input"; //поле Дата начала КНМ
    String dateStartKNMField = "//*[@id='startDateBlock']/div[2]/div[1]/div/div/input"; //поле Дата начала КНМ
    //String dateStopKNMField = "/html/body/div/div/main/form/div[2]/div[2]/div[6]/div[2]/div[1]/div/div/input"; //поле Дата окончания КНМ
    String dateStopKNMField = "//*[@id='stopDateBlock']/div[2]/div[1]/div/div/input"; //поле Дата окончания КНМ

    String addLegalGroundsConductingButton = "//*[@id='legalBasesTitle']/span/button"; //кнопка Добавить в разделе Правовые основания проведения КНМ
    String absenceDirectoryRadioButton = "//*[@id='legalBasesNotExist']"; //радиобатон Отсутствует в справочнике
    String LegalGroundsConductingField = "//html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/textarea[1]"; // поле для ввода в разделе Выберите нормативно-правовые акты
    String saveLegalGroundsConductingButton = "//body/div[2]/div[1]/div[3]/button[1]"; //кнопка Сохранить в разделе Выберите нормативно-правовые акты
    String goalsTasksSubjectField = "//*[@id='check-sheets']/div[3]/textarea"; // текстовое поле Цели, задачи, предмет КНМ
    String durationEventDaysField = "//*[@id='durationDays']"; //поле Срок проведения (дней)
    String durationEventHoursField = "//*[@id='durationHours']";//поле Срок проведения (часов)

    String addListControlMeasuresButton = "//*[@id='eventsBlock']/div/span/button"; // кнопка Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
    String listControlMeasuresField = "//*[@id='eventsBlock']/ul/li[1]//textarea"; // поле для ввода в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ

    String addGroundRegistrationButton = "//*[@id='reasonsTitleBlock']/span/button"; // кнопка Добавить в разделе Основания регистрации  КНМ
    String groundRegistrationDropDown = "//*[@id ='reasonsTitleBlock']/../ul/li[1]//div[contains(@class, 'SelectInput_Control')]"; //выпадающий список Основание регистрации КНМ
    String groundRegistration = "1.2.27 (99-ФЗ) Наличие приказа (распоряжения), изданного лицензирующим органом в соответствии с поручением Президента Российской Федерации или Правительства Российской Федерации.";

    String nameKNODropDown = "//*[@id='']"; //выпадающий список Наименование органа контроля
    String kindControlDropDown = "//*[@id='supervisionTypeBlock']/div[2]"; // выпадающий список Вид государственного контроля (надзора)

    String innField = "//*[@id='inn']"; //ИНН
    //String innListField = "//li[contains(@class,'AutoComplete_OptionItem')]"; //появившийся спискок ИНН

    String namePersonCheckField = "//*[@name='organizationName']";

    String addMandatoryRequirementsButton = "//*[@id='requirementsTitleBlock']//button";//кнопка Добавить в блоке Подлежащие проверке обязательные требования
    String mandatoryRequirementsDropDown = "//div[contains(@class, 'KnmErpRequirementsModal_Body')]/div[2]";//выпадающий список Обязательные требования
    String saveButtonMandatoryRequirementsButton = "//div[contains(@class, 'KnmErpRequirementsModal_Footer')]//*[text()='Добавить']";

    String KNMNumber = "//h3[contains(@class, 'KnmInfo_Title')]"; // Заголовок на странице с КНМ, в котором находится номер КНМ
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

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param view Вид КНМ
     */
    public void setViewKNMDropDown(String view) {
        $(By.xpath(viewKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        clickToText(view); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка форма КНМ
     *
     * @param form Значение поля
     */
    public void setFormKMNDropDown(String form) {
        $(By.xpath(formKMNDropDown)).click(); // клик на выпадающем списке форма КНМ
        clickToText(form); // клик на нужной форме КНМ
    }

    /**
     * Выбор из выпадающего списка тип субъекта КНМ
     *
     * @param type Значение поля
     */
    public void setTypeSubjectDropDown(String type) {
        $(By.xpath(typeSubjectDropDown)).click(); // клик на выпадающем списке тип субъекта КНМ
        clickToText(type); // клик на нужном типе субъекта КНМ
    }

    /**
     * Заполнение поля Номер приказа
     *
     * @param number Номер приказа
     */
    public void setNumberOrdersField(String number) {
        $(By.xpath(numberOrdersField)).setValue(number);
    }

    /**
     * Заполнение поля Дата приказа
     */
    public void setDateOrdersField() {
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        $(By.xpath(dateOrdersField)).setValue(currentDate);
    }

    /**
     * Заполнение поля Дата начала КНМ
     */
    public void setDateStartKNMField() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(GregorianCalendar.DAY_OF_MONTH, -1);
        $(By.xpath(dateStartKNMField)).setValue(new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
    }

    /**
     * Заполнение поля Дата окончания КНМ
     */
    public void setDateStopKNMField() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 2);
        $(By.xpath(dateStopKNMField)).setValue(new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
    }

    /**
     * Нажатие на кнопку Добавить в разделе Правовые основания проведения КНМ
     */
    public void clickAddLegalGroundsConductingButton() {
        $(By.xpath(addLegalGroundsConductingButton)).click();
    }

    /**
     * Нажатие на радиобатон Отсутствует в справочнике
     */
    public void clickAbsenceDirectoryRadioButton() {
        $(By.xpath(absenceDirectoryRadioButton)).click();
    }

    /**
     * Заполнение поля Нормативно-правовые акты
     *
     * @param text НПА
     */
    public void setLegalGroundsConductingField(String text) {
        $(By.xpath((LegalGroundsConductingField))).setValue(text);
    }

    /**
     * Нажатие на кнопку Сохранить в модальном окне Выберите нормативно-правовые акты
     */
    public void clickSaveLegalGroundsConductingButton() {
        $(By.xpath(saveLegalGroundsConductingButton)).click();
    }

    /**
     * Заполнение поля Цели, задачи, предмет КНМ
     *
     * @param text Значение поля
     */
    public void setGoalsTasksSubjectField(String text) {
        $(By.xpath(goalsTasksSubjectField)).setValue(text);
    }

    /**
     * Заполнение поля Срок проведения (дней)
     *
     * @param days Значение поля
     */
    public void setDurationEventDaysField(String days) {
        $(By.xpath(durationEventDaysField)).setValue(days);
    }

    /**
     * Заполнение поля Срок проведения (часов)
     *
     * @param hours Значение поля
     */
    public void setDurationEventHoursField(String hours) {
        $(By.xpath(durationEventHoursField)).setValue(hours);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
     */
    public void clickAddListControlMeasuresButton() {
        $(By.xpath(addListControlMeasuresButton)).click();
    }

    /**
     * Заполнение поля в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
     *
     * @param text Значение поля
     */
    public void setListControlMeasuresField(String text) {
        $(By.xpath(listControlMeasuresField)).setValue(text);
    }

    /**
     * Нажатие на кнопку Добавить в блоке Основания регистрации КНМ
     */
    public void clickAddGroundRegistrationButton() {
        $(By.xpath(addGroundRegistrationButton)).click();
    }

    /**
     * Заполнение выпадающего списка Основание регистрации КНМ
     */
    public void setGroundRegistrationDropDown() {
        $(By.xpath(groundRegistrationDropDown)).click();
        clickToText(groundRegistration);
    }

//    /**
//     * Выбор из выпадающего списка Наименование органа контроля
//     *
//     * @param name Орган контроля
//     */
//    public void setNameKNODropDown(String name) {
//        $(By.xpath(nameKNODropDown)).click(); // клик на выпадающем списке Наименование органа контроля
//        clickToText(name); // клик на нужной организации
//    }

    /**
     * Выбор из выпадающего списка Вид контроля
     *
     * @param kind вид контроля
     */
    public void setKindControlDropDown(String kind) {
        $(By.xpath(kindControlDropDown)).click(); // клик на выпадающем списке Вид контроля
        clickToText(kind); // клик на нужном виде контроля
    }

    /**
     * Заполнить поле ИНН, выбрать из появившегося окна
     */
    public void setInnField(String INN, String name) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(namePersonCheckField)).setValue(name);
        //$(By.xpath(innListField)).click();
    }

    /**
     * Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки
     */
    public void setMandatoryRequirementsDropDown() {
        $(By.xpath(addMandatoryRequirementsButton)).scrollIntoView(false).click(); // Нажатие на кнопку Добавить в блоке Обязательные требования, подлежащие проверки
        $(By.xpath(mandatoryRequirementsDropDown)).click(); // Открытие выпадающего списка ОТ
        $(By.xpath(mandatoryRequirementsDropDown + "//div[contains(@class,'select-field__menu-list')]/div[1]")).click();
        $(By.xpath(saveButtonMandatoryRequirementsButton)).click();
        //clickToText(addNewMandatoryRequirementsButton);
    }

    /**
     * Получение номера КНМ у созданной проверки
     *
     * @return Номер КНМ
     */
    public String getKnmNumber() {
        return $(By.xpath(KNMNumber)).getText().split(" ")[1];
    }

    /**
     * проверка смуществования КНМ на странице Список проверок
     *
     * @param knm Номер КНМ
     */
    public void checkKNM(String knm, String status, boolean exist) {
        Condition condition = exist ? appear : not(appear);
        if (exist)
            $(By.xpath(knmListCell)).should(Text.text(knm)).parent().should(Text.text(status));
        else
            $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }

    /**
     * Нажатие на кнопку Добавить в блоке Объекты проведения КНМ
     */
    public void clickObjectsKNMButton() {
        $(By.xpath(objectsKNMButton + "//..//..")).click();
        $(By.xpath(objectsKNMButton)).scrollIntoView(false).click();
    }

    /**
     * Заполнение поля Местонахождение в блоке Объекты проведения КНМ
     *
     * @param text Местонахождение
     */
    public void setAddressField(String text) {
        $(By.xpath(addressField)).setValue(text);
    }

    /**
     * Выбор значений в выпадающем списке Тип места в блоке Объекты проведения КНМ
     *
     * @param text Значение поля
     */
    public void setAddressTypeDropDown(String text) {
        $(By.xpath(addressTypeDropDown)).click();
        clickToText(text);
    }

    /**
     * Выбор значения в выпадающем списке Тип объекта проведения в блоке Объекты проведения КНМ
     *
     * @param text Значение поля
     */
    public void setTypeObjectDropDown(String text) {
        $(By.xpath(typeObjectDropDown)).click();
        clickToText(text);
    }

    /**
     * Выбор значения в выпадающем списке Категория риска в блоке Объекты проведения КНМ
     *
     * @param text Значение поля
     */
    public void setRiskCategoryDropDown(String text) {
        $(By.xpath(riskCategoryDropDown)).click();
        clickToText(text);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Список результатов
     */
    public void clickListResultButton() {
        $(By.xpath(listResultButton)).click();
    }

    /**
     * Выбор значения в выпадающем списке Объекты проведения КНМ в блоке Список результатов
     */
    public void setObjectKNMDropDown() {
        $(By.xpath(objectKNMDropDown)).click();
        $(By.xpath(objectKNMDropDown + "//div[contains(@class,'select-field__menu-list')]/div[1]")).click();
    }

    public void setDateTimeActField() {
        $(By.xpath(dateTimeActField)).setValue(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }

    /**
     * Выбор значения в выпадающем списке Место составления акта о проведении КНМ в блоке Список результатов
     * @param text Значение поля
     */
    public void setResultAddressField(String text) {
        $(By.xpath(resultAddressField)).setValue(text);
    }

    /**
     * Выбор значения в выпадающем списке Тип места в блоке Список результатов
     *
     * @param text Значение поля
     */
    public void setResultAddressTypeDropDown(String text) {
        $(By.xpath(resultAddressTypeDropDown)).click();
        clickToText(text);
    }

    /**
     * Заполнение поля Дата и время проведения КНМ в блоке Список результатов
     */
    public void setDateTimeKNMField() {
        $(By.xpath(dateTimeKNMField)).setValue(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()));
    }

    /**
     * Нажатие на кнопку Действия на странице Список проверок
     */
    public void clickActionsButton() {
        $(By.xpath(actionButton)).click();
    }
}
