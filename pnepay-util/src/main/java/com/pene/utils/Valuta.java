package com.pene.utils;

public enum Valuta {

	EURO("EURO"), DOLAR("USD"), RON("RON");

	private final String string;

	private Valuta(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}

