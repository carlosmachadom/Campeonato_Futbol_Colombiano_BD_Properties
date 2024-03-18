package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
		// Agregar Listener a Pantalla lista de equipos
		asignarListenersPantallaListaEquipos();
				
		// Agregar listeners a pantalla crear nuevo equipo
	}
	
	public void asignarListenersPantallaListaEquipos() {
		vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().getBotonCrearEmpleado().addActionListener(this);
		asignarListenersBotonesEliminar();
	}
	
	public void asignarListenersBotonesEliminar() {
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
		if(aux.equals("PantallaCrearNuevoEquipo")) {
			
		}
		
		if (aux.contains("Eliminar")) {			
			String equipo = aux.split("=")[1];
			boolean respuesta = campeonato.eliminarEquipo(equipo);
			
			if (respuesta) {
				//Mostrar dialog de exito
				JOptionPane.showMessageDialog(null, "¡Equipo eliminado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				campeonato = new Campeonato();
				vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().insertarNuevaTabla(campeonato.getEquipos());
				asignarListenersBotonesEliminar();
			} else {
				//Mostrar dialog de rechazo
				JOptionPane.showMessageDialog(null, "¡El equipo no se pudo eliminar!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
}
