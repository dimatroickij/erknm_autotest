package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ListPlansTest extends ListPlanPage {
    //раздел Список планов
    public String numberPlan = "";
    public String numberKNM = "";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    /**
     * Цель: Создание плана (статус в процессе формирования)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=445
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание плана (статус в процессе формирования)")
    public void createPlanTest() {
        authorization("supervisor");
        sleep(2000);//TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListPlansPage();
        clickAddButton();
       // setKNOFormPlanDropDown(); выбор, если по умолчанию выбрано не здравоохранение
       // setProsecutorDropDown();
        clickCreateButton();
        numberPlan = getNumberPlan();
        System.out.println("НОМЕР ПЛАНА " + numberPlan);
        gotoListPlansPage();
        openCardPlan(numberPlan);
        checkObject("В процессе формирования");

    }

    /**
     * Цель: Добавление плановой КНМ в созданный план
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=446
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "3 - Добавление плановой КНМ в созданный план", dependsOnMethods={"createPlanTest"})
    //@Test(description = "3 - Добавление плановой КНМ в созданный план")
    public void addPlannedKNMInPlanTest() {
        authorization("supervisor");
        sleep(2000);//TODO убрать, как пофиксят баг
        ListEventsPage event = new ListEventsPage();
        choiceERKNM();
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
        numberKNM = event.getNumberKNM();
        event.setDurationDaysField(number);
        event.addGroundsIncludePlan(futureDate);
        event.addListActions(futureDate, futureDate);
        event.createMandatoryRequirements(prefix + "авто", prefix + "авто", currentDate);
        event.clickAddVenueButton();
        event.setVenueField(place);
        closeNotification();
        clickSaveButton();
        checkObject("Готово к согласованию");

    }

    /**
     * Цель: Перевод плана в статус На рассмотрении
     * !Hp ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=516
     *
     * @author Frolova S.I 02.2022
     */
   // @Test(description = "4 - Перевод плана в статус На рассмотрении")
    @Test(description = "4 - Перевод плана в статус На рассмотрении", dependsOnMethods = {"addPlannedKNMInPlanTest"})
    public void transferPlanStatusOnConsiderationTest() {
        installPlugin();
        authorization("supervisor");
        sleep(2000);//TODO убрать, как пофиксят баг
        choiceERKNM();
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
        checkObject("На рассмотрении");

    }

    /**
     * Цель: Перевод плана в статус Рассмотрен
     * HP ALM:
     *
     * @author Frolova S.I. 03.2022
     */
    @Test(description = "5 - Перевод плана в статус Рассмотрен", dependsOnMethods = {"transferPlanStatusOnConsiderationTest"})
    //@Test(description = "5 - Перевод плана в статус Рассмотрен")
    public void transferPlanStatusReviewed(){
        authorization("prosecutor");
        sleep(2000);//TODO убрать, как пофиксят баг
        choiceERKNM();
        ListEventsPage event = new ListEventsPage();
        gotoListKNMPage();
        event.openCard(numberKNM);
        //event.openCard("77230660001100009047");
        event.setDecisionApplicationDropDown(approved);
        clickSaveButton();
        gotoListPlansPage();
       // openCardPlan("2023037785");
        openCardPlan(numberPlan);
        clickReviewedPlanButton();
        approveChangeStatus(fio,number);
        checkObject("Рассмотрен");

    }

    /**
     * Цель: Перевод плана в статус Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=520
     *
     * @author Frolova S.I 02.2022
     */
    //@Test(description = "6 - Перевод плана в статус Утвержден")
    @Test(description = "6 - Перевод плана в статус Утвержден", dependsOnMethods = {"transferPlanStatusReviewed"})
    public void transferPlanStatusApprovedTest() {
        authorization("supervisor");
        sleep(2000);//TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        //openCardPlan("2023037785");
        clickApprovePlanButton();
        clickApproveChangeStatus();
        clickSaveButton();
        checkObject("Утверждён");
    }

    /**
     * Цель:Исключение КНМ из плана в статусе Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3323
     *
     * @author Frolova S.I 03.2022
     */
    @Test(description = "6 - Исключение КНМ из плана в статусе Утвержден", dependsOnMethods = {"transferPlanStatusApprovedTest"})
    //@Test(description = "6 - Исключение КНМ из плана в статусе Утвержден")
    public void exceptionKNMFromApprovedPlanTest() {
        authorization("supervisor");
        sleep(2000);//TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77230370001100008833");
        clickActionsOnCardButton();
        excludeKNMFromPlan();
        checkObject("Исключена");

    }

    /**
     * Цель: Удаление плана
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=449
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "2 - Удаление плана")
    public void deletePlanTest() {
        createPlanTest();
        gotoListPlansPage();
        searchRequest(numberPlan);
        clickCheckBoxListPlan(numberPlan);
        clickDeleteButton();
        clickConfirmationDeleteButton();
        searchRequest(numberPlan);
        checkAbsenceObject(numberPlan);

    }

}
