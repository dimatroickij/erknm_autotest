package testCases.pmi_4_1_21;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

/**
 * Проверка выполнения требований по реализации совместимости ФГИС ЕРКНМ со статусной моделью ЕРВК в части планового контроля.
 * A.1.5
 */

public class TestERKNM_4_1_21 extends ListEventsPage {

    public TestERKNM_4_1_21() throws Exception {
    }

    /**
     * Цель: Проверка отображения значений в поле «Характер КНМ» при создании КНМ через вкладку «Список КНМ».
     * A.1.5.1
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.21")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.5.1. Проверка отображения значений в поле «Характер КНМ» при создании КНМ через вкладку " +
            "«Список КНМ».")
    public void characterKNMValuesDisplayTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setNameKNODropDown(knoName);
        setCharacterKNMDropDown(null);
        String[] nameFields = {"Необходимо заполнить поле \"Вид контроля (надзора) и его номер\""};
        checkNamesEmptyFields(nameFields);
        String[] typesCharactersKNO = {plannedCheckFZ, unplannedCheck, plannedCheck};
        checkInVisibleListCharacterKNMDropDown(typesCharactersKNO);
        setKindControlAndNumberDropDown(viewKNO);
        String[] typeCharacterKNO = {plannedCheck};
        checkInVisibleListCharacterKNMDropDown(typeCharacterKNO);
        setRequiredFieldsKNM(null, viewKNOForPlan, documentaryVerification, plannedCheck, futureDate, futureDate, interactionDays,
                null, prosecutorsOffice, INN, kingObjectOne);
        clickSaveButton();
        getNumberKNM();
        checkElementAvailable("Характер КНМ", characterKNMDropDown);
        setFieldsNecessaryForHarmonization("4.0.11", futureDate, plannedCheck);
        closeNotification();
        clickSaveButton();
        checkStatusKNM(statusReadyApproval);
        checkElementAvailable("Характер КНМ", characterKNMDropDown);
    }

    /**
     * Цель: Проверка отображения значений в поле «Вид контроля (надзора) и его номер» при создании КНМ через план КНМ.
     * A.1.5.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.21")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.5.2. Проверка отображения значений в поле «Вид контроля (надзора) и его номер» при создании" +
            " КНМ через план КНМ.")
    public void characterKNMCreateInPlanValuesDisplayTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();

    }


}
