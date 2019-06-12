package com.pene.utils;

public enum StringUtils {
	MENU_FACTURI("FACTURI"),
	MENU_FURNIZORI("FURNIZORI"),
	MENU_CASIERIE("CASIERIE"),
	MENU_DISPOZITIE_PLATA("DISPOZITIE DE PLATA"),
	MENU_ADAUGA_FACTURA("Adauga Factura"),
	MENU_STERGE_FACTURA("Sterge Factura"),
	MENU_ADAUGA_FURNIZOR("Adauga Furnizor"),
	MENU_STERGE_FURNIZOR("Sterge Furnizor"),
	MENU_ADAUGA_DISPOZITIE_PLATA("Adauga Dispozitie De Plata"),
	MENU_STERGE_DISPOZITIE_PLATA("Sterge Dispozitie De Plata"),
	MENU_ADAUGA_CASIERIE("Adauga Casierie"),
	MENU_STERGE_CASIERIE("Sterge Casierie");
	
	
	private final String string;
	private StringUtils(String string) {
		this.string=string;
	}
	public String getString() {
		return this.string;
	}
}
