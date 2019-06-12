
package com.pene.ui.dispozitiePlata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.CasierieStringUtils;
import com.pene.utils.DispozitiePlataStringUtils;
import com.pene.utils.NotificationMessages;
import com.pene.model.entity.Casierie;
import com.pene.model.entity.DispozitiePlata;
import com.pene.service.showallcasierii.ShowAllCasieriiService;
import com.pene.service.showalldispozitii.ShowAllDispozitiiService;
import com.pene.service.stergeCasierie.StergeCasierieService;
import com.pene.service.stergeDispozitiePlata.StergeDispozitiePlataService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.renderers.DateRenderer;
import com.vaadin.ui.renderers.Renderer;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = RemoveDispozitiiLayoutFactory.Name, ui = PnePayMainUI.class)
public class RemoveDispozitiiLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

	@Autowired
	private ShowAllDispozitiiService allDispozitiiService;

	@Autowired
	private StergeDispozitiePlataService stergeDispozitieService;
	
	public static final String Name = "stergedispozitiedeplata";

	private Grid stergeDispozitieTable;
	private Button removeDispozitieButton;
	private List<DispozitiePlata> dispozitii;

	private void addLayout() {

		removeDispozitieButton = new Button(DispozitiePlataStringUtils.DISPOZITIE_REMOVE_BUTTON.getString());

		setMargin(true);
		BeanItemContainer<DispozitiePlata> container = new BeanItemContainer<DispozitiePlata>(DispozitiePlata.class, dispozitii);

		stergeDispozitieTable = new Grid(container);
		stergeDispozitieTable.setColumnOrder("dataDispozitie", "nume", "serieBuletin", "functie", "scopPlata","sumaPlatita","valuta");
		stergeDispozitieTable.removeColumn("id");
		stergeDispozitieTable.getColumn("dataDispozitie").setRenderer((Renderer) new DateRenderer("%1$td/%1$tm/%1$tY"));
		stergeDispozitieTable.setImmediate(true);
		stergeDispozitieTable.setSelectionMode(SelectionMode.MULTI);
		stergeDispozitieTable.setWidth("100%");

		removeDispozitieButton.addClickListener(this);
		removeDispozitieButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

		addComponent(stergeDispozitieTable);
		addComponent(removeDispozitieButton);
	}

	private void loadDispozitii() {
		dispozitii = allDispozitiiService.getAllDispozitii();

	}

	public void buttonClick(ClickEvent event) {

		MultiSelectionModel selectionModel = (MultiSelectionModel) stergeDispozitieTable.getSelectionModel();

		for (Object selectedItem : selectionModel.getSelectedRows()) {

			DispozitiePlata dispozitie = (DispozitiePlata) selectedItem;
			stergeDispozitieTable.getContainerDataSource().removeItem(dispozitie);
			stergeDispozitieService.stergeDispozitiePlata(dispozitie);
		}

		Notification.show(NotificationMessages.DISPOZITIE_REMOVE_SUCCESS_TITLE.getString(),
				NotificationMessages.DISPOZITIE_REMOVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);

		stergeDispozitieTable.getSelectionModel().reset();
	}

	public void enter(ViewChangeEvent event) {

		if (stergeDispozitieTable != null)
			return;

		loadDispozitii();
		addLayout();

	}

}

