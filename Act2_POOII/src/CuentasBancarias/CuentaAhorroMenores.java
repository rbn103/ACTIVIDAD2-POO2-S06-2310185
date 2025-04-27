package CuentasBancarias;

import Interfaces.CuentaFactory;

public class CuentaAhorroMenores extends CuentaBancaria {

    private boolean requiereTutor;
    private boolean retiros;
    private boolean mantenimiento;

    public CuentaAhorroMenores(double tasaInteres, double monto) {
        super("Cuenta Ahorro para Menores", tasaInteres, monto);

        this.requiereTutor = true;
        this.retiros = false;
        this.mantenimiento = false;


    }

    @Override
    public String detallesCuenta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Requiere tutor: ").append(requiereTutor ? "Sí" : "No").append("\n");
        sb.append("Requiere mantenimiento: ").append(mantenimiento ? "Sí" : "No").append("\n");
        sb.append("Puede retirar: ").append(retiros ? "Sí" : "No").append("\n");
        return sb.toString();
    }
}
