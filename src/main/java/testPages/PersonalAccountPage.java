package testPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    //TODO: переделать xpath
    //String nameOrganizationField = "//*[contains(@class,'SelectInput_Indicators')] "; // выпадающий список Организация
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
    public void clickPersonalAccount() {
        $(By.xpath(menuButton)).click();
        $(By.xpath(personalAccount)).click();
    }

    /**
     * Скролл по странице в начало
     */
    public void scrollTopHtml(){
        $(By.xpath("//h1[contains(@class, 'PersonalAccount_Header')]")).scrollIntoView(false);
    }

    /**
     * Переход в Раздел общая информация
     */
    public void gotoCommonInformationMenu() {
        clickToText(commonInformation);
    }

    /**
     * Переход в раздел Уполномоченные на проведение КНМ
     */
    public void goToAuthorizedToConductMenu() {
        clickToText(authorizedToConduct);
    }

    /**
     * Переход в раздел Проверочные листы
     */
    public void goToCheckSheetsMenu() {
        clickToText(checkSheets);
    }

    /**
     * Переход в раздел Обязательные требования
     */
    public void goToMandatoryRequirementsMenu() {
        clickToText(mandatoryRequirements);
    }


    /**
     * Заполнение поля ФИО
     */
    public void setNameField(String name) {
        $(By.xpath(nameField)).setValue(name);
    }

    /**
     * Заполнение поля Должность
     */
    public void setPositionField(String position) {
        $(By.xpath(positionField)).setValue(position);
    }

    /**
     * Выбор типа проверяющего
     */
    public void setTypeInspectorDropDown(String type) {
        $(By.xpath(typeFieldDropDown)).click(); // клик на выпадающем списке Тип проверяющего
        $(By.xpath("//*[text()='" + type + "']")).click(); // клик на нужном типе
    }

    /**
     * Нажатие на вторую запись в списке обязательных требований и проверочных листов (проверка готовночти страницы к созданию новых записей)
     */
    public void clickToTemplateRecord(){
        $(By.xpath("//ul[contains(@class, 'TemplatesList')]//li[2]")).click();
    }

    /**
     * Заполнение поля наименование в проверочных листах и обязательные требования
     */
    public void setTemplateNameField(String name) {
        $(By.xpath(templateNameField)).shouldHave(Condition.empty).setValue(name);
    }

    /**
     * Заполнение поля Сведения об утверждении
     */
    public void setApprovalDetailsField(String details) {
        $(By.xpath(approvalDetailsField)).setValue(details);
    }

    /**
     * Заполнение поля Вопрос в разделе контрольные вопросы
     */
    public void setQuestionField(String question) {
        $(By.xpath(questionField)).setValue(question);
    }

    /**
     * Заполнение поля Реквизиты в разделе контрольные вопросы
     */
    public void setRequisitesField(String requisites) {
        $(By.xpath(requisitesField)).setValue(requisites);
    }

    /**
     * Заполнение поля Организация
     */
    public void setNameOrganizationFieldDropDown(String name) {
        $(By.xpath(nameOrganizationFieldDropDown)).click();
        clickToText(name);
    }

    /**
     * Заполнение поля Вид государственного контроля (надзора)
     */
    public void setTypeOrganizationFieldDropDown(String type) {
        $(By.xpath(typeOrganizationFieldDropDown)).click();
        clickToText(type);
    }

    /**
     * Заполнение поля Формулировка обязательного требования
     */
    public void setFormulationField(String data) {
        $(By.xpath(formulationField)).setValue(data);
    }

    /**
     * Заполнение поля Наименования НПА
     */
    public void setNameNPAField(String name) {
        $(By.xpath(nameNPAField)).setValue(name);
    }

    /**
     * Заполнение поля Номер НПА
     */
    public void setNumberNPAField(String number) {
        $(By.xpath(numberNPAField)).setValue(number);
    }

    /**
     * Заполнение поля Дата НПА
     */
    public void setDateNPAField() {
        String dateStr = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        $(By.xpath(dateNPAField)).setValue(dateStr);
    }

    /**
     * Нажатие на кнопке Добавить требования
     */
    public void clickAddRequirementsButton() {
        $(By.xpath(addRequirements)).click();
    }

    /**
     * Нажатие на кнопке Добавить контрольный вопрос
     */
    public void clickAddSecurityQuestionButton() {
        $(By.xpath(addSecurityQuestion)).click();
    }

    /**
     * Проверка созданного уполномоченного на проведение КНМ
     */
    public void checkResresentatives(String name) {
        $(By.xpath("//*[@value='" + name + "']")).shouldBe(com.codeborne.selenide.Condition.visible);

    }


}
