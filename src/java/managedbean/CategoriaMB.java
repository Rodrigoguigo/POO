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
import modelo.Categoria;
import org.primefaces.event.CellEditEvent;
import servico.CategoriaServico;

/**
 *
 * @author gutao
 */
@ManagedBean
@SessionScoped
public class CategoriaMB {
    private Categoria categoria = new Categoria();
    private CategoriaServico servico = new CategoriaServico();
    private List<Categoria> filteredCategoria = servico.gatAllCategorias();
    private Categoria selectedCategoria;

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.categoria = Categoria;
    }

    public CategoriaServico getServico() {
        return servico;
    }

    public void setServico(CategoriaServico servico) {
        this.servico = servico;
    }

    public List<Categoria> getFilteredCategoria() {
        return filteredCategoria;
    }

    public void setFilteredCategoria(List<Categoria> filteredCategoria) {
        this.filteredCategoria = filteredCategoria;
    }
    
    public void salvar ()
    {
        servico.salvar(categoria);
        categoria= new Categoria();
        filteredCategoria = servico.gatAllCategorias();
    }
    
    public List<Categoria> getCategorias ()    {
        return servico.gatAllCategorias();
        
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
 
