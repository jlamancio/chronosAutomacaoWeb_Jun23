package br.com.chronosacademy.unitarios;

public class Media {
    public String calcularMedia(double val1, double val2) {

        double media = (( val1 + val2 ) / 2);
        if (media < 5){
            return "Reprovado";
        }
        return "Aprovado";
    }
}
