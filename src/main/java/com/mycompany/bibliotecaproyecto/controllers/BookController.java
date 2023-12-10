package com.mycompany.bibliotecaproyecto.controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import com.mycompany.bibliotecaproyecto.models.Book;
import com.mycompany.bibliotecaproyecto.models.BookApi;
import com.mycompany.bibliotecaproyecto.service.TableCustomBook;
import com.mycompany.bibliotecaproyecto.thread.ShowImgInit;
import com.mycompany.bibliotecaproyecto.views.BookVista;

public class BookController extends AccionesController implements ActionListener {
	
	BookVista bookvista;
	
	public BookController() {
		this.bookvista = new BookVista();
	}
	
	public void init() {
		File f = new File("src\\main\\resources\\booksTable.txt");
		ArrayList<BookApi> books = null;
		if(!f.exists()) {
			bookService.uploadBooksTable(dataBookApiService.getBooks());
			books = bookService.getBookFileForTable();
		}else {
			books = bookService.getBookFileForTable();
		}
		//bookService.uploadBooks(books);
		ArrayList<Book> BooksFile = bookService.getBookFile();
		bookvista.setVisible(true);
		bookvista.btnNewButton_1.setEnabled(false);
		showTableBook(books);		
		Thread showImg = new ShowImgInit(bookvista, books.get(0));
		showImg.start();
		bookvista.table.setDefaultRenderer(Object.class, new TableCustomBook());
		bookvista.btnNewButton.addActionListener(this);
		bookvista.btnNewButton_1.addActionListener(this);
		bookvista.btnNewButton_2.addActionListener(this);
		bookvista.btnNewButton_3.addActionListener(this);
		bookvista.comboBox.addActionListener(this);
		bookvista.textArea.setLineWrap(true);
		bookvista.textArea.setWrapStyleWord(true);
		bookvista.table.setCellSelectionEnabled(true);
		
		bookvista.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = bookvista.table.rowAtPoint(e.getPoint());
                int col = bookvista.table.columnAtPoint(e.getPoint());

                if (row != -1 && col != -1) {
                    Object value = bookvista.table.getValueAt(row, col);
            		try {
            			for(Book r : BooksFile) {
            				if(r.getTitle().equals(value)) {
            					URL url = new URL(r.getImage());
                    	        ImageIcon imagenDeFondoInicial = redimensionarImagen(url, 250, 400);
                    	        bookvista.lblNewLabel_3.setIcon(imagenDeFondoInicial);                    	        
                    	        bookvista.textArea.setText(r.getSummary());
                    	        break;
            				}
            			}            			
            		}catch (Exception y) {
            			System.out.println(y.getMessage());
            		}
                    
                }
            }
        });
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bookvista.btnNewButton_3) {
			System.exit(0);
		}else if(e.getSource() == bookvista.btnNewButton) {
			bookvista.dispose();
			ClientController c = new ClientController();
			c.init();
		}else if(e.getSource() == bookvista.btnNewButton_2) {
			bookvista.dispose();
			LoanController c = new LoanController();
			c.init();
		}else if (e.getSource() == bookvista.comboBox) {
			String filter = bookvista.comboBox.getSelectedItem().toString();
			if(filter.equals("Sin filtro")) {
				showTableBook(bookService.getBookFileForTable());
			}else{
				showTableBookFilter(bookService.getBookFileForTable(),filter);
			}
		}
		
	}
	
	private ImageIcon redimensionarImagen(URL url, int ancho, int alto) {
        ImageIcon imagenOriginal = new ImageIcon(url);
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }
	
	private void showTableBook(ArrayList<BookApi> booksAux) {
		DefaultTableModel model = (DefaultTableModel) bookvista.table.getModel();
		int filas = bookvista.table.getRowCount();
        for (int i = filas -1; i > -1; i--) {
        	model.removeRow(i);
        }
        int aux= 0;
		for(BookApi x: booksAux) {
			aux++;
			if(x.getTitle().equals("A Pack Divided") || x.getTitle().equals("The Endless Lake")) {
				model.addRow(new Object[]{x.getTitle(),x.getAuthor(),x.getCategory(),x.getYear(),x.getIsbn(),"No disponible"});
			}else {
				model.addRow(new Object[]{x.getTitle(),x.getAuthor(),x.getCategory(),x.getYear(),x.getIsbn(),"Disponible"});
			}
		}
		bookvista.lblNewLabel_4.setText("Libros: " +aux);
	}
	
	private void showTableBookFilter(ArrayList<BookApi> booksAux,String category) {
		DefaultTableModel model = (DefaultTableModel) bookvista.table.getModel();
		int filas = bookvista.table.getRowCount();
        for (int i = filas -1; i > -1; i--) {
        	model.removeRow(i);
        }
        int aux= 0;
		for(BookApi x: booksAux) {
			if(x.getCategory().equals(category)) {
				aux++;
				if(x.getTitle().equals("A Pack Divided") || x.getTitle().equals("The Endless Lake")) {
					model.addRow(new Object[]{x.getTitle(),x.getAuthor(),x.getCategory(),x.getYear(),x.getIsbn(),"No disponible"});
				}else {
					model.addRow(new Object[]{x.getTitle(),x.getAuthor(),x.getCategory(),x.getYear(),x.getIsbn(),"Disponible"});
				}
			}			
		}
		bookvista.lblNewLabel_4.setText("Libros: " +aux);
	}

}
