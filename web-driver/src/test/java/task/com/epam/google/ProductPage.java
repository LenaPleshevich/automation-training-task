package task.com.epam.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@track-name='seePricing']")
    private WebElement buttonSeePrising;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public PricingPage goToPagePrising() {
        super.initWait(buttonSeePrising);
        buttonSeePrising.click();
        return new PricingPage(driver);
    }
}
