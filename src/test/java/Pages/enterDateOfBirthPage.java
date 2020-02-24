package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class enterDateOfBirthPage extends PageObject {


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[1]")
    private WebElement dateOfBorn;


    public enterDateOfBirthPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfValidationBornDatePageIsDisplayed() {

        assertThat(dateOfBorn.isDisplayed()).isTrue();
    }

}

