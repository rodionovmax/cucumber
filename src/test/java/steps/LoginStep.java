package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import transformation.EmailTransform;
import transformation.SalaryCountTransformer;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }


    @Given("^I navigate to login page of the application$")
    public void iNavigateToLoginPageOfTheApplication() throws Throwable {
        System.out.println("Navigate to Login page\n");
        String pageUrl = "http://www.executeautomation.com/demosite/Login.html";
        base.Driver.navigate().to(pageUrl);

    }

    @And("^I enter following for login$")
    public void iEnterFollowingForLogin(DataTable table) throws Throwable {

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);

        for (User user : users) {
            LoginPage page = new LoginPage(base.Driver);

            page.Login(user.username, user.password);
        }

    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
//        base.Driver.findElement(By.name("Login")).submit();
        LoginPage page = new LoginPage(base.Driver);

        page.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        Assert.assertTrue(base.Driver.findElement(By.id("Initial")).isDisplayed(), "It's not displayed");
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        System.out.println("Username is: " + username);
        System.out.println("Password is: " + password);
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {

        System.out.println("The email address is: " + email);
    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {

        System.out.println("My salary digits is: " + salary);
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() {
        Assert.assertTrue(base.Driver.findElement(By.id(".vsnvakafgkkga")).isDisplayed(), "It's not displayed");
    }


    public class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }


}

