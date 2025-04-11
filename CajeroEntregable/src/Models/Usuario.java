package Models;

public class Usuario {
    private String nombre;
    private Cuenta cuenta;

    public Usuario(String nombre, Cuenta cuenta){
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public String getnombre() {
        return nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public EstadoCuenta getEstadoCuenta() {
        return cuenta.getEstadoCuenta();
    }
    
    public void setEstadoCuenta(EstadoCuenta estado) {
        cuenta.setEstadoCuenta(estado); 
    }
}

