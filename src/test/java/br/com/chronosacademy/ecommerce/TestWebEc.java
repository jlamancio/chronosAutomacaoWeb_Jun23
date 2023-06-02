package br.com.chronosacademy.ecommerce;

import br.com.chronosacademy.ecommerce.core.Driver;
import br.com.chronosacademy.ecommerce.pages.CursoPage;
import br.com.chronosacademy.ecommerce.pages.PrincipalPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestWebEc {

    Driver driverweb;
    WebDriver driver;
    PrincipalPage principalPage;
    CursoPage cursoPage;

    @Before
    public void inicializarTest() {
        driverweb = new Driver("chrome");
        driver = driverweb.getDriver();
        driver.get("https://chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }

    @Test
    public void primeiroTeste() {

        String titulo = principalPage.getTitulo();
        Assert.assertEquals("Porque Tempo É Conhecimento.", titulo);

    }

    @Test
    public void segundoTeste() {
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();
        String titulo = cursoPage.getTitulo2();
        Assert.assertEquals("Conheça todos os nossos cursos.", titulo);

    }

    @After
    public void finalizarTest() {
        driver.quit();
    }

}
