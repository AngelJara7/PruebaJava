package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.GestionEncabezadoTabla;

public class ModuloCliente {
	
	public JFrame ventana;
	public JPanel panelPrincipal, panelCentral, panelSuperior, panelInferior, panelBuscar;
	public JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    public JTextField tf_buscar;
    public JButton b_nuevo, b_buscar;
    public DefaultTableModel modelo;
    public JTable tabla;
    public JTableHeader tablaHeader;
    public JScrollPane scrollPane;
    
    public Font fuente = new Font("poppins", Font.BOLD, 12);

    public void InicilizarComponentes(){
       ventana = new JFrame("Prueba Java");
       ventana.setSize(600, 500);
       ventana.setLocationRelativeTo(null);
       ventana.setDefaultCloseOperation(ventana.DISPOSE_ON_CLOSE);
       ventana.setLayout(new BorderLayout());
       
       panelPrincipal = new JPanel();
       panelPrincipal.setLayout(new BorderLayout());
       ventana.add(panelPrincipal);
       
       panelCentral = new JPanel();
       panelCentral.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Detalles", 0, 0, fuente, new Color(0, 0, 0)));
       panelCentral.setLayout(new BorderLayout());
       panelPrincipal.add(panelCentral);
       
       panelSuperior = new JPanel();
       panelSuperior.setLayout(new BorderLayout(50, 50));
       panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
       
       panelBuscar = new JPanel();
       panelBuscar.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
       panelBuscar.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Acciones", 0, 0, fuente, new Color(0, 0, 0)));
       panelSuperior.add(panelBuscar, BorderLayout.CENTER);
       
       label1 = new JLabel("     ");
       ventana.add(label1, BorderLayout.NORTH);
       
       label2 = new JLabel("     ");
       ventana.add(label2, BorderLayout.SOUTH);
       
       label3 = new JLabel("     ");
       ventana.add(label3, BorderLayout.EAST);
       
       label4 = new JLabel("     ");
       ventana.add(label4, BorderLayout.WEST);
       
       label5 = new JLabel("     ");
       panelCentral.add(label5, BorderLayout.NORTH);
       
       label6 = new JLabel("     ");
       panelCentral.add(label6, BorderLayout.SOUTH);
       
       label7 = new JLabel("     ");
       panelCentral.add(label7, BorderLayout.EAST);
       
       label8 = new JLabel("     ");
       panelCentral.add(label8, BorderLayout.WEST);

       tf_buscar = new JTextField();
       tf_buscar.setFont(fuente);
       tf_buscar.setColumns(25);
       tf_buscar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       panelBuscar.add(tf_buscar);

       b_buscar = new JButton("Buscar");
       b_buscar.setFont(fuente);
       b_buscar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
       b_buscar.setBackground(new Color(12, 120, 84));
       b_buscar.setForeground(new Color(255, 255, 255));
       panelBuscar.add(b_buscar);

       b_nuevo = new JButton("Nuevo");
       b_nuevo.setFont(fuente);
       b_nuevo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
       b_nuevo.setBackground(new Color(12, 120, 84));
       b_nuevo.setForeground(new Color(255, 255, 255));
       panelBuscar.add(b_nuevo, FlowLayout.RIGHT);

       modelo = new DefaultTableModel(){
    	   @Override
   	   public boolean isCellEditable(int fila, int columna) {
    		   return false;
    	   }
       };
       
       tabla = new JTable(modelo);
       tabla.setFocusable(false);
       tabla.setRowHeight(30);
       tabla.getTableHeader().setReorderingAllowed(false);
       tabla.getTableHeader().setResizingAllowed(false);
       tabla.getTableHeader().setFont(fuente);
       tabla.getTableHeader().setBackground(Color.WHITE);
       tabla.setFont(fuente);
       tabla.setBackground(Color.WHITE);
       
       tablaHeader = tabla.getTableHeader();
       tablaHeader.setDefaultRenderer(new GestionEncabezadoTabla());
       
       tabla.setTableHeader(tablaHeader);
       
       scrollPane = new JScrollPane();
       scrollPane.setViewportView(tabla);
       
       panelCentral.add(scrollPane);

       ventana.setVisible(true);
    }
}
