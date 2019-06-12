
package com.pene.ui.casierie;

import org.springframework.beans.factory.annotation.Autowired;
import com.pene.model.entity.Casierie;
import com.pene.service.adaugaCasierie.AdaugaCasierieService;
import com.pene.utils.CasierieStringUtils;
import com.pene.utils.NotificationMessages;
import com.pene.utils.Valuta;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


@org.springframework.stereotype.Component
public class AddCasierieMainLayoutFactory {

	@Autowired
	private AdaugaCasierieService adaugaCasierieService;
	
	private class AddCasierieMainLayout extends VerticalLayout implements Button.ClickListener {

		private TextField denumireCasierie;
		private TextField punctLucru;
		private TextField numeCasier;
		private ComboBox valutaCasierie;
		private Button saveButton;
		private Button clearButton;

		private BeanFieldGroup<Casierie> fieldGroup;
		private Casierie casierie;
		private CasierieSavedListener casieriiSavedListener;
		
		
		public AddCasierieMainLayout(CasierieSavedListener casieriiSavedListener) {
			this.casieriiSavedListener=casieriiSavedListener;
		}

		public AddCasierieMainLayout init() {

			fieldGroup = new BeanFieldGroup<Casierie>(Casierie.class);
			casierie = new Casierie();

			denumireCasierie = new TextField(CasierieStringUtils.DENUMIRE_CASIERIE.getString());
			punctLucru = new 	TextField(CasierieStringUtils.PUNCT_LUCRU.getString());
			numeCasier= new TextField(CasierieStringUtils.NUME_CASIER.getString());
			valutaCasierie = new ComboBox(CasierieStringUtils.VALUTA.getString());


			saveButton = new Button(CasierieStringUtils.SAVE_BUTTON.getString());
			
			clearButton = new Button(CasierieStringUtils.CLEAR_BUTTON.getString());
			

			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

			saveButton.addClickListener(this);
			clearButton.addClickListener(this);

			valutaCasierie.addItem(Valuta.EURO.getString());
			valutaCasierie.addItem(Valuta.DOLAR.getString());
			valutaCasierie.addItem(Valuta.RON.getString());
			
			denumireCasierie.setNullRepresentation("");
			punctLucru.setNullRepresentation("");
			numeCasier.setNullRepresentation("");
			
	
			return this;

		}

		public AddCasierieMainLayout bind() {
			
			
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(casierie);

			return this;
		}

		public Component layout() {

			setMargin(true);
			setWidth("100%");

			GridLayout gridLayout = new GridLayout(1, 5);
			gridLayout.setHeightUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(denumireCasierie, 0, 0);
			gridLayout.addComponent(punctLucru, 0, 1);
			gridLayout.addComponent(numeCasier, 0,2);
			gridLayout.addComponent(valutaCasierie, 0, 3);

			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 4);
			valutaCasierie.clear();
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

			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				Notification.show(NotificationMessages.CASIERIE_SAVED_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.CASIERIE_SAVED_VALIDATION_ERROR_DESCRIPTION.getString(), Type.ERROR_MESSAGE);
			}

			adaugaCasierieService.saveCasierie(casierie);
			casieriiSavedListener.casierieSaved();
			clearField();
			Notification.show(NotificationMessages.CASIERIE_SAVE_SUCCESS_TITLE.getString(),
					NotificationMessages.CASIERIE_SAVE_SUCCESS_DESCRIPTION.getString(), Type.WARNING_MESSAGE);

		}

		private void clearField() {
			
			denumireCasierie.setValue(null);
			punctLucru .setValue(null);
			numeCasier.setValue(null);
			valutaCasierie.setValue(null);
		}

	}



	public Component createComponent(CasierieSavedListener casieriiSavedListener) {
		return new AddCasierieMainLayout(casieriiSavedListener).init().bind().layout();
	}
}

