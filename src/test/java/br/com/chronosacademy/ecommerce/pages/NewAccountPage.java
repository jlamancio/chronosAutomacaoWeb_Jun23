package br.com.chronosacademy.ecommerce.pages;

import br.com.chronosacademy.ecommerce.core.Driver;
import br.com.chronosacademy.ecommerce.maps.NewAccountMap;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {
    NewAccountMap newAccountMap;

    public NewAccountPage() {
        newAccountMap = new NewAccountMap();
        PageFactory.initElements(Driver.getDriver(), newAccountMap);
    }

    public String getTextNewAccount() {
        Driver.visibilityOf(newAccountMap.textCreateNewAccount);
        return  newAccountMap.textCreateNewAccount.getText();
    }
}
