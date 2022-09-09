package testCases.pmiERKNM1;

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
        checkTextErrorField("Реквизиты требования", textUnderDetailsRequirement, textErrorInput);
        String value = prefix;
        setDetailsRequirement(value);
        closeNotification();
        clickSaveButton();
        getNumberKNM();
        checkValueOfField("Реквизиты требования", detailsRequirementInput, value);
        setGroundConductingDropDown("4.0.15");
        checkElementVisible("Реквизиты требования", detailsRequirementInput);
    }
}
