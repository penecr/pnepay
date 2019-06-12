package com.pene.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="FURNIZOR")
public class Furnizor {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column(name="CIF")
	@NotNull(message="Introduceti CIF-ul")
	private String cif;
	
	@Column(name="denumire_Furnizor")
	@NotNull(message="Introduceti Denumirea Furnizorului")
	private String denumireFurnizor;
	
	@Column(name="iban_Furnizor")
	@NotNull(message="Introduceti IBAN-ul")
	private String ibanFurnizor;

	@Column(name="tip_Furnizor")
	@NotNull(message="Introduceti Tipul Furnizorului")
	private String tipFurnizor;
	
	@Column(name="banca_Furnizor")
	@NotNull(message="Introduceti Banca Furnizor")
	private String bancaFurnizor;
	
	@Column(name="persoana_Contact")
	@NotNull(message="Introduceti Persoana Contact")
	private String persoanaContact;
	
	@Column(name="email_Persoana")
	@NotNull(message="Introduceti E-mail")
	@Email(message="Introduceti un E-mail Valid")
	private String emailPersoana;
	


	public Furnizor() {

	}

	public Long getId() {
		return id;
	}

	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDenumireFurnizor() {
		return denumireFurnizor;
	}

	public void setDenumireFurnizor(String denumireFurnizor) {
		this.denumireFurnizor = denumireFurnizor;
	}

	public String getIbanFurnizor() {
		return ibanFurnizor;
	}

	public void setIbanFurnizor(String ibanFurnizor) {
		this.ibanFurnizor = ibanFurnizor;
	}

	public String getTipFurnizor() {
		return tipFurnizor;
	}

	public void setTipFurnizor(String tipFurnizor) {
		this.tipFurnizor = tipFurnizor;
	}

	public String getBancaFurnizor() {
		return bancaFurnizor;
	}

	public void setBancaFurnizor(String bancaFurnizor) {
		this.bancaFurnizor = bancaFurnizor;
	}

	public String getPersoanaContact() {
		return persoanaContact;
	}

	public void setPersoanaContact(String persoanaContact) {
		this.persoanaContact = persoanaContact;
	}

	public String getEmailPersoana() {
		return emailPersoana;
	}

	public void setEmailPersoana(String emailPersoana) {
		this.emailPersoana = emailPersoana;
	}

	@Override
	public String toString() {
		return this.denumireFurnizor;
	}
	


	
	
}
