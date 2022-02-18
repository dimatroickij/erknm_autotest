package testPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage extends Common {

    //разделы личного кабинета

    public String commonInformation = "Общая информация";
    public String authorizedToConduct = "Уполномоченные на проведение КНМ";
    public String checkSheets = "Проверочные листы";
    public String mandatoryRequirements = "Обязательные требования";
    public String settings = "Настройки";
    public String managementUsers = "Управление пользователями";
    public String managementDirectories = "Управление справочниками";
    public String managementSchedule = "Управление расписанием";
    public String downloadingDirectories = "Загрузка справочников";
    public String managementNews = "Управление новостями";
    public String typeStateControl = "Выборочный контроль качества биомедицинских клеточных продуктов.";

    public String personalAccount = "//*[contains(@class,'DropdownItem_MenuButton') and contains(string(), 'Личный кабинет')]";
    // поля для добавления уполномоченных
    String nameField = "//*[@name='inspectors[0].fullName']";
    String positionField = "//*[@name='inspectors[0].position']";
    String typeFieldDropDown = "//*[text()='Тип проверяющего']";

    //поля для проверочных листов
    String templateNameField = "//*[@name='templateName']";
    String approvalDetailsField = "//*[@name='approvalDetails']";
    String questionField = "//*[@name='questions[0].question']";
    String requisitesField = "//*[@name='questions[0].npaProps']";

    //поля для обязательных требований
    String nameOrganizationFieldDropDown = "//form/div[2]/div[2]/div[1]/div/div[1]"; // выпадающий список Организация
    String typeOrganizationFieldDropDown = "//form/div[3]/div[2]/div[1]/div/div[1]"; //Выпадающий список Вид государственного контроля (надзора)
    String addRequirements = "//form/div[4]/button"; // кнопка Добавить требования
    String addSecurityQuestion = "//form/div[4]/button"; // кнопка Добавить контрольные вопросы
    String formulationField = "//*[@name='requirements[0].props']";//формулировка обязательного требования
    String nameNPAField = "//*[@name='requirements[0].name']"; // наименование НПА
    String numberNPAField = "//*[@name='requirements[0].number']"; // номер НПА
    String dateNPAField = "//*[contains(@class,'DatePicker_Input_')]";//Дата НПА


    /**
     * Переход в личный кабинет
     */
    @Step("Переход в личный кабинет")
    public void clickPersonalAccount() {
        $(By.xpath(menuButton)).click();
        $(By.xpath(personalAccount)).click();
    }

    /**
     * Скролл по странице в начало
     */
    @Step("Скролл по странице в начало")
    public void scrollTopHtml() {
        $(By.xpath("//h1[contains(@class, 'PersonalAccount_Header')]")).scrollIntoView(false);
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
        clickToText(authorizedToConduct);
    }

    /**
     * Переход в раздел Проверочные листы
     */
    @Step("Переход в раздел Проверочные листы")
    public void goToCheckSheetsMenu() {
        clickToText(checkSheets);
    }

    /**
     * Переход в раздел Обязательные требования
     */
    @Step("Переход в раздел Обязательные требования")
    public void goToMandatoryRequirementsMenu() {
        clickToText(mandatoryRequirements);
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
    @Step("Нажатие на вторую запись в списке обязательных требований и проверочных листов (проверка готовночти страницы к созданию новых записей)")
    public void clickToTemplateRecord() {
        $(By.xpath("//ul[contains(@class, 'TemplatesList')]//li[2]")).click();
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
        $(By.xpath("//*[@value='" + name + "']")).shouldBe(com.codeborne.selenide.Condition.visible);
    }

    /**
     * Выбор организации по умолчанию
     *
     * @param name Название КНО
     */
    @Step("Выбор организации по умолчанию - {name}")
    public void setOrganization(String name){
        clickToText(commonInformation);
        $(By.xpath(String.format("//label[contains(text(), '%s')]", name))).click();
        clickSaveButton();
    }

}
