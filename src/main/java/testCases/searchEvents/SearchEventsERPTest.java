package testCases.searchEvents;

import org.testng.annotations.Test;
import testPages.Common;
import testPages.SearchERPPage;

public class SearchEventsERPTest extends SearchERPPage {
    //раздел Поиск мероприятий для ЕРП

    public String knm = "772200008561";

    @Test(description = "1 - Проверка работоспособности поиска КНМ для ЕРП")
    public void checkFunctionalitySearchKNMTest() {
        authorization("supervisor");
        choiceERP();
        gotoSearchEvents();
        setSearchField(knm);
        clickSearchButton();
        checkKNM(knm, true);
        logout();
    }
}
