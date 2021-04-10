package steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class AnnotatedTest {

    private final static String REPOSITORY = "qarabbit/QaGuru_HW5";
    private WebTest steps = new WebTest();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Owner("sherova")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Steps test")
    public void issueSearchTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeTitle();
    }
}
