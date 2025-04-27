import CuentasBancarias.CuentaBancaria;
import CuentasBancariasFactory.CuentaFactoryDirector;
import Interfaces.CuentaFactory;
import Interfaces.TipoDeCuenta;
import Vistas.Home;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Home c = new Home();
            c.setVisible(true);
        });

    }
}