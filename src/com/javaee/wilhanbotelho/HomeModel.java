package com.javaee.wilhanbotelho;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeModel {
	protected String saudacao;
	
	public String getSaudacao() {
		return saudacao;
	}

	public void setSaudacao() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();     
		String reportDate = df.format(today);
		this.saudacao = "Data/Hora: "+reportDate;
	}
}
