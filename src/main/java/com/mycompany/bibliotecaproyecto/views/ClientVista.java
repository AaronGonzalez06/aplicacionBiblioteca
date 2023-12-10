package com.mycompany.bibliotecaproyecto.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mycompany.bibliotecaproyecto.styles.ColorsApp;
import com.mycompany.bibliotecaproyecto.styles.RoundedBorder;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientVista extends JFrame{
	public JTable table;
	public JButton btnNewButton_3;
	public JButton btnNewButton_2;
	public JButton btnNewButton_1;
	public JButton btnNewButton;
	public JList list;
	public JLabel lblNewLabel_3;
	public JTextField textField;
	
	public ClientVista() {
		
		JPanel panel = new JPanel();
		panel.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		lblNewLabel_3 = new JLabel("Historial de libros.");
		panel.add(lblNewLabel_3);
		
		list = new JList();
		panel.add(list);				
		
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
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Filtre por DNI");
		panel_1.add(lblNewLabel_4);
		
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
		model.addColumn("Nombre");
		model.addColumn("Apellido 1");
		model.addColumn("Apellido 2");
		model.addColumn("Teléfono");
		model.addColumn("Libros a devolver");
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.add(scrollPane);
		
		//final

		setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
	}

}