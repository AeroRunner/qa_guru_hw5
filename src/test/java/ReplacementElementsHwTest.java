import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ReplacementElementsHwTest {

    @BeforeAll
   static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl ="https://the-internet.herokuapp.com";
                      }
    @Test
    void AactionB() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200,0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

                    }
    @Test
    void AdragAndDroptoB() {
        open("/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
                           }

}
