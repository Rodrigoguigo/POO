/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 171071
 */
public class Cliente {
    private int id;
    private String nome;
     private String endereco;
    private String telefone;
    private int status;
    private double limite;
    private ArrayList<Pedido> itens = new ArrayList<>();
    private static int cont=0;

    public ArrayList<Pedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Pedido> itens) {
        this.itens = itens;
    }
    
    

    public Cliente()
    {
        id = cont++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    
    
    
}
