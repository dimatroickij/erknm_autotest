package testCases.pmi_4_1_21;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import static com.codeborne.selenide.Selenide.sleep;

/**
 * Проверка выполнения требований по реализации совместимости ФГИС ЕРКНМ со статусной моделью ЕРВК в части планового контроля.
 * A.1.1.3
 */

public class TestERKNM_4_1_21 extends ListEventsPage {

    public TestERKNM_4_1_21() throws Exception {
    }

    ListPlanPage plan = new ListPlanPage();

    /**
     * Цель: Проверка отображения значений в поле «Характер КНМ» при создании КНМ через вкладку «Список КНМ».
     * A.1.1.3.1
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.21")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.3.1 Проверка отображения значений в поле «Характер КНМ» при создании КНМ через вкладку " +
            "«Список КНМ».")
    public void characterKNMValuesDisplayTest() throws Exception {
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setNameKNODropDown(nameKNOFNS);
        setCharacterKNMDropDown(null);
        String[] nameFields = {"Необходимо заполнить поле \"Вид контроля (надзора) и его номер\""};
        checkNamesEmptyFields(nameFields);
        String[] typesCharactersKNO = {plannedCheckFZ, unplannedCheck, plannedCheck};
        checkInVisibleListCharacterKNMDropDown(typesCharactersKNO);
        setKindControlAndNumberDropDown(viewKNOFNS);
        String[] typeCharacterKNO = {plannedCheck};
        checkInVisibleListCharacterKNMDropDown(typeCharacterKNO);
        setRequiredFieldsKNM(null, viewKNOFNSForPlan, documentaryVerification, plannedCheck, "01.02.2024",
                "01.02.2024", interactionDays, null, viewEntity);
        clickSaveButton();
        getNumberKNM();
        checkElementAvailable("Характер КНМ", characterKNMDropDown);
        setFieldsNecessaryForHarmonization("4.0.11", typeActionsRetrievalDocuments,"01.02.2024");
        closeNotification();
        clickSaveButton();
        checkStatusKNM(statusReadyApproval);
        checkElementNotAvailable("Характер КНМ", characterKNMDropDown);
    }

    /**
     * Цель: Проверка отображения значений в поле «Вид контроля (надзора) и его номер» при создании КНМ через план КНМ.
     * A.1.1.3.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.21")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.3.2 Проверка отображения значений в поле «Вид контроля (надзора) и его номер» при создании" +
            " КНМ через план КНМ.")
    public void characterKNMCreateInPlanValuesDisplayTest() throws Exception {
        authorization(employee);
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan("2024063491");
        plan.clickAddKNMButton();
        checkValueForDropDownOfField("Наименование органа контроля", nameKNOFiledText, knoNameTransport);
        checkValueForDropDownOfField("Характер КНМ", characterKNMFieldText, plannedCheck);
        checkValueForDropDownOfField("Наименование прокуратуры", nameProsecutorFieldText, prosecutorsOffice);
        checkInVisibleValueOfDropDown("Вид контроля (надзора) и его номер", kindControlAndNumberDropDown);

        gotoListPlansPage();
        openCardPlan(numberPlan);
        plan.clickAddKNMButton();
        checkValueForDropDownOfField("Наименование органа контроля", nameKNOFiledText, nameKNOFNS);
        checkValueForDropDownOfField("Характер КНМ", characterKNMFieldText, plannedCheck);
        checkValueForDropDownOfField("Наименование прокуратуры", nameProsecutorFieldText, prosecutorsOffice);
        String[] kindsOfControls = {"066", "052", "037"};
        checkInVisibleListKindOfControlDropDown(kindsOfControls);
        setRequiredFieldsKNM(null, viewKNOFNSForPlan, documentaryVerification, null, "01.02.2024",
                "01.02.2024", interactionDays, null, viewEntity);
        clickSaveButton();
        sleep(3000);
        checkStatusKNM(statusProcessFilling);
        getNumberKNM();
        checkElementAvailable("Характер КНМ", characterKNMDropDown);
    }

    /**
     * Цель: Проверка применения валидации требования к КНМ, созданным в системе после выхода требования в промышленный контур.
     * A.1.1.3.3
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.21")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.3.3 Проверка применения валидации требования к КНМ, созданным в системе после выхода " +
            "требования в промышленный контур.")
    public void validationOfRequirementsForPreviouslyCreatedKNMTest() throws Exception {
        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(nameKNOFNS, null, null, null, currentDate, currentDate, interactionDays,
                null, viewEntity);
        clickSaveButton();
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Необходимо заполнить поле \"Вид контроля (надзора) и его номер\"",
                "Вид контроля (надзора) и его номер", "Вид КНМ"};
        checkNamesEmptyFields(nameFields);

        authorization(employee);
        selectionERKNM();
        gotoListKNMPage();
        openCard("7722231000000027972");  // 77220660001100046634
        clickSaveButton();
        checkTextNotification("КНМ успешно сохранено");
    }
}
