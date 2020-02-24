package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class typeOfFuelPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[1]")
    private WebElement fueling;

    public typeOfFuelPage(WebDriver webDriver) {
        super(webDriver);
    }


    public horsePowerPage selectWhatAreYouFueling() throws InterruptedException {
        Thread.sleep(500);
        fueling.click();
        return new horsePowerPage(this.webDriver);
    }

}
