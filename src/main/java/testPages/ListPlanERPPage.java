package testPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListPlanERPPage extends Common {

    public String controlAuthorityDropDown = "//div[contains(@class, 'CreatePlanModal_Body')]/div[1]/div[2]";
    public String prosecutorOfficeDropDown = "//div[contains(@class, 'CreatePlanModal_Body')]/div[2]/div[2]";
    public String typePlanDropDown = "//div[contains(@class, 'CreatePlanModal_Body')]/div[3]/div[2]";

    public String prosecutorsOffice = "Генеральная прокуратура Российской Федерации";
    public String summaryPlan294 = "Сводный 294ФЗ";

    /**
     * Выбор значения в выпадающем списке Орган контроля
     *
     * @param text Значение поля
     */
    public void setControlAuthorityDropDown(String text) {
        $(By.xpath(controlAuthorityDropDown)).click();
        $(By.xpath(controlAuthorityDropDown + "//div[contains(@class, 'select-field__option') and text()='" + text
                + "']")).click();
    }

    /**
     * Выбор значения в выпадающем списке Орган прокуратуры
     *
     * @param text Значение поля
     */
    public void setProsecutorOfficeDropDown(String text) {
        $(By.xpath(prosecutorOfficeDropDown)).click();
        $(By.xpath(prosecutorOfficeDropDown + "//div[contains(@class, 'select-field__option') and text()='" + text
                + "']")).click();
    }

    public void setTypePlanDropDown(String text){
        $(By.xpath(typePlanDropDown)).click();
        $(By.xpath(typePlanDropDown + "//div[contains(@class, 'select-field__option') and text()='" + text
                + "']")).click();
    }

}
