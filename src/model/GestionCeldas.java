package model;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer {
	
	Integer row = null;
	
	public GestionCeldas(int row) {
		this.row = row;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		if(this.row == row) {
			System.out.println("COINCIDEN");
			setBackground(new Color(192, 192, 192));
		}
		return this;
	}
}