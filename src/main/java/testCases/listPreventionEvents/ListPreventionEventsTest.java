package testCases.listPreventionEvents;

import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

import java.io.IOException;
import java.util.Random;

public class ListPreventionEventsTest extends ListPreventionEventsPage {
    //раздел Список ПМ
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    String dataStart = "12.01.2022";
    String dataStop = "12.01.2022";
    public String numberPM = "";
    String ground = "5.0.3 (ФЗ 248) В связи с отношением объектов контроля к категориям чрезвычайно высокого, высокого и значительного риска";
    String officialPost = "Руководитель Территориального органа Росздравнадзора";

    /*
         author Frolova S.I 01.2022
         */
    @Test(description = "1 - Добавляем ПМ, вид Объявление предостережения (статус в процессе заполнения)")
    public void createPMEventWarningAnnouncementStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEvents();
        clickAddButton();
        setNameKNOPMDropDown(nameKNO);
        setKindControlAndNumberPMDropDown(viewKNO);
        setKindPMDropDown(typeAnnouncementWarningsPM);
        setStartDate(dataStart);
        setInnField(INN);
        setTypeObjectField(typeObject);
        setViewObjectField(viewObject);
        setClassDangerField(classDanger);
        clickSaveButton();
        checkObject("В процессе заполнения");
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);

    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "2 - Перевод Объявление предостережения в статус Предостережение объявлено")
    public void transferPMEventWarningAnnouncementStatusWarningAnnouncedTest() throws IOException {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEvents();
        //openRequest(numberPM);
        openRequest("ПМ 77220660001100054148");
        //TODO разобраться, может проблема с новой вкладкой. Не находит элементы
        setStopDate(dataStop);
        setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        clickAddDocumentButton();
        // Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceDoc.exe");
        Runtime.getRuntime().exec(".\\erknm_gui_autotest\\testUtils\\choiceDoc.exe");
        clickAddSignatureButton();
        // Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceSign.exe");
        Runtime.getRuntime().exec("..\\erknm_gui_autotest\\erknm_gui_autotest\\testUtils\\choiceSign.exe");
        clickUploadButton();
        clickAddGroundsButton();
        setGroundDropDown(ground);
        clickOfficialButton();
        setOfficialField(prefix + "авто ФИО");
        setOfficialPostDropDown(officialPost);
        clickSaveButton();
        clickActionButton();
        clickSignatureButton();
        //выбор подписи и бывает алерт
        clickSignatureButton();
        clickSaveButton();

        checkObject("Предостережение объявлено");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод Объявление предостережения в статус Есть возражение")
    public void transferPMEventWarningAnnouncementStatusAnyObjectinsTest() {
        //открываем ПМ созданную в тесте 1 ранее
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEvents();
        //openRequest(numberPM);
        openRequest("ПМ 77220660001100054148");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "4 - Добавляем ПМ, вид профилактический визит (статус в процессе заполнения)")
    public void createPEventPreventiveVisitStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEvents();
        clickAddButton();
        setNameKNOPMDropDown(nameKNO);
        setKindControlAndNumberPMDropDown(viewKNO);
        setKindPMDropDown(typePreventiveVisitPM);
        setStartDate(dataStart);
        setInnField(INN);
        setTypeObjectField(typeObject);
        setViewObjectField(viewObject);
        setClassDangerField(classDanger);
        clickSaveButton();
        checkObject("В процессе заполнения");
        numberPM = getNumberPM();
        System.out.println("НОМЕР ПМ - " + numberPM);
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод Профилактического визита в статус Ожидает проведения")
    public void transferPEventPreventiveVisitStatusAwaitingTest() throws IOException {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEvents();
        //openRequest(numberPM);
        openRequest("ПМ 77220660001100054149");
        //TODO разобраться, может проблема с новой вкладкой. Не находит элементы
        setStopDate(dataStop);
        setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        clickAddDocumentButton();
        Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceDoc.exe");
        clickAddSignatureButton();
        Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceSign.exe");
        clickUploadButton();
        clickAddGroundsButton();
        setGroundDropDown(ground);
        checkObject("Предостережение объявлено");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод Профилактического визита в статус Завершено")
    public void transferPEventPreventiveVisitStatusCompletedTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление ПМ")
    public void deletePMEventTest() {
        createPMEventWarningAnnouncementStatusProcessCompletionTest();
        //TODO разобраться с кнопкой действия
        clickActionButton();
        clickDeleteButton();
        searchRequest(numberPM);
        checkAbsenceObject(numberPM);


    }
}
