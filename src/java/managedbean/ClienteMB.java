/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import servico.ClienteServico;

/**
 *
 * @author 171071
 */
@ManagedBean
@SessionScoped
public class ClienteMB  {
    private Cliente cliente = new Cliente();
    private ClienteServico servico = new ClienteServico();
    private List<Cliente> filteredCliente = servico.gatAllClientes();
    private Cliente selectedCliente;

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteServico getServico() {
        return servico;
    }

    public void setServico(ClienteServico servico) {
        this.servico = servico;
    }

    public List<Cliente> getFilteredCliente() {
        return filteredCliente;
    }

    public void setFilteredCliente(List<Cliente> filteredCliente) {
        this.filteredCliente = filteredCliente;
    }
    
    public void salvar ()
    {
        servico.salvar(cliente);
        cliente= new Cliente();
        filteredCliente = servico.gatAllClientes();
    }
    
    public List<Cliente> getClientes ()    {
        return servico.gatAllClientes();
        
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void removeFromList()
    {
        servico.remover(selectedCliente);
        filteredCliente.remove(selectedCliente);
        selectedCliente = null;
    }
    
}
