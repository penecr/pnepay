package com.pene.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "DISPOZITIE_PLATA")
public class DispozitiePlata {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "data_Dispozitie")
	@NotNull(message = "Introduceti Data Emiterii Dispozitiei")
	@Past(message = "Data Emiterii nu este corecta")
	@Temporal(TemporalType.DATE)
	private Date dataDispozitie;

	@Column(name = "nume_Persoana_Autorizata")
	@NotNull(message = "Introduceti Numele Persoanei Autorizate")
	private String nume;

	@Column(name = "serie_Serie_Nr_Bi")
	@NotNull(message = "Introduceti Serie Buletin")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{6}$", message = "Introduceti o Serie de Buletin Valida")
	private String serieBuletin;

	@Column(name = "functie")
	@NotNull(message = "Introduceti Functia Persoanei Autorizate")
	private String functie;

	@Column(name = "scop_Plata")
	@NotNull(message = "Introduceti Scopul Platii")
	private String scopPlata;

	@Column(name = "suma_Platita")
	@NotNull(message = "Introduceti Suma Platita")
	private float sumaPlatita;

	@Column(name = "valuta")
	@NotNull(message = "Introduceti Valuta")
	private String valuta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "casierie_id")
	@NotNull(message = "Introduceti Casierie")
	private Casierie casierie;

	public DispozitiePlata() {

	}


	public Integer getId() {
		return id;
	}

	
	public Date getDataDispozitie() {
		return dataDispozitie;
	}

	public void setDataDispozitie(Date dataDispozitie) {
		this.dataDispozitie = dataDispozitie;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getSerieBuletin() {
		return serieBuletin;
	}

	public void setSerieBuletin(String serieBuletin) {
		this.serieBuletin = serieBuletin;
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}

	public String getScopPlata() {
		return scopPlata;
	}

	public void setScopPlata(String scopPlata) {
		this.scopPlata = scopPlata;
	}

	public float getSumaPlatita() {
		return sumaPlatita;
	}

	public void setSumaPlatita(float sumaPlatita) {
		this.sumaPlatita = sumaPlatita;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	public Casierie getCasierie() {
		return casierie;
	}

	public void setCasierie(Casierie casierie) {
		this.casierie = casierie;
	}


}
