/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelo.Propietario;

/**
 *Diálogo para agregar o editar un propietario. Valida los datos
 * ingresados, verifica que la cédula no esté duplicada al agregar,
 * y aplica una máscara al campo de teléfono.
 * 
 * @author graci
 */
public class DlgNewPropietario extends javax.swing.JDialog {

    /**
     * Lista de propietarios donde se agrega o actualiza el registro.
     */
    private ArrayList<Propietario> listaProp;
    
    /**
     * Indica la operación a realizar: 1 = Agregar, 2 = Editar.
     */
    private int operacion; //1=Agregar, 2= Editar
    
    /**
     * Posición en la lista del propietario que se está editando.
     */
    private int index;
    
    /**
     * Propietario que se está editando (solo se usa en el modo Editar).
     */
    private Propietario prop;
    
    public DlgNewPropietario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarMascaraTelefono();
    }
    
    /**
     * Crea el diálogo en modo Agregar.
     *
     * @param parent ventana padre
     * @param modal si el diálogo es modal
     * @param listaProp lista donde se agregará el nuevo propietario
     * @param operacion 1 para agregar
     */
    public DlgNewPropietario(java.awt.Frame parent, boolean modal, ArrayList<Propietario> listaProp, int operacion) {
        super(parent, modal);
        initComponents();
        configurarMascaraTelefono();
        this.listaProp = listaProp;
        this.operacion = operacion;
    }
    
    /**
     * Crea el diálogo en modo Editar, con los campos ya llenos.
     *
     * @param parent ventana padre
     * @param modal si el diálogo es modal
     * @param listaProp lista donde se actualizará el propietario
     * @param operacion 2 para editar
     * @param prop propietario a editar
     * @param index posición del propietario en la lista
     */
    public DlgNewPropietario(java.awt.Frame parent, boolean modal, ArrayList<Propietario> listaProp, int operacion, Propietario prop, int index) {
        super(parent, modal);
        initComponents();
        configurarMascaraTelefono();
        this.listaProp = listaProp;
        this.operacion = operacion;
        this.index = index;
        this.prop = prop;
    }
    
    /**
     * Obtiene la lista de propietarios, ya actualizada tras guardar.
     *
     * @return la lista de propietarios
     */
    public ArrayList<Propietario> getListaProp(){
        return listaProp;
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
     * Valida los campos del formulario y construye el propietario a
     * guardar. En modo Agregar, verifica además que no exista ya un
     * propietario con la misma cédula. Muestra un mensaje si hay campos
     * vacíos o la cédula está duplicada.
     *
     * @return el propietario construido, o null si la validación falla
     */
    private Propietario getPropietario(){
        Propietario p = new Propietario();
         if (!txtCedula.getText().isEmpty()
            && !txtNombre.getText().isEmpty()
            && cmbGenero.getSelectedIndex() != -1
            && !frmTelefono.getText().contains("_")
            && !txtDireccion.getText().isEmpty()
            && !txtEmail.getText().isEmpty()) {

        try {
            String cedulaIngresada = txtCedula.getText();

            // Validar cédula duplicada solo al agregar
            if (operacion == 1) {
                for (Propietario existente : listaProp) {
                    if (existente.getCedPropiet().equals(cedulaIngresada)) {
                        JOptionPane.showMessageDialog(this,
                                "Ya existe un propietario con esa cédula");
                        return null;
                    }
                }
            }

            p.setCedPropiet(cedulaIngresada);
            p.setNomPropiet(txtNombre.getText());
            p.setGenero(cmbGenero.getSelectedItem().toString());
            p.setTelefono(frmTelefono.getText());
            p.setDireccion(txtDireccion.getText());
            p.setEmail(txtEmail.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cédula debe ser numérica");
            return null;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Hay campos vacíos");
        return null;
    }
    return p;
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
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Propietarios");

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
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCedula))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(frmTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(frmTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Guarda el propietario del formulario. Si la operación es agregar, lo
     * añade a la lista, si es editar, reemplaza el propietario en su
     * posición original.
     *
     * @param evt evento de clic sobre el botón Guardar
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Propietario p = getPropietario();
        if (p !=null){
            if (operacion == 1){ //Se agrega un nuevo propietario
                if(listaProp.add(p)){
                    JOptionPane.showMessageDialog(this, "Propietario guardado");
                    this.dispose();
                } else { //Se edita un propietario existente
                   listaProp.set(index, p);
                   JOptionPane.showMessageDialog(this, "Error al guardar");
                   
                }
            } else {
                listaProp.set(index, p);
                JOptionPane.showMessageDialog(this, "Propietario editado");
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
            java.util.logging.Logger.getLogger(DlgNewPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgNewPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgNewPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgNewPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgNewPropietario dialog = new DlgNewPropietario(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField frmTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
