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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "FACTURA")
public class Factura {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@NotNull(message = "Introduceti data emiterii")
	@Past(message = "Data Emiterii nu este corecta")
	@Column(name = "data_Emiterii")
	@Temporal(TemporalType.DATE)
	private Date dataEmiterii;

	@NotNull(message = "Introduceti data scadentei")
	@Column(name = "data_Scadenta")
	@Temporal(TemporalType.DATE)
	private Date dataScadenta;

	@NotNull(message = "Introduceti totalul facturii")
	@Min(value = 0, message = "Valoarea minima mai mare decat 0")
	@Column(name = "total_Factura")
	private float totalFactura;

	@NotNull(message = "Introduceti descrierea facturii")
	@Column(name = "descriere_Factura")
	private String descriereFactura;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "furnizor_id")
	@NotNull(message = "Introduceti Furnizor")
	private Furnizor furnizor;

	public Factura() {

	}

	public Long getId() {
		return id;
	}

	public String getDescriereFactura() {
		return descriereFactura;
	}

	public void setDescriereFactura(String descriereFactura) {
		this.descriereFactura = descriereFactura;
	}

	public Date getDataEmiterii() {
		return dataEmiterii;
	}

	public void setDataEmiterii(Date dataEmiterii) {
		this.dataEmiterii = dataEmiterii;
	}

	public Date getDataScadenta() {
		return dataScadenta;
	}

	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}

	public float getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(float totalFactura) {
		this.totalFactura = totalFactura;
	}

	public Furnizor getFurnizor() {
		return furnizor;
	}

	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;

	}
}
