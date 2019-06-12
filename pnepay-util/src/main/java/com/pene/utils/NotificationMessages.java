package com.pene.utils;

public enum NotificationMessages {
	FACTURA_SAVE_VALIDATION_ERROR_TITLE("Eroare"), 
	FACTURA_SAVE_ERROR_DESCRIPTION("Câmpurile trebuiesc completate"),
	FACTURA_SAVE_SUCCESS_TITLE("Succes"),
	FACTURA_SAVE_SUCCESS_DESCRIPTION("Factura a fost salvata cu succes"),
	FACTURA_REMOVE_SUCCESS_TITLE("Succes"),
	FACTURA_REMOVE_SUCCESS_DESCRIPTION("Factura a fost stearsa cu succes"), 
	FURNIZORI_SAVED_VALIDATION_ERROR_DESCRIPTION("Câmpurile trebuiesc completate"),
	FURNIZORI_SAVED_VALIDATION_ERROR_TITLE("Eroare"),
	FURNIZOR_SAVE_SUCCESS_TITLE("Succes"),
	FURNIZOR_SAVE_SUCCESS_DESCRIPTION("Furnizorul a fost adaugat cu succes"),
	FURNIZOR_REMOVE_SUCCESS_TITLE("Succes"),
	FURNIZOR_REMOVE_SUCCESS_DESCRIPTION("Furnizorul a fost sters cu succes"),
	CASIERIE_SAVED_VALIDATION_ERROR_DESCRIPTION("Câmpurile trebuiesc completate"),
	CASIERIE_SAVED_VALIDATION_ERROR_TITLE("Eroare"),
	CASIERIE_SAVE_SUCCESS_TITLE("Succes"),
	CASIERIE_SAVE_SUCCESS_DESCRIPTION("Casieria a fost adaugat cu succes"),
	CASIERIE_REMOVE_SUCCESS_TITLE("Succes"),
	CASIERIE_REMOVE_SUCCESS_DESCRIPTION("Casieria a fost stearsa cu succes"),
	DISPOZITIE_SAVED_VALIDATION_ERROR_DESCRIPTION("Câmpurile trebuiesc completate"),
	DISPOZITIE_SAVED_VALIDATION_ERROR_TITLE("Eroare"),
	DISPOZITIE_SAVE_SUCCESS_TITLE("Succes"),
	DISPOZITIE_SAVE_SUCCESS_DESCRIPTION("Dispozitia de plata a fost adaugat cu succes"),
	DISPOZITIE_REMOVE_SUCCESS_TITLE("Succes"),
	DISPOZITIE_REMOVE_SUCCESS_DESCRIPTION("Dispozitia de plata a fost stearsa cu succes"),
	FACTURA_SAVE_INVALID_TITLE("Eroare"), 
	FACTURA_SAVE_INVALID_DESCRIPTION("Definiti un Furnizor"), 
	DISPOZITIE_SAVE_INVALID_TITLE("Eroare"),
	DISPOZITIE_SAVE_INVALID_DESCRIPTION("Definiti o Casierie");
	
	
	private final String string;

	private NotificationMessages(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}
}
