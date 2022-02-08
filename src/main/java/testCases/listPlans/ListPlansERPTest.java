package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListPlanERPPage;

public class ListPlansERPTest extends ListPlanERPPage {
    // работа с планами в режиме ЕРП

    /*
    author Troickij D. A. 01.2022
    */
    @Test(description = "1 - Создание плана (Статус Новый) в ЕРП")
    public void createPlanERPTest() throws InterruptedException {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        clickAddButton();
        setControlAuthorityDropDown(nameKNO);
        setProsecutorOfficeDropDown(prosecutorsOffice);
        setTypePlanDropDown(summaryPlan294);
        clickCreateButton();
        Thread.sleep(4000);
        //СОздание плана + добавление КНМ или создание КНМ с номером созданного плана в ЕРП
    }

    @Test(description = "2 - Удаление плана в ЕРП")
    public void deletePlanERPTest() {

    }

    @Test(description = "3 - Перевод плана в статус На согласовании в ЕРП")
    public void transferPlanStatusOnApprovalTest() {

    }

    @Test(description = "4 - Перевод плана в статус На доработке в ЕРП")
    public void transferPlanStatusFrRevisionTest() {

    }

    @Test(description = "5 - Перевод плана в статус Согласован в ЕРП")
    public void transferPlanStatusAgreedTest() {

    }

    @Test(description = "6 - Перевод плана в статус Утвержден в ЕРП")
    public void transferPlanStatusApprovedTest() {

    }

}
