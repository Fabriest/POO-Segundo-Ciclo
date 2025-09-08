public class Jugador {
    private String nombre;
    private int puntaje;
    private int id;

    public Jugador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.puntaje = 0;
    }

    public void aumentarPuntaje() {
        puntaje++;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void reiniciarPuntaje() {
        puntaje = 0;
    }
}
