package testCases.listEvents;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import testPages.ListEventsPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

//раздел Список КНМ
public class ListEventsTest extends ListEventsPage {

    public String numberKNM = "";
    Random rnd = new Random();
    int prefix = rnd.nextInt(1000000);


    /**
     * Цель: Создание внеплановой КНМ требующей согласования
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)", priority=1)
    public void createEventStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        checkObject("В процессе заполнения");
        numberKNM = getNumberKNM();
        closeNotification();
        //logout();
    }

    /**
     * Цель: Создание шаблонов обязательных требований (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "Создание шаблонов обязательных требований (для ЕРКНМ)", priority=2)
    public void createTemplateMandatoryRequirementsERKNMTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        //openCard(numberKNM);
        openCard("77220660001100008841");
        //TODO: иногда при скроле до элемента верхняя панель перекрывает поля для ввода
        createMandatoryRequirements(prefix +"авто",prefix +"авто",currentDate);
        clickSaveButton();
        checkObject(prefix +"авто");
        //logout();
    }

    /**
     * Цель: Перевод КНМ в статус готово к согласованию
     * HP ALM
     * @author Frolova S.I 01.2022
     */
   // @Test(description = "2 - Перевод КНМ в статус готово к согласованию", dependsOnMethods={"createTemplateMandatoryRequirementsERKNMTest"})
    @Test(description = "2 - Перевод КНМ в статус готово к согласованию")
    public void transferEventStatusReadyApprovalTest() {
        installPlugin();
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard("77220660001100008841");
        switchTo().window(1);
        setDateTimePublicationDecisionField(currentDate);
        setSolutionNumberField(prefix +"");
        setPlaceDecisionField(prefix + "автотестМесто");
        setNameOfficialField(prefix + "autoFIO");
        setPositionPersonSignedDecisionsDropDown();
        setDurationDaysField("1");
        addGroundsConductingUnscheduled(filePath,signPath,needCoordination);
        addListActions(currentDate,currentDate);
        clickAddVenueButton();
        setVenueField(prefix + "автотестместо");
        closeNotification();
        clickSaveButton();
        checkObject("Готово к согласованию");
        closeNotification();
        clickActionsHeaderButton();
        clickSignatureButton();
        choiceSignature();
        //Selenide.confirm();
        clickSignatureButton();
        //logout();
    }

    /**
     * Цель: Перевод КНМ в статус на согласовании
     * HP ALM
     * @author Frolova S.I 01.2022
     */
   // @Test(description = "3 - Перевод КНМ в статус на согласовании", dependsOnMethods={"transferEventStatusReadyApprovalTest"})
    @Test(description = "3 - Перевод КНМ в статус на согласовании")
    public void transferEventStatusOnApprovalTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
       // openCard("numberKNM");
        openCard("77220660001100008840");
        clickActionsOnCardButton();
        clickForApprovalButton();
        checkObject("На согласовании");
    }

    /**
     * Цель: Перевод КНМ в статус ожидает завершения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
  //  @Test(description = "4 - Перевод КНМ в статус ожидает завршения", dependsOnMethods={"transferEventStatusOnApprovalTest"})
    @Test(description = "4 - Перевод КНМ в статус ожидает завршения")
    public void transferEventStatusAgreedTest() {
        authorization("prosecutor");
        choiceERKNM();
        gotoListKNMPage();
        // openCard("numberKNM");
        openCard("77220660001100008840");
        setDecisionApplicationDropDown(approved);
        clickSaveButton();
        checkObject("Ожидает завершения");
    }

    /**
     * Цель: Перевод КНМ в статус завершено
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    //@Test(description = "5 - Перевод КНМ в статус завершено", dependsOnMethods={"transferEventStatusAgreedTest"})
    @Test(description = "5 - Перевод КНМ в статус завершено")
    public void transferEventStatusWaitCompletedTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        // openCard("numberKNM");
        openCard("77220660001100008840");
        addInformationAboutAct(filePath,signPath,number,currentDate,currentDate,number,fio,fio,"",familiarWith,fio,"");
        clickSaveButton();
        checkObject("Завершено");
    }

    /**
     * Цель: Перевод КНМ в статус ожидает проведения
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод КНМ в статус ожидает проведения")
    public void transferEventStatusWaitCompletionsTest() {
        //открываем КНМ созданную в тесте 1 ранее На данном статусе необходимо выбрать соблюдены ли обязательные требования,
        //если было заполнено поле “Обязательные требования, подлежащие проверке”. Проверка не
        //является завершенной.
    }

    /**
     * Цель: Удаление КНМ
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление КНМ")
    public void deleteEventTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        addUnplannedKNM(nameKNO, viewKNO, controlPurchase, currentDate, prosecutorsOffice, INN);
        clickActionsOnCardButton();
        clickDeleteButton();
        checkObject("Удалено");
        gotoListKNMPage();
        checkAbsenceObject("05220131000200090625");
        //TODO можно добавить проверку мессаджа "КНМ успешно удален."

    }

    /**
     * Цель: Создание шаблонов проверочных листов (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРКНМ)")
    public void createTemplateTestSheetsERKNMTest() {
        //создаем новую и добавляем проверочные листы
    }

    /**
     * Цель: Добавление уполномоченных на проведение проверки (для ЕРКНМ)
     * HP ALM
     * @author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addRepresentativesERKNMTest() {
        //создаем новую и добавляем уполномоченных
    }

}
