package br.com.chronosacademy.ecommerce.steps;

import br.com.chronosacademy.ecommerce.core.Driver;
import br.com.chronosacademy.ecommerce.enums.Browser;
import br.com.chronosacademy.ecommerce.pages.LoginPage;
import br.com.chronosacademy.ecommerce.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {

    LoginPage loginPage;
    String username;

    @Before
    public void iniciarNavegador(Scenario cenario) {
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criarDiretorio();
    }

    @After
    public void fecharNavegador(Scenario cenario) throws IOException {
        System.out.println(Driver.getNomeCenario() + " -- " + cenario.getStatus());
        System.out.println(Driver.getNomeCenario() + " falhou ?" + " -- " + cenario.isFailed());
        if(cenario.isFailed()){
            Driver.printScreen("Erro no cenário");
        }
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
        } catch (Exception e) {
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
    public void aPaginaCreateNewAccountDeveSerExibida() throws IOException {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
        Driver.printScreen("Exibição tela Create New Account");
    }

    @Quando("os campos de login sejam preenchidos da seguinte forma")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) throws IOException {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);

        if (remember) {
            loginPage.clickInpRemember();
        }

        Driver.printScreen("Preenchimento dos campos de Login");

    }

    @Quando("for realizado o clique  no botao Singin")
    public void forRealizadoOCliqueNoBotaoSingin() {
        loginPage.clicBtnSingIn();
    }

    @Então("deve ser possível logar no sistema")
    public void deveSerPossívelLogarNoSistema() throws IOException {
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
        Driver.printScreen("Logado no sistema");

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
