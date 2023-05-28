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
	
	public EntradaDatosController(ModuloCliente moduloCliente, ModuloEntradaDatos moduloEntradaDatos, Cliente cliente) {
		this.cliente = cliente;
		this.moduloEntradaDatos = moduloEntradaDatos;
		this.moduloCliente = moduloCliente;
	}
	
	public void Iniciar() {
		moduloEntradaDatos.InicilizarComponentes();
		moduloEntradaDatos.b_guardar.addActionListener(this);
		moduloEntradaDatos.b_cancelar.addActionListener(this);
		moduloEntradaDatos.b_eliminar.addActionListener(this);
		
		if (cliente.getCedula().equalsIgnoreCase("")) {
			moduloEntradaDatos.tf_cedula.setEditable(true);
			moduloEntradaDatos.b_eliminar.setEnabled(false);
			moduloEntradaDatos.b_eliminar.setBackground(new Color(192, 192, 192));
		}
	}
	
	public void CargarDatosBusqueda(String cedula) {
		//buscarCliente = id;
		moduloEntradaDatos.tf_nombre.setText(cliente.getNombre());
		moduloEntradaDatos.tf_apellido.setText(cliente.getApellido());
		moduloEntradaDatos.tf_cedula.setText(cliente.getCedula());
		moduloEntradaDatos.tf_email.setText(cliente.getEmail());
		
		if (!cedula.equals("")) {
			moduloEntradaDatos.tf_cedula.setEditable(false);
			moduloEntradaDatos.tf_cedula.setBackground(Color.WHITE);
			moduloEntradaDatos.b_eliminar.setEnabled(true);
			moduloEntradaDatos.b_eliminar.setBackground(new Color(12, 120, 84));
		}
	}
	
	public void Guardar() {

        if (ValidarCampos()) {
//            cliente.setCliente(new Cliente(
//            		moduloEntradaDatos.tf_nombre.getText(), 
//            		moduloEntradaDatos.tf_apellido.getText(), 
//            		moduloEntradaDatos.tf_cedula.getText(), 
//            		moduloEntradaDatos.tf_email.getText()
//            	)
//            );
        	cliente.setNombre(moduloEntradaDatos.tf_nombre.getText());
        	cliente.setApellido(moduloEntradaDatos.tf_apellido.getText());
        	cliente.setCedula(moduloEntradaDatos.tf_cedula.getText());
        	cliente.setEmail(moduloEntradaDatos.tf_email.getText());
        	cliente.CrearCliente();
            
            cliente.CargarDatos(moduloCliente.modelo);
            cliente.Inicializar();
            LimpiarCampos();
        }
    }
	
	public void Actualizar(String cedula) {
		
    	if(ValidarCampos()) {
//    		cliente.Actualizar(id, new Cliente(
//    				moduloEntradaDatos.tf_nombre.getText(), 
//    				moduloEntradaDatos.tf_apellido.getText(), 
//    				moduloEntradaDatos.tf_cedula.getText(), 
//    				moduloEntradaDatos.tf_email.getText()
//    			)
//    		);
    		cliente.setNombre(moduloEntradaDatos.tf_nombre.getText());
        	cliente.setApellido(moduloEntradaDatos.tf_apellido.getText());
        	cliente.setCedula(moduloEntradaDatos.tf_cedula.getText());
        	cliente.setEmail(moduloEntradaDatos.tf_email.getText());
        	if (cliente.Actualizar()) {
        		JOptionPane.showMessageDialog(null, "Registro actualizado", "Actualizar Registro", JOptionPane.PLAIN_MESSAGE, null);
        	}
        	
    		cliente.CargarDatos(moduloCliente.modelo);
    	}
    }
	
	public void Eliminar(String cedula) {
		int confirmacion = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro", "Eliminar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.OK_CANCEL_OPTION);
		
		if (confirmacion == JOptionPane.YES_OPTION) {
			cliente.Eliminar(cedula);
			cliente.CargarDatos(moduloCliente.modelo);
			moduloEntradaDatos.entradaDatos.dispose();
		}
	}
	
	public boolean ValidarCampos() {
    	
    	String nombre, apellido, cedula, email;
    	
    	nombre = moduloEntradaDatos.tf_nombre.getText();
        apellido = moduloEntradaDatos.tf_apellido.getText();
        cedula = moduloEntradaDatos.tf_cedula.getText();
        email = moduloEntradaDatos.tf_email.getText();
        
        if (nombre.equals("") || apellido.equals("") || cedula.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(null, "No se admiten campos vacíos", "Error al guardar", JOptionPane.ERROR_MESSAGE, null);
            return false;
        } else {
        	return true;
        }
    }
	
	public void LimpiarCampos() {
    	moduloEntradaDatos.tf_nombre.setText("");
    	moduloEntradaDatos.tf_apellido.setText("");
    	moduloEntradaDatos.tf_cedula.setText("");
    	moduloEntradaDatos.tf_email.setText("");
        moduloCliente.tf_buscar.setText("");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == moduloEntradaDatos.b_guardar) {
			
			if(cliente.getCedula().equalsIgnoreCase("")) {
				Guardar();
			} else {
				Actualizar(moduloEntradaDatos.tf_cedula.getText());
			}
        }

        if (e.getSource() == moduloEntradaDatos.b_cancelar) {
        	LimpiarCampos();
        	cliente.Inicializar();
        	moduloEntradaDatos.entradaDatos.dispose();
        }
        
        if (e.getSource() == moduloEntradaDatos.b_eliminar ) {
        	if (!moduloEntradaDatos.tf_cedula.getText().equals("")) {
        		Eliminar(moduloEntradaDatos.tf_cedula.getText());
        	}
        }
	}
}
