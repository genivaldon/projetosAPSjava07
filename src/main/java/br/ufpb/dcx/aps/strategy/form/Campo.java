package br.ufpb.dcx.aps.strategy.form;

import br.ufpb.dcx.aps.strategy.form.validador.ValidadorTextoSimples;

public class Campo implements ItemFormulario {

    private String nome;
    private String id;
    private String valor;
    private boolean preenchido;
    private boolean obrigatorio;
    private ValidadorCampo validador;

    public Campo(String id){

        this.validador = new ValidadorTextoSimples();
        this.id = id;
        this.nome = "";
        this.valor = "";
        this.preenchido = false;
        this.obrigatorio = false;
    }

    public Campo (String id, String nome){
        this(id);
        this.nome = nome;
    }

    public Campo(ValidadorCampo validador, boolean obrigatorio){
        this.validador = validador;
        this.obrigatorio = obrigatorio;

    }
    public Campo(String id, boolean obrigatorio, String nome){
        this(id, nome);
        this.obrigatorio = obrigatorio;
    }
    public Campo (String nome, boolean obrigatorio){
        this.nome = nome;
        this.obrigatorio = obrigatorio;
    }

    public String getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getLabel(){
        return getNome();
    }

    public String getValor(){
        return this.valor;
    }

    public void setValor(String valor){
        this.valor = valor;
        this.preenchido = true;
    }

    public boolean getObrigatorio(){
        return this.obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio){
        this.obrigatorio = obrigatorio;
    }

    public boolean isPreenchido(){
        if (!getValor().equals("")){
            return true;
        }
        return false;
    }

    public boolean isObrigatorio(){
        return this.obrigatorio;
    }

    public void setValidador(ValidadorCampo validador){
        this.validador = validador;
    }

    
    public Resultado validar(){
        if(this.obrigatorio == true && !this.preenchido){
            return new Resultado (true, this.getId() + " é obrigatório e não foi preenchido");

        }
        if(!this.preenchido){
            return new Resultado();
        }
        return this.validador.validarCampo(this.valor);
    }

  
  

   

}
  
    
    

