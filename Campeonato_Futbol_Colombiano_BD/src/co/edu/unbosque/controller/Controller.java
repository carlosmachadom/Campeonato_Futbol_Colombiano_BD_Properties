package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import co.edu.unbosque.model.Campeonato;
import co.edu.unbosque.view.PanelFilaTabla;
import co.edu.unbosque.view.VistaVentana;

public class Controller implements ActionListener {
	private VistaVentana vista;
	private Campeonato campeonato;

	public Controller() {
		vista= new VistaVentana();		
		campeonato = new Campeonato();
		
		run();
	}

	public void run() {		
		vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().insertarNuevaTabla(campeonato.getEquipos());
		
		asignarListeners();
	}
	
	public void asignarListeners() {
		// Agregar Listener a boton de crear empleado
		vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().getBotonCrearEmpleado().addActionListener(this);
		
		// Agregar Listeners para eliminar equipos
		Component[] equipos = vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().getTabla().getContenedorInfo().getComponents();
		
		for (Component c : equipos) {			
			JPanel panelInterno = (JPanel) c;
            Component subComponente = panelInterno.getComponent(0);            
            if (subComponente != null) {            	
            	if(subComponente instanceof PanelFilaTabla) {
            		((PanelFilaTabla) subComponente).getBotonEliminar().addActionListener(this);
            	}
            }
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String aux = e.getActionCommand();
		
		validateAction(aux);
	}

	public void validateAction(String aux) {
		if(aux.equals("CrearNuevoEquipo")) {
			
		}
		
		if (aux.contains("Eliminar")) {			
			String equipo = aux.split("=")[1];
			System.out.println(equipo);			
		}
	}
}
