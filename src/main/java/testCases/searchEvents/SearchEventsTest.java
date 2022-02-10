package testCases.searchEvents;

import org.testng.annotations.Test;
import testPages.Common;
import testPages.ListEventsPage;

public class SearchEventsTest extends Common {
    //раздел Поиск мероприятий
    String numberKNM="";

    /**
     * Цель: Проверка поиска опубликованных КНМ
     * HP ALM  td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3322
     * @author Frolova S.I 02.2022
     */
    @Test(description = "1 - Проверка работоспособности поиска КНМ")
    public void checkFunctionalitySearchKNMTest(){
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        ListEventsPage event = new ListEventsPage();
        //не требует согласования
        //TODO баг отображения публикации, тк КНМ с видом Контрольная закупка публикуются после внесения результатов(те статус Завершено) + 1 день
        event.addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate,prosecutorsOffice, INN);
        //опубликовать эту кнм и найти ее
        searchRequest(numberKNM);
        checkObject(numberKNM);
//Документарная проверка
//Выездная проверка
    }
}
