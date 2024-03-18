package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VistaVentana extends JFrame {
	
	private PanelContenedorPrincipal root;
	
	public VistaVentana() {
		setTitle("Base de datos campeonato de futbol Colombiano");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());		
		setMinimumSize(new Dimension(1366, 768));
		setResizable(true);
		setLocationRelativeTo(null);

		inicializarComponentes();
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		root = new PanelContenedorPrincipal();	
		add(root, BorderLayout.CENTER);
	}
	
	public PanelContenedorPrincipal getContenedorPrincipal() {
		return root;
	}
}
