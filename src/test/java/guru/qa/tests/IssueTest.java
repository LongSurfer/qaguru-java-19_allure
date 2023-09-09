package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.TestBase;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTest extends TestBase {
    @Test
    void issueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $("[data-target=\"qbsearch-input.inputButtonText\"]").click();
        $("#query-builder-test").setValue("egolikov/allure-reports-21").pressEnter();

        $(linkText("egolikov/allure-reports-21")).click();
        $("#issues-tab").click();
        $(withText("Hello! This is test issue")).should(exist);
    }
}
