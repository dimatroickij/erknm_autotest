package testCases.searchEvents;

import org.testng.annotations.Test;
import testPages.SearchERPPage;

public class SearchEventsERPTest extends SearchERPPage {
    public SearchEventsERPTest() throws Exception {
    }
    //раздел Поиск мероприятий для ЕРП

    /**
     * Цель: Проверка работоспособности поиска КНМ для ЕРП
     * HP ALM
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Проверка работоспособности поиска КНМ для ЕРП")
    //TODO Нужно как-то переделать на поиск определенных проверок
    public void checkFunctionalitySearchKNMERPTest() throws Exception {
        authorization("supervisor");
        choiceMode(false);
        gotoERPListKNMPage();
        String conductingKNM = searchKNM(statusProcessConducting); // Поиск проверки в статусе В процессе проведения
        System.out.println("Проверка в статусе В процессе проведения " + conductingKNM);
        //String formationKNM = searchKNM(statusProcessFormation); // Поиск проверки в статусе В процессе формирования
        String completedKNM = searchKNM(statusCompleted); // Поиск проверки в статусе Завершено
        System.out.println("Проверка в статусе В процессе формирования " + completedKNM);
        //String deletedKNM = searchKNM(statusDeleted); // Поиск проверки в статусе Удалено
        gotoSearchEvents();
        checkKNMOrPMSearch(conductingKNM, true); // Проверка нашлась
        //checkKNM(formationKNM, false); // Проверка не нашлась
        checkKNMOrPMSearch(completedKNM, true); // Проверка не нашлась
        //checkKNM(deletedKNM, false); // Проверка нашлась
        logout();
    }
}
