package initApplication;

import view.ModuloCliente;
import model.Cliente;
import controller.ControllerCliente;

public class Prueba {
	
	public static void main(String[] args) {
        ModuloCliente moduloCliente = new ModuloCliente();
        Cliente cliente = new Cliente();
        
        ControllerCliente controlador = new ControllerCliente(moduloCliente, cliente);
        controlador.Iniciar();
    }
}
