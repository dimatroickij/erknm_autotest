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
                null, viewEntity);
        clickedOnNavigationMenuItem(buttonSubjectOfVerification);  // предмет КНМ
        setBlockOfRequirements(true,"правительство");
        clickSaveButton();
        clickedOnNavigationMenuItem(linkInfoHistoryOfChanges);
        openHistoryOfChanges();
        checkLogInHistory("Значение поля \"НПА, содержащий обязательное требование\" добавлено \"Правительство Российской" +
                " Федерации: Постановление Правительства РФ от 2020-11-04 № 1788 «О лицензировании деятельности по производству" +
                " и реализации защищенной от подделок полиграфической продукции»\"");
    }

    /**
     * Цель: Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке» для внеплановой КНМ
     * A.1.1.9.2
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.2 Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке» " +
            "для внеплановой КНМ")
    public void addingEntriesSectionMandatoryRequirementsForUnPlanedEventTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        clickedOnNavigationMenuItem(buttonSubjectOfVerification);
        clickButtonAddForRequirements();
        checkTextContent(hintTextForSearchNPA, "Для отображения НПА, содержащих обязательные требования, необходимо " +
                "осуществить поиск");
        checkTextInPlaceholder("Введите номер или часть наименования НПА");
        searchNameNPA("правительство");
        selectNPAFromTable();
        selectSEFromList();
        clickOnRequirements();
        checkValueOfFieldRequirement();
    }

    /**
     * Цель: Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке» для плановой КНМ
     * A.1.1.9.2/1
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.2/1 Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке» " +
            "для плановой КНМ")
    public void addingEntriesSectionMandatoryRequirementsForPlanedEventTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, controlPurchase, plannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        clickedOnNavigationMenuItem(buttonSubjectOfVerification);
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        selectNPAFromTable();
        selectSEFromList();
        clickOnRequirements();
        checkValueOfFieldAllRequirementForPlanedEvent();
    }

    /**
     * Цель: Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке» с созданием НПА
     * A.1.1.9.2/2
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.2/2 Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке» " +
            "с созданием НПА")
    public void addingEntriesSectionMandatoryRequirementsWhichCreateNPATest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNSForPlan, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        clickedOnNavigationMenuItem(buttonSubjectOfVerification);
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        checkElementInvisible("Найденные НПА", npaInTable);
        String numberNPA = addNewNPA(randomNumber);
        selectSEFromList();
        clickButtonAddForRequirements();
        searchNameNPA(numberNPA);
        checkNumberNPAFromTable(numberNPA);
    }

    /**
     * Цель: Проверка валидации при создании НПА в подразделе «Обязательные требования, подлежащие проверке»
     * A.1.1.9.2/3
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.2/3 Проверка валидации при создании НПА в подразделе «Обязательные требования, " +
            "подлежащие проверке»")
    public void validationForAddRecordsRequirementsVerifiedEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNSForPlan, controlPurchase, unplannedCheck, currentDate, currentDate, interactionDays,
                null,viewEntity);
        closeNotification();
        getNumberKNM();
        clickedOnNavigationMenuItem(buttonSubjectOfVerification);
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        clickButtonAddNewNPA();
        clickButtonAddSE();
        clickButtonSaveForCreateNewNPA();
        checkTextErrorField("Дата утверждения акта", textErrorUnderInputDateNPA, textErrorNotNullInput);
        checkTextErrorField("Наименование НПА", textErrorUnderInputTitleNPA, textErrorNotNullInput);
        clickButtonCancelForCreateNewNPA();
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        String numberNPA = addNewNPA(randomNumber);
        clickButtonCancelForCreateNewNPA();
        clickButtonAddForRequirements();
        searchNameNPA(numberNPA);
        addNewNPA(numberNPA);
        checkValidationForCreateNewNPA();
    }

    /**
     * Цель: Проверка требований к подразделу «Нарушенные обязательные требования»
     * A.1.1.9.3
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.3 Проверка требований к подразделу «Нарушенные обязательные требования»")
    public void subsectionViolatedMandatoryRequirementsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        transferEventStatusReadyApproval("4.0.15", currentDateTime, currentDate, currentDate, doesNotRequire,
                typeActionsRetrievalDocuments);
        clickedOnNavigationMenuItem(linkInfoAboutAct);
        clickAddInformationAboutActsButton();
        setTypeOfActDropDown(actOfImpossibility);
        checkElementInvisible("Раздел обязательные требования", violatedMandatoryRequirements);
        setTypeOfActDropDown(supervisoryAct);
        setViolatedMandatoryRequirements();  // незаполненно
        clickSaveButton();
        clickedOnNavigationMenuItem(linkInfoHistoryOfChanges);
        checkLogInHistory("");

    }

    /**
     * Цель: Проверка добавления записей в подраздел «Нарушенные обязательные требования»
     * A.1.1.9.4
     *
     * @author Kirilenko P.A. 11.2022
     */
    @Epic("4.1.43")
    @Feature("ЕРКНМ")
    @Story("КНМ")
    @Test(description = "A.1.1.9.4 Проверка добавления записей в подраздел «Нарушенные обязательные требования»")
    public void addingEntriesMandatoryRequirementsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListKNMPage();
        addKNM(nameKNOFNS, viewKNOFNS, documentaryVerification, unplannedCheck, currentDate, currentDate, interactionDays,
                null, viewEntity);
        closeNotification();
        getNumberKNM();
        transferEventStatusReadyApproval("4.0.15", currentDateTime, currentDate, currentDate, doesNotRequire,
                typeActionsRetrievalDocuments);
        clickedOnNavigationMenuItem(linkInfoAboutAct);
        clickAddInformationAboutActsButton();
        setTypeOfActDropDown(supervisoryAct);
        // нажать кнопку добавить «Нарушенные обязательные требования»
        // проверить наличие в таблице пар НПА и СЕ - получить количество
        // выбрать все пары
        // нажать добавить в форме
        // проверить добавленных пар по количеству
        // удалить одно значение
        // проверить добавленных пар по (количеству - 1)
        // свернуть блок с парами
        // проверить на невидимость пар
        // развернуть блок с парами
        // проверить на видимость пар

    }

}
