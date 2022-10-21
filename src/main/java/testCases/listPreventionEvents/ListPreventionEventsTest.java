package testCases.listPreventionEvents;

import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

public class ListPreventionEventsTest extends ListPreventionEventsPage {
    //раздел Список ПМ


    public ListPreventionEventsTest() throws Exception {
    }

    /**
     * Цель: Создание ПМ, вид Объявление предостережения, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=537
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание ПМ, вид Объявление предостережения, статус В процессе заполнения")
    public void createPMEventWarningAnnouncementStatusProcessCompletionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, viewObject);
        numberPMEventWarningPublished = getNumberPM();
        logout();
    }

    /**
     * Цель: Перевод Объявление предостережения в статус Предостережение объявлено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=538
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод Объявление предостережения в статус Предостережение объявлено",
            dependsOnMethods = {"createPMEventWarningAnnouncementStatusProcessCompletionTest"})
    public void transferPMEventWarningAnnouncementStatusWarningAnnouncedTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPMEventWarningPublished);
        transferPMEventWarningAnnouncementStatusWarningAnnounced();
        logout();
    }

    /**
     * Цель: Перевод Объявление предостережения в статус Есть возражение
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=539
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод Объявление предостережения в статус Есть возражение",
            dependsOnMethods = {"createPMEventWarningAnnouncementStatusProcessCompletionTest"})
    public void transferPMEventWarningAnnouncementStatusAnObjectionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPMEventWarningPublished);
        transferPMEventWarningAnnouncementStatusAnObjection();
        logout();
    }

    /**
     * Цель: Создание ПМ, вид Профилактический визит, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=533
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание ПМ, вид Профилактический визит, статус В процессе заполнения")
    public void createPMEventPreventiveVisitStatusProcessCompletionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typePreventiveVisitPM, currentDate, INN, viewObject);
        numberPMPreventiveVisitPublished = getNumberPM();
        logout();
    }

    /**
     * Цель: Перевод Профилактического визита из статуса В процессе заполнения в статус Ожидает проведения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=536
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод Профилактического визита из статуса В процессе заполнения в статус Ожидает проведения",
            dependsOnMethods = {"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    public void transferPMEventPreventiveVisitStatusLookingForwardTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPMPreventiveVisitPublished);
        transferPMEventPreventiveVisitStatusLookingForward(currentDate);
        logout();
    }

    /**
     * Цель: Перевод Профилактического визита из статуса Ожидает проведения в статус Завершено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=535
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод Профилактического визита из статуса Ожидает проведения в статус Завершено",
            dependsOnMethods = {"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    public void transferPMEventPreventiveVisitStatusCompletedTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPMPreventiveVisitPublished);
        transferPMEventPreventiveVisitStatusLookingForward(currentDate);
        gotoListPreventionEventsPage();
        openCard(numberPMPreventiveVisitPublished);
        transferPMEventPreventiveVisitStatusCompleted();
        logout();
    }

    /**
     * Цель: Перевод Профилактического визита из статуса Ожидает проведения в статус отказ в проведении
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=535
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод Профилактического визита из статуса Ожидает проведения в статус отказ в проведении",
            dependsOnMethods = {"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    public void transferPMEventPreventiveVisitStatusRefusalToConductTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPMPreventiveVisitPublished);
        transferPMEventPreventiveVisitStatusLookingForward(currentDate);
        gotoListPreventionEventsPage();
        openCard(numberPMPreventiveVisitPublished);
        transferPMEventPreventiveVisitStatusRefusalToConduct(currentDate);
        logout();
    }


    /**
     * Цель: Удаление ПМ
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3319
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Удаление ПМ", dependsOnMethods = {"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    public void deletePMEventTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPMPreventiveVisitPublished);
        clickConfirmButton();
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        closeNotification();
        checkStatusPM(statusDeleted);
        gotoListPreventionEventsPage();
        searchRequest(numberPMPreventiveVisitPublished);
        checkKNMOrPM(numberPMPreventiveVisitPublished, statusDeleted, false);
        logout();

    }
}
