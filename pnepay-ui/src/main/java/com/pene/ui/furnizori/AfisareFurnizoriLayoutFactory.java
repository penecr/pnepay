package com.pene.ui.furnizori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Furnizor;
import com.pene.ui.commons.UIComponentBuilder;
import com.pene.service.showallfurnizori.ShowAllFurnizoriService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class AfisareFurnizoriLayoutFactory implements UIComponentBuilder {

	private List<Furnizor> furnizori;
	private BeanItemContainer<Furnizor> container;

	@Autowired
	private ShowAllFurnizoriService showAllFurnizoriService;

	private class AfiseazaFurnizoriLayout extends VerticalLayout {

		private Grid furnizoriTable;

		public AfiseazaFurnizoriLayout init() {

			setMargin(true);
			container = new BeanItemContainer<Furnizor>(Furnizor.class, furnizori);

			furnizoriTable = new Grid(container);

			furnizoriTable.setColumnOrder("cif", "denumireFurnizor", "ibanFurnizor", "tipFurnizor", "bancaFurnizor",
					"persoanaContact", "emailPersoana");
			furnizoriTable.removeColumn("id");
			furnizoriTable.setImmediate(true);

			return this;
		}

		public AfiseazaFurnizoriLayout load() {
			furnizori = showAllFurnizoriService.getAllFurnizori();
			return this;
		}

		public AfiseazaFurnizoriLayout layout() {

			addComponent(furnizoriTable);
			furnizoriTable.setWidth("100%");
			return this;
		}

	}

	public void refreshTable() {
		furnizori = showAllFurnizoriService.getAllFurnizori();
		container.removeAllItems();
		container.addAll(furnizori);

	}

	public Component createComponent() {
		return new AfiseazaFurnizoriLayout().load().init().layout();
	}

}
