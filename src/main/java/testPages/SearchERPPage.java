package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchERPPage extends Common {


    public String statusKNMCell = "//tr[contains(@class, KnmListTable_TbodyRow)]/td[7 and text()='%s']/../td[2]"; // Ячейка с номером КНМ в зависимости от статуса КНМ TODO должен быть идентификатор

    public SearchERPPage() throws Exception {
    }

    /**
     * Поиск КНМ в зависимости от статуса
     *
     * @param status Статус КНМ
     * @return номер КНМ
     */
    @Step("Поиск КНМ со статусом {status}")
    public String searchKNM(String status) {
        return $(By.xpath(String.format(statusKNMCell, status))).getText();
    }
}
