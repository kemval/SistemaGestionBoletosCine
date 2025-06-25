/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionboletoscine_kembly;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//clase interfaz del sistema de gestion de boletos del cine

public class InterfazBoletos extends JFrame implements ActionListener {
    private GestorBoletos gestor;
    private GeneradorReportes generadorReportes;
    private DefaultTableModel modeloTabla;
    
    //componentes
    private JSpinner spnCodigo;
    private JTextField txtNombre;
    private ButtonGroup grupoPeliculas;
    private JRadioButton[] radioPeliculas;
    private JComboBox<Integer> cmbSala;
    private JTextField txtPrecio;
    private JTextField txtAsiento;
    private JComboBox<String> cmbHorario;
    private JCheckBox chkPagoRealizado;
    //botones
    private JButton btnAgregar, btnLimpiar, btnGenerarReporte, btnGenerarFactura;
    private JTable tabla;

    public InterfazBoletos() {
        gestor = new GestorBoletos();
        generadorReportes = new GeneradorReportes(gestor);
        
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
        
        setTitle("Sistema de Gestión de Boletos de Cine - Kembly");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 650);
        setMinimumSize(new Dimension(700, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
        //spinner para codigo
        spnCodigo = new JSpinner(new SpinnerNumberModel(1, 1, 9999, 1));
        txtNombre = new JTextField(20);
        
        // radio botones-pelis
        grupoPeliculas = new ButtonGroup();
        radioPeliculas = new JRadioButton[Pelicula.values().length];
        for (int i = 0; i < Pelicula.values().length; i++) {
            radioPeliculas[i] = new JRadioButton(Pelicula.values()[i].getNombre());
            grupoPeliculas.add(radioPeliculas[i]);
        }
        radioPeliculas[0].setSelected(true);
        
        //componentes salas
        Integer[] salas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        cmbSala = new JComboBox<>(salas);
        txtPrecio = new JTextField(10);
        txtAsiento = new JTextField(10);
        
        String[] horarios = {"3:00 p.m.", "6:30 p.m.", "9:00 p.m.", "11:30 p.m."};
        cmbHorario = new JComboBox<>(horarios);
        chkPagoRealizado = new JCheckBox("Pago Realizado");
        
        //botones de accion
        btnAgregar = new JButton("Agregar Boleto");
        btnLimpiar = new JButton("Limpiar Campos");
        btnGenerarReporte = new JButton("Generar Reporte");
        btnGenerarFactura = new JButton("Generar Factura");
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());
        
        //panel del formulario
        JPanel panelFormulario = crearPanelFormulario();
        JPanel panelBotones = crearPanelBotones();
        JPanel panelTabla = crearPanelTabla();
        
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelFormulario, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);
    }
    
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Boleto"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // componentes con gridbaglayout
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1; panel.add(spnCodigo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; panel.add(txtNombre, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Película:"), gbc);
        gbc.gridx = 1;
        JPanel panelPeliculas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (JRadioButton radio : radioPeliculas) {
            panelPeliculas.add(radio);
        }
        panel.add(panelPeliculas, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Sala:"), gbc);
        gbc.gridx = 1; panel.add(cmbSala, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Precio:"), gbc);
        gbc.gridx = 1; panel.add(txtPrecio, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Asiento:"), gbc);
        gbc.gridx = 1; panel.add(txtAsiento, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Horario:"), gbc);
        gbc.gridx = 1; panel.add(cmbHorario, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        panel.add(chkPagoRealizado, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(btnAgregar);
        panel.add(btnLimpiar);
        panel.add(btnGenerarReporte);
        panel.add(btnGenerarFactura);
        return panel;
    }
    
    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Boletos Registrados"));
        
        String[] columnas = {"Código", "Nombre", "Película", "Sala", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(0, 200));
        panel.add(scroll, BorderLayout.CENTER);
        
        return panel;
    }

    private void configurarEventos() {
        btnAgregar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnGenerarReporte.addActionListener(this);
        btnGenerarFactura.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            agregarBoleto();
        } else if (e.getSource() == btnLimpiar) {
            limpiarFormulario();
        } else if (e.getSource() == btnGenerarReporte) {
            generarReporte();
        } else if (e.getSource() == btnGenerarFactura) {
            generarFactura();
        }
    }

    private void agregarBoleto() {
        try {
            String errorValidacion = ValidadorDatos.validarBoleto(
                txtNombre.getText(), txtPrecio.getText(), txtAsiento.getText());
            
            if (errorValidacion != null) {
                mostrarError(errorValidacion);
                return;
            }
            
            //creacion del boleto
            int codigo = (Integer) spnCodigo.getValue();
            if (gestor.existeCodigo(codigo)) {
                mostrarError("Ya existe un boleto con ese código.");
                return;
            }
            
            Pelicula peliculaSeleccionada = obtenerPeliculaSeleccionada();
            
            Boleto nuevoBoleto = new Boleto(
                codigo,
                txtNombre.getText().trim(),
                peliculaSeleccionada,
                (Integer) cmbSala.getSelectedItem(),
                Double.parseDouble(txtPrecio.getText().trim()),
                txtAsiento.getText().trim(),
                (String) cmbHorario.getSelectedItem(),
                chkPagoRealizado.isSelected()
            );
            
            if (gestor.agregarBoleto(nuevoBoleto)) {
                agregarFilaTabla(nuevoBoleto);
                mostrarExito("Boleto agregado exitosamente.");
            }
            
        } catch (Exception ex) {
            mostrarError("Error al agregar boleto: " + ex.getMessage());
        }
    }
    
    private Pelicula obtenerPeliculaSeleccionada() {
        for (int i = 0; i < radioPeliculas.length; i++) {
            if (radioPeliculas[i].isSelected()) {
                return Pelicula.values()[i];
            }
        }
        return Pelicula.values()[0];
    }
    
    private void agregarFilaTabla(Boleto boleto) {
        Object[] fila = {
            boleto.getCodigo__boleto(),
            boleto.getNombre__comprador(),
            boleto.getPelicula().getNombre(),
            boleto.getSala(),
            String.format("₡%.2f", boleto.getPrecio__boleto())
        };
        modeloTabla.addRow(fila);
    }

    private void limpiarFormulario() {
        spnCodigo.setValue(1);
        txtNombre.setText("");
        radioPeliculas[0].setSelected(true);
        cmbSala.setSelectedIndex(0);
        txtPrecio.setText("");
        txtAsiento.setText("");
        cmbHorario.setSelectedIndex(0);
        chkPagoRealizado.setSelected(false);
    }

    private void generarReporte() {
        try {
            String archivo = generadorReportes.generarReporteGeneral();
            mostrarExito("Reporte generado: " + archivo);
        } catch (IllegalStateException ex) {
            mostrarAdvertencia(ex.getMessage());
        } catch (Exception ex) {
            mostrarError("Error al generar reporte: " + ex.getMessage());
        }
    }

    private void generarFactura() {
        try {
            String codigoStr = JOptionPane.showInputDialog(this, "Ingrese el código del boleto:");
            if (codigoStr == null || codigoStr.trim().isEmpty()) {
                return;
            }
            
            if (!ValidadorDatos.esNumeroValido(codigoStr)) {
                mostrarError("Código inválido. Debe ser un número.");
                return;
            }
            
            int codigo = Integer.parseInt(codigoStr);
            String archivo = generadorReportes.generarFactura(codigo);
            mostrarExito("Factura generada: " + archivo);
            
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        } catch (Exception ex) {
            mostrarError("Error al generar factura: " + ex.getMessage());
        }
    }
    
    //metodos para la muestra de mensajes de error, exito y advertencias
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
