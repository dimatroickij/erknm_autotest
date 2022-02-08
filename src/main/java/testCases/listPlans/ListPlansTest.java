package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ListPlansTest extends ListPlanPage {
    //раздел Список планов
    public String numberPlan = "";
    public String numberKNM = "";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    /**
     * Цель: Создание плана (статус в процессе формирования)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=445
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание плана (статус в процессе формирования)")
    public void createPlanTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPlansPage();
        clickAddButton();
        //нужно менять прокуратуру и орган контроля?
        clickCreateButton();
        numberPlan = getNumberPlan();
        System.out.println("НОМЕР ПЛАНА " + numberPlan);
        openCard(numberPlan);
        checkObject("В процессе формирования");
    }

    /**
     * Цель: Добавление плановой КНМ в созданный план
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=446
     * @author Frolova S.I 02.2022
     */
    @Test(description = "3 - Добавление плановой КНМ в созданный план", dependsOnMethods={"createPlanTest"})
    public void addPlannedKNMInPlanTest() throws IOException {
        authorization("supervisor");
        ListEventsPage event = new ListEventsPage();
        choiceERKNM();
        gotoListPlansPage();
        openCard("2023038134");
        clickAddKNMButton();
        event.setKindControlAndNumberDropDown(viewKNO);
        event.setKindKNMDropDown(controlPurchase);
        event.setStartKNMDate(futureDate);
        event.setInnField(INN);
        event.setTypeObjectDropDown();
        event.setKindObjectDropDown();
        clickSaveButton();
        //numberKNM = event.getNumberKNM();
        System.out.println("НОМЕР НОВОЙ - " +numberKNM);
       //checkObject("В процессе заполнения");
        event.setDurationDaysField("1");
        event.addGroundsIncludePlan(futureDate);

        event.setDateTimePublicationDecisionField(futureDate);
        event.setSolutionNumberField(prefix+"");
        event.setPlaceDecisionField(prefix + "автотестМесто");
        event.setNameOfficialField(prefix + "autoFIO");
        event.setPositionPersonSignedDecisionsDropDown();

        event.clickAddGroundConductingButton();
        event.setGroundConduсtingDropDown();
        event.setNeedCoordinationDropDown();
        event.clickAddFoundationButton();
        event.setTypeDocumentDropDown();
        event.clickAddFileButton();
        Runtime.getRuntime().exec("..\\..\\..\\..\\..\\testUtils\\choiceDoc.exe");
        //clickAddSignatureButton();
        Runtime.getRuntime().exec("..\\..\\..\\..\\..\\testUtils\\choiceSign.exe");
        clickUploadButton();
        event.clickAddListActionsButton();
        event.setTypeActionsDropDown();

        event.setDateStartActions(futureDate);
        event.setDateEndActions(futureDate);
        event.createMandatoryRequirements("","",futureDate);

        event.clickAddVenueButton();
        event.setVenueField("prefix + автотестместо");

    }

    /**
     * Цель: Перевод плана в статус На рассмотрении
     * !Hp ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=516
     * @author Frolova S.I 02.2022
     */
    //статус на согласовании?
    @Test(description = "4 - Перевод плана в статус На рассмотрении", dependsOnMethods={"addPlannedKNMInPlanTest"})
    public void transferPlanStatusOnConsiderationTest() {
        authorization("prosecutor");
        choiceERKNM();
        gotoListKNMPage();
        openCard("");

        gotoListKNMPage();
        openCard(numberPlan);
        checkObject("На рассмотрении");

    }

    /**
     * Цель: Перевод плана в статус Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=520
     * @author Frolova S.I 02.2022
     */
    @Test(description = "5 - Перевод плана в статус Утвержден", dependsOnMethods={"transferPlanStatusOnConsiderationTest"})
    public void transferPlanStatusApprovedTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberPlan);
        checkObject("Утвержден");
    }

    /**
     * Цель:Исключение КНМ из плана в статусе Утвержден
     * !HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3323
     * @author Frolova S.I 02.2022
     */
    @Test(description = "6 - Исключение КНМ из плана в статусе Утвержден", dependsOnMethods={"transferPlanStatusApprovedTest"})
    public void exceptionKNMFromApprovedPlanTest() {

    }
    /**
     * Цель: Удаление плана
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=449
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
