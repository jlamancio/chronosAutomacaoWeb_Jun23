package br.com.chronosacademy.ecommerce.steps;

import br.com.chronosacademy.ecommerce.core.Driver;
import br.com.chronosacademy.ecommerce.enums.Browser;
import br.com.chronosacademy.ecommerce.pages.LoginPage;
import br.com.chronosacademy.ecommerce.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {

    LoginPage loginPage;
    String username;
    @Before
    public void iniciarNavegador(){
        new Driver(Browser.CHROME);
    }
    @After
    public void fecharNavegador(){
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com");
        loginPage = new LoginPage();
        loginPage.clickBtnlogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardarLoader();
    }

    @Quando("for realizado clique fora da modal")
    public void forRealizadoCliqueForaDaModal() {
        loginPage.clickDivFecharModal();
    }

    @Então("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        }catch (Exception e){
            throw new Exception(("A janela modal não foi fechada"));
        }
    }

    @Quando("for realizado un clique no icone de fechar modal")
    public void forRealizadoUnCliqueNoIconeDeFecharModal() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique no link Create New Account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clicklinkCreateAccount();
    }

    @Então("a pagina Create New Account deve ser exibida.")
    public void aPaginaCreateNewAccountDeveSerExibida() {
       NewAccountPage newAccountPage = new NewAccountPage();
       Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
    }

    @Quando("os campos de login sejam preenchidos da seguinte forma")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);

        if (remember){
            loginPage.clickInpRemember();
        }

    }

    @Quando("for realizado o clique  no botao Singin")
    public void forRealizadoOCliqueNoBotaoSingin() {
        loginPage.clicBtnSingIn();
    }

    @Então("deve ser possível logar no sistema")
    public void deveSerPossívelLogarNoSistema() {
        Assert.assertEquals(username, loginPage.getUsuarioLogado());

    }

    @Então("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect user name or password.", loginPage.getErrorLogin());
    }

    @Então("o botao Singin devera permanecer desabiitado")
    public void oBotaoSinginDeveraPermanecerDesabiitado() {
        boolean enabled = loginPage.isBtnSingIN();
        Assert.assertFalse(enabled);
    }
}
