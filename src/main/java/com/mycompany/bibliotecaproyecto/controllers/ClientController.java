package com.mycompany.bibliotecaproyecto.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import com.mycompany.bibliotecaproyecto.models.Book;
import com.mycompany.bibliotecaproyecto.models.ClientModel;
import com.mycompany.bibliotecaproyecto.models.Loan;
import com.mycompany.bibliotecaproyecto.service.ClientService;
import com.mycompany.bibliotecaproyecto.service.TableCustom;
import com.mycompany.bibliotecaproyecto.views.ClientVista;

public class ClientController extends AccionesController implements ActionListener,KeyListener {
	
	ClientVista vistaCliente;
	
	public ClientController() {
		this.vistaCliente = new ClientVista();
	}
	
	public void init() {
		vistaCliente.setVisible(true);
		vistaCliente.btnNewButton.setEnabled(false);
		ArrayList<ClientModel> clients = clientService.getClients();
		showTableClient(clients);
		vistaCliente.table.setDefaultRenderer(Object.class, new TableCustom());
		vistaCliente.btnNewButton.addActionListener(this);
		vistaCliente.btnNewButton_1.addActionListener(this);
		vistaCliente.btnNewButton_2.addActionListener(this);
		vistaCliente.btnNewButton_3.addActionListener(this);
		vistaCliente.textField.addKeyListener(this);
		
		DefaultListModel<String> modelList = new DefaultListModel<>();
		vistaCliente.list.setModel(modelList);
		vistaCliente.table.setCellSelectionEnabled(true);
		showList(clients.get(0).getDni(),modelList);
		
		vistaCliente.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = vistaCliente.table.rowAtPoint(e.getPoint());
                int col = vistaCliente.table.columnAtPoint(e.getPoint());

                if (row != -1 && col != -1) {
                    Object value = vistaCliente.table.getValueAt(row, col);                       
                    showList(value,modelList);
                }
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaCliente.btnNewButton_3) {
			System.exit(0);
		}else if(e.getSource() == vistaCliente.btnNewButton_1) {
			vistaCliente.dispose();
			BookController c = new BookController();
			c.init();
		}else if(e.getSource() == vistaCliente.btnNewButton_2) {
			vistaCliente.dispose();
			LoanController c = new LoanController();
			c.init();
		}
		
	}
	
	public void showList(Object value,DefaultListModel<String> listModelAux) {
        vistaCliente.lblNewLabel_3.setText("Historial de libros: "+ value+"."); 
		DefaultListModel model = (DefaultListModel)vistaCliente.list.getModel();
        model.clear();
        	for(Loan z: debtors) {
        		if(z.getDni().equals(value)) {
        			listModelAux.addElement("Título: " + z.getTitle()+ ", Fecha entrega: " + z.getDateFinal());
        		}
            }
        	
        	for(Loan z: loan) {
        		if(z.getDni().equals(value)) {
        			listModelAux.addElement("Título: " + z.getTitle()+ ", Fecha entrega: " + z.getDateFinal());
        		}
            }
        	
        	Random r = new Random();
        	int numBooks = r.nextInt(3,8);
        	ArrayList<Book> booksRandom = bookService.getBookFile();
        	LocalDate fechaActual = LocalDate.now();
        	for(int c =0;c<numBooks; c++) {
                int diasAleatorios = ThreadLocalRandom.current().nextInt(0, 15);
                LocalDate fechaAleatoria = fechaActual.plusDays(diasAleatorios);
        		int auxBook = r.nextInt(0,(booksRandom.size()-1));
        		Book BookAux = booksRandom.get(auxBook);
        		listModelAux.addElement("Título: " + BookAux.getTitle()+ ", Fecha entrega: " + fechaAleatoria);
        	}
	}
	
	public void showTableClient(ArrayList<ClientModel> clienteModelAux) {
		DefaultTableModel model = (DefaultTableModel) vistaCliente.table.getModel();
        int filas = vistaCliente.table.getRowCount();
        for (int i = filas -1; i > -1; i--) {
        	model.removeRow(i);
        }
		for(ClientModel x: clienteModelAux) {
			if(x.getSanctioned()) {
				model.addRow(new Object[]{x.getDni(),x.getName(),x.getSurname(),x.getSurnameTwo(),x.getPhone(),"si"});
			}else {
				model.addRow(new Object[]{x.getDni(),x.getName(),x.getSurname(),x.getSurnameTwo(),x.getPhone(),"no"});
			}
		}
	}
	
	public void showTableClientFilter(ArrayList<ClientModel> clienteModelAux,String dniFilter) {
		DefaultTableModel model = (DefaultTableModel) vistaCliente.table.getModel();
        int filas = vistaCliente.table.getRowCount();
        for (int i = filas -1; i > -1; i--) {
        	model.removeRow(i);
        }
		for(ClientModel x: clienteModelAux) {
			if(x.getDni().contains(dniFilter)) {
				if(x.getSanctioned()) {
					model.addRow(new Object[]{x.getDni(),x.getName(),x.getSurname(),x.getSurnameTwo(),x.getPhone(),"si"});
				}else {
					model.addRow(new Object[]{x.getDni(),x.getName(),x.getSurname(),x.getSurnameTwo(),x.getPhone(),"no"});
				}
			}			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == vistaCliente.textField) {
			if(vistaCliente.textField.getText().length() >=2) {
				showTableClientFilter(clientService.getClients(),vistaCliente.textField.getText());
			}else {
				showTableClient(clientService.getClients());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
