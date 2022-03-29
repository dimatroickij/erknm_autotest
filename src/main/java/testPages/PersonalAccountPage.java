package testPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

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
    String positionField = "//*[@name='inspectors[0].position']";
    String typeFieldDropDown = "//*[@id='inspectors[0].type']";

    //поля для проверочных листов
    String checkListsAddButton = "//*[@id='checkListsAddButton']"; // Кнопка Добавить в шаблонах проверочных листов
    String templateNameField = "//*[@name='templateName']";
    String approvalDetailsField = "//*[@name='approvalDetails']";
    String questionField = "//*[@name='questions[0].question']";
    String requisitesField = "//*[@name='questions[0].npaProps']";

    //поля для обязательных требований
    String addMandatoryRequirementsButton = "//*[@id='userRequirementsAddButton']"; // Кнопка Добавить в шаблонах обязательных требований
    String nameOrganizationFieldDropDown = "//*[@id='organisation']"; // выпадающий список Организация
    String typeOrganizationFieldDropDown = "//*[@id='supervisionType']"; //Выпадающий список Вид государственного контроля (надзора)
    String addRequirements = "//*[@id='requirementsAddButton']"; // кнопка Добавить требования
    String addSecurityQuestion = "//*[@id='questionAddButton']"; // кнопка Добавить контрольные вопросы
    String formulationField = "//*[@name='requirements[0].props']"; //формулировка обязательного требования
    String nameNPAField = "//*[@name='requirements[0].name']"; // наименование НПА
    String numberNPAField = "//*[@name='requirements[0].number']"; // номер НПА
    String dateNPAField = "//*[contains(@class,'DatePicker_Input_')]"; //Дата НПА TODO должен быть идентификатор
    String recordLine = "//ul[contains(@class, 'TemplatesList')]//li[2]"; // Шаблон для выбора обязательного требования или проверочного листа из списка в личном кабинете TODO должен быть идентификатор
    String defaultOrganizationLine = "//label[contains(text(), '%s')]"; // Строка с названием организации в списке доступных организаций TODO должен быть идентификатор
    String inputRepresentatives = "//*[@value='%s']"; //


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
        $(By.xpath(templateNameField)).shouldHave(Condition.empty).setValue(name);
    }

    /**
     * Заполнение поля Сведения об утверждении
     *
     * @param details Значение поля
     */
    @Step("Заполнение поля Сведения об утверждении - {details}")
    public void setApprovalDetailsField(String details) {
        $(By.xpath(approvalDetailsField)).setValue(details);
    }

    /**
     * Заполнение поля Вопрос в разделе контрольные вопросы
     *
     * @param question Вопрос
     */
    @Step("Заполнение поля Вопрос в разделе контрольные вопросы - {question}")
    public void setQuestionField(String question) {
        $(By.xpath(questionField)).setValue(question);
    }

    /**
     * Заполнение поля Реквизиты в разделе контрольные вопросы
     *
     * @param requisites Реквизиты
     */
    @Step("Заполнение поля Реквизиты в разделе контрольные вопросы - {requisites}")
    public void setRequisitesField(String requisites) {
        $(By.xpath(requisitesField)).setValue(requisites);
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
        $(By.xpath(formulationField)).setValue(data);
    }

    /**
     * Заполнение поля Наименования НПА
     *
     * @param name Наименование НПА
     */
    @Step("Заполнение поля Наименования НПА - {name}")
    public void setNameNPAField(String name) {
        $(By.xpath(nameNPAField)).setValue(name);
    }

    /**
     * Заполнение поля Номер НПА
     *
     * @param number Номер НПА
     */
    @Step("Заполнение поля Номер НПА - {number}")
    public void setNumberNPAField(String number) {
        $(By.xpath(numberNPAField)).setValue(number);
    }

    /**
     * Заполнение поля Дата НПА
     *
     * @param date Дата НПА
     */
    @Step("Заполнение поля Дата НПА")
    public void setDateNPAField(String date) {
        $(By.xpath(dateNPAField)).setValue(date);
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

}
