import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;
import io.undertow.util.Headers;
import io.undertow.util.Methods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static com.codeborne.selenide.Selenide.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Selenide tests")
class SelenideTests {
    private SelenideDriver driver;
    private Undertow server;

    @BeforeAll
    void setUpWebServer() {
        server = Undertow.builder()
                .addHttpListener(8081, "127.0.0.1")
                .setHandler(new RoutingHandler()
                        .add(Methods.GET, "/",
                                exchange -> {
                                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
                                    exchange.getResponseSender()
                                            .send("<!DOCTYPE html><html><head><title>example</title></head><body>Content</body></html>");
                                }))
                .build();
        server.start();
    }

    @AfterAll
    void tearDownWebServer() {
        server.stop();
    }

    @BeforeAll
    void setUpSelenide() {
        driver = new SelenideDriver(new SelenideConfig().headless(true));
        SelenideLogger.addListener("allure", new AllureSelenide().savePageSource(false));
    }

    @AfterAll
    void tearDownSelenide() {
        SelenideLogger.removeListener("allure");
    }

    @Test

    public void aviaTicketsUa() {
        open("https://avia.tickets.ua/");
        //select start point, end point, data
        homePage.homePageFun();
        //get offer list
        offerPage.getOfferList();

    }
}


