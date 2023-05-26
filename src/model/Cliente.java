package model;

import javax.swing.table.DefaultTableModel;
import java.util.*;

public class Cliente {

    private String nombre, apellido, cedula, email;
    private ArrayList<Cliente> clientes;
    private Integer id;

    public Cliente() {
    	Inicializar();
        this.clientes = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, String cedula, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setID(Integer id) {
        this.id = id;
    }
    
    public Integer getID() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public void Inicializar() {
    	nombre = "";
    	apellido = "";
    	cedula = "";
    	email = "";
    	id = 0;
    }
    
    public void CargarDatos(DefaultTableModel modelo) {
    	
    	Inicializar();
    	
    	modelo.setColumnCount(0);
    	modelo.setRowCount(0);

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("E-mail");
        
        Object[] fila = new Object[4];
        
        Iterator<Cliente> it = this.clientes.iterator();
        while(it.hasNext()){
        	Cliente cliente = it.next();
        	fila[0] = cliente.getNombre();
            fila[1] = cliente.getApellido();
            fila[2] = cliente.getCedula();
            fila[3] = cliente.getEmail();
                
            modelo.addRow(fila);
        }
    }
    
    public int Buscar(String cedula) {
    	
    	Inicializar();
    	
    	Cliente clienteEncontrado = null;
    	
    	Iterator<Cliente> it = this.clientes.iterator();
    	
    	while(it.hasNext() && clienteEncontrado == null) {
    		Cliente c = it.next();
    		if(c.getCedula().equals(cedula) ) {
    			clienteEncontrado = c;
            	this.nombre = c.getNombre();
            	this.apellido = c.getApellido();
            	this.cedula = c.getCedula();
            	this.email = c.getEmail();
            }
        }
    	return clientes.indexOf(clienteEncontrado);
    }
    
    public void Actualizar(int idCliente, Cliente cliente) {
    	clientes.set(idCliente, cliente);
    	cliente.setID(null);
    }
    
    public void Eliminar(int id) {
    	clientes.remove(id);
    }
}

