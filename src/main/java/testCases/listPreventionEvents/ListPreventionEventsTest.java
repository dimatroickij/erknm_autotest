package testCases.listPreventionEvents;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

import java.io.File;
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
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавляем ПМ, вид Объявление предостережения (статус в процессе заполнения)")
    public void createPMEventWarningAnnouncementStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setNameKNOPMDropDown(nameKNO);
        setKindControlAndNumberPMDropDown(viewKNO);
        setKindPMDropDown(typeAnnouncementWarningsPM);
        setStartDate(currentDate);
        setInnField(INN);
        addObjectData(typeObject, viewObject, classDanger);
        clickSaveButton();
        checkObject("В процессе заполнения");
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);

    }

    /**
     * Цель: Перевести Объявление предостережения в в статус Предостережение объявлено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=538
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Перевод Объявление предостережения в статус Предостережение объявлено", dependsOnMethods={"createPMEventWarningAnnouncementStatusProcessCompletionTest"})
    public void transferPMEventWarningAnnouncementStatusWarningAnnouncedTest() throws IOException {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        //openRequest(numberPM);
       // openCard("77220660001100054411");
        openCard("77220660001100054495");
        switchTo().window(1);
        setStopDate(currentDate);
        setNoteWarningField(prefix + "авто Описание");
        //addDocument();
        clickAddContentWarningButton();
        clickAddDocumentButton();
        Runtime.getRuntime().exec(scriptAddDocument);
        //Runtime.getRuntime().exec("cmd /c start C:\\erknm_autotest\\file\\startscript.bat");
        clickAddSignatureButton();
        Runtime.getRuntime().exec(scriptAddSignature);
        clickUploadButton();
        addGrounds(grounds);
        addOfficial(prefix + "авто ФИО", officialPost);
        clickActionButton();
        clickSignatureButton();
        Selenide.confirm();
        clickSignatureButton();
        clickSaveButton();

        checkObject("Предостережение объявлено");
    }

    /**
     * Цель: Перевести Объявление предостережения в статус Есть возражение
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=539
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод Объявление предостережения в статус Есть возражение")
    public void transferPMEventWarningAnnouncementStatusAnyObjectinsTest() {
        createPMEventWarningAnnouncementStatusProcessCompletionTest();
        clickAddInformationDirectionObjectionButton();
        //Добавление документа и подписи
        checkObject("Есть возражение");
    }

    /**
     * Цель: Создание ПМ, вид профилактический визит, статус В процессе заполнения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=533
     * @author Frolova S.I 01.2022
     */
    @Test(description = "4 - Добавляем ПМ, вид профилактический визит (статус в процессе заполнения)")
    public void createPMEventPreventiveVisitStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setNameKNOPMDropDown(nameKNO);
        setKindControlAndNumberPMDropDown(viewKNO);
        setKindPMDropDown(typePreventiveVisitPM);
        // setStartDate(dataStart);
        setInnField(INN);
        setTypeObjectDropDown(typeObject);
        setViewObjectDropDown(viewObject);
        setClassDangerDropDown(classDanger);
        clickSaveButton();
        checkObject("В процессе заполнения");
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);
    }

    /**
     * Цель: Перевести Профилактический визит в статус Ожидает проведения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=534
     * @author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения", dependsOnMethods={"createPMEventPreventiveVisitStatusProcessCompletionTest"})
    public void transferPMEventPreventiveVisitStatusAwaitingTest() {
        authorization("supervisor");
       //TODO статус ожидает проведения для тех, у кого не наступила дата начала? создать новую
        choiceERKNM();
        gotoListPreventionEventsPage();
        //openRequest(numberPM);
        openCard("ПМ 77220660001100054149");
        switchTo().window(1);
        setStopDate(futureDate);
        /*setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        clickAddDocumentButton();
        Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceDoc.exe");
        clickAddSignatureButton();
        Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceSign.exe");
        clickUploadButton();*/
        clickAddGroundsButton();
        setGroundDropDown(grounds);
        clickOfficialButton();
        setOfficialField(prefix + "авто ФИО");
        setOfficialPostDropDown(officialPost);
        clickSaveButton();
        clickActionButton();
        clickSignatureButton();
        //TODO autoit выбор подписи и бывает алерт и ок нажатие через селенид
        clickSignatureButton();
        clickSaveButton();
        checkObject("Ожидание проведения");
    }

    /**
     * Цель: Перевести Профлактический визит в статус Завершено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=535
     * @author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод Профилактического визита в статус Завершено", dependsOnMethods={"transferPMEventPreventiveVisitStatusAwaitingTest"})
    public void transferPMEventPreventiveVisitStatusCompletedTest() {
        //открываем КНМ созданную в тесте 1 ранее
        clickAddInformationResultPMButton();
        setResultPMField(prefix + "авто результат");
        checkObject("Завершено");

    }

    /**
     * Цель: Удаление ПМ
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3319
     * @author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление ПМ")
    public void deletePMEventTest() {
        createPMEventWarningAnnouncementStatusProcessCompletionTest();
        closeNotification();
       // gotoListPreventionEventsPage();
       // openCard(numberPM);
       // switchTo().window(1);
        clickActionButton();
        clickDeleteButton();
        checkObject("Удалено");
        gotoListPreventionEventsPage();
        searchRequest(numberPM);
        checkAbsenceObject(numberPM);


    }
}
