package Github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl="https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void shouldFindSelenideAsRepository() {


        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        sleep(5000);
    }
}