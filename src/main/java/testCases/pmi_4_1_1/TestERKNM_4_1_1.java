package testCases.pmi_4_1_1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

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
     * A.1.1.1.1
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.1 Проверка поля «Реквизиты требования» в карточке КНМ в системе ЕРКНМ.")
    public void createEventCheckRequirementsDetailsTest() throws Exception {
        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(nameKNOFNS, viewKNOFNS, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
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
        checkElementInvisible("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка поля «Номер поручения» в карточке КНМ в системе ЕРКНМ.
     * A.1.1.1.2
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.2. Проверка поля «Номер поручения» в карточке КНМ в системе ЕРКНМ.")
    public void createEventCheckNumberOrderTest() throws Exception {
        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(nameKNOFNS, viewKNOFNS, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
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
        checkElementInvisible("Текст ошибки под полем Номер поручения", textUnderOrderNumberInput);
        closeNotification();
        clickSaveButton();
        checkTextNotification("КНМ успешно сохранено");
        checkValueOfField("Номер поручения", orderNumberInput, value);
        setGroundConductingDropDown("4.0.16");
        checkElementInvisible("Номер поручения", orderNumberInput);
    }

    /**
     * Цель: Проверка поля «Дата поручения» в карточке КНМ в системе ЕРКНМ.
     * A.1.1.1.3
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.3. Проверка поля «Дата поручения» в карточке КНМ в системе ЕРКНМ.")
    public void createEventCheckDateOrderTest() throws Exception {
        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        clickAddButton();
        setRequiredFieldsKNM(nameKNOFNS, viewKNOFNS, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
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
        checkElementInvisible("Дата поручения", orderDateInput);
    }

    /**
     * Цель: Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» для заполнения в ЕРКНМ.
     * A.1.1.1.4
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.4. Проверка доступности полей «Дата поручения», «Номер поручения» и «Реквизиты требования» " +
            "для заполнения в ЕРКНМ.")
    public void openEventsCheckAvailabilityFieldsTest() throws Exception {
        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        String[] parametersFiltration_1 = {"Статус КНМ", "Дата поручения правительства о проведении КНМ (интервал)"};
        filtrationEventsForParameters(null, null, parametersFiltration_1, futureDate, statusProcessFilling);
        openCard(getNumberRandomEvent());  // В процессе заполнения
        sleep(3000);
        checkElementAvailable("Дата поручения", orderDateInput);
        checkElementAvailable("Номер поручения", orderNumberInput);

        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        String[] parametersFiltration_2 = {"Статус КНМ", "Реквизиты требования"};
        filtrationEventsForParameters(null, null, parametersFiltration_2, futureDate, statusProcessFilling);
        openCard(getNumberRandomEvent()); // В процессе заполнения
        sleep(3000);
        checkElementAvailable("Реквизиты требования", detailsRequirementInput);

//        authorization("voskhod_qa");
//        selectionERKNM();
//        gotoListKNMPage();
//        String[] parametersFiltration_3 = {"Статус КНМ", "Дата поручения правительства о проведении КНМ (интервал)"};
//        filtrationEventsForParameters(null, null, parametersFiltration_3, futureDate, statusReadyApproval);
//        openCard(getNumberRandomEvent()); // Готова к согласованию
//        sleep(3000);
//        checkElementAvailable("Дата поручения", orderDateInput);
//        checkElementAvailable("Номер поручения", orderNumberInput);

//        authorization("voskhod_qa");
//        selectionERKNM();
//        gotoListKNMPage();
//        String[] parametersFiltration_4 = {"Статус КНМ", "Реквизиты требования"};
//        filtrationEventsForParameters(null, null, parametersFiltration_4, futureDate, statusReadyApproval);
//        openCard(getNumberRandomEvent()); // Готова к согласованию
//        sleep(3000);
//        checkElementAvailable("Реквизиты требования", detailsRequirementInput);
//
//        authorization("voskhod_qa");
//        selectionERKNM();
//        gotoListKNMPage();
//        String[] parametersFiltration_5 = {"Статус КНМ", "Реквизиты требования"};
//        filtrationEventsForParameters(null, null, parametersFiltration_5, futureDate, statusOnApproval);
//        openCard(getNumberRandomEvent()); // На согласовании
//        sleep(3000);
//        checkElementNotAvailable("Реквизиты требования", detailsRequirementInput);
//
//        authorization("voskhod_qa");
//        selectionERKNM();
//        gotoListKNMPage();
//        String[] parametersFiltration_6 = {"Статус КНМ", "Дата поручения правительства о проведении КНМ (интервал)"};
//        filtrationEventsForParameters(null, null, parametersFiltration_6, futureDate, statusProcessCompletion);
//        openCard(getNumberRandomEvent()); // Ожидает завершения
//        sleep(3000);
//        checkElementNotAvailable("Дата поручения", orderDateInput);
//        checkElementNotAvailable("Номер поручения", orderNumberInput);

        authorization("prosecutor");
        selectionERKNM();
        gotoListKNMPage();
        String[] parametersFiltration_7 = {"Статус КНМ", "Дата поручения правительства о проведении КНМ (интервал)"};
        filtrationEventsForParameters(null, null, parametersFiltration_7, futureDate, statusProcessFilling);
        openCard(getNumberRandomEvent()); // В процессе заполнения
        sleep(3000);
        checkElementNotAvailable("Дата поручения", orderDateInput);
        checkElementNotAvailable("Номер поручения", orderNumberInput);

//        authorization("prosecutor");
//        selectionERKNM();
//        gotoListKNMPage();
//        String[] parametersFiltration_8 = {"Статус КНМ", "Реквизиты требования"};
//        filtrationEventsForParameters(null, null, parametersFiltration_8, futureDate, statusReadyApproval);
//        openCard(getNumberRandomEvent()); // Готова к согласованию
//        sleep(3000);
//        checkElementNotAvailable("Реквизиты требования", detailsRequirementInput);
    }

    /**
     * Цель: Проверка фильтрации данных в ЗЧ ЕРКНМ.
     * A.1.1.1.10
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.10. Проверка фильтрации данных в ЗЧ ЕРКНМ.")
    public void checkFiltrationDataTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        openFiltrationForm();
        setBasicFilterParameters(knoName, null);
        addAdditionalFilter("Реквизиты требования");
        setAdditionalFilterInput(requirementDetailsFilterInput, "автотест");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("77220661000000065712");

        openFiltrationForm();
        deleteAdditionalFilterInput();
        addAdditionalFilter("Номер поручения");
        setAdditionalFilterInput(orderNumberFilterInput, "54321");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("77220661000000065690");

        openFiltrationForm();
        deleteAdditionalFilterInput();
        addAdditionalFilter("Дата поручения");
        setAdditionalFilterInput(orderDateFilterInput, "01.01.2021");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("77220661000000065791");

        authorization("prosecutor");
        selectionERKNM();
        gotoListKNMPage();
        openFiltrationForm();
        setBasicFilterParameters(knoName, null);
        addAdditionalFilter("Дата поручения правительства о проведении КНМ (интервал)");
        setAdditionalFilterIntervalInput(orderDateStartIntervalInput, orderDateStopIntervalInput,
                "01.01.2021", "02.01.2021");
        clickButtonUpdateForFilterBlock();
        checkNumberKNMFromTable("77220661000000065791");
    }

    /**
     * Цель: Проверка валидации поля "Реквизиты требования" в ранее созданных КНМ.
     * A.1.1.1.11
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.1")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.11 Проверка валидации полей Реквизиты требования в ранее созданных КНМ.")
    public void fieldValidationDetailsOfRequirementInCreatedEventsTest() throws Exception {
        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        String[] parametersFiltration = {"Статус КНМ", "Дата начала проведения КНМ (интервал)"};
        filtrationEventsForParameters(nameKNO, unplannedCheck, parametersFiltration, dateOfOneStage, statusProcessFilling);
        openCard(getNumberRandomEvent());
        try{
            deleteGroundsConductingKNM();
        } catch (Exception e) {}
        finally {
            addGroundsConductingUnscheduled("4.0.21", null, null, null,
                    "Не требует согласования");
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
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.1.12 Проверка валидации полей Дата поручения и Номер поручения в ранее созданных КНМ.")
    public void fieldValidationDateAndNumberAssignmentInCreatedEventsTest() throws Exception {
        authorization("voskhod_qa");
        selectionERKNM();
        gotoListKNMPage();
        String[] parametersFiltration = {"Статус КНМ", "Дата начала проведения КНМ (интервал)"};
        filtrationEventsForParameters(null, unplannedCheck, parametersFiltration, dateOfOneStage, statusProcessFilling);
        openCard(getNumberRandomEvent());
        try{
            deleteGroundsConductingKNM();
        } catch (Exception e) {}
        finally {
            addGroundsConductingUnscheduled("4.0.19", null, null, null,
                    "Не требует согласования");
            clickSaveButton();
            checkTextNotification("КНМ успешно сохранено");
        }
    }


}
