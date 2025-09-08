public class ControladorJuego {
    private JuegoMemoria modelo;

    public ControladorJuego(JuegoMemoria modelo) {
        this.modelo = modelo;
    }

    public boolean intentarSeleccionar(int f1, int c1, int f2, int c2) throws MovimientoInvalidoExcepcion {
        Tablero t = modelo.obtenerTablero();
        t.revelarFicha(f1, c1);
        t.revelarFicha(f2, c2);

        if (t.sonIguales(f1, c1, f2, c2)) {
            t.marcarEmparejadas(f1, c1, f2, c2);
            modelo.obtenerJugadorActual().aumentarPuntaje();
            return true;
        } else {
            t.ocultarFicha(f1, c1);
            t.ocultarFicha(f2, c2);
            modelo.cambiarTurno();
            return false;
        }
    }

    public Jugador obtenerGanador() {
        Jugador[] jugadores = modelo.obtenerJugadores();
        if (jugadores[0].obtenerPuntaje() > jugadores[1].obtenerPuntaje()) {
            return jugadores[0];
        } else if (jugadores[1].obtenerPuntaje() > jugadores[0].obtenerPuntaje()) {
            return jugadores[1];
        } else {
            return null;
        }
    }
}
