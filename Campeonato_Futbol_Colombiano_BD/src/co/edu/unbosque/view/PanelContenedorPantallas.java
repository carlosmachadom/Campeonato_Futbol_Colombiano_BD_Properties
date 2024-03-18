package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.Equipo;

public class PanelContenedorPantallas extends JPanel{	
	private PanelPantallaListaEquipos listaEquipos;
	private PanelPantallaCrearNuevoEquipo crearEquipo;
	
	public PanelContenedorPantallas() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0,0,0,0));
		setBackground(Color.black);
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes () {
		insertarPantallaListaDeEquipos();
	}
	
	public void insertarPantallaListaDeEquipos() {
		removeAll();
		actualizarEstado();
		
		// Insertar Pantalla de Tabla		
		listaEquipos = new PanelPantallaListaEquipos();
		add(listaEquipos);
		
		// Volver a actualizar estado
		actualizarEstado();
	}
	
	public void insertarPantallaCrearNuevoEquipo() {
		removeAll();
		actualizarEstado();
		
		// Insertar Pantalla de crear
		
		// Volver a actualizar estado
		actualizarEstado();
	}
	
	public void actualizarEstado() {
		revalidate();
		repaint();
	}

	public PanelPantallaListaEquipos getListaEquipos() {
		return listaEquipos;
	}

	public PanelPantallaCrearNuevoEquipo getCrearEquipo() {
		return crearEquipo;
	}
}
