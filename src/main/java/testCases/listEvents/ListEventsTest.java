package testCases.listEvents;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import testPages.ListEventsPage;


import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

//раздел Список КНМ
public class ListEventsTest extends ListEventsPage {

    public String numberKNM = "";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);

    public ListEventsTest() throws Exception {
    }


    /**
     * Цель: Создание внеплановой КНМ требующей согласования
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)")
    public void createEventStatusProcessCompletionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        checkObject("В процессе заполнения");
        numberKNM = getNumberKNM();
        numberPublishedKNMBVT = numberKNM;
        logout();
    }

    /**
     * Цель: Создание шаблонов обязательных требований (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание шаблонов обязательных требований (для ЕРКНМ)")
    public void createTemplateMandatoryRequirementsERKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        //TODO: иногда при скроле до элемента верхняя панель перекрывает поля для ввода
        createMandatoryRequirements(prefix + "авто",prefix + "авто",currentDate);
        clickSaveButton();
        closeNotification();
        checkObject(prefix +"авто");
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус готово к согласованию
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус готово к согласованию", dependsOnMethods={"createTemplateMandatoryRequirementsERKNMTest"})
    public void transferEventStatusReadyApprovalTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        setDateTimePublicationDecisionField(currentDate);
        setSolutionNumberField(prefix +"");
        setPlaceDecisionField(prefix + "автотестМесто");
        setNameOfficialField(prefix + "autoFIO");
        setPositionPersonSignedDecisionsDropDown();
        setDurationDaysField("1");
        addGroundsConductingUnscheduled(filePath,signPath,needCoordination);
        addListActions(currentDate,currentDate);
        clickAddVenueButton();
        setVenueField(prefix + "автотестместо");
        closeNotification();
        clickSaveButton();
        closeNotification();
        checkObject("Готово к согласованию");
       // clickActionsHeaderButton();
        clickActionsOnCardButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        closeNotification();
        closeNotification();
        checkSuccessfullySignNotification();
        closeNotification();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус на согласовании
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус на согласовании", dependsOnMethods={"transferEventStatusReadyApprovalTest"})
    public void transferEventStatusOnApprovalTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        clickActionsOnCardButton();
        clickForApprovalButton();
        checkObject("На согласовании");
        closeNotification();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус ожидает завершения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус ожидает завершения", dependsOnMethods={"transferEventStatusOnApprovalTest"})
    public void transferEventStatusAgreedTest() throws Exception {
        authorization("prosecutor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        setDecisionApplicationDropDown(approved);
        clickSaveButton();
        checkObject("Ожидает завершения");
        closeNotification();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус завершено
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус завершено", dependsOnMethods={"transferEventStatusAgreedTest"})
    public void transferEventStatusWaitCompletedTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        addInformationAboutAct(filePath,signPath,number,currentDate,currentDate,number,fio,fio,"Факт устранения",familiarWith,fio,positionDirectorTerritorialAuthority);
        clickSaveButton();
        checkObject("Завершено");
        closeNotification();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус ожидает проведения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    // TODO не работает перевод в статус Ожидает проведения (не активно поле Решение по заявлению)
    @Test(description = "Перевод КНМ в статус ожидает проведения")
    public void transferEventStatusLookingForwardTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, futureDate, prosecutorsOffice, INN);
        numberKNM = getNumberKNM();
        createMandatoryRequirements(prefix + "авто",prefix + "авто",futureDate);
        clickSaveButton();
        closeNotification();
        checkObject(prefix +"авто");
        setDateTimePublicationDecisionField(futureDate);
        setSolutionNumberField(prefix +"");
        setPlaceDecisionField(prefix + "автотестМесто");
        setNameOfficialField(prefix + "autoFIO");
        setPositionPersonSignedDecisionsDropDown();
        setDurationDaysField("1");
        addGroundsConductingUnscheduled(filePath,signPath,needCoordination);
        addListActions(futureDate,futureDate);
        clickAddVenueButton();
        setVenueField(prefix + "автотестместо");
        closeNotification();
        clickSaveButton();
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        clickActionsOnCardButton();
        clickForApprovalButton();
        closeNotification();
        closeNotification();
        closeNotification();
        logout();
        authorization("prosecutor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        setDecisionApplicationDropDown(approved);
        clickSaveButton();
        checkObject("Ожидает проведения");
        closeNotification();
        logout();

    }

    /**
     * Цель: Удаление КНМ
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Удаление КНМ")
    public void deleteEventTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        numberUnpublishedKNMBVT = getNumberKNM();
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        closeNotification();
        checkObject("Удалено");
        logout();
    }

    /**
     * Цель: Создание шаблонов проверочных листов (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРКНМ)")
    public void createTemplateTestSheetsERKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, raidInspection, currentDate, prosecutorsOffice, INN);
        addCheckList(prefix+"");
        clickSaveButton();
        checkObject("Проверочный лист №1");
        closeNotification();
        logout();
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Добавление уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addRepresentativesERKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        addInformationAboutOfficialsParticipatingInTheKNM(prefix+ fio);
        clickSaveButton();
        closeNotification();
        checkOfficialsParticipatingInTheKNM(prefix + fio);
        logout();
    }

}
