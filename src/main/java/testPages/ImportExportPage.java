package testPages;

public class ImportExportPage extends Common {

    //Кнопка Загрузить  = унопка добавить из комон
    String typeFileDropDown = "//*[@id='fileType']"; // выпадающий список Тип загружаемого файла
    String knoOrganizationDropDown = "//*[@id='knoOrganization']"; // выпадающий список Орган контроля
    String prosecutorOrganizationDropDown = "//*[@id='prosecutorOrganization']"; // выпадающий список Наименование прокуратуры

    String selectFileButton = "//*[@id='selectFileButton']"; //кнопка Выберите файл на форме загрузки


    public ImportExportPage() throws Exception {
    }
}
