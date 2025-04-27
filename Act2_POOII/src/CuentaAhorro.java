public class CuentaAhorro {
    private String tipo;
    private double tasaInteres;
    private double monto;
    private boolean pagaMantenimiento;
    private int retirosPermitidosATM;
    private boolean esDigital;
    private int cantidadTitulares;
    private int plazoMeses;

    // Constructor complejo con muchos parámetros
    public CuentaAhorro(String tipo,
                        double tasaInteres,
                        double monto,
                        boolean pagaMantenimiento,
                        int retirosPermitidosATM,
                        boolean esDigital,
                        int cantidadTitulares,
                        int plazoMeses) {
        this.tipo = tipo;
        this.tasaInteres = tasaInteres;
        this.monto = monto;
        this.pagaMantenimiento = pagaMantenimiento;
        this.retirosPermitidosATM = retirosPermitidosATM;
        this.esDigital = esDigital;
        this.cantidadTitulares = cantidadTitulares;
        this.plazoMeses = plazoMeses;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isPagaMantenimiento() {
        return pagaMantenimiento;
    }

    public void setPagaMantenimiento(boolean pagaMantenimiento) {
        this.pagaMantenimiento = pagaMantenimiento;
    }

    public int getRetirosPermitidosATM() {
        return retirosPermitidosATM;
    }

    public void setRetirosPermitidosATM(int retirosPermitidosATM) {
        this.retirosPermitidosATM = retirosPermitidosATM;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    public void setEsDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }

    public int getCantidadTitulares() {
        return cantidadTitulares;
    }

    public void setCantidadTitulares(int cantidadTitulares) {
        this.cantidadTitulares = cantidadTitulares;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }
}
