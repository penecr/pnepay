package com.pene.utils;

public enum FacturiStringUtils {

	MENIU("MENIU"),
	AFISEAZA_FACTURI("AFISEAZA TOATE FACTURILE"),
	DATA_EMITERE("Data Emitere"),
	DATA_SCADENTA("Data Scadenta"),
	TOTAL_FACTURA("Total Factura"),
	DESCRIERE_FACTURA("Descriere Factura"),
	SAVE_BUTTON("Salveaza"),
	CLEAR_BUTTON("Anuleaza"),
	FACTURA_REMOVE_BUTTON("Sterge"), 
	FURNIZOR("Selecteaza Furnizor");
	private final String string;
	
	private FacturiStringUtils(String string) {
		this.string=string;
	}
	public String getString() {
		return this.string;
	}
	
}
