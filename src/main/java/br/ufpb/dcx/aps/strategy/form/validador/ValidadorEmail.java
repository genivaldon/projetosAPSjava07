package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.ValidadorCampo;

public class ValidadorEmail implements ValidadorCampo {


    @Override
    public Resultado validarCampo(String valor){
        if (valor == null){
            return new Resultado(true, "Valor de campo nulo");
        }
        if (!valor.contains("@")){
            return new Resultado(true, "email inválido: '" + valor + "'");

        }
        return new Resultado(); 
    }
    
}
