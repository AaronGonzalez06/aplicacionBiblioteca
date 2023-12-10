package com.mycompany.bibliotecaproyecto.service;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCustomLoan extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		LocalDate fechaInit = (LocalDate) table.getValueAt(row, 3);
		LocalDate fechaFinal = (LocalDate) table.getValueAt(row, 4);
		LocalDate fechaActual = LocalDate.now();
		long diasDiferencia = ChronoUnit.DAYS.between(fechaInit, fechaFinal);
		long diasDiferenciaDesdeActual = ChronoUnit.DAYS.between(fechaInit, fechaActual);
		if (diasDiferenciaDesdeActual> diasDiferencia) {
			cell.setBackground(Color.RED);
			cell.setForeground(Color.WHITE);
		}else if(diasDiferenciaDesdeActual == diasDiferencia) {
			cell.setBackground(Color.YELLOW);
			cell.setForeground(Color.BLACK);
		} else {
			cell.setBackground(Color.GREEN);
			cell.setForeground(table.getForeground());
		}

		return cell;
	}
}
