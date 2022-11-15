package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ListPlanPage extends Common {
    //раздел Список планов

    public String prefix = UUID.randomUUID().toString();
    public String numberPlan;
    public String numberKNM;
    String iconToBackPlan = "//div[contains(@class,'_TitleBlock')]/a"; // кнопка назад, вернуться в план
    public String signatureOrNextButton = "//*[@id='modal']//button[@id=\"signButton\"]"; // Кнопка Подписать или далее на модальном окне Подписание плана или Смена статуса TODO Должен быть идентификатор
    String statusPlan = "//*[contains(@class,'_TitleBlock')]/span[contains(@class, '_Status')]"; // Статус Плана TODO Должен быть идентификатор
    String signingStatus = "//div[contains(@class, '_PublishedStatus')]//span[contains(@class, '_Status')]"; // Статус подписания плана TODO Должен быть идентификатор
    String addKNMButton = "//*[contains(@class,'_PlanBodyHeaderContainer_')]/button"; // TODO Должен быть идентификатор
    String knoDropDown = "//*[@id='kno']"; // выпадающий список Орган контроля на форме создания плана
    String prosecutorDropDown = "//*[@id='prosecutor']"; // выпадающий список Орган прокуратуры на форме создания плана
    String confirmationDeleteButton = "//*[@id='confirmButton']"; // подтверждение удаления
    String submitReviewButton = "//*[@id='planChangeStatusButton']"; // кнопка Отправить на рассмотрение
    String approveChangeStatusButton = "//*[@id='modal']//div[contains(@class,\"ContainerSpaceBetween\")]/button[2]"; // Подтверждение смены статуса TODO Должен быть идентификатор
    String historyApprovalBlock = "//*[@id='approvedHistoryBlock']"; // блок История согласования
    String historySignedBlock = "//*[@id='signedHistoryBlock']"; // блок История подписания
    String responsesFromNadzorWebBlock = "//*[@id='responsesFromWebBlock']"; // блок Статус обмена с АИК "Надзор-Web"
    String documentsBlock = "//*[@id='documentsBlock']"; // блок Список документа
    String versionsBlock = "//*[@id='versionsBlock']"; // блок Версии плана
    String reviewedPlanButton = "//div[contains(@class, '_HeaderContent')]//button[contains(@class, '_ButtonSuccess')]"; // кнопка Рассмотрено TODO Должен быть идентификатор


    String fioPlanProsecutorField = "//*[@id='fullName']"; // поле на форме смены статуса - ФИО уполномоченного прокурора, осуществившего рассмотрение данного плана
    String positionPlanProsecutorField = "//*[@id='position']"; // поле на форме смены статуса - Должность прокурора, уполномоченного на рассмотрение и осуществившего рассмотрение данного плана
    String filePlanInput = "//input[@id='documentFile']"; // Выберите файл на форме Смена статуса
    String buttonUpdate = "//div[@id='modal']//div[contains(@class,'_Container_')]/button"; // кнопка Далее в форме Смена статуса
    String approvePlanButton = "//*[@id='planChangeStatusButton']"; // кнопка Утвердить план

    // список КНМ
    public String numberKNMOfTableValue = "//td[contains(@class,\"CellErpId\")]/a"; // номер КНМ в таблице списка КНМ в плане
    public String durationsOfDaysColumnName = "//div[@data-id=\"durationDays\"]"; // название колонки срок непосредственного взаимодействия в таблице списка КНМ в плане
    public String durationsOfDaysColumnValue = "//td[contains(@class,\"CellDurationDays\")]"; // значение в колонке срок непосредственного взаимодействия в таблице списка КНМ в плане
    public String openAllKNMButton = "//div[contains(@class,\"PlanBodyComposition\")]//a[contains(@class,\"PlanBodyCompostionItem\")][1]"; // кнопка Перейти к перечню всех КНМ
    public String openAgreedKNMButton = "//div[contains(@class,\"PlanBodyComposition\")]//a[contains(@class,\"PlanBodyCompostionItem\")][3]"; // кнопка Перейти к перечню согласованных КНМ
    public String openExcludedKNMButton = "//div[contains(@class,\"PlanBodyComposition\")]//a[contains(@class,\"PlanBodyCompostionItem\")][4]"; // кнопка Перейти к перечню исключенных КНМ
    public String openUnderConsiderationKNMButton = "//div[contains(@class,\"PlanBodyComposition\")]//a[contains(@class,\"PlanBodyCompostionItem\")][2]"; // кнопка Перейти к перечню КНМ на рассмотрении

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
     * Нажать Перейти к перечню согласованных КНМ
     */
    @Step("Нажать Перейти к перечню согласованных КНМ")
    public void clickAgreedEventsOpen() {
        $(By.xpath(openAgreedKNMButton)).click();
    }

    /**
     * Нажать Перейти к перечню исключенных КНМ
     */
    @Step("Нажать Перейти к перечню исключенных КНМ")
    public void clickExcludedEventsOpen() {
        $(By.xpath(openExcludedKNMButton)).click();
    }

    /**
     * Нажать Перейти к перечню КНМ на рассмотрении
     */
    @Step("Нажать Перейти к перечню КНМ на рассмотрении")
    public void clickUnderConsiderationEventsOpen() {
        $(By.xpath(openUnderConsiderationKNMButton)).click();
    }

    /**
     * Вернуться в план
     */
    @Step("Вернуться в план")
    public void backToPlan() {
        $(By.xpath(iconToBackPlan)).click();
    }

    /**
     * Открытие КНМ из таблицы Список КНМ
     */
    @Step("Открытие КНМ из таблицы Список КНМ")
    public void openEventFromListEventsTable() {
        $(By.xpath(numberKNMOfTableValue)).scrollIntoView(false).click();
        switchTo().window(1);
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
     *
     * @param nameKNO        Наименование органа контроля
     * @param prosecutorName Наименование прокуратуры
     */
    @Step("Создание плана КНМ: Наименование органа контроля - {nameKNO}, Наименование прокуратуры - {prosecutorName}")
    public String createPlan(String nameKNO, String prosecutorName) {
        clickAddButton();
        setKNOFormPlanDropDown(nameKNO);
        //setProsecutorDropDown(prosecutorName);
        clickCreateButton();
        return getNumberPlan();
    }

    /**
     * Создание плановой проверки в плане
     *
     * @param number         Номер плана
     * @param viewKNO        Вид контроля (надзора) и его нормер
     * @param kind           Вид КНМ
     * @param startDate      Дата начала КНМ
     * @param stopDate       Дата окончания КНМ
     * @param days           Срок непосредственного взаимодействия дней
     * @param hours          Срок непосредственного взаимодействия часов
     * @param typePerson     Тип контролируемого лица
     */
    @Step("Создание плановой КНМ через план - {number}: Вид контроля (надзора) - {viewKNO}, Вид КНМ - {kind}, " +
            "Дата начала КНМ - {startDate}, Дата окончания КНМ - {stopDate}, Срок непосредственного взаимодействия дней" +
            " - {days}, Срок непосредственного взаимодействия часов - {hours}, Тип контролируемого лица - {typePerson}")
    public void addPlannedKNMInPlan(String number, String viewKNO, String kind, String startDate, String stopDate, String days,
                                    String hours, String typePerson) throws Exception {
        openCardPlan(number);
        clickAddKNMButton();
        ListEventsPage event = new ListEventsPage();
        numberKNM = event.addPlannedKNM(viewKNO, kind, startDate, stopDate, days, hours, typePerson);
    }

    /**
     * Подтверждение перевода плана в статус
     */
    @Step("Подтверждение перевода плана в статус")
    public void approveChangeStatus() throws InterruptedException {
        $(By.xpath(fioPlanProsecutorField)).setValue(prefix + " Авто ФИО");
        $(By.xpath(positionPlanProsecutorField)).setValue(prefix + " Авто должность");
        $(By.xpath(filePlanInput)).uploadFile(new File(filePath));
        $(By.xpath(buttonUpdate)).click();
        clickApproveChangeStatus();
    }


    /**
     * Выбор органа контроля при создании плана
     *
     * @param nameKNO  Наименование органа контроля
     */
    @Step("Выбор Органа контроля - {nameKNO} при создании плана")
    public void setKNOFormPlanDropDown(String nameKNO) {
        $(By.xpath(knoDropDown)).click();
        setValueDropDownToText(nameKNO);
    }

    /**
     * Получить значение из колонки срок непосредственного взаимодействия в таблице списка КНМ в плане
     */
    @Step("Получаем значение из колонки срок непосредственного взаимодействия в таблице списка КНМ в плане")
    public String getValueOfColumnDurationOfDays() {
        return $(By.xpath(durationsOfDaysColumnValue)).shouldBe(visible, Duration.ofSeconds(15)).getText().split(" ")[0];
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
     *
     * @param prosecutorName Наименование прокуратуры
     */
    @Step("Выбор органа прокуратуры - {prosecutorName} при создании плана")
    public void setProsecutorDropDown(String prosecutorName) {
        $(By.xpath(prosecutorDropDown)).click();
        setValueDropDownToText(prosecutorName);
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
     * Проверка статуса подписи в плане
     *
     * @param status true - Статус Подписан, false - Статус Не подписан
     */
    @Step("Проверка статуса подписи в плане")
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
     */
    @Step("Перевод плана в статус На рассмотрении")
    public void transferPlanStatusOnConsideration() throws InterruptedException {
        electronicSignatureInBrowser();
        clickSubmitReviewButton();
        clickApproveChangeStatus();

        clickSaveButton();
        closeNotification();
    }

    /**
     * Подписание плана электронной подписью
     */
    @Step("Подписание плана электронной подписью")
    public void electronicSignatureInBrowser() throws InterruptedException {
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        clickSignatureOrNextButton();
        closeNotification();
    }


    /**
     * Перевод плана в статус Рассмотрен
     */
    @Step("Перевод плана в статус Рассмотрен")
    public void transferPlanStatusReviewed() throws Exception {
        clickReviewedPlanButton();
        approveChangeStatus();
        closeNotification();
    }

    /**
     * Перевод плана в статус Утвержден
     */
    @Step("Перевод плана в статус Утвержден")
    public void transferPlanStatusApproved() throws Exception {
        clickApprovePlanButton();
        clickApproveChangeStatus();
        clickSaveButton();
        closeNotification();
    }

    /**
     * Удаление плана
     */
    @Step("Удаление плана")
    public String deletePlan() {
        String number = createPlan(nameKNO, prosecutorPlan);
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
