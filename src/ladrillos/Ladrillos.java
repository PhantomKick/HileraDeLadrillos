package ladrillos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ladrillos {

	private int cantidadLadrillos;
	private String[] ladrillos;
	private int CantidadCalculos = 0;

	public Ladrillos(String path) {
		try {
			leerArchivo(path);
		} catch (Exception e) {
			System.out.println("Error abrir archivo.");
			e.printStackTrace();
		}
	}

	public void calcula() {
		while (this.CantidadCalculos > 0) {
			for (int i = 0; i < this.cantidadLadrillos - 2; i++)
				if (!this.ladrillos[i].equals("*") && !this.ladrillos[i + 1].equals("*")) {
					this.ladrillos[i + 2] = String.valueOf(Integer.parseInt(this.ladrillos[i]) + Integer.parseInt(this.ladrillos[i + 1]));
					this.CantidadCalculos--;
				}

			for (int i = this.cantidadLadrillos - 1; i > 1; i--) {
				if (!this.ladrillos[i].equals("*") && !this.ladrillos[i - 1].equals("*")) {
					this.ladrillos[i - 2] = String.valueOf(Integer.parseInt(this.ladrillos[i]) - Integer.parseInt(this.ladrillos[i - 1]));
					this.CantidadCalculos--;
				} else if (!this.ladrillos[i].equals("*") && !this.ladrillos[i - 2].equals("*")) {
					this.ladrillos[i - 1] = String.valueOf(Integer.parseInt(this.ladrillos[i]) - Integer.parseInt(this.ladrillos[i - 2]));
					this.CantidadCalculos--;
				}
			}
		}

	}

	public void leerArchivo(String path) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(path));
			this.cantidadLadrillos = Integer.parseInt(sc.nextLine());
			this.ladrillos = new String[cantidadLadrillos];
			this.ladrillos = sc.nextLine().split("\\s+");
			for (int i = 0; i < this.ladrillos.length; i++)
				if (this.ladrillos[i].equals("*"))
					this.CantidadCalculos++;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		sc.close();
	}

	public void escribirVector() {
		for (int i = 0; i < this.cantidadLadrillos; i++)
			System.out.print(this.ladrillos[i] + " ");
	}

	public void grabarArchivo(String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			for (int i = 0; i < this.cantidadLadrillos; i++)
				salida.print(this.ladrillos[i] + " ");

			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
