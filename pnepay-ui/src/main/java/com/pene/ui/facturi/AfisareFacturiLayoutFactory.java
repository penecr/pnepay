package com.pene.ui.facturi;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Factura;
import com.pene.model.entity.facturaDTO;
import com.pene.service.showallfacturi.ShowAllFacturiService;
import com.pene.service.showallfurnizori.ShowAllFurnizoriService;
import com.pene.ui.commons.UIComponentBuilder;
import com.pene.utils.FacturiStringUtils;
import com.pene.utils.StringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.DateRenderer;
import com.vaadin.ui.renderers.Renderer;

@org.springframework.stereotype.Component
public class AfisareFacturiLayoutFactory implements UIComponentBuilder {

	private List<facturaDTO> facturi;
	private BeanItemContainer<facturaDTO> container;
	
	@Autowired
	private ShowAllFacturiService showAllFacturiService;
	
	private class AfiseazaFacturiLayout extends VerticalLayout {
		
		private Grid facturiTable;
		
		public AfiseazaFacturiLayout init() {
			
			setMargin(true);
			container=new BeanItemContainer<facturaDTO>(facturaDTO.class, facturi);
			
			facturiTable=new Grid(container);
			facturiTable.setColumnOrder("dataEmiterii", "dataScadenta","totalFactura","descriereFactura","furnizor");
			
			
			
			
			facturiTable.getColumn("dataEmiterii").setRenderer((Renderer) new DateRenderer("%1$td/%1$tm/%1$tY"));
			facturiTable.getColumn("dataScadenta").setRenderer((Renderer) new DateRenderer("%1$td/%1$tm/%1$tY"));
		
		

			facturiTable.setImmediate(true);
			
			
			return this;
		}
		
		public AfiseazaFacturiLayout load(){
			facturi= showAllFacturiService.getAllFacturi();
			return this;
		}
		
	public AfiseazaFacturiLayout layout(){
			addComponent(facturiTable);
			facturiTable.setWidth("100%");
			return this;
		}
	
	}
	
	
	public void refreshTable() {
		facturi= showAllFacturiService.getAllFacturi();
		container.removeAllItems();
		container.addAll(facturi);
		
	}
	
	
	public Component createComponent() {
		return new AfiseazaFacturiLayout().load().init().layout();
	}

	



	



}
