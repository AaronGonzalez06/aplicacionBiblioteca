package com.mycompany.bibliotecaproyecto.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.mycompany.bibliotecaproyecto.views.Login;

public class LoginController implements ActionListener {
	
	private Login loginVista;

	public LoginController() {
		this.loginVista = new Login();
	}

	public void init() {
		loginVista.setVisible(true);
		loginVista.btnNewButton.addActionListener(this);
		loginVista.btnNewButton_1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginVista.btnNewButton) {
			if(loginVista.textField.getText().isEmpty() || loginVista.passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Algún campo esta vacío.");
			}else {
				char[] password = loginVista.passwordField.getPassword();
				String pass = new String(password);
				if(loginVista.textField.getText().equals("usuario") &&  pass.equals("usuario")) {
					loginVista.dispose();
					ClientController c = new ClientController();
					c.init();
				}else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectos.");
					loginVista.textField.setText("");
					loginVista.passwordField.setText("");
				}
			} 
		} else if (e.getSource() == loginVista.btnNewButton_1) {
			loginVista.textField.setText("");
			loginVista.passwordField.setText("");
		}
	}

}
