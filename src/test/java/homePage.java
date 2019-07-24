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
        switchTo().window(1);
    }
}
