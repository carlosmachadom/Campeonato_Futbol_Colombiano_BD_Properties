package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PanelContenedorPrincipal extends JPanel{
	private PanelCabecera header;
	private PanelContenedorPantallas contenedorPantallas;
	
	public PanelContenedorPrincipal() {
		setLayout(new BorderLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		header = new PanelCabecera();
		add(header, BorderLayout.NORTH);
		
		contenedorPantallas = new PanelContenedorPantallas();
		
		JPanel highCont = new JPanel();
		highCont.setLayout(new BorderLayout());
		highCont.setPreferredSize(new Dimension(1440, 960));
		highCont.add(contenedorPantallas);
		
		JPanel section = new JPanel();
		section.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		section.add(highCont, gbc);		
		
		add(section, BorderLayout.CENTER);		
	}
	
	public PanelContenedorPantallas getContenedorPantallas() {
		return contenedorPantallas;
	}
	
}
