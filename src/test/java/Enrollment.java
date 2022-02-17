import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Enrollment extends PageObject{
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

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailForm;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneForm;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement countryForm;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityForm;

    @FindBy(xpath = "//*[@id=\"postCode\"]")
    private WebElement postecodeForm;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/div[5]/label")
    private WebElement postecodeHeader;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement nextButton1;

    @FindBy(xpath = "//*[@id=\"flexRadioButton3\"]")
    private WebElement autManOption;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement nextButton2;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[2]/input")
    private WebElement cardHolderForm;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[1]/input")
    private WebElement cardnumberForm;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[3]/div/div[2]/input")
    private WebElement cardCvcForm;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/div/div[1]/label")
    private WebElement expiryDateHeader;

    @FindBy(xpath = "//*[@id=\"month\"]")
    private WebElement monthForm;

    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElement yearForm;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/div[4]/button[2]")
    private WebElement nextButton3;

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[5]/a")
    private WebElement successRegistrationAttribute;


    public Enrollment (WebDriver driver) {
        super(driver);
    }
    public void completeForms () {
        this.firstNameForm.sendKeys("Olexandr");
        this.lastNameForm.sendKeys("Al oshyn");
        this.userNameForm.sendKeys("Aleshoff");
        this.passwordForm.sendKeys("abc");
        this.confirmPasswordForm.sendKeys("abc");
        Utils.scrollToElement(driver, confirmPasswordHeader);
        this.nextButton.click();

        this.emailForm.sendKeys("aleshoff@gmail.com");
        this.phoneForm.sendKeys("000-00-00");
        this.countryForm.sendKeys("Romania");
        this.cityForm.sendKeys("Brasov");
        this.postecodeForm.sendKeys("520180");
        Utils.scrollToElement(driver, postecodeHeader);
        this.nextButton1.click();

        this.autManOption.click();
        this.nextButton2.click();

        this.cardHolderForm.sendKeys("Al oshyn Olexandr");
        this.cardnumberForm.sendKeys("1111-0000-2222-3333");
        this.cardCvcForm.sendKeys("123");
        Utils.scrollToElement(driver, expiryDateHeader);
        this.monthForm.sendKeys("july");
        this.yearForm.sendKeys("2022");

    }

    public void verifySuccessAttribute () {

        successRegistrationAttribute.findElement(By.xpath("//a[@href=\"../index.html\"]"));
    }
}
