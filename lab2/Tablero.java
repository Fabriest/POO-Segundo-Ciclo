import java.util.*;

public class Tablero {
    private int filas;
    private int columnas;
    private Ficha[][] fichas;
    private int paresRestantes;
    private static final String[] SIMBOLOS = {
        "@", "#", "$", "%", "&", "*", "+", "=", "?", "!", "~", "^"
    }; //No salen los emojis :c

    public Tablero(int filas, int columnas) {
        if ((filas * columnas) % 2 != 0) {
            throw new IllegalArgumentException("El tablero debe tener un número par de casillas");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        this.paresRestantes = (filas * columnas) / 2;
        inicializarFichas();
    }

    private void inicializarFichas() {
        int cantidad = paresRestantes;
        List<String> simbolosSeleccionados = seleccionarSimbolos(cantidad);
        List<String> todas = new ArrayList<>();
        for (String s : simbolosSeleccionados) {
            todas.add(s);
            todas.add(s);
        }
        Collections.shuffle(todas);
        Iterator<String> it = todas.iterator();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                fichas[i][j] = new Ficha(it.next());
            }
        }
    }

    private List<String> seleccionarSimbolos(int cantidad) {
        if (cantidad > SIMBOLOS.length) {
            throw new IllegalArgumentException("No hay suficientes símbolos");
        }
        List<String> lista = new ArrayList<>(Arrays.asList(SIMBOLOS));
        Collections.shuffle(lista);
        return lista.subList(0, cantidad);
    }

    public boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public Ficha obtenerFicha(int fila, int columna) {
        return fichas[fila][columna];
    }

    public void revelarFicha(int fila, int columna) throws MovimientoInvalidoExcepcion {
        if (!posicionValida(fila, columna)) throw new MovimientoInvalidoExcepcion("Posición fuera del tablero");
        Ficha f = fichas[fila][columna];
        if (!f.estaDisponible()) throw new MovimientoInvalidoExcepcion("Ficha no disponible");
        f.revelar();
    }

    public void ocultarFicha(int fila, int columna) {
        fichas[fila][columna].ocultar();
    }

    public void marcarEmparejadas(int f1,int c1,int f2,int c2) {
        fichas[f1][c1].emparejar();
        fichas[f2][c2].emparejar();
        paresRestantes--;
    }

    public boolean sonIguales(int f1,int c1,int f2,int c2) {
        return fichas[f1][c1].obtenerSimbolo().equals(fichas[f2][c2].obtenerSimbolo());
    }

    public boolean todasEmparejadas() {
        return paresRestantes == 0;
    }

    public int getFilas() {
    return filas;
}

    public int getColumnas() {
    return columnas;  
}


    public String[] obtenerFilaParaMostrar(int fila) {
        String[] filaStr = new String[columnas];
        for (int j = 0; j < columnas; j++) {
            filaStr[j] = fichas[fila][j].mostrar();
        }
        return filaStr;
    }
}
