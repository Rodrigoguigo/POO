/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.ProdutoExportacao;

/**
 *
 * @author gutao
 */
public class ProdutoExportServico {
    private ArrayList <ProdutoExportacao> produtosExportacao = Dados.LISTA_PRODUTOE;
    
    
    public void salvar(ProdutoExportacao c)
    {
        produtosExportacao.add(c);
    }
    
    public ArrayList<ProdutoExportacao> getAllProdutosExportacao()
    {
        return produtosExportacao;
    }
    
    public void remover(ProdutoExportacao rm)
    {
        produtosExportacao.remove(rm);
    }
}
