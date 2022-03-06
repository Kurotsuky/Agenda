package view;

import models.Agenda;
import models.Contacto;

public class UpdatePanel extends javax.swing.JPanel
{
    AgendaForm agendaForm;
    Contacto contacto;
    String[] moviles;
    String[] telefonos;
    
    public UpdatePanel()
    {
        this(new AgendaForm());
    }
    
    public UpdatePanel(AgendaForm agendaForm)
    {
        this.agendaForm = agendaForm;
        moviles = new String[5];
        telefonos = new String[5];
        initComponents();
        updateTextFields();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSurname1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        cbxMovil = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        cbxTelefono = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtSurname2 = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDirection = new javax.swing.JTextField();
        txtMonth = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(450, 360));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido 1:");

        txtName.setToolTipText("Nombre del contacto");

        jLabel3.setText("Apellido 2:");

        jLabel4.setText("DNI:");

        jLabel5.setText("Fecha de Nacimiento:");

        jLabel6.setText("Email:");

        jLabel7.setText("Dirección:");

        jLabel8.setText("Movil:");

        cbxMovil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbxMovil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMovilItemStateChanged(evt);
            }
        });

        jLabel9.setText("Teléfono:");

        cbxTelefono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbxTelefono.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTelefonoItemStateChanged(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setText("Atrás");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel10.setText("/");

        jLabel11.setText("/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSurname2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSurname1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel10)
                                    .addGap(2, 2, 2)
                                    .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel11)
                                    .addGap(2, 2, 2)
                                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtDirection, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btnBack)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtMovil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbxMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSurname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSurname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSave))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtName.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        agendaForm.showPanel(AgendaForm.getMENU());
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveActionPerformed
    {//GEN-HEADEREND:event_btnSaveActionPerformed
        Agenda agenda = AgendaForm.getAgendaController().getAgenda();
        if(contacto == null) 
        {
            contacto = new Contacto();
            agenda.addContacto(contacto);
        }
        
        String name = txtName.getText();
        String apellido1 = txtSurname1.getText();
        String apellido2 = txtSurname2.getText();
        String dni = txtDNI.getText();
        String day = txtDay.getText();
        String month = txtMonth.getText();
        String year = txtYear.getText();
        String email = txtEmail.getText();
        String direction = txtDirection.getText();
        moviles[cbxMovil.getSelectedIndex()] = txtMovil.getText();
        telefonos[cbxTelefono.getSelectedIndex()] = txtTelefono.getText();
        
        contacto.setNombre(name);
        contacto.setApellido1(apellido1);
        contacto.setApellido2(apellido2);
        contacto.setDNI(dni);
        contacto.setFechaNacimiento(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        contacto.setEmail(email);
        contacto.setDireccion(direction);
        contacto.setMovil(moviles);
        contacto.setTelefono(telefonos);
        
        AgendaForm.getSaveSystem().save();
        agendaForm.showPanel(AgendaForm.getMENU());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxMovilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMovilItemStateChanged
        int currentIndex = cbxMovil.getSelectedIndex();
        int previousIndex = Integer.parseInt(evt.getItem().toString()) - 1;
        
        moviles[previousIndex] = txtMovil.getText();
        txtMovil.setText(moviles[currentIndex]);
    }//GEN-LAST:event_cbxMovilItemStateChanged

    private void cbxTelefonoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTelefonoItemStateChanged
        int currentIndex = cbxTelefono.getSelectedIndex();
        int previousIndex = Integer.parseInt(evt.getItem().toString()) - 1;
        
        telefonos[previousIndex] = txtTelefono.getText();
        txtTelefono.setText(telefonos[currentIndex]);
    }//GEN-LAST:event_cbxTelefonoItemStateChanged

    private void updateTextFields() 
    {
        String name = "";
        String apellido1 = "";
        String apellido2 = "";
        String dni = "";
        String day = "";
        String month = "";
        String year = "";
        String email = "";
        String direction = "";
        String movil = "";
        String telefono = "";
        
        if(contacto != null) 
        {
            name = contacto.getNombre();
            apellido1 = contacto.getApellido1();
            apellido2 = contacto.getApellido2();
            dni = contacto.getDNI();
            day = contacto.getFechaNacimiento().getDay().toString();
            month = contacto.getFechaNacimiento().getMonth().toString();
            year = contacto.getFechaNacimiento().getYear().toString();
            email = contacto.getEmail();
            direction = contacto.getDireccion();
            movil = contacto.getMoviles()[0];
            telefono = contacto.getTelefonos()[0];
        }
        
        txtName.setText(name);
        txtSurname1.setText(apellido1);
        txtSurname2.setText(apellido2);
        txtDNI.setText(dni);
        txtDay.setText(day);
        txtMonth.setText(month);
        txtYear.setText(year);
        txtEmail.setText(email);
        txtDirection.setText(direction);
        txtMovil.setText(movil);
        txtTelefono.setText(telefono);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxMovil;
    private javax.swing.JComboBox<String> cbxTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtDirection;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname1;
    private javax.swing.JTextField txtSurname2;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables

    public Contacto getContacto()
    {
        return contacto;
    }

    public void setContacto(Contacto contacto)
    {
        this.contacto = contacto;
        
        if(contacto != null) {
            moviles = contacto.getMoviles();
            telefonos = contacto.getTelefonos();
        }
        
        updateTextFields();
    }
}
