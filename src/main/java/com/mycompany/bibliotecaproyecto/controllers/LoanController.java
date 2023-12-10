package com.mycompany.bibliotecaproyecto.controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mycompany.bibliotecaproyecto.models.Loan;
import com.mycompany.bibliotecaproyecto.service.TableCustomLoan;
import com.mycompany.bibliotecaproyecto.views.LoanVista;

public class LoanController extends AccionesController implements ActionListener {
	
	LoanVista loanvista;
	
	public LoanController() {
		this.loanvista = new LoanVista();
	}
	
	public void init() {
		loanvista.setVisible(true);
		loanvista.btnNewButton_2.setEnabled(false);
		DefaultTableModel model = (DefaultTableModel) loanvista.table.getModel();
		LocalDate fechaActual = LocalDate.now();
		for (Loan x : debtors) {			
			long diasDiferencia = ChronoUnit.DAYS.between(x.getDateInit(), fechaActual);
			model.addRow(new Object[] { x.getDni(), x.getTitle(), x.getIsbn(), x.getDateInit(), x.getDateFinal(),diasDiferencia});
		}
		for (Loan x : loan) {			
			long diasDiferencia = ChronoUnit.DAYS.between(x.getDateInit(), fechaActual);
			model.addRow(new Object[] { x.getDni(), x.getTitle(), x.getIsbn(), x.getDateInit(), x.getDateFinal(),diasDiferencia});
		}
		loanvista.table.setDefaultRenderer(Object.class, new TableCustomLoan());
		loanvista.btnNewButton.addActionListener(this);
		loanvista.btnNewButton_1.addActionListener(this);
		loanvista.btnNewButton_2.addActionListener(this);
		loanvista.btnNewButton_3.addActionListener(this);
		loanvista.btnNewButton_4.addActionListener(this);
		loanvista.btnNewButton_5.addActionListener(this);
		loanvista.btnNewButton_6.addActionListener(this);
		loanvista.btnNewButton_7.addActionListener(this);
		loanvista.table.setCellSelectionEnabled(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loanvista.btnNewButton_3) {
			System.exit(0);
		}else if(e.getSource() == loanvista.btnNewButton) {
			loanvista.dispose();
			ClientController c = new ClientController();
			c.init();
		}else if(e.getSource() == loanvista.btnNewButton_1) {
			loanvista.dispose();
			BookController c = new BookController();
			c.init();
		}else if(e.getSource() == loanvista.btnNewButton_5) {	
			String dni = loanvista.textField.getText();
			DefaultTableModel modelo = (DefaultTableModel) loanvista.table.getModel();
            int filas = loanvista.table.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }
            
            DefaultTableModel model = (DefaultTableModel) loanvista.table.getModel();
    		LocalDate fechaActual = LocalDate.now();
    		int aux=0;
    		for (Loan x : debtors) {			
    			long diasDiferencia = ChronoUnit.DAYS.between(x.getDateInit(), fechaActual);
    			if(x.getDni().equals(dni)) {
    				aux++;
        			model.addRow(new Object[] { x.getDni(), x.getTitle(), x.getIsbn(), x.getDateInit(), x.getDateFinal(),diasDiferencia});
    			}
    		}
    		for (Loan x : loan) {			
    			long diasDiferencia = ChronoUnit.DAYS.between(x.getDateInit(), fechaActual);
    			if(x.getDni().equals(dni)) {
    				aux++;
        			model.addRow(new Object[] { x.getDni(), x.getTitle(), x.getIsbn(), x.getDateInit(), x.getDateFinal(),diasDiferencia});
    			}
    		}
    		if(aux ==0) {
    			showDataTable(loan,debtors);
				JOptionPane.showMessageDialog(null, "lector " + dni+" no encontrado");
    		}
		}else if(e.getSource() == loanvista.btnNewButton_4) {
			showDataTable(loan,debtors);
		}else if(e.getSource() == loanvista.btnNewButton_6) {
			String dni = loanvista.textField_1.getText();
			String isbn = loanvista.textField_2.getText();
			if(dni.isEmpty() || isbn.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Campos imcompletos");
			}else {
				int confirmado = JOptionPane.showConfirmDialog(null, "¿Seguro de la acción?");
				if (JOptionPane.OK_OPTION == confirmado){
					//add
					ArrayList<Loan> updateLoans=loanService.addLoan(loan,dni,isbn);
	    			showDataTable(updateLoans,debtors);
				}else {
					JOptionPane.showMessageDialog(null, "Operación cancelada.");
				}
			}
		}else if(e.getSource() == loanvista.btnNewButton_7) {
			String dni = loanvista.textField_3.getText();
			String isbn = loanvista.textField_4.getText();
			if(dni.isEmpty() || isbn.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Campos imcompletos");
			}else {
				int confirmado = JOptionPane.showConfirmDialog(null, "¿Seguro de la acción?");
				if (JOptionPane.OK_OPTION == confirmado){
					ArrayList<Loan> updateLoans=loanService.deleteLoan(loan,dni,isbn);
					if(updateLoans == null) {
						JOptionPane.showMessageDialog(null, "Datos incorrectos.");
					}else {
		    			showDataTable(updateLoans,debtors);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Operación cancelada.");
				}
			}
		}
		
	}
	
	private ImageIcon redimensionarImagen(URL url, int ancho, int alto) {
        ImageIcon imagenOriginal = new ImageIcon(url);
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }
	
	private void showDataTable(ArrayList<Loan> loanUpdate, ArrayList<Loan> debtorsUpdate) {
		DefaultTableModel modelo = (DefaultTableModel) loanvista.table.getModel();
        int filas = loanvista.table.getRowCount();
        for (int i = filas -1; i > -1; i--) {
            modelo.removeRow(i);
        }
        
        DefaultTableModel model = (DefaultTableModel) loanvista.table.getModel();
		LocalDate fechaActual = LocalDate.now();
		for (Loan x : debtorsUpdate) {			
			long diasDiferencia = ChronoUnit.DAYS.between(x.getDateInit(), fechaActual);
			model.addRow(new Object[] { x.getDni(), x.getTitle(), x.getIsbn(), x.getDateInit(), x.getDateFinal(),diasDiferencia});
		}
		for (Loan x : loanUpdate) {			
			long diasDiferencia = ChronoUnit.DAYS.between(x.getDateInit(), fechaActual);
			model.addRow(new Object[] { x.getDni(), x.getTitle(), x.getIsbn(), x.getDateInit(), x.getDateFinal(),diasDiferencia});
		}
	}

}
