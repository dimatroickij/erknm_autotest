package testCases.searchEvents;

import org.testng.annotations.Test;
import testPages.Common;

public class SearchEventsTest extends Common {
    //раздел Поиск мероприятий

    public SearchEventsTest() throws Exception {
    }


    /**
     * Цель: Проверка поиска опубликованных КНМ
     * HP ALM  td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3322
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "Проверка работоспособности поиска КНМ")
    public void checkFunctionalitySearchKNMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoSearchEvents();
        setSearchField(numberPublishedKNMBVT);
        checkKNMOrPMSearch(numberPublishedKNMBVT, true);
    }

    /**
     * Цель: Проверка поиска опубликованных ПМ
     * HP ALM
     *
     * @author Troitskii D.A. 06.2022
     */
    @Test(description = "Проверка работоспособности поиска ПМ")
    public void checkFunctionalitySearchPMTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoSearchEvents();
        setSearchField(numberPMEventWarningPublished);
        checkKNMOrPMSearch(numberPMEventWarningPublished, true);
        setSearchField(numberPMPreventiveVisitPublished);
        checkKNMOrPMSearch(numberPMPreventiveVisitPublished, true);
    }
}
