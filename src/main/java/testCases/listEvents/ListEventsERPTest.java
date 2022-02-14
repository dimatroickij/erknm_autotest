package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ListEventsERPTest extends ListEventsERPPage {
    //раздел Список проверок в режиме ЕРП

    //    public String knmNumber = "772200008566";
    public String knmNumber;

    /*
     author Troickij D. A. 01.2022
     */
    // TODO Переделать
    @Test(description = "1 - Добавление проверки (статус в процессе формирования)")
    public void createEventStatusProcessCompletionERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String startDate = LocalDateTime.from((new Date()).toInstant()).minusDays(1).format(formatter);
        String stopDate = LocalDateTime.from((new Date()).toInstant()).plusDays(2).format(formatter);
        knmNumber = createUnscheduledEvent(currentDate, startDate, stopDate, false, false);
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessFormation, true);
        logout();
    }

    /*
     author Troickij D. A. 01.2022
     */
    @Test(description = "2 - Перевод проверки в статус  в процессе проведения")
    public void transferEventStatusProcessConductingERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        openCard(knmNumber);
        clickObjectsKNMButton();
        setAddressField(address);
        setAddressTypeDropDown(locationLE);
        setTypeObjectDropDown(branch);
        setRiskCategoryDropDown(righRisk);
        clickSaveButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessConducting, true);
        logout();
    }

    /*
    author Troickij D. A. 02.2022
    */
    @Test(description = "3 - Перевод проверки в статус завершено")
    public void transferEventStatusCompletedERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        openCard(knmNumber);
        clickListResultButton();
        setObjectKNMDropDown();
        setDateTimeActField(currentDate);
        setResultAddressField(address);
        setResultAddressTypeDropDown(locationLE);
        setDateTimeKNMField(currentDateTime);
        clickSaveButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusCompleted, true);
        logout();
    }

    /*
    author Troickij D. A. 02.2022
    */
    @Test(description = "4 - Удаление проверки")
    public void deletedEventERPTest() {
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

    // TODO переделать
    @Test(description = "5 - Добавление шаблонов в паспорт проверки при создании (для ЕРП)")
    public void addTemplatesInCheckCardERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        //templateMandatoryRequirements = "236812авто Наименование";
        //resresentative = "54796авто ФИО";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String startDate = LocalDateTime.from((new Date()).toInstant()).minusDays(1).format(formatter);
        String stopDate = LocalDateTime.from((new Date()).toInstant()).plusDays(2).format(formatter);
        knmNumber = createUnscheduledEvent(currentDate, startDate, stopDate, true, true);
        // TODO Для добавления проверочных листов проверка должна быть плановой, но для этого нужно заполнять больше полей
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessFormation, true);
        logout();
    }
}
