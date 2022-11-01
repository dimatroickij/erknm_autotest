package testCases.e2e;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * Цель: Проверка статусной модели и статуса публикации КНМ при переходе по ЖЦ
 *
 * @author Kirilenko P.A. 10.2022
 */

public class TestE2EKNM extends ListEventsPage {

    public TestE2EKNM() throws Exception {
    }

    ListPlanPage planPage = new ListPlanPage();

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования")
    public void unscheduledCheckRequiresApprovalTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval("4.0.15", currentDateTime, currentDate, currentDate, needCoordination);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization("prosecutor");
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);

        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования")
    public void unscheduledCheckRequiresNotApprovalTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval("4.0.15", currentDateTime, currentDate, currentDate, doesNotRequire);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для плановой КНМ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для плановой КНМ")
    public void scheduledCheckTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        gotoListPlansPage();
        String numberPlan = planPage.createPlan(nameKNOFNS, prosecutorPlan);
        planPage.addPlannedKNMInPlan(numberPlan, viewKNOFNSForPlan, documentaryVerification, "01.02.2024", "01.02.2024",
                interactionDays, null, viewEntity, INN, kingObjectForFNSInPlaned);
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, "01.02.2024", "01.02.2024", "4.0.14", doesNotRequire);
        checkStatusKNM(statusReadyApproval);
        electronicSignatureInBrowser();
        exitFromEvent();
        planPage.transferPlanStatusOnConsideration();
        planPage.checkStatusPlan(statusPlanUnderConsideration);
        planPage.checkSigningPlan(true);

        authorization("prosecutor");
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        planPage.clickAllEventsOpen();
        planPage.openEventFromListEventsTable();
        checkStatusKNM(statusReadyApproval);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessAwaiting);
        checkStatusPublication(statusPublished);
        switchTo().window(0);
        planPage.backToPlan();
        planPage.transferPlanStatusReviewed();
        planPage.checkStatusPlan(statusPlanReviewed);
        planPage.checkSigningPlan(true);

        authorization("supervisor");
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        planPage.transferPlanStatusApproved();
        planPage.checkStatusPlan(approvedPlan);
        planPage.clickAllEventsOpen();
        planPage.openEventFromListEventsTable();
        checkStatusKNM(statusProcessAwaiting);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(actOfImpossibility);
        checkStatusKNM(statusCannotBeHeld);
        checkStatusPublication(statusPublished);
    }




}
