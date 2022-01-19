package erknm_gui_autotest.src.java.testCases.searchEvents;

import erknm_gui_autotest.src.java.testPages.Common;
import org.testng.annotations.Test;

public class SearchEventsTest extends Common {
    //раздел Поиск мероприятий
    String numberKNM="";

    /*
    author Frolova S.I 01.2022
     */
    @Test(description = "1 - Проверка работоспособности поиска КНМ")
    public void checkFunctionalitySearchKNMTest(){
        // TODO подставить номер созданной КНМ - numberKNM
        searchRequest(numberKNM);
        checkObject(numberKNM);

    }
}
