package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.Equipo;

public class PanelPantallaListaEquipos extends JPanel {
	private JButton  botonCrearEmpleado;	
	
	public PanelPantallaListaEquipos() {
		setLayout(new BorderLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		insertarCabecera();
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
	
	public void insertarNuevaTabla(ArrayList<Equipo> listaEquipos) {
		removeAll();
		actualizarEstado();
		
		// Insertar Tabla
		
		// Actualizar Estado
		actualizarEstado();
	}
	
	public void actualizarEstado() {
		revalidate();
		repaint();
	}
	
	public JButton getBotonCrearEmpleado() {
		return botonCrearEmpleado;
	}
}
