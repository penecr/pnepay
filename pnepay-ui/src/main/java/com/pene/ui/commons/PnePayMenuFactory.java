package com.pene.ui.commons;

import org.springframework.security.core.context.SecurityContextHolder;

import com.pene.navigator.PnePayNavigator;
import com.pene.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class PnePayMenuFactory implements UIComponentBuilder {

	private class PnePayMenu extends VerticalLayout implements Property.ValueChangeListener {
		private Tree mainMenu;
		
		public PnePayMenu init(){
			
			mainMenu=new Tree();
			mainMenu.addValueChangeListener(this);
			
			return this;
		}
		
		public PnePayMenu layout() {
			
			setWidth("100%");
			setHeightUndefined();
			
			mainMenu.addItem(StringUtils.MENU_FACTURI.getString());
			mainMenu.addItem((StringUtils.MENU_FURNIZORI.getString()));
			mainMenu.addItem((StringUtils.MENU_CASIERIE.getString()));
			mainMenu.addItem((StringUtils.MENU_DISPOZITIE_PLATA.getString()));
			mainMenu.addItem("DECONECTARE");
			
			
			mainMenu.expandItem(StringUtils.MENU_FACTURI.getString());
			mainMenu.expandItem((StringUtils.MENU_FURNIZORI.getString()));
			mainMenu.expandItem((StringUtils.MENU_CASIERIE.getString()));
			mainMenu.expandItem((StringUtils.MENU_DISPOZITIE_PLATA.getString()));
			mainMenu.expandItem("DECONECTARE");
			
			mainMenu.addItem(StringUtils.MENU_ADAUGA_FACTURA.getString());
			mainMenu.addItem(StringUtils.MENU_STERGE_FACTURA.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADAUGA_FACTURA.getString(), false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_STERGE_FACTURA.getString(), false);
			mainMenu.setParent(StringUtils.MENU_ADAUGA_FACTURA.getString(), (StringUtils.MENU_FACTURI.getString()));
			mainMenu.setParent(StringUtils.MENU_STERGE_FACTURA.getString(), (StringUtils.MENU_FACTURI.getString()));
			
			mainMenu.addItem("Deconectare");
			mainMenu.setParent("Deconectare", "DECONECTARE");
			mainMenu.setChildrenAllowed("Logout",false);
			mainMenu.addItem(StringUtils.MENU_ADAUGA_FURNIZOR.getString());
			mainMenu.addItem(StringUtils.MENU_STERGE_FURNIZOR.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADAUGA_FURNIZOR.getString(), false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_STERGE_FURNIZOR.getString(), false);
			mainMenu.setParent(StringUtils.MENU_ADAUGA_FURNIZOR.getString(), (StringUtils.MENU_FURNIZORI.getString()));
			mainMenu.setParent(StringUtils.MENU_STERGE_FURNIZOR.getString(), (StringUtils.MENU_FURNIZORI.getString()));
			
			mainMenu.addItem(StringUtils.MENU_ADAUGA_CASIERIE.getString());
			mainMenu.addItem(StringUtils.MENU_STERGE_CASIERIE.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADAUGA_CASIERIE.getString(), false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_STERGE_CASIERIE.getString(), false);
			mainMenu.setParent(StringUtils.MENU_ADAUGA_CASIERIE.getString(), (StringUtils.MENU_CASIERIE.getString()));
			mainMenu.setParent(StringUtils.MENU_STERGE_CASIERIE.getString(), (StringUtils.MENU_CASIERIE.getString()));
			
			mainMenu.addItem(StringUtils.MENU_ADAUGA_DISPOZITIE_PLATA.getString());
			mainMenu.addItem(StringUtils.MENU_STERGE_DISPOZITIE_PLATA.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADAUGA_DISPOZITIE_PLATA.getString(), false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_STERGE_DISPOZITIE_PLATA.getString(), false);
			mainMenu.setParent(StringUtils.MENU_ADAUGA_DISPOZITIE_PLATA.getString(), (StringUtils.MENU_DISPOZITIE_PLATA.getString()));
			mainMenu.setParent(StringUtils.MENU_STERGE_DISPOZITIE_PLATA.getString(), (StringUtils.MENU_DISPOZITIE_PLATA.getString()));
			
			
			
			addComponent(mainMenu);
			return this;
			
		}

		public void valueChange(ValueChangeEvent event) {
		 String selectedItemPath= (String) event.getProperty().getValue();
		 
		 if(selectedItemPath==null) return;
		 if(selectedItemPath.equals("Deconectare")) {
			 SecurityContextHolder.clearContext();
			 UI.getCurrent().getPage().setLocation("/pnepay-web-1.3.6.RELEASE/login");
		 }
		 String path= selectedItemPath.toLowerCase().replaceAll("\\s+","");
		 PnePayNavigator.navigate(path);
			
		}
	}
	public Component createComponent() {
		return new  PnePayMenu().init().layout();
	}

}
