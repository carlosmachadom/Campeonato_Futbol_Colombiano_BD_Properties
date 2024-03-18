package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelTablaEquipos extends JPanel {
	private ArrayList<PanelFilaTabla> listaFilasTabla;
	
	public PanelTablaEquipos() {
		setLayout(new BorderLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
	}
	
	public void insertarCabecera() {
		JPanel cabeceraTabla = new JPanel();
		cabeceraTabla.setLayout(new GridLayout(1, 3));
		cabeceraTabla.setBackground(Color.BLACK);
		
		cabeceraTabla.add(obtenerSeccion("Nombre de equipo"));		
		cabeceraTabla.add(obtenerSeccion("Numero de estrellas"));		
		cabeceraTabla.add(obtenerSeccion(""));		
	}
	
	public JPanel obtenerSeccion(String texto) {
		JPanel seccion = new JPanel();
		JLabel title = new JLabel(texto);
		seccion.setBorder(new EmptyBorder(10,10,10,10));
		seccion.add(title);		
		return seccion;
	}
	
	public void obtenerFilaTabla() {
		
		
		
	}
	
	
}
