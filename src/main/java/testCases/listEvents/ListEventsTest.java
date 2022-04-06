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
    @Test(description = "1 - Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)", priority=1)
    public void createEventStatusProcessCompletionTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        checkObject("В процессе заполнения");
        numberKNM = getNumberKNM();
        numberPublishedKNMBVT =numberKNM;

        closeNotification();
        //logout();
    }

    /**
     * Цель: Создание шаблонов обязательных требований (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание шаблонов обязательных требований (для ЕРКНМ)", priority=2)
    public void createTemplateMandatoryRequirementsERKNMTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        openCard(numberKNM);
        //openCard("77220660001100009009");
        //TODO: иногда при скроле до элемента верхняя панель перекрывает поля для ввода
        createMandatoryRequirements(prefix +"авто",prefix +"авто",currentDate);
        clickSaveButton();
        checkObject(prefix +"авто");
        //logout();
    }

    /**
     * Цель: Перевод КНМ в статус готово к согласованию
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Перевод КНМ в статус готово к согласованию", dependsOnMethods={"createTemplateMandatoryRequirementsERKNMTest"})
   // @Test(description = "2 - Перевод КНМ в статус готово к согласованию")
    public void transferEventStatusReadyApprovalTest() {
        installPlugin();
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
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
        checkObject("Готово к согласованию");
       // clickActionsHeaderButton();
        clickActionsOnCardButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureButton();
        checkSuccessfullySignNotification(); //TODO можно увеличить время ожидания сообщения
        //logout();
    }

    /**
     * Цель: Перевод КНМ в статус на согласовании
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод КНМ в статус на согласовании", dependsOnMethods={"transferEventStatusReadyApprovalTest"})
    //@Test(description = "3 - Перевод КНМ в статус на согласовании")
    public void transferEventStatusOnApprovalTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        openCard("numberKNM");
       // openCard("77220660001100009009");
        clickActionsOnCardButton();
        clickForApprovalButton();
        checkObject("На согласовании");
    }

    /**
     * Цель: Перевод КНМ в статус ожидает завершения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "4 - Перевод КНМ в статус ожидает завршения", dependsOnMethods={"transferEventStatusOnApprovalTest"})
    //@Test(description = "4 - Перевод КНМ в статус ожидает завршения")
    public void transferEventStatusAgreedTest() {
        authorization("prosecutor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        openCard("numberKNM");
        //openCard("77220660001100009009");
        setDecisionApplicationDropDown(approved);
        clickSaveButton();
        checkObject("Ожидает завершения");
    }

    /**
     * Цель: Перевод КНМ в статус завершено
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод КНМ в статус завершено", dependsOnMethods={"transferEventStatusAgreedTest"})
    //@Test(description = "5 - Перевод КНМ в статус завершено")
    public void transferEventStatusWaitCompletedTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        openCard("numberKNM");
        //openCard("77220660001100009009");
        addInformationAboutAct(filePath,signPath,number,currentDate,currentDate,number,fio,fio,"",familiarWith,fio,positionDirectorTerritorialAuthority);
        clickSaveButton();
        checkObject("Завершено");
    }

    /**
     * Цель: Перевод КНМ в статус ожидает проведения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод КНМ в статус ожидает проведения")
    public void transferEventStatusLookingForwardTest() {
        installPlugin();
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, futureDate, prosecutorsOffice, INN);
        numberKNM = getNumberKNM();
        closeNotification();
        createMandatoryRequirements(prefix +"авто",prefix +"авто",futureDate);
        clickSaveButton();
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

    }

    /**
     * Цель: Удаление КНМ
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление КНМ")
    public void deleteEventTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        numberUnpublishedKNMBVT = getNumberKNM();
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        checkObject("Удалено");
        closeNotification();

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
        closeNotification();
        clickSaveButton();
        checkObject("Проверочный лист №1");
        //TODO сделать проверку на наименование
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addRepresentativesERKNMTest() {
        authorization("supervisor");
        sleep(2000); //TODO убрать, как пофиксят баг
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        closeNotification();
        addInformationAboutOfficialsParticipatingInTheKNM(prefix+fio);
        checkObject(prefix +fio);

    }

}
