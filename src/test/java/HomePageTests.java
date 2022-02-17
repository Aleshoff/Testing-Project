import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTests {
    protected static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Verify functionality of Email Form")
    public void VerifyEmail() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.inputTextToEmailForm();
    }

    @Test(testName = "Verify functionality of Errors for Email Form")
    public void VerifyErrorEmail() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.inputErrorTextToEmailForm();
        webForm.verifyErrorAttribute();
    }

    @Test(testName = "Verify functionality for What You'll learn button")
    public void VerifyLearnButton() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.ClickOnWhatYouLearn();
    }

    @Test(testName = "Verify functionality of the Correct SignUp Process")
    public void VerifyEnrollmentProcess() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.ClickOnStartEnrolmentButton();
        Enrollment enrollmentForm = new Enrollment(driver);
        enrollmentForm.completeForms();
        enrollmentForm.verifySuccessAttribute();
    }

    @Test(testName = "Verify functionality for Virtual button")
    public void VerifyVirtualButton() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.ClickOnVirtualButton();
        Virtual virtualElementForm = new Virtual(driver);
        Assert.assertEquals(virtualElementForm.verifyVirtualText(), Constants.VIRTUAL_TEXT);
    }

    @Test(testName = "Verify functionality for LearnSelenium button")
    public void VerifyLearnSeleniumButton() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.ClickOnLearnSeleniumButton();
        Fundamentals fundamentalsElementForm = new Fundamentals(driver);
        Assert.assertEquals(fundamentalsElementForm.fundamentalsPageText(), Constants.FUNDAMENTAL_TEXT);
    }

    @Test(testName = "Verify functionality of John Doe Facebook")
    public void VerifyJohnDoeFacebook() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.verifyJohnDoeFacebook();
        Assert.assertEquals(driver.getTitle(), Constants.FACEBOOK_TITLE);
    }

    @Test(testName = "Verify functionality of All Twitters")
    public void VerifyAllTwitters() {
        Homepage webForm = new Homepage(driver);
        webForm.verifyAllTwitterButtons();
    }

    @Test(testName = "Verify functionality of All Instagrams")
    public void VerifyAllInstagrams() {
        Homepage webForm = new Homepage(driver);
        webForm.verifyAllInstagramButtons();
    }

    @Test(testName = "Verify functionality of Up button")
    public void VerifyUpButton() {
        driver.get(Utils.BASE_URL);
        Homepage webForm = new Homepage(driver);
        webForm.ClickOnUpButton();
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
