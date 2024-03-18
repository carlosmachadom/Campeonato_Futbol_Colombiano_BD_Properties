package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.Equipo;

public class PanelTablaEquipos extends JPanel {
	private JPanel contenedorInfo;
	
	public PanelTablaEquipos(Equipo[] listaEquipos) {
		setLayout(new BorderLayout());
		setBackground(Color.black);
		
		inicializarComponentes(listaEquipos);
		
		setVisible(true);
	}
	
	public void inicializarComponentes(Equipo[] listaEquipos) {
		insertarCabecera();	
		contenedorInfo = new JPanel(new GridLayout(listaEquipos.length, 1));
		
		JScrollPane scrollArea = new JScrollPane(
				contenedorInfo,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollArea.setPreferredSize(new Dimension(1440, 480));
		
		scrollArea.setBorder(new EmptyBorder(0,0,0,0));		
		add(scrollArea, BorderLayout.CENTER);
		
		renderizarTabla(listaEquipos);
	}
	
	public void insertarCabecera() {
		JPanel cabeceraTabla = new JPanel();
		cabeceraTabla.setLayout(new GridLayout(1, 3));
		cabeceraTabla.setBackground(Color.black);
		
		cabeceraTabla.add(obtenerSeccion("Nombre de equipo"));		
		cabeceraTabla.add(obtenerSeccion("Numero de estrellas"));		
		cabeceraTabla.add(obtenerSeccion("Eliminar equipo"));	
		
		add(cabeceraTabla, BorderLayout.NORTH);
	}
	
	public void renderizarTabla(Equipo[] listaEquipos) {
		contenedorInfo.removeAll();
		contenedorInfo.revalidate();
		contenedorInfo.repaint();

		for(Equipo e : listaEquipos) {
			JPanel fila = obtenerFilaTabla(e.getNombre(), e.getEstrellas());			
			contenedorInfo.add(fila);
		}
		
		contenedorInfo.revalidate();
		contenedorInfo.repaint();		
	}
	
	public JPanel obtenerSeccion(String texto) {
		JPanel seccion = new JPanel();
		seccion.setBackground(new Color(128, 128, 128, 120));
		seccion.setBorder(new EmptyBorder(20,20,20,20));
		seccion.setBorder(new LineBorder(Color.white, 2));

		JLabel title = new JLabel(texto);	
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.BOLD, 28));
		seccion.add(title);		
		return seccion;
	}
	
	public JPanel obtenerFilaTabla(String nombreEquipo, String numeroEstrellas) {
		JPanel seccionFila = new JPanel(new BorderLayout());
		
		PanelFilaTabla fila = new PanelFilaTabla(nombreEquipo, numeroEstrellas);
		
		seccionFila.add(fila, BorderLayout.CENTER);
		
		return seccionFila;
	}

	public JPanel getContenedorInfo() {
		return contenedorInfo;
	}
}
