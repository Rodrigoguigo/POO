/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;
import modelo.Produto;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import servico.ProdutoServico;
import servico.ProdutoServico;

/**
 *
 * @author 171071
 */
@ManagedBean
@SessionScoped
public class ProdutoMB {
    private Produto produto = new Produto();
    private ProdutoServico servico = new ProdutoServico();
    private List<Produto> filteredProduto = servico.getAllProdutos();
    private Produto selectedProduto;


    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto Produto) {
        this.produto = Produto;
    }

    public ProdutoServico getServico() {
        return servico;
    }

    public void setServico(ProdutoServico servico) {
        this.servico = servico;
    }

    public List<Produto> getFilteredProduto() {
        return filteredProduto;
    }

    public void setFilteredProduto(List<Produto> filteredProduto) {
        this.filteredProduto = filteredProduto;
    }
    
    public void salvar ()
    {
        servico.salvar(produto);
        produto= new Produto();
        filteredProduto = servico.getAllProdutos();
    }
    
    public List<Produto> getProdutos ()    {
        return servico.getAllProdutos();
        
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
        servico.remover(selectedProduto);
        filteredProduto.remove(selectedProduto);
        selectedProduto = null;
    }
    
}
