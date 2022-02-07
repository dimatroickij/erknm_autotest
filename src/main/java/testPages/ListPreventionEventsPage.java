package testPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;
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
    String typeObjectDropDown = "//*[(@id='objectsPm[0].objectType')]"; // выбор типа объекта
    String viewObjectDropDown = "//*[(@id='objectsPm[0].objectKind')]"; // выбор вида объекта
    String classDangerDropDown = "//*[(@id='objectsPm[0].dangerClass')]"; // выбор класса опасности
    String noteWarningField = "//*[(@id='noteWarning')]"; //поле Описание предостережения
    String addNoteWarningButton = "/html/body/div/div/main/form/div[2]/div[2]/div[2]/div/span/button"; //кнопка Добавить у блока Содержание предостережения
    String addDocumentButton = "//*[(@for='contentWarningAttachmentsUploadDocument')]"; //кнопка Добавить документ
    String addSignatureButton = "//*[(@for='contentWarningAttachmentsUploadSign')]"; //кнопка Добавить подпись

    String addGroundsButton = "/html/body/div[1]/div/main/form/div[2]/div[3]/div/div/span/button"; //кнопка Добавить в блоке основания проведения профилактических мероприятий
    String choiceGroundDropDown = "//*[contains(@class,'select-field__placeholder ')]"; //выпадающий список Выберете основание проведения ПМ
    String officialButton = "/html/body/div/div/main/form/div[2]/div[5]/div/div/span/button"; //кнопка Добавить должностное лицо
    String officialField = "//*[@name='inspectorsErknm[0].fullName']"; //поле Введите ФИО должностного лица
    String officialPostDropDown = "/html/body/div/div/main/form/div[2]/div[5]/div/ul/li/div/div[2]/div[1]/div/div[1]/div[1]"; // выпадающий список Выберете должность

    String numberPM = "//*[contains(@class, 'KnmHeader_Title_') and (contains(string(), 'ПМ 6') or contains(string(), 'ПМ 7'))]";

    String addInformationDirectionObjectionButton = ""; //кнопка Добавить в разделе Сведения о направлении возражения на предостережение
    String addInformationResultPMButton = "";// кнопка Добавить в разделе Сведения о результатах ПМ
    String resultPMField = "";//поле результат ПМ


    /**
     * Заполнение выпадающего списка Контрольный (надзорный) орган
     * @param name
     */
    @Step("Заполнение выпадающего списка Контрольный (надзорный) орган - {name}")
    public void setNameKNOPMDropDown(String name) {
        $(By.xpath(nameKNOPMDropDown)).click(); //клик по списку КНО
        $(By.xpath("//*[text()='" + name + "']")).click(); //выбор конкретной КНО
    }

    /**
     * Заполнение выпадающего списка Вид контроля (надзора) и его номер
     * @param kind
     */
    @Step("Заполнение выпадающего списка Вид контроля (надзора) и его номер - {kind}")
    public void setKindControlAndNumberPMDropDown(String kind) {
        $(By.xpath(kindControlAndNumberPMDropDown)).click(); //клик по списку Вид контроля (надзора) и его номер
        $(By.xpath("//*[text()='" + kind + "']")).click(); //выбор конкретного Вида контроля
    }

    /**
     * Заполнение выпадающего списка Вид профилактического мероприятия
     * @param kindPM
     */
    @Step("Заполнение выпадающего списка Вид профилактического мероприятия - {kindPM}")
    public void setKindPMDropDown(String kindPM) {
        $(By.xpath(kindPMDropDown)).click(); //клик по списку Вид профилактического мероприятия
        $(By.xpath("//*[text()='" + kindPM + "']")).click(); //выбор конкретного Вид профилактического мероприятия
    }

    /**
     * Заполнение поля Дата начала
     */
    @Step("Заполнение поля Дата начала - {date}")
    public void setStartDate(String date) {
        $(By.xpath(startDateField)).setValue(date);
    }

    /**
     * Заполнение поля Дата окончания
     */
    @Step("Заполнение поля Дата окончания - {date}")
    public void setStopDate(String date) {
        $(By.xpath(stopDateField)).setValue(date);
    }

    /**
     * Заполнить поле ИНН, выбрать из появившегося окна
     * @param INN
     */
    @Step("Заполнить поле ИНН, выбрать из появившегося окна - {INN}")
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).click();
    }

    /**
     * Выбор Тип объекта
     * @param type
     */
    @Step("Выбор Тип объекта - {type}")
    public void setTypeObjectDropDown(String type) {
        $(By.xpath(typeObjectDropDown)).click();
        clickToText(type);
    }

    /**
     * Выбор Вид объекта
     * @param view
     */
    @Step("Выбор Вид объекта - {view}")
    public void setViewObjectDropDown(String view) {
        $(By.xpath(viewObjectDropDown)).click();
        clickToText(view);
    }

    /**
     * Выбор класса опасности
     */
    @Step("Выбор класса опасности - {classDanger}")
    public void setClassDangerDropDown(String classDanger) {
        $(By.xpath(classDangerDropDown)).click();
        clickToText(classDanger);
    }

    /**
     * Заполнение поля Описание предостережения
     */
    @Step("Заполнение поля Описание предостережения")
    public void setNoteWarningField(String note) {
        $(By.xpath(noteWarningField)).setValue(note);
    }

    /**
     * Нажатие на кнопку Добавить у блока Содержание предостережение
     */
    @Step("Нажатие на кнопку Добавить у блока Содержание предостережение")
    public void clickAddContentWarningButton() {
        $(By.xpath(addNoteWarningButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить документ
     */
    @Step("Нажатие на кнопку Добавить документ")
    public void clickAddDocumentButton() {
        $(By.xpath(addDocumentButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить подпись
     */
    @Step("Нажатие на кнопку Добавить подпись")
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
     * Нажатие на кнопку Добавить в блоке основания проведения ПМ
     */
    @Step("Нажатие на кнопку Добавить в блоке основания проведения ПМ")
    public void clickAddGroundsButton() {
        $(By.xpath(addGroundsButton)).click();
    }

    /**
     * Заполнение выпадающего списка Выберете основание проведения ПМ
     */
    @Step("Заполнение выпадающего списка Выберете основание проведения ПМ - {ground}")
    public void setGroundDropDown(String ground) {
        $(By.xpath(choiceGroundDropDown)).click(); //клик по списку
        clickToText(ground);
    }

    /**
     * Нажатие на кнопку Добавить должностное лицо
     */
    @Step("Нажатие на кнопку Добавить должностное лицо")
    public void clickOfficialButton() {
        $(By.xpath(officialButton)).click();
    }

    /**
     * Заполнить поле ФИО должностного лица
     */
    @Step("Заполнить поле ФИО должностного лица -{name}")
    public void setOfficialField(String name) {
        $(By.xpath(officialField)).setValue(name);
    }

    /**
     * Заполнение выпадающего списка Выберете должность
     */
    @Step("Заполнение выпадающего списка Выберете должность - {post}")
    public void setOfficialPostDropDown(String post) {
        $(By.xpath(officialPostDropDown)).click(); //клик по списку
        clickToText(post);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение
     */
    @Step("Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение")
    public void clickAddInformationDirectionObjectionButton() {
        $(By.xpath(addInformationDirectionObjectionButton)).click();
    }

    /**
     * Нажатие на кнопку Добавить в разделе Сведения о результатах ПМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Сведения о результатах ПМ")
    public void clickAddInformationResultPMButton() {
        $(By.xpath(addInformationResultPMButton)).click();
    }

    /**
     * Заполнение поля результат ПМ
     */
    @Step("Заполнение поля результат ПМ - {result}")
    public void setResultPMField(String result) {
        $(By.xpath(resultPMField)).setValue(result);
    }

    /**
     * Заполненение блока Объект
     */
    @Step("Заполненение блока Объект")
    public void addObjectData(String type, String view, String classDanger) {
        setTypeObjectDropDown(type);
        setViewObjectDropDown(view);
        setClassDangerDropDown(classDanger);
    }

    /**
     * Добавление документа к ПМ
     */
    @Step("Добавление документа к ПМ")
    public void addDocument() throws IOException {
        clickAddContentWarningButton();
        clickAddDocumentButton();
        Runtime.getRuntime().exec(scriptAddDocument);
        clickAddSignatureButton();
        Runtime.getRuntime().exec(scriptAddSignature);
        clickUploadButton();
    }

    /**
     * Добавление основания проведения ПМ
     */
    @Step("Добавление основания проведения ПМ - {grounds}")
    public void addGrounds(String grounds){
        clickAddGroundsButton();
        setGroundDropDown(grounds);
    }

    /**
     * Добавление должностного лица
     */
    @Step("Добавление должностного лица - {name}, {post}")
    public void addOfficial(String name, String post){
        clickOfficialButton();
        setOfficialField(name);
        setOfficialPostDropDown(post);
        clickSaveButton();
    }
}
