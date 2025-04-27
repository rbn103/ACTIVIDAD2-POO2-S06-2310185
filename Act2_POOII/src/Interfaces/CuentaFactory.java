package Interfaces;

import CuentasBancarias.CuentaBancaria;

import java.util.ArrayList;

public interface CuentaFactory {

    CuentaBancaria crearCuenta(double tasaInteres, double monto,
                               ArrayList<String> titulares,
                               Integer plazoMeses, Double penalizacion);

}
