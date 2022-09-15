package testCases.pmi1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

/**
 * Проверка выполнения требований по добавлению возможности выбора КНО из данных ЕРВК и вывод данных в поле
 * «Наименование органа контроля, с которым КНМ проводится совместно» в паспорте КНМ.
 */

public class TestERKNM_4_1_1 extends ListEventsPage {

    public TestERKNM_4_1_1() throws Exception {
    }

    public String numberKNM;

    /**
     * Цель: Проверка поля «Реквизиты требования» в карточке КНМ в системе ЕРКНМ.
     * A.1.1.1
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1. Проверка поля «Реквизиты требования» в карточке КНМ в системе ЕРКНМ.")
    public void createEventCheckRequirementsDetails() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(knoName, viewKNO, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, prosecutorsOffice, INN);
        addGroundsConductingUnscheduled("4.0.21", null, null, null,
                "Не требует согласования");
        clickSaveButton();
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Реквизиты требования"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Реквизиты требования", textUnderDetailsRequirement, textErrorNotNullInput);
        String value = prefix;
        setDetailsRequirement(value);
        closeNotification();
        clickSaveButton();
        getNumberKNM();
        checkValueOfField("Реквизиты требования", detailsRequirementInput, value);
        setGroundConductingDropDown("4.0.15");
        checkElementVisible("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка поля «Номер поручения» в карточке КНМ в системе ЕРКНМ.
     * A.1.1.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.2. Проверка поля «Номер поручения» в карточке КНМ в системе ЕРКНМ.")
    public void createEventCheckNumberOrder() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(knoName, viewKNO, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, prosecutorsOffice, INN);
        addGroundsConductingUnscheduled("4.0.18", null, currentDate, null,
                "Не требует согласования");
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
        setGroundConductingDropDown("4.0.19");
        setOrderNumber(value);
        setOrderDate(currentDate);
        checkTextErrorField("Номер поручения", textUnderOrderNumberInput, textErrorIncorrectlyInput);
        value = "ДГ-П36-23пр";
        clearInput("Номер поручения", orderNumberInput);
        setOrderNumber(value);
        checkElementVisible("Текст ошибки под полем Номер поручения", textUnderOrderNumberInput);
        closeNotification();
        clickSaveButton();
        checkTextNotification("КНМ успешно сохранено");
        checkValueOfField("Номер поручения", orderNumberInput, value);
        setGroundConductingDropDown("4.0.16");
        checkElementVisible("Номер поручения", orderNumberInput);
    }

    /**
     * Цель: Проверка поля «Дата поручения» в карточке КНМ в системе ЕРКНМ.
     * A.1.1.3
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.3. Проверка поля «Дата поручения» в карточке КНМ в системе ЕРКНМ.")
    public void createEventCheckDateOrder() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(knoName, viewKNO, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, prosecutorsOffice, INN);
        addGroundsConductingUnscheduled("4.0.19", "АА-Б1-2", null, null,
                "Не требует согласования");
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
        setGroundConductingDropDown("4.0.17");
        checkElementVisible("Дата поручения", orderDateInput);
    }

    /**
     * Цель: Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» для заполнения в ЕРКНМ.
     * A.1.1.4
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.4. Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» " +
            "для заполнения в ЕРКНМ.")
    public void openEventsCheckAvailabilityFields() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        openCard("01220441000300056542"); // В процессе заполнения
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        gotoListKNMPage();
        openCard(""); // В процессе заполнения
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

        gotoListKNMPage();
        openCard(""); // Готова к согласованию
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        gotoListKNMPage();
        openCard(""); // Готова к согласованию
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

        gotoListKNMPage();
        openCard(""); // На согласовании
        checkElementNotAvailable("Реквизиты требования", detailsRequirementInput);

        gotoListKNMPage();
        openCard(""); // Ожидает завершения
        checkElementNotAvailable("Дата поручения", orderDateInput);
        checkElementNotAvailable("Номер поручения", orderNumberInput);

        authorization("prosecutor");
        selectionERKNM();
        gotoListKNMPage();
        openCard("01220441000300056542"); // В процессе заполнения
        checkElementNotAvailable("Дата поручения", orderDateInput);
        checkElementNotAvailable("Номер поручения", orderNumberInput);

        gotoListKNMPage();
        openCard(""); // Готова к согласованию
        checkElementNotAvailable("Реквизиты требования", detailsRequirementInput);
    }



}
