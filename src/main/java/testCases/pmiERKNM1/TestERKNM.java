package testCases.pmiERKNM1;

import org.testng.annotations.Test;
import testPages.ListEventsPage;

/**
 * Проверка выполнения требований по добавлению в паспорт КНМ поля «Срок непосредственного взаимодействия (дней)»
 * и реализации ограничений на заполнение полей «Срок непосредственного взаимодействия (часов)» и «Срок
 * непосредственного взаимодействия (дней)» в зависимости от критериев проводимого КНМ.
 */

public class TestERKNM extends ListEventsPage {
    public TestERKNM() throws Exception {
    }

    public String numberKNM;

    /**
     * Цель: Проверка обязательности заполнения поля «Дата окончания КНМ».
     * A.1.1.1
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Test(description = "Добавление внеплановой КНМ и сохранение с незаполненным полем «Дата окончания КНМ»")
    public void createEventOutStopDateTest() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, currentDate, null, interactionDays, null, prosecutorsOffice, INN);
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Дата окончания КНМ"};
        checkNamesEmptyFields(nameFields);

    }
}
