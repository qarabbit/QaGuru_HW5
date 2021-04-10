package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    private final String BASE_URL = "https://github.com";

    @Step("Open main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search for repo {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Go to {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Go to Issues")
    public void clickOnIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Check title")
    public void shouldSeeTitle() {
        $(By.id("issue_1_link")).shouldHave(text("MyIssue"));
    }
}
