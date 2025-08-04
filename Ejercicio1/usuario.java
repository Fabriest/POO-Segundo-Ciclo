import java.util.Random;

public class usuario{
    private String nombre, email;
    private int cantidad_boletos, ticket;
    private double presupuesto;

    public usuario(String nombre, String email, int cantidad_boletos, double presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.cantidad_boletos = cantidad_boletos;
        this.presupuesto = presupuesto;
        randomticket();
    }

    private void randomticket(){
        Random rand = new Random();
        this.ticket = rand.nextInt(15000) + 1;
    }

    public boolean validarID() {
        Random rand = new Random();
        int a = rand.nextInt(15000) + 1;
        int b = rand.nextInt(15000) + 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ticket >= min && ticket <= max;
    }

    public String getNombre() { 
        return nombre; 
        }

    public String getEmail() { 
        return email; 
        }

    public int getCantidadBoletos() { 
        return cantidad_boletos; 
        }

    public double getPresupuesto() { 
        return presupuesto; 
        }

    public int getTicket() { 
        return ticket; 
        }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
        }

    public void setEmail(String email) { 
        this.email = email; 
        }

    public void setCantidadBoletos(int cantidad) { 
        this.cantidad_boletos = cantidad; 
        }

    public void setPresupuesto(double presupuesto) { 
        this.presupuesto = presupuesto; 
        }
}
