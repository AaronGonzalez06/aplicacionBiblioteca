package com.mycompany.bibliotecaproyecto.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mycompany.bibliotecaproyecto.styles.ColorsApp;
import com.mycompany.bibliotecaproyecto.styles.RoundedBorder;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class LoanVista extends JFrame{
	
	public JTable table;
	public JButton btnNewButton_3;
	public JButton btnNewButton_2;
	public JButton btnNewButton_1;
	public JButton btnNewButton;
	public JTextField textField;
	public JButton btnNewButton_5;
	public JButton btnNewButton_4;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JButton btnNewButton_6;
	public JButton btnNewButton_7;
	
	public LoanVista() {
		
		JPanel panel = new JPanel();
		panel.setBackground(ColorsApp.AMARILLO_SUAVE);
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_3 = new JLabel("Crear prestamo");
		panel.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_6);
		
		JLabel lblNewLabel_5 = new JLabel("DNI");
		panel_6.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("ISBN");
		panel_7.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		panel_7.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_8);
		
		btnNewButton_6 = new JButton("Aceptar");
		btnNewButton_6.setIcon((Icon) new ImageIcon("src\\main\\resources\\libro3.png"));
		btnNewButton_6.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_6.setBorder(new RoundedBorder(1));
		panel_8.add(btnNewButton_6);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_11);
		
		JLabel lblNewLabel_7 = new JLabel("Devolver libro");
		panel_11.add(lblNewLabel_7);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_12);
		
		JLabel lblNewLabel_4 = new JLabel("DNI");
		panel_12.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		panel_12.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_13);
		
		JLabel lblNewLabel_8 = new JLabel("ISBN");
		panel_13.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		panel_13.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_14);
		
		btnNewButton_7 = new JButton("Aceptar");
		btnNewButton_7.setIcon((Icon) new ImageIcon("src\\main\\resources\\estante-para-libros.png"));
		btnNewButton_7.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_7.setBorder(new RoundedBorder(1));
		panel_14.add(btnNewButton_7);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_5.add(panel_18);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(ColorsApp.AMARILLO_SUAVE);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		btnNewButton = new JButton("Clientes");
		btnNewButton.setIcon((Icon) new ImageIcon("src\\main\\resources\\libro2.png"));
		btnNewButton.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton.setBorder(new RoundedBorder(1));
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("libros");
		btnNewButton_1.setIcon((Icon) new ImageIcon("src\\main\\resources\\libro.png"));
		btnNewButton_1.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_1.setBorder(new RoundedBorder(1));
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Prestamos");
		btnNewButton_2.setIcon((Icon) new ImageIcon("src\\main\\resources\\libro1.png"));
		btnNewButton_2.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_2.setBorder(new RoundedBorder(1));
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Cerrar sesión");
		btnNewButton_3.setIcon((Icon) new ImageIcon("src\\main\\resources\\apagar.png"));
		btnNewButton_3.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_3.setBorder(new RoundedBorder(1));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_1.add(panel_4);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		btnNewButton_5 = new JButton("Buscar lector");
		btnNewButton_5.setIcon((Icon) new ImageIcon("src\\main\\resources\\libro2.png"));
		btnNewButton_5.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_5.setBorder(new RoundedBorder(1));
		panel_4.add(btnNewButton_5);
		
		btnNewButton_4 = new JButton("Resetear tabla");
		btnNewButton_4.setIcon((Icon) new ImageIcon("src\\main\\resources\\goma-de-borrar.png"));
		btnNewButton_4.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_4.setBorder(new RoundedBorder(1));
		panel_4.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(ColorsApp.AMARILLO_SUAVE);
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Biblioteca Los Rosales.");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sesión:");
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(ColorsApp.AMARILLO_SUAVE);
		getContentPane().add(panel_3, BorderLayout.CENTER);

		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("DNI");
		model.addColumn("Titulo");
		model.addColumn("ISBN");
		model.addColumn("Fecha inicio");
		model.addColumn("Fecha fin");
		model.addColumn("Dias pasados");
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel_3.add(scrollPane);
		

		//final
		setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
	}

}
