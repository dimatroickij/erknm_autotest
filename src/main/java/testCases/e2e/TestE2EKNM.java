package testCases.e2e;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

public class TestE2EKNM extends ListEventsPage {

    public TestE2EKNM() throws Exception {
    }

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
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);

        authorization("prosecutor");
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);

        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
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

    }




}
