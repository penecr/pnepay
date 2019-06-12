package com.pene.ui.furnizori;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.ui.facturi.AfisareFacturiLayoutFactory;
import com.pene.utils.FacturiStringUtils;
import com.pene.utils.FurnizoriStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = FurnizoriLayoutFactory.Name, ui = PnePayMainUI.class)
public class FurnizoriLayoutFactory extends VerticalLayout implements View, FurnizoriSavedListener {

	public static final String Name = "adaugafurnizor";

	

	@Autowired
	private AdaugaFurnizorLayoutFactory adaugaFurnizorLayoutFactory;
	
	@Autowired
	private AfisareFurnizoriLayoutFactory afisareFurnizoriLayoutFactory;
	private TabSheet tabSheet;
	
	private void addLayout() {
		
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addFurnizoriTab= adaugaFurnizorLayoutFactory.createComponent(this);
		Component showAllFurnizoriTab= afisareFurnizoriLayoutFactory.createComponent();
		Component showStatistics = new Label("Statistici");
		
		tabSheet.addTab(addFurnizoriTab, FurnizoriStringUtils.MENIU.getString());
		tabSheet.addTab(showAllFurnizoriTab, FurnizoriStringUtils.AFISEAZA_FURNIZORI.getString());
		tabSheet.addTab(showStatistics, FurnizoriStringUtils.STATISTICI.getString());
		
		addComponent(tabSheet);
	}
	public void furnizoriSaved() {
		afisareFurnizoriLayoutFactory.refreshTable();
	}

	public void enter(ViewChangeEvent event) {

		removeAllComponents();
		addLayout();
	}

}
