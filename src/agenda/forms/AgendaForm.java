package agenda.forms;

import agenda.*;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import utilidad.Utility;

public class AgendaForm extends javax.swing.JFrame
{
    // IDENTIFICADOR
    private final static String MENU = "Menu";
    private final static String UPDATE = "Update";
    
    private static Agenda agenda;
    
    private MenuPanel menu;
    private UpdatePanel update;
    
    public AgendaForm()
    {
        agenda = InitializeAgenda();
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
        setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 490, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AgendaForm().setVisible(true);
            }
        });
    }
    
    private Agenda InitializeAgenda()
    {
        String filepath = "Archivos\\Contactos.txt";
        File file = new File(filepath);
        
        try 
        {
            if(file.createNewFile() || IsEmptyFile(file))
            {
                return DefaultAgenda();
            }
            return new Agenda(file);
        } catch (IOException ex)
        {
            Logger.getLogger(AgendaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Agenda();
    }
    
    private Boolean IsEmptyFile(File file) throws FileNotFoundException 
    {
        String[] text = Utility.fileToArray(file.getPath());
        
        return text[0].equals("");
    }
    
    private Agenda DefaultAgenda() throws IOException 
    {
        Agenda agenda = new Agenda();
        
        agenda.CrearContacto(
                "43970914C", "Rodrigo", "Fernandez", "Perez", 
                new Date(5, 11, 1999), new String[] {"922807250","","","",""}, new String[] {"672679054","","","",""}, 
                "rodrigofernandez@gmail.com", "Calle San Agustin");
        agenda.CrearContacto(
                "62709029N", "Manuel", "de la Casa", "Castillo", 
                new Date(10, 4, 1989), new String[] {"922609125","","","",""}, new String[] {"610905834","","","",""}, 
                "manuelcasas@gmail.com", "Calle Puerta Vieja");
        agenda.CrearContacto(
                "47083903M", "Alvaro", "Reyes", "Delgado", 
                new Date(24, 9, 2002), new String[] {"822409103","822609251","","",""}, new String[] {"649104732","","","",""}, 
                "alvaroreyes@gmail.com", "Calle San Lazaro");
        
        return agenda;
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
    public static Agenda getAgenda() { return agenda; }
}
