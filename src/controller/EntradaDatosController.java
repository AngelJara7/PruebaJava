package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Cliente;
import view.ModuloCliente;
import view.ModuloEntradaDatos;

public class EntradaDatosController implements ActionListener {
	
	private Cliente cliente;
	private ModuloEntradaDatos moduloEntradaDatos;
	private ModuloCliente moduloCliente;
	Integer buscarCliente;
	
	public EntradaDatosController(ModuloCliente moduloCliente, ModuloEntradaDatos moduloEntradaDatos, Cliente cliente) {
		this.cliente = cliente;
		this.moduloEntradaDatos = moduloEntradaDatos;
		this.moduloCliente = moduloCliente;
	}
	
	public void Iniciar() {
		moduloEntradaDatos.InicilizarComponentes();
		moduloEntradaDatos.b_guardar.addActionListener(this);
		moduloEntradaDatos.b_cancelar.addActionListener(this);
		moduloEntradaDatos.b_eliminar.setEnabled(false);
		moduloEntradaDatos.b_eliminar.setBackground(new Color(192, 192, 192));
	}
	
	public void CargarDatosBusqueda(int id) {
		buscarCliente = id;
		moduloEntradaDatos.tf_nombre.setText(cliente.getNombre());
		moduloEntradaDatos.tf_apellido.setText(cliente.getApellido());
		moduloEntradaDatos.tf_cedula.setText(cliente.getCedula());
		moduloEntradaDatos.tf_email.setText(cliente.getEmail());
		
		moduloEntradaDatos.b_eliminar.addActionListener(this);
		moduloEntradaDatos.b_eliminar.setEnabled(true);
	}
	
	public void Guardar() {

        if (ValidarCampos()) {
            cliente.setCliente(new Cliente(
            		moduloEntradaDatos.tf_nombre.getText(), 
            		moduloEntradaDatos.tf_apellido.getText(), 
            		moduloEntradaDatos.tf_cedula.getText(), 
            		moduloEntradaDatos.tf_email.getText()
            	)
            );
            
            cliente.CargarDatos(moduloCliente.modelo);
            Limpiar();
        }
    }
	
	public void Actualizar(int id) {
		
    	if(ValidarCampos()) {
    		cliente.Actualizar(id, new Cliente(
    				moduloEntradaDatos.tf_nombre.getText(), 
    				moduloEntradaDatos.tf_apellido.getText(), 
    				moduloEntradaDatos.tf_cedula.getText(), 
    				moduloEntradaDatos.tf_email.getText()
    			)
    		);
    		cliente.CargarDatos(moduloCliente.modelo);
    	}
    }
	
	public boolean ValidarCampos() {
    	
    	String nombre, apellido, cedula, email;
    	
    	nombre = moduloEntradaDatos.tf_nombre.getText();
        apellido = moduloEntradaDatos.tf_apellido.getText();
        cedula = moduloEntradaDatos.tf_cedula.getText();
        email = moduloEntradaDatos.tf_email.getText();
        
        if (nombre.isEmpty() && apellido.isEmpty() && cedula.isEmpty() && email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se admiten campos vacíos", "Error al guardar", JOptionPane.ERROR_MESSAGE, null);
            return false;
        } else {
        	return true;
        }
    }
	
	public void Limpiar() {
    	moduloEntradaDatos.tf_nombre.setText("");
    	moduloEntradaDatos.tf_apellido.setText("");
    	moduloEntradaDatos.tf_cedula.setText("");
    	moduloEntradaDatos.tf_email.setText("");
        moduloCliente.tf_buscar.setText("");
        buscarCliente = null;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == moduloEntradaDatos.b_guardar) {
			
			if(buscarCliente == null) {
				Guardar();
			} else {
				Actualizar(buscarCliente);
			}
        }

        if (e.getSource() == moduloEntradaDatos.b_cancelar) {
        	moduloEntradaDatos.entradaDatos.dispose();
        	moduloEntradaDatos.entradaDatos.setVisible(false);
        }
	}

}
