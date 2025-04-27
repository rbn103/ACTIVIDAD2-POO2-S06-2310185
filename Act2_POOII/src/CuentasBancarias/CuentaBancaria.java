package CuentasBancarias;

public abstract class CuentaBancaria {

    private String tipo;
    private double tasaInteres;
    private double monto;

    public CuentaBancaria(String tipo, double tasaInteres, double monto) {
        this.tipo = tipo;
        this.tasaInteres = tasaInteres;
        this.monto = monto;
    }

    public String mostrarCuenta()   {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Cuenta: ").append(tipo).append("\n");
        sb.append("Saldo: $").append(monto).append("\n");
        sb.append("Tasa de Interés: ").append(tasaInteres).append("%\n");
        sb.append(detallesCuenta());
        return sb.toString();
    }

    public abstract String detallesCuenta();


}
