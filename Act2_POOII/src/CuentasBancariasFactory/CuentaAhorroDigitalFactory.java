package CuentasBancariasFactory;

import CuentasBancarias.CuentaAhorroDigital;
import CuentasBancarias.CuentaBancaria;
import Interfaces.CuentaFactory;

import java.util.ArrayList;

public class CuentaAhorroDigitalFactory implements CuentaFactory {
    @Override
    public CuentaBancaria crearCuenta(double tasaInteres, double monto,
                                      ArrayList<String> titulares,
                                      Integer plazoMeses, Double penalizacion) {
        return new CuentaAhorroDigital(tasaInteres, monto);
    }

}
