package testCases.pmi_4_1_43;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

/**
 * 1.1.9 Проверка выполнения требований по реализации внутреннего справочника «Обязательные требования» в ФГИС ЕРКНМ
 */

public class TestERKNM_4_1_43 extends ListEventsPage {

    public TestERKNM_4_1_43() throws Exception {
    }

    /**
     * Цель: Проверка требований к подразделу «Обязательные требования, подлежащие проверке»
     * A.1.1.9.1
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.1 Проверка требований к подразделу «Обязательные требования, подлежащие проверке»")
    public void requirementsSectionMandatoryRequirementsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(nameKNOFNS, viewKNOFNS, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        clickedOnNavigationMenuItem(buttonSubjectOfVerification);  // предмет КНМ
        setBlockOfRequirements("правительство");
        clickSaveButton();
        clickedOnNavigationMenuItem(linkInfoHistoryOfChanges);
        openHistoryOfChanges();
        checkLogInHistory("Значение поля \"НПА, содержащий обязательное требование\" добавлено \"Правительство Российской" +
                " Федерации: Постановление Правительства РФ от 2020-11-04 № 1788 «О лицензировании деятельности по производству" +
                " и реализации защищенной от подделок полиграфической продукции»\"");

    }

}
