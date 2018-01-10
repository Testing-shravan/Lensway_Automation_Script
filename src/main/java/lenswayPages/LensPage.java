package lenswayPages;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LensPage extends TestBase {

    public static final Logger log = Logger.getLogger(HomePage.class.getName());


    @FindBy(xpath = "//*[@data-megamenu='js-lenses']/a")
    private WebElement GoToLens;

    @FindBy(linkText = "1-Day Acuvue")
    private WebElement SelectLens1 ;

    @FindBy(xpath = ".//*[@id='boxsize_107']")
    private WebElement Select30Pack;

    @FindBy(xpath = ".//*[@id='boxsize_46']")
    private WebElement Select90Pack;

    @FindBy(xpath = ".//*[@id='left_eye_checkbox']")
    private WebElement leftEyeCheckbox;

    @FindBy(id = "right_eye_checkbox")
    private WebElement rightEyeCheckbox;

    @FindBy(id = "prod_pow_right")
    protected WebElement rightEyePower;

    @FindBy(id = "prod_pow_left")
    protected WebElement leftEyePower;

    @FindBy(id = "prod_bc_right")
    protected WebElement rightEyeBC;

    @FindBy(id = "prod_bc_left")
    protected WebElement leftEyeBC;

    @FindBy(id = "prod_dia_right")
    protected WebElement rightEyeDiameter;

    @FindBy(id = "prod_dia_left")
    protected WebElement leftEyeDiameter;

    @FindBy(id = "prod_quantity_right")
    protected WebElement rightLensQuantity;

    @FindBy(id = "prod_quantity_left")
    protected WebElement leftLensQuantity;

    @FindBy(id = "js-buy-btn")
    protected WebElement gotoCart;

    @FindBy(xpath = "//*[@id='popup-related-products']//a[@href='/cart']")
    private WebElement confirmGotoCart;

//****************************************************************************************//

    @FindBy(id = "no-popup")
    private WebElement doNotShowCheckbox;

    @FindBy(className = "offers-to-cart__button")
    protected WebElement precartButton;

    @FindBy(id = "popup-related-products")
    protected WebElement popupOnCart;

    @FindBy(xpath = "//article[@class='info-wrapper__body']/p[@class='hide']")
    private List<WebElement> productAbsentInfo;

    @FindBy(className = "loadingoverlay")
    private WebElement overlay;

    @FindBy(xpath = "//a[contains(@class,'info-wrapper__link')]")
    private WebElement linkToAnotherProduct;

    @FindBy(xpath = "//*[@id='notInStockWithReplace']")
    private WebElement replaceWithOtherProductButton;

    @FindBy(xpath = "//*[@id='notInStockNoReplace']")
    private WebElement irreplaceableWithOtherProduct;

    @FindBy(id = "product-page__total-amount")
    protected WebElement priceOnGotoCartButton;

    @FindBy(id = "product-page__product-prescription")
    protected WebElement showReceiptButton;

    @FindBy(name = "j_username")
    protected List<WebElement> signInEmailFields;

    @FindBy(name = "j_password")
    protected List<WebElement> passwordFields;

    @FindBy(xpath = "//*[@class='login-widget__login']//input[contains(@class,'login-btn')]")
    protected List<WebElement> loginButtons;

    @FindBy(className = "popup-window__content")
    private WebElement popupElement;

    @FindBy(xpath = "//*[contains(@class,'goToCartButton')]")
    protected WebElement gotoCartButton;

    @FindBy(id = "top-menu-basket")
    protected WebElement basket;


    public LensPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void LensProduct()   {

        Actions action1= new Actions(driver);
        action1.moveToElement(GoToLens).build().perform();

        //Select Lenses
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1-Day Acuvue")));
        SelectLens1.click();

        //Select radio button
        Actions action2= new Actions(driver);
        action2.moveToElement(Select30Pack).click().perform();

        //Unselect check box
        Actions action3= new Actions(driver);
        action2.moveToElement(leftEyeCheckbox).click().perform();


        //Select Dropdown
        Select dropdown1 = new Select(driver.findElement(By.id("prod_pow_right")));
        dropdown1.selectByVisibleText("-0.75");

        Select dropdown2 = new Select(driver.findElement(By.id("prod_bc_right")));
        dropdown2.selectByVisibleText("8.5");

        //Add to Cart
        gotoCart.click();
        confirmGotoCart.click();

        //Scrolldown
        WebElement scroll = driver.findElement(By.xpath("//label[text()='Har du en rabattkod?']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);


        WebElement frame = driver.findElement(By.id("klarna-checkout-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("checkout-se@testdrive.klarna.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("12345");
        driver.findElement(By.cssSelector("._3aM-K._37GB9")).click();

        //Scrolldown
        WebElement scroll1 = driver.findElement(By.xpath("//h1[text()='Betalsätt']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll1);

        //Scrolldown and click button
        WebElement scroll2= driver.findElement(By.id("buy-button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", scroll2);

    }


}


