
package com.pene.ui.casierie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.CasierieStringUtils;
import com.pene.utils.NotificationMessages;
import com.pene.model.entity.Casierie;
import com.pene.service.showallcasierii.ShowAllCasieriiService;
import com.pene.service.stergeCasierie.StergeCasierieService;
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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = RemoveCasieriiLayoutFactory.Name, ui = PnePayMainUI.class)
public class RemoveCasieriiLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

	@Autowired
	private ShowAllCasieriiService allCasieriiService;

	@Autowired
	private StergeCasierieService stergeCasierieService;
	
	public static final String Name = "stergecasierie";

	private Grid stergeCasierieTable;
	private Button removeCasierieButton;
	private List<Casierie> casierii;

	private void addLayout() {

		removeCasierieButton = new Button(CasierieStringUtils.CASIERIE_REMOVE_BUTTON.getString());

		setMargin(true);
		BeanItemContainer<Casierie> container = new BeanItemContainer<Casierie>(Casierie.class, casierii);

		stergeCasierieTable = new Grid(container);
		stergeCasierieTable.setColumnOrder("idCasierie","numeCasier","denumireCasierie","punctLucru","valutaCasierie");
		stergeCasierieTable.setImmediate(true);
		stergeCasierieTable.setSelectionMode(SelectionMode.MULTI);
		stergeCasierieTable.setWidth("100%");

		removeCasierieButton.addClickListener(this);
		removeCasierieButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

		addComponent(stergeCasierieTable);
		addComponent(removeCasierieButton);
	}

	private void loadCasierii() {
		casierii = allCasieriiService.getAllCasierii();

	}

	public void buttonClick(ClickEvent event) {

		MultiSelectionModel selectionModel = (MultiSelectionModel) stergeCasierieTable.getSelectionModel();

		for (Object selectedItem : selectionModel.getSelectedRows()) {

			Casierie casierie = (Casierie) selectedItem;
			stergeCasierieTable.getContainerDataSource().removeItem(casierie);
			stergeCasierieService.stergeCasierie(casierie);
		}

		Notification.show(NotificationMessages.CASIERIE_REMOVE_SUCCESS_TITLE.getString(),
				NotificationMessages.CASIERIE_REMOVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);

		stergeCasierieTable.getSelectionModel().reset();
	}

	public void enter(ViewChangeEvent event) {

		if (stergeCasierieTable != null)
			return;

		loadCasierii();
		addLayout();

	}

}

