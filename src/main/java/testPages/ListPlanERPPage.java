package testPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanERPPage extends Common {

    public String controlAuthorityDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[1]/div[2]"; // Выпадающий список Орган контроля
    public String prosecutorOfficeDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[2]/div[2]"; // Выпадающий список Орган прокуратуры
    public String typePlanDropDown = "//div[contains(@class, 'CreatePlanModal_SelectLabel') and text()='Тип плана КНМ']/../div[2]"; // Выпадающий список Тип плана КНМ
    public String selectValue = "//div[contains(@class, 'select-field__option') and text()='%s']"; // Локатор для выбора определенного значения в выпадающем списке
    public String numberPlanNotificationText = "//div[contains(@class, 'Notification_ClosingNotificationText')]//a"; // Номер созданного плана из уведомления после создания

    public String planCheckBox = "//*[@id='%s']"; // Чекбокс у номера плана в списке планов
    public String planStatusText = "//*[@id='%s']/../../../../..//td[contains(@class, 'PlanListTable_CellStatus')]"; // Ячейка со статусом плана
    public String planCountKNMText = "//*[@id='%s']/../../../../..//td[contains(@class, 'PlanListTable_CellKnmAmount')]"; // Ячейка с количеством провеерок в плане
    public String confirmationDeleteButton = "//div[contains(@class, 'ConfirmModal_Footer')]/button"; // Кнопка Удалить в модальном окне подтверждения удаления

    public String planCellMenuButton = "//*[@id='%s']/../../../../..//td[contains(@class, 'PlanListTable_CellMenu')]//button"; // Кнопка - гамбургер у плана
    public String addKNMtoPlanButton = "//ul[contains(@class, 'Dropdown_Menu')]/li[1]"; // Кнопка Добавить существующее КНМ в меню - гамбургере
    public String changeStatusButton = "//ul[contains(@class, 'Dropdown_Menu')]/li[2]"; // Кнопка Изменить статус в меню - гамбургере
    public String statusButton = "//ul[contains(@class, 'Dropdown_Menu')]//ul//button[text()='%s']"; // Кнопка с названием статуса плана из меню - гамбургера
    public String numberKNMField = "//div[contains(@class, 'AddKnmModal_InputBlock')]//input"; // Поле Введите учетный номер КНМ в модальном окне Добавление КНМ в план
    public String notificationText = "//div[contains(@class, 'Notification_ClosingNotificationText')]"; // Текст уведомления об успешном добавлении КНМ

    public String prosecutorsOffice = "Генеральная прокуратура Российской Федерации";
    public String summaryPlan294 = "Сводный 294ФЗ";

    // Статусы планов
    public String newPlan = "Новый";
    public String onApprovalPlan = "На согласовании";
    public String onRevisionPlan = "На доработке";
    public String agreedPlan = "Согласован";
    public String approvedPlan = "Утвержден";

    public String numberPlan; // номер плана. Для использования в нескольких автотестах

    /**
     * Выбор значения в выпадающем списке Орган контроля
     *
     * @param kno Значение поля
     */
    @Step("Выбор значения в выпадающем списке Орган контроля {kno}")
    public void setControlAuthorityDropDown(String kno) {
        $(By.xpath(controlAuthorityDropDown)).click();
        $(By.xpath(controlAuthorityDropDown + String.format(selectValue, kno))).click();
    }

    /**
     * Выбор значения в выпадающем списке Орган прокуратуры
     *
     * @param prosecutor Значение поля
     */
    @Step("Выбор значения в выпадающем списке Орган прокуратуры {prosecutor}")
    public void setProsecutorOfficeDropDown(String prosecutor) {
        $(By.xpath(prosecutorOfficeDropDown)).click();
        $(By.xpath(prosecutorOfficeDropDown + String.format(selectValue, prosecutor))).click();
    }

    /**
     * Выбор значения в выпадающем списке Тип плана КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор значения в выпадающем списке Тип плана КНМ {type}")
    public void setTypePlanDropDown(String type) {
        $(By.xpath(typePlanDropDown)).click();
        $(By.xpath(typePlanDropDown + String.format(selectValue, type))).click();
    }

    /**
     * Создание плана КНМ
     */
    @Step("Создание плана КНМ")
    public String createPlan() {
        clickAddButton();
        setControlAuthorityDropDown(nameKNO);
        setProsecutorOfficeDropDown(prosecutorsOffice);
        setTypePlanDropDown(summaryPlan294);
        clickCreateButton();
        return $(By.xpath(numberPlanNotificationText)).getText();
    }

    /**
     * Выбор чек-бокса по номеру плана
     *
     * @param number Номер плана
     */
    @Step("Выбор чек-бокса по номеру плана {number}")
    public void clickPlanCheckBox(String number) {
        $(By.xpath(String.format(planCheckBox, number))).scrollIntoView(false).click();
    }

    /**
     * Нажатие на кнопку Удалить на форме подтверждения удаления
     */
    @Step("Нажатие на кнопку Удалить на форме подтверждения удаления")
    public void clickConfirmationDeleteButton() {
        $(By.xpath(confirmationDeleteButton)).click();
    }

    /**
     * Перевод плана в указанный статус
     *
     * @param status Новый статус плана
     * @param number Номер плана
     */
    @Step("Перевод плана {number} в указанный статус {status}")
    public void workToPlan(String status, String number) {
        setSearchField(number);
        clickSearchButton();
        transferOfPlanToStatus(number, status);
        closeNotification();
        searchPlan(number, status, true);
    }

    /**
     * Поиск плана по номеру
     *
     * @param number  Номер плана
     * @param isExist true - план должен быть в списке, false - план должен отсутствовать в списке
     */
    @Step("Поиск плана по номеру {number} {isExist}")
    public void searchPlan(String number, boolean isExist) {
        setSearchField(number);
        clickSearchButton();
        if (isExist) $(By.xpath(String.format(planCheckBox, number))).should(Condition.exist);
        else $(By.xpath(String.format(planCheckBox, number))).shouldNot(Condition.exist);
    }

    /**
     * Поиск плана по номеру и статусу
     *
     * @param number  Номер плана
     * @param status  Статус плана
     * @param isExist true - план должен быть в списке, false - план должен отсутствовать в списке
     */
    @Step("Поиск плана по номеру {number} и статусу {status}, {isExist}")
    public void searchPlan(String number, String status, boolean isExist) {
        String tmpStatus = status;
        if (Objects.equals(status, "Утвержден")) tmpStatus = "Утверждён"; // костыль из-за бага
        if (Objects.equals(status, "На доработке")) tmpStatus = "На проверке"; // костыль из-за бага
        //setSearchField(number);
        //clickSearchButton();
        if (isExist) {
            $(By.xpath(String.format(planStatusText, number))).should(Condition.text(tmpStatus));
        } else {
            $(By.xpath(String.format(planStatusText, number))).shouldNot(Condition.text(tmpStatus));
        }
    }

    /**
     * Нажатие на меню - гамбургер у выбранного плана
     *
     * @param number Номер плана
     */
    public void clickPlanCellMenuButton(String number) {
        $(By.xpath(String.format(planCellMenuButton, number))).click();
    }

    /**
     * Изменение статуса плана ЕРП
     *
     * @param number Номер плана ЕРП
     * @param status Новый статус плана ЕРП
     */
    @Step("Перевод плана {number} в статус '{status}'")
    public void transferOfPlanToStatus(String number, String status) {
        clickPlanCellMenuButton(number);
        $(By.xpath(changeStatusButton)).hover();
        $(By.xpath(String.format(statusButton, status))).click();
    }

    /**
     * Получение количества проверок в плане КНМ
     *
     * @param numberPlan Номер плана
     * @return Количество проверок в плане
     */
    public Integer getCountKNMToPlan(String numberPlan) {
        return Integer.parseInt($(By.xpath(String.format(planCountKNMText, numberPlan))).getText());
    }

    /**
     * Добавление проверки в план
     *
     * @param numberPlan Номер плана
     * @param numberKNM  Номер проверки
     */
    public void addKNMtoPlan(String numberPlan, String numberKNM) {
        clickPlanCellMenuButton(numberPlan);
        $(By.xpath(addKNMtoPlanButton)).click();
        $(By.xpath(numberKNMField)).setValue(numberKNM);
        clickModalAddButton();
        $(By.xpath(notificationText)).should(Condition.text("КНМ успешно добавлено к плану"));
    }


}
