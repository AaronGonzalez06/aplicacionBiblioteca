package com.mycompany.bibliotecaproyecto.models;

import java.time.LocalDate;

public class Loan {
	
	String dni;
	String title;
	int isbn;
	LocalDate dateInit;
	LocalDate dateFinal;
	
	public Loan(String dni, String title, int isbn, LocalDate dateInit, LocalDate dateFinal) {
		this.dni = dni;
		this.title = title;
		this.isbn = isbn;
		this.dateInit = dateInit;
		this.dateFinal = dateFinal;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDateInit() {
		return dateInit;
	}

	public void setDateInit(LocalDate dateInit) {
		this.dateInit = dateInit;
	}

	public LocalDate getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(LocalDate dateFinal) {
		this.dateFinal = dateFinal;
	}
	
	
	
	

}
