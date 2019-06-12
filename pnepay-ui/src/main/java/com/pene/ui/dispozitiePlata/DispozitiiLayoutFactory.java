package com.pene.ui.dispozitiePlata;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.DispozitiePlataStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import aj.org.objectweb.asm.Label;

@SpringView(name = DispozitiiLayoutFactory.Name, ui = PnePayMainUI.class)
public class DispozitiiLayoutFactory extends VerticalLayout implements View, DispozitiePlataSavedListener {

	public static final String Name = "adaugadispozitiedeplata";

	@Autowired
	private AddDispozitiePlataMainLayoutFactory adaugaDispozitiePlataLayoutFactory;

	@Autowired
	private AfisareDispozitiiLayoutFactory afisareDispozitiiLayoutFactory;
	private TabSheet tabSheet;

	private void addLayout() {
		setMargin(true);

		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");

		Component adaugaDispozitieMainTab = adaugaDispozitiePlataLayoutFactory.createComponent(this);
		Component afiseazaDispozitieTab = afisareDispozitiiLayoutFactory.createComponent();

		tabSheet.addTab(adaugaDispozitieMainTab, DispozitiePlataStringUtils.MENIU.getString());
		tabSheet.addTab(afiseazaDispozitieTab, DispozitiePlataStringUtils.AFISEAZA_DISPOZITIE.getString());

		addComponent(tabSheet);

	}

	public void dispozitieSaved() {
		afisareDispozitiiLayoutFactory.refreshTable();
	}

	public void enter(ViewChangeEvent event) {

		removeAllComponents();
		addLayout();
	}


}




