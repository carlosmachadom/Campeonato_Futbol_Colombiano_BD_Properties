package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Archivo {
	
	private File f;
	private Properties datos;
	
	public Archivo() {
		f = new File("archivos\\DatosCampeonato.properties");
		datos = new Properties();
	}
	
	public Archivo(File f) {
		this.f = f;
		datos = new Properties();
	}
	
	public void leerConfiguracion() throws IOException {
		try {
			FileInputStream in = new FileInputStream(f);
			datos.load(in);
			in.close();
		}catch(IOException e) {
			throw new IOException("Formato Inv�lido");
		}
	}
	
	public void escribirPropiedades(String propiedad, String valor) {
		try {
			datos.setProperty(propiedad, valor);
			datos.store(new FileOutputStream(f), null);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getDatos() {
		return datos;
	}

	public void setDatos(Properties datos) {
		this.datos = datos;
	}
	
}
