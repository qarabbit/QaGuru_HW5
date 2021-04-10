package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
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
    @DisplayName("Selenide test")
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(By.id("issue_1_link")).shouldHave(text("MyIssue"));
    }
}
