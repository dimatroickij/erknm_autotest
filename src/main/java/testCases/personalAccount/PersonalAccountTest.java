package testCases.personalAccount;

import org.testng.annotations.Test;
import testPages.PersonalAccountPage;

import java.util.Calendar;
import java.util.Random;

public class PersonalAccountTest extends PersonalAccountPage {
    String typeInspector = "Проверяющий";
    String typeExpert = "Эксперт";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    //проверки в Личном кабинете для ЕРП

    /*
      author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание шаблонов обязательных требований (для ЕРП)")
    public void createTemplateMandatoryRequirementsERPTest() {
        //authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickPersonalAccount();
        scrollTopHtml();
        goToMandatoryRequirementsMenu();
        clickToTemplateRecord();
        clickAddButton();
        setTemplateNameField(prefix + "авто Наименование");
        setNameOrganizationFieldDropDown(nameKNO);
        setTypeOrganizationFieldDropDown(typeStateControl);
        clickAddRequirementsButton();
        setFormulationField(prefix + "авто Формулировка");
        setNameNPAField(prefix + "авто Наименование НПА");
        setNumberNPAField(prefix + "1");
        setDateNPAField();
        clickSaveButton();
        checkObject(prefix + "авто Наименование");
        closeNotification();
        //logout();
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРП)")
    public void createTemplateTestSheetsERPTest() {
        //authorization("supervisor");
        System.out.println("Идентификатор - " + prefix);
        clickPersonalAccount();
        scrollTopHtml();
        goToCheckSheetsMenu();
        clickToTemplateRecord();
        clickAddButton();
        setTemplateNameField(prefix + "авто Наименование");
        setApprovalDetailsField(prefix + "авто Сведения");
        clickAddSecurityQuestionButton();
        setQuestionField(prefix + "авто Вопрос");
        setRequisitesField(prefix + "авто Реквизиты");
        clickSaveButton();
        checkObject(prefix + "авто Наименование");
        closeNotification();
        //logout();
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРП)")
    public void addResresentativesERPTest() {
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToAuthorizedToConductMenu();
        clickAddButton();
        setNameField(prefix + "авто ФИО");
        setPositionField(prefix + "авто Должность");
        setTypeInspectorDropDown(typeInspector);
        clickSaveButton();
        checkResresentatives(prefix + "авто ФИО");
        closeNotification();
        //logout();
    }



}
