package testCases.pmi_4_1_58;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListEventsERPPage;

/**
 * 1.1.2 Проверка отмены проведения проверок согласно требованиям ПП №336 от 10 марта 2022 г.
 */

public class TestERP_4_1_58 extends ListEventsERPPage {

    public TestERP_4_1_58() throws Exception {
    }

    /**
     * Цель: Проверка завершения КНМ из паспорта по кнопке «Завершить ПП 336».
     * A.1.1.2.1
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.58")
    @Feature("ЕРП")
    @Story("КНМ")
    @Test(description = "A.1.1.2.1 Проверка завершения КНМ из паспорта по кнопке «Завершить ПП 336».")
    public void completionKNMFromPassportTest() throws Exception {
        String[] events = new String[]{"772200000088",  // ожидает проведения до 11.03.2022
                "772200054656"  // ожидает завершения, создана до 11.03.2022, плановая, с Датой начала КНМ с 01.04.2022 включительно.
        };
        authorization("supervisor");
        selectionERP();
        for(String event : events){
            gotoListKNMPage();
            openCard(event);
            if(event == "772200054656"){
                checkElementInvisible("«Завершить ПП 336»", completePPButton);
            }
            else {
                checkElementVisible("«Завершить ПП 336»", completePPButton);
                clickButtonCompletePP();
                checkTextModalWindow(textModalForCompletePP, "[Изменение данных" +
                        " в КНМ после его завершения будет недоступно. Перед выполнением действия по завершению КНМ по ПП336, " +
                        "выполните сохранение изменений путем нажатия на кнопку «Сохранить»., Действие по завершению КНМ по ПП336" +
                        " является необратимым и является отменой проведения КНМ на основании постановления Правительства " +
                        "Российской Федерации от 10 марта 2022 г. № 336 «Об особенностях организации и осуществления государственного" +
                        " контроля (надзора), муниципального контроля».]");
                clickNotButtonForModalCompletePP();
            }
        }
    }
}
