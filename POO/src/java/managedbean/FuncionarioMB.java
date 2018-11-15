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
import modelo.Funcionario;
import org.primefaces.event.RowEditEvent;
import servico.FuncionarioService;

/**
 *
 * @author glauc
 */
@ManagedBean
@SessionScoped
public class FuncionarioMB {
    private FuncionarioService servico = new 
         FuncionarioService();
    private Funcionario func = new Funcionario();
    private Funcionario selectedFunc;

    public Funcionario getSelectedFunc() {
        return selectedFunc;
    }

    public void setSelectedFunc(Funcionario selectedFunc) {
        this.selectedFunc = selectedFunc;
    }
    
    public void removeFuncionario(Funcionario func){
        servico.removerFuncionario(func);
    }
    
    public void removeSelected(){
        servico.removerFuncionario(selectedFunc);
        selectedFunc = null;
    }
    
    public void onRowEdit(RowEditEvent event) {
       FacesMessage msg = new FacesMessage("Funcionário Editado", ((Funcionario) event.getObject()).getNome());
       FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void salvar(){
        servico.salvar(func);
        func = new Funcionario();
    }
    
    public List<Funcionario> getFuncionarios(){
        return servico.getFuncionarios();
    }
    
    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }
    
    
    
}
