package Vistas;

import Interfaces.TipoDeCuenta;

import javax.swing.*;
import java.awt.*;

public class CrearCuenta extends JPanel {

    public JComboBox<TipoDeCuenta> comboTipoCuenta;
    public JTextField txtMonto;
    public JButton btnCrearCuenta;
    public JTextArea txtDetallesCuenta;

    public JPanel panelOpcionesMancomunada;
    public JSpinner spinnerCantidadTitulares;
    public JPanel panelTitulares;
    public JButton btnGenerarTitulares;

    public CrearCuenta() {
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(8, 1, 5, 5));
        comboTipoCuenta = new JComboBox<>(TipoDeCuenta.values());
        txtMonto = new JTextField();
        btnCrearCuenta = new JButton("Crear Cuenta");

        panelOpcionesMancomunada = new JPanel();
        spinnerCantidadTitulares = new JSpinner(new SpinnerNumberModel(2, 2, 4, 1));
        btnGenerarTitulares = new JButton("Generar Campos Titulares");

        panelTitulares = new JPanel(new GridLayout(4, 1, 5, 5));

        panelOpcionesMancomunada.add(new JLabel("Cantidad de Titulares:"));
        panelOpcionesMancomunada.add(spinnerCantidadTitulares);
        panelOpcionesMancomunada.add(btnGenerarTitulares);

        panelOpcionesMancomunada.setVisible(false);

        panelSuperior.add(new JLabel("Tipo de Cuenta:"));
        panelSuperior.add(comboTipoCuenta);
        panelSuperior.add(new JLabel("Monto Inicial:"));
        panelSuperior.add(txtMonto);
        panelSuperior.add(panelOpcionesMancomunada);
        panelSuperior.add(panelTitulares);
        panelSuperior.add(btnCrearCuenta);

        add(panelSuperior, BorderLayout.NORTH);

        txtDetallesCuenta = new JTextArea();
        txtDetallesCuenta.setEditable(false);
        add(new JScrollPane(txtDetallesCuenta), BorderLayout.CENTER);
    }
}
