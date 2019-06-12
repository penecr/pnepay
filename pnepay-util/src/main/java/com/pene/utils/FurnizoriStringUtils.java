package com.pene.utils;

public enum FurnizoriStringUtils {

	MENIU("MENIU"),
	AFISEAZA_FURNIZORI("AFISEAZA TOTI FURNIZORII"),
	STATISTICI("STATISTICI"),
	CIF("CIF"),
	DENUMIRE_FURNIZOR("Denumire Furnizor"),
	IBAN("IBAN"),
	TIP_FURNIZOR("Tip Furnizor"),
	BANCA("Banca Furnizor"),
	PERSOANA_CONTACT("Persoana Contact"),
	EMAIL("E-mail Persoana Contact"),
	SAVE_BUTTON("Salveaza"),
	CLEAR_BUTTON("Anuleaza"),
	FURNIZOR_REMOVE_BUTTON("Sterge");
	private final String string;
	
	private FurnizoriStringUtils(String string) {
		this.string=string;
	}
	public String getString() {
		return this.string;
	}
	
}
