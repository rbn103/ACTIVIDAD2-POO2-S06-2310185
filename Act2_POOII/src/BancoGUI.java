import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoGUI extends JFrame {
    private JComboBox<String> tipoCuentaCombo;
    private JTextArea detallesTextArea;
    private JTextField montoField;

    //TODO
    // PROBLEMA 01: La GUI está fuertemente acoplada a la clase CuentaAhorro y su lógica de creación
    public BancoGUI() {
        setTitle("Sistema Bancario - Problema de Acoplamiento");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel de selección
        JPanel panelSuperior = new JPanel(new GridLayout(3, 2, 5, 5));

        panelSuperior.add(new JLabel("Tipo de Cuenta:"));
        tipoCuentaCombo = new JComboBox<>(new String[]{
                "Ahorro Sueldo",
                "Ahorro Digital",
                "Ahorro Mancomunada",
                "Plazo Fijo"
        });
        panelSuperior.add(tipoCuentaCombo);

        panelSuperior.add(new JLabel("Monto Inicial:"));
        montoField = new JTextField("100.00");
        panelSuperior.add(montoField);

        JButton crearBtn = new JButton("Crear Cuenta");
        crearBtn.addActionListener(new CrearCuentaListener());
        panelSuperior.add(crearBtn);

        add(panelSuperior, BorderLayout.NORTH);

        // Area de resultados
        detallesTextArea = new JTextArea();
        detallesTextArea.setEditable(false);
        add(new JScrollPane(detallesTextArea), BorderLayout.CENTER);
    }

    //TODO
    // PROBLEMA 02: Clase interna que muestra el acoplamiento con la lógica de creación
    private class CrearCuentaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tipo = (String) tipoCuentaCombo.getSelectedItem();
                double monto = Double.parseDouble(montoField.getText());

                //TODO
                // PROBLEMA 03: La GUI conoce directamente los detalles de construcción
                CuentaAhorro cuenta;
                switch(tipo) {
                    case "Ahorro Sueldo":
                        cuenta = new CuentaAhorro(tipo, 2.5, monto, false, 5, false, 1, 0);
                        break;
                    case "Ahorro Digital":
                        cuenta = new CuentaAhorro(tipo, 3.0, monto, true, 3, true, 1, 0);
                        break;
                    case "Ahorro Mancomunada":
                        cuenta = new CuentaAhorro(tipo, 4.0, monto, false, 5, false, 2, 0);
                        break;
                    case "Plazo Fijo":
                        cuenta = new CuentaAhorro(tipo, 6.0, monto, false, 0, false, 1, 6);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo no válido");
                }

                //TODO
                // PROBLEMA 04: La GUI conoce la estructura interna de CuentaAhorro
                String detalles = "=== Detalles de la Cuenta ===\n" +
                        "Tipo: " + cuenta.getTipo() + "\n" +
                        "Tasa: " + cuenta.getTasaInteres() + "%\n" +
                        "Saldo: $" + cuenta.getMonto() + "\n" +
                        "Cantidad de titulares: " + cuenta.getCantidadTitulares() + "\n" +
                        "Mantenimiento: " + (cuenta.isPagaMantenimiento() ? "Sí" : "No") + "\n" +
                        "Retiros ATM: " + cuenta.getRetirosPermitidosATM() + "/mes";

                if (cuenta.getPlazoMeses() > 0) {
                    detalles += "\nPlazo: " + cuenta.getPlazoMeses() + " meses";
                }

                detallesTextArea.setText(detalles);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(BancoGUI.this, "Monto inválido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(BancoGUI.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //TODO
    // PROBLEMA 05: LA GUI principal o main debería ser invocada utilizando arquitectura de software
    public static void main(String[] args) {

    }
}