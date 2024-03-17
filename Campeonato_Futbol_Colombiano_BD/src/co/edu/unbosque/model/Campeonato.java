package co.edu.unbosque.model;

import java.io.IOException;

import co.edu.unbosque.model.persistence.Archivo;

public class Campeonato {
	
	private int maxEquipos;
	private Equipo[] equipos;
	private Archivo archivo;
	
	public Campeonato() {
		archivo = new Archivo();
		try {
			archivo.leerConfiguracion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		maxEquipos = Integer.parseInt(obtenerPropiedad("campeonato.equipos"));
		equipos = new Equipo[maxEquipos];
		inicializarEquipos();
	}
	
	public String obtenerPropiedad(String propiedad) {
		return archivo.getDatos().getProperty(propiedad);
	}
	
	public void modificarPropiedad(String propiedad, String valor) {
		archivo.escribirPropiedades(propiedad, valor);
	}
	
	public void eliminarPropiedad(String propiedad) {
		archivo.getDatos().remove(propiedad);
	}
	
	public void inicializarEquipos() {
		for(int i= 0; i < maxEquipos; i++) {
			String nombre = obtenerPropiedad("campeonato.nombre"+i);
			equipos[i] = new Equipo(nombre);
		}
	}
	
	public String InformacionCampeonato() {
		String info = "Cantidad de equipos: " + maxEquipos + "\n";
		for(int i = 0; i < maxEquipos; i++) {
			info += equipos[i] + "\n";
		}
		return info;
	}
	
	public boolean agregarEquipo(String nombre) {
		int pos = buscarEquipo(nombre);
		if(pos == -1) { 
			maxEquipos++;
			modificarPropiedad("campeonato.equipos", ""+maxEquipos);
			equipos = new Equipo[maxEquipos];
			modificarPropiedad("campeonato.nombre"+(maxEquipos-1), nombre);
			inicializarEquipos(); 
			return true;
		}else {
			return false;
		}
	}
	
	public int buscarEquipo(String nombre) {
		int pos = -1;
		for(int i = 0; i < maxEquipos; i++) {
			if(equipos[i].getNombre().equals(nombre)) {
				pos = i;
			}
		}
		return pos;
	}
	
	public boolean eliminarEquipo(String nombre) {
		int pos = buscarEquipo(nombre);
		if(pos != -1) {
			for (int i = pos; i < maxEquipos-1; i++) {
				equipos[i] = equipos[i+1];
			}
			maxEquipos--;
			modificarPropiedad("campeonato.equipos", ""+maxEquipos);
			for (int i = pos; i < maxEquipos; i++) {
				modificarPropiedad("campeonato.nombre"+(i), equipos[i].getNombre());
			}
			inicializarEquipos(); 
			return true;
		}
		return false;
	}
	
}
