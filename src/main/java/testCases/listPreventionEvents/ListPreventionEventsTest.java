package testCases.listPreventionEvents;

import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

import java.io.IOException;
import java.util.Calendar;
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
        gotoListPreventionEventsPage();
        clickAddButton();
        setNameKNOPMDropDown(nameKNO);
        setKindControlAndNumberPMDropDown(viewKNO);
        setKindPMDropDown(typeAnnouncementWarningsPM);
        setStartDate(Calendar.getInstance());
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
        gotoListPreventionEventsPage();
        //openRequest(numberPM);
        openRequest("ПМ 77220660001100054148");
        //TODO разобраться, может проблема с новой вкладкой. Не находит элементы, попробовать работающие методы и потом добавить переключение вкладок
        setStopDate(dataStop);
        setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        clickAddDocumentButton();
        //TODO нужно переделать срипт
        // Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceDoc.exe");
        Runtime.getRuntime().exec(".\\erknm_gui_autotest\\testUtils\\choiceDoc.exe");
        clickAddSignatureButton();
        // Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceSign.exe");
        Runtime.getRuntime().exec("..\\erknm_gui_autotest\\erknm_gui_autotest\\testUtils\\choiceSign.exe");
        clickUploadButton();
        clickAddGroundsButton();
        setGroundDropDown(ground);
        //TODO сделать методы по добавлению, где в одном методе сразу нажатие кнопки и заполнение
        clickOfficialButton();
        setOfficialField(prefix + "авто ФИО");
        setOfficialPostDropDown(officialPost);
        clickSaveButton();
        clickActionButton();
        clickSignatureButton();
        //TODO autoit выбор подписи и бывает алерт
        clickSignatureButton();
        clickSaveButton();

        checkObject("Предостережение объявлено");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод Объявление предостережения в статус Есть возражение")
    public void transferPMEventWarningAnnouncementStatusAnyObjectinsTest() {
        createPMEventWarningAnnouncementStatusProcessCompletionTest();
//TODO добавить пункты из предыдущего теста (сократить методы)

        clickAddInformationDirectionObjectionButton();
        //Добавление документа и подписи
        checkObject("Есть возражение");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "4 - Добавляем ПМ, вид профилактический визит (статус в процессе заполнения)")
    public void createPEventPreventiveVisitStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setNameKNOPMDropDown(nameKNO);
        setKindControlAndNumberPMDropDown(viewKNO);
        setKindPMDropDown(typePreventiveVisitPM);
       // setStartDate(dataStart);
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
        gotoListPreventionEventsPage();
        //openRequest(numberPM);
        openRequest("ПМ 77220660001100054149");
        //TODO разобраться, может проблема с новой вкладкой. Не находит элементы
        setStopDate(dataStop);
        /*setNoteWarningField(prefix + "авто Описание");
        clickAddContentWarningButton();
        clickAddDocumentButton();
        Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceDoc.exe");
        clickAddSignatureButton();
        Runtime.getRuntime().exec("C:\\t\\erknm_gui_autotest28\\erknm_gui_autotest\\erknm_gui_autotest\\src\\autoit\\choiceSign.exe");
        clickUploadButton();*/
        clickAddGroundsButton();
        setGroundDropDown(ground);
        clickOfficialButton();
        setOfficialField(prefix + "авто ФИО");
        setOfficialPostDropDown(officialPost);
        clickSaveButton();
        clickActionButton();
        clickSignatureButton();
        //TODO autoit выбор подписи и бывает алерт
        clickSignatureButton();
        clickSaveButton();
        checkObject("Ожидание проведения");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод Профилактического визита в статус Завершено")
    public void transferPEventPreventiveVisitStatusCompletedTest() {
        //открываем КНМ созданную в тесте 1 ранее
        clickAddInformationResultPMButton();
        setResultPMField(prefix+"авто результат");
        checkObject("Завершено");

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
