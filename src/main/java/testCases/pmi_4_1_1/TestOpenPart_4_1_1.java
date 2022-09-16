package testCases.pmi_4_1_1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.OpenPartPage;

import static com.codeborne.selenide.Selenide.*;

public class TestOpenPart_4_1_1 extends OpenPartPage {

    public TestOpenPart_4_1_1() throws Exception {
    }

    /**
     * Цель: Проверка отображение полей в ОЧ ЕРКНМ и ЕРП.
     * A.1.1.11
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ОЧ")
    @Story("Поиск проверок")
    @Test(description = "A.1.1.11. Проверка отображение полей в ОЧ ЕРКНМ и ЕРП.")
    public void checkFieldsInOpenPart() throws Exception {
        open(openUrl);
        gotoHomeOpenPage();
        searchEventsWithCaptcha("77220171000000065441", captcha);
        openFoundEvent();
        checkFieldVisible("Номер поручения");
        checkFieldVisible("Дата поручения");

        switchTo().window(0);
        gotoHomeOpenPage();
        searchEventsWithoutCaptcha("77220661000000065679");
        openFoundEvent();
        checkFieldVisible("Реквизиты требования");

        switchTo().window(0);
        gotoHomeOpenPage();
        searchEventsWithoutCaptcha("772200065697");
        openFoundEvent();
        checkFieldVisible("Номер поручения");
        checkFieldVisible("Дата поручения");

        switchTo().window(0);
        gotoHomeOpenPage();
        searchEventsWithoutCaptcha("772200065688");
        openFoundEvent();
        checkFieldVisible("Реквизиты требования");
    }

}
