package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Campeonato;
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
		asignarListeners();
	}
	
	public void asignarListeners() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String aux = e.getActionCommand();
		
	}

	public void validateAction(String aux) {
		
	}
}
