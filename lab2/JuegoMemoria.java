public class JuegoMemoria {
    private Tablero tablero;
    private Jugador[] jugadores;
    private int indiceJugadorActual;
    private int totalPares;

    public JuegoMemoria(String j1, String j2, int filas, int columnas) {
        this.tablero = new Tablero(filas, columnas);
        this.jugadores = new Jugador[2];
        this.jugadores[0] = new Jugador(j1, 1);
        this.jugadores[1] = new Jugador(j2, 2);
        this.indiceJugadorActual = 0;
        this.totalPares = (filas * columnas) / 2;
    }

    public Jugador obtenerJugadorActual() {
        return jugadores[indiceJugadorActual];
    }

    public void cambiarTurno() {
        indiceJugadorActual = 1 - indiceJugadorActual;
    }

    public boolean juegoTerminado() {
        return tablero.todasEmparejadas();
    }

    public Tablero obtenerTablero() {
        return tablero;
    }

    public Jugador[] obtenerJugadores() {
        return jugadores;
    }

    public void reiniciarJuego(String j1, String j2, int filas, int columnas) {
        this.tablero = new Tablero(filas, columnas);
        jugadores[0].reiniciarPuntaje();
        jugadores[1].reiniciarPuntaje();
        indiceJugadorActual = 0;
    }
}
