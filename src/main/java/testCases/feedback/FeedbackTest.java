package testCases.feedback;


import com.beust.jcommander.Parameter;
import org.checkerframework.common.value.qual.StringVal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testPages.FeedBackPage;

import java.util.stream.Stream;

public class FeedbackTest extends FeedBackPage {

    public FeedbackTest() throws Exception {
    }

    /**
     * Цель: Заполнение и отправка формы обратной связи
     *
     * @author Kirilenko P.A. 08.2022
     */
    @ParameterizedTest
    @MethodSource("types")
    @DisplayName("Заполнение и отправка формы обратной связи")
    //@Test(description = "Заполнение и отправка формы обратной связи")
    public void sendFeedBack(String type) throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoFeedBack();
        fillingFeedBack(fillingTextInputs, phoneNumber, email, type);
        closeInfoMessage();
    }


}
