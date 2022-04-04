package testPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanPage extends Common {
    //раздел Список планов
    String addKNMButton = "//*[text()='Добавить КНМ']";
    String knoDropDown="//*[@id='kno']"; //выпадающий список Орган контроля на форме создания плана
    String prosecutorDropDown="//*[@id='prosecutor']"; //выпадающий список Орган прокуратуры на форме создания плана
    String numberPlan = "//*[contains(@class,'Notification_ClosingNotificationText_') and contains(string(),'План 2')]"; //для получения номера плана
    String confirmationDeleteButton = "//*[@id='confirmButton']"; //подтверждение удаления
    String submitReviewButton = "//*[@id='planChangeStatusButton']"; //кнопка Отправить на рассмотрение
    String historyApprovalBlock = "//*[@id='approvedHistoryBlock']";//блок История согласования
    String historySignedBlock = "//*[@id='signedHistoryBlock']";//блок История подписания
    String responsesFromNadzorWebBlock = "//*[@id='responsesFromWebBlock']";//блок Статус обмена с АИК "Надзор-Web"
    String documentsBlock = "//*[@id='documentsBlock']";//блок Список документа
    String versionsBlock = "//*[@id='versionsBlock']";//блок Версии плана

    /**
     * Выбор органа контроля при создании плана
     */
    @Step("Выбор Органа контроля при создании плана")
    public void setKNOFormPlanDropDown(){
        $(By.xpath(knoDropDown)).click();
        clickToText(nameKNO);
    }
    /**
     * Выбор органа прокуратуры при создании плана
     */
    @Step("Выбор органа прокуратуры при создании плана")
    public void setprosecutorDropDown(){
        $(By.xpath(prosecutorDropDown)).click();
        clickToText(prosecutorPlan);
    }

    /**
     * Нажатие на блок История согласования
     */
    @Step("Нажатие на блок История согласования ")
    public void clickHistoryApprovalBlock(){
        $(By.xpath(historyApprovalBlock)).click();
    }

    /**
     * Нажатие на блок История подписания
     */
    @Step("Нажатие на блок История подписания ")
    public void clickHistorySignedBlock(){
        $(By.xpath(historySignedBlock)).click();
    }

    /**
     * Нажатие на блок Статус обмена с АИК "Надзор-Web"
     */
    @Step("Нажатие на блок Статус обмена с АИК Надзор-Web ")
    public void clickResponsesFromNadzorWebBlock(){
        $(By.xpath(responsesFromNadzorWebBlock)).click();
    }

    /**
     * Нажатие на блок Список документа"
     */
    @Step("Нажатие на блок Список документа ")
    public void clickDocumentsBlock(){
        $(By.xpath(documentsBlock)).click();
    }

    /**
     * Нажатие на блок Версии плана"
     */
    @Step("Нажатие на блок Версии плана ")
    public void clickVersionsBlock(){
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
        String number = messageNumber.replaceAll("\\D+","");
        return number;
    }

    /**
     * Выбор чек-бокса по номеру плана
     */
    @Step("Выбор чек-бокса по номеру плана - {number}")
    public void clickCheckBoxListPlan(String number){
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
    public void clickSubmitReviewButton(){
        $(By.xpath(submitReviewButton)).click();
    }

}
