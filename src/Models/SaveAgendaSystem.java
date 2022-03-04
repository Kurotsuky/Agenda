package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidad.Utility;

public class SaveAgendaSystem {
    private final String FILEPATH;
    
    private File file;
    
    
    public SaveAgendaSystem() {
        this("save.txt");
    }
    
    public SaveAgendaSystem(String filePath) {
        FILEPATH = filePath;
        file = new File(FILEPATH);
    }
    
    
    public Agenda load() {
        
        if(IsEmptyFile(file))
        {
            return DefaultAgenda();
        }
        
        return fillAgendaByFile();
    }
    
    private static Boolean IsEmptyFile(File file)
    {
        String[] text = {};
        try {
            if(!file.exists()) { return true; }
            text = Utility.fileToArray(file.getPath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveAgendaSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return text[0].equals("");
    }
    
    private static Agenda DefaultAgenda()
    {
        Agenda agenda = new Agenda();
        
        agenda.addContacto(new Contacto("43970914C", 
                "Rodrigo", "Fernandez", "Perez", new Date(5, 11, 1999), 
                new String[] {"922807250","","","",""}, 
                new String[] {"672679054","","","",""}, 
                "rodrigofernandez@gmail.com", "Calle San Agustin"));
        agenda.addContacto(new Contacto("62709029N", 
                "Manuel", "de la Casa", "Castillo", new Date(10, 4, 1989), 
                new String[] {"922609125","","","",""}, 
                new String[] {"610905834","","","",""}, 
                "manuelcasas@gmail.com", "Calle Puerta Vieja"));
        agenda.addContacto(new Contacto("47083903M", 
                "Alvaro", "Reyes", "Delgado", new Date(24, 9, 2002), 
                new String[] {"822409103","822609251","","",""}, 
                new String[] {"649104732","","","",""}, 
                "alvaroreyes@gmail.com", "Calle San Lazaro"));
        
        return agenda;
    }
    
    private Agenda fillAgendaByFile()
    {
        Agenda agenda = new Agenda();
        String[] infoFile = Utility.GetFileText(file, ",");
        
        for(int i = 0; i < infoFile.length; i+=17) 
        {
            int id = agenda.getContactos().size();
            String dni = infoFile[i];
            String nombre = infoFile[i+1];
            String apellido1 = infoFile[i+2];
            String apellido2 = infoFile[i+3];
            Date fechaNacimiento = new Date(Utility.GetStringText(infoFile[i+4], "-"));
            String[] telefono = new String[] { 
                infoFile[i+5], infoFile[i+6], infoFile[i+7], infoFile[i+8], infoFile[i+9] };
            String[] movil = new String[] { 
                infoFile[i+10], infoFile[i+11], infoFile[i+12], infoFile[i+13], infoFile[i+14] };
            String email = infoFile[i+15];
            String direccion = infoFile[i+16];
            
            agenda.addContacto(new Contacto(dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, movil, email, direccion));
        }
        return agenda;
    }
    
    public void save(Agenda agenda)
    {
        createDirectories();
        
        FileWriter fw = null;
        try {
            if(!file.exists()) { file.createNewFile(); }
            fw = new FileWriter(file);
            fw.write(agenda.toString());
        } 
        catch (IOException e) {
            Logger.getLogger(SaveAgendaSystem.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {
            try { fw.close(); } 
            catch (IOException e) {
                Logger.getLogger(SaveAgendaSystem.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    private void createDirectories() {
        String separator = System.getProperty("file.separator");
        String[] directories = file.getPath().split(separator + separator);
        
        for (int i = 0; i < directories.length - 1; i++) {
            String directory = directories[i];
            
            new File(directory).mkdir();
        }
    }
}