package CuentasBancariasFactory;

import CuentasBancarias.CuentaAhorroSueldo;
import CuentasBancarias.CuentaBancaria;
import Interfaces.CuentaFactory;

import java.util.ArrayList;

public class CuentaAhorroSueldoFactory implements CuentaFactory {

    @Override
    public CuentaBancaria crearCuenta(double tasaInteres, double monto,
                                      ArrayList<String> titulares, Integer plazoMeses,
                                      Double penalizacion) {
        return new CuentaAhorroSueldo(tasaInteres, monto);
    }
}
