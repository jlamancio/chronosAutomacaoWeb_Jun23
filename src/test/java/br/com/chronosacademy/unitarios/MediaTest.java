package br.com.chronosacademy.unitarios;


import org.junit.Assert;
import org.junit.Test;

public class MediaTest {

    Media media = new Media();

    @Test
    public void validarAprovado(){
        String resultado;
        resultado = media.calcularMedia(5.0, 5.0);
        Assert.assertEquals("Aprovado", resultado);

    }

    @Test
    public void validarReprovado(){
        String resultado;
        resultado = media.calcularMedia(4.9, 5.0);
        Assert.assertEquals("Reprovado", resultado);
    }

}