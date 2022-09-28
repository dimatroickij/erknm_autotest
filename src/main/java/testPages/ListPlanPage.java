package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanPage extends Common {
    //раздел Список планов

    public String prefix = UUID.randomUUID().toString();
    public String numberPlan;
    public String numberKNM;
    public String signatureOrNextButton = "//div[contains(@class, 'ModalActions_Container')]//button"; // Кнопка Подписать или далее на модальном окне Подписание плана или Смена статуса TODO Должен быть идентификатор
    String statusPlan = "//span[contains(@class, 'PlanHeader_Status')]"; // Статус Плана TODO Должен быть идентификатор
    String signingStatus = "//div[contains(@class, 'PlanHeader_PublishedStatus')]//span[contains(@class, 'PlanHeader_Status')]"; // Статус подписания плана TODO Должен быть идентификатор
    String addKNMButton = "//*[text()='Добавить КНМ']"; // TODO Должен быть идентификатор
    String knoDropDown = "//*[@id='kno']"; // выпадающий список Орган контроля на форме создания плана
    String prosecutorDropDown = "//*[@id='prosecutor']"; // выпадающий список Орган прокуратуры на форме создания плана
    String confirmationDeleteButton = "//*[@id='confirmButton']"; // подтверждение удаления
    String submitReviewButton = "//*[@id='planChangeStatusButton']"; // кнопка Отправить на рассмотрение
    String approveChangeStatusButton = "//div[contains(@class, 'ModalActions_ContainerSpaceBetween')]//button[2]"; // Подтверждение смены статуса TODO Должен быть идентификатор
    String historyApprovalBlock = "//*[@id='approvedHistoryBlock']"; // блок История согласования
    String historySignedBlock = "//*[@id='signedHistoryBlock']"; // блок История подписания
    String responsesFromNadzorWebBlock = "//*[@id='responsesFromWebBlock']"; // блок Статус обмена с АИК "Надзор-Web"
    String documentsBlock = "//*[@id='documentsBlock']"; // блок Список документа
    String versionsBlock = "//*[@id='versionsBlock']"; // блок Версии плана
    String reviewedPlanButton = "//div[contains(@class, 'PlanHeaderButtons_Container')]/button"; // кнопка Рассмотрено TODO Должен быть идентификатор


    String fioPlanProsecutorField = "//*[@id='fullName']"; // поле на форме смены статуса - ФИО уполномоченного прокурора, осуществившего рассмотрение данного плана
    String positionPlanProsecutorField = "//*[@id='position']"; // поле на форме смены статуса - Должность прокурора, уполномоченного на рассмотрение и осуществившего рассмотрение данного плана
    String filePlanInput = "//input[@id='documentFile']"; // Выберите файл на форме Смена статуса
    String approvePlanButton = "//*[@id='planChangeStatusButton']"; // кнопка Утвердить план

    // список КНМ
    public String numberKNMOfTableValue = "//td[@class=\"_Cell_1iybu_368 _CellErpId_1cug4_5\"]/a"; // номер КНМ в таблице списка КНМ в плане
    public String durationsOfDaysColumnName = "//div[@data-id=\"durationDays\"]"; // название колонки срок непосредственного взаимодействия в таблице списка КНМ в плане
    public String durationsOfDaysColumnValue = "//td[@class=\"_Cell_1iybu_368 _CellDurationDays_1cug4_318\"]"; // значение в колонке срок непосредственного взаимодействия в таблице списка КНМ в плане
    public String openAllKNMButton = "//div[@class=\"_PlanBodyComposition_12w7q_18\"]//a[@class=\"_PlanBodyCompostionItem_12w7q_50\"][1]"; // кнопка Перейти к перечню всех КНМ

    public ListPlanPage() throws Exception {
    }

    /**
     * Нажать Перейти к перечню всех КНМ
     */
    @Step("Нажать Перейти к перечню всех КНМ")
    public void clickAllEventsOpen() {
        $(By.xpath(openAllKNMButton)).click();
    }

    /**
     * Открытие КНМ из таблицы Список КНМ
     */
    @Step("Открытие КНМ из таблицы Список КНМ")
    public void openEventFromListEventsTable() {
        $(By.xpath(numberKNMOfTableValue)).scrollIntoView(false).click();
    }

    /**
     * Проверка статуса плана
     *
     * @param status Статус, который должен быть у плана
     */
    @Step("Проверка статуса плана - {status}")
    public void checkStatusPlan(String status) {
        $(By.xpath(statusPlan)).should(Text.text(status));
    }

    /**
     * Создание плана КНМ
     */
    @Step("Создание плана КНМ")
    public String createPlan() {
        clickAddButton();
        setKNOFormPlanDropDown();
        setProsecutorDropDown();
        clickCreateButton();
        String number = getNumberPlan();
        openCardPlan(number);
        checkStatusPlan(statusProcessFormation);
        return number;
    }

    /**
     * Создание плановой проверки в плане
     *
     * @param number Номер плана
     */
    @Step("Создание плана КНМ")
    public void addPlannedKNMInPlan(String number) throws Exception {
        openCardPlan(number);
        clickAddKNMButton();
        ListEventsPage event = new ListEventsPage();
        numberKNM = event.addPlannedKNM(viewKNOFNS, controlPurchase, futureDate, INN);
    }

    /**
     * Подтверждение перевода плана в статус
     */
    @Step("Подтверждение перевода плана в статус")
    public void approveChangeStatus(String fio, String position) {
        $(By.xpath(fioPlanProsecutorField)).setValue(fio);
        $(By.xpath(positionPlanProsecutorField)).setValue(position);
        $(By.xpath(filePlanInput)).uploadFile(new File(filePath));
        clickSignatureOrNextButton();
        clickApproveChangeStatus();
    }


    /**
     * Выбор органа контроля при создании плана
     */
    @Step("Выбор Органа контроля при создании плана")
    public void setKNOFormPlanDropDown() {
        $(By.xpath(knoDropDown)).click();
        setValueDropDownToText(nameKNO);
    }

    /**
     * Получить значение из колонки срок непосредственного взаимодействия в таблице списка КНМ в плане
     */
    @Step("Получаем значение из колонки срок непосредственного взаимодействия в таблице списка КНМ в плане")
    public String getValueOfColumnDurationOfDays() {
        return $(By.xpath(durationsOfDaysColumnValue)).getText();
    }

    /**
     * Проверка значения из колонки срок непосредственного взаимодействия в таблице списка КНМ в плане на
     * ожидаемый результат
     *
     * @param result Ожидаемый результат
     */
    @Step("Проверка значения из колонки срок непосредственного взаимодействия в таблице списка КНМ в плане на " +
            "ожидаемый результат - {result}")
    public void checkValueOfColumnDurationOfDays(String result) {
        String value = getValueOfColumnDurationOfDays();
        Assert.assertEquals(value, result);
    }

    /**
     * Выбор органа прокуратуры при создании плана
     */
    @Step("Выбор органа прокуратуры при создании плана")
    public void setProsecutorDropDown() {
        $(By.xpath(prosecutorDropDown)).click();
        setValueDropDownToText(prosecutorPlan);
    }

    /**
     * Нажатие на блок История согласования
     */
    @Step("Нажатие на блок История согласования ")
    public void clickHistoryApprovalBlock() {
        $(By.xpath(historyApprovalBlock)).click();
    }

    /**
     * Нажатие на блок История подписания
     */
    @Step("Нажатие на блок История подписания ")
    public void clickHistorySignedBlock() {
        $(By.xpath(historySignedBlock)).click();
    }

    /**
     * Нажатие на блок Статус обмена с АИК "Надзор-Web"
     */
    @Step("Нажатие на блок Статус обмена с АИК Надзор-Web ")
    public void clickResponsesFromNadzorWebBlock() {
        $(By.xpath(responsesFromNadzorWebBlock)).click();
    }

    /**
     * Нажатие на блок Список документа"
     */
    @Step("Нажатие на блок Список документа ")
    public void clickDocumentsBlock() {
        $(By.xpath(documentsBlock)).click();
    }

    /**
     * Нажатие на блок Версии плана"
     */
    @Step("Нажатие на блок Версии плана ")
    public void clickVersionsBlock() {
        $(By.xpath(versionsBlock)).click();
    }

    /**
     * Нажатие на кнопку добавить КНМ
     */
    @Step("Нажатие на кнопку добавить КНМ")
    public void clickAddKNMButton() {
        $(By.xpath(addKNMButton)).click();
    }

    /**
     * Нажатие на кнопку Удалить на форме подтверждения удаления
     */
    @Step("Нажатие на кнопку Удалить на форме подтверждения удаления")
    public void clickConfirmationDeleteButton() {
        $(By.xpath(confirmationDeleteButton)).click();
    }

    /**
     * Нажатие на кнопку отправить на рассмотрение
     */
    @Step("Нажатие на кнопку отправить на рассмотрение")
    public void clickSubmitReviewButton() {
        $(By.xpath(submitReviewButton)).click();
    }

    /**
     * Нажатие на кнопку Утвердить план
     */
    @Step("Нажатие на кнопку Утвердить план")
    public void clickApprovePlanButton() {
        $(By.xpath(approvePlanButton)).click();
    }

    /**
     * Нажатие на кнопку Да на форме подтверждения смены статуса плана
     */
    @Step("Нажатие на кнопку Да на форме подтверждения смены статуса плана")
    public void clickApproveChangeStatus() {
        $(By.xpath(approveChangeStatusButton)).click();
    }

    /**
     * Нажатие на кнопку Рассмотрено в плане
     */
    @Step("Нажатие на кнопку Рассмотрено в плане")
    public void clickReviewedPlanButton() {
        $(By.xpath(reviewedPlanButton)).click();
    }

    /**
     * Проверка статуса подписания плана
     *
     * @param status true - Статус Подписан, false - Статус Не подписан
     */
    @Step("Нажатие на кнопку Рассмотрено в плане")
    public void checkSigningPlan(boolean status) {
        if (status)
            $(By.xpath(signingStatus)).should(Text.text("Подписан"));
        else
            $(By.xpath(signingStatus)).should(Text.text("Не подписан"));
    }

    /**
     * Нажатие на кнопку Подписать или Далее в модальном окне Подписание плана или Смена статуса
     */
    @Step("Нажатие на кнопку Подписать или Далее в модальном окне Подписание плана или Смена статуса")
    public void clickSignatureOrNextButton() {
        $(By.xpath(signatureOrNextButton)).click();
    }

    /**
     * Перевод плана в статус На рассмотрении
     *
     * @param number номер плана
     */
    @Step("Перевод плана в статус На рассмотрении")
    public void transferPlanStatusOnConsideration(String number) throws InterruptedException {
        openCardPlan(number);
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureOrNextButton();
        closeNotification();
        checkSigningPlan(true);
        clickSubmitReviewButton();
        clickApproveChangeStatus();
        clickSaveButton();
        closeNotification();
        checkStatusPlan(statusPlanUnderConsideration);
    }


    /**
     * Перевод плана в статус Рассмотрен
     *
     * @param number номер плана
     */
    @Step("Перевод плана в статус Рассмотрен")
    public void transferPlanStatusReviewed(String number) throws Exception {
        ListEventsPage event = new ListEventsPage();
        gotoListKNMPage();
        event.openCard(numberKNM);
        event.setDecisionApplicationDropDown(approved);
        clickSaveButton();
        closeNotification();
        gotoListPlansPage();
        openCardPlan(number);
        clickReviewedPlanButton();
        approveChangeStatus(fio, "1");
        closeNotification();
        checkStatusPlan(statusPlanReviewed);
        checkSigningPlan(true);
    }

    /**
     * Удаление плана
     */
    @Step("Удаление плана")
    public String deletePlan() {
        String number = createPlan();
        gotoListPlansPage();
        clickPlanCheckBox(number);
        clickDeleteButton();
        clickConfirmationDeleteButton();
        closeNotification();
        searchPlan(number, false);
        return number;
    }

    /**
     * Исключение КНМ из плана в статусе Утвержден
     *
     * @param number Номер исключаемой проверки
     */
    @Step("Исключение КНМ из плана в статусе Утвержден")
    public void exceptionKNMFromApprovedPlan(String number) throws Exception {
        ListEventsPage event = new ListEventsPage();
        gotoListKNMPage();
        event.openCard(number);
        event.clickActionsOnCardButton();
        event.excludeKNMFromPlan();
    }
}
