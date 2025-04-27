package Interfaces;

public enum TipoDeCuenta {
    SUELDO(3.5),
    DIGITAL(2.5),
    MANCOMUNADA(4.5),
    PLAZO_FIJO(6.0),
    MENORES(2.0);

    private double tasaInteres;

    TipoDeCuenta(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

}
