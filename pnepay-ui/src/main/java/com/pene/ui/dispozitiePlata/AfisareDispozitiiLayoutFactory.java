
package com.pene.ui.dispozitiePlata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Casierie;
import com.pene.model.entity.DispozitiePlata;
import com.pene.service.showallcasierii.ShowAllCasieriiService;
import com.pene.service.showalldispozitii.ShowAllDispozitiiService;
import com.pene.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.DateRenderer;
import com.vaadin.ui.renderers.Renderer;

@org.springframework.stereotype.Component
public class AfisareDispozitiiLayoutFactory implements UIComponentBuilder {

	private List<DispozitiePlata> dispozitii;
	private BeanItemContainer<DispozitiePlata> container;

	@Autowired
	private ShowAllDispozitiiService showAllDispozitiiService;

	private class AfisareDispozitiiLayout extends VerticalLayout {

		private Grid dispozitiiTable;

		public AfisareDispozitiiLayout init() {

			setMargin(true);
			container = new BeanItemContainer<DispozitiePlata>(DispozitiePlata.class, dispozitii);

			dispozitiiTable = new Grid(container);
			dispozitiiTable.setColumnOrder("dataDispozitie", "nume", "serieBuletin", "functie", "scopPlata","sumaPlatita","valuta");
			dispozitiiTable.removeColumn("id");
			dispozitiiTable.removeColumn("casierie");

			dispozitiiTable.getColumn("dataDispozitie").setRenderer((Renderer) new DateRenderer("%1$td/%1$tm/%1$tY"));

			dispozitiiTable.setImmediate(true);

			return this;
		}

		public AfisareDispozitiiLayout load() {
			dispozitii = showAllDispozitiiService.getAllDispozitii();
			return this;
		}

		public AfisareDispozitiiLayout layout() {
			addComponent(dispozitiiTable);
			dispozitiiTable.setWidth("100%");
			return this;
		}

	}

	public void refreshTable() {
		dispozitii = showAllDispozitiiService.getAllDispozitii();
		container.removeAllItems();
		container.addAll(dispozitii);

	}

	public Component createComponent() {
		return new AfisareDispozitiiLayout().load().init().layout();
	}

}
