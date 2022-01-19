package testCases.listPlans;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testPages.ListPlanPage;

import static com.codeborne.selenide.Selenide.$;

public class ListPlansTest extends ListPlanPage {
    //раздел Список планов
    public String numberPlan = "";

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание плана (статус в процессе формирования)")
    public void createPlanTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPlans();
        clickAddButton();
        //нужно менять прокуратуру и орган контроля?
        clickCreateButton();
        numberPlan = getNumberPlan();
        System.out.println("НОМЕР " + getNumberPlan());
        // checkObject("успешно создан");
        openRequest(numberPlan);
        // checkObject("Новый");


    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "2 - Удаление плана")
    public void deletePlanTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListPlans();
        createPlanTest(); //создаем и удаляем
        searchRequest(numberPlan);
        $(By.xpath("//*[@id=" + numberPlan + "]")).click(); //выбор чек-бокса в списке
        clickDeleteButton();
        clickСonfirmationDeleteButton();
        searchRequest(numberPlan);
        checkAbsenceObject(numberPlan);

    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление плановой КНМ в созданный план")
    public void addPlannedKNMInPlanTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNM();
        clickEnterButton();
        clickAddButton();
        //решить в каком порядке запускать, что бы создавать в ListEvent, а использовать здесь или пилить новое добавление КНМ
        /*setNameKNODropDown(nameKNO);
        setKindControlAndNumberDropDown(controlPurchase);
        setCharacterKNMDropDown(unplannedCheck);
        setStartKNMDate(dateStart);
        setInnField(INN);
        clickSaveButton();
        numberKNM = getNumberKNM();*/

    }

    /*
     author Frolova S.I 01.2022
     */
    //статус на согласовании?
    @Test(description = "4 - Перевод плана в статус На рассмотрении")
    public void transferPlanStatusOnConsiderationTest() {
        authorization("prosecutor");
        choiceERKNM();
        gotoListKNM();
        openRequest(numberPlan);
        checkObject("На рассмотрении");

    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод плана в статус Утвержден")
    public void transferPlanStatusApprovedTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNM();
        openRequest(numberPlan);
        checkObject("Утвержден");
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "6 - Исключение КНМ из плана в статусе Утвержден")
    public void exceptionKNMFromApprovedPlanTest() {

    }

}
