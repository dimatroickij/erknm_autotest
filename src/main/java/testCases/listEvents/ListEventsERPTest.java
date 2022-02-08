package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

public class ListEventsERPTest extends ListEventsERPPage {
    //раздел Список проверок в режиме ЕРП

    public String knmNumber = "772200008548";
//    public String knmNumber;

    /*
     author Troickij D. A. 01.2022
     */
    @Test(description = "1 - Добавление проверки (статус в процессе формирования)")
    public void createEventStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        clickAddButton();
        setViewKNMDropDown(unscheduledCheck);
        setFormKMNDropDown(exitAndDocumentaryForm);
        setTypeSubjectDropDown(legalEntity);
        setNumberOrdersField(String.valueOf(122345));
        setDateOrdersField();
        setDateStartKNMField();
        setDateStopKNMField();
        clickAddLegalGroundsConductingButton();
        clickAbsenceDirectoryRadioButton();
        setLegalGroundsConductingField("НПА");
        clickSaveLegalGroundsConductingButton();
        setGoalsTasksSubjectField("Автотест");
        setDurationEventDaysField("30");
        setDurationEventHoursField("30");
        clickAddListControlMeasuresButton();
        setListControlMeasuresField("Автотест");
        clickAddGroundRegistrationButton();
        setGroundRegistrationDropDown();
        setNameKNODropDown(nameKNO);
        setKindControlDropDown(viewKNOERP);
        setInnField(INN, "Тест");
        setMandatoryRequirementsDropDown(false);
        clickSaveButton();
        closeNotification();
        knmNumber = getKnmNumber();
        System.out.println(knmNumber);
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessFormation, true);
//        logout();
    }

    /*
     author Troickij D. A. 01.2022
     */
    @Test(description = "2 - Перевод проверки в статус  в процессе проведения")
    public void transferEventStatusProcessConductingTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        openCard(knmNumber);
        clickObjectsKNMButton();
        setAddressField("Автотест");
        setAddressTypeDropDown(locationLE);
        setTypeObjectDropDown(branch);
        setRiskCategoryDropDown(righRisk);
        clickSaveButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessConducting, true);
//        logout();
    }

    /*
    author Troickij D. A. 02.2022
    */
    @Test(description = "3 - Перевод проверки в статус завершено")
    public void transferEventStatusCompletedTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        openCard(knmNumber);
        clickListResultButton();
        setObjectKNMDropDown();
        setDateTimeActField();
        setResultAddressField("Автотест");
        setResultAddressTypeDropDown(locationLE);
        setDateTimeKNMField();
        clickSaveButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusCompleted, true);
//        logout();
    }

    /*
    author Troickij D. A. 02.2022
    */
    @Test(description = "4 - Удаление проверки")
    public void deletedEventTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        openCard(knmNumber);
        clickActionsButton();
        clickDeleteButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusCompleted, false);
        logout();
    }

    @Test(description = "5 - Добавление шаблонов в паспорт проверки при создании (для ЕРП)")
    public void addTemplatesInCheckCardTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        clickAddButton();
        setViewKNMDropDown(unscheduledCheck);
        setFormKMNDropDown(exitAndDocumentaryForm);
        setTypeSubjectDropDown(legalEntity);
        setNumberOrdersField(String.valueOf(122345));
        setDateOrdersField();
        setDateStartKNMField();
        setDateStopKNMField();
        clickAddLegalGroundsConductingButton();
        clickAbsenceDirectoryRadioButton();
        setLegalGroundsConductingField("НПА");
        clickSaveLegalGroundsConductingButton();
        setGoalsTasksSubjectField("Автотест");
        setDurationEventDaysField("30");
        setDurationEventHoursField("30");
        clickAddListControlMeasuresButton();
        setListControlMeasuresField("Автотест");
        clickAddGroundRegistrationButton();
        setGroundRegistrationDropDown();
        setNameKNODropDown(nameKNO);
        setKindControlDropDown(viewKNOERP);
        setInnField(INN, "Тест");
        templateMandatoryRequirements = "236812авто Наименование";
        setMandatoryRequirementsDropDown(true);
        resresentative = "800550авто ФИО";
        setResresentativesDropDown(true);
        clickSaveButton();
        closeNotification();
        knmNumber = getKnmNumber();
        System.out.println(knmNumber);
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessFormation, true);
//        logout();
    }
}
