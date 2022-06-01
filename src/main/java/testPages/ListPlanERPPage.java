package testPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class ListPlanERPPage extends Common {

    public String controlAuthorityDropDown = "//*[@id='kno']"; // Выпадающий список Орган контроля
    public String prosecutorOfficeDropDown = "//*[@id='prosecutor']"; // Выпадающий список Орган прокуратуры
    public String typePlanDropDown = "//*[@id='type']"; // Выпадающий список Тип плана КНМ

    public String planStatusText = "//*[@id='%s']/../../../../..//td[contains(@class, 'PlanListTable_CellStatus')]"; // Ячейка со статусом плана TODO Должен быть идентификатор
    public String planCountKNMText = "//*[@id='%s']/../../../../..//td[contains(@class, 'PlanListTable_CellKnmAmount')]"; // Ячейка с количеством провеерок в плане TODO Должен быть идентификатор

    public String planCellMenuButton = "//*[@id='%s']/../../../../..//td[contains(@class, 'Table_MenuTBody')]//button"; // Кнопка - гамбургер у плана TODO Должен быть идентификатор
    public String addKNMtoPlanButton = "//ul[contains(@class, 'Dropdown_Menu')]/li[1]"; // Кнопка Добавить существующее КНМ в меню - гамбургере TODO Должен быть идентификатор
    public String changeStatusButton = "//ul[contains(@class, 'Dropdown_Menu')]/li[2]"; // Кнопка Изменить статус в меню - гамбургере TODO Должен быть идентификатор
    public String statusButton = "//ul[contains(@class, 'Dropdown_Menu')]//ul//button[text()='%s']"; // Кнопка с названием статуса плана из меню - гамбургера TODO Должен быть идентификатор
    public String numberKNMField = "//div[contains(@class, 'AddKnmModal_InputBlock')]//input"; // Поле Введите учетный номер КНМ в модальном окне Добавление КНМ в план TODO Должен быть идентификатор
    public String notificationText = "//div[contains(@class, 'Notification_ClosingNotificationText')]"; // Текст уведомления об успешном добавлении КНМ TODO Должен быть идентификатор

    public String prosecutorsOffice = "Генеральная прокуратура Российской Федерации";
    public String summaryPlan294 = "Сводный 294ФЗ";

    // Статусы планов
    public String newPlan = "Новый";
    public String onRevisionPlan = "На доработке";
    public String agreedPlan = "Согласован";


    public String numberPlan; // Номер плана. Для использования в нескольких автотестах

    public ListPlanERPPage() throws Exception {
    }

    /**
     * Выбор значения в выпадающем списке Орган контроля
     *
     * @param kno Значение поля
     */
    @Step("Выбор значения в выпадающем списке Орган контроля {kno}")
    public void setControlAuthorityDropDown(String kno) {
        $(By.xpath(controlAuthorityDropDown)).click();
        setValueDropDownToText(kno);
    }

    /**
     * Выбор значения в выпадающем списке Орган прокуратуры
     *
     * @param prosecutor Значение поля
     */
    @Step("Выбор значения в выпадающем списке Орган прокуратуры {prosecutor}")
    public void setProsecutorOfficeDropDown(String prosecutor) {
        $(By.xpath(prosecutorOfficeDropDown)).click();
        setValueDropDownToText(prosecutor);
    }

    /**
     * Выбор значения в выпадающем списке Тип плана КНМ
     *
     * @param type Значение поля
     */
    @Step("Выбор значения в выпадающем списке Тип плана КНМ {type}")
    public void setTypePlanDropDown(String type) {
        $(By.xpath(typePlanDropDown)).click();
        setValueDropDownToText(type);
    }

    /**
     * Создание плана КНМ
     */
    @Step("Создание плана КНМ")
    public String createPlan() {
        refresh();
        clickAddButton();
        setControlAuthorityDropDown(nameKNO);
        setProsecutorOfficeDropDown(prosecutorsOffice);
        setTypePlanDropDown(summaryPlan294);
        clickCreateButton();
        return getNumberPlan();
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
     * Поиск плана по номеру и статусу
     *
     * @param number  Номер плана
     * @param status  Статус плана
     * @param isExist true - план должен быть в списке, false - план должен отсутствовать в списке
     */
    @Step("Поиск плана по номеру {number} и статусу {status}, {isExist}")
    public void searchPlan(String number, String status, boolean isExist) {
        //setSearchField(number);
        //clickSearchButton();
        if (isExist) {
            $(By.xpath(String.format(planStatusText, number))).should(Condition.text(status));
        } else {
            $(By.xpath(String.format(planStatusText, number))).shouldNot(Condition.text(status));
        }
    }

    /**
     * Нажатие на меню - гамбургер у выбранного плана
     *
     * @param number Номер плана
     */
    @Step("Нажатие на меню - гамбургер у выбранного плана {number}")
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
    @Step("Добавление проверки {numberKNM} в план {numberPlan}")
    public void addKNMtoPlan(String numberPlan, String numberKNM) {
        clickPlanCellMenuButton(numberPlan);
        $(By.xpath(addKNMtoPlanButton)).click();
        $(By.xpath(numberKNMField)).setValue(numberKNM);
        clickModalSaveButton();
        $(By.xpath(notificationText)).should(Condition.text("КНМ успешно добавлено к плану"));
    }


}
