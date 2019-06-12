package com.pene.ui.facturi;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.FacturiStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = FacturiLayoutFactory.Name, ui = PnePayMainUI.class)
public class FacturiLayoutFactory extends VerticalLayout implements View, FacturiSavedListener {

	public static final String Name = "adaugafactura";

	@Autowired
	private AddFacturaMainLayoutFactory mainLayoutFactory;

	@Autowired
	private AfisareFacturiLayoutFactory afisareFacturiLayoutFactory;
	private TabSheet tabSheet;

	private void addLayout() {
		setMargin(true);

		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");

		Component adaugaFacturaMainTab = mainLayoutFactory.createComponent(this);
		Component afiseazaFacturaTab = afisareFacturiLayoutFactory.createComponent();

		tabSheet.addTab(adaugaFacturaMainTab, FacturiStringUtils.MENIU.getString());
		tabSheet.addTab(afiseazaFacturaTab, FacturiStringUtils.AFISEAZA_FACTURI.getString());

		addComponent(tabSheet);

	}

	public void facturiSaved() {
		afisareFacturiLayoutFactory.refreshTable();
	}

	public void enter(ViewChangeEvent event) {

		removeAllComponents();
		addLayout();
	}

}
