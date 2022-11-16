package testCases.e2e;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

/**
 * Цель: Проверка статусной модели и статуса публикации Проверочных мероприятий при переходе по ЖЦ
 *
 * @author Kirilenko P.A. 10.2022
 */

public class TestE2EPM extends ListPreventionEventsPage {

    public TestE2EPM() throws Exception {
    }

    /**
     * Цель: Проверка перехода по ЖЦ ПМ Объявление предостережения в статус Предостережение объявлено
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "Проверка перехода по ЖЦ ПМ Объявление предостережения в статус Предостережение объявлено")
    public void declarationCautionInStatusCautionDeclaredTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        getNumberPM();
        checkStatusPM(statusProcessFilling);
        checkStatusPublicationPM(statusNotPublished);
        transferPMEventWarningAnnouncementStatusWarningAnnounced();
        checkStatusPM(statusWarningAnnounced);
        checkStatusPublicationPM(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ ПМ Объявление предостережения в статус Есть возражение
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "Проверка перехода по ЖЦ ПМ Объявление предостережения в статус Есть возражение")
    public void announcementCautionsInStatusThereObjectionsTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        getNumberPM();
        checkStatusPM(statusProcessFilling);
        checkStatusPublicationPM(statusNotPublished);
        transferPMEventWarningAnnouncementStatusAnObjection();
        checkStatusPM(statusAnObjection);
        checkStatusPublicationPM(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ ПМ Профилактического визита в статус Завершено
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "Проверка перехода по ЖЦ ПМ Профилактического визита в статус Завершено")
    public void preventiveVisitStatusCompletedTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typePreventiveVisitPM, currentDate, INN, kingObjectForFNS);
        getNumberPM();
        checkStatusPM(statusProcessFilling);
        checkStatusPublicationPM(statusNotPublished);
        transferPMEventPreventiveVisitStatusLookingForward();
        checkStatusPM(statusProcessAwaiting);
        checkStatusPublicationPM(statusPublished);
        transferPMEventPreventiveVisitStatusCompleted();
        checkStatusPM(statusCompleted);
        checkStatusPublicationPM(statusPublished);
    }

    /**
     * Цель: Проверка перехода по ЖЦ ПМ Профилактического визита в статус Отказ в проведении
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "Проверка перехода по ЖЦ ПМ Профилактического визита в статус Отказ в проведении")
    public void preventiveVisitStatusRefusalCarryOutTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typePreventiveVisitPM, currentDate, INN, kingObjectForFNS);
        getNumberPM();
        checkStatusPM(statusProcessFilling);
        checkStatusPublicationPM(statusNotPublished);
        transferPMEventPreventiveVisitStatusLookingForward();
        checkStatusPM(statusProcessAwaiting);
        checkStatusPublicationPM(statusPublished);
        transferPMEventPreventiveVisitStatusRefusalToConduct();
        checkStatusPM(statusRefusalToConduct);
        checkStatusPublicationPM(statusPublished);
    }

    /**
     * Цель: Проверка удаления ПМ
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("e2e")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "Проверка удаления ПМ")
    public void deleteCartPMTest() throws Exception {
        installPlugin();
        authorization(employee);
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typePreventiveVisitPM, currentDate, INN, kingObjectForFNS);
        getNumberPM();
        checkStatusPM(statusProcessFilling);
        checkStatusPublicationPM(statusNotPublished);
        deletePM();
        checkStatusPM(statusDeleted);
        checkStatusPublicationPM(statusNotPublished);
    }

}
