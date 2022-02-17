package testCases.listPlans;

import org.testng.annotations.Test;
import testPages.ListEventsERPPage;
import testPages.ListPlanERPPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Selenide.switchTo;

public class ListPlansERPTest extends ListPlanERPPage {
    // работа с планами в режиме ЕРП

    /**
     * Цель: Создание плана (Статус Новый) в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=195
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Создание плана (Статус Новый) в ЕРП")
    public void createPlanERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        numberPlan = createPlan();
        closeNotification();
        // Можно добавить проверку на динамическое появление плана на странице списка планов
        searchPlan(numberPlan, newPlan, true);
        logout();
        authorization("supervisor");
        choiceERP();
        gotoERPListKNMPage();

        ListEventsERPPage listEventsERPPage = new ListEventsERPPage();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        String startDate = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());

        String scheduledKNMNumber = listEventsERPPage.createScheduledEvent(startDate,
                listEventsERPPage.groundPlannedRegistration, false, false);
        System.out.println(scheduledKNMNumber);
        System.out.println(numberPlan);
        logout();
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        //String scheduledKNMNumber = "772200008564";
        //numberPlan = "2022037661";
        //Integer lastCountKNM = getCountKNMToPlan(numberPlan);
        addKNMtoPlan(numberPlan, scheduledKNMNumber);
        //Assert.assertEquals(getCountKNMToPlan(numberPlan), lastCountKNM + 1); // проверка на динамическое изменение количества проверок в КНМ на странице
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
    public void deletePlanERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        String deletedNumberPlan = createPlan();
        //String deletedNumberPlan = "2022037580";
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
        //numberPlan = "2022037406";
        workToPlan(onApprovalPlan);
        logout();
    }

    /**
     * Цель: Перевод плана в статус На доработке в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3328
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус На доработке в ЕРП")
    public void transferPlanStatusOnRevisionERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        //numberPlan = "2022037662";
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
        //numberPlan = "2022037662";
        workToPlan(agreedPlan);
        logout();
    }

    /**
     * Цель: Перевод плана в статус Утвержден в ЕРП
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=3330
     *
     * @author Troickij D. A. 02.2022
     */
    @Test(description = "Перевод плана в статус Утвержден в ЕРП")
    public void transferPlanStatusApprovedERPTest() {
        authorization("prosecutor");
        choiceERP();
        gotoListPlansPage();
        //numberPlan = "2022037662";
        workToPlan(approvedPlan);
        logout();
    }

}
