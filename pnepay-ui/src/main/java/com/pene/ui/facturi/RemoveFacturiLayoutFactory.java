package com.pene.ui.facturi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.ui.commons.PnePayMainUI;
import com.pene.utils.FacturiStringUtils;
import com.pene.utils.NotificationMessages;
import com.pene.model.entity.Factura;
import com.pene.model.entity.facturaDTO;
import com.pene.service.showallfacturi.ShowAllFacturiService;
import com.pene.service.stergeFactura.StergeFacturaService;
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

@SpringView(name = RemoveFacturiLayoutFactory.Name, ui = PnePayMainUI.class)
public class RemoveFacturiLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

	@Autowired
	private ShowAllFacturiService allFacturiService;

	@Autowired
	private StergeFacturaService stergeFacturaService;
	
	public static final String Name = "stergefactura";

	private Grid stergeFacturaTable;
	private Button removeFacturaButton;
	private List<facturaDTO> facturi;

	private void addLayout() {

		removeFacturaButton = new Button(FacturiStringUtils.FACTURA_REMOVE_BUTTON.getString());

		setMargin(true);
		BeanItemContainer<facturaDTO> container = new BeanItemContainer<facturaDTO>(facturaDTO.class, facturi);

		stergeFacturaTable = new Grid(container);
		stergeFacturaTable.setColumnOrder("id", "descriereFactura", "dataEmiterii", "dataScadenta",
				"totalFactura","furnizor");
		stergeFacturaTable.removeColumn("furnizor");
	
		stergeFacturaTable.getColumn("dataEmiterii").setRenderer((Renderer) new DateRenderer("%1$td/%1$tm/%1$tY"));
		stergeFacturaTable.getColumn("dataScadenta").setRenderer((Renderer) new DateRenderer("%1$td/%1$tm/%1$tY"));
		stergeFacturaTable.setImmediate(true);
		stergeFacturaTable.setSelectionMode(SelectionMode.MULTI);
		stergeFacturaTable.setWidth("100%");

		removeFacturaButton.addClickListener(this);
		removeFacturaButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

		addComponent(stergeFacturaTable);
		addComponent(removeFacturaButton);
	}

	private void loadFacturi() {
		facturi = allFacturiService.getAllFacturi();

	}

	public void buttonClick(ClickEvent event) {

		MultiSelectionModel selectionModel = (MultiSelectionModel) stergeFacturaTable.getSelectionModel();

		for (Object selectedItem : selectionModel.getSelectedRows()) {

			Factura factura = (Factura) selectedItem;
			stergeFacturaTable.getContainerDataSource().removeItem(factura);
			stergeFacturaService.stergeFactura(factura);
		}

		Notification.show(NotificationMessages.FACTURA_REMOVE_SUCCESS_TITLE.getString(),
				NotificationMessages.FACTURA_REMOVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);

		stergeFacturaTable.getSelectionModel().reset();
	}

	public void enter(ViewChangeEvent event) {

		if (stergeFacturaTable != null)
			return;

		loadFacturi();
		addLayout();

	}

}

