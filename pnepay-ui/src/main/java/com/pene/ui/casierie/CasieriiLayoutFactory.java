package com.pene.ui.casierie;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.CasierieStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import aj.org.objectweb.asm.Label;

@SpringView(name = CasieriiLayoutFactory.Name, ui = PnePayMainUI.class)
public class CasieriiLayoutFactory extends VerticalLayout implements View, CasierieSavedListener {

	public static final String Name = "adaugacasierie";

	@Autowired
	private AddCasierieMainLayoutFactory adaugaCasierieLayoutFactory;

	@Autowired
	private AfisareCasieriiLayoutFactory afisareCasieriiLayoutFactory;
	private TabSheet tabSheet;

	private void addLayout() {
		setMargin(true);

		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");

		Component adaugaCasierieMainTab = adaugaCasierieLayoutFactory.createComponent(this);
		Component afiseazaCasierieTab = afisareCasieriiLayoutFactory.createComponent();

		tabSheet.addTab(adaugaCasierieMainTab, CasierieStringUtils.MENIU.getString());
		tabSheet.addTab(afiseazaCasierieTab, CasierieStringUtils.AFISEAZA_CASIERIE.getString());

		addComponent(tabSheet);

	}

	public void casierieSaved() {
		afisareCasieriiLayoutFactory.refreshTable();
	}

	public void enter(ViewChangeEvent event) {

		removeAllComponents();
		addLayout();
	}
}




