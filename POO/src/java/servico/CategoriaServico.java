/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author gutao
 */
public class CategoriaServico {
    private ArrayList<Categoria> categorias = Dados.LISTA_CATEGORIA;
    
    
    public void salvar(Categoria c)
    {
        categorias.add(c);
    }
    
    public ArrayList<Categoria> gatAllCategorias()
    {
        return categorias;
    }
    
    public void remover(Categoria rm)
    {
        categorias.remove(rm);
    }
    
    
}
