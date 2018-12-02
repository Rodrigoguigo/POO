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
    private ArrayList<Pedido> clPedidos = new ArrayList<>();
    private static int cont=0;

    public ArrayList<Pedido> getClPedidos() {
        return clPedidos;
    }

    public void setClPedidos(ArrayList<Pedido> clPedidos) {
        this.clPedidos = clPedidos;
    }
    
    

    public Cliente()
    {
        id = cont++;
    }
    
    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Cliente{" + "id= " + id + " , nome= " + nome + " }";
    }

    
    
    
    
}
