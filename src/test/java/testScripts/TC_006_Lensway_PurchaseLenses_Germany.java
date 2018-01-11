package testScripts;

import lenswayPages.HomePage;
import lenswayPages.LensPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TC_006_Lensway_PurchaseLenses_Germany extends TestBase {

    @BeforeTest

    public void setUp()
    {
        init();

    }

    @Test

    public void lensValidation()   {
        log.info("#######################Starting test to verify login details#####################################");
        homePage=new HomePage(driver);
        lensPage=new LensPage(driver);
        homePage.login_Lensway("Testuat@lenswaygroup.com", "Test@1231");
        lensPage.LensProduct();

        log.info("#######################Finished test to verify login details#####################################");

    }

    @AfterClass

    public void endTest()
    {
        driver.close();

    }

}
