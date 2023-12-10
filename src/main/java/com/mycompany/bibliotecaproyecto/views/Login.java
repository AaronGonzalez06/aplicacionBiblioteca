package com.mycompany.bibliotecaproyecto.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import com.mycompany.bibliotecaproyecto.styles.ColorsApp;
import com.mycompany.bibliotecaproyecto.styles.RoundedBorder;

import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame{
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public Login() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(ColorsApp.AMARILLO_SUAVE);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Biblioteca Los Rosales.");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(200, 200));
		textField.setColumns(10);
		panel_2.add(textField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		panel_3.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setMaximumSize(new Dimension(200, 200));
		panel_3.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(ColorsApp.AMARILLO_SUAVE);
		panel.add(panel_4);
		btnNewButton = new JButton("Acceder");
		btnNewButton.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton.setIcon((Icon) new ImageIcon("src\\main\\resources\\libro-de-lectura.png"));
		btnNewButton.setBorder(new RoundedBorder(1));
		panel_4.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Borrar datos");
		btnNewButton_1.setBackground(ColorsApp.NARANJA_SUAVE);
		btnNewButton_1.setBorder(new RoundedBorder(1));
		btnNewButton_1.setIcon((Icon) new ImageIcon("src\\main\\resources\\goma-de-borrar.png"));
		panel_4.add(btnNewButton_1);
		
		setPreferredSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
	}
}
