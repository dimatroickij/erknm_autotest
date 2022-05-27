package testCases.listPreventionEvents;

import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;


import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ListPreventionEventsTest extends ListPreventionEventsPage {
    //раздел Список ПМ
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    public String numberPM = "";
    String officialPost = "Руководитель Территориального органа Росздравнадзора";

    public ListPreventionEventsTest() throws Exception {
    }

    /**
     * Цель: Создание ПМ, вид Объявление предостережения, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=537
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавляем ПМ, вид Объявление предостережения (статус в процессе заполнения)")
    public void createPMEventWarningAnnouncementStatusProcessCompletionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO, viewKNO, typeAnnouncementWarningsPM, currentDate, INN, typeObject, viewObject, classDanger);
        checkObject(statusProcessFilling);
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);
        clickConfirmButton();
        closeNotification();
        logout();

    }

    /**
     * Цель: Перевести Объявление предостережения в в статус Предостережение объявлено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=538
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Перевод Объявление предостережения в статус Предостережение объявлено", dependsOnMethods = {"createPMEventWarningAnnouncementStatusProcessCompletionTest"})
    //@Test(description = "2 - Перевод Объявление предостережения в статус Предостережение объявлено")
    public void transferPMEventWarningAnnouncementStatusWarningAnnouncedTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPM);
        //openCard("77220660001100009021");
        clickCloseMessagePMButton();
        setStopDate(currentDate);
        setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        addDocumentAndSignatureNoteWarning(filePath, signPath);
        clickUploadButton();
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        closeNotification();
        clickSaveButton();
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        // Selenide.confirm();
        clickSignatureButton();
        closeNotification();
        closeNotification();
        //clickCloseMessagePMButton();
        clickSaveButton();
        closeNotification();
        checkObject("Предостережение объявлено"); //TODO нужно ожидать после подписания около 3-5 сек
        logout();
    }

    /**
     * Цель: Перевести Объявление предостережения в статус Есть возражение
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=539
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод Объявление предостережения в статус Есть возражение")
    public void transferPMEventWarningAnnouncementStatusAnyObjectinsTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO, viewKNO, typeAnnouncementWarningsPM, currentDate, INN, typeObject, viewObject, classDanger);
        clickCloseMessagePMButton();
        closeNotification();
        //clickAddInformationDirectionObjectionButton();//TODO не всегда срабатывает без ожидания
        addDocumentAndSignatureInformationDirectionObjection(filePath, signPath);
        clickUploadButton();
        closeNotification();
        clickSaveButton();
        checkObject("Есть возражение");
        logout();
    }

    /**
     * Цель: Создание ПМ, вид профилактический визит, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=533
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "4 - Добавляем ПМ, вид профилактический визит (статус в процессе заполнения)")
    public void createPMEventPreventiveVisitStatusProcessCompletionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO, viewKNO, typePreventiveVisitPM, currentDate, INN, typeObject, viewObject, classDanger);
        checkObject(statusProcessFilling);
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);
    }

    /**
     * Цель: Перевести Профилактический визит в статус Ожидает проведения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=536
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения", dependsOnMethods = {"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    //@Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения")
    public void transferPMEventPreventiveVisitStatusLookingForwardTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        openCard(numberPM);
        //openCard("77220660001100009031");
        clickCloseMessagePMButton();
        setStopDate(currentDate);
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        clickSaveButton();
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        //Selenide.confirm();
        clickSignatureButton();
        clickSaveButton();
        clickCloseMessagePMButton();
        checkObject(statusProcessAwaiting);
        logout();
    }

    /**
     * Цель: Перевести Профлактический визит в статус Завершено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=535
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод Профилактического визита в статус Завершено", dependsOnMethods = {"transferPMEventPreventiveVisitStatusLookingForwardTest"})
    //@Test(description = "6 - Перевод Профилактического визита в статус Завершено")
    public void transferPMEventPreventiveVisitStatusCompletedTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        //openCard("77220660001100009031");
        openCard(numberPM);
        clickCloseMessagePMButton();
        setResultPMField(prefix + "авто результат");
        clickSaveButton();
        checkObject(statusCompleted);
        logout();
    }


    /**
     * Цель: Удаление ПМ
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3319
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление ПМ")
    public void deletePMEventTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO, viewKNO, typeAnnouncementWarningsPM, currentDate, INN, typeObject, viewObject, classDanger);
        numberPM = getNumberPM();
        System.out.println(numberPM);
        clickCloseMessagePMButton();
        closeNotification();
        clickActionButton();
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        checkObject(statusDeleted);
        gotoListPreventionEventsPage();
        searchRequest(numberPM);
        checkAbsenceObject(numberPM);
        logout();

    }
}
