package br.com.chronosacademy.ecommerce.pages;

import br.com.chronosacademy.ecommerce.core.Driver;
import br.com.chronosacademy.ecommerce.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage(){
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void clickBtnlogin(){
        loginMap.btnLogin.click();
    }

    public void clickBtnFechar(){
        loginMap.btnFechar.click();
    }

    public void clickDivFecharModal(){
        loginMap.divFecharModal.click();
    }

    public void setInpUserName(String username){
        loginMap.inpUserName.sendKeys(username);
    }

    public void setInpPassword(String password){
        loginMap.inpPassword.sendKeys(password);
    }

    public void clickInpRemember(){
        loginMap.inpRemember.click();
    }

    public void linkCreateAccount(){
        loginMap.linkCreateAccount.click();
    }

    public void clicBtnSingIn(){
        loginMap.btnSignIn.click();
    }

    public boolean isBtnSingIN(){
        return loginMap.btnSignIn.isSelected();
    }








}
