package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class selectVehiclePage extends PageObject {

    @FindBy(name = "make")
    private List<WebElement> allBrands;


    public selectVehiclePage(WebDriver webDriver) {
        super(webDriver);
    }

    public carModelPage selectCarManufacturer(String manufacturer) {
        allBrands.stream().filter(br -> br.getText().contains(manufacturer)).findFirst().get().click();
        return new carModelPage(this.webDriver);
    }


}