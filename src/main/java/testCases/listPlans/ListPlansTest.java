package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;


import java.util.Random;

public class ListPlansTest extends ListPlanPage {
    //раздел Список планов
    public String numberPlan = "";
    public String numberKNM = "";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

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
        clickAddButton();
        // setKNOFormPlanDropDown(); выбор, если по умолчанию выбрано не здравоохранение
        // setProsecutorDropDown();
        clickCreateButton();
        numberPlan = getNumberPlan();
        System.out.println("НОМЕР ПЛАНА " + numberPlan);
        gotoListPlansPage();
        openCardPlan(numberPlan);
        checkObject(statusProcessFormation);

    }

    /**
     * Цель: Добавление плановой КНМ в созданный план
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=446
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "Добавление плановой КНМ в созданный план", dependsOnMethods = {"createPlanTest"})
    //@Test(description = "3 - Добавление плановой КНМ в созданный план")
    public void addPlannedKNMInPlanTest() throws Exception, Exception {
        logout();
        authorization("supervisor");
        ListEventsPage event = new ListEventsPage();
        choiceMode(true);
        gotoListPlansPage();
        //openCardPlan("2023037785");
        openCardPlan(numberPlan);
        clickAddKNMButton();
        event.setKindControlAndNumberDropDown(viewKNO);
        event.setKindKNMDropDown(controlPurchase);
        event.setStartKNMDate(futureDate);
        event.setInnField(INN);
        event.setTypeObjectDropDown();
        event.setKindObjectDropDown();
        event.setDangerClassDropDown();
        clickSaveButton();
        closeNotification();
        numberKNM = event.getNumberKNM();
        event.setDurationDaysField(number);
        event.addGroundsIncludePlan(futureDate);
        event.addListActions(futureDate, futureDate);
        event.createMandatoryRequirements(prefix + "авто", prefix + "авто", currentDate);
        event.clickAddVenueButton();
        event.setVenueField(place);
        clickSaveButton();
        closeNotification();
        checkObject(statusReadyApproval);
        logout();
    }

    /**
     * Цель: Перевод плана в статус На рассмотрении
     * !Hp ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=516
     *
     * @author Frolova S.I 02.2022
     */
    // @Test(description = "4 - Перевод плана в статус На рассмотрении")
    @Test(description = "Перевод плана в статус На рассмотрении", dependsOnMethods = {"addPlannedKNMInPlanTest"})
    public void transferPlanStatusOnConsiderationTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        openCardPlan(numberPlan);
        // openCardPlan("2023037785");
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        clickSubmitReviewButton();
        clickApproveChangeStatus();
        clickSaveButton();
        closeNotification();
        checkObject("На рассмотрении");
        logout();
    }

    /**
     * Цель: Перевод плана в статус Рассмотрен
     * HP ALM:
     *
     * @author Frolova S.I. 03.2022
     */
    @Test(description = "Перевод плана в статус Рассмотрен", dependsOnMethods = {"transferPlanStatusOnConsiderationTest"})
    //@Test(description = "5 - Перевод плана в статус Рассмотрен")
    public void transferPlanStatusReviewed() throws Exception, Exception {
        authorization("prosecutor");
        choiceMode(true);
        ListEventsPage event = new ListEventsPage();
        gotoListKNMPage();
        event.openCard(numberKNM);
        //event.openCard("77230660001100009047");
        event.setDecisionApplicationDropDown(approved);
        clickSaveButton();
        closeNotification();
        gotoListPlansPage();
        // openCardPlan("2023037785");
        openCardPlan(numberPlan);
        clickReviewedPlanButton();
        approveChangeStatus(fio, number);
        checkObject("Рассмотрен");
        logout();
    }

    /**
     * Цель: Перевод плана в статус Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=520
     *
     * @author Frolova S.I 02.2022
     */
    //@Test(description = "6 - Перевод плана в статус Утвержден")
    @Test(description = "Перевод плана в статус Утвержден", dependsOnMethods = {"transferPlanStatusReviewed"})
    public void transferPlanStatusApprovedTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPlansPage();
        openCardPlan(numberPlan);
        //openCardPlan("2023037785");
        clickApprovePlanButton();
        clickApproveChangeStatus();
        clickSaveButton();
        closeNotification();
        checkObject("Утверждён");
        logout();
    }

    /**
     * Цель:Исключение КНМ из плана в статусе Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3323
     *
     * @author Frolova S.I 03.2022
     */
    @Test(description = "Исключение КНМ из плана в статусе Утвержден", dependsOnMethods = {"transferPlanStatusApprovedTest"})
    //@Test(description = "6 - Исключение КНМ из плана в статусе Утвержден")
    public void exceptionKNMFromApprovedPlanTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77230370001100008833");
        clickActionsOnCardButton();
        excludeKNMFromPlan();
        checkObject(statusExcluded);
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
        createPlanTest();
        gotoListPlansPage();
        searchRequest(numberPlan);
        clickCheckBoxListPlan(numberPlan);
        clickDeleteButton();
        clickConfirmationDeleteButton();
        searchRequest(numberPlan);
        checkAbsenceObject(numberPlan);
    }


//    @Test(description = "Создание проверок в статусе Исключено")
//    public void exceptionTest() throws Exception {
//        createPlanTest();
//        addPlannedKNMInPlanTest();
//        transferPlanStatusOnConsiderationTest();
//        transferPlanStatusReviewed();
//        transferPlanStatusApprovedTest();
//    }

}
