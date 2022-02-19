import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameForm;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameForm;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement userNameForm;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordForm;

    @FindBy(xpath = "//*[@id=\"cpassword\"]")
    private WebElement confirmPasswordForm;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/div[5]/label")
    private WebElement confirmPasswordHeader;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement nextButton;

    public PersonalInformationPage (WebDriver driver) {
        super(driver);
    }

    public void completePersonalPageForms () {
        this.firstNameForm.sendKeys("Olexandr");
        this.lastNameForm.sendKeys("Al oshyn");
        this.userNameForm.sendKeys("Aleshoff");
        this.passwordForm.sendKeys("abc");
        this.confirmPasswordForm.sendKeys("abc");
        Utils.scrollToElement(driver, confirmPasswordHeader);
        this.nextButton.click();
    }
}
