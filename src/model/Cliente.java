package model;

import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.util.*;

public class Cliente {

    private String nombre, apellido, cedula, email;
    private ArrayList<Cliente> clientes;
    private DataBase db;
    private String sql;

    public Cliente() {
    	Inicializar();
    	db = new DataBase();
        this.clientes = new ArrayList<>();
        db.Abrir();
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
    }
    
    public void CrearCliente() {
    	sql = "";
    	
    	try {
    		sql = "insert into cliente(nombre, apellido, cedula, email) values('";
    		sql = sql+nombre+"', '"+apellido+"', '"+cedula+"', '"+email+"')";
    		System.out.println(sql);
    		db.ExecuteUpdate(sql);
    		db.Cerrar();
    	} catch (Exception e) {
    		System.out.println("ERROR AL GUARDAR: "+e.toString());
    	}
    }
    
    public void CargarDatos(DefaultTableModel modelo) {
    	
    	sql = "";
    	modelo.setColumnCount(0);
    	modelo.setRowCount(0);

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("E-mail");
        
        Object[] fila = new Object[4];
        
        try {
        	sql = "select * from cliente";
        	ResultSet rs = db.ExecuteQuery(sql);
        	while (rs.next()) {
        		fila[0] = rs.getString(2);
        		fila[1] = rs.getString(3);
        		fila[2] = rs.getString(4);
        		fila[3] = rs.getString(5);
        		
        		modelo.addRow(fila);
        	}
        	db.Cerrar();
        } catch (Exception e) {
        	System.out.println("ERROR: "+e.toString());
        }
//        
//        Iterator<Cliente> it = this.clientes.iterator();
//        while(it.hasNext()){
//        	Cliente cliente = it.next();
//        	fila[0] = cliente.getNombre();
//            fila[1] = cliente.getApellido();
//            fila[2] = cliente.getCedula();
//            fila[3] = cliente.getEmail();
//                
//            modelo.addRow(fila);
//        }
    }
    
    public boolean Buscar(String cedula) {
    	
    	Inicializar();
    	
    	sql = "";
    	
    	boolean clienteEncontrado = false;
    	
    	try {
    		sql = "select * from cliente where cedula = '"+cedula+"'";
    		ResultSet rs = db.ExecuteQuery(sql);
    		
    		if (rs.next()) {
    			this.nombre = rs.getString(2);
    			this.apellido = rs.getString(3);
    			this.cedula = rs.getString(4);
    			this.email = rs.getString(5);
    		}
    		clienteEncontrado = true;
    		db.Cerrar();
    	} catch (Exception e) {
    		System.out.println("ERROR AL BUSCAR: "+e.toString());
    	}
    	
//    	Iterator<Cliente> it = this.clientes.iterator();
//    	
//    	while(it.hasNext() && clienteEncontrado == null) {
//    		Cliente c = it.next();
//    		if(c.getCedula().equals(cedula) ) {
//    			clienteEncontrado = c;
//            	this.nombre = c.getNombre();
//            	this.apellido = c.getApellido();
//            	this.cedula = c.getCedula();
//            	this.email = c.getEmail();
//            }
//        }
    	return clienteEncontrado;
    }
    
    public boolean Actualizar() {
    	
    	boolean actualizado = false;
//    	clientes.set(idCliente, cliente);
//    	cliente.setID(null);
    	
    	sql = "";
    	
    	try {
    		sql = "update cliente set nombre = '"+nombre+"', ";
    		sql = sql+"apellido = '"+apellido+"', ";
    		sql = sql+"email = '"+email+"'";
    		sql = sql+"where cedula = '"+cedula+"'";
    		
    		db.ExecuteUpdate(sql);
    		db.Cerrar();
    		
    		actualizado = true;
    	} catch (Exception e) {
    		System.out.println("ERROR AL ACTUALIZAR: "+e.toString());
    	}
    	return actualizado;
    }
    
    public void Eliminar(String cedula) {
    	
    	sql = "";
    	
    	try {
    		sql = "delete from cliente where cedula = '"+cedula+"'";
    		db.ExecuteUpdate(sql);
    		db.Cerrar();
    	} catch (Exception e) {
    		System.out.println("ERROR AL ELIMINAR: "+e.toString());
    	}
    	//clientes.remove(id);
    }
}

