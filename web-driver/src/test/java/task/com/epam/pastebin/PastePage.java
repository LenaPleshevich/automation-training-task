package task.com.epam.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastePage extends BasePage {
    @FindBy(id = "paste_code")
    private WebElement enteredText;
    @FindBy(xpath = "//*[@class='paste_box_line1']")
    private WebElement enteredName;
    @FindBy(xpath = "//*[@class='h_640']")
    private WebElement selectedSyntaxHighlighting;

    public PastePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPasteName() {
        return enteredName;
    }

    public WebElement getTextPaste() {
        return enteredText;
    }

    public WebElement getSyntaxHighlighting() {
        return selectedSyntaxHighlighting;
    }
}
