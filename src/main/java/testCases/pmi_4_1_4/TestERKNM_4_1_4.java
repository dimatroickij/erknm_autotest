package testCases.pmi_4_1_4;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testPages.ListPreventionEventsPage;
import testPages.OpenPartPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static java.lang.Thread.sleep;

/**
 * 1.1.8 Проверка выполнения требований по доработкам паспорта профилактического мероприятия.
 */

public class TestERKNM_4_1_4 extends ListPreventionEventsPage {

    public TestERKNM_4_1_4() throws Exception {
    }

    OpenPartPage openPage = new OpenPartPage();

    /**
     * Цель: Проверка требований к разделу «Сведения о предмете профилактического мероприятия» в ПМ
     * A.1.1.8.1
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.1 Проверка требований к разделу «Сведения о предмете профилактического мероприятия» в ПМ")
    public void informationSubjectOfPreventiveEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        clickedOnNavigationMenuItem(linkInfoSubjectOfPreventionEvent);
        clickButtonAddForRequirements();

        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        openCard("77220521000000065884");
        clickConfirmButton();
        clickedOnNavigationMenuItem(linkInfoSubjectOfPreventionEvent);
        checkElementVisible("Кнопка Добавить в «Обязательные требования, подлежащие проверке»",
                buttonAddForRequirements);
        clickOnRequirements();
        checkValueOfFieldRequirement();
    }

    /**
     * Цель: Проверка требований к подразделу «Обязательные требования, подлежащие проверке»
     * A.1.1.8.2
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.2 Проверка требований к подразделу «Обязательные требования, подлежащие проверке»")
    public void mandatoryRequirementsVerifiedEventsTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        setFieldsForSavePMStatusWarningDeclared(currentDate);
        checkElementAvailable("Кнопка Добавить в «Обязательные требования, подлежащие проверке»",
                buttonAddForRequirements);
        clickSaveButton();
        clickConfirmButton();
        checkStatusPM("В процессе заполнения");
        String numberPM = getNumberPM();
        setBlockOfRequirements("правительство");
        clickSaveButton();
        checkStatusPM("В процессе заполнения");

        authorization("prosecutor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        openCard(numberPM);
        clickConfirmButton();
        clickedOnNavigationMenuItem(linkInfoSubjectOfPreventionEvent);
        clickOnRequirements();
        checkValueOfFieldRequirement();
        checkElementNotAvailable("Кнопка Добавить в «Обязательные требования, подлежащие проверке»",
                buttonAddForRequirements);

        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        openCard(numberPM);
        clickConfirmButton();
        electronicSignatureInBrowser();
        sleep(5000);
        clickConfirmButton();
        checkStatusPM("Предостережение объявлено");
        clickedOnNavigationMenuItem(linkInfoHistoryOfChanges);
        openHistoryOfChangesPM();
        checkLogInHistory("Значение поля \"ПМ подписан электронной подписью\" изменено с \"Нет\" на \"Да\"");
        clickedOnNavigationMenuItem(linkInfoSubjectOfPreventionEvent);
        clickOnRequirements();
        checkValueOfFieldRequirement();
        checkElementNotAvailable("Кнопка Добавить в «Обязательные требования, подлежащие проверке»",
                buttonAddForRequirements);
    }

    /**
     * Цель: Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке»
     * A.1.1.8.3
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.3 Проверка добавления записей в подраздел «Обязательные требования, подлежащие проверке»")
    public void addRecordsRequirementsVerifiedEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        clickButtonAddForRequirements();
        checkElementNotAvailable("Кнопка Далее при выборе НПА", buttonAddInFormRequirement);
        searchNameNPA("правительство");
        Selenide.sleep(3000);
        selectNPAFromTable();
        checkElementNotAvailable("Кнопка Далее при выборе СЕ", buttonSaveInFormRequirement);
        selectSEFromList();
        checkElementNotAvailable("Кнопка Сохранить при выборе формулировки", buttonSaveInFormRequirement);
        selectContentFromList();
        clickButtonSaveForRequirements();
        clickOnRequirements();
        checkValueOfFieldRequirement();
    }

    /**
     * Цель: Проверка валидации при добавлении записей в подраздел «Обязательные требования, подлежащие проверке»
     * A.1.1.8.3/1
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.3/1 Проверка валидации при добавлении записей в подраздел «Обязательные требования, подлежащие проверке»")
    public void validationForAddRecordsRequirementsVerifiedEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNSForPlan, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNSInPlaned);
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        clickButtonAddNewNPA();
        clickButtonAddSE();
        clickButtonSaveForCreateNewNPA();
        checkTextErrorField("Дата утверждения акта", textErrorUnderInputDateNPA, textErrorNotNullInput);
        checkTextErrorField("Наименование НПА", textErrorUnderInputTitleNPA, textErrorNotNullInput);
//        checkTextErrorField("Еденица в СЕ", errorStopKNMDate, textErrorNotNullInput);
//        checkTextErrorField("Значение в СЕ", errorStopKNMDate, textErrorNotNullInput);
        clickButtonCancelForCreateNewNPA();
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        String numberNPA = addNewNPA(randomNumber);
        clickButtonCancelForCreateNewNPA();
        clickButtonAddForRequirements();
        searchNameNPA(numberNPA);
        addNewNPA(numberNPA);
        checkValidationForCreateNewNPA();
    }

    /**
     * Цель: Проверка редактирования записей в подраздел «Обязательные требования, подлежащие проверке»
     * A.1.1.8.3/2
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.3/2 Проверка редактирования записей в подраздел «Обязательные требования, подлежащие проверке»")
    public void editForRecordsRequirementsVerifiedEventsTest() throws Exception {
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        clickAddButton();
        setFieldsForPreventionEvent(nameKNOFNS, viewKNOFNSForPlan, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNSInPlaned);
        clickButtonAddForRequirements();
        searchNameNPA("правительство");
        String numberNPA = addNewNPA(randomNumber);
        clickButtonCancelForCreateNewNPA();
        clickButtonAddForRequirements();
        searchNameNPA(numberNPA);
        String newNumberNPA = editFieldsNPA(numberRandom());
        searchNameNPA(newNumberNPA);
        checkNumberNPAFromTable(newNumberNPA);
    }

    /**
     * Цель: Проверка отображения полей подраздела «Обязательные требования, подлежащие проверке» в открытой части ЕРКНМ
     * A.1.1.8.4
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ ОЧ")
    @Test(description = "A.1.1.8.4 Проверка отображения полей подраздела «Обязательные требования, подлежащие проверке» " +
            "в открытой части ЕРКНМ")
    public void displayFieldsRequiredRequirementsTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNSForPlan, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNSInPlaned);
        String numberNPA = transferPMEventWarningAnnouncementStatusWarningAnnounced();
        String numberPM = getNumberPM();

        open(openUrl);
        openPage.gotoHomeOpenPage();
        openPage.searchEventsWithCaptcha(numberPM,  openPage.captcha);
        openPage.openFoundEvent();
        openPage.checkFieldVisible("Автотест");
        openPage.checkFieldVisible(numberNPA);
        openPage.checkFieldVisible(currentDate);
        openPage.checkFieldVisible("Статья " + numberPM);
        openPage.checkFieldVisible("Автотест содержание");
    }

    /**
     * Цель: Проверка изменений в паспорте ПМ вида «Объявление предостережения»
     * A.1.1.8.5
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ ОЧ")
    @Test(description = "A.1.1.8.5 Проверка изменений в паспорте ПМ вида «Объявление предостережения»")
    public void changesInPassportEventsForWarningTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        gotoListPreventionEventsPage();
        addPreventionEvent(nameKNOFNS, viewKNOFNS, typeAnnouncementWarningsPM, currentDate, INN, kingObjectForFNS);
        checkNameField("Дата объявления предостережения", nameFieldForStartDate);
        checkElementInvisible("Дата окончания", stopDateField);
        transferPMEventWarningAnnouncementStatusWarningAnnounced();
        String numberPM = getNumberPM();

        open(openUrl);
        openPage.gotoHomeOpenPage();
        openPage.searchEventsWithCaptcha(numberPM,  openPage.captcha);
        openPage.openFoundEvent();
        openPage.checkFieldVisible("Дата объявления предостережения");
        openPage.checkFieldInVisible("Дата окончания");
    }

    /**
     * Цель: Проверка применения валидации требования к ПМ, созданным в системе после выхода требования в промышленный контур
     * A.1.1.8.6
     *
     * @author Kirilenko P.A. 10.2022
     */
    @Epic("4.1.4")
    @Feature("ЕРКНМ")
    @Story("ПМ")
    @Test(description = "A.1.1.8.6 Проверка применения валидации требования к ПМ, созданным в системе после выхода " +
            "требования в промышленный контур")
    public void applyingValidationToOldPMTest() throws Exception {
        installPlugin();
        authorization("supervisor");
        selectionERKNM();
        while (true){
            sleep(2000);
            gotoListPreventionEventsPage();
            sortingByPeriod(true);
            openCard(getNumberRandomEvent());
            clickConfirmButton();
            String status = getStatusPM();
            System.out.println(status);
            if(status.equals(statusProcessFilling)) {
                break;
            }
        }
        if (getValueOfField("Вид ПМ", valueOfFieldKindPM).equals(typeAnnouncementWarningsPM)) {
            setFieldsForSavePMStatusWarningDeclared(currentDate);
            clickSaveButton();
            closeNotification();
            electronicSignatureInBrowser();
            sleep(5000);
            clickConfirmButton();
            checkStatusPM(statusWarningAnnounced);
        } else {
            setFieldsForSavePMStatusPreventiveVisit(currentDate);
            clickSaveButton();
            electronicSignatureInBrowser();
            sleep(5000);
            clickConfirmButton();
            checkStatusPM(statusProcessAwaiting);
        }
    }



}
