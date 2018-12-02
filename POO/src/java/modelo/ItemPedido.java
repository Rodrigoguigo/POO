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
public class ItemPedido {
    private int cod;
    private int quantidade;
    private Produto produto;
    private static int cont;

    public ItemPedido()
    {
        cod = cont++;
    }
    
    public ItemPedido(int qt, Produto prod)
    {
        quantidade = qt;
        produto = prod;
        cod = cont++;
    }
    
    double totalItem()
    {
        return quantidade*produto.getPreco();
    }
    
    
    public int getCod() {
        return cod;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Item de " + "ID= " + cod +
                " com " + quantidade + 
                ", produtos de nome" + produto.getNome()+
                " dando um total de R$ "+ totalItem();
    }
    
    
  
  
}
