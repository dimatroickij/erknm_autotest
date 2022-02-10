package testPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanERPPage extends Common {

    public String controlAuthorityDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[1]/div[2]"; // Выпадающий список Орган контроля
    public String prosecutorOfficeDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[2]/div[2]"; // Выпадающий список Орган прокуратуры
    public String typePlanDropDown = "//div[contains(@class, 'ModalBody_Body')]/div[3]/div[2]"; // Выпадающий список Тип плана КНМ
    public String selectValue = "//div[contains(@class, 'select-field__option') and text()='%s']"; // Локатор для выбора определенного значения в выпадающем списке

    public String planCheckBox = "//*[@id='%s']"; // Чекбокс у номера плана в списке планов
    public String confirmationDeleteButton = "//div[contains(@class, 'ConfirmModal_Footer')]/button"; // Кнопка Удалить в модальном окне подтверждения удаления

    public String planCellMenuButton = "//*[@id='%s']/../../../../..//td[contains(@class, 'PlanListTable_CellMenu')]//button";
    public String button1 = "//ul[contains(@class, 'Dropdown_AdditionalMenu')]/li[2]/button";

    public String prosecutorsOffice = "Генеральная прокуратура Российской Федерации";
    public String summaryPlan294 = "Сводный 294ФЗ";

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
        return "";
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
     * Выбор чек-бокса по номеру плана
     *
     * @param number  Номер плана
     * @param isExist true - план должен быть в списке, false - план должен отсутствовать в списке
     */
    @Step("Поиск плана по номеру {number} {isExist}")
    public void searchPlan(String number, boolean isExist) {
        setSearchField(number);
        clickSearchButton();
        if (isExist)
            $(By.xpath(String.format(planCheckBox, number))).should(Condition.exist);
        else
            $(By.xpath(String.format(planCheckBox, number))).shouldNot(Condition.exist);
    }

    public void clickPlanCellMenuButton(String number) {
        $(By.xpath(String.format(planCellMenuButton, number))).click();
        $(By.xpath(button1)).click();
    }

}
