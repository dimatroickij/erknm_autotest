package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListPlanERPPage;

public class ListPlansERPTest extends ListPlanERPPage {
    // работа с планами в режиме ЕРП

    /**
     * Цель: Создание плана (Статус Новый) в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=195
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Создание плана (Статус Новый) в ЕРП", enabled = false)
    public void createPlanERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = createPlan();
        logout();
    }

    /**
     * Цель: Удаление плана в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=199
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Удаление плана в ЕРП", enabled = false)
    public void deletePlanERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = createPlan();
        //numberPlan = "2022037676";
        clickPlanCheckBox(numberPlan);
        clickDeleteButton();
        clickConfirmationDeleteButton();
        closeNotification();
        searchPlan(numberPlan, false);
        logout();
    }

    @Test(description = "Перевод плана в статус На согласовании в ЕРП", enabled = false)
    public void transferPlanStatusOnApprovalTest() throws InterruptedException {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = "2022037658";
        clickPlanCellMenuButton(numberPlan);
        Thread.sleep(3000);
    }

    @Test(description = "Перевод плана в статус На доработке в ЕРП", enabled = false)
    public void transferPlanStatusFrRevisionTest() {

    }

    @Test(description = "Перевод плана в статус Согласован в ЕРП", enabled = false)
    public void transferPlanStatusAgreedTest() {

    }

    @Test(description = "Перевод плана в статус Утвержден в ЕРП", enabled = false)
    public void transferPlanStatusApprovedTest() {

    }

}
