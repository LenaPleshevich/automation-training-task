package task.com.epam.test.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task.com.epam.pastebin.HomePage;
import task.com.epam.pastebin.PastePage;

public class PastebinPageTest {
    private static final String INPUT_TEXT = "Hello from WebDriver";
    private static final String INPUT_TEXT_TASK_2 = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String PASTE_NAME = "helloweb";
    private static final String PASTE_NAME_TASK_2 = "how to gain dominance among developers";
    private static final String EXPIRATION_PASTE = "10 Minutes";
    private static final String SYNTAX_HIGHLIGHTING = "Bash";
    private static WebDriver driver;
    private static HomePage homePage;
    private static PastePage pastePage;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void parameterPasteForFirstTaskTest() {
        homePage.enterText(INPUT_TEXT).enterPasteName(PASTE_NAME).selectPasteExpiration(EXPIRATION_PASTE);
    }

    @Test
    public void parameterPasteForSecondTaskTest() {
        homePage.enterText(INPUT_TEXT_TASK_2).enterPasteName(PASTE_NAME_TASK_2).selectPasteExpiration(EXPIRATION_PASTE).selectSyntaxHighlighting(SYNTAX_HIGHLIGHTING);
        pastePage = homePage.createNewPostButton();
        checkEnteredParameters();
    }

    private void checkEnteredParameters() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pastePage.getPasteName().getText().contains(PASTE_NAME_TASK_2)
                , "The resulting parameter value PasteName does not match expected");
        softAssert.assertTrue(pastePage.getSyntaxHighlighting().getText().contains(SYNTAX_HIGHLIGHTING)
                ,"The resulting parameter value Syntax Highlighting does not match expected");
        System.out.println(pastePage.getTextPaste().getText());
        softAssert.assertTrue(pastePage.getTextPaste().getText().contains(INPUT_TEXT_TASK_2)
                , "The resulting parameter value InputText does not match expected");
        softAssert.assertAll();
    }
}
