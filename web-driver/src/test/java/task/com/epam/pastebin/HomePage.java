package task.com.epam.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage{
    @FindBy(id = "paste_code")
    private WebElement inputText;
    @FindBy(xpath = "//*[@title='Never']")
    private WebElement pasteExpirationDropDown;
    @FindBy(xpath = "//*[@class='select2-results__option']")
    private List<WebElement> pasteExpirationList;
    @FindBy(xpath = "//*[@title='None']")
    private WebElement syntaxHighlightingDropDown;
    @FindBy(xpath = "//*[@class='select2-results__option']")
    private List<WebElement> syntaxHighlightingList;
    @FindBy(name = "paste_name")
    private WebElement pasteName;
    @FindBy(id = "submit")
    private WebElement newPasteButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public PastePage createNewPostButton() {
        initWait(newPasteButton);
        newPasteButton.click();
        return new PastePage(driver);
    }

    public HomePage selectPasteExpiration(String parameter) {
        pasteExpirationDropDown.click();
        for(WebElement webElement: pasteExpirationList){
            if(webElement.getText().contains(parameter)){
                webElement.click();
                return this;
            }
        }
        return this;
    }

    public HomePage selectSyntaxHighlighting(String parameter) {
        syntaxHighlightingDropDown.click();
        for(WebElement webElement: syntaxHighlightingList) {
            if(webElement.getText().contains(parameter)){
                webElement.click();
                return this;
            }
        }
        return this;
    }

    public HomePage enterText(String text) {
        super.initWait(inputText);
        inputText.sendKeys(text);
        return this;
    }

    public HomePage enterPasteName(String name) {
        pasteName.sendKeys(name);
        return this;
    }
}
