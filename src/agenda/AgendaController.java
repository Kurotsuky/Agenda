package agenda;

import utilidad.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import utilidad.Utility;

public class AgendaController 
{
    private static Agenda agenda;
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        new File("Archivos").mkdir();
        agenda = InitializeAgenda();
        int optionSelected;
        
        do 
        {
            optionSelected = new Menu("Crear Contacto \nBorrar Contacto \nModificar Contacto \nInsertar Contacto \nBuscar Contacto \nSalir").AskOption();
            SelectFunction(optionSelected);
            
        } while(optionSelected != 6);
    }
    
    private static Agenda InitializeAgenda() throws IOException 
    {
        String filepath = "Archivos\\Contactos.txt";
        File file = new File(filepath);
        
        if(file.createNewFile() || IsEmptyFile(file)) 
        {
            return DefaultAgenda();
        }
        return new Agenda(file);
    }
    
    private static Boolean IsEmptyFile(File file) throws FileNotFoundException 
    {
        String[] text = Utility.fileToArray(file.getPath());
        
        return text[0].equals("");
    }
    
    private static Agenda DefaultAgenda() throws IOException 
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
    
    private static void SelectFunction(int selected) throws IOException 
    {
        switch(selected) 
        {
            case 1:
                agenda.CrearContacto();
                break;
            case 2:
                agenda.BorrarContacto();
                break;
            case 3:
                agenda.ModificarContacto();
                break;
            case 4:
                agenda.InsertarContacto();
                break;
            case 5:
                agenda.BuscarContacto();
                break;
        }
    }

    public static Agenda GetAgenda(){ return agenda; }
}
