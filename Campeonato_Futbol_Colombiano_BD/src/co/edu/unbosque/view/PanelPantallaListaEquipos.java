package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.Equipo;

public class PanelPantallaListaEquipos extends JPanel {
	private JButton  botonCrearEmpleado;	
	private PanelTablaEquipos tabla;
	private JPanel contenedorTabla;
	
	public PanelPantallaListaEquipos() {
		setLayout(new BorderLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		insertarCabecera();
		
		contenedorTabla = new JPanel();
		add(contenedorTabla);
	}
	
	public void insertarCabecera() {
		JPanel seccionBotonCrear = new JPanel();
		seccionBotonCrear.setLayout(new FlowLayout(FlowLayout.RIGHT));
		seccionBotonCrear.setBorder(new EmptyBorder(20,20,20,20));
		
		botonCrearEmpleado = new JButton("Crear Nuevo Equipo");
		botonCrearEmpleado.setActionCommand("CrearNuevoEquipo");
		botonCrearEmpleado.setMargin(new Insets(10, 10, 10, 10));
		botonCrearEmpleado.setFont(botonCrearEmpleado.getFont().deriveFont(18f));
		botonCrearEmpleado.setFocusPainted(false);
		
		seccionBotonCrear.add(botonCrearEmpleado);
		add(seccionBotonCrear, BorderLayout.NORTH);
	}
	
	public void insertarNuevaTabla(Equipo[] listaEquipos) {
		contenedorTabla.removeAll();
		actualizarEstado();
		
		// Insertar Tabla
		tabla = new PanelTablaEquipos(listaEquipos);
		contenedorTabla.add(tabla, BorderLayout.CENTER);
		
		// Actualizar Estado
		actualizarEstado();
	}
	
	public void actualizarEstado() {
		contenedorTabla.revalidate();
		contenedorTabla.repaint();
	}
	
	public JButton getBotonCrearEmpleado() {
		return botonCrearEmpleado;
	}

	public JPanel getContenedorTabla() {
		return contenedorTabla;
	}

	public PanelTablaEquipos getTabla() {
		return tabla;
	}
}
