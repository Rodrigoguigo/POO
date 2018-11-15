
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author 171071
 */
public class ClienteServico {
    private ArrayList <Cliente> clientes = Dados.LISTA_CLIENTE;
    
    
    public void salvar(Cliente c)
    {
        clientes.add(c);
    }
    
    public ArrayList<Cliente> gatAllClientes()
    {
        return clientes;
    }
    
    public void remover(Cliente rm)
    {
        clientes.remove(rm);
    }
    
}
