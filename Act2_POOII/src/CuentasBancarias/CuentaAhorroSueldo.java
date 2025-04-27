package CuentasBancarias;

public class CuentaAhorroSueldo extends CuentaBancaria {
    private boolean mantenimiento;
    private String plazoMantenimiento;
    private int limiteRetiros;


    public CuentaAhorroSueldo(double tasaInteres, double monto) {
        super("Cuenta Ahorro Sueldo", tasaInteres, monto);

        this.mantenimiento = false;
        this.plazoMantenimiento = "Ninguno";
        this.limiteRetiros = 5;
    }

    //Cuentas Bancarias
    @Override
    public String detallesCuenta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mantenimiento: ").append(mantenimiento ? "Sí" : "No").append("\n");
        sb.append("Plazo de Mantenimiento: ").append(plazoMantenimiento).append("\n");
        sb.append("Límite de Retiros: ").append(limiteRetiros).append(" por mes.\n");
        return sb.toString();
    }


}
