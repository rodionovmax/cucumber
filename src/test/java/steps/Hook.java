package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {

        scenarioDef = base.features.createNode(scenario.getName());

        System.out.println("Opening the browser: Chrome\n");
        System.setProperty("webdriver.chrome.Driver", "chromedriver");
        base.Driver = new ChromeDriver();

    }

    @After
    public void TearDownTest(Scenario scenario) {
        System.out.println("Closing the browser: Chrome\n");

        if (scenario.isFailed()) {
            // Take a screenshot
            System.out.println(scenario.getName());
            base.Driver.quit();
        }
    }
}
