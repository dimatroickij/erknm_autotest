package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchERPPage extends Common {

    public String knmListCell = "//tbody//td";
    public String statusKNMCell = "//tr[contains(@class, KnmListTable_TbodyRow)]/td[7 and text()='%s']/../td[2]"; // Ячейка с номером КНМ в зависимости от статуса КНМ

    /**
     * проверка существования КНМ на странице Список проверок
     *
     * @param exist true - проверка на существование КНМ в списке, false - проверка на отсутствие КНМ
     * @param knm   Номер КНМ
     */
    @Step("Проверка существования КНМ на странице Список проверок - {knm} - {exist}")
    public void checkKNM(String knm, boolean exist) {
        setSearchField(knm);
        clickSearchButton();
        if (exist)
            $(By.xpath(knmListCell)).should(Text.text(knm));
        else
            $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
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
