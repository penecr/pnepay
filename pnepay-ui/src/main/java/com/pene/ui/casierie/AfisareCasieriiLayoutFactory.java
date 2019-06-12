
package com.pene.ui.casierie;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Casierie;
import com.pene.service.showallcasierii.ShowAllCasieriiService;
import com.pene.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class AfisareCasieriiLayoutFactory implements UIComponentBuilder {

	private List<Casierie> casierii;
	private BeanItemContainer<Casierie> container;
	private Column column;
	
	@Autowired
	private ShowAllCasieriiService showAllCasieriiService;
	
	private class AfisareCasieriiLayout extends VerticalLayout {
		
		private Grid casieriiTable;
		
		public AfisareCasieriiLayout init() {
			
			setMargin(true);
			container=new BeanItemContainer<Casierie>(Casierie.class, casierii);
			
			casieriiTable=new Grid(container);
			casieriiTable.setColumnOrder("numeCasier","denumireCasierie","punctLucru","valutaCasierie");
			casieriiTable.removeColumn("idCasierie");
			casieriiTable.setImmediate(true);
			return this;
		}
		
		public AfisareCasieriiLayout layout(){
			addComponent(casieriiTable);
			casieriiTable.setWidth("100%");
			return this;
		}
		
		public AfisareCasieriiLayout load(){
			casierii= showAllCasieriiService.getAllCasierii();
			return this;
		}
		
	
	
	}
	
	
	public void refreshTable() {
		casierii= showAllCasieriiService.getAllCasierii();
		container.removeAllItems();
		container.addAll(casierii);
		
	}
	
	
	public Component createComponent() {
		return new AfisareCasieriiLayout().load().init().layout();
	}

	



	



}

