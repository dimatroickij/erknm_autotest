package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsPage;

//раздел Список КНМ
public class ListEventsTest extends ListEventsPage {

    public String numberKNM;

    public ListEventsTest() throws Exception {
    }


    /**
     * Цель: Создание внеплановой КНМ требующей согласования
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)")
    public void createEventStatusProcessCompletionTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, currentDate, currentDate, interactionDays, null, prosecutorsOffice, INN);
        checkStatusKNM(statusProcessFilling);
        numberKNM = getNumberKNM();
        numberPublishedKNMBVT = numberKNM;
        logout();
    }

    /**
     * Цель: Создание шаблонов обязательных требований (для ЕРКНМ)
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Добавление шаблонов обязательных требований в КНМ (т. е. создание нового ОТ) (для ЕРКНМ)",
            dependsOnMethods = {"createEventStatusProcessCompletionTest"})
    public void createTemplateMandatoryRequirementsERKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        //иногда при скроле до элемента верхняя панель перекрывает поля для ввода
        createTemplateMandatoryRequirements();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус Готово к согласованию
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус Готово к согласованию"/*,
            dependsOnMethods = {"createTemplateMandatoryRequirementsERKNMTest"}*/)
    public void transferEventStatusReadyApprovalTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard("77210370001100042064");
        transferEventStatusReadyApproval(currentDate, currentDate, currentDate);
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус На согласовании
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус На согласовании", dependsOnMethods = {"transferEventStatusReadyApprovalTest"})
    public void transferEventStatusOnApprovalTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusOnApproval();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус Ожидает завершения
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус Ожидает завершения", dependsOnMethods = {"transferEventStatusOnApprovalTest"})
    public void transferEventStatusAgreedTest() throws Exception {
        authorization("prosecutor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, statusProcessCompletion);
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус Завершено
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус Завершено", dependsOnMethods = {"transferEventStatusAgreedTest"})
    public void transferEventStatusWaitCompletedTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusWaitCompleted();
        closeNotification();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус Не согласована
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус Не согласована")
    public void transferEventStatusNotAgreedTest() throws Exception {
        String numberNotAgreed = createKNM(rejected, statusNotAgreed);
    }

    private String createKNM(String rejected, String nextStatus) throws Exception {
        String numberKNM;
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        reloadPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, futureDate, futureDate, interactionDays, null, prosecutorsOffice, INN);
        checkStatusKNM(statusProcessFilling);
        numberKNM = getNumberKNM();
        createTemplateMandatoryRequirements();
        transferEventStatusReadyApproval(currentDate, futureDate, futureDate);
        transferEventStatusOnApproval();
        logout();
        authorization("prosecutor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(rejected, nextStatus);
        logout();
        return numberKNM;
    }

    /**
     * Цель: Перевод КНМ в статус Ожидает проведения
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус Ожидает проведения")
    public void transferEventStatusLookingForwardTest() throws Exception {
        String numberKNMLookingForward = createKNM(approved, statusProcessAwaiting);
    }

    /**
     * Цель: Удаление КНМ
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Удаление КНМ")
    public void deleteEventTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, currentDate, interactionDays, null, prosecutorsOffice, INN);
        String number = getNumberKNM();
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        closeNotification();
        checkStatusKNM(statusDeleted);
        gotoListKNMPage();
        checkKNMOrPM(number, statusDeleted, false);
        logout();
    }

    /**
     * Цель: Создание шаблонов проверочных листов (для ЕРКНМ)
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание КНМ с созданием шаблона проверочных листов (для ЕРКНМ)")
    public void createTemplateTestSheetsERKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, raidInspection, currentDate, currentDate, interactionDays, null, prosecutorsOffice, INN);
        String numberKNMTemplate = getNumberKNM();
        addCheckList(prefix);
        clickSaveButton();
        checkCheckList(prefix);
        closeNotification();
        logout();
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРКНМ)
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание КНМ с добавлением уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addRepresentativesERKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, currentDate, interactionDays, null, prosecutorsOffice, INN);
        String numberKNMRepresentatives = getNumberKNM();
        addInformationAboutOfficialsParticipatingInTheKNM(officialField);
        clickSaveButton();
        closeNotification();
        checkOfficialsParticipatingInTheKNM(officialField);
        logout();
    }

}
