package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class enterRegistrationDatePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button[2]")
    private WebElement furtherButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div/div[2]/div/div/input")
    private WebElement firstRegdate;


    public enterRegistrationDatePage(WebDriver webDriver) {
        super(webDriver);
    }

    public enterRegistrationDatePage enterRegDate(String date) throws InterruptedException {
        firstRegdate.clear();
        firstRegdate.sendKeys(date);

        return this;
    }

    public enterDateOfBirthPage clickFurther() {
        furtherButton.click();
        return new enterDateOfBirthPage(this.webDriver);
    }
}
