package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//    public LoginPage(WebElement txtUserName, WebElement txtPassword, WebElement btnLogin) {
//        this.txtUserName = txtUserName;
//        this.txtPassword = txtPassword;
//        this.btnLogin = btnLogin;
//    }

    // Constructor for this page which initializes all elements of this page
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;

    public void Login(String username, String password) {
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    public void ClickLogin() {
        btnLogin.submit();
    }
}
