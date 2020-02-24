package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class landingPage extends PageObject {

    @FindBy(xpath = "//*[@id='root']/div/div[3]/div/div[2]/div/div/form/div[1]/button[2]")
    private WebElement precondition;
    @FindBy(name = "inceptionDate")
    private WebElement inceptionDate;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button/span")
    private WebElement nextButton;

    public landingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public landingPage selectPreCondition() {
        precondition.click();
        return this;
    }

    public landingPage enterInceptionDate(String date) {
        inceptionDate.sendKeys(date);
        return this;
    }

    public carOwnerShipPage clickNextButton() {
        nextButton.click();
        return new carOwnerShipPage(this.webDriver);
    }

    public landingPage clearDate() {
        inceptionDate.clear();
        return this;
    }

    public void checkIfValidationErrorIsDisplayed() {
        WebElement validationError = webDriver.findElement(By.className("ValidationLabel__validationLabel--2km9U"));

        assertThat(validationError.isDisplayed()).isTrue();
    }
}
