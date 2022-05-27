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
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
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
    @Test(description = "Добавление шаблонов обязательных требований в КНМ (т. е. создание нового ОТ) (для ЕРКНМ)")
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
     * Цель: Перевод КНМ в статус готово к согласованию
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус готово к согласованию", dependsOnMethods = {"createTemplateMandatoryRequirementsERKNMTest"})
    public void transferEventStatusReadyApprovalTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusReadyApproval(currentDate, currentDate, currentDate);
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус на согласовании
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус на согласовании", dependsOnMethods = {"transferEventStatusReadyApprovalTest"})
    public void transferEventStatusOnApprovalTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusOnApproval();
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус ожидает завершения
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус ожидает завершения", dependsOnMethods = {"transferEventStatusOnApprovalTest"})
    public void transferEventStatusAgreedTest() throws Exception {
        authorization("prosecutor");
        choiceMode(true);
        gotoListKNMPage();
        openCard(numberKNM);
        transferEventStatusAgreed(approved, statusProcessCompletion);
        logout();
    }

    /**
     * Цель: Перевод КНМ в статус завершено
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус завершено", dependsOnMethods = {"transferEventStatusAgreedTest"})
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
        createKNM(rejected, statusNotAgreed);
    }

    private void createKNM(String rejected, String nextStatus) throws Exception {
        installPlugin();
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, futureDate, prosecutorsOffice, INN);
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
    }

    /**
     * Цель: Перевод КНМ в статус Ожидает проведения
     * HP ALM
     *
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Перевод КНМ в статус Ожидает проведения")
    public void transferEventStatusLookingForwardTest() throws Exception {
        createKNM(approved, statusProcessAwaiting);
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
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        numberUnpublishedKNMBVT = getNumberKNM();
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        closeNotification();
        checkStatusKNM(statusDeleted);
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
        addUnplannedKNM(nameKNO, viewKNO, raidInspection, currentDate, prosecutorsOffice, INN);
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
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        addInformationAboutOfficialsParticipatingInTheKNM(officialField);
        clickSaveButton();
        closeNotification();
        checkOfficialsParticipatingInTheKNM(officialField);
        logout();
    }

}
