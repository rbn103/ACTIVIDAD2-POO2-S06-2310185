package CuentasBancarias;

import java.util.ArrayList;


public class CuentaAhorroMancomunada extends CuentaBancaria{
    private ArrayList<String> titulares;
    private boolean requiereFirma;
    private boolean mantenimiento;


    public CuentaAhorroMancomunada(ArrayList<String> titulares, double tasaInteres, double monto) {
        super("Cuenta Ahorro Mancomunada", tasaInteres, monto);
        this.titulares = titulares;
        this.requiereFirma = true;
        this.mantenimiento = false;
    }

    //Cuentas Bancarias
    @Override
    public String detallesCuenta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulares:\n");
        for (String titular : titulares) {
            sb.append("- ").append(titular).append("\n");
        }
        sb.append("Requiere firma conjunta: ").append(requiereFirma ? "Sí" : "No").append("\n");
        sb.append("Requiere mantenimiento: ").append(mantenimiento ? "Sí" : "No").append("\n");
        return sb.toString();
    }


}
