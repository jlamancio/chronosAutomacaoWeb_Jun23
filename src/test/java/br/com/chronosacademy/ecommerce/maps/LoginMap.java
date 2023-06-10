package br.com.chronosacademy.ecommerce.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")          // '#' = id
    public WebElement btnLogin;
    @FindBy(css = ".closeBtn")          // '.' = class
    public WebElement btnFechar;
    @FindBy(css = ".PopUp")
    public WebElement divFecharModal;
    @FindBy(css = "*[name='username']")
    public WebElement inpUserName;
    @FindBy(css = "*[name='password']")
    public WebElement inpPassword;
    @FindBy(css = "#sign_in_btnundefined")
    public WebElement btnSignIn;
    @FindBy(css = "*[name='remember_me']")
    public WebElement inpRemember;
    @FindBy(linkText = "CREATE NEW ACCOUNT")
    public WebElement linkCreateAccount;
    @FindBy(css = ".loader")
    public WebElement divLoader;
    @FindBy(css = ".containMiniTitle ")
    public WebElement textLogado;
}
