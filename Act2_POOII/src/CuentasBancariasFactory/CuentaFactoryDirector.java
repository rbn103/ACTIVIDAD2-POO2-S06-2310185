package CuentasBancariasFactory;
import CuentasBancarias.CuentaBancaria;
import Interfaces.CuentaFactory;
import Interfaces.TipoDeCuenta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CuentaFactoryDirector {

    private static Map<TipoDeCuenta, CuentaFactory> factories = new HashMap<>();

    static {
        factories.put(TipoDeCuenta.SUELDO, new CuentaAhorroSueldoFactory());
        factories.put(TipoDeCuenta.DIGITAL, new CuentaAhorroDigitalFactory());
        factories.put(TipoDeCuenta.MANCOMUNADA, new CuentaAhorroMancomunadaFactory());
        factories.put(TipoDeCuenta.PLAZO_FIJO, new DepositoAPlazoFijoFactory());
        factories.put(TipoDeCuenta.MENORES, new CuentaMenoresFactory());
    }

    public static CuentaBancaria crearCuenta(
            TipoDeCuenta tipoCuenta,
            double saldo,
            ArrayList<String> titulares,
            Integer plazoMeses,
            Double penalizacion)
    {


        CuentaFactory factory = factories.get(tipoCuenta);
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de cuenta no soportado: " + tipoCuenta);
        }

        if (tipoCuenta == TipoDeCuenta.MANCOMUNADA && (titulares == null || titulares.isEmpty())) {
            throw new IllegalArgumentException("Se requieren titulares para la cuenta mancomunada.");
        }

        if (tipoCuenta == TipoDeCuenta.PLAZO_FIJO && (plazoMeses == null || plazoMeses <= 0)) {
            throw new IllegalArgumentException("Se requiere un plazo válido para el depósito a plazo fijo.");
        }

        return factory.crearCuenta(tipoCuenta.getTasaInteres(), saldo, titulares, plazoMeses, penalizacion);
    }
}

