/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gutao
 */
public class Pedido {
    private long numero;
    private Date data;
    private ArrayList<ItemPedido> itens;
    private Cliente cliente;
    private long cont;
    
    public Pedido()
    {
        numero = cont++;
    }
    
    double totalPedido()
    {
        double sum = 0;
        for(ItemPedido item : itens)
        {
            sum+= item.totalItem();
        }
        return sum;
    }
    
    double totalImposto()
    {
        double sum = 0;
        for(ItemPedido item : itens)
        {
            sum+= item.getProduto().getImposto();
        }
        return sum;      
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
