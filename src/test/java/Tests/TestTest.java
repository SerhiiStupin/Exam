package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTest {

    @Test(description = "test test")
    @Story("Checking the URL")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("google.com")
    public void test(){
        open("https://www.google.com");
        assertThat(url()).isEqualTo("https://www.google.com/");
    }
}
