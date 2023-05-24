package initApplication;

import view.*;
import model.Cliente;
import controller.*;

public class Prueba {
	
	public static void main(String[] args) {
		
        ModuloCliente moduloCliente = new ModuloCliente();
        Cliente cliente = new Cliente();
        
    	ControllerCliente controllerCliente = new ControllerCliente(moduloCliente, cliente);
    	controllerCliente.Iniciar();
        
//        EntradaDatosController entradaDatosController = new EntradaDatosController(moduloEntradaDatos, cliente);
//        entradaDatosController.Iniciar();
    }
}
