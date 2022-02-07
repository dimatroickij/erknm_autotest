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
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание шаблонов обязательных требований (для ЕРП)")
    public void createTemplateMandatoryRequirementsERPTest() {
        authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickToText(nameSupervisor);
        clickPersonalAccount();
        goToMandatoryRequirementsMenu();
        clickAddButton();
        setTemplateNameField(prefix + "авто Наименование");
        setNameOrganizationFieldDropDown(nameKNO);
        setTypeOrganizationFieldDropDown(typeStateControl);
        clickAddRequirementsButton();
        setFormulationField(prefix + "авто Формулировка");
        setNameNPAField(prefix + "авто Наименование НПА");
        setNumberNPAField(prefix + "1");
        setDateNPAField(currentDate);
        clickSaveButton();
        checkObject(prefix + "авто Наименование");

    }

    /**
     * Цель: Создание шаблонов проверочных листов (для ЕРП)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРП)")
    public void createTemplateTestSheetsERPTest() {
        authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickToText(nameSupervisor);
        clickPersonalAccount();
        goToCheckSheetsMenu();
        clickAddButton();
        setTemplateNameField(prefix + "авто Наименование");
        setApprovalDetailsField(prefix + "авто Сведения");
        clickAddSecurityQuestionButton();
        setQuestionField(prefix + "авто Вопрос");
        setRequisitesField(prefix + "авто Реквизиты");
        clickSaveButton();
        checkObject(prefix + "авто Наименование");
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРП)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРП)")
    public void addRepresentativesERPTest() {
        authorization("supervisor");
        clickToText(nameSupervisor);
        clickPersonalAccount();
        goToAuthorizedToConductMenu();
        clickAddButton();
        setNameField(prefix + "авто ФИО");
        setPositionField(prefix + "авто Должность");
        setTypeInspectorDropDown(typeInspector);
        clickSaveButton();
        checkRepresentatives(prefix + "авто ФИО");
    }



}