
//author saravanan kumar
package testScripts;

import com.lensway.lenswayPages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.lensway.testBase.TestBase;

public class TC_002_Lensway_ValidLoginVerification extends TestBase {


    HomePage homePage;

    @BeforeTest

    public void setuUp()
    {

       init();

    }

    @Test

    public void loginValidation() throws InterruptedException {
        log.info("#######################Starting test to verify login details#####################################");
        homePage=new HomePage(driver);

        homePage.login_Lensway("Testuat@lensway.com", "Test@1231");

        getScreenShot("loginValidation");

        log.info("#######################Finished test to verify login details#####################################");

    }

    @AfterClass

    public void endTest()
    {
        driver.close();

    }

}


