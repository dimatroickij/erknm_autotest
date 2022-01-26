package testCases.listEvents;

import org.testng.annotations.Test;
import testPages.ListEventsPage;

import java.text.SimpleDateFormat;
import java.util.Date;

//раздел Список КНМ
public class ListEventsTest extends ListEventsPage {

    public String numberKNM = "";


    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "1 - Добавление внеплановой КНМ требующей согласования (статус в процессе заполнения)")
    public void createEventStatusProcessCompletionTest() {
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        clickAddButton();
        setNameKNODropDown(nameKNO);
        setKindControlAndNumberDropDown(viewKNO);
        setKindKNMDropDown(controlPurchase);
        setCharacterKNMDropDown(unplannedCheck);
        setStartKNMDate();
        setNameProsecutorDropDown(prosecutorsOffice);
        setInnField(INN);
       // setAdressField("fl");
        setTypeObjectDropDown();
        setKindObjectDropDown();
        clickSaveButton();
        //400 ошибка в апи
        numberKNM = getNumberKNM();

      /**
       * Логирование аллюр
       * SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false)); // или savePageSource(true))

        Capture selenium logs:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().enableLogs(LogType.BROWSER, Level.ALL));
        https://github.com/SeleniumHQ/selenium/wiki/Logging
**/
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "2 - Перевод КНМ в статус готово к согласованию")
    public void transferEventStatusReadyApprovalTest() {

     /*   open("http://private.proverki.local/private/knm/808253");
        setLogin(loginProsecutor);
        setPassword(password);
        clickEnterButton();
        numberKNM = getNumberKNM();*/
        authorization("supervisor");
        choiceERKNM();
        gotoListKNMPage();
        openCard("ПМ 77220660001100054148");
        setDateTimePublicationDecisionField();
        setSolutionNumberField("prefix");
        setPlaceDecisionField("prefix + автотестМесто");
        setNameOfficialField("prefix + autoFIO");
        setPositionPersonSignedDecisionsDropDown();
        setDurationDaysField("1");
        clickAddGroundConductingButton();
        setGroundConduсtingDropDown();
        setNeedCoordinationDropDown();
        clickAddFoundationButton();
        setTypeDocumentDropDown();
        clickAddFileButton();
        //добавить автоит
        clickAddListActionsButton();
        setTypeActionsDropDown();
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        setDateStartActions(currentDate);
        setDateEndActions(currentDate);
        createMandatoryRequirements("","", currentDate);

        clickAddVenueButton();
        setVenueField("prefix + автотестместо");

    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Перевод КНМ в статус на согласовании")
    public void transferEventStatusOnApprovalTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "4 - Перевод КНМ в статус согласована")
    public void transferEventStatusAgreedTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "5 - Перевод КНМ в статус ожидает завершения")
    public void transferEventStatusWaitCompletionsTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "6 - Перевод КНМ в статус завершена")
    public void transferEventStatusWaitCompletedTest() {
        //открываем КНМ созданную в тесте 1 ранее
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "7 - Удаление КНМ")
    public void deleteEventTest() {
        //создаем новую и удаляем
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "1 - Создание шаблонов обязательных требований (для ЕРКНМ)")
    public void createTemplateMandatoryRequirementsERKNMTest() {
        //создаем новую и добавляем ОТ
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "2 - Создание шаблонов проверочных листов (для ЕРКНМ)")
    public void createTemplateTestSheetsERKNMTest() {
        //создаем новую и добавляем проверочные листы
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "3 - Добавление уполномоченных на проведение проверки (для ЕРКНМ)")
    public void addResresentativesERKNMTest() {
        //создаем новую и добавляем уполномоченных
    }

    /*
     author Frolova S.I 01.2022
     */
    @Test(description = "4 - Подписание КНМ открепленной подписью")
    public void  signKNMUnpinnedSignatureTest() {
        //создаем новую и подписываем через загрузить подпись
    }

}
