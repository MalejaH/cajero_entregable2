package Models;


public class Cuenta{
private String numeroCuenta;
private double saldo;
private String pin;
private int intentosFallidos;
private EstadoCuenta estadoCuenta; 

public Cuenta(String numeroCuenta, double saldo, String pin, int intentosFallidos, EstadoCuenta estadoCuenta) {
    this.numeroCuenta = numeroCuenta;
    this.saldo = saldo;
    this.pin = pin;
    this.intentosFallidos = 0;
    this.estadoCuenta = estadoCuenta; 
}

public String getNumeroCuenta() {
    return numeroCuenta;
}

public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
}

public double getSaldo() {
    return saldo;
}

public void setSaldo(double saldo) {
    this.saldo = saldo;
}

public String getPin() {
    return pin;
}

public void setPin(String pin) {
    this.pin = pin;
}

public int getIntentosFallidos() {
    return intentosFallidos;
}
public EstadoCuenta getEstadoCuenta(){
    return estadoCuenta; 
}
public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
    this.estadoCuenta = estadoCuenta; 
}

public void setIntentosFallidos(int intentosFallidos) {
    this.intentosFallidos = intentosFallidos;
}


}




