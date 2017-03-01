package Test;

import java.util.Scanner;

import Models.*;

public class TestJuego {

	public static void main(String[] args) {
		Tablero t1 = new Tablero();
		Jugador j1 = new Jugador(true);
		boolean terminado = false;
		int[] coordenadas = new int[2];
		boolean movimientoValido = false;
		int numeroJugadores = leerJugadores();
		t1.Iniciar();
		System.out.println(t1);
		switch (numeroJugadores) {
		case 1:
			Jugador maq = new Jugador(false);

			do {
				System.out.println("Movimiento jugador 1.");
				do {
					coordenadas = leerPosicion();
					movimientoValido = (t1.movimientoValido(coordenadas[0] - 1, coordenadas[1] - 1));
					t1.mueveJugador(j1, (coordenadas[0] - 1), (coordenadas[1] - 1));
				} while (!movimientoValido);
				if(t1.comprobar_ganador('X')){break;}
				System.out.println("Movimiento de la maquina.");
				t1.movimientoAutomatico(maq);
				terminado = (t1.comprobar_ganador('X')) || (t1.comprobar_ganador('O'));
				System.out.println(t1);
			} while (!terminado);
			if (t1.comprobar_ganador('X')) {
				System.out.println("Le has ganado a la maquina :)");
			} else {
				System.out.println("Te ha ganado la máquina :(");
			}
			break;
		case 2:
			Jugador j2 = new Jugador (false);
			do {
				System.out.println("Movimiento jugador 1.");
				do {
					coordenadas = leerPosicion();
					movimientoValido = (t1.movimientoValido(coordenadas[0] - 1, coordenadas[1] - 1));
					t1.mueveJugador(j1, (coordenadas[0] - 1), (coordenadas[1] - 1));
				} while (!movimientoValido);
				System.out.println(t1);
				if(t1.comprobar_ganador('X')){break;}
				System.out.println("Movimiento jugador 2.");
				do {
					coordenadas = leerPosicion();
					movimientoValido = (t1.movimientoValido(coordenadas[0] - 1, coordenadas[1] - 1));
					t1.mueveJugador(j2, (coordenadas[0] - 1), (coordenadas[1] - 1));
				} while (!movimientoValido);
				terminado = (t1.comprobar_ganador('X')) || (t1.comprobar_ganador('O'));
				System.out.println(t1);
			} while (!terminado);
			if (t1.comprobar_ganador('X')) {
				System.out.println("Ganador jugador 1");
			} else {
				System.out.println("Ganador jugador 2");
			}
			break;
		}
	}

	/**
	 * Lee el numero de jugadores verificando que se introduce entre 1 y 2
	 * 
	 * @return devuelve el numero de jugadores
	 */
	public static int leerJugadores() {
		Scanner sc = new Scanner(System.in);
		String aux;
		int numero;
		boolean esCorrecto = false;

		do {
			numero = 0;
			System.out.print("Introduce un número de jugadores entre 1 y 2: ");
			try {
				aux = sc.next();
				numero = Integer.parseInt(aux);
				esCorrecto = true;
				if (numero != 1 && numero != 2) {
					System.out.println("No ha introducido un número valido.");
					esCorrecto = false;
				}
			} catch (Exception e) {
				esCorrecto = false;
				System.out.println("No ha introducido un numero.");
			}

		} while (esCorrecto == false);
		return numero;

	}

	public static int[] leerPosicion() {
		String[] cadenas = { "una fila", "una columna" };
		boolean esCorrecto = false;
		int[] posiciones = new int[2];
		for (int i = 0; i < posiciones.length; i++) {
			do {
				esCorrecto = false;
				posiciones[i] = leerEnteros(cadenas[i]);
				esCorrecto = (posiciones[i] >= 1 && posiciones[i] <= 3) ? true : false;
				if (!esCorrecto) {
					System.out.println("No has introducido una columa valida.");
				}
			} while (!esCorrecto);
		}
		return posiciones;

	}

	public static int leerEnteros(String pantalla) {
		Scanner sc = new Scanner(System.in);
		String aux;
		int numero = 0;
		boolean esCorrecto = false;

		do {
			System.out.print("Introduce " + pantalla + ": ");
			try {
				aux = sc.next();
				numero = Integer.parseInt(aux);
				esCorrecto = true;
			} catch (Exception e) {
				esCorrecto = false;
				System.out.println("No ha introducido " + pantalla + ".");
			}
		} while (esCorrecto == false);
		return numero;

	}
}
