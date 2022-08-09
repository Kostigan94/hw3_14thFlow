package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {


    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void shouldFindSelenideAsRepository() {


        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("#wiki-tab").click();
        //Assertion
        $("#wiki-body").shouldHave(text("Soft assertions"));

        $("#wiki-body").$(byText("Soft assertions")).click();
        // Second Assertion
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

        }
}