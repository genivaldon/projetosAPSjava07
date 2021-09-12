package br.ufpb.dcx.aps.strategy.form.validador;

import br.ufpb.dcx.aps.strategy.form.Campo;
import br.ufpb.dcx.aps.strategy.form.Formulario;
import br.ufpb.dcx.aps.strategy.form.Resultado;
import br.ufpb.dcx.aps.strategy.form.validador.ValidadorEmail;

public class App {

    public static void main(String[] argsadd){
        Formulario form = new Formulario("Exemplo Strategy");

        Campo nome = new Campo("nome", "Digite seu Nome:");
        nome.setValidador(new ValidadorTextoSimples(3,200));
        form.addItemFormulario(nome);
        Resultado resNome = nome.validar();


        Campo email = new Campo("email","Digite seu email:");
        email.setValidador(new ValidadorEmail());

        form.addItemFormulario(email);

        Resultado resultado = form.validar();


    }
}
