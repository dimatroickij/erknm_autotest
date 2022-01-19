package testCases.listPlans;

import org.testng.annotations.Test;

public class ListPlansERPTest {
    // работа с планами в режиме ЕРП
    @Test(description = "1 - Создание плана (Статус Новый) в ЕРП")
    public void createPlanERPTest(){
        //СОздание плана + добавление КНМ или создание КНМ с номером созданного плана в ЕРП
    }

    @Test(description = "2 - Удаление плана в ЕРП")
    public void deletePlanERPTest(){

    }

    @Test(description = "3 - Перевод плана в статус На согласовании в ЕРП")
    public void  transferPlanStatusOnApprovalTest(){

    }

    @Test(description = "4 - Перевод плана в статус На доработке в ЕРП")
    public void  transferPlanStatusFrRevisionTest(){

    }

    @Test(description = "5 - Перевод плана в статус Согласован в ЕРП")
    public void  transferPlanStatusAgreedTest(){

    }

    @Test(description = "6 - Перевод плана в статус Утвержден в ЕРП")
    public void  transferPlanStatusApprovedTest(){

    }

}
