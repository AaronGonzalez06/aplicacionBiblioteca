package com.mycompany.bibliotecaproyecto.service;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCustomBook extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (table.getValueAt(row, 5) != null && (String) table.getValueAt(row, 5) == "No disponible") {
			cell.setBackground(Color.RED);
			cell.setForeground(Color.WHITE);
		} else {
			cell.setBackground(Color.GREEN);
			cell.setForeground(table.getForeground());
		}

		return cell;
	}
}