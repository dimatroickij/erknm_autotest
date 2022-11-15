package testCases.pmi_4_1_58;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.AnalyticsPage;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * 1.1.2 Проверка отмены проведения проверок согласно требованиям ПП №336 от 10 марта 2022 г.
 */

public class TestERKNM_4_1_58 extends ListEventsPage {

    public TestERKNM_4_1_58() throws Exception {
    }

    /**
     * Цель: Проверка завершения КНМ из паспорта по кнопке «Завершить ПП 336».
     * A.1.1.2.1
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.58")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2.1 Проверка завершения КНМ из паспорта по кнопке «Завершить ПП 336».")
    public void completionKNMFromPassportTest() throws Exception {

        String[] events = new String[]{"7722231000000027948",  // ожидает проведения до 11.03.2022
                "77220370001100042115",  // ожидает завершения
                "01230511000300047085",  // ожидает проведения после 11.03.2022
                "77220660001100042205"  // другой статус до 11.03.2022
        };
        authorization("supervisor");
        selectionERKNM();
        for(String event : events){
            gotoListKNMPage();
            openCard(event);
            sleep(3000);
            System.out.println(event);
            if(event == "01230511000300047085" || event == "77220660001100042205"){
                checkElementInvisible("«Завершить ПП 336»", completePPButton);
            }
            else {
                checkElementVisible("«Завершить ПП 336»", completePPButton);
                clickButtonCompletePP();
                checkTextContent(textModalForCompletePP, "[Изменение данных" +
                        " в КНМ после его завершения будет недоступно. Перед выполнением действия по завершению КНМ по ПП336, " +
                        "выполните сохранение изменений путем нажатия на кнопку «Сохранить»., Действие по завершению КНМ по ПП336" +
                        " является необратимым и является отменой проведения КНМ на основании постановления Правительства " +
                        "Российской Федерации от 10 марта 2022 г. № 336 «Об особенностях организации и осуществления государственного" +
                        " контроля (надзора), муниципального контроля».]");
                clickNotButtonForModalCompletePP();
            }
        }
    }

    /**
     * Цель: Доработка справочных значений оснований для исключения КНМ из утвержденных планов.
     * A.1.1.2.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.58")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2.2 Доработка справочных значений оснований для исключения КНМ из утвержденных планов.")
    public void referenceValuesForGroundsForExclusionTest() throws Exception {
        ListPlanPage planPage = new ListPlanPage();
        authorization("supervisor");
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan("2023002609");
        planPage.clickAgreedEventsOpen();
        planPage.openEventFromListEventsTable();
        switchTo().window(1);
        String numberEvent = getNumberKNM();
        excludeKNMFromPlan();
        switchTo().window(0);
        gotoListPlansPage();
        openCardPlan("2023002609");
        planPage.clickExcludedEventsOpen();
        openCardForPlan(numberEvent);
    }

    /**
     * Цель: Проверка логики отображения исключенных из плана КНМ в модуле аналитики.
     * A.1.1.2.3
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.58")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2.3 Проверка логики отображения исключенных из плана КНМ в модуле аналитики.")
    public void displayOfKNMExcludedFromPlanTest() throws Exception {
        AnalyticsPage analytics = new AnalyticsPage();
        authorization("prosecutor");
        selectionERKNM();
        gotoAnalyticsPage();
        sleep(10000);
        analytics.clickOnValueOfTableCell(analytics.exceptEverythingValue);
        analytics.checkStatusKNMInTable(statusExcluded);

        gotoAnalyticsPage();
        sleep(10000);
        analytics.clickOnValueOfTableCell(analytics.plannedKNMValue);
        sleep(5000);
        analytics.checkStatusKNMInTable(statusCompleted);
    }




}
