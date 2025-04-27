package CuentasBancariasFactory;

import Interfaces.CuentaFactory;
import CuentasBancarias.DepositoAPlazoFijo;
import CuentasBancarias.CuentaBancaria;
import Interfaces.CuentaFactory;

import java.util.ArrayList;

public class DepositoAPlazoFijoFactory implements CuentaFactory {

    @Override
    public CuentaBancaria crearCuenta(double tasaInteres, double monto,
                                      ArrayList<String> titulares,
                                      Integer plazoMeses, Double penalizacion) {
        if (plazoMeses == null || penalizacion == null) {
            throw new IllegalArgumentException("Plazo mínimo y penalización son requeridos para depósito a plazo fijo.");
        }
        return new DepositoAPlazoFijo(tasaInteres, monto, plazoMeses, penalizacion);
    }

}
