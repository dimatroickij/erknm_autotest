package testCases.pmi_4_1_1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

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
     * A.1.1.6
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.6. Проверка поля «Реквизиты требования» в карточке КНМ в системе ЕРП.")
    public void createEventsCheckEditGroundsForRegistration() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNMForERP(unscheduledCheck, exitAndDocumentaryForm, legalEntity, numberOrders, currentDate,
                currentDate, currentDate, "1", null,  prosecutorsOffice, nameKNO, viewKNOERP, INN);
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
        getNumberKNM();
        checkValueOfField("Реквизиты требования", detailsRequirementInput, value);
        setGroundRegistrationDropDown("1.2.10");
        checkElementInvisible("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка поля «Номер поручения» в карточке КНМ в системе ЕРП.
     * A.1.1.7
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.7. Проверка поля «Номер поручения» в карточке КНМ в системе ЕРП.")
    public void createEventCheckNumberOrder() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNMForERP(unscheduledCheck, exitAndDocumentaryForm, legalEntity, numberOrders, currentDate,
                currentDate, currentDate, "1", null,  prosecutorsOffice, nameKNO, viewKNOERP, INN);
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
     * A.1.1.8
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.8. Проверка поля «Дата поручения» в карточке КНМ в системе ЕРП.")
    public void createEventCheckDateOrder() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNMForERP(unscheduledCheck, exitAndDocumentaryForm, legalEntity, numberOrders, currentDate,
                currentDate, currentDate, "1", null,  prosecutorsOffice, nameKNO, viewKNOERP, INN);
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
        getNumberKNM();
        checkValueOfField("Дата поручения", orderDateInput, value);
        setGroundRegistrationDropDown("1.2.16");
        checkElementInvisible("Дата поручения", orderDateInput);
    }

    /**
     * Цель: Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» для заполнения в ЕРП.
     * A.1.1.9
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.9. Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» " +
            "для заполнения в ЕРП.")
    public void openEventsCheckAvailabilityFields() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200065697"); // В процессе заполнения
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        gotoListKNMPage();
        openCard("772200065688"); // В процессе проведения
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

        gotoListKNMPage();
        openCard(""); // Завершено
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        gotoListKNMPage();
        openCard(""); // Отклонено
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

        gotoListKNMPage();
        openCard(""); // На согласовании
        checkElementNotAvailable("Реквизиты требования", detailsRequirementInput);

        gotoListKNMPage();
        openCard(""); // Ожидает завершения
        checkElementNotAvailable("Дата поручения", orderDateInput);
        checkElementNotAvailable("Номер поручения", orderNumberInput);

        authorization("prosecutor");
        selectionERP();
        gotoListKNMPage();
        openCard("772200065697"); // В процессе заполнения
        checkElementNotAvailable("Дата поручения", orderDateInput);
        checkElementNotAvailable("Номер поручения", orderNumberInput);

        gotoListKNMPage();
        openCard(""); // Завершено
        checkElementNotAvailable("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка фильтрации данных в ЗЧ ЕРП.
     * A.1.1.10
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.10. Проверка фильтрации данных в ЗЧ ЕРП.")
    public void checkFiltrationData() throws Exception {
        authorization("supervisor");
        selectionERP();
        gotoListKNMPage();
        openFiltrationForm();
        setBasicFilterParameters(nameKNO);
        addAdditionalFilter("Реквизиты требования");
        setAdditionalFilterInput(requirementDetailsFilterInput, "12345");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("772200065688");

        openFiltrationForm();
        deleteAdditionalFilterInput();
        addAdditionalFilter("Номер поручения");
        setAdditionalFilterInput(orderNumberFilterInput, "54321");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("772200065687");

        openFiltrationForm();
        deleteAdditionalFilterInput();
        addAdditionalFilter("Дата поручения");
        setAdditionalFilterInput(orderDateFilterInput, "15.09.2022");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("772200065687");
    }

}
