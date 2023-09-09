package guru.qa.tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStep {

    @Step("Open github main page")
    public void openMainPage() {
        open("");
    }
    @Step("Search repository {repo}")
    public void searchForRepository(String repo) {
        $("[data-target=\"qbsearch-input.inputButtonText\"]").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }
    @Step("Click on repository link {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Click on Issues tab")
    public void clickOnIssueTab() {
        $("#issues-tab").click();
    }
    @Step("Check issue {issue}")
    public void checkIssue(String issue) {
        $(withText(issue)).should(exist);
    }

}
