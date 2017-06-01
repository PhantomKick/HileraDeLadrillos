package ladrillos;

import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class LadrillosTest {

	private static String archivoIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	private static String archivoOut = "Ejecucion de Prueba/Salida Obtenida/";

	@Test
	public void testEnunciado() {
		Ladrillos ladrillos = new Ladrillos(archivoIn + "00_Enunciado.in");
		ladrillos.calcula();
		ladrillos.grabarArchivo(archivoOut + "00_Enunciado.out");
	}

	@Test
	public void testEnunciadoInverso() {
		Ladrillos ladrillos = new Ladrillos(archivoIn + "01_Enunciado_Inverso.in");
		ladrillos.calcula();
		ladrillos.grabarArchivo(archivoOut + "01_Enunciado_Inverso.out");
	}

}
