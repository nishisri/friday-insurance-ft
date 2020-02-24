package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class horsePowerPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[1]")
    private WebElement horsePower;


    public horsePowerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public engineSelectionOfCarsPage selectHowMuchHP() throws InterruptedException {
        Thread.sleep(500);
        horsePower.click();
        return new engineSelectionOfCarsPage(this.webDriver);
    }
}
