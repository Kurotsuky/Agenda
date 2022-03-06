package view;

import controller.AgendaController;
import models.SaveAgendaSystem;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class AgendaForm extends javax.swing.JFrame
{
    // IDENTIFICADOR
    private final static String MENU = "Menu";
    private final static String UPDATE = "Update";
    
    private static AgendaController agendaController;
    private static SaveAgendaSystem saveSystem;
    
    private MenuPanel menu;
    private UpdatePanel update;
    
    public AgendaForm()
    {
        this(new AgendaController());
    }
    
    public AgendaForm(AgendaController agendaController)
    {
        this(agendaController, new SaveAgendaSystem());
    }
    
    public AgendaForm(AgendaController agendaController, SaveAgendaSystem saveSystem)
    {
        AgendaForm.agendaController = agendaController;
        AgendaForm.saveSystem = saveSystem;
        menu = new MenuPanel(this);
        update = new UpdatePanel(this);
        
        initComponents();
        panelContent.add(menu, MENU);
        panelContent.add(update, UPDATE);
        showPanel(MENU);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");
        setMinimumSize(new java.awt.Dimension(410, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 490, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {
        String filePath = "archivos\\Contactos.txt";
        saveSystem = new SaveAgendaSystem(filePath);
        agendaController = new AgendaController(saveSystem.load());
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new AgendaForm(agendaController, saveSystem).setVisible(true);
            }
        });
    }
    
    public void showPanel(String id) 
    {
        CardLayout layout = (CardLayout)(panelContent.getLayout());
        layout.show(panelContent, id);
        
        this.setPreferredSize(panelContent.getPreferredSize());
        this.pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelContent;
    // End of variables declaration//GEN-END:variables

    public static String getMENU() { return MENU; }
    public static String getUPDATE() { return UPDATE; }
    public JPanel getPanelContent() { return panelContent; }
    public static AgendaController getAgendaController() { return agendaController; }
    public static SaveAgendaSystem getSaveSystem() { return saveSystem; }
}
