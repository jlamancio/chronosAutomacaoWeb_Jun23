package br.com.chronosacademy.ecommerce.pages;

import br.com.chronosacademy.ecommerce.core.Driver;
import br.com.chronosacademy.ecommerce.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void clickBtnlogin() {
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }

    public void clickBtnFechar() {
        loginMap.btnFechar.click();
    }

    public void clickDivFecharModal() {
        loginMap.divFecharModal.click();
    }

    public void setInpUserName(String username) {
        if (username != null) {
            loginMap.inpUserName.sendKeys(username);
        }
    }

    public void setInpPassword(String password) {
        if (password != null) {
            loginMap.inpPassword.sendKeys(password);
        }
    }

    public void clickInpRemember() {
        loginMap.inpRemember.click();
    }

    public void clicklinkCreateAccount() {
        loginMap.linkCreateAccount.click();
    }

    public void clicBtnSingIn() {
        loginMap.btnSignIn.click();
    }

    public boolean isBtnSingIN() {
        return loginMap.btnSignIn.isEnabled();
    }

    public void visibilityOfBtnFechar() {
        Driver.visibilityOf(loginMap.btnFechar);
    }

    public void invisibilityOfBtnFechar() {
        Driver.invisibilityOf(loginMap.btnFechar);
    }

    public void aguardarLoader() {
        Driver.attributeChange(loginMap.divLoader, "display", "none");
    }

    public String getUsuarioLogado(){
        Driver.visibilityOf(loginMap.textLogado);
        return loginMap.textLogado.getText();
    }
    public String getErrorLogin(){
        Driver.visibilityOf(loginMap.txtErrorLogin);
        return loginMap.txtErrorLogin.getText();
    }

}
