//Autor: Fabricio Estrada 25230
//Laboratorio 2

import java.util.*;

public class Vista {
    private Scanner entrada;
    private ControladorJuego controlador;
    private JuegoMemoria modelo;

    public Vista() {
        entrada = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Vista v = new Vista();
        v.iniciarJuego();
    }

    private void iniciarJuego() {
        System.out.print("Ingrese nombre del Jugador 1: ");
        String j1 = entrada.nextLine();
        System.out.print("Ingrese nombre del Jugador 2: ");
        String j2 = entrada.nextLine();

        System.out.print("Ingrese filas del tablero: ");
        int filas = entrada.nextInt();
        System.out.print("Ingrese columnas del tablero: ");
        int columnas = entrada.nextInt();

        modelo = new JuegoMemoria(j1, j2, filas, columnas);
        controlador = new ControladorJuego(modelo);

        while (!modelo.juegoTerminado()) {
            mostrarTablero();
            Jugador actual = modelo.obtenerJugadorActual();
            System.out.println("Turno de: " + actual.obtenerNombre());

            int[] p1 = pedirPosicion("Primera ficha");
            int[] p2 = pedirPosicion("Segunda ficha");

            try {
                boolean acierto = controlador.intentarSeleccionar(p1[0], p1[1], p2[0], p2[1]);
                if (acierto) {
                    System.out.println("¡Correcto! Mantienes el turno.");
                } else {
                    System.out.println("No coincidieron. Turno cambiado.");
                }
            } catch (MovimientoInvalidoExcepcion e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        mostrarPuntajes();
        Jugador ganador = controlador.obtenerGanador();
        if (ganador != null) {
            System.out.println("Ganador: " + ganador.obtenerNombre());
        } else {
            System.out.println("¡Empate!");
        }
    }

    private void mostrarTablero() {
        Tablero t = modelo.obtenerTablero();
        for (int i = 0; i < t.getFilas(); i++) {
            String[] fila = t.obtenerFilaParaMostrar(i);
            for (String s : fila) {
                System.out.print("[" + s + "]");
            }
            System.out.println();
        }
    }


    private int[] pedirPosicion(String mensaje) {
        System.out.println(mensaje + " (fila columna): ");
        int fila = entrada.nextInt();
        int columna = entrada.nextInt();
        return new int[]{fila, columna};
    }

    private void mostrarPuntajes() {
        for (Jugador j : modelo.obtenerJugadores()) {
            System.out.println(j.obtenerNombre() + ": " + j.obtenerPuntaje() + " puntos");
        }
    }
}
