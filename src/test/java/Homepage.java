import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends PageObject{
    @FindBy(xpath = "/html/body/section[2]/div/div/div/input")
    private WebElement emailForm;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[1]/a")
    private WebElement whatYouLearn;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/a")
    private WebElement startEnrolment;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[1]/div/div/a")
    private WebElement virtualButton;

    @FindBy(xpath = "/html/body/section[3]/div/div/div[1]/div/div/h3")
    private WebElement virtualHeader;

    @FindBy(xpath = "//*[@id=\"learn-selenium\"]/div/div/div[1]/a")
    private WebElement learnSeleniumButton;

    @FindBy(xpath = "//*[@id=\"learn-selenium\"]/div/div/div[1]/h2")
    private WebElement learnSeleniumHeader;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/h3")
    private WebElement johnDoeHeader;

    @FindBy(xpath = "//*[@id=\"instructors\"]/div/div/div[1]/div/div/a[2]/i")
    private WebElement johnDoeFacebookButton;

    @FindBy(xpath = "//*[@href='https://www.twitter.com/']")
    private List<WebElement> twitterButtons;

    @FindBy(xpath = "//*[@href='https://www.instagram.com/']")
    private List<WebElement> instagramButtons;

    @FindBy(xpath = "/html/body/footer/div/a/i")
    private WebElement upButton;

    @FindBy(xpath = "/html/body/section[8]/div/div/div[1]/ul/li[5]/span")
    private WebElement studentEmailHeader;


    public Homepage (WebDriver driver) {
        super(driver);
    }

    public void ClickOnWhatYouLearn () {
        this.whatYouLearn.click();
    }

    public void ClickOnStartEnrolmentButton () {
        this.startEnrolment.click();
    }

    public void ClickOnVirtualButton () {
        Utils.scrollToElement(driver, virtualHeader);
        this.virtualButton.click();
    }

    public void ClickOnLearnSeleniumButton () {
        Utils.scrollToElement(driver, learnSeleniumHeader);
        this.learnSeleniumButton.click();
    }

    public void inputTextToEmailForm () {
        try {
            this.emailForm.sendKeys("abs@gmail.com");
            this.submitButton.click();
            //WebDriverWait wait = new WebDriverWait(driver, 1000);
            //Alert alert1 = wait.until(alertIsPresent);  it doesn't working. To see later.
            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            alert.accept();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inputErrorTextToEmailForm () {

            this.emailForm.sendKeys("abs");
            this.submitButton.click();
    }

    public void verifyErrorAttribute () {

        this.emailForm.findElement(By.xpath("//*[@class=\"form-control error\"]"));
    }

    public void verifyJohnDoeFacebook (){
        Utils.scrollToElement(driver, johnDoeHeader);
        this.johnDoeFacebookButton.click();
    }

    public void verifyAllTwitterButtons (){
        driver.get(Utils.BASE_URL);
        for (int i = 0; i < twitterButtons.size(); i++) {

            Utils.scrollToElement(driver, johnDoeHeader);
            WebElement newTwitterButton = twitterButtons.get(i);
            newTwitterButton.click();
            Assert.assertEquals(driver.getTitle(), Constants.TWITTER_TITLE);
            driver.get(Utils.BASE_URL);
        }
    }

    public void verifyAllInstagramButtons (){

        driver.get(Utils.BASE_URL);
        for (int i = 0; i < instagramButtons.size(); i++) {

            Utils.scrollToElement(driver, johnDoeHeader);
            WebElement newInstagramButton = instagramButtons.get(i);
            newInstagramButton.click();
            Assert.assertEquals(driver.getTitle(), Constants.INSTAGRAM_TITLE);
            driver.get(Utils.BASE_URL);
        }
    }

    public void ClickOnUpButton () {
        Utils.scrollToElement(driver, studentEmailHeader);
        this.upButton.click();
    }
}
