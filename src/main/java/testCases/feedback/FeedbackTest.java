package testCases.feedback;


import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import testPages.Common;
import testPages.FeedBackPage;



public class FeedbackTest extends FeedBackPage {

    public FeedbackTest() throws Exception {
    }

    @Test(description = "Заполнение и отправка формы обратной связи")
    public void sendFeedBack() throws Exception {
        authorization("supervisor");
        choiceMode(true);
        gotoFeedBack();
        fillingFeedBack();
    }
}
