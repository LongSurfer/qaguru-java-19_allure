package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.TestBase;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueStepTest extends TestBase {

    public static final String REPOSITORY = "egolikov/allure-reports-21";
    public static final String ISSUE = "Hello! This is test issue";
    @Test
    void issueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open github main page", () -> {
            open("");
        });

        step("Search repository " + REPOSITORY, () -> {
            $("[data-target=\"qbsearch-input.inputButtonText\"]").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Click on repository link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Click on Issues tab", () -> {
            $("#issues-tab").click();
        });

        step("Check issue " + ISSUE, () -> {
             $(withText(ISSUE)).should(exist);
        });

    }

    @Test
    void issueWebStepsTest() {
        WebStep steps = new WebStep();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.clickOnIssueTab();
        steps.checkIssue(ISSUE);
    }
}
