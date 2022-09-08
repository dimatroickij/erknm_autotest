package testCases.pmiERKNM1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

import static java.lang.Thread.sleep;

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
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1. Сохранение внеплановой КНМ  с незаполненным полем «Дата окончания КНМ»")
    public void createEventOutStopDateTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, currentDate, null, interactionDays, null,
                prosecutorsOffice, INN);
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Дата окончания КНМ"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField(nameInputStopKNMDate, errorStopKNMDate, textErrorInput);
        setStopKNMDate(currentDate);
        closeNotification();
        clickSaveButton();
        getNumberKNM();
    }

    /**
     * Цель: Проверка автоматического расчета значения в поле «Срок проведения (дней)» с одинаковыми датами начала и
     * окончания КНМ при первом сохранении записи КНМ.
     * A.1.1.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2. Проверка автоматического расчета значения в поле «Срок проведения (дней)» с " +
            "одинаковыми датами начала и окончания КНМ при первом сохранении записи КНМ")
    public void createEventWitchAutoCalculationDeadlineSameDates() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, currentDate, currentDate, null, interactionHours,
                prosecutorsOffice, INN);
        checkDurationOfDays("1");
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        clearField(nameInputDurationDaysField, clearDurationDays);
        setDurationDaysField("365");
        closeNotification();
        clickSaveButton();
        numberKNM = getNumberKNM();
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        String[] roles = {"prosecutor", "ombudsman"};
        for (String role : roles) {
            authorization(role);
            System.out.println(role);
            selectionERKNM();
            gotoListKNMPage();
            openCard(numberKNM);
            checkElementVisible("Текст под полем Срок проведения дней", textUnderDurationDaysField);
            checkElementNotAvailable(nameInputDurationDaysField, durationDaysField);
        }
    }

    /**
     * Цель: Проверка автоматического расчета значения в поле «Срок проведения (дней)» с разными датами начала и
     * окончания КНМ при первом сохранении записи КНМ.
     * A.1.1.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2. Проверка автоматического расчета значения в поле «Срок проведения (дней)» с " +
            "разными датами начала и окончания КНМ при первом сохранении записи КНМ")
    public void createEventWitchAutoCalculationDeadlineDifferentDates() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, "16.01.2023", "20.01.2023", null,
                interactionHours, prosecutorsOffice, INN);
        getNumberKNM();
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        checkDurationOfDays("5");
        clearField(nameInputDurationDaysField, clearDurationDays);
        checkElementAvailable(nameInputDurationDaysField, durationDaysField);
    }

    /**
     * Цель: Проверка автоматического расчета значения в поле «Срок проведения (дней)» с датами выходного дня при
     * первом сохранении записи КНМ.
     * A.1.1.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2. Проверка автоматического расчета значения в поле «Срок проведения (дней)» с " +
            "датами выходного дня при первом сохранении записи КНМ")
    public void createEventWitchAutoCalculationDeadlineWeekendDays() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, "21.01.2023", "22.01.2023", null,
                interactionHours, prosecutorsOffice, INN);
        getNumberKNM();
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        checkDurationOfDays("0");
        clearField(nameInputDurationDaysField, clearDurationDays);
        checkElementAvailable(nameInputDurationDaysField, durationDaysField);
    }

}