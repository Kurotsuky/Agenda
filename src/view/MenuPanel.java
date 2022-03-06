package view;

import controller.AgendaController;
import models.ContactSearcher;
import models.ContactFilter;
import models.Contacto;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

public class MenuPanel extends javax.swing.JPanel 
{
    private AgendaForm agendaForm;
    
    private List<Contacto> contactos;
    
    public MenuPanel() 
    {
        this(new AgendaForm());
    }
    
    public MenuPanel(AgendaForm agendaForm) 
    {
        this.agendaForm = agendaForm;
        
        initComponents();
        updateList();
        updateSelector();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listContactos = new javax.swing.JList<>();
        cbxSearchFilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtSearchValue = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(450, 360));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        btnCreate.setText("Crear Contacto");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRemove.setText("Eliminar Contacto");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnModify.setText("Modificar Contacto");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        listContactos.setMinimumSize(new java.awt.Dimension(258, 235));
        listContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listContactosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listContactos);

        cbxSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Buscar por:");

        txtSearchValue.setToolTipText("");
        txtSearchValue.setName(""); // NOI18N
        txtSearchValue.setPreferredSize(new java.awt.Dimension(171, 20));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setText("Resetear");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearchValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(btnSearch)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnModify)
                    .addComponent(btnRemove))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSearchActionPerformed
    {//GEN-HEADEREND:event_btnSearchActionPerformed
        String text = txtSearchValue.getText();
        
        if(text.equals("")) 
        {
            btnResetActionPerformed(evt);
            return;
        }
        
        ContactSearcher searcher = new ContactSearcher();
        ContactFilter filter = ContactFilter.values()[cbxSearchFilter.getSelectedIndex()];
        
        List<Contacto> matches = searcher.searchContact(text, filter, AgendaForm.getAgendaController().getAgenda().getContactos());
        updateList(matches);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearText();
        updateList();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        Contacto contacto =  contactos.get(listContactos.getSelectedIndex());
        
        AgendaController agendaController = AgendaForm.getAgendaController();
        agendaController.borrarContacto(contacto);
        updateList();
        AgendaForm.getSaveSystem().save();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCreateActionPerformed
    {//GEN-HEADEREND:event_btnCreateActionPerformed
        goModifyMenu(null);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnModifyActionPerformed
    {//GEN-HEADEREND:event_btnModifyActionPerformed
        Contacto contacto = contactos.get(listContactos.getSelectedIndex());
        goModifyMenu(contacto);
    }//GEN-LAST:event_btnModifyActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        updateList();
        updateSelector();
    }//GEN-LAST:event_formComponentShown

    private void listContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listContactosMouseClicked
        if(evt.getClickCount() == 2) 
        {
            Contacto contacto = contactos.get(listContactos.getSelectedIndex());
            goModifyMenu(contacto);
        }
    }//GEN-LAST:event_listContactosMouseClicked

    private void goModifyMenu(Contacto contacto) 
    {
        JPanel contentPanel = agendaForm.getPanelContent();
        
        for(int i = 0; i < contentPanel.getComponents().length; i++) 
        {
            Component component = contentPanel.getComponent(i);
            
            if(component instanceof UpdatePanel) 
            {
                ((UpdatePanel) component).setContacto(contacto);
            }
        }
        clearText();
        agendaForm.showPanel(AgendaForm.getUPDATE());
    }
    
    private void updateList() 
    {
        DefaultListModel data = new DefaultListModel();
        
        contactos = AgendaForm.getAgendaController().getAgenda().getContactos();
        
        for (Contacto contacto : contactos) 
        {
            data.addElement(contacto.toStringSimple());
        }
        
        listContactos.setModel(data);
    }
    
    private void updateList(List<Contacto> contactos) 
    {
        DefaultListModel data = new DefaultListModel();
        
        contactos = contactos;
        
        for (Contacto contacto : contactos) 
        {
            data.addElement(contacto.toStringSimple());
        }
        
        listContactos.setModel(data);
    }
    
    private void updateSelector() 
    {
        DefaultComboBoxModel models  = new DefaultComboBoxModel();
        
        ContactFilter[] filters = ContactFilter.values();
        
        for (int i = 0; i < filters.length; i++) 
        {
            models.addElement(filters[i].getName());
        }
        
        cbxSearchFilter.setModel(models);
    }
    
    private void clearText() 
    {
        txtSearchValue.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbxSearchFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listContactos;
    private javax.swing.JTextField txtSearchValue;
    // End of variables declaration//GEN-END:variables

}
