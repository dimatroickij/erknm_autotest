package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

public class ListPlansTest extends ListPlanPage {
    //раздел Список планов

    public ListPlansTest() throws Exception {
    }

    /**
     * Цель: Создание плана (статус в процессе формирования)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=445
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание плана (статус в процессе формирования)")
    public void createPlanTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        numberPlan = createPlan(nameKNO, prosecutorPlan);
        System.out.println("НОМЕР ПЛАНА " + numberPlan);
        logout();
    }

    /**
     * Цель: Добавление плановой КНМ в созданный план
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=446
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "Добавление плановой КНМ в созданный план", dependsOnMethods = {"createPlanTest"})
    public void addPlannedKNMInPlanTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        addPlannedKNMInPlan(numberPlan, viewKNOFNS, documentaryVerification, currentDate, currentDate, interactionDays,
                null, viewEntity);
        logout();
    }

    /**
     * Цель: Перевод плана в статус На рассмотрении
     * !Hp ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=516
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "Перевод плана в статус На рассмотрении", dependsOnMethods = {"addPlannedKNMInPlanTest"})
    public void transferPlanStatusOnConsiderationTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        transferPlanStatusOnConsideration();
        logout();
    }

    /**
     * Цель: Перевод плана в статус Рассмотрен
     * HP ALM:
     *
     * @author Frolova S.I. 03.2022
     */
    @Test(description = "Перевод плана в статус Рассмотрен", dependsOnMethods = {"transferPlanStatusOnConsiderationTest"})
    public void transferPlanStatusReviewedTest() throws Exception {
        authorization("prosecutor");
        choiceMode(true);
        transferPlanStatusReviewed();
        logout();
    }

    /**
     * Цель: Перевод плана в статус Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=520
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "Перевод плана в статус Утвержден", dependsOnMethods = {"transferPlanStatusReviewedTest"})
    public void transferPlanStatusApprovedTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        openCardPlan(numberPlan);
        clickApprovePlanButton();
        clickApproveChangeStatus();
        clickSaveButton();
        closeNotification();
        checkStatusPlan(approvedPlan);
        logout();
    }

    /**
     * Цель:Исключение КНМ из плана в статусе Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3323
     *
     * @author Frolova S.I 03.2022
     */
    @Test(description = "Исключение КНМ из плана в статусе Утвержден", dependsOnMethods = {"transferPlanStatusApprovedTest"})
    public void exceptionKNMFromApprovedPlanTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        exceptionKNMFromApprovedPlan(numberKNM);
        logout();
    }

    /**
     * Цель: Удаление плана
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=449
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "Удаление плана")
    public void deletePlanTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        String number = deletePlan();
        System.out.println("НОМЕР УДАЛЁННОГО ПЛАНА " + number);
        logout();
    }


    @Test(description = "Создание проверок в статусе Исключено", dependsOnMethods = {"transferPlanStatusApprovedTest"})
    public void exceptionTest() throws Exception {
        authorization("supervisor");
    }

}
