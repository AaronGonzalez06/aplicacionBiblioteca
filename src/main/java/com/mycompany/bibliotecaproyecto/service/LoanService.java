package com.mycompany.bibliotecaproyecto.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.mycompany.bibliotecaproyecto.models.Loan;

public class LoanService {
	
	public ArrayList<Loan> addLoan(ArrayList<Loan> loan, String dni, String isbn) {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaFutura = fechaActual.plusDays(10);
		Loan newLoan = new Loan(dni,"Winter Turning",Integer.parseInt(isbn),fechaActual,fechaFutura);
		loan.add(newLoan);
		return loan;
	}
	
	public ArrayList<Loan> deleteLoan(ArrayList<Loan> loan, String dni, String isbn) {
		int aux = 0;
		boolean change = false;
		for (Loan x : loan) {
			if (x.getDni().equals(dni) && x.getIsbn() == Integer.parseInt(isbn)) {
				change = true;
				break;
			}
			aux++;
		}

		if (change) {
			loan.remove(aux);
			return loan;
		}
		return null;
	}
    
}
