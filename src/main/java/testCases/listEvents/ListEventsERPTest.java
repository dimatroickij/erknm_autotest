package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListEventsERPTest extends ListEventsERPPage {
    //раздел Список проверок в режиме ЕРП

    public String knmNumber;

    /**
     * Цель: Добавление проверки (статус в процессе формирования)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3299
     *
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Добавление проверки (статус в процессе формирования)")
    public void createEventStatusProcessCompletionERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String startDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        String stopDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
        knmNumber = createUnscheduledEvent(currentDate, startDate, stopDate, groundRegistration,
                false, false, true, true);
        System.out.println("Созданная проверка " + knmNumber);
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessFormation, true);
        logout();
    }

    /**
     * Цель: Перевод проверки в статус в процессе проведения
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3300
     *
     * @author Troickij D. A. 01.2022
     */
    @Test(description = "Перевод проверки в статус в процессе проведения")
    public void transferEventStatusProcessConductingERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        openCard(knmNumber);
        setObjectKNM(address, locationLE, branch, righRisk, true);
        clickSaveButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(knmNumber);
        clickSearchButton();
        checkKNM(knmNumber, statusProcessConducting, true);
        System.out.println("Проверка " + knmNumber + " переведена в статус '" + statusProcessConducting + "'");
        logout();
    }

    /**
     * Цель: Перевод проверки в статус завершено
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3301
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод проверки в статус завершено")
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
        System.out.println("Проверка " + knmNumber + " переведена в статус '" + statusCompleted + "'");
        logout();
    }

    /**
     * Цель: Удаление проверки
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=172
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Удаление проверки")
    public void deletedEventERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String startDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        String stopDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
        String deleteKNMNumber = createUnscheduledEvent(currentDate, startDate, stopDate, groundRegistration,
                false, false, true, true);
        gotoERPListKNMPage();
        openCard(deleteKNMNumber);
        clickActionsOnCardButton();
        clickDeleteOnCardButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(deleteKNMNumber);
        clickSearchButton();
        checkKNM(deleteKNMNumber, statusCompleted, false);
        System.out.println("Проверка " + knmNumber + " удалена");
        logout();
    }

    /**
     * Цель: Добавление шаблонов в паспорт проверки при создании (для ЕРП)
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=116
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Добавление шаблонов в паспорт проверки при создании (для ЕРП)")
    public void addTemplatesInCheckCardERPTest() {
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String startDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
        String scheduledKNMNumber = createScheduledEvent(startDate, groundPlannedRegistration,
                true, true, true, true);
        setObjectKNM(address, locationLE, branch, righRisk, true);
        setTemplateSheetsDropDown(true); // TODO баг, который мешает проверке функции
        clickSaveButton();
        closeNotification();
        gotoERPListKNMPage();
        setSearchField(scheduledKNMNumber);
        clickSearchButton();
        checkKNM(scheduledKNMNumber, statusProcessConducting, true);
        System.out.println("Созданная проверка с добавлением шаблонов" + knmNumber);
        logout();
    }
}
