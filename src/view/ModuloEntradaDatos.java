package view;

import javax.swing.*;

import model.Cliente;

public class ModuloEntradaDatos {
	
	public JDialog entradaDatos;
	public JLabel l_nombre, l_apellido, l_cedula, l_email;

    Cliente cliente;
    Integer buscarCliente;

    public void InicilizarComponentes(){
    	entradaDatos = new JDialog();
    	entradaDatos.setSize(500, 500);
    	entradaDatos.setLocationRelativeTo(null);
    	entradaDatos.setModal(true);
    	entradaDatos.setLayout(null);
    	l_nombre = new JLabel();
        l_nombre.setText("Nombre:");
        l_nombre.setBounds(20, 100, 100, 25);
        entradaDatos.add(l_nombre);
        
        l_apellido = new JLabel();
        l_apellido.setText("Apellido:");
        l_apellido.setBounds(20, 140, 100, 25);
        entradaDatos.add(l_apellido);

        l_cedula = new JLabel();
        l_cedula.setText("Cedula:");
        l_cedula.setBounds(20, 180, 100, 25);
        entradaDatos.add(l_cedula);

        l_email = new JLabel();
        l_email.setText("E-mail:");
        l_email.setBounds(20, 220, 100, 25);
        entradaDatos.add(l_email);
    }
}
