package testPages;

import io.qameta.allure.Step;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;

import java.io.File;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FeedBackPage extends Common {

    String lastNameInput = "//input[@name='lastName']"; // имя
    String firstNameInput = "//input[@name='firstName']"; // фамилия
    String patronymicInput = "//input[@name='patronymic']";  // отчество
    String phoneInput = "//input[@name='phone']";  // номер телефона
    String emailInput = "//input[@name='email']";  // электронная почта
    String typeOfApplicant = "//div[@class=\"SelectInput_ValueContainer__XYBPc SelectInput_ValueContainerSingle__3Uia9 " +
            "select-field__value-container css-0\"]";  // селектор выбора типа заявителя
    String organizationNameInput = "//input[@name='organizationName']";  // наименование организации
    String topicInput = "//input[@name='topic']";  // тема обращения
    String textArea = "//textarea[@name='text']";  // описание
    String agreementCheckBox = "//input[@name='agreement']";  // чекбокс согласия на обработку персональных данных
    String addDocumentButton = "//input[@name='load']";  // кнопка добавления документов/вложений
    String submitButton = "//button[@type='submit']";  // кнопка отправить
    public static String typeKO = "Контролирующий орган"; // Контролирующий орган
    public static String typeOP = "Орган прокуратуры"; // Орган прокуратуры
    String closeInfoMessageButton = "//button[@class='Notification_CloseButton__2qh4j']"; // кнопка закрытия сообщения об успешной отправке

    public FeedBackPage() throws Exception {
    }

    /**
     * Заполнение и отправка формы обратной связи
     *
     * @param name заполнение тектовых инпутов
     * @param phone номер телефона
     * @param email электронная почта
     * @param type тип заявителя
     */
    @Step("Заполнение и отправка формы обратной связи")
    public void fillingFeedBack(String name, String phone, String email,  String type) {
        $(By.xpath(lastNameInput)).setValue(name);
        $(By.xpath(firstNameInput)).setValue(name);
        $(By.xpath(patronymicInput)).setValue(name);
        $(By.xpath(phoneInput)).setValue(phone);
        $(By.xpath(emailInput)).setValue(email);
        $(By.xpath(typeOfApplicant)).click(); // нажатие на селектор выбора типа заявителя
        setValueDropDownToText(type);   // выбор типа заявителя
        $(By.xpath(organizationNameInput)).setValue(name);
        $(By.xpath(topicInput)).setValue(name);
        $(By.xpath(textArea)).setValue(name);
        $(By.xpath(agreementCheckBox)).click();  // активация чекбокса согласия на обработку персональных данных
        addDocumentFeedBack(filePath);  // загрузка документа/вложения
        $(By.xpath(submitButton)).click();
    }

    /**
     * Загрузка документа в форму обратной связи
     *
     * @param fPath Путь к файлу
     */
    @Step("Загрузка документа в форму обратной связи")
    public void addDocumentFeedBack(String fPath) {
        $(By.xpath(addDocumentButton)).uploadFile(new File(fPath));
    }

    @Step("Ожидание появления и закрытия сообщения об успешной отправке")
    public void closeInfoMessage() {
        $(By.xpath(closeInfoMessageButton)).should(visible).click();
    }

    // отдает параметры для выбора типа заявителя в тесте
    private static Stream<Arguments> types() {
        return Stream.of(
                Arguments.of(typeKO),
                Arguments.of(typeOP)
        );
    }
}
