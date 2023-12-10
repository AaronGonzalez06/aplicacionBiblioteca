package com.mycompany.bibliotecaproyecto.thread;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.mycompany.bibliotecaproyecto.models.BookApi;
import com.mycompany.bibliotecaproyecto.styles.ImgStyles;
import com.mycompany.bibliotecaproyecto.views.BookVista;

public class ShowImgInit extends Thread{
	BookVista bookvista;
	BookApi books;
	public ShowImgInit(BookVista bookVista,BookApi books){
		this.bookvista = bookVista;
		this.books = books;
	}
	@Override
	public void run() {
		try{
			ImageIcon gifIcon = new ImageIcon("src\\main\\resources\\cargando-loading-031.gif");
	        bookvista.lblNewLabel_3.setIcon(gifIcon);
	        bookvista.scrollPane_1.setVisible(false);
			//fin prueba
			URL url = new URL(books.getImage());
	        ImageIcon imagenDeFondoInicial = redimensionarImagen(url, 250, 400);
	        bookvista.lblNewLabel_3.setIcon(imagenDeFondoInicial);  
	        bookvista.scrollPane_1.setVisible(true);                  	        
	        bookvista.textArea.setText(books.getSummary());
	        //pruebas
	        ImgStyles styleLabel = new ImgStyles(Color.BLACK,2,true);
	        bookvista.lblNewLabel_3.setBorder(styleLabel);
	        //fin pruebas
		}catch (Exception e) {
			System.out.println("Message: "+e.getMessage());
		}
	}
	
	private ImageIcon redimensionarImagen(URL url, int ancho, int alto) {
        ImageIcon imagenOriginal = new ImageIcon(url);
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }
}
