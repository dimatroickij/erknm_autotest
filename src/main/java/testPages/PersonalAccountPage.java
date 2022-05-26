package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.UUID;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage extends Common {

    //разделы личного кабинета

    public String commonInformation = "//*[@id='/private/lk/info']/a"; // Общая информация
    public String authorizedToConduct = "//*[@id='/private/lk/authorized-to-conduct']/a"; // Уполномоченные на проведение КНМ
    public String checkSheets = "//*[@id='/private/lk/check-sheets']/a"; // Проверочные листы
    public String mandatoryRequirementsButton = "//*[@id='/private/lk/requirements']/a"; // Раздел Обязательные требования
    public String settings = "//*[@id='/private/lk/settings']/a"; // Настройки
    public String managementUsers = "//*[@id='/private/lk/users']/a"; // Управление пользователями
    public String managementDirectories = "//*[@id='/private/lk/catalogs']/a"; // Управление справочниками
    public String managementSchedule = "//*[@id='/private/lk/exports']/a"; // Управление расписанием
    public String downloadingDirectories = "//*[@id='/private/lk/catalogs-update']/a"; // Загрузка справочников
    public String managementNews = "//*[@id='/private/lk/news']/a"; // Управление новостями
    public String typeStateControl = "Выборочный контроль качества биомедицинских клеточных продуктов.";
    public String personalAccount = "//*[@id='personalAccountButton']"; // Кнопка "Личный кабинет"

    // поля для добавления уполномоченных
    String authorizedToConductAddButton = "//*[@id='authorizedToConductAddButton']"; // Кнопка Добавить в Уполномоченных на проведение КНМ
    String nameField = "//*[@name='inspectors[0].fullName']";
    String nameFieldSearch = "//*[contains(@name, 'fullName') and contains(text(), '%s')]";
    String positionField = "//*[@name='inspectors[0].position']";
    String positionFieldSearch = "//*[contains(@name, 'position') and contains(text(), '%s')]";
    String typeFieldDropDown = "//*[@id='inspectors[0].type']";

    //поля для проверочных листов
    String checkListsAddButton = "//*[@id='checkListsAddButton']"; // Кнопка Добавить в шаблонах проверочных листов
    String templateNameField = "//*[@name='templateName']";
    String approvalDetailsField = "//*[@name='approvalDetails']";
    String questionField = "//*[@name='questions[0].question']";
    String requisitesField = "//*[@name='questions[0].npaProps']";

    //поля для обязательных требований
    String addMandatoryRequirementsButton = "//*[@id='userRequirementsAddButton']"; // Кнопка Добавить в шаблонах обязательных требований
    String nameOrganizationFieldDropDown = "//*[@id='organisation']"; // Выпадающий список Организация
    String typeOrganizationFieldDropDown = "//*[@id='supervisionType']"; //Выпадающий список Вид государственного контроля (надзора)
    String addRequirements = "//*[@id='requirementsAddButton']"; // кнопка Добавить требования
    String addSecurityQuestion = "//*[@id='questionAddButton']"; // кнопка Добавить контрольные вопросы
    String formulationField = "//*[@name='requirements[0].props']"; //формулировка обязательного требования
    String nameNPAField = "//*[@name='requirements[0].name']"; // наименование НПА
    String numberNPAField = "//*[@name='requirements[0].number']"; // номер НПА
    String dateNPAField = "//*[contains(@class,'DatePicker_Input_')]"; //Дата НПА TODO должен быть идентификатор
    String recordLine = "//ul[contains(@class, 'TemplatesList')]//li[2]"; // Шаблон для выбора обязательного требования или проверочного листа из списка в личном кабинете TODO должен быть идентификатор
    String recordLineByText = "//ul[contains(@class, 'TemplatesList')]//li//div[contains(text(), '%s')]"; // Шаблон для поиска нужного обязательного требования
    String allRecordLine = "//ul[contains(@class, 'TemplatesList')]//li//div"; // Список всех наименований обязательных требований
    String defaultOrganizationLine = "//label[contains(text(), '%s')]"; // Строка с названием организации в списке доступных организаций TODO должен быть идентификатор
    String inputRepresentatives = "//*[@value='%s']"; //

    public String prefixName = UUID.randomUUID().toString(); // Идентификатор для наименования проверочного листа / обязательного требования / уполномоченного
    public String templateName = " авто Наименование"; // Шаблон наименования обязательного требования и проверочного лист
    String formulationTemplate = " авто Формулировка"; // Шаблон формулировки обязательного требования
    String nameNPATemplate = " авто Наименование НПА"; // Шаблон Название НПА обязательного требования
    String approvalDetailsTemplate = " авто Сведения"; // Шаблон Сведения об утверждении
    String questionTemplate = " авто Вопрос"; // Шаблон Вопрос
    String requisitesTemplate = " авто Реквизиты"; // Шаблон Реквизиты
    public String representativeTemplate = " авто ФИО"; // ФИО
    String positionTemplate = " авто Должность"; // Должность
    String typeInspector = "Проверяющий";
    String typeExpert = "Эксперт";

    public PersonalAccountPage() throws Exception {
    }

    /**
     * Переход в личный кабинет
     */
    @Step("Переход в личный кабинет")
    public void clickPersonalAccount() {
        $(By.xpath(menuButton)).click();
        $(By.xpath(personalAccount)).click();
    }

    /**
     * Переход в Раздел общая информация
     */
    @Step("Переход в Раздел общая информация")
    public void gotoCommonInformationMenu() {
        clickToText(commonInformation);
    }

    /**
     * Переход в раздел Уполномоченные на проведение КНМ
     */
    @Step("Переход в раздел Уполномоченные на проведение КНМ")
    public void goToAuthorizedToConductMenu() {
        $(By.xpath(authorizedToConduct)).click();
    }

    /**
     * Переход в раздел Проверочные листы
     */
    @Step("Переход в раздел Проверочные листы")
    public void goToCheckSheetsMenu() {
        $(By.xpath(checkSheets)).click();
    }

    /**
     * Переход в раздел Обязательные требования
     */
    @Step("Переход в раздел Обязательные требования")
    public void goToMandatoryRequirementsMenu() {
        $(By.xpath(mandatoryRequirementsButton)).click();
    }

    /**
     * Заполнение поля ФИО
     *
     * @param name ФИО
     */
    @Step("Заполнение поля ФИО - {name}")
    public void setNameField(String name) {
        $(By.xpath(nameField)).setValue(name);
    }

    /**
     * Заполнение поля Должность
     *
     * @param position Должность
     */
    @Step("Заполнение поля Должность - {position}")
    public void setPositionField(String position) {
        $(By.xpath(positionField)).setValue(position);
    }

    /**
     * Выбор типа проверяющего
     *
     * @param type Тип проверяющего
     */
    @Step("Выбор типа проверяющего - {type}")
    public void setTypeInspectorDropDown(String type) {
        $(By.xpath(typeFieldDropDown)).click(); // клик на выпадающем списке Тип проверяющего
        setValueDropDownToText(type); // клик на нужном типе
    }

    /**
     * Нажатие на вторую запись в списке обязательных требований и проверочных листов (проверка готовночти страницы к созданию новых записей)
     */
    @Step("Нажатие на вторую запись в списке обязательных требований и проверочных листов (проверка готовности страницы к созданию новых записей)")
    public void clickToTemplateRecord() {
        $(By.xpath(recordLine)).click();
    }

    /**
     * Заполнение поля наименование в проверочных листах и обязательные требования
     *
     * @param name Значение поля
     */
    @Step("Заполнение поля наименование в проверочных листах и обязательные требования - {name}")
    public void setTemplateNameField(String name) {
        $(By.xpath(templateNameField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(templateNameField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(templateNameField)).shouldHave(Condition.empty).setValue(name);
    }

    /**
     * Заполнение поля Сведения об утверждении
     *
     * @param details Значение поля
     */
    @Step("Заполнение поля Сведения об утверждении - {details}")
    public void setApprovalDetailsField(String details) {
        $(By.xpath(approvalDetailsField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(approvalDetailsField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(approvalDetailsField)).shouldHave(Condition.empty).setValue(details);
    }

    /**
     * Заполнение поля Вопрос в разделе контрольные вопросы
     *
     * @param question Вопрос
     */
    @Step("Заполнение поля Вопрос в разделе контрольные вопросы - {question}")
    public void setQuestionField(String question) {
        $(By.xpath(questionField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(questionField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(questionField)).shouldHave(Condition.empty).setValue(question);
    }

    /**
     * Заполнение поля Реквизиты в разделе контрольные вопросы
     *
     * @param requisites Реквизиты
     */
    @Step("Заполнение поля Реквизиты в разделе контрольные вопросы - {requisites}")
    public void setRequisitesField(String requisites) {
        $(By.xpath(requisitesField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(requisitesField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(requisitesField)).shouldHave(Condition.empty).setValue(requisites);
    }

    /**
     * Заполнение поля Организация
     *
     * @param name организация
     */
    @Step("Заполнение поля Организация - {name}")
    public void setNameOrganizationFieldDropDown(String name) {
        $(By.xpath(nameOrganizationFieldDropDown)).click();
        setValueDropDownToText(name);
    }

    /**
     * Заполнение поля Вид государственного контроля (надзора)
     *
     * @param type Вид государственного контроля
     */
    @Step("Заполнение поля Вид государственного контроля (надзора) - {type}")
    public void setTypeOrganizationFieldDropDown(String type) {
        $(By.xpath(typeOrganizationFieldDropDown)).click();
        setValueDropDownToText(type);
    }

    /**
     * Заполнение поля Формулировка обязательного требования
     *
     * @param data - Формулировка обязательного требования
     */
    @Step("Заполнение поля Формулировка обязательного требования - {data}")
    public void setFormulationField(String data) {
        $(By.xpath(formulationField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(formulationField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(formulationField)).shouldHave(Condition.empty).setValue(data);
    }

    /**
     * Заполнение поля Наименования НПА
     *
     * @param name Наименование НПА
     */
    @Step("Заполнение поля Наименования НПА - {name}")
    public void setNameNPAField(String name) {
        $(By.xpath(nameNPAField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(nameNPAField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(nameNPAField)).shouldHave(Condition.empty).setValue(name);
    }

    /**
     * Заполнение поля Номер НПА
     *
     * @param number Номер НПА
     */
    @Step("Заполнение поля Номер НПА - {number}")
    public void setNumberNPAField(String number) {
        $(By.xpath(numberNPAField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(numberNPAField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(numberNPAField)).shouldHave(Condition.empty).setValue(number);
    }

    /**
     * Заполнение поля Дата НПА
     *
     * @param date Дата НПА
     */
    @Step("Заполнение поля Дата НПА")
    public void setDateNPAField(String date) {
        $(By.xpath(dateNPAField)).should(exist).sendKeys(Keys.CONTROL + "A"); // Выделение текста в поле
        $(By.xpath(dateNPAField)).sendKeys(Keys.BACK_SPACE); // Очистка поля
        $(By.xpath(dateNPAField)).shouldHave(Condition.empty).setValue(date);
    }

    /**
     * Нажатие на кнопку Добавить требования
     */
    @Step("Нажатие на кнопку Добавить требования")
    public void clickAddRequirementsButton() {
        $(By.xpath(addRequirements)).click();
    }

    /**
     * Нажатие на кнопку Добавить контрольный вопрос
     */
    @Step("Нажатие на кнопку Добавить контрольный вопрос")
    public void clickAddSecurityQuestionButton() {
        $(By.xpath(addSecurityQuestion)).click();
    }

    /**
     * Проверка созданного уполномоченного на проведение КНМ
     *
     * @param name ФИО уполномоченного
     */
    @Step("Проверка созданного уполномоченного на проведение КНМ - {name}")
    public void checkRepresentatives(String name) {
        $(By.xpath(String.format(inputRepresentatives, name))).shouldBe(Condition.visible);
    }

    /**
     * Выбор организации по умолчанию
     *
     * @param name Название КНО
     */
    @Step("Выбор организации по умолчанию - {name}")
    public void setOrganization(String name) {
        $(By.xpath(commonInformation)).click();
        $(By.xpath(String.format(defaultOrganizationLine, name))).click();
        clickSaveButton();
    }

    /**
     * Нажатие на кнопку Добавить в Шаблонах обязательных требований
     */
    @Step("Нажатие на кнопку Добавить в Шаблонах обязательных требований")
    public void clickAddMandatoryRequirementsButton() {
        $(By.xpath(addMandatoryRequirementsButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить в Шаблонах проверочных листов
     */
    @Step("Нажатие на кнопку Добавить в Шаблонах проверочных листов")
    public void clickCheckListsAddButton() {
        $(By.xpath(checkListsAddButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить в Уполномоченных на проведение КНМ
     */
    @Step("Нажатие на кнопку Добавить в Уполномоченных на проведение КНМ")
    public void clickAuthorizedToConductAddButton() {
        $(By.xpath(authorizedToConductAddButton)).click();
    }

    /**
     * Создание шаблона обязательных требований
     *
     * @param code Уникальный код каждой записи
     */
    @Step("Создание шаблона обязательных требований {code}")
    public void createTemplateMandatoryRequirements(String code) {
        clickToTemplateRecord();
        clickAddMandatoryRequirementsButton();
        setTemplateNameField(code + templateName);
        setNameOrganizationFieldDropDown(nameKNO);
        setTypeOrganizationFieldDropDown(typeStateControl);
        clickAddRequirementsButton();
        setFormulationField(code + formulationTemplate);
        setNameNPAField(code + nameNPATemplate);
        setNumberNPAField("1");
        setDateNPAField(currentDate);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Редактирование шаблона обязательных требований
     *
     * @param lastCode Старый код
     * @param newCode  Новый код
     */
    @Step("Редактирование шаблона обязательных требований {lastCode} {newCode}")
    public void editTemplateMandatoryRequirements(String lastCode, String newCode) {
        $(By.xpath(String.format(recordLineByText + "/../../button", lastCode))).click();
        setTemplateNameField(newCode + templateName);
        setNameOrganizationFieldDropDown(nameKNO);
        setTypeOrganizationFieldDropDown(typeStateControl);
        setFormulationField(newCode + formulationTemplate);
        setNameNPAField(newCode + nameNPATemplate);
        setNumberNPAField("1");
        setDateNPAField(currentDate);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Удаление шаблона обязательных требований или проверочного листа
     *
     * @param code Код
     */
    @Step("Удаление шаблона обязательных требований или проверочного листа {code}")
    public void deleteTemplateMandatoryRequirementsOrSheets(String code) {
        $(By.xpath(String.format(recordLineByText + "/../..//button[2]", code))).click();
        clickConfirmButton();
        closeNotification();
    }

    /**
     * Создание шаблона проверочных листов
     *
     * @param code Уникальный код каждой записи
     */
    @Step("Создание шаблона проверочных листов {code}")
    public void createTemplateSheets(String code) {
        clickToTemplateRecord();
        clickCheckListsAddButton();
        setTemplateNameField(code + templateName);
        setNameOrganizationFieldDropDown(nameKNO);
        setApprovalDetailsField(code + approvalDetailsTemplate);
        clickAddSecurityQuestionButton();
        setQuestionField(code + questionTemplate);
        setRequisitesField(code + requisitesTemplate);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Редактирование шаблона проверочных листов
     *
     * @param lastCode Старый код
     * @param newCode  Новый код
     */
    @Step("Редактирование шаблона проверочных листов {lastCode} {newCode}")
    public void editTemplateSheets(String lastCode, String newCode) {
        $(By.xpath(String.format(recordLineByText + "/../../button", lastCode))).click();
        setTemplateNameField(newCode + templateName);
        setNameOrganizationFieldDropDown(nameKNO);
        setApprovalDetailsField(newCode + approvalDetailsTemplate);
        setQuestionField(newCode + questionTemplate);
        setRequisitesField(newCode + requisitesTemplate);
        clickSaveButton();
        closeNotification();
    }

    /**
     * Проверка на существование обязательного требования
     *
     * @param code  Уникальный код записи
     * @param exist Должна ли найтись запись
     */
    @Step("Проверка на существование обязательного требования {code} {exist}")
    public void checkTemplateMandatoryRequirements(String code, boolean exist) {
        if (exist) {
            $(By.xpath(String.format(recordLineByText + "/../../button", code))).click();
            $(By.xpath(templateNameField)).should(Text.value(code + templateName));
            $(By.xpath(formulationField)).should(Text.value(code + formulationTemplate));
            $(By.xpath(nameNPAField)).should(Text.value(code + nameNPATemplate));
        } else $(By.xpath(allRecordLine)).shouldNot(Text.text(code));
    }

    /**
     * Проверка на существование проверочного листа
     *
     * @param code  Уникальный код записи
     * @param exist Должна ли найтись запись
     */
    @Step("Проверка на существование проверочного листа {code} {exist}")
    public void checkTemplateSheets(String code, boolean exist) {
        if (exist) {
            $(By.xpath(String.format(recordLineByText + "/../../button", code))).click();
            $(By.xpath(templateNameField)).should(Text.value(code + templateName));
            $(By.xpath(approvalDetailsField)).should(Text.value(code + approvalDetailsTemplate));
            $(By.xpath(questionField)).should(Text.value(code + questionTemplate));
            $(By.xpath(requisitesField)).should(Text.value(code + requisitesTemplate));
        } else $(By.xpath(allRecordLine)).shouldNot(Text.text(code));
    }

    /**
     * Проверка на существование уполномоченного
     *
     * @param code  Уникальный код записи
     * @param exist Должна ли найтись запись
     */
    @Step("Проверка на существование уполномоченного {code} {exist}")
    public void checkRepresentatives(String code, boolean exist) {
        if (exist) {
            $(By.xpath(String.format(nameFieldSearch, code))).should(Text.text(code));
            $(By.xpath(String.format(positionFieldSearch, code))).should(Text.text(code));
        } else {
            $(By.xpath(nameFieldSearch)).shouldNot(Text.text(code));
            $(By.xpath(positionFieldSearch)).shouldNot(Text.text(code));
        }
    }

    /**
     * Создание уполномоченных на проведение КНМ
     *
     * @param code Уникальный код каждой записи
     */
    @Step("Создание уполномоченных на проведение КНМ {code}")
    public void createRepresentatives(String code) {
        clickAuthorizedToConductAddButton();
        setNameField(code + representativeTemplate);
        setPositionField(code + positionTemplate);
        setTypeInspectorDropDown(typeInspector);
        clickSaveButton();
        closeNotification();
    }
//
//    /**
//     * Редактирование уполномоченного
//     *
//     * @param lastCode Старый код
//     * @param newCode  Новый код
//     */
//    @Step("Редактирование уполномоченного {lastCode} {newCode}")
//    public void editRepresentatives(String lastCode, String newCode) {
//        $(By.xpath(String.format(nameFieldSearch, lastCode)));
//        $(By.xpath(String.format(positionFieldSearch, lastCode)));
//        setNameField(newCode + representativeTemplate);
//        setPositionField(newCode + positionTemplate);
//        setTypeInspectorDropDown(typeInspector);
//        clickSaveButton();
//        closeNotification();
//    }

    /**
     * Удаление уполномоченного
     *
     * @param code Код
     */
    @Step("Удаление уполномоченного {code}")
    public void deleteRepresentatives(String code) {
        $(By.xpath(String.format(nameFieldSearch, code) + "/../..//button")).click();
        clickConfirmButton();
        closeNotification();
    }
}
