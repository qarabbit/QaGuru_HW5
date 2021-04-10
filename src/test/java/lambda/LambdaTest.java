package lambda;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY  = "qarabbit/QaGuru_HW5";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("sherova")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Lambda test")
    public void issueSearchTest() {
        step("Open Github", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Search for repo", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repo", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Go to Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Check title", (step) -> {
            step.parameter("Expected result", "MyIssue");

           $(By.id("issue_1_link")).shouldHave(text("MyIssue"));
        });
    }
}
