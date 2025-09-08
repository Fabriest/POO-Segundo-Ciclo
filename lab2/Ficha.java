public class Ficha {
    private String simbolo;
    private boolean revelada;
    private boolean emparejada;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.revelada = false;
        this.emparejada = false;
    }

    public void revelar() {
        this.revelada = true;
    }

    public void ocultar() {
        if (!emparejada) this.revelada = false;
    }

    public void emparejar() {
        this.emparejada = true;
        this.revelada = true;
    }

    public boolean estaDisponible() {
        return !revelada && !emparejada;
    }

    public String obtenerSimbolo() {
        return simbolo;
    }

    public String mostrar() {
        if (revelada || emparejada) {
            return simbolo;
        } else {
            return "*";
        }
    }
}
