package testCases.searchEvents;

import org.testng.annotations.Test;
import testPages.Common;
import testPages.ListEventsPage;

public class SearchEventsTest extends Common {
    //раздел Поиск мероприятий
    String numberKNM = "";


    /**
     * Цель: Проверка поиска опубликованных КНМ
     * HP ALM  td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3322
     *
     * @author Frolova S.I 02.2022
     */
    @Test(description = "1 - Проверка работоспособности поиска КНМ")
    public void checkFunctionalitySearchKNMTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        ListEventsPage event = new ListEventsPage();
        event.addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        gotoSearchEvents();
        searchRequest(numberKNM);
        checkAbsenceObject(numberKNM);
        gotoListKNMPage();
        openCard(numberKNM);

        event.setDateTimePublicationDecisionField(currentDate);
        event.setSolutionNumberField(number);
        event.setPlaceDecisionField(place);
        event.setNameOfficialField(fio);
        event.setPositionPersonSignedDecisionsDropDown();
        event.setDurationDaysField(number);
        event.setGroundConduсtingDropDown();
        event.addListActions(currentDate, currentDate);
        event.createMandatoryRequirements("1", "2", currentDate);//выбор первого или создание нового
        clickSaveButton();
        //подписать!
        gotoSearchEvents();
        //опубликовать эту кнм и найти ее
        searchRequest(numberKNM);
        checkObject(numberKNM);
    }
}
