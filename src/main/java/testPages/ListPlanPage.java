package testPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanPage extends Common {
    //раздел Список планов
    String addKNMButton = "//*[text()='Добавить КНМ']";
    String knoDropDown = "//*[@id='kno']"; //выпадающий список Орган контроля на форме создания плана
    String prosecutorDropDown = "//*[@id='prosecutor']"; //выпадающий список Орган прокуратуры на форме создания плана
    String numberPlan = "//*[contains(@class,'Notification_ClosingNotificationText_') and contains(string(),'План 2')]"; //для получения номера плана
    String confirmationDeleteButton = "//*[@id='confirmButton']"; //подтверждение удаления
    String submitReviewButton = "//*[@id='planChangeStatusButton']"; //кнопка Отправить на рассмотрение
    String approveChangeStatusButton = "/html/body/div[2]/div[1]/div[2]/button[2]"; //подтверждение смены статуса
    String historyApprovalBlock = "//*[@id='approvedHistoryBlock']";//блок История согласования
    String historySignedBlock = "//*[@id='signedHistoryBlock']";//блок История подписания
    String responsesFromNadzorWebBlock = "//*[@id='responsesFromWebBlock']";//блок Статус обмена с АИК "Надзор-Web"
    String documentsBlock = "//*[@id='documentsBlock']";//блок Список документа
    String versionsBlock = "//*[@id='versionsBlock']";//блок Версии плана
    String reviewedPlanButton = "/html/body/div/div/main/div/div[1]/div[1]/div[2]/button";//кнопка Рассмотрено
    String excludeKNMFromPlanButton = "//*[text()='Исключить из плана']"; //кнопка Исключить из плана

    String fioPlanProsecutorField = "//*[@id='fullName']"; // поле на форме смены статуса - ФИО упономоченного прокурора, осуществившего рассмотрение данного плана
    String positionPlanProsecutorField = "//*[@id='position']"; // поле на форме смены статуса - Должность прокурора, уполномоченного на рассмотрение и осуществившего рассмотрение данного плана
    String filePlanInput = "//input[@id='documentFile']"; //Выберите файл на форме Смена статуса
    String nextButton = "/html/body/div[2]/div[1]/form/div[2]/button";//кнопка Далее на форме смены статуса
    String okButton = "/html/body/div[2]/div[1]/div[2]/button[2]"; //кнопка Да на форме подтверждения смены статуса плана
    String approvePlanButton = "//*[@id='planChangeStatusButton']";//кнопка Утвердить план
    String exclusionGroundDropDown = "/html/body/div[2]/div[1]/div[1]/div[1]/div/div/div[1]"; // выпадающий список Основание исключение
    String docInput = "//input[@id='document']";//выбор документа
    String exclusionButton="//*[text()='Исключить']";//кнопка Исключить на форме исключение КНМ из плана

    /**
     * Подтверждение перевода плана в статус
     */
    @Step("Подтверждение перевода плана в статус")
    public void approveChangeStatus(String fio, String position){
        $(By.xpath(fioPlanProsecutorField)).setValue(fio);
        $(By.xpath(positionPlanProsecutorField)).setValue(position);
        $(By.xpath(filePlanInput)).uploadFile(new File(filePath));
        $(By.xpath(nextButton)).click();
        $(By.xpath(okButton)).click();
    }

    /**
     *  Исключение из плана КНМ
     */
    @Step("Исключение из плана КНМ")
    public void excludeKNMFromPlan() {
        $(By.xpath(excludeKNMFromPlanButton)).click();
        $(By.xpath(exclusionGroundDropDown)).click();
        clickToText(exclusionGround);
        $(By.xpath(docInput)).uploadFile(new File(filePath));
        $(By.xpath(exclusionButton)).click();

    }


    /**
     * Выбор органа контроля при создании плана
     */
    @Step("Выбор Органа контроля при создании плана")
    public void setKNOFormPlanDropDown() {
        $(By.xpath(knoDropDown)).click();
        clickToText(nameKNO);
    }

    /**
     * Выбор органа прокуратуры при создании плана
     */
    @Step("Выбор органа прокуратуры при создании плана")
    public void setProsecutorDropDown() {
        $(By.xpath(prosecutorDropDown)).click();
        clickToText(prosecutorPlan);
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
     * Получение номера плана
     */
    @Step("Получение номера плана - {number}")
    public String getNumberPlan() {
        String messageNumber = $(By.xpath(numberPlan)).getText();
        String number = messageNumber.replaceAll("\\D+", "");
        return number;
    }

    /**
     * Выбор чек-бокса по номеру плана
     */
    @Step("Выбор чек-бокса по номеру плана - {number}")
    public void clickCheckBoxListPlan(String number) {
        $(By.xpath("//*[@id='" + number + "']")).click();
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
}
