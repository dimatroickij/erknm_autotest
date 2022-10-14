package testCases.pmi_4_1_13;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsPage;
import testPages.ListPlanPage;

import static com.codeborne.selenide.Selenide.switchTo;
import static java.lang.Thread.sleep;

/**
 * Проверка выполнения требований по добавлению в паспорт КНМ поля «Срок непосредственного взаимодействия (дней)»
 * и реализации ограничений на заполнение полей «Срок непосредственного взаимодействия (часов)» и «Срок
 * непосредственного взаимодействия (дней)» в зависимости от критериев проводимого КНМ.
 */

public class TestERKNM_4_1_13 extends ListEventsPage {
    public TestERKNM_4_1_13() throws Exception {
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
        addUnplannedKNM(nameKNOFNS, viewKNOFNS, controlPurchase, currentDate, null, interactionDays, null,
                prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Дата окончания КНМ"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField(nameInputStopKNMDate, errorStopKNMDate, textErrorNotNullInput);
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
    public void createEventWitchAutoCalculationDeadlineSameDatesTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(knoName, viewKNO, controlPurchase, currentDate, currentDate, null, interactionHours,
                prosecutorsOffice, viewEntity, INN, kingObject);
        checkValueOfField("Срок проведения дней", durationDaysField,"1");
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        clickButtonClearField(nameInputDurationDaysField, clearDurationDays);
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
            checkElementInvisible("Текст под полем Срок проведения дней", textUnderDurationDaysField);
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
    public void createEventWitchAutoCalculationDeadlineDifferentDatesTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNOFNS, viewKNOFNS, controlPurchase, "16.01.2023", "20.01.2023", null,
                interactionHours, prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        getNumberKNM();
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        checkValueOfField("Срок проведения дней", durationDaysField,"5");
        clickButtonClearField(nameInputDurationDaysField, clearDurationDays);
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
    public void createEventWitchAutoCalculationDeadlineWeekendDaysTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNOFNS, viewKNOFNS, controlPurchase, "21.01.2023", "22.01.2023", null,
                interactionHours, prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        getNumberKNM();
        checkTextErrorField(nameInputDurationDaysField, textUnderDurationDaysField,
                "При проведении КНМ в нерабочие дни поле подлежит изменению");
        checkValueOfField("Срок проведения дней", durationDaysField,"0");
        clickButtonClearField(nameInputDurationDaysField, clearDurationDays);
        checkElementAvailable(nameInputDurationDaysField, durationDaysField);
    }

    /**
     * Цель: Проверка наличия поля «Срок непосредственного взаимодействия (дней)», а также алгоритмов доступности для
     * ввода значений в поля «Срок непосредственного взаимодействия (дней)» и «Срок непосредственного взаимодействия (часов)».
     * A.1.1.3
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.3. Проверка наличия поля «Срок непосредственного взаимодействия (дней)», а также " +
            "алгоритмов доступности для ввода значений в поля «Срок непосредственного взаимодействия (дней)» и «Срок " +
            "непосредственного взаимодействия (часов)»")
    public void createEventWitchCheckFieldsInteractionTimeTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNOFNS, viewKNOFNS, controlPurchase, currentDate, currentDate, "", "",
                prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        String[] nameFields = {"Срок непосредственного взаимодействия (дней)",
                "Срок непосредственного взаимодействия (часов)"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Срок непосредственного взаимодействия (дней)", errorInteractionTimeDays,
                textErrorNotNullInput);
        checkTextErrorField("Срок непосредственного взаимодействия (часов)", errorInteractionTimeHours,
                textErrorNotNullInput);
        interactionTimeHours("256");
        checkElementNotAvailable("Срок непосредственного взаимодействия (дней)", interactionTimeDays);
        checkValueOfField("Срок непосредственного взаимодействия (дней)", interactionTimeDays,"");
        closeNotification();
        clickSaveButton();
        getNumberKNM();
        clearInput("Срок непосредственного взаимодействия (часов)", interactionTimeHours);
        interactionTimeDays("356");
        closeNotification();
        clickSaveButton();
        checkElementNotAvailable("Срок непосредственного взаимодействия (часов)", interactionTimeHours);
        checkValueOfField("Срок непосредственного взаимодействия (часов)", interactionTimeHours,"");
        checkValueOfField("Срок непосредственного взаимодействия (дней)", interactionTimeDays,"356");
        checkElementAvailable("Срок непосредственного взаимодействия (дней)", interactionTimeDays);
    }

    /**
     * Цель: Проверка обязательности заполнения одного из полей «Срок непосредственного взаимодействия (дней)» и «Срок
     * непосредственного взаимодействия (часов)» при сохранении КНМ.
     * A.1.1.4
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.4. Проверка обязательности заполнения одного из полей «Срок непосредственного " +
            "взаимодействия (дней)» и «Срок непосредственного взаимодействия (часов)» при сохранении КНМ.")
    public void mandatoryFieldsDirectInteractionTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNOFNS, viewKNOFNS, controlPurchase, currentDate, currentDate, null, null,
                prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        clickSaveButton();
        checkTextNotification("Проверка не сохранена. Требуется исправить ошибки.");
        String[] nameFields = {"Срок непосредственного взаимодействия (дней)",
                "Срок непосредственного взаимодействия (часов)"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Срок непосредственного взаимодействия дней", errorInteractionTimeDays,
                textErrorNotNullInput);
        checkTextErrorField("Срок непосредственного взаимодействия часов", errorInteractionTimeHours,
                textErrorNotNullInput);
    }

    /**
     * Цель: Проверка целевых условий доступности поля «Срок непосредственного взаимодействия (дней)» для заполнения в
     * КНМ в зависимости от его статуса и роли сотрудника.
     * A.1.1.5
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.5. Проверка целевых условий доступности поля «Срок непосредственного взаимодействия " +
            "(дней)» для заполнения в КНМ в зависимости от его статуса и роли сотрудника. ")
    public void availabilityFieldsDirectInteractionTest() throws Exception {
        String[] roles = new String[]{"supervisor", "prosecutor", "ombudsman"};
        String[] events = new String[]{"01220511000300047075",  // В процессе заполнения
                                        "77220370001100042327",  // Готова к согласованию
                                        "77220370001100042249",  // Есть замечания
                                        "77230660001100056204",  // «Ожидает проведения» (и план Рассмотрен) И Решение обжаловано = Да И Решение по заявлению
                                        "77220370001100042369"   // На согласовании
                                        };
        for (String role : roles) {
            for (String event : events) {
                System.out.println("Role: " + role + " КНМ " + event);
                authorization(role);
                sleep(4000);
                selectionERKNM();
                gotoListKNMPage();
                openCard(event);
                sleep(4000);
                if (event == "77220370001100042369") {
                    checkElementNotAvailable("Срок непосредственного взаимодействия (дней)", interactionTimeDays);
                } else {
                    if (role == "supervisor") {
                        checkElementAvailable("Срок непосредственного взаимодействия (дней)", interactionTimeDays);
                    } else {
                        checkElementNotAvailable("Срок непосредственного взаимодействия (дней)", interactionTimeDays);
                    }
                }
            }
        }
    }

    /**
     * Цель: Доработка отображения сведений в списке плановых КНМ.
     * A.1.1.6
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.6. Доработка отображения сведений в списке плановых КНМ.")
    public void displayingInformationInListOfPlannedTest() throws Exception {
        ListPlanPage planPage = new ListPlanPage();
        authorization("supervisor");
        selectionERKNM();
        gotoListPlansPage();
        openCardPlan("2023003594");
        planPage.clickAllEventsOpen();
        checkTextErrorField("Наименование колонки сроков непосредственного взаимодействия",
                planPage.durationsOfDaysColumnName, "Срок проведения (в днях) \\ Срок непосредственного взаимодействия");
        planPage.openEventFromListEventsTable();
        switchTo().window(1);
        String value = String.valueOf(1 + (int) ( Math.random() * 100 ));
        sleep(3000);
        editInteractionTime(value);
        sleep(3000);
        clickSaveButton();
        sleep(3000);
        gotoListPlansPage();
        sleep(3000);
        openCardPlan("2023003594");
        sleep(3000);
        planPage.clickAllEventsOpen();
        planPage.checkValueOfColumnDurationOfDays(value);
    }

    /**
     * Цель: Проверка применения валидации требования к КНМ, созданных в Системе после выхода требования в промышленный контур.
     * A.1.1.8
     *
     * @author Kirilenko P.A. 09.2022
     */
    @Epic("4.1.13")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.8. Проверка применения валидации требования к КНМ, созданных в Системе после выхода " +
            "требования в промышленный контур.")
    public void requirementsValidationKNMTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNOFNS, viewKNOFNS, controlPurchase, currentDate, null, null, null,
                prosecutorsOffice, viewEntity, INN, kingObjectForFNS);
        clickSaveButton();
        String[] nameFields = {"Дата окончания КНМ", "Срок непосредственного взаимодействия (дней)",
                "Срок непосредственного взаимодействия (часов)"};
        checkNamesEmptyFields(nameFields);
        checkTextErrorField("Дата окончания КНМ", errorStopKNMDate, textErrorNotNullInput);
        checkTextErrorField("Срок непосредственного взаимодействия (дней)", errorInteractionTimeDays,
                textErrorNotNullInput);
        checkTextErrorField("Срок непосредственного взаимодействия (часов)", errorInteractionTimeHours,
                textErrorNotNullInput);

        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        openCard("77220061000100056383");
        checkValueOfField("Дата окончания КНМ", stopKNMDate, "");
        checkValueOfField("Срок непосредственного взаимодействия (дней)", interactionTimeDays, "");
        checkValueOfField("Срок непосредственного взаимодействия (часов)", interactionTimeHours, "");
        clickSaveButton();
        checkTextNotification("КНМ успешно сохранено");
    }
}