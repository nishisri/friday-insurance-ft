package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class engineSelectionOfCarsPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[1]")
    private WebElement selectEngine;


    public engineSelectionOfCarsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public enterRegistrationDatePage selectCarEngine() throws InterruptedException {
        Thread.sleep(500);
        selectEngine.click();
        return new enterRegistrationDatePage(this.webDriver);
    }
}


