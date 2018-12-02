/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import servico.ProdutoServico;

/**
 *
 * @author gutao
 */
public class Pedido {
    private long numero;
    private Date data;
    private ArrayList<ItemPedido> itens = new ArrayList();
    private Cliente cliente;
    private static long cont = 0;
    private boolean addItem = false;
    private ArrayList<String> descricaoItem = new ArrayList();
    private double totalP;
    private double totalI;
    private int qt;
    
    public Pedido()
    {
        numero = cont++;
    }
    
    public double totalPedido()
    {
        double sum = 0;
        for(ItemPedido item : itens)
        {
            sum+= item.totalItem();
        }
        return sum;
    }
    
    public double totalImposto()
    {
        double sum = 0;
        for(ItemPedido item : itens)
        {
            sum+= item.getProduto().getImposto()*item.getQuantidade();
        }
        return sum;      
    }

    public ArrayList<String> getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(ArrayList<String> descricaoItem) {
        this.descricaoItem = descricaoItem;
    }
    
    

    public boolean isAddItem() {
        return addItem;
    }

    public void setAddItem(boolean addItem) {
        this.addItem = addItem;
    }
    
    public ArrayList<String> checarItens()
    {
        ArrayList<String> descricao = new ArrayList<>();
        for(ItemPedido item : itens)
        {
            descricao.add(item.toString());
        }
        //montar string unica e adicionar deleção.
        return descricao;
    }   
    
    public int qtItens()
    {
        return itens.size();
    }
    
    public void removeItem (String valor)
    {
        for(ItemPedido item : itens)
        {
            if(item.getCod() == Integer.parseInt(valor))
            {
                descricaoItem.remove(itens.indexOf(item));
                itens.remove(item);               
                break;
            }
        }
    }
    
    public long getNumero() {
        return numero;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     public void criarItem(int qt,Produto prod)
    {
        
        ItemPedido aux = new ItemPedido(qt,prod);
        itens.add(aux);
        descricaoItem.add(aux.toString());
        
    }
    
}
