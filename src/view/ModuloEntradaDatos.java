package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import model.Cliente;

public class ModuloEntradaDatos {
	
	public JDialog entradaDatos;
	public JPanel panelCentral, panelPrincipal, panelOpciones;
	public JLabel l_nombre, l_apellido, l_cedula, l_email, l_label;
	public JLabel label1, label2, label3, label4;
	public JTextField tf_nombre, tf_apellido, tf_cedula, tf_email;
	public JButton b_guardar, b_cancelar, b_eliminar;

    Cliente cliente;
    Integer buscarCliente;
    
    public Font fuente = new Font("poppins", Font.BOLD, 12);

    public void InicilizarComponentes(){
    	entradaDatos = new JDialog();
    	entradaDatos.setSize(500, 400);
    	entradaDatos.setLocationRelativeTo(null);
    	entradaDatos.setModal(true);
    	entradaDatos.setLayout(new BorderLayout());
    	
    	panelCentral = new JPanel();
    	panelCentral.setLayout(new BorderLayout());
    	entradaDatos.add(panelCentral);
    	
    	panelPrincipal = new JPanel();
    	panelPrincipal.setLayout(new GridLayout(0, 2, 20, 20));
    	panelCentral.add(panelPrincipal);
    	
    	panelOpciones = new JPanel();
    	panelOpciones.setLayout(new GridLayout(0, 3, 40, 20));
    	panelCentral.add(panelOpciones, BorderLayout.SOUTH);
    	
    	label1 = new JLabel("     ");
    	entradaDatos.add(label1, BorderLayout.NORTH);
        
        label2 = new JLabel("     ");
        entradaDatos.add(label2, BorderLayout.SOUTH);
        
        label3 = new JLabel("     ");
        entradaDatos.add(label3, BorderLayout.EAST);
        
        label4 = new JLabel("     ");
        entradaDatos.add(label4, BorderLayout.WEST);
    	
    	l_nombre = new JLabel("Nombre:");
        l_nombre.setFont(fuente);
        l_nombre.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        panelPrincipal.add(l_nombre);
        
        tf_nombre = new JTextField();
        tf_nombre.setFont(fuente);
        tf_nombre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(tf_nombre);
        
        l_apellido = new JLabel("Apellido:");
        l_apellido.setFont(fuente);
        l_apellido.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        panelPrincipal.add(l_apellido);
        
        tf_apellido = new JTextField();
        tf_apellido.setFont(fuente);
        tf_apellido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(tf_apellido);

        l_cedula = new JLabel("Cédula:");
        l_cedula.setFont(fuente);
        l_cedula.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        panelPrincipal.add(l_cedula);
        
        tf_cedula = new JTextField();
        tf_cedula.setFont(fuente);
        tf_cedula.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(tf_cedula);

        l_email = new JLabel("E-mail:");
        l_email.setFont(fuente);
        l_email.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        panelPrincipal.add(l_email);

        tf_email = new JTextField();
        tf_email.setFont(fuente);
        tf_email.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(tf_email);
        
        l_label = new JLabel("   ");
        panelPrincipal.add(l_label);
        
        b_guardar = new JButton("Guardar");
        b_guardar.setFont(fuente);
        b_guardar.setBackground(new Color(12, 120, 84));
        b_guardar.setForeground(new Color(255, 255, 255));
        b_guardar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelOpciones.add(b_guardar);
        
        b_cancelar = new JButton("Cancelar");
        b_cancelar.setFont(fuente);
        b_cancelar.setBackground(new Color(12, 120, 84));
        b_cancelar.setForeground(new Color(255, 255, 255));
        b_cancelar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelOpciones.add(b_cancelar);
        
        b_eliminar = new JButton("Eliminar");
        b_eliminar.setFont(fuente);
        b_eliminar.setBackground(new Color(12, 120, 84));
        b_eliminar.setForeground(new Color(255, 255, 255));
        b_eliminar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelOpciones.add(b_eliminar);
        
        //entradaDatos.setVisible(true);
    }
}
