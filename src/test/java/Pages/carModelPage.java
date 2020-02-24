package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class carModelPage extends PageObject {
    @FindBy(name = "model")
    private List<WebElement> allCarModels;

    public carModelPage(WebDriver webDriver) {
        super(webDriver);
    }


    public shapeOfCarsPage selectCarModel(String carModel) {
        allCarModels.stream().filter(cm -> cm.getText().contains(carModel)).findFirst().get().click();
        return new shapeOfCarsPage(this.webDriver);


    }
}
