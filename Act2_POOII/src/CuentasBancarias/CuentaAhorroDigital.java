package CuentasBancarias;

import Interfaces.TipoDeCuenta;

public class CuentaAhorroDigital extends CuentaBancaria {
    private boolean mantenimiento;
    private String plazoMantenimiento;
    private int limiteRetiros;

    public CuentaAhorroDigital(double tasaInteres, double monto) {
        super("Cuenta Ahorro Digital", tasaInteres, monto);
        this.mantenimiento = true;
        this.plazoMantenimiento = "mensual";
        this.limiteRetiros = 3;
    }


    //Cuentas Bancarias
    public String detallesCuenta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta de Ahorro Digital:\n")
                .append("Mantenimiento: ").append(mantenimiento ? "Sí" : "No").append("\n")
                .append("Plazo de Mantenimiento: ").append(plazoMantenimiento).append("\n")
                .append("Límite de Retiros: ").append(limiteRetiros).append(" por mes.\n");

        return sb.toString();
    }


}
