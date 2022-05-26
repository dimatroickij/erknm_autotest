package testPages;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ImportExportPage extends Common{

    //Кнопка Загрузить  = унопка добавить из комон
    String typeFileDropDown = "//*[@id='fileType']"; // выпадающий список Тип загружаемого файла
    String knoOrganizationDropDown = "//*[@id='knoOrganization']"; // выпадающий список Орган контроля
    String prosecutorOrganizationDropDown = "//*[@id='prosecutorOrganization']"; // выпадающий список Наименование прокуратуры

    String selectFileButton = "//*[@id='selectFileButton']"; //кнопка Выберете файл на форме загрузки


    public ImportExportPage() throws Exception {
    }
}
