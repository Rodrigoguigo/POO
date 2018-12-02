/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gutao
 */
public class Categoria {
    private String descricao;
    private int id;
    private static int cont;
    
    public Categoria()
    {
        id = cont++;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  descricao;
    }
    
    
    
}
