package testPages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AnalyticsPage extends Common {

    public AnalyticsPage() throws Exception {
    }

    public String exceptEverythingValue = "//tr[contains(@class, 'AccrodionHeadContent')][1]/td[6]//a"; // Значение Итого в колонке Исключено на основании "А" П. 14 ПП 2428
    public String plannedKNMValue = "//tr[contains(@class, 'AccrodionHeadContent')][1]/td[7]//a"; // Значение Итого в колонке Проведено плановых КНМ
    public String statusColumnValue = "//table[contains(@class,\"Table\")]//tr/td[6]"; // Значения в колонке статусы КНМ

    /**
     * Нажать на значение в ячейке таблицы Аналитика
     *
     * @param tableCell    локатор ячейки в таблице
     */
    @Step("Нажать на значение в ячейке - {tableCell} таблицы Аналитика")
    public void clickOnValueOfTableCell(String tableCell) {
        $(By.xpath(tableCell)).scrollIntoView(false).click();
    }

    /**
     * Проверка статусов КНМ в таблице
     *
     * @param statusKNM     Ожидаемый статус КНМ
     */
    @Step("Проверка статусов КНМ в таблице на соответствие - {statusKNM}")
    public void checkStatusKNMInTable(String statusKNM) {
        ElementsCollection statuses = $$ (By.xpath(statusColumnValue));
        for (WebElement status : statuses)  {
            Assert.assertEquals(status.getText(), statusKNM);
        }
    }

}
