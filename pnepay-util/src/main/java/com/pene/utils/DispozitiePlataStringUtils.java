package com.pene.utils;



public enum DispozitiePlataStringUtils {

	MENIU("MENIU"),
	AFISEAZA_DISPOZITIE("AFISEAZA TOATE DISPOZITIILE DE PLATA"),
	DATA_DISPOZITIE("Data Emitere Dispozitie"),
	NUME("Nume Persoana Autorizata"),
	SERIE("Serie Buletin Persoana Autorizata"),
	FUNCTIE("Functie Persoana Autorizata"),
	SCOP("Scop Plata"),
	SUMA_PLATITA("Suma Platita"),
	VALUTA("Valuta"),
	SAVE_BUTTON("Salveaza"),
	CLEAR_BUTTON("Anuleaza"),
	DISPOZITIE_REMOVE_BUTTON("Sterge"), CASIERIE("Casierie");
	private final String string;
	
	private DispozitiePlataStringUtils(String string) {
		this.string=string;
	}
	public String getString() {
		return this.string;
	}

}
