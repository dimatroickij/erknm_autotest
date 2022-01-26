package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class ListPlansTest extends ListPlanPage {
    //раздел Список планов
    public String numberPlan = "";
    public String numberKNM = "";

    /*
     author Frolova S.I 01.2022
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
        System.out.println("НОМЕР ПЛАНА" + numberPlan);
        openCard(numberPlan);
        checkObject("В процессе формирования");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление плановой КНМ в созданный план")
    public void addPlannedKNMInPlanTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPlansPage();
        openCard("2023002705");
        clickAddKNMButton();
        ListEventsPage event = new ListEventsPage();
        event.setKindControlAndNumberDropDown(viewKNO);
        event.setKindKNMDropDown(controlPurchase);
        event.setStartKNMDateNextYear();
        event.setInnField(INN);
        event.setTypeObjectDropDown();
        event.setKindObjectDropDown();
        clickSaveButton();
        numberKNM = event.getNumberKNM();
        System.out.println("НОМЕР НОВОЙ - " +numberKNM);
        checkObject("В процессе заполнения");
        //TODO нужна ли проерка номер КНМ/ номер плана в который добавлена?
//77230660001100054369
        event.setDurationDaysField("1");

        event.setDateTimePublicationDecisionNextYearField();
        event.setSolutionNumberField("prefix");
        event.setPlaceDecisionField("prefix + автотестМесто");
        event.setNameOfficialField("prefix + autoFIO");
        event.setPositionPersonSignedDecisionsDropDown();

        event.clickAddGroundConductingButton();
        event.setGroundConduсtingDropDown();
        event.setNeedCoordinationDropDown();
        event.clickAddFoundationButton();
        event.setTypeDocumentDropDown();
        event.clickAddFileButton();
        //добавить автоит
        event.clickAddListActionsButton();
        event.setTypeActionsDropDown();
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        event.setDateStartActions(currentDate);
        event.setDateEndActions(currentDate);
        event.createMandatoryRequirements("","", currentDate);

        event.clickAddVenueButton();
        event.setVenueField("prefix + автотестместо");

    }

    /*
     author Frolova S.I 01.2022
     */
    //статус на согласовании?
    @Test(description = "4 - Перевод плана в статус На рассмотрении")
    public void transferPlanStatusOnConsiderationTest() {
        authorization("prosecutor");
        choiceERKNM();
        gotoListKNMPage();
        openCard("");

        gotoListKNMPage();
        openCard(numberPlan);
        checkObject("На рассмотрении");

    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод плана в статус Утвержден")
    public void transferPlanStatusApprovedTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberPlan);
        checkObject("Утвержден");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "6 - Исключение КНМ из плана в статусе Утвержден")
    public void exceptionKNMFromApprovedPlanTest() {

    }
    /*
    author Frolova S.I 01.2022
    */
    @Test(description = "2 - Удаление плана")
    public void deletePlanTest() {
        createPlanTest();
        gotoListPlansPage();
        searchRequest(numberPlan);
        clickCheckBoxListPlan(numberPlan);
        clickDeleteButton();
        clickСonfirmationDeleteButton();
        searchRequest(numberPlan);
        checkAbsenceObject(numberPlan);

    }

}
