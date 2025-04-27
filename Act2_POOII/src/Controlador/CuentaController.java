package Controlador;

import CuentasBancarias.CuentaBancaria;
import CuentasBancariasFactory.CuentaFactoryDirector;
import Interfaces.TipoDeCuenta;
import Vistas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CuentaController {

    private CrearCuenta panelCrearCuenta;
    private VerCuentas panelVerCuentas;
    private ArrayList<CuentaBancaria> cuentasRegistradas;

    public CuentaController(CrearCuenta panelCrearCuenta, VerCuentas panelVerCuentas) {
        this.panelCrearCuenta = panelCrearCuenta;
        this.panelVerCuentas = panelVerCuentas;
        this.cuentasRegistradas = new ArrayList<>();

        initListeners();
    }

    private void initListeners() {
        panelCrearCuenta.comboTipoCuenta.addActionListener(e -> actualizarPanelTitulares());
        panelCrearCuenta.btnGenerarTitulares.addActionListener(e -> generarCamposTitulares());
        panelCrearCuenta.btnCrearCuenta.addActionListener(e -> crearCuenta());
    }

    private void actualizarPanelTitulares() {
        TipoDeCuenta seleccion = (TipoDeCuenta) panelCrearCuenta.comboTipoCuenta.getSelectedItem();
        panelCrearCuenta.panelOpcionesMancomunada.setVisible(seleccion == TipoDeCuenta.MANCOMUNADA);
        panelCrearCuenta.panelTitulares.removeAll();
        panelCrearCuenta.panelTitulares.revalidate();
        panelCrearCuenta.panelTitulares.repaint();
    }

    private void generarCamposTitulares() {
        panelCrearCuenta.panelTitulares.removeAll();
        int cantidad = (Integer) panelCrearCuenta.spinnerCantidadTitulares.getValue();
        for (int i = 0; i < cantidad; i++) {
            panelCrearCuenta.panelTitulares.add(new JTextField("Titular " + (i + 1)));
        }
        panelCrearCuenta.panelTitulares.revalidate();
        panelCrearCuenta.panelTitulares.repaint();
    }

    private ArrayList<String> obtenerNombresTitulares() {
        ArrayList<String> titulares = new ArrayList<>();
        for (Component comp : panelCrearCuenta.panelTitulares.getComponents()) {
            if (comp instanceof JTextField) {
                String nombre = ((JTextField) comp).getText().trim();
                if (!nombre.isEmpty()) {
                    titulares.add(nombre);
                }
            }
        }
        return titulares;
    }

    private void crearCuenta() {
        try {
            TipoDeCuenta tipo = (TipoDeCuenta) panelCrearCuenta.comboTipoCuenta.getSelectedItem();
            double monto = Double.parseDouble(panelCrearCuenta.txtMonto.getText());
            ArrayList<String> titulares = null;
            Integer plazoMeses = null;
            Double penalizacion = null;

            if (tipo == TipoDeCuenta.MANCOMUNADA) {
                titulares = obtenerNombresTitulares();
            }

            CuentaBancaria cuenta = CuentaFactoryDirector.crearCuenta(
                    tipo, monto, titulares, plazoMeses, penalizacion
            );

            cuentasRegistradas.add(cuenta);
            panelCrearCuenta.txtDetallesCuenta.setText(cuenta.mostrarCuenta());

            actualizarListaCuentas();
            limpiarCampos();

            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void actualizarListaCuentas() {
        StringBuilder builder = new StringBuilder();
        for (CuentaBancaria cuenta : cuentasRegistradas) {
            builder.append(cuenta.mostrarCuenta()).append("\n------------------\n");
        }
        panelVerCuentas.txtCuentasRegistradas.setText(builder.toString());
    }

    private void limpiarCampos() {
        panelCrearCuenta.txtMonto.setText("");
        panelCrearCuenta.panelTitulares.removeAll();
        panelCrearCuenta.panelTitulares.revalidate();
        panelCrearCuenta.panelTitulares.repaint();
    }
}
