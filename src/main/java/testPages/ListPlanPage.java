package testPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanPage extends Common {
    //раздел Список планов
    String addKNMButton = "//*[text()='Добавить КНМ']";
    String numberPlan = "//*[contains(@class,'Notification_ClosingNotificationText_') and contains(string(),'План 2')]"; //для получения номера плана
    String confirmationDeleteButton = "/html/body/div/div/main/div/div[1]/div[3]/div/div[3]/button[1]"; //подтверждение удаления
    String submitReviewButton = "//*[text()='Отправить на рассмотрение']";
    String signInBrowserButton = "//*[text()='Подписать в браузере']";

    /**
     * Нажатие на кнопку добавить КНМ
     */
    public void clickAddKNMButton() {
    $(By.xpath(addKNMButton)).click();
    }

    /**
     * Получение номера плана
     */
    public String getNumberPlan() {
        String messageNumber = $(By.xpath(numberPlan)).getText();
        String number = messageNumber.replaceAll("\\D+","");
        return number;
    }

    /**
     * Выбор чек-бокса по номеру плана
     */
    public void clickCheckBoxListPlan(String number){
        $(By.xpath("//*[@id='" + number + "']")).click();
    }

    /**
     * Нажатие на кнопку Удалить на форме подтверждения удаления
     */
    public void clickСonfirmationDeleteButton() {
        $(By.xpath(confirmationDeleteButton)).click();
    }

    /**
     * Нажатие на кнопку отправить на рассмотрение
     */
    public void clickSubmitReviewButton(){
        $(By.xpath(submitReviewButton)).click();
    }
    
    /**
     * Нажатие на кнопку подписать в браузере
     */
    public void clickSignInBrowserButton(){
        $(By.xpath(signInBrowserButton)).click();
    }


}
