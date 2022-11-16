package testCases.e2e;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.awt.SystemColor.window;

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
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Документарная проверка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Документарная проверка, ЮЛ")
    public void unscheduledCheckRequiresApprovalDocumentationForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Контрольная закупка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Контрольная закупка, ЮЛ")
    public void unscheduledCheckRequiresApprovalPurchaseForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays, null,
                viewEntity);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsInspection);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Выборочный контроль, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Выборочный контроль, ЮЛ")
    public void unscheduledCheckRequiresApprovalSelectiveControlForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, selectiveControl, unplannedCheck, currentDate, currentDate, interactionDays, null,
                viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsInspection);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Мониторинговая закупка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Мониторинговая закупка, ЮЛ")
    public void unscheduledCheckRequiresApprovalMonitoringPurchaseForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_037, monitoringPurchase, unplannedCheck, currentDate, currentDate, interactionDays, null,
                viewEntity);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsInspection);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Рейдовый осмотр, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Рейдовый осмотр, ЮЛ")
    public void unscheduledCheckRequiresApprovalRaidInspectionForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, raidInspection, unplannedCheck, currentDate, currentDate, interactionDays, null,
                viewEntity);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsInspection);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр, ЮЛ")
    public void unscheduledCheckRequiresNotApprovalRaidInspectionForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, raidInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Инспекционный визит, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Инспекционный визит, ЮЛ")
    public void unscheduledCheckRequiresNotApprovalInspectionVisitForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, inspectionVisit, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Инспекционный визит, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Инспекционный визит, ЮЛ")
    public void unscheduledCheckRequiresApprovalInspectionVisitForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, inspectionVisit, unplannedCheck, currentDate, currentDate, interactionDays, null,
                viewEntity);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsInspection);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Выездная проверка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, требующей согласования, Выездная проверка, ЮЛ")
    public void unscheduledCheckRequiresApprovalOnsiteInspectionForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, onsiteInspection, unplannedCheck, currentDate, currentDate, interactionDays, null,
                viewEntity);
        closeNotification();
        String numberKNM = getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", needCoordination,
                typeActionsInspection);
        checkStatusKNM(statusReadyApproval);
        transferEventStatusOnApproval();
        checkStatusKNM(statusOnApproval);
        checkStatusPublication(statusNotPublished);

        authorization(prosecutor);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Выездная проверка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Выездная проверка, ЮЛ")
    public void unscheduledCheckRequiresNotApprovalOnsiteInspectionForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, onsiteInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, незамедлительная проверка, Выездная проверка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, незамедлительная проверка, Выездная проверка, ЮЛ")
    public void unscheduledCheckRequiresPromptCheckOnsiteInspectionForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNO, viewKNO_066, onsiteInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", promptCheck,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, ЮЛ")
    public void unscheduledCheckRequiresNotApprovalDocumentationForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, незамедлительная проверка, Документарная проверка, ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, незамедлительная проверка, Документарная проверка, ЮЛ")
    public void unscheduledCheckRequiresPromptCheckDocumentationForEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", promptCheck,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, ИП
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, ИП")
    public void unscheduledCheckRequiresNotApprovalDocumentationForMerchantTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewMerchant);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, ФЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, ФЛ")
    public void unscheduledCheckRequiresNotApprovalDocumentationForIndividualTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewIndividual);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, иностранное ЮЛ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, иностранное ЮЛ")
    public void unscheduledCheckRequiresNotApprovalDocumentationForForeignLegalEntityTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewForeignLegalEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(supervisoryAct);
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, иностранное ЮЛ
     * не зарегистрированное на территории РФ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требует согласования, Документарная проверка, " +
            "иностранное ЮЛ не зарегистрированное на территории РФ")
    public void unscheduledCheckRequiresNotApprovalDocumentationForForeignLegalEntityNotRegisteredTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewForeignLegalEntityNotRegistered);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsRetrievalDocuments);
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
        authorization(employee);
        selectionERKNM();
        gotoListPlansPage();
        String numberPlan = planPage.createPlan(nameKNOFNS, prosecutorPlan);
        planPage.addPlannedKNMInPlan(numberPlan, viewKNOFNSForPlan, documentaryVerification, "01.02.2024", "01.02.2024",
                interactionDays, null, viewEntity);
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, "01.02.2024", "01.02.2024", "4.0.14",
                doesNotRequire, typeActionsRetrievalDocuments);
        checkStatusKNM(statusReadyApproval);

        exitFromEvent();
        planPage.transferPlanStatusOnConsideration();
        planPage.checkStatusPlan(statusPlanUnderConsideration);
        planPage.checkSigningPlan(true);

        authorization(prosecutor);
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        planPage.clickAllEventsOpen();
        planPage.openEventFromListEventsTable();
        checkStatusKNM(statusOnApproval);
        transferEventStatusAgreed(approved, currentDate);
        checkStatusKNM(statusProcessAwaiting);
        checkStatusPublication(statusPublished);

        switchTo().window(1).close();
        switchTo().window(0);
        planPage.backToPlan();
        planPage.transferPlanStatusReviewed();
        planPage.checkStatusPlan(statusPlanReviewed);
        planPage.checkSigningPlan(true);

        authorization(employee);
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        planPage.transferPlanStatusApproved();
        planPage.checkStatusPlan(approvedPlan);
        planPage.clickAllEventsOpen();
        planPage.openEventFromListEventsTable();
        checkStatusKNM(statusProcessAwaiting);
        checkStatusPublication(statusPublished);
        sleep(2000);
        transferEventStatusWaitCompleted(actOfImpossibility);
        checkStatusKNM(statusCannotBeHeld);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка создание КНМ в плане
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка создание КНМ в плане")
    public void createKNMFromPlanTest() throws Exception {
        int amount = 2;
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListPlansPage();
        String numberPlan = planPage.createPlan(nameKNOFNS, prosecutorPlan);
        for(int i = 0; i < amount; i++){
            planPage.addPlannedKNMInPlan(numberPlan, viewKNOFNSForPlan, documentaryVerification, "01.02.2024",
                    "01.02.2024", interactionDays, null, viewEntity);
            transferEventStatusReadyApproval(currentDateTime, "01.02.2024", "01.02.2024", "4.0.14",
                    doesNotRequire, typeActionsRetrievalDocuments);
            exitFromEvent();
            gotoListPlansPage();
        }

        authorization(prosecutor);
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        for(int i = 0; i < amount; i++){
            planPage.clickUnderConsiderationEventsOpen();
            planPage.openEventFromListEventsTable();
            transferEventStatusAgreed(approved, currentDate);
            switchTo().window(0);
            planPage.backToPlan();
        }
        planPage.transferPlanStatusReviewed();

        authorization(employee);
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan(numberPlan);
        planPage.transferPlanStatusApproved();
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ до Не может быть проведено
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ до Не может быть проведено")
    public void unscheduledCheckToCannotBeCarriedOutTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, futureDate, futureDate, "4.0.15", doesNotRequire,
                typeActionsRetrievalDocuments);
        checkStatusKNM(statusProcessAwaiting);
        checkStatusPublication(statusPublished);
        transferEventStatusWaitCompleted(actOfImpossibility);
        checkStatusKNM(statusCannotBeHeld);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без блока Сведения о КЛ,
     * с добавлением в акте ЮЛ
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без " +
            "блока Сведения о КЛ, с добавлением в акте ЮЛ ")
    public void unscheduledCheckRequiresNotApprovalRaidInspectionWithoutControlledPersonAddEntityForActTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, raidInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, null);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);
        addInformationAboutAct(supervisoryAct, randomNumber, familiarWith);
        addInformationControlledPersonForAct(viewEntity, INN);
        clickSaveButton();
        closeNotification();
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без блока Сведения о КЛ,
     * с добавлением в акте ИП
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без " +
            "блока Сведения о КЛ, с добавлением в акте ИП ")
    public void unscheduledCheckRequiresNotApprovalRaidInspectionWithoutControlledPersonAddMerchantForActTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, raidInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, null);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);
        addInformationAboutAct(supervisoryAct, randomNumber, familiarWith);
        addInformationControlledPersonForAct(viewMerchant, INN);
        clickSaveButton();
        closeNotification();
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без блока Сведения о КЛ,
     * с добавлением в акте иностранного ЮЛ
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без " +
            "блока Сведения о КЛ, с добавлением в акте иностранного ЮЛ")
    public void unscheduledCheckRequiresNotApprovalRaidInspectionWithoutControlledPersonAddForeignLegalEntityForActTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, raidInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, null);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);
        addInformationAboutAct(supervisoryAct, randomNumber, familiarWith);
        addInformationControlledPersonForAct(viewForeignLegalEntity, INN);
        clickSaveButton();
        closeNotification();
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без блока Сведения о КЛ,
     * с добавлением в акте иностранного ЮЛ без регистрации в РФ
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "Проверка перехода по ЖЦ для внеплановой КНМ, не требующей согласования, Рейдовый осмотр без " +
            "блока Сведения о КЛ, с добавлением в акте иностранного ЮЛ без регистрации в РФ")
    public void unscheduledCheckRequiresNotApprovalRaidInspectionWithoutControlledPersonAddForeignLegalEntityNotRegisteredForActTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        addKNM(knoNameTransport, viewKNO_069, raidInspection, unplannedCheck, currentDate, currentDate, interactionDays,
                null, null);
        closeNotification();
        getNumberKNM();
        checkStatusKNM(statusProcessFilling);
        transferEventStatusReadyApproval(currentDateTime, currentDate, currentDate, "4.0.15", doesNotRequire,
                typeActionsInspection);
        checkStatusKNM(statusProcessCompletion);
        checkStatusPublication(statusNotPublished);
        addInformationAboutAct(supervisoryAct, randomNumber, familiarWith);
        addInformationControlledPersonForAct(viewForeignLegalEntityNotRegistered, INN);
        clickSaveButton();
        closeNotification();
        checkStatusKNM(statusCompleted);
        checkStatusPublication(statusPublished);
    }

}
