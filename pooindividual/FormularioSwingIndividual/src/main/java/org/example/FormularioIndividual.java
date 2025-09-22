package org.example;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FormularioIndividual extends JFrame {
    private Image imagen;

    public FormularioIndividual() {
        // Cargar imagen de fondo
        URL url = getClass().getResource("/imagenes/fondo.png");
        System.out.println("Ruta encontrada: " + url);

        if (url != null) {
            imagen = new ImageIcon(url).getImage();
        } else {
            System.out.println("⚠ No se encontró la imagen");
        }

        // Configuración del JFrame
        setTitle("Formulario con Fondo");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel con fondo
        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagen != null) {
                    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelConFondo.setLayout(new GridBagLayout());
        add(panelConFondo);

        // Configuración de layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Estilo de texto blanco
        Color textoColor = Color.WHITE;

        // Etiqueta y campo Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(textoColor);
        gbc.gridx = 0; gbc.gridy = 0;
        panelConFondo.add(lblNombre, gbc);
        gbc.gridx = 1;
        panelConFondo.add(new JTextField(15), gbc);

        // Etiqueta y campo Edad
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setForeground(textoColor);
        gbc.gridx = 0; gbc.gridy = 1;
        panelConFondo.add(lblEdad, gbc);
        gbc.gridx = 1;
        panelConFondo.add(new JTextField(5), gbc);

        // Etiqueta y campo Fecha de Nacimiento
        JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
        lblFecha.setForeground(textoColor);
        gbc.gridx = 0; gbc.gridy = 2;
        panelConFondo.add(lblFecha, gbc);
        gbc.gridx = 1;
        panelConFondo.add(new JTextField(10), gbc);

        // Checkbox
        JLabel lblTerminos = new JLabel("Acepta términos:");
        lblTerminos.setForeground(textoColor);
        gbc.gridx = 0; gbc.gridy = 3;
        panelConFondo.add(lblTerminos, gbc);

        JCheckBox chkTerminos = new JCheckBox();
        chkTerminos.setOpaque(false); // Fondo transparente para que no tape el fondo
        chkTerminos.setForeground(textoColor);
        gbc.gridx = 1;
        panelConFondo.add(chkTerminos, gbc);

        // Botón de enviar
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBackground(new Color(30, 144, 255)); // Azul moderno
        btnEnviar.setForeground(Color.WHITE); // Texto blanco
        btnEnviar.setFocusPainted(false);
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 14));

        btnEnviar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Formulario enviado correctamente"));
        panelConFondo.add(btnEnviar, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioIndividual ventana = new FormularioIndividual();
            ventana.setVisible(true);
        });
    }
}
