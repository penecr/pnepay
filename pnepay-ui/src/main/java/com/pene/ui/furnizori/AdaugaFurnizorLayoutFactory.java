package com.pene.ui.furnizori;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Furnizor;
import com.pene.service.adaugaFurnizor.AdaugaFurnizorService;
import com.pene.utils.FurnizoriStringUtils;
import com.pene.utils.NotificationMessages;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AdaugaFurnizorLayoutFactory {
	
	@Autowired
	private AdaugaFurnizorService adaugaFurnizorService;

	private class AdaugaFurnizorLayout extends VerticalLayout implements Button.ClickListener {

		private TextField cif;
		private TextField denumireFurnizor;
		private TextField ibanFurnizor;
		private TextField tipFurnizor;
		private TextField bancaFurnizor;
		private TextField persoanaContact;
		private TextField emailPersoana;

		private Furnizor furnizor;
		private BeanFieldGroup<Furnizor> fieldGroup;

		private Button saveButton;
		private FurnizoriSavedListener furnizoriSavedListener;
		
		public AdaugaFurnizorLayout(FurnizoriSavedListener furnizoriSavedListener) {
			
			this.furnizoriSavedListener=furnizoriSavedListener;
			
		}
		
		public AdaugaFurnizorLayout init() {

			furnizor=new Furnizor();
			fieldGroup=new BeanFieldGroup<Furnizor>(Furnizor.class);
			
			cif = new TextField(FurnizoriStringUtils.CIF.getString());
			cif.setMaxLength(30);

			denumireFurnizor = new TextField(FurnizoriStringUtils.DENUMIRE_FURNIZOR.getString());

			ibanFurnizor = new TextField(FurnizoriStringUtils.IBAN.getString());

			ibanFurnizor.setMaxLength(30);

			tipFurnizor = new TextField(FurnizoriStringUtils.TIP_FURNIZOR.getString());

			bancaFurnizor = new TextField(FurnizoriStringUtils.BANCA.getString());

			persoanaContact = new TextField(FurnizoriStringUtils.PERSOANA_CONTACT.getString());

			emailPersoana = new TextField(FurnizoriStringUtils.EMAIL.getString());

			saveButton = new Button(FurnizoriStringUtils.SAVE_BUTTON.getString(), this);

			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

			cif.setNullRepresentation("");
			denumireFurnizor.setNullRepresentation("");
			ibanFurnizor.setNullRepresentation("");
			tipFurnizor.setNullRepresentation("");
			bancaFurnizor.setNullRepresentation("");
			persoanaContact.setNullRepresentation("");
			emailPersoana.setNullRepresentation("");

			return this;
		}

		public AdaugaFurnizorLayout bind() {

			
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(furnizor);
			
			
			return this;
		}
		
		public Component layout() {
			
			GridLayout grid = new GridLayout(2,5);
			
			grid.setHeightUndefined();
			grid.setSpacing(true);
			
			grid.addComponent(cif, 0, 0);
			grid.addComponent(denumireFurnizor, 1, 0);
			grid.addComponent(tipFurnizor, 0, 1);
			grid.addComponent(bancaFurnizor, 0, 2);
			grid.addComponent(ibanFurnizor, 1, 2);
			grid.addComponent(persoanaContact, 0, 3);
			grid.addComponent(emailPersoana, 1, 3);
			grid.addComponent(saveButton, 0, 4);

			return grid;
		}

		public void buttonClick(ClickEvent event) {

			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				
				Notification.show(NotificationMessages.FURNIZORI_SAVED_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.FURNIZORI_SAVED_VALIDATION_ERROR_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
				
				return;
				
			}
			
			clearFields();
			adaugaFurnizorService.adaugaFurnizor(furnizor);
			furnizoriSavedListener.furnizoriSaved();
			Notification.show(NotificationMessages.FURNIZOR_SAVE_SUCCESS_TITLE.getString(),
					NotificationMessages.FURNIZOR_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);		
		}

		private void clearFields() {
			cif.setValue(null);
			denumireFurnizor.setValue(null);
			ibanFurnizor.setValue(null);
			tipFurnizor.setValue(null);
			bancaFurnizor.setValue(null);
			persoanaContact.setValue(null);
			emailPersoana.setValue(null);
			
			
		}

	}

	public Component createComponent(FurnizoriSavedListener furnizoriSavedListener) {

		return new AdaugaFurnizorLayout(furnizoriSavedListener).init().bind().layout();
	}

}
