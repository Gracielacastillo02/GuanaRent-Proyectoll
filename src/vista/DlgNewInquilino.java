/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelo.Inquilino;
import java.util.Date;

/**
 * Diálogo para agregar o editar un inquilino. Valida los datos ingresados,
 * verifica que la cédula no esté duplicada al agregar, y aplica una
 * máscara al campo de teléfono.
 * 
 * @author graci
 */
public class DlgNewInquilino extends javax.swing.JDialog {

    /**
     * Lista de inquilinos donde se agrega o actualiza el registro.
     */
    private ArrayList<Inquilino> listaInqui;
    
    /**
     * Indica la operación a realizar: 1 = Agregar, 2 = Editar.
     */
    private int operacion;  // 1 = Agregar, 2 = Editar
    
    /**
     * Posición en la lista del inquilino que se está editando.
     */
    private int index;
    
    /**
     * Inquilino que se está editando (solo se usa en el modo Editar).
     */
    private Inquilino inqui;
    
    public DlgNewInquilino(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarMascaraTelefono();
    }
    
    /**
     * Crea el diálogo en modo Agregar.
     *
     * @param parent ventana padre
     * @param modal si el diálogo es modal
     * @param listaInqui lista donde se agregará el nuevo inquilino
     * @param operacion 1 para agregar
     */
    public DlgNewInquilino(java.awt.Frame parent, boolean modal, ArrayList<Inquilino> listaInqui, int operacion) {
        super(parent, modal);
        initComponents();
        configurarMascaraTelefono();
        this.listaInqui = listaInqui;
        this.operacion = operacion;
    }
    
    /**
     * Crea el diálogo en modo Editar, con los campos ya llenos.
     *
     * @param parent ventana padre
     * @param modal si el diálogo es modal
     * @param listaInqui lista donde se actualizará el inquilino
     * @param operacion 2 para editar
     * @param inqui inquilino a editar
     * @param index posición del inquilino en la lista
     */
    public DlgNewInquilino(java.awt.Frame parent, boolean modal, ArrayList<Inquilino> listaInqui, int operacion, Inquilino inqui, int index) {
        super(parent, modal);
        initComponents();
        configurarMascaraTelefono();
        this.listaInqui = listaInqui;
        this.operacion = operacion;
        this.index = index;
        this.inqui = inqui;
    }
    
    /**
     * Obtiene la lista de inquilinos, ya actualizada tras guardar.
     *
     * @return la lista de inquilinos
     */
    public ArrayList<Inquilino> getListaInqui(){
        return listaInqui;
    }
    
    /**
     * Configura la máscara de formato "####-####" en el campo de teléfono,
     * usando '_' como carácter de relleno mientras el usuario escribe.
     */
    private void configurarMascaraTelefono(){
        try{
            MaskFormatter mask = new MaskFormatter("####-####");
            mask.setPlaceholderCharacter('_');
            frmTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mask));
        } catch (ParseException e){
            System.out.println("Error en la máscara: " + e.getMessage());
        }
    }
    
    /**
     * Valida los campos del formulario y construye el inquilino a guardar.
     * En modo Agregar, verifica además que no exista ya un inquilino con
     * la misma cédula. Muestra un mensaje si hay campos vacíos, la fecha
     * de nacimiento no fue seleccionada, o la cédula está duplicada.
     *
     * @return el inquilino construido, o null si la validación falla
     */
    private Inquilino getInquilino(){
        Inquilino i = new Inquilino();
         if (!txtCedula.getText().isEmpty()
            && !txtNombre.getText().isEmpty()
            && cmbGenero.getSelectedIndex() != -1
            && !frmTelefono.getText().contains("_")
            && !txtDireccion.getText().isEmpty()
            && !txtEmail.getText().isEmpty()) {

        try {
            String cedulaIngresada = txtCedula.getText();

            if (operacion == 1) {
                for (Inquilino existente : listaInqui) {
                    if (existente.getCedInqui().equals(cedulaIngresada)) {
                        JOptionPane.showMessageDialog(this,
                                "Ya existe un inquilino con esa cédula");
                        return null;
                    }
                }
            }

            i.setCedInqui(cedulaIngresada);
            i.setNomInqui(txtNombre.getText());
            i.setGenero(cmbGenero.getSelectedItem().toString());
            if (dtcFechaNac.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar la fecha de nacimiento");
                return null;
            }
            Date fechaSeleccionada = dtcFechaNac.getDate();
            LocalDate fechaConvertida = fechaSeleccionada.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            
            i.setFechNac(fechaConvertida);
            i.setTelefono(frmTelefono.getText());
            i.setDireccion(txtDireccion.getText());
            i.setEmail(txtEmail.getText());
            i.setOcupacion(txtOcupacion.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cédula debe ser numérica");
            return null;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Hay campos vacíos");
        return null;
    }
    return i;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        frmTelefono = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtOcupacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dtcFechaNac = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Inquilinos");

        jLabel1.setText("Cédula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("Email:");

        jLabel5.setText("Género:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre", " " }));

        jLabel6.setText("Teléfono:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel7.setText("Ocupación:");

        jLabel8.setText("Fecha de nacimiento:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel8)))
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(frmTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dtcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(dtcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(frmTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Guarda el inquilino del formulario. Si la operación es agregar, lo
     * añade a la lista, si es editar, reemplaza el inquilino en su
     * posición original.
     *
     * @param evt evento de clic sobre el botón Guardar
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Inquilino i = getInquilino();
        if (i != null) {
            if (operacion == 1) { // Se agrega un nuevo inquilino
                if (listaInqui.add(i)) {
                    JOptionPane.showMessageDialog(this, "Inquilino guardado");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar");
                }
            } else { // Se edita un inquilino existente
                listaInqui.set(index, i);
                JOptionPane.showMessageDialog(this, "Inquilino editado");
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgNewInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgNewInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgNewInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgNewInquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgNewInquilino dialog = new DlgNewInquilino(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmbGenero;
    private com.toedter.calendar.JDateChooser dtcFechaNac;
    private javax.swing.JFormattedTextField frmTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOcupacion;
    // End of variables declaration//GEN-END:variables
}
