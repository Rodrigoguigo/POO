/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.ProdutoMercadoInterno;

/**
 *
 * @author gutao
 */
public class ProdutoInternoServico {
    private ArrayList <ProdutoMercadoInterno> produtosInternos = Dados.LISTA_PRODUTOMI;
    
    
    public void salvar(ProdutoMercadoInterno c)
    {
        produtosInternos.add(c);
    }
    
    public ArrayList<ProdutoMercadoInterno> getAllProdutosInternos()
    {
        return produtosInternos;
    }
    
    public void remover(ProdutoMercadoInterno rm)
    {
        produtosInternos.remove(rm);
    }
}
