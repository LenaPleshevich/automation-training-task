package task.com.epam.tenMinuteMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import task.com.epam.google.BasePage;

public class TenMinuteMailPage extends BasePage {
    @FindBy(xpath = "//*[@class='mail-address-address']")
    private WebElement generateMail;
    @FindBy(xpath = "//*[@id='ui-id-1']")
    private WebElement emailDropDown;
    @FindBy(xpath = "//td[2]//h3")
    private WebElement totalCost;
    private static final String generateMailAttribute = "value";

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public String getGenerateMail() {
        return generateMail.getAttribute(generateMailAttribute);
    }

    public TenMinuteMailPage openEmail() {
        super.initWait(emailDropDown);
        emailDropDown.click();
        return this;
    }

    public WebElement getTotalCost(){
        return totalCost;
    }
}
