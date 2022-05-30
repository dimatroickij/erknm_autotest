package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;
import testPages.ListPlanERPPage;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListPlansERPTest extends ListPlanERPPage {
    public ListPlansERPTest() throws Exception {
    }
    // работа с планами в режиме ЕРП

    /**
     * Цель: Создание плана (Статус Новый) в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=195
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Создание плана (Статус Новый) в ЕРП")
    public void createPlanERPTest() throws Exception {
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        numberPlan = createPlan();
        System.out.println("Номер плана " + numberPlan);
        closeNotification();
        // TODO Можно добавить проверку на динамическое появление плана на странице списка планов
        searchPlan(numberPlan, newPlan, true);
        logout();
        authorization("supervisor");
        choiceMode(false);
        gotoERPListKNMPage();

        ListEventsERPPage listEventsERPPage = new ListEventsERPPage();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        String startDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());

        String scheduledKNMNumber = listEventsERPPage.createScheduledEvent(startDate,
                listEventsERPPage.groundPlannedRegistration, false, false, true, true);
        System.out.println("Номер созданной проверки " + scheduledKNMNumber);
        logout();
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        //Integer lastCountKNM = getCountKNMToPlan(numberPlan);
        addKNMtoPlan(numberPlan, scheduledKNMNumber);
        //Assert.assertEquals(getCountKNMToPlan(numberPlan), lastCountKNM + 1); // проверка на динамическое изменение количества проверок в КНМ на странице //TODO подумать как можно сделать динамическую проверку на количество проверок в плане
        openCard(numberPlan);

        setSearchField(scheduledKNMNumber);
        clickSearchButton();
        listEventsERPPage.checkKNM(scheduledKNMNumber, true);
        logout();
    }

    /**
     * Цель: Удаление плана в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=199
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Удаление плана в ЕРП")
    public void deletePlanERPTest() throws Exception {
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        String deletedNumberPlan = createPlan();
        System.out.println("Номер удалённого плана " + numberPlan);
        clickPlanCheckBox(deletedNumberPlan);
        clickDeleteButton();
        clickConfirmButton();
        closeNotification();
        searchPlan(deletedNumberPlan, false);
        closeNotification();
        logout();
    }

    /**
     * Цель: Перевод плана в статус На согласовании в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=197
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус На согласовании в ЕРП")
    public void transferPlanStatusOnApprovalERPTest() throws Exception {
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        workToPlan(statusOnApproval, numberPlan);
        System.out.println("План " + numberPlan + " переведён в статус '" + statusOnApproval + "'");
        logout();
    }

    /**
     * Цель: Перевод плана в статус На доработке в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3328
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус На доработке в ЕРП")
    public void transferPlanStatusOnRevisionERPTest() throws Exception {
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        workToPlan(onRevisionPlan, numberPlan);
        System.out.println("План " + numberPlan + " переведён в статус '" + onRevisionPlan + "'");
        logout();
    }

    /**
     * Цель: Перевод плана в статус Согласован в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3329
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус Согласован в ЕРП")
    public void transferPlanStatusAgreedERPTest() throws Exception {
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        workToPlan(agreedPlan, numberPlan);
        System.out.println("План " + numberPlan + " переведён в статус '" + agreedPlan + "'");
        logout();
    }

    /**
     * Цель: Перевод плана в статус Утвержден в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3330
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус Утвержден в ЕРП")
    public void transferPlanStatusApprovedERPTest() throws Exception {
        authorization("prosecutor");
        choiceMode(false);
        gotoListPlansPage();
        workToPlan(approvedPlan, numberPlan);
        System.out.println("План " + numberPlan + " переведён в статус '" + approvedPlan + "'");
        logout();
    }

}
