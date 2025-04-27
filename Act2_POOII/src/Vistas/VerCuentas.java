package Vistas;

import javax.swing.*;
import java.awt.*;

public class VerCuentas extends JPanel {

    public JTextArea txtCuentasRegistradas;

    public VerCuentas() {
        setLayout(new BorderLayout());

        txtCuentasRegistradas = new JTextArea();
        txtCuentasRegistradas.setEditable(false);

        add(new JScrollPane(txtCuentasRegistradas), BorderLayout.CENTER);
    }
}
