
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author 171071
 */
public class ProdutoServico {
    private ArrayList <Produto> produtos = Dados.LISTA_PRODUTO;
    
    
    public void salvar(Produto c)
    {
        produtos.add(c);
    }
    
    public ArrayList<Produto> getAllProdutos()
    {
        return produtos;
    }
    
    public void remover(Produto rm)
    {
        produtos.remove(rm);
    }
    
}
