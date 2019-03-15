package task.com.epam.test.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task.com.epam.google.CalculatorPage;
import task.com.epam.google.HomePage;

public class CalculatorPageTest {
    private static final String OS = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String INSTANCES_NUMBER = "4";
    private static final String PLATFORM = "COMPUTE ENGINE";
    private static final String VM_CLASS = "Regular";
    private static final String TYPE_INSTANCE = "n1-standard-8";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String COMMITED_USAGE = "1 Year";
    private static final String DATA_CENTER_LOCATION = "Frankfurt";
    private static final String GPU_NUMBER = "1";
    private static final String TYPE_GPU = "NVIDIA Tesla V100";
    private static final String EXPECTED_COST = "1,187.77";
    private static WebDriver driver;
    private static HomePage homePage;
    private static CalculatorPage calculatorPage;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/ ");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public static void goToPageCalculators() {
        calculatorPage = homePage.goToPageProducts().goToPagePrising().goToPageCalculators();
    }

    @Test
    public void parameterCalculatorTest() {
        calculatorPage.switchToFrame();
        calculatorPage.selectPlatform(PLATFORM)
                .selectInstancesNumber(INSTANCES_NUMBER)
                .selectOS(OS)
                .selectVMClass(VM_CLASS)
                .selectInstanceType(TYPE_INSTANCE)
                .addGPU(GPU_NUMBER, TYPE_GPU)
                .selectLocalSSD(LOCAL_SSD)
                .selectDataCenterLocation(DATA_CENTER_LOCATION)
                .selectCommitedUsage(COMMITED_USAGE);
        calculatorPage.addToExecute();
        checkEnteredParameters();
    }

    private void checkEnteredParameters() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calculatorPage.getVMClass().getText().contains(VM_CLASS.toLowerCase())
                , "The resulting parameter value VM_CLASS does not match expected");
        softAssert.assertTrue(calculatorPage.getInstanceType().getText().contains(TYPE_INSTANCE)
                ,"The resulting parameter value TYPE_INSTANCE does not match expected");
        softAssert.assertTrue(calculatorPage.getLocalSSD().getText().contains(LOCAL_SSD)
                , "The resulting parameter value LOCAL_SSD does not match expected");
        softAssert.assertTrue(calculatorPage.getRegion().getText().contains(DATA_CENTER_LOCATION)
                ,"The resulting parameter value DATA_CENTER_LOCATION does not match expected");
        softAssert.assertTrue(calculatorPage.getCommitmentTerm().getText().contains(COMMITED_USAGE)
                , "The resulting parameter value COMMITED_USAGE does not match expected");
        softAssert.assertTrue(calculatorPage.getCost().getText().contains(EXPECTED_COST)
                , "The resulting parameter value EstimatedCost does not match expected");
        softAssert.assertAll();
    }
}