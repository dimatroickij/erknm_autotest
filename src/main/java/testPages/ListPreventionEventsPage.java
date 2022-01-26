package testPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class ListPreventionEventsPage extends Common {
    //список ПМ

    String nameKNOPMDropDown = "//*[@id='knoOrganizationPm']"; //выпадающий список Контрольный надзорный орган
    String kindControlAndNumberPMDropDown = "//*[@id='supervisionTypePm']"; //выпадающий список Вид контроля (надзора) и его номер
    String kindPMDropDown = "//*[@id='pmType']"; // выпадающий список Вид ПМ
    public String typeAnnouncementWarningsPM = "Объявление предостережения";
    public String typePreventiveVisitPM = "Профилактический визит";
    public String typeObject = "Деятельность и действия";
    public String viewObject = "используемые контролируемыми лицами при осуществлении деятельности в сфере обращения лекарственных средств помещения, к которым предъявляются обязательные требования";
    public String classDanger = "Первый";
    public String classDanger2 = "Второй";


    // String startDateField = "//*[@id='startDateBlock']"; // поле Дата начала
    String startDateField = "/html/body/div/div/main/form/div[2]/div[1]/div[6]/div[2]/div[1]/div/div/input"; // поле Дата начала
    //String stopDateField = "//*[@id='stopDateBlock']"; // поле Дата окончания
    String stopDateField = "//*[@id='stopDateBlock']/div[2]/div/div/div/input"; // поле Дата окончания
    String innField = "//*[(@name='inn')]"; //Поле ИНН
    String innListField = "//li[contains(@class,'AutoComplete_OptionItem')]"; //выбор из выпадающего списка ИНН
    String typeObjectField = "//*[(@id='objectsPm[0].objectType')]"; // выбор типа объекта
    String viewObjectField = "//*[(@id='objectsPm[0].objectKind')]"; // выбор вида объекта
    String classDangerField = "//*[(@id='objectsPm[0].dangerClass')]"; // выбор класса опасности
    String noteWarningField = "//*[(@id='noteWarning')]"; //поле Описание предостережения
    String addNoteWarningButton = "/html/body/div/div/main/form/div[2]/div[2]/div[2]/div/span/button"; //кнопка Добавить у блока Содержание предостережения
    String addDocumentButton = "//*[(@for='contentWarningAttachmentsUploadDocument')]"; //кнопка Добавить документ
    String addSignatureButton = "//*[(@for='contentWarningAttachmentsUploadSign')]"; //кнопка Добавить подпись

    String addGroundsButton = "/html/body/div[1]/div/main/form/div[2]/div[3]/div/div/span/button"; //кнопка Добавить в блоке основания проведения профилактических мероприятий
    String choiceGroundDropDown = "//*[contains(@class,'select-field__placeholder ')]"; //выпадающий список Выберете основание проведения ПМ
    String officialButton ="/html/body/div/div/main/form/div[2]/div[5]/div/div/span/button"; //кнопка Добавить должностное лицо
    String officialField ="//*[@name='inspectorsErknm[0].fullName']"; //поле Введите ФИО должностного лица
    String officialPostDropDown="/html/body/div/div/main/form/div[2]/div[5]/div/ul/li/div/div[2]/div[1]/div/div[1]/div[1]"; // выпадающий список Выберете должность

    String numberPM = "//*[contains(@class, 'KnmHeader_Title_') and (contains(string(), 'ПМ 6') or contains(string(), 'ПМ 7'))]";

    String addInformationDirectionObjectionButton =""; //кнопка Добавить в разделе Сведения о направлении возражения на предостережение
    String addInformationResultPMButton="";// кнопка Добавить в разделе Сведения о результатах ПМ
    String resultPMField="";//поле результат ПМ


    /**
     * Заполнение выпадающего списка Контрольный (надзорный) орган
     */
    public void setNameKNOPMDropDown(String name) {
        $(By.xpath(nameKNOPMDropDown)).click(); //клик по списку КНО
        $(By.xpath("//*[text()='" + name + "']")).click(); //выбор конкретной КНО
    }

    /**
     * Заполнение выпадающего списка Вид контроля (надзора) и его номер
     */
    public void setKindControlAndNumberPMDropDown(String kind) {
        $(By.xpath(kindControlAndNumberPMDropDown)).click(); //клик по списку Вид контроля (надзора) и его номер
        $(By.xpath("//*[text()='" + kind + "']")).click(); //выбор конкретного Вида контроля
    }

    /**
     * Заполнение выпадающего списка Вид профилактического мероприятия
     */
    public void setKindPMDropDown(String kindPM) {
        $(By.xpath(kindPMDropDown)).click(); //клик по списку Вид профилактического мероприятия
        $(By.xpath("//*[text()='" + kindPM + "']")).click(); //выбор конкретного Вид профилактического мероприятия
    }

    /**
     * Заполнение поля Дата начала
     */
    public void setStartDate(Calendar date) {
        String dateStr = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        $(By.xpath(startDateField)).setValue(dateStr);
    }

    /**
     * Заполнение поля Дата окончания
     *
     * @param date
     */
    public void setStopDate(String date) {
        $(By.xpath(stopDateField)).shouldBe(Condition.appear).setValue(date);
    }

    /**
     * Заполнить поле ИНН, выбрать из появившегося окна
     */
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).click();
    }

    /**
     * Выбор Тип объекта
     */
    public void setTypeObjectField(String type) {
        $(By.xpath(typeObjectField)).click();
        clickToText(type);
    }

    /**
     * Выбор Вид объекта
     */
    public void setViewObjectField(String view) {

        $(By.xpath(viewObjectField)).click();
        clickToText(view);
    }

    /**
     * Выбор класса опасности
     */
    public void setClassDangerField(String classDanger) {
        $(By.xpath(classDangerField)).click();
        clickToText(classDanger);
    }

    /**
     * Заполнение поля Описание предостережения
     */
    public void setNoteWarningField(String note) {
        $(By.xpath(noteWarningField)).setValue(note);
    }

    /**
     * Нажать на кнопку Добавить у блока Содержание предостережение
     */
    public void clickAddContentWarningButton() {
        $(By.xpath(addNoteWarningButton)).click();
    }

    /**
     * Нажать на кнопку Добавить документ
     */
    public void clickAddDocumentButton() {
        $(By.xpath(addDocumentButton)).click();
    }

    /**
     * Нажать на кнопку Добавить подпись
     */
    public void clickAddSignatureButton() {
        $(By.xpath(addSignatureButton)).click();
    }

    /**
     * Получение номера ПМ
     */
    public String getNumberPM() {
        String number = $(By.xpath(numberPM)).getOwnText();
        return number;
    }

    /**
     * Нажатие кнопки Добавить в блоке основания проведения ПМ
     */
    public void clickAddGroundsButton() {
        $(By.xpath(addGroundsButton)).click();
    }

    /**
     * Заполнение выпадающего списка Выберете основание проведения ПМ
     */
    public void setGroundDropDown(String ground) {
        $(By.xpath(choiceGroundDropDown)).click(); //клик по списку
        clickToText(ground);
    }

    /**
     * Нажатие на кнопку Добавить должностное лицо
     */
    public void clickOfficialButton() {
        $(By.xpath(officialButton)).click();
    }

    /**
     * Заполнить поле ФИО должностного лица
     */
    public void setOfficialField(String name) {
        $(By.xpath(officialField)).setValue(name);
    }

    /**
     * Заполнение выпадающего списка Выберете должность
     */
    public void setOfficialPostDropDown(String post) {
        $(By.xpath(officialPostDropDown)).click(); //клик по списку
        clickToText(post);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение
     */
    public void clickAddInformationDirectionObjectionButton(){
        $(By.xpath(addInformationDirectionObjectionButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить в разделе Сведения о результатах ПМ
     */
    public void clickAddInformationResultPMButton(){
        $(By.xpath(addInformationResultPMButton)).click();
    }
/**
 * Заполнение поля результат ПМ
 */
public void setResultPMField(String result){
    $(By.xpath(resultPMField)).setValue(result);
}
}
