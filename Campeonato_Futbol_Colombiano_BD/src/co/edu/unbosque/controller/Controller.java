package co.edu.unbosque.controller;

import co.edu.unbosque.model.Campeonato;
import co.edu.unbosque.view.VistaConsola;

public class Controller {

	private VistaConsola vista;
	private Campeonato campeonato;

	public Controller() {
		vista = new VistaConsola();
		campeonato = new Campeonato();
	}

	public void run() {
		String aux = "";
		int opcion = 0;
		mainLoop: while (true) {
			vista.mostrarInformacion("***     MENU DE OPERACIONES     ***" + "\n\t1.Ingresar equipo "
					+ "\n\t2.Eliminar equipo " + "\n\t3.Mostar todos los equipos " + "\n\t4.Salir ");
			opcion = vista.leerDatoEntero("Ingrese operacion: ");

			ingresarLoop: while (true) {
				switch (opcion) {
				case 1:
					boolean isNumber = false;
					aux = vista.leerCadenaCaracteres("Ingrese Equipo: ");
					String auxEstrellas = vista.leerCadenaCaracteres("Ingrese estrellas");

					if (campeonato.agregarEquipo(aux, auxEstrellas)) {
						vista.mostrarInformacion("Se agrego con exito");
					} else {
						vista.mostrarInformacion("No fue posible la insercion");
					}
					aux = vista.leerCadenaCaracteres("Deseas adicionar otro equipo: \n1.SI\n2.NO\nOpcion: ");
					if (!aux.equals("1")) {
						break ingresarLoop;
					}
					break;

				case 2:
					aux = vista.leerCadenaCaracteres("Eliminar Equipo: ");
					if (campeonato.eliminarEquipo(aux)) {
						vista.mostrarInformacion("Se elimino con exito");
					} else {
						vista.mostrarInformacion("No fue posible la eliminacion");
					}
					break ingresarLoop;

				case 3:
					vista.mostrarInformacion(campeonato.informacionCampeonato());
					break ingresarLoop;

				case 4:
					vista.mostrarInformacion("Hasta Luego");
					break mainLoop;

				default:
					vista.mostrarInformacion("Error: opcion no valida");
				}
			}
		}
	}

}
