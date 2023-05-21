package initApplication;

import view.*;
import model.Cliente;
import controller.*;

public class Prueba {
	
	public static void main(String[] args) {
		
        ModuloCliente moduloCliente = new ModuloCliente();
        ModuloEntradaDatos moduloEntradaDatos = new ModuloEntradaDatos(moduloCliente, true);
        Cliente cliente = new Cliente();
        
    	ControllerCliente controlador = new ControllerCliente(moduloCliente, moduloEntradaDatos, cliente);
        controlador.Iniciar();
        
        EntradaDatosController entradaDatosController = new EntradaDatosController(moduloEntradaDatos, cliente);
        entradaDatosController.Iniciar();
    }
}
