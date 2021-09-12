package br.ufpb.dcx.aps.strategy.form;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class Formulario {

    private String titulo;
    private Map<String, ItemFormulario> formularios = new LinkedHashMap<>();

    public Formulario() {
        this.titulo = "";
    }

    public Formulario(String titulo) {
        this.titulo = titulo;
    }

    public void addItemFormulario(ItemFormulario itemFormulario) {
        if (!formularios.containsKey(itemFormulario.getId())) {
            formularios.put(itemFormulario.getId(), itemFormulario);

        } else {
            throw new RuntimeException("'" + itemFormulario.getId() + "' já existe");
        }

    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ItemFormulario getItemFormulario(String id) {
        if (formularios.containsKey(id)) {
            return formularios.get(id);
        } else {
            throw new IllegalArgumentException("Não existe campo com esse id");

        }

    }

    public Collection<ItemFormulario> getItemFormulario() {
        return formularios.values();
    }

    public Resultado validar() {
        Resultado resultado = new Resultado();
        for (ItemFormulario i : formularios.values()) {
            if (i.validar().getMensagens().isEmpty() == false) {
                resultado.setErro(true);
                
            resultado.addMensagem(i.getId() + ": " + i.validar().getMensagemSimples());
            }
        }
        return resultado;
    }

}
