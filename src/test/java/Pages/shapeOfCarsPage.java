package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shapeOfCarsPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[1]")
    private WebElement shapeOfCar;

    public shapeOfCarsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public typeOfFuelPage selectShapeOfCar() {
        shapeOfCar.click();
        return new typeOfFuelPage(this.webDriver);
    }
}

