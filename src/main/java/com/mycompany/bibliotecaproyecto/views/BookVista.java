package com.mycompany.bibliotecaproyecto.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class BookVista extends JFrame{
	public JTable table;
	public JButton btnNewButton_3;
	public JButton btnNewButton_2;
	public JButton btnNewButton_1;
	public JButton btnNewButton;
	public JLabel lblNewLabel_3;
	public JTextArea textArea;
	public JComboBox comboBox;
	public JLabel lblNewLabel_4;
	public JScrollPane scrollPane_1;
	public BookVista() {
		
		JPanel panel = new JPanel();
		panel.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new EmptyBorder(0, 0, 5, 0));
		panel.add(lblNewLabel_3);
		
		textArea = new JTextArea();
		//panel.add(textArea);
		scrollPane_1 = new JScrollPane(textArea);
		panel.add(scrollPane_1);
		
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
		//panel_1.add(btnNewButton_3);
		
		comboBox = new JComboBox();
		comboBox.addItem("Sin filtro");
		comboBox.addItem("Science Fiction & Fantasy");
		comboBox.addItem("Fiction, Non-fiction & Poetry");
		panel_1.add(comboBox);
		
		lblNewLabel_4 = new JLabel("Libros:");
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
		model.addColumn("Titulo");
		model.addColumn("Autor");
		model.addColumn("Categoria");
		model.addColumn("Año");
		model.addColumn("ISBN");
		model.addColumn("estado");
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.add(scrollPane);
		

		//final
		setPreferredSize(new Dimension(980, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
	}

}