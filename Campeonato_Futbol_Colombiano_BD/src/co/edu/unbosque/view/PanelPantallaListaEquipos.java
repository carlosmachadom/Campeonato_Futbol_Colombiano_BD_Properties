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
	private JButton botonCrearEquipo;	
	private JButton botonConsultar;
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
		
		botonCrearEquipo = new JButton("Crear Nuevo Equipo");
		botonCrearEquipo.setActionCommand("CREAR");
		botonCrearEquipo.setMargin(new Insets(10, 10, 10, 10));
		botonCrearEquipo.setFont(botonCrearEquipo.getFont().deriveFont(18f));
		botonCrearEquipo.setFocusPainted(false);
		
		botonConsultar = new JButton("Consultar equipo");
		botonConsultar.setActionCommand("CONSULTAR");
		botonConsultar.setMargin(new Insets(10, 10, 10, 10));
		botonConsultar.setFont(botonCrearEquipo.getFont().deriveFont(18f));
		botonConsultar.setFocusPainted(false);
		
		seccionBotonCrear.add(botonCrearEquipo);
		seccionBotonCrear.add(botonConsultar);
		
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
	
	public JButton getBotonCrearEquipo() {
		return botonCrearEquipo;
	}

	public JPanel getContenedorTabla() {
		return contenedorTabla;
	}

	public PanelTablaEquipos getTabla() {
		return tabla;
	}

	public JButton getBotonConsultar() {
		return botonConsultar;
	}

	public void setBotonConsultar(JButton botonConsultar) {
		this.botonConsultar = botonConsultar;
	}
	
}
