package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

public class ListEventsERPTest extends ListEventsERPPage {
    //раздел Список проверок в режиме ЕРП

    @Test(description = "1 - Добавление проверки (статус в процессе формирования)")
    public void createEventStatusProcessCompletionTest() throws InterruptedException {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        clickAddButton();
        setViewKNMDropDown(unscheduledCheck);
        setFormKMNDropDown(onsiteAndDocumentaryForm);
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
        //setNameKNODropDown(nameKNO);
        setKindControlDropDown(viewKNOERP);
        setInnField(INN, "Тест");
        setMandatoryRequirementsDropDown();
        //clickSaveButton();
        Thread.sleep(4000);
    }

    @Test(description = "2 - Перевод проверки в статус  в процессе проведения")
    public void transferEventStatusProcessConductingTest() {
    }

    @Test(description = "3 - Перевод проверки в статус завершено")
    public void transferEventStatusCompletedTest() {
    }

    @Test(description = "4 - Удаление проверки")
    public void deletedEventTest() {
    }

    @Test(description = "5 - Добавление шаблонов в паспорт проверки при создании (для ЕРП)") //из bvt для личного кабинета ЕРП (4 кейс)
    public void addTemplatesInCheckCardTest() {
        //создаем новую и подписываем через загрузить подпись
    }
}
