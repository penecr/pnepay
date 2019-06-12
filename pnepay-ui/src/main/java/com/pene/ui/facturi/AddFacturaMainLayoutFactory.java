package com.pene.ui.facturi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Factura;
import com.pene.model.entity.Furnizor;
import com.pene.service.adaugaFactura.AdaugaFacturaService;
import com.pene.service.showallfurnizori.ShowAllFurnizoriService;
import com.pene.utils.FacturiStringUtils;
import com.pene.utils.NotificationMessages;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddFacturaMainLayoutFactory {

	private class AddFacturaMainLayout extends VerticalLayout implements Button.ClickListener {

		private DateField dataEmiterii;
		private DateField dataScadenta;
		private ComboBox furnizor;
		private TextField totalFactura;
		private TextArea descriereFactura;
		
		private Button saveButton;
		private Button clearButton;

		private BeanFieldGroup<Factura> fieldGroup;
		private Factura factura;
		private FacturiSavedListener facturiSavedListener;
		
		
		public AddFacturaMainLayout(FacturiSavedListener facturiSavedListener) {
			this.facturiSavedListener=facturiSavedListener;
		}

		public AddFacturaMainLayout init() {

			fieldGroup = new BeanFieldGroup<Factura>(Factura.class);
			factura = new Factura();

			dataEmiterii = new DateField(FacturiStringUtils.DATA_EMITERE.getString());
			dataScadenta = new DateField(FacturiStringUtils.DATA_SCADENTA.getString());
			totalFactura = new TextField(FacturiStringUtils.TOTAL_FACTURA.getString());
			descriereFactura = new TextArea(FacturiStringUtils.DESCRIERE_FACTURA.getString());
			furnizor= new ComboBox(FacturiStringUtils.FURNIZOR.getString());
			furnizor.setWidth("100%");
			saveButton = new Button(FacturiStringUtils.SAVE_BUTTON.getString());
			
			clearButton = new Button(FacturiStringUtils.CLEAR_BUTTON.getString());
			
			
			

			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			saveButton.addClickListener(this);
			clearButton.addClickListener(this);

			descriereFactura.setNullRepresentation("");
			totalFactura.setNullRepresentation("");
			return this;

		}

		public AddFacturaMainLayout bind() {

			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(factura);

			return this;
		}

		public Component layout() {

			setMargin(true);

			GridLayout gridLayout = new GridLayout(2, 5);
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(dataEmiterii, 0, 0);
			gridLayout.addComponent(dataScadenta, 1, 0);
			gridLayout.addComponent(furnizor, 0, 1);
			gridLayout.addComponent(totalFactura, 0, 2);
			gridLayout.addComponent(descriereFactura, 0, 3);

			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 4);

			return gridLayout;
		}

		public void buttonClick(ClickEvent event) {
			if (event.getSource() == this.saveButton) {

				save();

			} else {
				clearField();
			}
		}

		private void save() {
			if (!isOperationValid()) {
				Notification.show(NotificationMessages.FACTURA_SAVE_INVALID_TITLE.getString(),
						NotificationMessages.FACTURA_SAVE_INVALID_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
			} else {
				saveFactura();
			}
		}
		private void saveFactura() {
			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				Notification.show(NotificationMessages.FACTURA_SAVE_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.FACTURA_SAVE_ERROR_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
			}

			adaugaFacturaService.saveFactura(factura);
			facturiSavedListener.facturiSaved();
			
			Notification.show(NotificationMessages.FACTURA_SAVE_SUCCESS_TITLE.getString(),
					NotificationMessages.FACTURA_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);
			clearField();
		}

		private void clearField() {
			dataEmiterii.setValue(null);
			dataScadenta.setValue(null);
			totalFactura.setValue(null);
			descriereFactura.setValue(null);
			furnizor.setValue(null);
			
		}
		public AddFacturaMainLayout load() {
			
			List<Furnizor> furnizori= afiseazaFurnizori.getAllFurnizori();
			furnizor.addItems(furnizori);
			
			return this;
		}
		
			
		}
	
	private boolean isOperationValid() {
		return afiseazaFurnizori.getAllFurnizori().size() != 0;
	}
	

	

	@Autowired
	private ShowAllFurnizoriService afiseazaFurnizori;
	@Autowired
	private AdaugaFacturaService adaugaFacturaService;

	public Component createComponent(FacturiSavedListener facturiSavedListener) {
		return new AddFacturaMainLayout(facturiSavedListener).init().load().bind().layout();
	}
}
