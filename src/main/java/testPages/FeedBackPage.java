package testPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedBackPage extends Common {

    String lastNameInput = "//input[@name='lastName']";
    String firstNameInput = "//input[@name='firstName']";
    String patronymicInput = "//input[@name='patronymic']";
    String phoneInput = "//input[@name='phone']";
    String emailInput = "//input[@name='email']";

    String organizationNameInput = "//input[@name='organizationName']";
    String topicInput = "//input[@name='topic']";
    String textArea = "//textarea[@name='text']";
    String agreementCheckBox = "//input[@name='agreement']";
    String submitButton = "//buttom[@type='submit']";

    public FeedBackPage() throws Exception {
    }

    @Step("Заполнение о отправка формы обратной связи")
    public void fillingFeedBack() {
        $(By.xpath(lastNameInput)).setValue("qwerty");
        $(By.xpath(submitButton)).click();
    }
}
