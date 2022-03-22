package testCases.listPreventionEvents;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

import java.io.IOException;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ListPreventionEventsTest extends ListPreventionEventsPage {
    //раздел Список ПМ
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    public String numberPM = "";
    String officialPost = "Руководитель Территориального органа Росздравнадзора";

    /**
     * Цель: Создание ПМ, вид Объявление предостережения, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=537
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавляем ПМ, вид Объявление предостережения (статус в процессе заполнения)")
    public void createPMEventWarningAnnouncementStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO,viewKNO,typeAnnouncementWarningsPM,currentDate,INN,typeObject, viewObject, classDanger);
        checkObject("В процессе заполнения");
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);
        //logout();

    }

    /**
     * Цель: Перевести Объявление предостережения в в статус Предостережение объявлено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=538
     *
     * @author Frolova S.I 01.2022
     */
    //@Test(description = "2 - Перевод Объявление предостережения в статус Предостережение объявлено", dependsOnMethods={"createPMEventWarningAnnouncementStatusProcessCompletionTest"})
    @Test(description = "2 - Перевод Объявление предостережения в статус Предостережение объявлено")
    public void transferPMEventWarningAnnouncementStatusWarningAnnouncedTest() throws IOException {
        installPlugin();
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
       // openCard(numberPM);
        openCard("77220660001100008846");
        switchTo().window(1);
        clickCloseMessagePMButton();
        setStopDate(currentDate);
        setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        addDocumentAndSignatureNoteWarning(filePath,signPath);
        clickUploadButton();
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        closeNotification();
        clickSaveButton();
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
       // Selenide.confirm();
        clickSignatureButton();
        clickSaveButton();
        checkObject("Предостережение объявлено");
        //logout();
    }

    /**
     * Цель: Перевести Объявление предостережения в статус Есть возражение
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=539
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод Объявление предостережения в статус Есть возражение", dependsOnMethods={"createPMEventWarningAnnouncementStatusProcessCompletionTest"})
    public void transferPMEventWarningAnnouncementStatusAnyObjectinsTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        openCard(numberPM);
        switchTo().window(1);
        clickAddInformationDirectionObjectionButton();
        addDocumentAndSignatureInformationDirectionObjection(filePath,signPath);
        clickUploadButton();
        closeNotification();
        clickSaveButton();
        checkObject("Есть возражение");
        //logout();
    }

    /**
     * Цель: Создание ПМ, вид профилактический визит, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=533
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "4 - Добавляем ПМ, вид профилактический визит (статус в процессе заполнения)")
    public void createPMEventPreventiveVisitStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO,viewKNO,typePreventiveVisitPM,currentDate,INN,typeObject, viewObject, classDanger);
        checkObject("В процессе заполнения");
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);
    }

    /**
     * Цель: Перевести Профилактический визит в статус Ожидает проведения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=534
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения", dependsOnMethods = {"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    //@Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения", dependsOnMethods={"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    @Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения")
    public void transferPMEventPreventiveVisitStatusAwaitingTest() {
        installPlugin();
        authorization("supervisor");
        //TODO статус ожидает проведения для тех, у кого не наступила дата начала? создать новую
        choiceERKNM();
        gotoListPreventionEventsPage();
        openCard(numberPM);
        switchTo().window(1);
        setStopDate(currentDate);
        addGroundsPM(grounds);
        addOfficialPM(prefix + "авто ФИО", officialPost);
        clickSaveButton();
        closeNotification(); //3 раза?
        clickActionsHeaderButton();
        clickSignatureButton();
        //Selenide.confirm();
        clickSignatureButton();
        clickSaveButton();
        checkObject("Ожидает проведения");
        //logout();
    }

    /**
     * Цель: Перевести Профлактический визит в статус Завершено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=535
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод Профилактического визита в статус Завершено", dependsOnMethods = {"transferPMEventPreventiveVisitStatusAwaitingTest"})
    @Test(description = "6 - Перевод Профилактического визита в статус Завершено", dependsOnMethods={"transferPMEventPreventiveVisitStatusAwaitingTest"})
    //@Test(description = "6 - Перевод Профилактического визита в статус Завершено")
    public void transferPMEventPreventiveVisitStatusCompletedTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        openCard(numberPM);
        switchTo().window(1);
        setResultPMField(prefix + "авто результат");
        clickSaveButton();
        checkObject("Завершено");
        //logout();
    }

    /**
     * Цель: Удаление ПМ
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3319
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление ПМ")
    public void deletePMEventTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNO,viewKNO,typeAnnouncementWarningsPM,currentDate,INN,typeObject, viewObject, classDanger);
        numberPM = getNumberPM();
        System.out.println(numberPM);
        clickCloseMessagePMButton();
        closeNotification();
        // gotoListPreventionEventsPage();
        // openCard(numberPM);
        // switchTo().window(1);
        clickActionButton();
        clickActionsOnCardButton();
        clickDeleteButton();
        checkObject("Удалено");
        gotoListPreventionEventsPage();
        searchRequest(numberPM);
        checkAbsenceObject(numberPM);
        //logout();

    }
}
