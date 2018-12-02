/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import servico.ClienteServico;
import servico.Dados;
import servico.ProdutoServico;

/**
 *
 * @author gutao
 */
@ManagedBean
@SessionScoped
public class PedidoItemMB {
    private ArrayList<Pedido> clientePedido = new ArrayList();
    private ArrayList<Pedido> pedidosCompleto = new ArrayList();
    private Pedido pedido = new Pedido();
    private String aux = "";
    private Pedido selectedPedido;
    private ArrayList<Pedido> filteredPedido = pedidosCompleto;
    private ClienteServico servico = new ClienteServico();
    private ArrayList<Cliente> fullCliente =   servico.gatAllClientes();
    private String nomeProd;
    private int qtProd;

    public int getQtProd() {
        return qtProd;
    }

    public void setQtProd(int qtProd) {
        this.qtProd = qtProd;
    }
    
    
    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }    
    
    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }
    
    
    
    public ArrayList<Pedido> getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(ArrayList<Pedido> clientePedido) {
        this.clientePedido = clientePedido;
    }

    public ArrayList<Pedido> getPedidosCompleto() {
        return pedidosCompleto;
    }

    public void setPedidosCompleto(ArrayList<Pedido> pedidosCompleto) {
        this.pedidosCompleto = pedidosCompleto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(Pedido selectedPedido) {
        this.selectedPedido = selectedPedido;
    }

    public ArrayList<Pedido> getFilteredPedido() {
        return filteredPedido;
    }

    public void setFilteredPedido(ArrayList<Pedido> filteredPedido) {
        this.filteredPedido = filteredPedido;
    }
    
    public void salvar()
    {
        String value = aux.split(" ")[1];
        for (Cliente selec: fullCliente )
        {
            if(selec.getId() == Integer.parseInt(value))
            {
                pedido.setCliente(selec);
                break;
            }
        }
        
        pedido.setData(new Date());
        pedido.getCliente().getClPedidos().add(pedido);
        pedidosCompleto.add(pedido);
        filteredPedido = pedidosCompleto;
        pedido = new Pedido();                
    }
    
    public String qtItem(Pedido pd)
    {
        return Integer.toString(pd.qtItens());
    }
    
    public void removePedidoFromList()
    {
        pedidosCompleto.remove(selectedPedido);
        selectedPedido.getCliente().getClPedidos().remove(selectedPedido);
        filteredPedido.remove(selectedPedido);
        selectedPedido = null;
    }
    
    public void onChangeList()
    {
        if(aux == null || aux.equals(""))
        {
            clientePedido = pedidosCompleto;
        }
        else
        {
            String value = aux.split(" ")[1];
            for (Cliente selec: fullCliente )
            {
                if(selec.getId() == Integer.parseInt(value))
                {
                    clientePedido = selec.getClPedidos();
                }
            }
        }
    }
    
    public void arrumarItem(int qt,String prod)
    {
        String valor = prod.split(" ")[1];
        Produto aux = null;
        for(Produto tone : new ProdutoServico().getAllProdutos())
        {
            if(tone.getId() == Integer.parseInt(valor))
            {
                aux = tone;
            }
        }
        for(Pedido adProd : pedidosCompleto)
        {
            if(adProd.isAddItem() && aux != null)
            {
                adProd.criarItem(qt, aux);
            }
        }
    }
    
    public void delItem(String completa)
    {
        String valor = completa.split(" ")[3];
        selectedPedido.removeItem(valor);
    }
    
}
