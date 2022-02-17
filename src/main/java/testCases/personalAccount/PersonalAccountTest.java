package testCases.personalAccount;

import org.testng.annotations.Test;
import testPages.PersonalAccountPage;

import java.util.Random;

public class PersonalAccountTest extends PersonalAccountPage {
    String typeInspector = "Проверяющий";
    String typeExpert = "Эксперт";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    //проверки в Личном кабинете для ЕРП

    /**
     * Цель: Создание шаблонов обязательных требований (для ЕРП)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=43
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание шаблонов обязательных требований (для ЕРП)")
    public void createTemplateMandatoryRequirementsERPTest() {
        authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickPersonalAccount();
        scrollTopHtml();
        goToMandatoryRequirementsMenu();
        clickToTemplateRecord();
        clickAddButton();
        templateMandatoryRequirements = prefix + "авто Наименование";
        setTemplateNameField(templateMandatoryRequirements);
        setNameOrganizationFieldDropDown(nameKNO);
        setTypeOrganizationFieldDropDown(typeStateControl);
        clickAddRequirementsButton();
        setFormulationField(prefix + "авто Формулировка");
        setNameNPAField(prefix + "авто Наименование НПА");
        setNumberNPAField(prefix + "1");
        setDateNPAField(currentDate);
        clickSaveButton();
        checkObject(prefix + "авто Наименование");
        closeNotification();
        logout();
    }

    /**
     * Цель: Создание шаблонов проверочных листов (для ЕРП)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=42
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРП)")
    public void createTemplateTestSheetsERPTest() {
        authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickPersonalAccount();
        scrollTopHtml();
        goToCheckSheetsMenu();
        clickToTemplateRecord();
        clickAddButton();
        templateSheets = prefix + "авто Наименование";
        setTemplateNameField(templateSheets);
        setNameOrganizationFieldDropDown(nameKNO);
        setApprovalDetailsField(prefix + "авто Сведения");
        clickAddSecurityQuestionButton();
        setQuestionField(prefix + "авто Вопрос");
        setRequisitesField(prefix + "авто Реквизиты");
        clickSaveButton();
        checkObject(prefix + "авто Наименование");
        closeNotification();
        logout();
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРП)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=291
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРП)")
    public void addRepresentativesERPTest() {
        authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickPersonalAccount();
        scrollTopHtml();
        goToAuthorizedToConductMenu();
        clickAddButton();
        resresentative = prefix + "авто ФИО";
        setNameField(resresentative);
        setPositionField(prefix + "авто Должность");
        setTypeInspectorDropDown(typeInspector);
        clickSaveButton();
        checkRepresentatives(prefix + "авто ФИО");
        closeNotification();
        logout();
    }
}
