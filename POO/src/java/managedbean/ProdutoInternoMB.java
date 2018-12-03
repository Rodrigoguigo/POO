/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.ProdutoMercadoInterno;
import org.primefaces.event.CellEditEvent;
import servico.ProdutoInternoServico;
import servico.ProdutoServico;

/**
 *
 * @author gutao
 */
@ManagedBean
@SessionScoped
public class ProdutoInternoMB {
    private ProdutoMercadoInterno produtoInterno = new ProdutoMercadoInterno();
    private ProdutoInternoServico servico = new ProdutoInternoServico();
    private List<ProdutoMercadoInterno> filteredProdutoInterno = servico.getAllProdutosInternos();
    private ProdutoMercadoInterno selectedProdutoInterno;
    private ProdutoServico ajuda = new ProdutoServico();

    public ProdutoMercadoInterno getProdutoInterno() {
        return produtoInterno;
    }

    public void setProdutoInterno(ProdutoMercadoInterno produtoInterno) {
        this.produtoInterno = produtoInterno;
    }

    public List<ProdutoMercadoInterno> getFilteredProdutoInterno() {
        return filteredProdutoInterno;
    }

    public void setFilteredProdutoInterno(List<ProdutoMercadoInterno> filteredProduto) {
        this.filteredProdutoInterno = filteredProduto;
    }

    public ProdutoMercadoInterno getSelectedProdutoInterno() {
        return selectedProdutoInterno;
    }

    public void setSelectedProdutoInterno(ProdutoMercadoInterno selectedProdutoInterno) {
        this.selectedProdutoInterno = selectedProdutoInterno;
    }
    
    public void salvar ()
    {
        servico.salvar(produtoInterno);
        ajuda.getAllProdutos().add(produtoInterno);
        produtoInterno= new ProdutoMercadoInterno();
        filteredProdutoInterno = servico.getAllProdutosInternos();
       
        
    }
    
    public List<ProdutoMercadoInterno> getProdutosInternos ()    {
        return servico.getAllProdutosInternos();
        
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void onChangeIncentivo(){
        boolean value = selectedProdutoInterno.isIncentivo();
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + value + ", New:" + !value);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void removeFromList()
    {
        servico.remover(selectedProdutoInterno);
        filteredProdutoInterno.remove(selectedProdutoInterno);
        ajuda.getAllProdutos().remove(selectedProdutoInterno);
        selectedProdutoInterno = null;
    }
}
