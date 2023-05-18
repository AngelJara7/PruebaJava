package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Cliente;
import view.ModuloCliente;
import view.ModuloEntradaDatos;

public class ControllerCliente implements ActionListener {
	
	private Cliente cliente;
	private ModuloCliente moduloCliente;
	private ModuloEntradaDatos moduloEntradaDatos;
	Integer buscarCliente;
	
	public ControllerCliente(ModuloCliente moduloCliente, Cliente cliente) {
		this.cliente = cliente;
		this.moduloCliente = moduloCliente;
	}
	
	public void Iniciar() {
		moduloCliente.InicilizarComponentes();
		moduloCliente.b_buscar.addActionListener(this);
		moduloCliente.b_guardar.addActionListener(this);
		moduloCliente.b_actualizar.addActionListener(this);
		moduloCliente.b_eliminar.addActionListener(this);
		CargarDatos();
	}
	
	public void CargarDatos(){
        cliente.setCliente(new Cliente("Angel", "Jaramillo", "1-111-111", "angel@correo.com"));
        cliente.setCliente(new Cliente("Juan", "Carmargo", "2-222-222", "juan@correo.com"));
        cliente.setCliente(new Cliente("José", "Murillo", "3-333-333", "jose@correo.com"));
        cliente.CargarDatos(moduloCliente.modelo);
    }
	
	public void actionPerformed(ActionEvent e) {

        if (e.getSource() == moduloCliente.b_buscar) {
            CargarBusqueda();
        }

        if (e.getSource() == moduloCliente.b_guardar) {
            Guardar();
        }

        if (e.getSource() == moduloCliente.b_actualizar) {
            Actualizar();
        }

        if (e.getSource() == moduloCliente.b_eliminar) {
            //Eliminar();
        	moduloEntradaDatos = new ModuloEntradaDatos();
			moduloEntradaDatos.InicilizarComponentes();
			moduloEntradaDatos.entradaDatos.setVisible(true);
        }
    }
	
	public void CargarBusqueda() {
    	
    	if(moduloCliente.tf_buscar.getText().equalsIgnoreCase("")) {
    		JOptionPane.showMessageDialog(null, "Introduzca un número de cédula para realizar la búsqueda");
    		Limpiar();
    	} else {
    		
    		buscarCliente = cliente.Buscar(moduloCliente.tf_buscar.getText());
    		
    		if(cliente.getCedula().equals("")) {
    			JOptionPane.showMessageDialog(null, "El registro no existe");
        		Limpiar();
    		} else {
    			moduloCliente.tf_nombre.setText(cliente.getNombre());
    			moduloCliente.tf_apellido.setText(cliente.getApellido());
    			moduloCliente.tf_cedula.setText(cliente.getCedula());
    			moduloCliente.tf_email.setText(cliente.getEmail());
    		}
    	}
    }

    public void Guardar() {

        if (ValidarCampos()) {
            cliente.setCliente(new Cliente(
            		moduloCliente.tf_nombre.getText(), 
            		moduloCliente.tf_apellido.getText(), 
            		moduloCliente.tf_cedula.getText(), 
            		moduloCliente.tf_email.getText()
            	)
            );
            
            cliente.CargarDatos(moduloCliente.modelo);
            Limpiar();
        }
    }
    
    public void Actualizar() {
    	
    	if(ValidarCampos()) {
    		cliente.Actualizar(buscarCliente, new Cliente(
    				moduloCliente.tf_nombre.getText(), 
    				moduloCliente.tf_apellido.getText(), 
    				moduloCliente.tf_cedula.getText(), 
    				moduloCliente.tf_email.getText()
    			)
    		);
    		
    		cliente.CargarDatos(moduloCliente.modelo);
            Limpiar();
    	}
    }
    
    public void Eliminar() {
    	if(buscarCliente == null) {
    		System.out.println("NO SE PUEDE ELIMINAR");
    	} else {
    		cliente.Eliminar(buscarCliente);
    		cliente.CargarDatos(moduloCliente.modelo);
    		Limpiar();
    	}
    }

    public void Limpiar() {
        moduloCliente.tf_nombre.setText("");
        moduloCliente.tf_apellido.setText("");
        moduloCliente.tf_cedula.setText("");
        moduloCliente.tf_email.setText("");
        moduloCliente.tf_buscar.setText("");
        buscarCliente = null;
    }
    
    public boolean ValidarCampos() {
    	
    	String nombre, apellido, cedula, email;
    	
    	nombre = moduloCliente.tf_nombre.getText();
        apellido = moduloCliente.tf_apellido.getText();
        cedula = moduloCliente.tf_cedula.getText();
        email = moduloCliente.tf_email.getText();
        
        if (nombre.isEmpty() && apellido.isEmpty() && cedula.isEmpty() && email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se admiten campos vacíos");
            return false;
        } else {
        	return true;
        }
    }
}
