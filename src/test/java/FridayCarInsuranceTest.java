import Pages.engineSelectionOfCarsPage;
import Pages.enterRegistrationDatePage;
import Pages.landingPage;
import Pages.selectVehiclePage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class FridayCarInsuranceTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/anubhavsrivastava/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://hello.friday.de/quote/selectPrecondition");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    @MethodSource("fordCars")
    @ParameterizedTest
    public void shouldBeAbleToSelectFORDKAAndFiesta(String brand, String model) throws InterruptedException, IOException {


        engineSelectionOfCarsPage engineSelectionOfCars = traverseToManufactureSelection()
                .selectCarManufacturer(brand)
                .selectCarModel(model)
                .selectShapeOfCar()
                .selectWhatAreYouFueling()
                .selectHowMuchHP();
        new enterRegistrationDatePage(this.driver)
                .enterRegDate(LocalDate.now().minusDays(3).format(DateTimeFormatter.ofPattern("MM.YYYY")))
                .clickFurther()
                .checkIfValidationBornDatePageIsDisplayed();

    }

    @Test
    @MethodSource("carWithModel")
    @ParameterizedTest
    public void shouldBeAbleToSelectBrandWithCars(String brand, String model) throws InterruptedException, IOException {


        traverseToManufactureSelection()
                .selectCarManufacturer(brand)
                .selectCarModel(model)
                .selectShapeOfCar()
                .selectWhatAreYouFueling()
                .selectHowMuchHP()
                .selectCarEngine()
                .enterRegDate(LocalDate.now().minusDays(3).format(DateTimeFormatter.ofPattern("MM.YYYY")))
                .clickFurther()
                .checkIfValidationBornDatePageIsDisplayed();


    }

    public selectVehiclePage traverseToManufactureSelection() {
        landingPage landingPage = new landingPage(driver);

        landingPage
                .selectPreCondition()
                .clearDate()
                .enterInceptionDate(LocalDate.now().minusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.YYYY")))
                .checkIfValidationErrorIsDisplayed();

        return landingPage
                .clearDate()
                .enterInceptionDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY")))
                .clickNextButton()
                .selectCarApprovedBySelf()
                .selectAsUsedCar()
                .goFurther();


    }

    static Stream<Arguments> carWithModel() {
        return Stream.of(
                arguments("VW", "Caddy"),
                arguments("VW", "Golf"),
                arguments("VW", "Polo"),
                arguments("BMW", "1er"),
                arguments("BMW", "2er"),
                arguments("BMW", "3er"),
                arguments("FORD", "Focus"));
    }

    static Stream<Arguments> fordCars() {
        return Stream.of(
                arguments("FORD", "Fiesta"),
                arguments("FORD", "KA"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
