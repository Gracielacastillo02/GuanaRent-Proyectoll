/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

/**
 * Diálogo para registrar un nuevo alquiler o editar uno existente. Se usa tanto desde el botón "Nuevo" como desde el botón "Editar" de DlgMainAlquileres, dependiendo de qué constructor se llame.
 *
 * @author Erick
 */
public class DlgNewAlquiler extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DlgNewAlquiler.class.getName());

    /**
     * Lista de alquileres del sistema, compartida con la ventana principal de Alquileres.
     */
    private java.util.ArrayList<modelo.Alquileres> listaAlquileres;

    /**
     * Lista de inquilinos registrados, usada para llenar el combo de selección.
     */
    private java.util.ArrayList<modelo.Inquilino> listaInquilinos;

    /**
     * Lista de viviendas registradas, usada para llenar el combo de selección.
     */
    private java.util.ArrayList<modelo.Vivienda> listaViviendas;

    /**
     * Indica si el usuario guardó los datos (true) o cerró el diálogo sin guardar (false).
     */
    private boolean guardado = false;

    /**
     * Alquiler que se está editando. Si es null, el diálogo está en modo "nuevo", si no, está en modo "editar".
     */
    private modelo.Alquileres alquilerEditar;

    /**
     * Crea el diálogo en modo "nuevo alquiler".
     *
     * @param parent ventana padre desde la que se abre el diálogo
     * @param modal si el diálogo debe bloquear la ventana padre mientras está abierto
     * @param listaAlquileres lista de alquileres donde se agregará el nuevo registro
     * @param listaInquilinos lista de inquilinos disponibles para elegir
     * @param listaViviendas lista de viviendas disponibles para elegir
     */
    public DlgNewAlquiler(java.awt.Frame parent, boolean modal,
            java.util.ArrayList<modelo.Alquileres> listaAlquileres,
            java.util.ArrayList<modelo.Inquilino> listaInquilinos,
            java.util.ArrayList<modelo.Vivienda> listaViviendas) {
        super(parent, modal);
        this.listaAlquileres = listaAlquileres;
        this.listaInquilinos = listaInquilinos;
        this.listaViviendas = listaViviendas;
        initComponents();
        cargarCombos();
    }

    /**
     * Llena los combos de Inquilino y Vivienda con los datos de las listas recibidas por el diálogo. Se ejecuta una sola vez, al crear la ventana.
     */
    private void cargarCombos() {
        cbInquilino.removeAllItems();
        for (modelo.Inquilino i : listaInquilinos) {
            cbInquilino.addItem(i.getNomInqui() + " - " + i.getCedInqui());
        }

        cbVivienda.removeAllItems();
        for (modelo.Vivienda v : listaViviendas) {
            cbVivienda.addItem("Vivienda #" + v.getIdVivienda());
        }
    }

    /**
     * Crea el diálogo en modo "editar alquiler", precargando los datos del alquiler recibido en los campos del formulario.
     *
     * @param parent ventana padre desde la que se abre el diálogo
     * @param modal si el diálogo debe bloquear la ventana padre mientras está abierto
     * @param listaAlquileres lista de alquileres del sistema
     * @param listaInquilinos lista de inquilinos disponibles para elegir
     * @param listaViviendas lista de viviendas disponibles para elegir
     * @param alquilerEditar alquiler que se va a editar
     */
    public DlgNewAlquiler(java.awt.Frame parent, boolean modal,
            java.util.ArrayList<modelo.Alquileres> listaAlquileres,
            java.util.ArrayList<modelo.Inquilino> listaInquilinos,
            java.util.ArrayList<modelo.Vivienda> listaViviendas,
            modelo.Alquileres alquilerEditar) {
        this(parent, modal, listaAlquileres, listaInquilinos, listaViviendas);
        this.alquilerEditar = alquilerEditar;
        if (alquilerEditar != null) {
            cargarDatosParaEditar();
        }
    }

    /**
     * Carga en el formulario los datos del alquiler que se va a editar (fecha, montos, cantidades, estado) y selecciona en los combos el inquilino y la vivienda correspondientes.
     */
    private void cargarDatosParaEditar() {
        setTitle("Editar Alquiler");
        btnGuardar.setText("Actualizar");

        java.util.Date fecha = java.util.Date.from(
                alquilerEditar.getFechaContrato().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
        jDateChooser1.setDate(fecha);

        spCantMeses.setValue(alquilerEditar.getCantMeses());
        spNumAdultos.setValue(alquilerEditar.getNumAdultos());
        spNumNinios.setValue(alquilerEditar.getNumNinios());
        txtDeposito.setText(String.valueOf(alquilerEditar.getDepositoGarantia()));
        txtPrecioAlquiler.setText(String.valueOf(alquilerEditar.getPrecioAlquiler()));
        jSpinner1.setValue(alquilerEditar.getPorcIncremAnual());
        cbEstado.setSelectedItem(alquilerEditar.getEstado());

        for (int i = 0; i < listaInquilinos.size(); i++) {
            if (Integer.parseInt(listaInquilinos.get(i).getCedInqui()) == alquilerEditar.getCedInquilino()) {
                cbInquilino.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < listaViviendas.size(); i++) {
            if (listaViviendas.get(i).getIdVivienda() == alquilerEditar.getIdVivienda()) {
                cbVivienda.setSelectedIndex(i);
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFechaContrato = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNumAdult = new javax.swing.JLabel();
        lblNumNinios = new javax.swing.JLabel();
        lblDepósito = new javax.swing.JLabel();
        lblPrecioAlquiler = new javax.swing.JLabel();
        lblIncremAnual = new javax.swing.JLabel();
        lblInquilino = new javax.swing.JLabel();
        lblVivienda = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        spCantMeses = new javax.swing.JSpinner();
        spNumAdultos = new javax.swing.JSpinner();
        spNumNinios = new javax.swing.JSpinner();
        txtDeposito = new javax.swing.JTextField();
        txtPrecioAlquiler = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        cbInquilino = new javax.swing.JComboBox<>();
        cbVivienda = new javax.swing.JComboBox<>();
        cbEstado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Alquileres");

        lblFechaContrato.setText("Fecha Contracto");

        jLabel1.setText("Cant. Meses");

        lblNumAdult.setText("Núm. Adultos");

        lblNumNinios.setText("Núm. Niños");

        lblDepósito.setText("Depósito");

        lblPrecioAlquiler.setText("Precio Alquiler");

        lblIncremAnual.setText("% Increm. Anual");

        lblInquilino.setText("Inquilino");

        lblVivienda.setText("Vivienda");

        lblEstado.setText("Estado");

        spCantMeses.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spNumAdultos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 40, 1));

        spNumNinios.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        cbInquilino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbVivienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vigente", "Vencido", "Cancelado" }));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaContrato)
                                    .addComponent(lblDepósito, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumNinios, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumAdult, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(lblPrecioAlquiler, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spCantMeses)
                                .addComponent(spNumAdultos)
                                .addComponent(spNumNinios)
                                .addComponent(txtDeposito)
                                .addComponent(txtPrecioAlquiler)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblIncremAnual)
                                .addComponent(lblVivienda, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblInquilino, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSpinner1)
                                .addComponent(cbInquilino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbVivienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaContrato)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spCantMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumAdult)
                    .addComponent(spNumAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spNumNinios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumNinios))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepósito))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioAlquiler))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncremAnual)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInquilino))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVivienda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Valida y guarda los datos del formulario. Si el diálogo está en modo "nuevo", crea un objeto modelo.Alquileres y lo agrega a la lista. Si está en modo "editar", actualiza el objeto que ya existe en la lista con los datos nuevos.
     *
     * @param evt evento de clic sobre el botón Guardar/Actualizar
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (jDateChooser1.getDate() == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione la fecha del contrato.");
                return;
            }

            double deposito = Double.parseDouble(txtDeposito.getText().trim());
            double precio = Double.parseDouble(txtPrecioAlquiler.getText().trim());

            java.time.LocalDate fecha = jDateChooser1.getDate().toInstant()
                    .atZone(java.time.ZoneId.systemDefault()).toLocalDate();

            int indexInquilino = cbInquilino.getSelectedIndex();
            int indexVivienda = cbVivienda.getSelectedIndex();

            if (indexInquilino == -1 || indexVivienda == -1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un inquilino y una vivienda.");
                return;
            }

            modelo.Inquilino inquilinoSel = listaInquilinos.get(indexInquilino);
            modelo.Vivienda viviendaSel = listaViviendas.get(indexVivienda);

            if (alquilerEditar == null) {
                // Modo "nuevo"
                modelo.Alquileres nuevo = new modelo.Alquileres(
                        fecha,
                        (int) spCantMeses.getValue(),
                        (int) spNumAdultos.getValue(),
                        (int) spNumNinios.getValue(),
                        deposito,
                        precio,
                        (int) jSpinner1.getValue(),
                        Integer.parseInt(inquilinoSel.getCedInqui()),
                        viviendaSel.getIdVivienda(),
                        (String) cbEstado.getSelectedItem()
                );
                listaAlquileres.add(nuevo);
            } else {
                // Modo "editar": actualizar el objeto existente
                alquilerEditar.setFechaContrato(fecha);
                alquilerEditar.setCantMeses(((Number) spCantMeses.getValue()).intValue());
                alquilerEditar.setNumAdultos(((Number) spNumAdultos.getValue()).intValue());
                alquilerEditar.setNumNinios(((Number) spNumNinios.getValue()).intValue());
                alquilerEditar.setDepositoGarantia(deposito);
                alquilerEditar.setPrecioAlquiler(precio);
                alquilerEditar.setPorcIncremAnual(((Number) jSpinner1.getValue()).doubleValue());
                alquilerEditar.setCedInquilino(Integer.parseInt(inquilinoSel.getCedInqui()));
                alquilerEditar.setIdVivienda(viviendaSel.getIdVivienda());
                alquilerEditar.setEstado((String) cbEstado.getSelectedItem());
            }

            guardado = true;
            dispose();

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Depósito y Precio deben ser números válidos.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Cierra el diálogo sin guardar ningún cambio.
     *
     * @param evt evento de clic sobre el botón Cancelar
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Indica si el usuario guardó los datos antes de cerrar el diálogo.
     *
     * @return true si se guardó (nuevo o editado), false si se canceló
     */
    public boolean isGuardado() {
        return guardado;
    }

    /**
     * Método de prueba para abrir este diálogo de forma independiente, sin pasar por el menú principal del sistema.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DlgNewAlquiler dialog = new DlgNewAlquiler(new javax.swing.JFrame(), true,
                        new java.util.ArrayList<>(), new java.util.ArrayList<>(), new java.util.ArrayList<>());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbInquilino;
    private javax.swing.JComboBox<String> cbVivienda;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblDepósito;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaContrato;
    private javax.swing.JLabel lblIncremAnual;
    private javax.swing.JLabel lblInquilino;
    private javax.swing.JLabel lblNumAdult;
    private javax.swing.JLabel lblNumNinios;
    private javax.swing.JLabel lblPrecioAlquiler;
    private javax.swing.JLabel lblVivienda;
    private javax.swing.JSpinner spCantMeses;
    private javax.swing.JSpinner spNumAdultos;
    private javax.swing.JSpinner spNumNinios;
    private javax.swing.JTextField txtDeposito;
    private javax.swing.JTextField txtPrecioAlquiler;
    // End of variables declaration//GEN-END:variables
}
