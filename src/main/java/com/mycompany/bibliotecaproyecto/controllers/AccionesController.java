package com.mycompany.bibliotecaproyecto.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.mycompany.bibliotecaproyecto.models.BookApi;
import com.mycompany.bibliotecaproyecto.models.ClientModel;
import com.mycompany.bibliotecaproyecto.models.Loan;
import com.mycompany.bibliotecaproyecto.service.BookService;
import com.mycompany.bibliotecaproyecto.service.ClientService;
import com.mycompany.bibliotecaproyecto.service.DataBookApiService;
import com.mycompany.bibliotecaproyecto.service.LoanService;

public class AccionesController {
	DataBookApiService dataBookApiService = new DataBookApiService();
    ClientService clientService = new ClientService();
    BookService bookService = new BookService();
    LoanService loanService = new LoanService();
    ArrayList<Loan> debtors = new ArrayList<Loan>();
    ArrayList<Loan> loan = new ArrayList<Loan>();
    
    public AccionesController() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	debtors.add(new Loan("45678901C","The Endless Lake",652365238,LocalDate.parse("2023-11-20"),LocalDate.parse("2023-11-30")));
    	debtors.add(new Loan("45678901C","A Pack Divided",652365238,LocalDate.parse("2023-11-20"),LocalDate.parse("2023-11-30")));
    	

    	debtors.add(new Loan("23456789E","The Lost Continent",652365230,LocalDate.parse("2023-12-01"),LocalDate.parse("2023-12-10")));
    	debtors.add(new Loan("23456789E","Moon Rising",652365231,LocalDate.parse("2023-12-03"),LocalDate.parse("2023-12-13")));
    	debtors.add(new Loan("23456789E","Escaping Peril",652365232,LocalDate.parse("2023-12-03"),LocalDate.parse("2023-12-13")));
    	
    	//
    	loan.add(new Loan("56789012M","Phoebe the Moonlight Dragon",652365234,LocalDate.parse("2023-12-02"),LocalDate.parse("2023-12-12")));
    	loan.add(new Loan("34567890L","Storm of Dogs",652365235,LocalDate.parse("2023-12-02"),LocalDate.parse("2023-12-12")));
    	loan.add(new Loan("34567890L","A Pack Divided",652365236,LocalDate.parse("2023-11-28"),LocalDate.parse("2023-12-08")));
    	loan.add(new Loan("34567890L","Phoebe the Moonlight Dragon",652365234,LocalDate.parse("2023-12-05"),LocalDate.parse("2023-12-15")));
    	loan.add(new Loan("67890123T","Wings Of Fire ",652365233,LocalDate.parse("2023-12-04"),LocalDate.parse("2023-12-14")));
    	loan.add(new Loan("67890123T","Escaping Peril",652365232,LocalDate.parse("2023-12-04"),LocalDate.parse("2023-12-14")));
    	loan.add(new Loan("90123456S","Moon Rising",652365231,LocalDate.parse("2023-12-04"),LocalDate.parse("2023-12-14")));
    }

}
