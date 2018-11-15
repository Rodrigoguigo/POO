/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.ProdutoExportacao;
import modelo.ProdutoMercadoInterno;

/**
 *
 * @author glauc
 */
public class Dados {
    
    public static final ArrayList<Funcionario> LISTA_FUNCIONARIOS = new ArrayList();
    public static final ArrayList<Cliente> LISTA_CLIENTE = new ArrayList();
    public static final ArrayList<Produto> LISTA_PRODUTO = new ArrayList();
    public static final ArrayList<Categoria> LISTA_CATEGORIA = new ArrayList();
    public static final ArrayList<ProdutoMercadoInterno> LISTA_PRODUTOMI = new ArrayList();
    public static final ArrayList<ProdutoExportacao> LISTA_PRODUTOE = new ArrayList();
}
