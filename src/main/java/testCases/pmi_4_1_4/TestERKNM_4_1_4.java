package testCases.pmi_4_1_4;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;

/**
 * 1.1.8 Проверка выполнения требований по доработкам паспорта профилактического мероприятия.
 */

public class TestERKNM_4_1_4 extends ListPreventionEventsPage {

    public TestERKNM_4_1_4() throws Exception {
    }

    /**
     * Цель: Проверка требований к разделу «Сведения о предмете профилактического мероприятия» в ПМ
     * A.1.1.8.1
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.1 Проверка требований к разделу «Сведения о предмете профилактического мероприятия» в ПМ")
    public void informationSubjectOfPreventiveEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        clickedOnNavigationMenuItem(linkInfoSubjectOfPreventionEvent);
        clickButtonAddForRequirements();

        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        openCard("77220521000000065882");
        clickConfirmButton();
        clickedOnNavigationMenuItem(linkInfoSubjectOfPreventionEvent);
        checkElementVisible("Кнопка Добавить в «Обязательные требования, подлежащие проверке»",
                buttonAddForRequirements);
        clickOnRequirements();
        checkValueOfFieldRequirement();
    }

    /**
     * Цель: Проверка требований к подразделу «Обязательные требования, подлежащие проверке»
     * A.1.1.8.2
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.2 Проверка требований к подразделу «Обязательные требования, подлежащие проверке»")
    public void mandatoryRequirementsVerifiedEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        setFieldsForSavePMStatusWarningDeclared(currentDate);
        checkElementAvailable("Кнопка Добавить в «Обязательные требования, подлежащие проверке»",
                buttonAddForRequirements);
        clickSaveButton();
        clickConfirmButton();
        checkStatusPM("В процессе заполнения");
        String numberPM = getNumberPM();

        gotoListPreventionEventsPage();

        openCard(numberPM);
        clickConfirmButton();
        setBlockOfRequirements("правительство");



    }

}
