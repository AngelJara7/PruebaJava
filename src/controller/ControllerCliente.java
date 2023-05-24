package controller;

import model.Cliente;
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
	Integer buscarCliente;
	
	EntradaDatosController entradaDatosController;
	ModuloEntradaDatos moduloEntradaDatos;
	
	public ControllerCliente(ModuloCliente moduloCliente, Cliente cliente) {
		this.cliente = cliente;
		this.moduloCliente = moduloCliente;
	}
	
	public void Iniciar() {
		moduloCliente.InicilizarComponentes();
		moduloCliente.b_buscar.addActionListener(this);
		moduloCliente.b_nuevo.addActionListener(this);
		moduloCliente.tabla.addMouseListener(this);
		
		moduloEntradaDatos = new ModuloEntradaDatos();
		
		entradaDatosController = new EntradaDatosController(moduloCliente, moduloEntradaDatos, cliente);
		entradaDatosController.Iniciar();
		
		CargarDatos();
	}
	
	public void CargarDatos(){
        cliente.setCliente(new Cliente("Angel", "Jaramillo", "1-111-111", "angel@correo.com"));
        cliente.setCliente(new Cliente("Juan", "Carmargo", "2-222-222", "juan@correo.com"));
        cliente.setCliente(new Cliente("José", "Murillo", "3-333-333", "jose@correo.com"));
        cliente.CargarDatos(moduloCliente.modelo);
    }
	
	public void CargarBusqueda() {
		
		buscarCliente = cliente.Buscar(moduloCliente.tf_buscar.getText());
    	
    	if(moduloCliente.tf_buscar.getText().equalsIgnoreCase("") && cliente.getCedula().equals("")) {
    		JOptionPane.showMessageDialog(null, "El registro no existe\n Introduzca un número de cédula válido", "Error de búsqueda", JOptionPane.ERROR_MESSAGE, null);
    	} else {
    		
    		for(int i = 0; i < moduloCliente.tabla.getRowCount(); i++) {
    			for(int y = 0; y <= moduloCliente.tabla.getColumnCount()-1; y++) {
    				if(moduloCliente.tf_buscar.getText().equalsIgnoreCase(moduloCliente.modelo.getValueAt(i, y).toString())) {
    					for(int x = 0; x < moduloCliente.tabla.getRowCount(); x++) {
    						moduloCliente.tabla.changeSelection(i, x, false, false);
    						//moduloCliente.tabla.getColumnModel().getColumn(x).setCellRenderer(new GestionCeldas(1));
    					}
    				}
    			}
    		}
    	}
    }
    
    public void Eliminar() {
    	if(buscarCliente == null) {
    		System.out.println("NO SE PUEDE ELIMINAR");
    	} else {
    		cliente.Eliminar(buscarCliente);
    		cliente.CargarDatos(moduloCliente.modelo);
    	}
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {

        if (e.getSource() == moduloCliente.b_buscar) {
            CargarBusqueda();
        }

        if (e.getSource() == moduloCliente.b_nuevo) {
        	moduloEntradaDatos.entradaDatos.setVisible(true);
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Integer id = null;
		
		int fila = moduloCliente.tabla.getSelectedRow();
		int columna = 2;
		String valor = moduloCliente.tabla.getValueAt(fila, columna).toString();
		
		if(e.getClickCount() == 2) {
			id = cliente.Buscar(valor);
			
			entradaDatosController.CargarDatosBusqueda(id);
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
