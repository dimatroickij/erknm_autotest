package testPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListEventsERPPage extends Common {
    //Список проверок

    String viewKNMDropDown = "/html/body/div/div/main/form/div[2]/div[1]/div[1]/div[2]/div"; //выпадающий список Вид КНМ
    String formKMNDropDown = "/html/body/div/div/main/form/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]"; //Выпадающий список Форма КНМ
    String exitForm = "Выездная";
    String documentaryForm = "Документарная";
    String exitAndDocumentaryForm = "Документарная и выездная";
    String typeSubjectDropDown = "/html/body/div/div/main/form/div[2]/div[1]/div[3]/div[2]/div[1]/div/div[1]"; //выпадающий список Тип субъекта КНМ
    String typeUlIp = "ЮЛ/ИП";
    String numberOrdersField = "//*[@name='orderNumber']"; //поле Номер приказа
    //String dateOrdersField = "/html/body/div/div/main/form/div[2]/div[2]/div[3]/div[2]/div[1]/div/div/input"; // поле Дата приказа
    String dateOrdersField = "//*[@id='orderDateBlock']/div[2]/div[1]/div/div/input"; // поле Дата приказа
   // String dateStartKNMField = "/html/body/div/div/main/form/div[2]/div[2]/div[5]/div[2]/div[1]/div/div/input"; //поле Дата начала КНМ
    String dateStartKNMField = "//*[@id='startDateBlock']/div[2]/div[1]/div/div/input"; //поле Дата начала КНМ
   //String dateStopKNMField = "/html/body/div/div/main/form/div[2]/div[2]/div[6]/div[2]/div[1]/div/div/input"; //поле Дата окончания КНМ
   String dateStopKNMField = "//*[@id='stopDateBlock']/div[2]/div[1]/div/div/input"; //поле Дата окончания КНМ

    String addLegalGroundsConductingButton = "//*[@id='legalBasesTitle']/span/button"; //кнопка Добавить в разделе Правовые основания проведения КНМ
    String absenceDirectoryRadioButton = "//*[@id='legalBasesNotExist']"; //радиобатон Отсутствует в справочнике
    String goalsTasksSubjectField ="//*[@id='check-sheets']/div[3]/textarea"; // текстовое поле Цели, задачи, предмет КНМ
    String durationEventDaysField = "//*[@id='durationDays']"; //поле Срок проведения (дней)
    String durationEventHoursField ="//*[@id='durationHours']";//поле Срок проведения (часов)

    String addListControlMeasuresButton ="//*[@id='eventsBlock']/div/span/button"; //кнопка Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param view
     */
    public void setViewKNMDropDown(String view) {
        $(By.xpath(viewKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        clickToText(view); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка форма КНМ
     *
     * @param form
     */
    public void setFormKMNDropDown(String form) {
        $(By.xpath(formKMNDropDown)).click(); // клик на выпадающем списке форма КНМ
        clickToText(form); // клик на нужной форме КНМ
    }

    /**
     * Выбор из выпадающего списка тип субъекта КНМ
     *
     * @param type
     */
    public void setTypeSubjectDropDown(String type) {
        $(By.xpath(typeSubjectDropDown)).click(); // клик на выпадающем списке тип субъекта КНМ
        clickToText(type); // клик на нужном типе субъекта КНМ
    }

    /**
     * Заполнение поля Номер приказа
     *
     * @param number
     */
    public void setNumberOrdersField(String number) {
        $(By.xpath(numberOrdersField)).setValue(number);
    }

    /**
     * Заполнение поля Дата приказа
     *
     * @param date
     */
    public void setDateOrdersField(String date) {
        $(By.xpath(dateOrdersField)).setValue(date);
    }

    /**
     * Заполнение поля Дата начала КНМ
     *
     * @param date
     */
    public void setDateStartKNMField(String date) {
        $(By.xpath(dateStartKNMField)).setValue(date);
    }

    /**
     * Заполнение поля Дата окончания КНМ
     *
     * @param date
     */
    public void setDateStopKNMField(String date) {
        $(By.xpath(dateStopKNMField)).setValue(date);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Правовые основания проведения КНМ
     */
    public void clickAddLegalGroundsConductingButton() {
        $(By.xpath(addLegalGroundsConductingButton)).click();
    }

    /**
     * Нажатие на радиобатон Отсутствует в справочнике
     */
    public void clickAbsenceDirectoryRadioButton() {
        $(By.xpath(absenceDirectoryRadioButton)).click();
    }

    /**
     * Заполнение поля Цели, задачи, предмет КНМ
     * @param text
     */
    public void setGoalsTasksSubjectField(String text) {
        $(By.xpath(goalsTasksSubjectField)).setValue(text);
    }

    /**
     * Заполнение поля Срок проведения (дней)
     * @param days
     */
    public void setDurationEventDaysField(String days) {
        $(By.xpath(durationEventDaysField)).setValue(days);
    }

    /**
     * Заполнение поля Срок проведения (часов)
     * @param hours
     */
    public void setDurationEventHoursField(String hours) {
        $(By.xpath(durationEventHoursField)).setValue(hours);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Перечень мероприятий по контролю, необходимых для достижения целей и задач проведения КНМ
     */
    public void clickAddListControlMeasuresButton() {
        $(By.xpath(addListControlMeasuresButton)).click();
    }

}