package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Cliente;
import view.ModuloEntradaDatos;

public class EntradaDatosController implements ActionListener {
	
	private Cliente cliente;
	private ModuloEntradaDatos moduloEntradaDatos;
	
	public EntradaDatosController(ModuloEntradaDatos moduloEntradaDatos, Cliente cliente) {
		this.cliente = cliente;
		this.moduloEntradaDatos = moduloEntradaDatos;
	}
	
	public void Iniciar() {
		moduloEntradaDatos.InicilizarComponentes();
		moduloEntradaDatos.b_guardar.addActionListener(this);
		moduloEntradaDatos.b_cancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == moduloEntradaDatos.b_guardar) {
        	System.out.println("GUARDANDO...");
        }

        if (e.getSource() == moduloEntradaDatos.b_cancelar) {
        	System.out.println("CERRANDO...");
        	moduloEntradaDatos.entradaDatos.dispose();
        	moduloEntradaDatos.entradaDatos.setVisible(false);
        }
	}

}
