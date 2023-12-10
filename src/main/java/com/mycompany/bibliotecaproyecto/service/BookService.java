package com.mycompany.bibliotecaproyecto.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

import com.mycompany.bibliotecaproyecto.models.Book;
import com.mycompany.bibliotecaproyecto.models.BookApi;
import com.mycompany.bibliotecaproyecto.models.Loan;

public class BookService {
	
	//uploadBooks
	public void uploadBooks(ArrayList<BookApi> books) {
		try {
			File f = new File("src\\main\\resources\\books.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(BookApi x: books) {
				bw.write(x.getTitle()+";.;"+x.getAuthor()+";.;"+x.getIsbn()+";.;"+x.getImage()+";.;"+x.getSummary()+"\n");
			}
			bw.close();
			fw.close();
		}catch (Exception e) {
			System.out.println("message: " + e.getMessage());
		}
	}
	
	//uploadBooksTable
		public void uploadBooksTable(ArrayList<BookApi> books) {
			try {
				File f = new File("src\\main\\resources\\booksTable.txt");
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(BookApi x: books) {
					bw.write(x.getTitle()+";.;"+x.getAuthor()+";.;"+x.getIsbn()+";.;"+x.getImage()+";.;"+x.getPages()+";.;"+x.getCategory()+";.;"+x.getYear()+";.;"+x.getSummary()+"\n");
				}
				bw.close();
				fw.close();
			}catch (Exception e) {
				System.out.println("message: " + e.getMessage());
			}
		}
		
		public ArrayList<BookApi> getBookFileForTable(){
			try {
				ArrayList<BookApi> books = new  ArrayList<BookApi>();
				File f = new File("src\\main\\resources\\booksTable.txt");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null){
					String[] data = line.split(";.;");
					if(data.length == 8) {
						books.add(new BookApi(data[3],data[1],data[0],Integer.parseInt(data[6]),Integer.parseInt(data[4]),data[5],Integer.parseInt(data[2]),data[7]));
					}else {
						books.add(new BookApi(data[3],data[1],data[0],Integer.parseInt(data[6]),Integer.parseInt(data[4]),data[5],Integer.parseInt(data[2]),null));
					}
				}
				return books;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
	
	//get info from book
	public ArrayList<Book> getBookFile(){
		try {
			ArrayList<Book> books = new  ArrayList<Book>();
			File f = new File("src\\main\\resources\\books.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				String[] data = line.split(";.;");
				if(data[2].equals("652365219") || data[2].equals("652365223")) {
					books.add(new Book(data[3],null,data[0],null,null,null,0,"Sin datos"));
				}else {
					books.add(new Book(data[3],null,data[0],null,null,null,0,data[4]));					
				}
			}
			return books;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//obtener los pasados de fecha
	public ArrayList<Loan> getDebtors(){
		ArrayList<Loan> debtors = null;
		try {			
			debtors = new ArrayList<Loan>();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			File f = new File("src\\main\\resources\\debtors.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				String[] data = line.split(";");
				debtors.add(new Loan(data[0],data[1],Integer.parseInt(data[2]),LocalDate.parse(data[3], formatter),LocalDate.parse(data[4], formatter)));
			}
			return debtors;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return debtors;
	}
	
    
}
