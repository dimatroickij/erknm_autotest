package testPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;

public class SearchERPPage extends Common {

    public String knmListCell = "//tbody//td";

    /**
     * проверка смуществования КНМ на странице Список проверок
     *
     * @param knm Номер КНМ
     */
    public void checkKNM(String knm, boolean exist) {
        Condition condition = exist ? appear : not(appear);
        if (exist)
            $(By.xpath(knmListCell)).should(Text.text(knm));//.parent().should(Text.text(status));
        else
            $(By.xpath(knmListCell)).shouldNot(Text.text(knm));
    }
}
