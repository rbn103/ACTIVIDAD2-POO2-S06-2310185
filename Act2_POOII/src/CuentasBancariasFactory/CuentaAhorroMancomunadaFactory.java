package CuentasBancariasFactory;

import CuentasBancarias.CuentaAhorroMancomunada;
import CuentasBancarias.CuentaBancaria;
import Interfaces.CuentaFactory;

import java.util.ArrayList;

public class CuentaAhorroMancomunadaFactory implements CuentaFactory {
    @Override
    public CuentaBancaria crearCuenta(double tasaInteres, double monto,
                                      ArrayList<String> titulares,
                                      Integer plazoMeses, Double penalizacion) {

        if (titulares == null || titulares.isEmpty()) {
            throw new IllegalArgumentException("Se requieren titulares para cuenta mancomunada.");
        }
        return new CuentaAhorroMancomunada(titulares, tasaInteres, monto);
    }
}
