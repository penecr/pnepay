package com.pene.utils;

public enum CasierieStringUtils {

	MENIU("MENIU"),
	AFISEAZA_CASIERIE("AFISEAZA TOATE CASIERIILE"),
	DENUMIRE_CASIERIE("Denumire Casierie"),
	NUME_CASIER("Nume Casier"),
	PUNCT_LUCRU("Punct de Lucru"),
	VALUTA("Valuta Casierie"),
	SAVE_BUTTON("Salveaza"),
	CLEAR_BUTTON("Anuleaza"),
	CASIERIE_REMOVE_BUTTON("Sterge");
	private final String string;
	
	private CasierieStringUtils(String string) {
		this.string=string;
	}
	public String getString() {
		return this.string;
	}
	
}
