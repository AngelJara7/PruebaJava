package controller;

import model.Cliente;
import model.GestionEncabezadoTabla;
import view.ModuloCliente;
import view.ModuloEntradaDatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class ControllerCliente implements ActionListener, MouseListener {
	
	private Cliente cliente;
	private ModuloCliente moduloCliente;
	private ModuloEntradaDatos moduloEntradaDatos;
	Integer buscarCliente;
	
	public ControllerCliente(ModuloCliente moduloCliente, ModuloEntradaDatos moduloEntradaDatos, Cliente cliente) {
		this.cliente = cliente;
		this.moduloCliente = moduloCliente;
		this.moduloEntradaDatos = moduloEntradaDatos;
		this.moduloEntradaDatos.InicilizarComponentes();
		this.moduloEntradaDatos.b_guardar.addActionListener(this);
	}
	
	public void Iniciar() {
		moduloCliente.InicilizarComponentes();
		moduloCliente.b_buscar.addActionListener(this);
		moduloCliente.b_nuevo.addActionListener(this);
		moduloCliente.tabla.addMouseListener(this);
		
		moduloEntradaDatos.InicilizarComponentes();
		moduloEntradaDatos.b_guardar.addActionListener(this);
		moduloEntradaDatos.b_cancelar.addActionListener(this);
		
		CargarDatos();
	}
	
	public void CargarDatos(){
        cliente.setCliente(new Cliente("Angel", "Jaramillo", "1-111-111", "angel@correo.com"));
        cliente.setCliente(new Cliente("Juan", "Carmargo", "2-222-222", "juan@correo.com"));
        cliente.setCliente(new Cliente("José", "Murillo", "3-333-333", "jose@correo.com"));
        cliente.CargarDatos(moduloCliente.modelo);
    }
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("PRESIONANDO...");

        if (e.getSource() == moduloCliente.b_buscar) {
        	System.out.println("BUSCANDO...");
            CargarBusqueda();
        }

        if (e.getSource() == moduloCliente.b_nuevo) {
            //Guardar();
        	System.out.println("CREANDO...");
			moduloEntradaDatos.InicilizarComponentes();
			moduloEntradaDatos.entradaDatos.setVisible(true);
        }
        
        if (e.getSource().equals(moduloEntradaDatos.b_guardar)) {
        	moduloEntradaDatos.InicilizarComponentes();
        	System.out.println("GUARDANDO...");
        }

        if (e.getSource().equals(moduloEntradaDatos.b_cancelar)) {
        	System.out.println("CERRANDO...");
        	moduloEntradaDatos.InicilizarComponentes();
        	moduloEntradaDatos.entradaDatos.dispose();
        	moduloEntradaDatos.entradaDatos.setVisible(false);
        }

//        if (e.getSource() == moduloEntradaDatos.b_eliminar) {
//            //Eliminar();
//			this.moduloEntradaDatos.InicilizarComponentes();
//			this.moduloEntradaDatos.entradaDatos.setVisible(true);
//        }
    }
	
	public void CargarBusqueda() {
    	
    	if(moduloCliente.tf_buscar.getText().equalsIgnoreCase("")) {
    		JOptionPane.showMessageDialog(null, "Introduzca un número de cédula para realizar la búsqueda");
    		Limpiar();
    	} else {
    		
    		buscarCliente = cliente.Buscar(moduloCliente.tf_buscar.getText());
    		
    		if(cliente.getCedula().equals("")) {
    			JOptionPane.showMessageDialog(null, "El registro no existe");
    		}
    	}
    	
    	for(int i = 0; i < moduloCliente.tabla.getRowCount(); i++) {
			for(int y = 0; y <= moduloCliente.tabla.getColumnCount()-1; y++) {
				if(moduloCliente.tf_buscar.getText().equalsIgnoreCase(moduloCliente.modelo.getValueAt(i, y).toString())) {
					for(int x = 0; x < moduloCliente.tabla.getRowCount(); x++) {
						System.out.println("HOLA: "+moduloCliente.modelo.getValueAt(i, x));
						moduloCliente.tabla.changeSelection(i, x, false, false);
						//moduloCliente.tabla.getColumnModel().getColumn(x).setCellRenderer(new GestionCeldas(1));
					}
				}
			}
		}
		//moduloCliente.tabla.setRowSelectionInterval(1, 1);
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
    	moduloEntradaDatos.tf_nombre.setText("");
    	moduloEntradaDatos.tf_apellido.setText("");
    	moduloEntradaDatos.tf_cedula.setText("");
    	moduloEntradaDatos.tf_email.setText("");
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

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int fila = moduloCliente.tabla.getSelectedRow();
		int columna = 2;
		String valor = moduloCliente.tabla.getValueAt(fila, columna).toString();
		
		if(e.getClickCount() == 2) {
			cliente.Buscar(valor);
				
			moduloEntradaDatos.InicilizarComponentes();
    		moduloEntradaDatos.tf_nombre.setText(cliente.getNombre());
    		moduloEntradaDatos.tf_apellido.setText(cliente.getApellido());
    		moduloEntradaDatos.tf_cedula.setText(cliente.getCedula());
    		moduloEntradaDatos.tf_email.setText(cliente.getEmail());
			moduloEntradaDatos.entradaDatos.setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
