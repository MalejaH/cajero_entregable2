package Controllers;
import Models.Cuenta;
import Models.EstadoCuenta;
import Models.Usuario;
import Views.Menu;
import Views.MenuAhorro;

import java.util.Scanner;

public class CajeroControles {
    public static void  funcionalidadCajero( Usuario usuario, Cuenta cuenta){
        Scanner scanner = new Scanner(System.in);
        int pinActual = 1512; 
        double saldo = cuenta.getSaldo();
        int intentos = 0; 
        boolean cuentaBloqueada = false; 

        
        while (intentos < 3) {
            System.out.println("Ingrese su PIN: ");
            int pinIngresado = scanner.nextInt();

            if (pinIngresado == pinActual) {
                System.out.println("BIENVENIDO");
                break;

            } else {
               
                cuenta.setIntentosFallidos(cuenta.getIntentosFallidos() + 1); 
                intentos++; 
                System.out.println("PIN incorrecto ¡No, no,no! Intentos fallidos: " + cuenta.getIntentosFallidos());
            }

            if (cuenta.getIntentosFallidos() == 3) {
                cuentaBloqueada = true;
                System.out.println("CUENTA BLOQUEADA ¡RAROOO!");
            }
        }
        if(cuentaBloqueada){
            scanner.close();
            return; 
        }

        int opcion;
        do{
            Menu.mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 0: 
                    System.out.println("\nInformación de Usuario y Cuenta:");
                    System.out.println("Nombre: " + usuario.getnombre());
                    System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
                    System.out.println("Estado de cuenta: " + cuenta.getEstadoCuenta());
                    System.out.println("Saldo actual: $" + cuenta.getSaldo());
                    System.out.println("Número de intentos fallidos: " + cuenta.getIntentosFallidos());
                    break;
                case 1:
                    System.out.println("Este es tu saldo: $" + saldo);
                    break;

                case 2:
                    System.out.println("¿Qué cantidad deseas retirar?: ");
                    double retiro = scanner.nextDouble();
                    if (retiro >= 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Sacaste dinero, tu saldo es de: " + saldo);
                    } else {
                        System.out.println("Cómo vas a retirar un saldo que no tienes? " + saldo);
                    } 
                    break;

                case 3:
                    System.out.println("¿Cuánto dinero vas a depositar?:");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("¡Deposito exitoso!, tu saldo es de: " + saldo);
                    } else {
                        System.out.println("Ese valor no está disponible");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el número de cuenta al que desea enviar dinero: ");
                    String numeroDeCuenta = scanner.next();
                    System.out.println("¿Cuánto dinero vas a enviar?:");
                    int envio = scanner.nextInt();
                    if (envio >= 0 && envio <= saldo) {
                        saldo -= envio;
                        System.out.println("Envío exitoso. Has enviado $" + envio + " a la cuenta: " + numeroDeCuenta + ". Tu saldo es: " + saldo);
                    } else {
                        System.out.println("No tienes suficiente saldo para enviar esa cantidad");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese su PIN actual: ");
                    int pinCambio = scanner.nextInt(); 
                    if (pinCambio == pinActual) {
                        System.out.println("Ingrese su NUEVO pin: ");
                        int nuevoPin = scanner.nextInt();
                        if (nuevoPin == pinActual) {
                            System.out.println("¡El PIN debe ser diferente al anterior!");
                        } else {
                            pinActual = nuevoPin;
                            System.out.println("Su pin se ha cambiado de manera EXITOSA.");
                        }
                    } else {
                        System.out.println("PIN INCORRECTO.");
                    }
                    break;

                case 6:
                    System.out.println("Crea el número de cuenta:");
                    String nuevoNumeroDeCuenta = scanner.next();

    
                    System.out.println("Ingresa el PIN de 4 dígitos para la nueva cuenta:");
                    String nuevoPin = scanner.next();

    
                    System.out.println("Ingresa el nombre del nuevo usuario:");
                    String nombreUsuario = scanner.next();

                    EstadoCuenta nuevoEstado = EstadoCuenta.ACTIVA;

                    double saldoInicial = 0.0;  
                    int intentosIniciales = 0;  
                    Cuenta nuevaCuenta = new Cuenta(nuevoNumeroDeCuenta, saldoInicial, nuevoPin, intentosIniciales, nuevoEstado);
                    Usuario nuevoUsuario = new Usuario(nombreUsuario, nuevaCuenta);

                    usuario = nuevoUsuario;
                    cuenta = nuevaCuenta;

                    System.out.println("Ingresa el monto a depositar en la cuenta:");
                    double montoDeposito = scanner.nextDouble();
                    if (montoDeposito > 0) {
                    nuevaCuenta.setSaldo(nuevaCuenta.getSaldo() + montoDeposito); 
                    System.out.println("Depósito exitoso. El saldo actual de la cuenta es: $" + nuevaCuenta.getSaldo());
                } else {
                    System.out.println("El monto a depositar debe ser mayor que 0.");
                }
                System.out.println("¡¡Su cuenta de ahorros ha sido creada de manera EXITOSA!!");
                
                boolean interactuarCuentaAhorro = true; 
                while (interactuarCuentaAhorro){
                    MenuAhorro.mostrarMenuAhorro();
                    int operacion = scanner.nextInt();

                    switch (operacion) {
                        case 1:
                            System.out.println("Información de la cuenta de ahorro:");
                            System.out.println("Nombre: " + usuario.getnombre());
                            System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
                            System.out.println("Saldo: $" + nuevaCuenta.getSaldo());
                            System.out.println("Estado de la cuenta: " + nuevaCuenta.getEstadoCuenta());
                            break;
                        
                        case 2:
                            System.out.println("Ingresa el monto a depositar:");
                                double montoDepositoAhorros = scanner.nextDouble();
                                if (montoDepositoAhorros > 0) {
                                    nuevaCuenta.setSaldo(nuevaCuenta.getSaldo() + montoDepositoAhorros);
                                    System.out.println("¡Depósito exitoso!, saldo actual: $" + nuevaCuenta.getSaldo());
                                } else {
                                    System.out.println("El monto a depositar debe ser mayor que 0.");
                                }
                        break;
                        case 3:
                            System.out.println("Ingresa el monto a retirar:");
                                double montoRetiro = scanner.nextDouble();
                                if (montoRetiro > 0 && montoRetiro <= nuevaCuenta.getSaldo()) {
                                    nuevaCuenta.setSaldo(nuevaCuenta.getSaldo() - montoRetiro);
                                    System.out.println("Retiro exitoso. Saldo actual: $" + nuevaCuenta.getSaldo());
                                } else {
                                    System.out.println("Monto inválido. Asegúrate de tener saldo suficiente.");
                                } 
                            break;
                        case 4: 
                            System.out.println("Ingresa el número de cuenta al que deseas enviar dinero:");
                            String numeroCuentaDestino = scanner.next();
                            System.out.println("Ingresa el monto a enviar:");
                            double montoEnvio = scanner.nextDouble();

                            if (montoEnvio > 0 && montoEnvio <= nuevaCuenta.getSaldo()) {
                            nuevaCuenta.setSaldo(nuevaCuenta.getSaldo() - montoEnvio);
                            System.out.println("Enviaste $" + montoEnvio + " a la cuenta: " + numeroCuentaDestino);
                            System.out.println("Saldo actual: $" + nuevaCuenta.getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente para enviar esa cantidad.");
                        }
                        break;
                        case 5:
                            interactuarCuentaAhorro = false;
                        break;    
                        default:
                            break;
                    }
                }
                    break;

                case 7:
                    System.out.println("HASTA PRONTO");
                    break;
                
                default:
                    System.out.println("¡Esa NO es una opción!");
                    break; 
            }
        } while (opcion != 7);

        scanner.close();
        }

    }


