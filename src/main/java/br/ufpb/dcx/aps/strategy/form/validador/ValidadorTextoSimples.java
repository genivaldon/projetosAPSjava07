package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.ValidadorCampo;

public class ValidadorTextoSimples implements ValidadorCampo {

    private int max;
    private int min;

    public ValidadorTextoSimples() {
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
    }

    public ValidadorTextoSimples(int min, int max) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("invalido min=" + min + ", max=" + max);
        }

        this.max = max;
        this.min = min;

    }

    @Override
    public Resultado validarCampo(String valor) {
        if (valor == null) {
            return new Resultado(true, "valor: " + valor);
        }
        Resultado resultado = new Resultado();

        int tamanho = valor.length();

        if (tamanho > max) {
            return new Resultado(true, "ERRO: tamanho do valor > " + getMax() + ": '" + valor + "'");

        }
        if (tamanho < min) {
            return new Resultado(true, "ERRO: tamanho do valor < " + getMin() + ": '" + valor + "'");
        }

        return resultado;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

}
