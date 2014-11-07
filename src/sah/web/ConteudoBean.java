package sah.web;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

@ManagedBean(name="conteudoBean") 
@RequestScoped
public class ConteudoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1805344705323361384L;
	
	private TabView tabView; 
    private int tabRemove;
  
    public void adicionaTab(String nome, String url) {  
        Tab tab = new Tab();  
  
        tab.setTitle(nome);  
        tab.setClosable(true);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();    
        FaceletContext faceletContext = (FaceletContext) facesContext.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);    
            
        try {  
            faceletContext.includeFacelet(tab, url);    
        } catch (IOException e) {  
            e.printStackTrace();   
        }  
          
        tabView.getChildren().add(tab);  
    }


	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

	public int getTabRemove() {
		return tabRemove;
	}


	public void setTabRemove(int tabRemove) {
		this.tabRemove = tabRemove;
	}
    
    

}
