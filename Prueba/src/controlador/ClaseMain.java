package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import conexiones.Conexiones;
import conexiones.ConfigDir;
import modelo.Rectangulo;
import modelo.Triangulo;

public class ClaseMain {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IOException, SQLException, InterruptedException {
		// TODO Auto-generated method stub
		ConfigDir config = new ConfigDir();
		Conexiones con = new Conexiones(config);
		int opcion = 0;
		Scanner in = new Scanner(System.in);
		int auxiliar = 0;

		do {
			System.out.println("-------------------------------------------");
			System.out.println("1. Listar todos");
			System.out.println("2. Aniadir polígono");
			System.out.println("3. Eliminar");
			System.out.println("4. Modificar poligono");
			System.out.println("5. Convertir datetime");
			System.out.println("6. Cotilleando lanzado de comandos en cmd con hilo ");
			System.out.println("0. Salir");
			System.out.println("-------------------------------------------");
			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				con.getData();
				break;
			case 2:
				System.out.println("Indique 1 si es un rectangulo y 2 si es un triangulo");
				auxiliar = in.nextInt();
				if (auxiliar == 1) {
					System.out.println("indique la altura del rectangulo");
					double altura = in.nextDouble();
					System.out.println("indique la longitud del rectangulo");
					double longitud = in.nextDouble();
					System.out.println("indique el identificador del rectangulo");
					int id = in.nextInt();
					Rectangulo rec = new Rectangulo(longitud, altura);
					con.insertData(id, rec.calcularPerimetro(), rec.calcularArea());
				} else if (auxiliar == 2) {
					System.out.println("indique la longitud de la base");
					double longitudBase = in.nextDouble();
					System.out.println("indique la altura del triangulo");
					double altura = in.nextDouble();
					System.out.println("indique el identificador del rectangulo");
					int id = in.nextInt();
					Triangulo rec = new Triangulo(longitudBase, altura);
					con.insertData(id, rec.calcularPerimetro(), rec.calcularArea());
				} else {
					System.out.println("numero incorrecto");
				}
				break;
			case 3:
				System.out.println("Indique el id del poligono a eliminar");
				auxiliar = in.nextInt();
				con.deleteData(auxiliar);
				break;
			case 4:
				System.out.println("Indique el id del poligono a modificar");
				auxiliar = in.nextInt();
				System.out.println("Indique el nuevo perimetro");
				Double perimetro = in.nextDouble();
				System.out.println("Indique el nuevo area");
				Double area = in.nextDouble();
				con.modificarEntrada(auxiliar, perimetro, area);
				break;
			case 5:
				// pasar de timestamp de java al formato de String nuestro (dd/mm/yyyy 00:00:00)
				Long datetime = System.currentTimeMillis();
				Timestamp timestamp = new Timestamp(datetime);
				System.out.println("timestamp en formato java: " + timestamp);
				String[] aux = timestamp.toString().split("-");
				String timestampEsp = aux[2].split(" ")[0] + "/" + aux[1] + "/" + aux[0] + " " + aux[2].split(" ")[1];
				System.out.println("timestamp en formato esp: " + timestampEsp);

				break;
			case 6:
				class Hilo extends Thread implements Runnable {
					public void run() {
						Runtime rt = Runtime.getRuntime();
						synchronized (rt) {
							try {
								rt.exec("cmd /c start iexplore http://google.es");
								rt.wait(2000);
								rt.exec("cmd /c start iexplore http://google.es");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				Thread t = new Thread(new Hilo());
				t.start();

				break;
			default:
				if (opcion!=0) {
					System.out.println("-------------------------------------------");
					System.out.println("Numero no contemplado");
					System.out.println("-------------------------------------------");
				}else {
					System.out.println("-------------------------------------------");
					System.out.println("Adiós");
					System.out.println("-------------------------------------------");
				}
				
				break;
			}
		} while (opcion != 0);

	}

}
