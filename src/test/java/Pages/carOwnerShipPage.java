package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class carOwnerShipPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/button[1]/div")
    private WebElement carApprovedY;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[3]/div[2]/button[1]")
    private WebElement carusedY;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button[2]")
    private WebElement buttonFurther;

    public carOwnerShipPage(WebDriver webDriver) {
        super(webDriver);
    }

    public carOwnerShipPage selectCarApprovedBySelf() {
        carApprovedY.click();
        return this;
    }

    public carOwnerShipPage selectAsUsedCar() {
        carusedY.click();
        return this;
    }

    public selectVehiclePage goFurther() {
        buttonFurther.click();
        return new selectVehiclePage(this.webDriver);


    }
}