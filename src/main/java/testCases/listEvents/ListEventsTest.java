package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsPage;

//раздел Список КНМ
public class ListEventsTest extends ListEventsPage {

    public String numberKNM = "";


    /**
     * Цель: Создание внеплановой КНМ требующей согласования
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)", priority=1)
    public void createEventStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        checkObject("В процессе заполнения");
        numberKNM = getNumberKNM();
        //
    }

    /**
     * Цель: Перевод КНМ в статус готово к согласованию
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Перевод КНМ в статус готово к согласованию", dependsOnMethods={"createEventStatusProcessCompletionTest"})
    public void transferEventStatusReadyApprovalTest() {
     /*   open("http://private.proverki.local/private/knm/808253");
        setLogin(loginProsecutor);
        setPassword(password);
        clickEnterButton();
        numberKNM = getNumberKNM();*/
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard("ПМ 77220660001100054148");
        setDateTimePublicationDecisionField(currentDate);
        setSolutionNumberField("prefix");
        setPlaceDecisionField("prefix + автотестМесто");
        setNameOfficialField("prefix + autoFIO");
        setPositionPersonSignedDecisionsDropDown();
        setDurationDaysField("1");
        clickAddGroundConductingButton();
        setGroundConduсtingDropDown();
        setNeedCoordinationDropDown();
        clickAddFoundationButton();
        setTypeDocumentDropDown();
        clickAddFileButton();
        //добавить автоит
        clickAddListActionsButton();
        setTypeActionsDropDown();
        setDateStartActions(currentDate);
        setDateEndActions(currentDate);
        createMandatoryRequirements("","",currentDate);

        clickAddVenueButton();
        setVenueField("prefix + автотестместо");

    }

    /**
     * Цель: Перевод КНМ в статус на согласовании
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод КНМ в статус на согласовании", dependsOnMethods={"transferEventStatusReadyApprovalTest"})
    public void transferEventStatusOnApprovalTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /**
     * Цель: Перевод КНМ в статус согласована
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "4 - Перевод КНМ в статус согласована", dependsOnMethods={"transferEventStatusOnApprovalTest"})
    public void transferEventStatusAgreedTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /**
     * Цель: Перевод КНМ в статус завершена
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод КНМ в статус завершена", dependsOnMethods={"transferEventStatusAgreedTest"})
    public void transferEventStatusWaitCompletedTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /**
     * Цель: Перевод КНМ в статус ожидает завершения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод КНМ в статус ожидает завершения")
    public void transferEventStatusWaitCompletionsTest() {
        //открываем КНМ созданную в тесте 1 ранее // создаем c датой в будущем и переводим
    }

    /**
     * Цель: Удаление КНМ
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление КНМ")
    public void deleteEventTest() {
        //createEventStatusProcessCompletionTest();
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        searchRequest("77220660001100054553");
        choiceERKNM();
        clickActionButton();
        clickDeleteButton();
        checkObject("Удалено");
        gotoListKNMPage();

    }

    /**
     * Цель: Создание шаблонов обязательных требований (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание шаблонов обязательных требований (для ЕРКНМ)")
    public void createTemplateMandatoryRequirementsERKNMTest() {
        //создаем новую и добавляем ОТ
    }

    /**
     * Цель: Создание шаблонов проверочных листов (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРКНМ)")
    public void createTemplateTestSheetsERKNMTest() {
        //создаем новую и добавляем проверочные листы
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addRepresentativesERKNMTest() {
        //создаем новую и добавляем уполномоченных
    }

}
