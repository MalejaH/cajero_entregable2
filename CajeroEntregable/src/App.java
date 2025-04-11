import Models.Cuenta;
import Models.EstadoCuenta;
import Models.Usuario;
import Controllers.CajeroControles;

public class App {
    public static void main(String[] args){

        Cuenta cuenta = new Cuenta("200615", 100000, "1512", 0, EstadoCuenta.ACTIVA);
        Usuario usuario = new Usuario("María Alejandra Hernández", cuenta);

        CajeroControles.funcionalidadCajero(usuario, cuenta);     
    }
}
