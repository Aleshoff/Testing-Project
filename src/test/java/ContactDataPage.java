import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDataPage extends PageObject {

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

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[1]")
    private WebElement backButton;

    public ContactDataPage (WebDriver driver) {super(driver);}

    public void completeContactDataForms () {

        this.emailForm.sendKeys("aleshoff@gmail.com");
        this.phoneForm.sendKeys("000-00-00");
        this.countryForm.sendKeys("Romania");
        this.cityForm.sendKeys("Brasov");
        this.postecodeForm.sendKeys("520180");
        Utils.scrollToElement(driver, postecodeHeader);

        this.nextButton1.click();
    }

    public void unCompleteContactDataForms () {

        this.phoneForm.sendKeys("000-00-00");
        this.countryForm.sendKeys("Romania");
        this.cityForm.sendKeys("Brasov");
        this.postecodeForm.sendKeys("520180");
        Utils.scrollToElement(driver, postecodeHeader);
        this.nextButton1.click();

        this.emailForm.findElement(By.xpath("//*[@class=\"error-message\"]"));
    }
}
