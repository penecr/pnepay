package com.pene.model.entity;

import java.util.Date;


public class facturaDTO{
	
	Date data1;
	Date data2;
	float total;
	String descriere;
	String furnizor;
	
	public facturaDTO( Date d1, Date d2, float t, String d, String f) {
		
		this.data1=d1;
		this.data2=d2;
		this.total=t;
		this.descriere=d;
		this.furnizor=f;
	}
	
}
