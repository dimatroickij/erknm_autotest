package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

//раздел Список КНМ
public class ListEventsTest extends ListEventsPage {

    public String numberKNM = "";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);


    /**
     * Цель: Создание внеплановой КНМ требующей согласования
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)")
    public void createEventStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
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
    public void createTemplateMandatoryRequirementsERKNMTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77220660001100009009");
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
   // @Test(description = "2 - Перевод КНМ в статус готово к согласованию")
    public void transferEventStatusReadyApprovalTest() {
        installPlugin();
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77220660001100009009");
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
    //@Test(description = "3 - Перевод КНМ в статус на согласовании")
    public void transferEventStatusOnApprovalTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
       // openCard("77220660001100009009");
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
    @Test(description = "Перевод КНМ в статус ожидает завршения", dependsOnMethods={"transferEventStatusOnApprovalTest"})
    //@Test(description = "4 - Перевод КНМ в статус ожидает завршения")
    public void transferEventStatusAgreedTest() {
        authorization("prosecutor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77220660001100009009");
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
    //@Test(description = "5 - Перевод КНМ в статус завершено")
    public void transferEventStatusWaitCompletedTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77220660001100009009");
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
    // TODO не работает подгрузка плагина
    @Test(description = "Перевод КНМ в статус ожидает проведения")
    public void transferEventStatusLookingForwardTest() {
        installPlugin();
        authorization("supervisor");
        choiceERKNM();
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
        logout();
        authorization("prosecutor");
        choiceERKNM();
        gotoListKNMPage();
        // openCard("numberKNM");
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
    public void deleteEventTest() {
        authorization("supervisor");
        choiceERKNM();
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
    public void createTemplateTestSheetsERKNMTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
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
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addRepresentativesERKNMTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        addInformationAboutOfficialsParticipatingInTheKNM(prefix+ fio);
        checkObject(prefix + fio);
        closeNotification();
        logout();
    }

}
