package br.com.chronosacademy.ecommerce.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin;

    public WebElement btnFechar;
    public WebElement divFecharModal;
    public WebElement inpUserName;
    public WebElement inpPassword;
    public WebElement btnSignIn;
    public WebElement inpRemember;
    public WebElement linkCreateAccount;

}
