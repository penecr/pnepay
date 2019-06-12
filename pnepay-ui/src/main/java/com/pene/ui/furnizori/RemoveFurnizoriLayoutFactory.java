package com.pene.ui.furnizori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.FurnizoriStringUtils;
import com.pene.utils.NotificationMessages;
import com.pene.model.entity.Furnizor;
import com.pene.service.showallfurnizori.ShowAllFurnizoriService;
import com.pene.service.stergeFurnizor.StergeFurnizorService;
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

@SpringView(name = RemoveFurnizoriLayoutFactory.Name, ui = PnePayMainUI.class)
public class RemoveFurnizoriLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

	@Autowired
	private ShowAllFurnizoriService allFurnizoriService;

	@Autowired
	private StergeFurnizorService stergeFurnizorService;

	public static final String Name = "stergefurnizor";

	private Grid stergeFurnizorTable;
	private Button removeFurnizorButton;
	private List<Furnizor> furnizori;

	private void addLayout() {

		removeFurnizorButton = new Button(FurnizoriStringUtils.FURNIZOR_REMOVE_BUTTON.getString());

		setMargin(true);
		BeanItemContainer<Furnizor> container = new BeanItemContainer<Furnizor>(Furnizor.class, furnizori);

		stergeFurnizorTable = new Grid(container);
		stergeFurnizorTable.setColumnOrder("cif", "denumireFurnizor", "ibanFurnizor", "tipFurnizor", "bancaFurnizor",
				"persoanaContact", "emailPersoana");
		stergeFurnizorTable.removeColumn("id");
		stergeFurnizorTable.setImmediate(true);
		stergeFurnizorTable.setSelectionMode(SelectionMode.MULTI);
		stergeFurnizorTable.setWidth("100%");

		removeFurnizorButton.addClickListener(this);
		removeFurnizorButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

		addComponent(stergeFurnizorTable);
		addComponent(removeFurnizorButton);
	}

	private void loadFurnizori() {
		furnizori = allFurnizoriService.getAllFurnizori();

	}

	public void buttonClick(ClickEvent event) {

		MultiSelectionModel selectionModel = (MultiSelectionModel) stergeFurnizorTable.getSelectionModel();

		for (Object selectedItem : selectionModel.getSelectedRows()) {

			Furnizor furnizor = (Furnizor) selectedItem;
			stergeFurnizorTable.getContainerDataSource().removeItem(furnizor);
			stergeFurnizorService.stergeFurnizor(furnizor);
		}

		Notification.show(NotificationMessages.FURNIZOR_REMOVE_SUCCESS_TITLE.getString(),
				NotificationMessages.FURNIZOR_REMOVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);

		stergeFurnizorTable.getSelectionModel().reset();
	}

	public void enter(ViewChangeEvent event) {

		if (stergeFurnizorTable != null)
			return;

		loadFurnizori();
		addLayout();

	}

}
