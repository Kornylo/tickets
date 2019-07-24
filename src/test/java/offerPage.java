import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.undertow.Undertow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import retrofit2.Call;

import java.io.IOException;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class offerPage {


    static void getOfferList() {
        $("#offers_table > section").shouldBe(exist);
        ElementsCollection colection = $$("#offers_table > section");
        for (int i = 0; i < colection.size(); i++) {
            System.out.println($$("div.ac_name.there").get(i).getText());
            System.out.println($$("li.flight-maininfo__tittle").get(i).getText());
            System.out.println($$("strong.UAH").get(i).getText());
            System.out.println("---------------------------");
        }
    }
}
