package Models;

public class Tablero {
	private char[][] tablero = new char[3][3];

	/**
	 * Crea un tablero vacio
	 */
	public Tablero() {
		Iniciar();
	}

	public void mueveJugador(Jugador jugador, int columna, int fila) {
		char numeroDeJugador = (jugador.getNumeroDeJugador()) ? 'X' : 'O';

		if (movimientoValido(columna, fila)) {
			this.tablero[columna][fila] = (char) numeroDeJugador;
		} else {
			System.out.println("Casilla ya usada");
		}
	}

	public void movimientoAutomatico(Jugador jugador) {
		int columna;
		int fila;
		do{
		columna = (int) (Math.random() * 3);
		fila = (int) (Math.random() * 3);
		}while(!movimientoValido(columna, fila));
		mueveJugador(jugador, columna, fila);

	}

	/**
	 * Muestra si el movimieno es valido o la casilla ya esta ocupada
	 * 
	 * @param columna
	 *            el numero de columna a elegir el movimiento
	 * @param fila
	 *            el numero de fila a elegir el movimiento
	 * @return true si se puede hacer, false si no se puede hacer
	 */
	public boolean movimientoValido(int columna, int fila) {
		return (this.tablero[columna][fila] == '0') ? true : false;
	}
/**
 * Limpia el tablero de fichas
 */
	public void Iniciar() {
		for (int i = 0; i < this.tablero.length; i++) // Columnas
		{
			for (int j = 0; j < this.tablero[0].length; j++)// Filas
			{
				this.tablero[i][j] = '0';
			}
		}

	}

	public boolean quedanMovimientos() {
		int columnas = 0;
		int filas = 0;
		do {
			do {

				if (movimientoValido(columnas, filas)) {
					return true;
				}
				filas++;
			} while (filas <= 3);
			columnas++;
		} while (columnas <= 3);
		return false;
	}

	public boolean comprobar_ganador(char fichaJugador) {

		if ((tablero[0][0] == fichaJugador) && (tablero[0][1] == fichaJugador) && (tablero[0][2] == fichaJugador)) {
			return true;
		}
		if ((tablero[1][0] == fichaJugador) && (tablero[1][1] == fichaJugador) && (tablero[1][2] == fichaJugador)) {
			return true;
		}
		if ((tablero[2][0] == fichaJugador) && (tablero[2][1] == fichaJugador) && (tablero[2][2] == fichaJugador)) {
			return true;
		}
		if ((tablero[0][0] == fichaJugador) && (tablero[1][0] == fichaJugador) && (tablero[2][0] == fichaJugador)) {
			return true;
		}
		if ((tablero[0][1] == fichaJugador) && (tablero[1][1] == fichaJugador) && (tablero[2][1] == fichaJugador)) {
			return true;
		}
		if ((tablero[0][2] == fichaJugador) && (tablero[1][2] == fichaJugador) && (tablero[2][2] == fichaJugador)) {
			return true;
		}
		if ((tablero[0][0] == fichaJugador) && (tablero[1][1] == fichaJugador) && (tablero[2][2] == fichaJugador)) {
			return true;
		}
		if ((tablero[0][2] == fichaJugador) && (tablero[1][1] == fichaJugador) && (tablero[2][0] == fichaJugador)) {
			return true;
		}
		return false;
	}

	/**
	 * Dibuja el tablero en un String
	 */
	@Override
	public String toString() {
		String aux = "";
		aux += "-------\n";
		for (char[] valorFila : this.tablero) {
			aux += "|";
			for (char valorColumna : valorFila) {
				aux += ((valorColumna == '0') ? '-' : valorColumna) + "|";
			}
			aux += "\n-------\n";
		}
		return aux;
	}

}
