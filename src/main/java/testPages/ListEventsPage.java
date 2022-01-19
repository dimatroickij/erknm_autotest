package testPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListEventsPage extends Common {
//раздел Список КНМ

    public String dateStart = "11.01.2022";

    String numberKNM = "//*[contains(@class, 'KnmHeader_Title_') and (contains(string(), 'КНМ 0') or contains(string(), 'КНМ 7'))]";//объект для получения номера КНМ
//.//h3[starts-with(@class,'KnmHeader_Title_')]

    String nameKNODropDown = "//*[@id='knoOrganizationErknm']"; //выпадающий список Наименование органа контроля
    String kindControlAndNumberDropDown = "//*[@id='kindControl']/div"; //выпадающий список Вид контроля (надзора) и его номер
    String kindKNMDropDown = "//*[@id='kindKnm']/div/div[1]"; // выпадающий список Вид КНМ
    String characterKNMDropDown = "//*[@id='typeErknm']/div/div[1]"; // выпадающий список Характер КНМ
    String startKNMDate = "//*[@id='startDateBlock']/div[2]/div[1]/div/div/input"; //Дата начала КНМ
    String nameProsecutorDropDown = "//*[@id='prosecutorOrganizationErknm']/div/div[1]"; //Наименование прокуратуры
    String innField = "//*[@name='organizations[0].inn']"; //ИНН
    String innListField = "//*[@class='ant-select-item-option-content']"; //появившийся спискок ИНН

    String numberPlanField = "//*[@id='planId']"; //номер плана
    String durationDaysField = "//*[@name='durationDays']"; //срок проведения(дней)

    //поправить, если не работает
    // String addGroundsIncludePlanButton="//*[(@id='reasonsBlock') and contains(string(),'Добавить')]"; //Кнопка добавить в основания включения в план
    String addGroundsIncludePlanButton = "/html/body/div/div/main/form/div[2]/div[1]/div[18]/div[2]/span/button"; //Кнопка добавить в раздел Основания включения в план
    String groundsIncludePlanDropDown = "//*[@id='reasonsErknm[0].type']";//основания включения в план
    String GIP = "4.0.1 (ФЗ 248) Истечение установленного федеральным законом о виде контроля, положением о виде контроля период времени с даты окончания проведения последнего планового контрольного (надзорного) мероприятия";
    String dateGIPField = "/html/body/div/div/main/form/div[2]/div[1]/div[18]/ul/li/div/div[2]/div/div[1]/div/div/input";//дата основания включения в план

    String addObjectControlButton = "//*[@id='objectsBlock']/span/button";//кнопка Добавить в разделе Сведения об объектах контроля
    String adressField = "//*[@name='objectsErknm[0].addressText']";//поле Местонахождение
    String typeObjectDropDown = "//*[@id='objectsErknm[0].objectType']";//тип объекта
    String typeObject = "Деятельность и действия";
    String kindObjectDropDown = "//*[@id='objectsErknm[0].objectKind']";//вид объекта
    //String kingObject = "деятельность, действия (бездействие) Контролируемых лиц, в рамках которых должны соблюдаться обязательные требования, в том числе предъявляемые к Контролируемым лицам, осуществляющим деятельность, действия (бездействие)";
    String kingObject = "используемые контролируемыми лицами при осуществлении деятельности в сфере обращения лекарственных средств помещения, к которым предъявляются обязательные требования";
    String subkindObjectDropDown = "//*[@id='objectsErknm[0].objectSubKind']";//подвид объекта
    String dangerClassDropDown = "//*[@id='objectsErknm[0].dangerClass']";//класс опасности
    String dangerClass = "Первый";

    String addListActionsButton = "//*[@id='eventsBlock']/span/button";//кнопка Добавить в разделе Перечень действий
    String typeActionsDropDown = "//*[@id='eventsErknm[0].type']";//Выберете тип действия
    String typeActions ="Осмотр";
    String dateStartActions = "/html/body/div/div/main/form/div[2]/div[3]/div[8]/ul/li/div/div[2]/div/div[1]/div/div/input"; //Дата начала
    String dateEndActions = "/html/body/div/div/main/form/div[2]/div[3]/div[8]/ul/li/div/div[3]/div/div[1]/div/div/input"; //Дата окончания

    String addVenueButton = "/html/body/div/div/main/form/div[2]/div[4]/div[4]/div/span/button"; //Кнопка добавить в разделе Место (места) проведение КНМ
    String venueField = "//*[@name='places[0].value']";//поле для введения Места

    //public String actionButton = "//button[text()='Действия']";
    String actionButton = "/html/body/div/div/main/form/div[1]/div[1]/div[2]/button[2]"; // кнопка Действия
    String signButton = "/html/body/div/div/main/form/div[1]/div[1]/div[2]/div/div/div/ul/li[4]/span/button"; //кнопка Подписать в подменю Действия
    String signOnFormButton ="/html/body/div[2]/div/div[2]/div/div[2]/div/div/button"; //кнопка Подписать на форме подписание паспорта КНМ

    String dateTimePublicationDecisionField="/html/body/div/div/main/form/div[2]/div[1]/div[7]/div[2]/div/div[1]/div/div/input"; // поле Дата и время издания решения в разделе о проведении КНМ
    String solutionNumberField ="//*[@id='numberDecision']"; //поле Номер решения в разделе Решение о проведении КНМ
    String placeDecisionField="//*[@id='placeDecision']";// поле Место вынесения решения
    String nameOfficialField="//*[@id='fioSigner']";// поле ФИО должностного лица
    String positionPersonSignedDecisionsDropDown="//*[@id='titleSigner']";// поле Должность лица, подписавшего решение
    String durationEventHoursField="//*[@name='durationHours']";//поле срок проведения (часов)
    String addGroundConducting="/html/body/div/div/main/form/div[2]/div[1]/div[17]/div[2]/span/button";//нажатие на кнопку Добавить в разделе Основания проведения КНМ




    /**
     * Выбор из выпадающего списка Наименование органа контроля
     *
     * @param name
     */
    public void setNameKNODropDown(String name) {
        $(By.xpath(nameKNODropDown)).click(); // клик на выпадающем списке Наименование органа контроля
        clickToText(name); // клик на нужной организации
    }

    /**
     * Выбор из выпадающего списка Вид контроля
     *
     * @param kind
     */
    public void setKindControlAndNumberDropDown(String kind) {
        $(By.xpath(kindControlAndNumberDropDown)).click(); // клик на выпадающем списке Вид контроля
        clickToText(kind); // клик на нужном виде контроля
    }

    /**
     * Выбор из выпадающего списка Вид КНМ
     *
     * @param kind
     */
    public void setKindKNMDropDown(String kind) {
        $(By.xpath(kindKNMDropDown)).click(); // клик на выпадающем списке Вид КНМ
        clickToText(kind); // клик на нужном виде КНМ
    }

    /**
     * Выбор из выпадающего списка Характер КНМ
     *
     * @param kind
     */
    public void setCharacterKNMDropDown(String kind) {
        $(By.xpath(characterKNMDropDown)).click(); // клик на выпадающем списке Характер КНМ
        clickToText(kind); // клик на нужном характере КНМ
    }

    /**
     * Заполненеи поля Дата начала КНМ
     */
    public void setStartKNMDate(String date) {
        $(By.xpath(startKNMDate)).setValue(date); //заполнение поля
    }

    /**
     * Выбор из выпадающего списка Наименование прокуратуры
     *
     * @param name
     */
    public void setNameProsecutorDropDown(String name) {
        $(By.xpath(nameProsecutorDropDown)).click(); // клик на выпадающем списке Наименование прокуратуры
        clickToText(name); // клик на нужной прокуратуре
    }

    /**
     * Заполнить поле ИНН, выбрать из появившегося окна
     */
    public void setInnField(String INN) {
        $(By.xpath(innField)).setValue(INN);
        $(By.xpath(innListField)).click();
    }

    /**
     * Получение номера КНМ
     *
     */
    public String getNumberKNM() {
        String number = $(By.xpath(numberKNM)).getOwnText();
        System.out.println("НОМЕР КНМ - " +number);
        // TODO: Нужно ли обрезать буквенную часть номера ? поиск работает и с ним
      /*  numberKNM = numberKNM.substring(4);
        System.out.println("НОМЕР без - " +numberKNM);*/
        return number;
    }

    /**
     * Заполнение поля Номер плана
     *
     * @param number
     */
    public void setNumberPlanField(String number) {
        $(By.xpath(numberPlanField)).setValue(number);
    }

    /**
     * Заполнение поля Срок проведения(дней)
     */
    public void setDurationDaysField(String days) {
        $(By.xpath(durationDaysField)).setValue(days);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Основания включения в план
     */
    public void clickAddGroundsIncludePlanButton() {
        $(By.xpath(addGroundsIncludePlanButton)).click();
    }

    /**
     * Выбор основания регистрации КНМ
     */
    public void setGroundsIncludePlanDropDown() {
        $(By.xpath(groundsIncludePlanDropDown)).click();
        clickToText(GIP);
    }

    /**
     * Заполнение даты в разделе Основания включения в план
     */
    //TODO: Выбор текущей даты? или какой
    public void setDateGIPField(String date) {
        $(By.xpath(dateGIPField)).setValue(date);
    }

    /**
     * Нажатие на кнопке Добавить в разделе СВедения об объектах контроля
     */
    public void clickAddObjectControlButton() {
        $(By.xpath(addObjectControlButton)).click();
    }

    /**
     * Заполнение поля Местонахождение
     */
    public void setAdressField(String adress) {
        $(By.xpath(adressField)).setValue(adress);
    }

    /**
     * Выбор Типа объекта
     */
    public void setTypeObjectDropDown() {
        $(By.xpath(typeObjectDropDown)).click();
        clickToText(typeObject);
    }

    /**
     * Выбор Вида объекта
     */
    public void setKindObjectDropDown(){
        $(By.xpath(kindObjectDropDown)).click();
        clickToText(kingObject);
    }

    /**
     * Выбор Подвида объекта
     */
    public void setSubkindObjectDropDown(){
        $(By.xpath(subkindObjectDropDown)).click();
        clickToText(kingObject);
    }

    /**
     * Выбор Класса опасности
     */
    public void setdangerClassDropDown(){
        $(By.xpath(dangerClassDropDown)).click();
        clickToText(dangerClass);
    }

    /**
     * Нажатие на кнопку Добавить в разделе Перечень действий, осуществляемый в рамках КНМ
     */
    public void clickAddListActionsButton(){
        $(By.xpath(addListActionsButton)).click();
    }

    /**
     * Выберете Тип действия в разделе Перечень действий
     */
    public void setTypeActionsDropDown(){
        $(By.xpath(typeActionsDropDown)).click();
        clickToText(typeActions);
    }

    /**
     * Заполнение Дата начала в Перечне действий
     */
    public void setDateStartActions(String date){
        $(By.xpath(dateStartActions)).setValue(date);
    }

    /**
     * Заполнение Дата окончания в Перечне действий
     */
    public void setDateEndActions(String date){
        $(By.xpath(dateEndActions)).setValue(date);
    }

    /**
     * Нажать кнопку Добавить в разделе Место (места) проведения КНМ
     */
    public void clickAddVenueButton(){
        $(By.xpath(addVenueButton)).click();
    }

    /**
     * Заполнение поля Введите место
     */
    public void setVenueField(String venue){
        $(By.xpath(venueField)).setValue(venue);
    }

    /**
     * Нажатие на кнопку Действия
     */
    public void clickActionsButton(){
        $(By.xpath(actionButton)).click();
    }

    /**
     * Нажатие на кнопку Подписать в подменю Действие
     */
    public void clickSignButton(){
        $(By.xpath(signButton)).click();
    }

    /**
     * Нажатие на кнопку Подписать на форме Подписание паспорта КНМ
     */
    public void clickSigOnFormButton(){
        $(By.xpath(signOnFormButton)).click();
    }
}