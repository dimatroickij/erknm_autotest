package testPages;

import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
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

    String addObjectControlPMButton = "//*[@id='pmObjectsAddButton']";//кнопка Добавить в разделе Сведения об объектах контроля в карточке ПМ
    String typeObjectDropDown = "//*[(@id='objectsPm[0].objectType')]"; // выбор типа объекта
    String viewObjectDropDown = "//*[(@id='objectsPm[0].objectKind')]"; // выбор вида объекта
    String classDangerDropDown = "//*[(@id='objectsPm[0].dangerClass')]"; // выбор класса опасности
    String noteWarningField = "//*[(@id='noteWarning')]"; //поле Описание предостережения
    String addNoteWarningButton = "//*[@id='pmContentWarningAddButton']"; //кнопка Добавить у блока Содержание предостережения
    String addDocumentButton = "//*[(@for='contentWarningAttachmentsUploadDocument')]"; //кнопка Добавить документ
    String addSignatureButton = "//*[(@for='contentWarningAttachmentsUploadSign')]"; //кнопка Добавить подпись

    String addGroundsPMButton = "//*[@id='pmReasonsAddButton']"; //кнопка Добавить в блоке основания проведения профилактических мероприятий

    String choiceGroundDropDown = "//*[contains(@class,'select-field__placeholder ')]"; //выпадающий список Выберете основание проведения ПМ
    String addOfficialPMButton = "//*[@id='erknmInspectorsAddButton']"; //кнопка Добавить должностное лицо
    String officialField = "//*[@name='inspectorsErknm[0].fullName']"; //поле Введите ФИО должностного лица
    String officialPostPMDropDown = "//*[@id='inspectorsErknm[0].position']"; // выпадающий список Выберете должность в ПМ

    String numberPM = "//*[contains(@class, 'KnmHeader_Title_') and (contains(string(), 'ПМ 6') or contains(string(), 'ПМ 7'))]";

    String documentNoteWarningInput = "//input[@id='contentWarningAttachmentsUploadDocument']"; // input для добавления документа в содержание предостережения
    String signatureNoteWarningInput = "//input[@id='contentWarningAttachmentsUploadSign']"; // input для добавления подписи в содержание предостережения


    String addInformationDirectionObjectionButton = "//*[@id='pmObjectionWarningAddButton']"; //кнопка Добавить в разделе Сведения о направлении возражения на предостережение
    String resultPMField = "//*[@id='resultOfInspection']";//поле результат ПМ

    String documentInformationDirectionObjectionInput = "//input[@id='objectionWarningAttachmentsUploadDocument']"; // input для добавления документа в сведения о направлении возражения на предостережение
    String signatureInformationDirectionObjectionInput = "//input[@id='objectionWarningAttachmentsUploadSign']"; // input для добавления подписи в сведения о направлении возражения на предостережение

    String closeButton = "//*[@id='confirmButton']"; //кнопка Закрыть на предупреждении

    public ListPreventionEventsPage() throws Exception {
    }

    /**
     * Заполнение выпадающего списка Контрольный (надзорный) орган
     *
     * @param name
     */
    @Step("Заполнение выпадающего списка Контрольный (надзорный) орган - {name}")
    public void setNameKNOPMDropDown(String name) {
        $(By.xpath(nameKNOPMDropDown)).click(); //клик по списку КНО
        $(By.xpath("//*[text()='" + name + "']")).click(); //выбор конкретной КНО
    }

    /**
     * Заполнение выпадающего списка Вид контроля (надзора) и его номер
     *
     * @param kind
     */
    @Step("Заполнение выпадающего списка Вид контроля (надзора) и его номер - {kind}")
    public void setKindControlAndNumberPMDropDown(String kind) {
        $(By.xpath(kindControlAndNumberPMDropDown)).click(); //клик по списку Вид контроля (надзора) и его номер
        $(By.xpath("//*[text()='" + kind + "']")).click(); //выбор конкретного Вида контроля
    }

    /**
     * Заполнение выпадающего списка Вид профилактического мероприятия
     *
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
     *
     * @param INN
     */
    @Step("Заполнить поле ИНН, выбрать из появившегося окна - {INN}")
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).click();
    }

    /**
     * Выбор Тип объекта
     *
     * @param type
     */
    @Step("Выбор Тип объекта - {type}")
    public void setTypeObjectDropDown(String type) {
        $(By.xpath(typeObjectDropDown)).click();
        clickToText(type);
    }

    /**
     * Выбор Вид объекта
     *
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
    public void clickAddGroundsPMButton() {
        $(By.xpath(addGroundsPMButton)).click();
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
    public void clickOfficialPMButton() {
        $(By.xpath(addOfficialPMButton)).click();
    }

    /**
     * Заполнить поле ФИО должностного лица
     */
    @Step("Заполнить поле ФИО должностного лица -{name}")
    public void setOfficialField(String name) {
        $(By.xpath(officialField)).setValue(name);
    }

    /**
     * Заполнение выпадающего списка Выберете должность для объявления предостережения
     */
    @Step("Заполнение выпадающего списка Выберете должность для объявления предостережения - {post}")
    public void setOfficialPostPMDropDown(String post) {
        $(By.xpath(officialPostPMDropDown)).click(); //клик по списку
        clickToText(post);
    }


    /**
     * Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение
     */
    @Step("Нажатие на кнопку Добавить в разделе Сведения о направлении возражения на предостережение")
    public void clickAddInformationDirectionObjectionButton() {
        $(By.xpath(addInformationDirectionObjectionButton)).shouldHave(text("Добавить")).click();
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
     *
     * @param type        тип объекта
     * @param view        вид объекта
     * @param classDanger класс опасности
     */
    @Step("Заполненение блока Объект")
    public void addObjectData(String type, String view, String classDanger) {
        setTypeObjectDropDown(type);
        setViewObjectDropDown(view);
        setClassDangerDropDown(classDanger);
    }

    /**
     * Добавление основания проведения ПМ
     */
    @Step("Добавление основания проведения ПМ - {grounds}")
    public void addGroundsPM(String grounds) {
        clickAddGroundsPMButton();
        setGroundDropDown(grounds);
    }

    /**
     * Добавление должностного лица для ПМ
     */
    @Step("Добавление должностного лица для ПМ - {name}, {post}")
    public void addOfficialPM(String name, String post) {
        clickOfficialPMButton();
        setOfficialField(name);
        setOfficialPostPMDropDown(post);
    }

    /**
     * Добавление ПМ
     *
     * @param name        Название контрольного (надзорного) органа
     * @param view        Вид контроля (надзора) и его номер
     * @param typePM      Вид ПМ
     * @param date        Дата начала
     * @param inn         ИНН
     * @param typeObject  тип объекта
     * @param viewObject  вид объекта
     * @param classDanger класс опасности
     */
    @Step("Добавление ПМ")
    public void addPreventionEvent(String name, String view, String typePM, String date, String inn, String typeObject, String viewObject, String classDanger) {
        clickAddButton();
        setNameKNOPMDropDown(name);
        setKindControlAndNumberPMDropDown(view);
        setKindPMDropDown(typePM);
        setStartDate(date);
        setInnField(inn);
        addObjectData(typeObject, viewObject, classDanger);
        clickSaveButton();
    }

    /**
     * Добавление документа и подписи в Содержаение предостережения
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление документа и подписи в Содержаение предостережения")
    public void addDocumentAndSignatureNoteWarning(String fPath, String sPath) {
        $(By.xpath(documentNoteWarningInput)).uploadFile(new File(fPath));
        $(By.xpath(signatureNoteWarningInput)).uploadFile(new File(sPath));
    }

    /**
     * Добавление документа и подписи в Сведения о направлении возражения на предостережение
     *
     * @param fPath путь к документу
     * @param sPath путь к подписи
     */
    @Step("Добавление документа и подписи в Сведения о направлении возражения на предостережение")
    public void addDocumentAndSignatureInformationDirectionObjection(String fPath, String sPath) {
        $(By.xpath(documentInformationDirectionObjectionInput)).uploadFile(new File(fPath));
        $(By.xpath(signatureInformationDirectionObjectionInput)).uploadFile(new File(sPath));
    }

    /**
     * Нажатие на кнопку Добавить в разделе Сведения об объектах контроля в карточке ПМ
     */
    @Step("Нажатие на кнопку Добавить в разделе Сведения об объектах контроля в карточке ПМ")
    public void clickAddObjectControlPMButton() {
        $(By.xpath(addObjectControlPMButton)).click();
    }

    /**
     * Кнопка Закрыть на форме с предупреждением
     */
    @Step("Кнопка Закрыть на форме с предупреждением")
    public void clickCloseMessagePMButton() {
        $(By.xpath(closeButton)).click();
    }
}
