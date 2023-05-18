package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Cliente;

public class ModuloCliente {
	
	public JFrame ventana;
	public JLabel l_nombre, l_apellido, l_cedula, l_email;
    public JTextField tf_nombre, tf_apellido, tf_cedula, tf_email, tf_buscar;
    public JButton b_guardar, b_buscar, b_actualizar, b_eliminar;
    public DefaultTableModel modelo;
    public JTable tabla;
    public JScrollPane scrollPane;

    Cliente cliente;
    Integer buscarCliente;

    public void InicilizarComponentes(){
       ventana = new JFrame("Prueba Java");
       ventana.setSize(800, 500);
       ventana.setLocationRelativeTo(null);
       ventana.setDefaultCloseOperation(ventana.DISPOSE_ON_CLOSE);
       ventana.setLayout(null);

       l_nombre = new JLabel();
       l_nombre.setText("Nombre:");
       l_nombre.setBounds(20, 100, 100, 25);
       ventana.add(l_nombre);

       l_apellido = new JLabel();
       l_apellido.setText("Apellido:");
       l_apellido.setBounds(20, 140, 100, 25);
       ventana.add(l_apellido);

       l_cedula = new JLabel();
       l_cedula.setText("Cedula:");
       l_cedula.setBounds(20, 180, 100, 25);
       ventana.add(l_cedula);

       l_email = new JLabel();
       l_email.setText("E-mail:");
       l_email.setBounds(20, 220, 100, 25);
       ventana.add(l_email);

       tf_buscar = new JTextField();
       tf_buscar.setBounds(20, 20, 150, 25);
       ventana.add(tf_buscar);

       tf_nombre = new JTextField();
       tf_nombre.setBounds(90, 100, 200, 25);
       ventana.add(tf_nombre);

       tf_apellido = new JTextField();
       tf_apellido.setBounds(90, 140, 200,25);
       ventana.add(tf_apellido);

       tf_cedula = new JTextField();
       tf_cedula.setBounds(90, 180, 200, 25);
       ventana.add(tf_cedula);

       tf_email = new JTextField();
       tf_email.setBounds(90, 220, 200, 25);
       ventana.add(tf_email);

       b_buscar = new JButton();
       b_buscar.setText("Buscar");
       b_buscar.setBounds(180, 20, 100, 25);
       ventana.add(b_buscar);

       b_guardar = new JButton();
       b_guardar.setText("Guardar");
       b_guardar.setBounds(300, 20, 100, 25);
       ventana.add(b_guardar);

       b_actualizar = new JButton();
       b_actualizar.setText("Actualizar");
       b_actualizar.setBounds(420, 20, 100, 25);
       ventana.add(b_actualizar);

       b_eliminar = new JButton();
       b_eliminar.setText("Eliminar");
       b_eliminar.setBounds(540, 20, 100, 25);
       ventana.add(b_eliminar);

       modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
       };
       
       tabla = new JTable(modelo);
       tabla.getTableHeader().setReorderingAllowed(false);
       tabla.getTableHeader().setResizingAllowed(false);
       scrollPane = new JScrollPane(tabla);
       scrollPane.setBounds(250, 100, 500, 300);
       ventana.add(scrollPane);
       
       cliente = new Cliente();

       ventana.setVisible(true);
    }
}
