package Vistas;

import Controlador.CuentaController;

import javax.swing.*;

public class Home extends JFrame {

    private CrearCuenta panelCrearCuenta;
    private VerCuentas panelVerCuentas;
    private CuentaController controlador;

    public Home() {
        setTitle("Gestión de Cuentas Bancarias");
        setSize(600, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelCrearCuenta = new CrearCuenta();
        panelVerCuentas = new VerCuentas();
        controlador = new CuentaController(panelCrearCuenta, panelVerCuentas);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Crear Cuenta", panelCrearCuenta);
        tabbedPane.addTab("Ver Cuentas", panelVerCuentas);

        add(tabbedPane);
    }
}
