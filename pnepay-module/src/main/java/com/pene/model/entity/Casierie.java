package com.pene.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="CASIERIE")
public class Casierie {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer idCasierie;
	


	@Column(name="nume_Casier")
	@NotNull(message="Introduceti Nume Casier")
	private String numeCasier;
	
	@Column(name="denumire_Casierie")
	@NotNull(message="Introduceti Denumirea Casieriei")
	private String denumireCasierie;
	
	@Column(name="punct_de_Lucru")
	@NotNull(message="Introduceti Punct de Lucru")
	private String punctLucru;

	@Column(name="valuta_casierie")
	@NotNull(message="Alegeti Valuta")
	private String valutaCasierie;

	
	public Casierie() {
		
	}


	public Integer getIdCasierie() {
		return idCasierie;
	}


	public void setId(Integer idCasierie) {
		this.idCasierie = idCasierie;
	}


	public String getDenumireCasierie() {
		return denumireCasierie;
	}

	public void setDenumireCasierie(String denumireCasierie) {
		this.denumireCasierie = denumireCasierie;
	}

	public String getNumeCasier() {
		return numeCasier;
	}
	public void setNumeCasier(String numeCasier) {
		this.numeCasier = numeCasier;
	}
	public String getPunctLucru() {
		return punctLucru;
	}

	public void setPunctLucru(String punctLucru) {
		this.punctLucru = punctLucru;
	}

	public String getValutaCasierie() {
		return valutaCasierie;
	}

	public void setValutaCasierie(String valutaCasierie) {
		this.valutaCasierie = valutaCasierie;
	}
	@Override
	public String toString() {
		return this.denumireCasierie;
	}
	
}
