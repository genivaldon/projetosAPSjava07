package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.ValidadorCampo;

public class ValidadorInteiro implements ValidadorCampo {

    private int valorMinimo;
    private int valorMaximo;

    public ValidadorInteiro(int min, int max) {

        this.valorMinimo = min;
        this.valorMaximo = max;

    }

    public ValidadorInteiro() {

        this.valorMinimo = Integer.MIN_VALUE;
        this.valorMaximo = Integer.MAX_VALUE;

    }

    @Override
    public Resultado validarCampo(String valor) {

        if (valor.matches("^[a-z]*")) {
            return new Resultado(true, "valor não é um inteiro:'" + valor + "'");

        }

        Resultado resultado = new Resultado();

        int valorInt = Integer.parseInt(valor);

        if (valorInt > valorMaximo) {
            return new Resultado(true, "valor maior que " + getMax() + ":" + valor);

        }

        if (valorInt < valorMinimo) {
            return new Resultado(true, "valor menor que " + getMin() + ":" + valor);
        }

        return resultado;
    }

    public int getMin() {
        return this.valorMinimo;
    }

    public int getMax() {
        return this.valorMaximo;
    }
}
