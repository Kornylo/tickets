import io.qameta.allure.okhttp3.AllureOkHttp3;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;
import io.undertow.util.Headers;
import io.undertow.util.Methods;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
class homePage {
    static void homePageFun() {
        $("a.ipc_city").click();
        $(".js-end-point > div > a:nth-child(2)").click();
        $("#departure_date").click();
        $("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-last > div > a").doubleClick();
        $(".ui-datepicker-week-end.day_td > a").click();
        $("input#departure_date_1").click();
        $("#ui-datepicker-div > div.btn-wrap > a").click();
        $("input.search_button").click();
        switchTo().window("Дешевые авиабилеты онлайн: купить авиабилеты на Tickets.ua / Tickets.ua");
    }
}
