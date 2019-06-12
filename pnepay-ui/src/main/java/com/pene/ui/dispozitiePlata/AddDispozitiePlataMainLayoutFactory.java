
package com.pene.ui.dispozitiePlata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pene.model.entity.Casierie;
import com.pene.model.entity.DispozitiePlata;
import com.pene.service.adaugaDispozitiePlata.AdaugaDispozitiePlataService;
import com.pene.service.showallcasierii.ShowAllCasieriiService;
import com.pene.utils.DispozitiePlataStringUtils;
import com.pene.utils.NotificationMessages;
import com.pene.utils.Valuta;
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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddDispozitiePlataMainLayoutFactory {



	private class AddDispozitiePlataMainLayout extends VerticalLayout implements Button.ClickListener {

		private DateField dataDispozitie;
		private TextField nume;
		private ComboBox casierie;
		private TextField serieBuletin;
		private TextField functie;
		private TextField scopPlata;
		private TextField sumaPlatita;
		private ComboBox valuta;
		
		private Button saveButton;
		private Button clearButton;

		private BeanFieldGroup<DispozitiePlata> fieldGroup;
		private DispozitiePlata dispozitiePlata;
		private DispozitiePlataSavedListener dispozitiePlataSavedListener;

		public AddDispozitiePlataMainLayout(DispozitiePlataSavedListener dispozitiePlataSavedListener) {
			this.dispozitiePlataSavedListener = dispozitiePlataSavedListener;
		}

		public AddDispozitiePlataMainLayout init() {

			fieldGroup = new BeanFieldGroup<DispozitiePlata>(DispozitiePlata.class);
			dispozitiePlata = new DispozitiePlata();

			dataDispozitie = new DateField(DispozitiePlataStringUtils.DATA_DISPOZITIE.getString());
			nume = new TextField(DispozitiePlataStringUtils.NUME.getString());
			serieBuletin = new TextField(DispozitiePlataStringUtils.SERIE.getString());
			functie = new TextField(DispozitiePlataStringUtils.FUNCTIE.getString());
			scopPlata = new TextField(DispozitiePlataStringUtils.SCOP.getString());
			sumaPlatita = new TextField(DispozitiePlataStringUtils.SUMA_PLATITA.getString());
			casierie = new ComboBox(DispozitiePlataStringUtils.CASIERIE.getString());
			casierie.setWidth("100%");

			saveButton = new Button(DispozitiePlataStringUtils.SAVE_BUTTON.getString());

			clearButton = new Button(DispozitiePlataStringUtils.CLEAR_BUTTON.getString());

			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			saveButton.addClickListener(this);
			clearButton.addClickListener(this);

			valuta.addItem(Valuta.EURO.getString());
			valuta.addItem(Valuta.DOLAR.getString());
			valuta.addItem(Valuta.RON.getString());

			nume.setNullRepresentation("");
			serieBuletin.setNullRepresentation("");
			functie.setNullRepresentation("");
			scopPlata.setNullRepresentation("");
			sumaPlatita.setNullRepresentation("");

			return this;

		}

		public AddDispozitiePlataMainLayout bind() {

			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(dispozitiePlata);

			return this;
		}

		public Component layout() {

			setMargin(true);
			

			GridLayout gridLayout = new GridLayout(2, 6);
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(dataDispozitie, 0, 0);
			gridLayout.addComponent(serieBuletin, 0, 1);
			gridLayout.addComponent(nume, 1, 1);
			gridLayout.addComponent(functie, 0, 2);
			gridLayout.addComponent(scopPlata, 1, 2);
			gridLayout.addComponent(sumaPlatita, 0, 3);
			gridLayout.addComponent(valuta, 1, 3);
			gridLayout.addComponent(casierie, 0, 4);

			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 5);
			valuta.clear();
			
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
				Notification.show(NotificationMessages.DISPOZITIE_SAVE_INVALID_TITLE.getString(),
						NotificationMessages.DISPOZITIE_SAVE_INVALID_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
			} else {
				saveDispozitie();
			}
		}

		private void saveDispozitie() {
			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				Notification.show(NotificationMessages.DISPOZITIE_SAVED_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.DISPOZITIE_SAVED_VALIDATION_ERROR_DESCRIPTION.getString(),
						Type.ERROR_MESSAGE);
			}

			adaugaDispozitiePlataService.saveDispozitie(dispozitiePlata);
			dispozitiePlataSavedListener.dispozitieSaved();

			Notification.show(NotificationMessages.DISPOZITIE_SAVE_SUCCESS_TITLE.getString(),
					NotificationMessages.DISPOZITIE_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);
			clearField();
		}

		private void clearField() {

			dataDispozitie.setValue(null);
			serieBuletin.setValue(null);
			nume.setValue(null);
			valuta.setValue(null);
			functie.setValue(null);
			scopPlata.setValue(null);
			sumaPlatita.setValue(null);
			casierie.setValue(null);
		}

		public AddDispozitiePlataMainLayout load() {

			List<Casierie> casierii = afiseazaCasierii.getAllCasierii();
			casierie.addItems(casierii);

			return this;
		}

	}

	private boolean isOperationValid() {
		return afiseazaCasierii.getAllCasierii().size() != 0;
	}
	@Autowired
	private AdaugaDispozitiePlataService adaugaDispozitiePlataService;
	
	@Autowired
	private ShowAllCasieriiService afiseazaCasierii;

	public Component createComponent(DispozitiePlataSavedListener dispozitiePlataSavedListener) {
		return new AddDispozitiePlataMainLayout(dispozitiePlataSavedListener).init().load().bind().layout();
	}
}
