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
import modelo.ProdutoExportacao;
import org.primefaces.event.CellEditEvent;
import servico.ProdutoExportServico;
import servico.ProdutoServico;

/**
 *
 * @author gutao
 */
@ManagedBean
@SessionScoped
public class ProdutoExportacaoMB {
    private ProdutoExportacao produtoExportacao = new ProdutoExportacao();
    private ProdutoExportServico servico = new ProdutoExportServico();
    private List<ProdutoExportacao> filteredProdutoExportacao = servico.getAllProdutosExportacao();
    private ProdutoExportacao selectedProdutoExportacao;
    private ProdutoServico ajuda = new ProdutoServico();

    public ProdutoExportacao getProdutoExportacao() {
        return produtoExportacao;
    }

    public void setProdutoExportacao(ProdutoExportacao produtoExportacao) {
        this.produtoExportacao = produtoExportacao;
    }

    public List<ProdutoExportacao> getFilteredProdutoExportacao() {
        return filteredProdutoExportacao;
    }

    public void setFilteredProdutoExportacao(List<ProdutoExportacao> filteredProdutoExportacao) {
        this.filteredProdutoExportacao = filteredProdutoExportacao;
    }

    public ProdutoExportacao getSelectedProdutoExportacao() {
        return selectedProdutoExportacao;
    }

    public void setSelectedProdutoExportacao(ProdutoExportacao selectedProdutoExportacao) {
        this.selectedProdutoExportacao = selectedProdutoExportacao;
    }
    
    public void salvar ()
    {
        servico.salvar(produtoExportacao);
        ajuda.getAllProdutos().add(produtoExportacao);
        produtoExportacao= new ProdutoExportacao();
        filteredProdutoExportacao = servico.getAllProdutosExportacao();
        
    }
    
    public List<ProdutoExportacao> getProdutosExportacao ()    {
        return servico.getAllProdutosExportacao();
        
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
        servico.remover(selectedProdutoExportacao);
        filteredProdutoExportacao.remove(selectedProdutoExportacao);
        ajuda.getAllProdutos().remove(selectedProdutoExportacao);
        selectedProdutoExportacao = null;
    }
}
