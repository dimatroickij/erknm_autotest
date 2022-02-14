package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;
import testPages.ListPlanERPPage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ListPlansERPTest extends ListPlanERPPage {
    // работа с планами в режиме ЕРП

    /**
     * Цель: Создание плана (Статус Новый) в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=195
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Создание плана (Статус Новый) в ЕРП", enabled = false)
    public void createPlanERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = createPlan();
        closeNotification();
        searchPlan(numberPlan, newPlan, true);
        logout();
//        authorization("supervisor");
//        choiceERP();
//        gotoERPListKNMPage();
//
//        ListEventsERPPage listEventsERPPage = new ListEventsERPPage();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
//        LocalDate startDate = LocalDate.parse(new Date().toString(), formatter2);
//        //String startDate = LocalDateTime.from((new Date()).toInstant()).plusHours(1).minusDays(1).format(formatter);
//        String stopDate = LocalDateTime.from((new Date()).toInstant()).plusHours(1).plusDays(2).format(formatter);
//        //String addEvent = listEventsERPPage.createScheduledEvent(currentDate, startDate, stopDate, false, false);
//        //System.out.println(addEvent);
//        logout();
//        authorization("prosecutor", false);
//        choiceERP();
//        gotoListPlansPage();

    }

    /**
     * Цель: Удаление плана в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=199
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Удаление плана в ЕРП", enabled = false)
    public void deletePlanERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        //String deletedNumberPlan = createPlan();
        String deletedNumberPlan = "2022037580";
        clickPlanCheckBox(deletedNumberPlan);
        clickDeleteButton();
        clickConfirmationDeleteButton();
        closeNotification();
        searchPlan(deletedNumberPlan, false);
        logout();
    }

    /**
     * Цель: Перевод плана в статус На согласовании в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=197
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус На согласовании в ЕРП")
    public void transferPlanStatusOnApprovalERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = "2022037489";
        workToPlan(onApprovalPlan);
        logout();
    }

    /**
     * Цель: Перевод плана в статус На доработке в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3328
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус На доработке в ЕРП", enabled = false)
    public void transferPlanStatusOnRevisionERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = "2022037489";
        workToPlan(onRevisionPlan);
        logout();
    }

    /**
     * Цель: Перевод плана в статус Согласован в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3329
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус Согласован в ЕРП")
    public void transferPlanStatusAgreedERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = "2022037489";
        workToPlan(agreedPlan);
        logout();
    }

    /**
     * Цель: Перевод плана в статус Утвержден в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3330
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус Утвержден в ЕРП", enabled = false)
    public void transferPlanStatusApprovedERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = "2022037489";
        workToPlan(approvedPlan);
        logout();
    }

}
