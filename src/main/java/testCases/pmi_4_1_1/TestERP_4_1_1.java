package testCases.pmi_4_1_1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

import static com.codeborne.selenide.Selenide.sleep;

/**
 * Проверка выполнения требований по добавлению возможности выбора КНО из данных ЕРВК и вывод данных в поле
 * «Наименование органа контроля, с которым КНМ проводится совместно» в паспорте КНМ.
 */

public class TestERP_4_1_1 extends ListEventsERPPage {

    public TestERP_4_1_1() throws Exception {
    }

    public String numberKNM;

    /**
     * Цель: Проверка поля «Реквизиты требования» в карточке КНМ в системе ЕРП.
     * A.1.1.1.6
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.6. Проверка поля «Реквизиты требования» в карточке КНМ в системе ЕРП.")
    public void createEventsCheckEditGroundsForRegistrationTest() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNMForERP(unscheduledCheck, exitAndDocumentaryForm, legalEntity, numberOrders, currentDate,
                currentDate, currentDate, "1", null,  prosecutorsOffice, nameKNOFNS, viewKNOERP, INN);
        addGroundsConductingKNM("3.2.9", null, null, null);
        clickSaveButton();
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Реквизиты требования"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Реквизиты требования", textUnderDetailsRequirementInput, textErrorNotNullInput);
        String value = prefix;
        setDetailsRequirement(value);
        closeNotification();
        clickSaveButton();
        sleep(3000);
        getNumberKNM();
        checkValueOfField("Реквизиты требования", detailsRequirementInput, value);
        setGroundRegistrationDropDown("1.2.10");
        checkElementInvisible("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка поля «Номер поручения» в карточке КНМ в системе ЕРП.
     * A.1.1.1.7
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.7. Проверка поля «Номер поручения» в карточке КНМ в системе ЕРП.")
    public void createEventCheckNumberOrderTest() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNMForERP(unscheduledCheck, exitAndDocumentaryForm, legalEntity, numberOrders, currentDate,
                currentDate, currentDate, "1", null,  prosecutorsOffice, nameKNOFNS, viewKNOERP, INN);
        addGroundsConductingKNM("3.2.6", null, currentDate, null);
        clickSaveButton();
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Номер поручения"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Номер поручения", textUnderOrderNumberInput, textErrorNotNullInput);
        String value = prefix;
        setOrderNumber(value);
        closeNotification();
        clickSaveButton();
        sleep(3000);
        getNumberKNM();
        checkValueOfField("Номер поручения", orderNumberInput, value);
        setGroundRegistrationDropDown("3.2.7");
        setOrderNumber(value);
        setOrderDate(currentDate);
        checkTextErrorField("Номер поручения", textUnderOrderNumberInput, textErrorIncorrectlyInput);
        value = "РР-А52-12345";
        clearInput("Номер поручения", orderNumberInput);
        setOrderNumber(value);
        checkElementInvisible("Текст ошибки под полем Номер поручения", textUnderOrderNumberInput);
        closeNotification();
        clickSaveButton();
        checkTextNotification("КНМ успешно сохранено");
        checkValueOfField("Номер поручения", orderNumberInput, value);
        setGroundRegistrationDropDown("3.2.9");
        checkElementInvisible("Номер поручения", orderNumberInput);
    }

    /**
     * Цель: Проверка поля «Дата поручения» в карточке КНМ в системе ЕРП.
     * A.1.1.1.8
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.8. Проверка поля «Дата поручения» в карточке КНМ в системе ЕРП.")
    public void createEventCheckDateOrderTest() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNMForERP(unscheduledCheck, exitAndDocumentaryForm, legalEntity, numberOrders, currentDate,
                currentDate, currentDate, "1", null,  prosecutorsOffice, nameKNOFNS, viewKNOERP, INN);
        addGroundsConductingKNM("3.2.15", "ПТ-Ю1-2кв", null, null);
        clickSaveButton();
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Дата поручения"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Дата поручения", textUnderOrderDateInput, textErrorNotNullInput);
        String value = currentDate;
        setOrderDate(value);
        closeNotification();
        clickSaveButton();
        sleep(3000);
        getNumberKNM();
        checkValueOfField("Дата поручения", orderDateInput, value);
        setGroundRegistrationDropDown("1.2.16");
        sleep(3000);
        checkElementInvisible("Дата поручения", orderDateInput);
    }

    /**
     * Цель: Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» для заполнения в ЕРП.
     * A.1.1.1.9
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.9 Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» " +
            "для заполнения в ЕРП.")
    public void openEventsCheckAvailabilityFieldsTest() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200054237"); // В процессе формирования
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200054125"); // В процессе проведения
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200065883"); // Завершено
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200054995"); // Отклонено
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

        authorization("prosecutor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200054237"); // В процессе формирования
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        authorization("prosecutor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200054219"); // Завершено
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка фильтрации данных в ЗЧ ЕРП.
     * A.1.1.1.10
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.10. Проверка фильтрации данных в ЗЧ ЕРП.")
    public void checkFiltrationDataTest() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openFiltrationForm();
        setBasicFilterParameters(nameKNO);
        addAdditionalFilter("Реквизиты требования");
        setAdditionalFilterInput(requirementDetailsFilterInput, "12345");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("772200065811");

        openFiltrationForm();
        deleteAdditionalFilterInput();
        addAdditionalFilter("Номер поручения");
        setAdditionalFilterInput(orderNumberFilterInput, "54321");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("772200065889");

        openFiltrationForm();
        deleteAdditionalFilterInput();
        addAdditionalFilter("Дата поручения");
        setAdditionalFilterInput(orderDateFilterInput, "01.01.2022");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("772200065889");
    }

    /**
     * Цель: Проверка валидации поля "Реквизиты требования" в ранее созданных КНМ.
     * A.1.1.1.11
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.11. Проверка валидации полей Реквизиты требования в ранее созданных КНМ.")
    public void fieldValidationDetailsOfRequirementInCreatedEventsTest() throws Exception {
        String[] events = new String[] {"772200054879",  // в процессе формирования
        "772200054995",  // отклонено
        "772200054230",  // в процессе проведения
        "772200054345"}; // завершено

        authorization("supervisor");
        selectionERP();
        for(String event : events){
            System.out.println(event);
            gotoListKNMPage();
            openCard(event);
            deleteGroundsConductingKNM();
            addGroundsConductingKNM("3.2.9", null, null, null);
            clickSaveButton();
            checkTextNotification("КНМ успешно сохранено");
        }
    }

    /**
     * Цель: Проверка валидации полей "Дата поручения" и "Номер поручения" в ранее созданных КНМ.
     * A.1.1.1.12
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.1.12. Проверка валидации полей полей Дата поручения и Номер поручения в ранее созданных КНМ.")
    public void fieldValidationDateAndNumberAssignmentInCreatedEventsTest() throws Exception {
        String[] events = new String[] {"772200054237",  // в процессе формирования
                "772200054998",  // отклонено
                "772200054125",  // в процессе проведения
                "772200054220"}; // завершено

        authorization("supervisor");
        selectionERP();
        for(String event : events){
            System.out.println(event);
            gotoListKNMPage();
            openCard(event);
            deleteGroundsConductingKNM();
            addGroundsConductingKNM("3.2.6", null, null, null);
            clickSaveButton();
            checkTextNotification("КНМ успешно сохранено");
        }
    }

}
