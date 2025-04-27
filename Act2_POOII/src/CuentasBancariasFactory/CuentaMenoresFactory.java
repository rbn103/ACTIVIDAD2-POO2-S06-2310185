package CuentasBancariasFactory;

import CuentasBancarias.CuentaAhorroMenores;
import CuentasBancarias.CuentaBancaria;
import Interfaces.CuentaFactory;

import java.util.ArrayList;

public class CuentaMenoresFactory implements CuentaFactory {

    @Override
    public CuentaBancaria crearCuenta(double tasaInteres, double monto, ArrayList<String> titulares,
                                      Integer plazoMeses, Double penalizacion) {

        return new CuentaAhorroMenores(tasaInteres,monto);
    }
}
