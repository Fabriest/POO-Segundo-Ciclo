public class localidad {
    private String nombre;
    private double precio;
    private int espacio_disponible;
    private int boletos_vendidos;

    public localidad(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.espacio_disponible = 20;
        this.boletos_vendidos = 0;
    }

    public boolean validar_presupuesto(double presupuesto){
        return precio <= presupuesto;
    }

    public boolean validar_espacio(int cantidad_boletos){
        return cantidad_boletos <= espacio_disponible;
    }

    public int venderBoletos(int cantidadSolicitada) {
        int cantidadVendida = Math.min(cantidadSolicitada, espacio_disponible);
        espacio_disponible -= cantidadVendida;
        boletos_vendidos += cantidadVendida;
        return cantidadVendida;
    }

    public String getNombre() { 
        return nombre; }

    public double getPrecio() { 
        return precio; }

    public int getEspacioDisponible() { 
        return espacio_disponible; }
        
    public int getBoletosVendidos() { 
        return boletos_vendidos; }
}
