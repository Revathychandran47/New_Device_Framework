package Page_Object.iOS;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage_iOS {
    WebDriver driver;

    @FindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage") public WebElement mph_image;
    @FindBy (xpath="//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeImage") public WebElement mph_logo;
    @FindBy (xpath = "//XCUIElementTypeStaticText") public WebElement oneAppToHelp_text;
    public String oneAppToHelp_Text="One app to help you consolidate all your health records, track your medications, manage your healthcare expenses, shop for plans and more..";
    @FindBy (xpath="//XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]") public WebElement login_button;
    @FindBy (xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]") public WebElement signUp_button;

    public LandingPage_iOS(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
