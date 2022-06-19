package Page_Object.Android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class LandingPage_Android {
    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView") public WebElement mph_image;
    @FindBy (xpath="//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView") public WebElement mph_logo;
    @FindBy (xpath = "//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView") public WebElement oneAppToHelp_text;
    public String oneAppToHelp_Text="One app to help you consolidate all your health records, track your medications, manage your healthcare expenses, shop for plans and more..";
    @FindBy (xpath="//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView") public WebElement login_button;
    @FindBy (xpath = "//android.view.ViewGroup[2]/android.widget.TextView") public WebElement signUp_button;

    public LandingPage_Android(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
