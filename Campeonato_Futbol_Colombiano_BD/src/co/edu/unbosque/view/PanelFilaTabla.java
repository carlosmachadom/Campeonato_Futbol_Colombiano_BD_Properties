package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelFilaTabla extends JPanel {
	private JButton botonEliminar;
	private JLabel equipo;
	private JLabel estrellas;
	
	public PanelFilaTabla(String nombreEquipo, String cantidadEstrellas) {
		setLayout(new GridLayout(1, 3));
		setBorder(new EmptyBorder(0,0,0,0));
		
		inicializarComponentes(nombreEquipo, cantidadEstrellas);
		
		setVisible(true);
	}
	
	public void inicializarComponentes(String nombreEquipo, String cantidadEstrellas) {
		equipo = new JLabel(nombreEquipo);
		equipo.setFont(new Font("Arial", Font.BOLD, 28));
		JPanel seccionNombreEquipo = obtenerSeccion(equipo);
		add(seccionNombreEquipo);

		estrellas = new JLabel(cantidadEstrellas);
		estrellas.setFont(new Font("Arial", Font.BOLD, 28));
		JPanel seccionCantidadEstrellas = obtenerSeccion(estrellas); 
		add(seccionCantidadEstrellas);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setActionCommand("Eliminar="+nombreEquipo);
		botonEliminar.setMargin(new Insets(10, 10, 10, 10));
		botonEliminar.setFont(botonEliminar.getFont().deriveFont(18f));
		botonEliminar.setBackground(Color.RED);
		botonEliminar.setForeground(Color.WHITE);
		botonEliminar.setFocusPainted(false);
		JPanel seccionBotonEliminarEquipo = obtenerSeccion(botonEliminar);
		add(seccionBotonEliminarEquipo);
	}
	
	public JPanel obtenerSeccion(JLabel texto) {
		JPanel seccion = new JPanel();
		seccion.setBorder(new EmptyBorder(10,10,10,10));
		seccion.add(texto);		
		return seccion;
	}
	
	public JPanel obtenerSeccion(JButton boton) {
		JPanel seccion = new JPanel();
		seccion.setBorder(new EmptyBorder(10,10,10,10));
		seccion.add(boton);
		return seccion;
	}
	
	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public JLabel getNombreEquipo() {
		return equipo;
	}
	
	public JLabel getCantidadEstrellas() {
		return estrellas;
	}
}
