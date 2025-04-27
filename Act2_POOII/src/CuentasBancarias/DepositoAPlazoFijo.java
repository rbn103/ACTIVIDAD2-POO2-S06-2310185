package CuentasBancarias;

public class DepositoAPlazoFijo extends CuentaBancaria {

    private int plazoMinimoMeses;
    private boolean retiros;
    private double penalizacionPorRetiro;


    public DepositoAPlazoFijo(double tasaInteres, double monto
            , int plazoMinimoMeses, double penalizacionPorRetiro ) {
        super("Deposito A Plazo Fijo", tasaInteres, monto);
        this.plazoMinimoMeses = plazoMinimoMeses;
        this.retiros = false;
        this.penalizacionPorRetiro = penalizacionPorRetiro;
    }

    public String detallesCuenta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Plazo mínimo: ").append(plazoMinimoMeses).append(" meses.\n");
        sb.append("Permite Retiros Anticipados: ").append(retiros ? "Sí" : "No").append("\n");
        sb.append("Penalización por Retiro Anticipado: ").append(penalizacionPorRetiro).append("% del saldo.\n");
        return sb.toString();
    }



}
