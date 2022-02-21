package Agenda;
import java.util.ArrayList;
import Utilidad.Utility;
import Utilidad.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Agenda 
{
    private ArrayList<Contacto> agenda;
    private File file;
    
    
    public Agenda() 
    {
        agenda = new ArrayList<>();
        file = new File("Archivos\\Contactos.txt");
    }
    
    public Agenda(File file) throws FileNotFoundException 
    {
        agenda = FillAgendaByFile(file);
        this.file = file;
    }
    
    
    public void CrearContacto() throws IOException 
    {
        int id = agenda.size();
        String dni = Utility.AskString("DNI: ");
        String nombre = Utility.AskString("Nombre: ");
        String apellido1 = Utility.AskString("Primer Apellido: ");
        String apellido2 = Utility.AskString("Segundo Apellido: ");
        Date fechaNacimiento = new Date(Utility.AskDate(new String[] { "Fecha de Nacimiento: \n  Dia: ", "  Mes: ", "  Año: " }));
        String[] telefono = Utility.AskStringArray("Telefono", 5);
        String[] movil = Utility.AskStringArray("Movil", 5);
        String email = Utility.AskString("Email: ");
        String direccion = Utility.AskString("Dirección: ");
        
        agenda.add(new Contacto(id, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, movil, email, direccion));
        Save();
    }
    
    public void CrearContacto(
            String dni,
            String nombre,
            String apellido1,
            String apellido2,
            Date fechaNacimiento,
            String[] telefono,
            String[] movil,
            String email,
            String direccion) throws IOException 
    {
        int id = agenda.size();
        
        agenda.add(new Contacto(id, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, movil, email, direccion));
        Save();
    }
    
    public void BorrarContacto() throws IOException 
    {
        Contacto searched = SearchContact();
        agenda.remove(searched);
        Save();
    }
    
    public void ModificarContacto() throws IOException 
    {
        Contacto searched = SearchContact();
        System.out.println("Seleccione el campo que quiere modificar: ");
        int optionSelected = new Menu("Nombre \nApellido1 \nApellido2 \nTelefono \nMovil \nDNI \nFecha de Nacimiento \nEmail \nDirección").AskOption();
        
        switch(optionSelected) 
        {
            case 1:
                searched.SetNombre(Utility.AskString("-> "));
                break;
            case 2:
                searched.SetApellido1(Utility.AskString("-> "));
                break;
            case 3:
                searched.SetApellido2(Utility.AskString("-> "));
                break;
            case 4:
                searched.SetTelefono(Utility.AskString("-> "));
                break;
            case 5:
                searched.SetMovil(Utility.AskString("-> "));
                break;
            case 6:
                searched.SetDNI(Utility.AskString("-> "));
                break;
            case 7:
                searched.SetFechaNacimiento(Utility.AskInt("Dia: "), Utility.AskInt("Mes: "), Utility.AskInt("Año: "));
                break;
            case 8:
                searched.SetNombre(Utility.AskString("-> "));
                break;
            case 9:
                searched.SetNombre(Utility.AskString("-> "));
                break;
        }
        Save();
    }
    
    public void InsertarContacto() throws IOException 
    {
        Save();
    }
    
    public void BuscarContacto() 
    {
        Contacto searched = SearchContact();
        
        if(searched == null) 
        { 
            System.out.println("Contacto no encontrado.");
            return; 
        }
        System.out.println("\n" + searched.toString());
    } 
    
    private Contacto SearchContact() 
    {
        ContactSearcher searcher = new ContactSearcher();
        Contacto searched = null;
        String searchText = "";
        
        System.out.println("Buscar por: ");
        int optionSelected = new Menu("Nombre \nNombre y Apellidos \nTelefono \nMovil \nDNI").AskOption();
        
        switch(optionSelected) 
        {
            case 1:
                searchText = Utility.AskString("Nombre: ");
                searched = searcher.SearchContact(searchText, ContactSearcher.Filter.Nombre, agenda);
                break;
            case 2:
                searchText += Utility.AskString("Nombre: ") + " \n";
                searchText += Utility.AskString("Apellido1: ") + " \n";
                searchText += Utility.AskString("Appelido2: ");
                searched = searcher.SearchContact(searchText, ContactSearcher.Filter.NombreYApellidos, agenda);
                break;
            case 3:
                searchText = Utility.AskString("Telefono: ");
                searched = searcher.SearchContact(searchText, ContactSearcher.Filter.Telefono, agenda);
                break;
            case 4:
                searchText = Utility.AskString("Movil: ");
                searched = searcher.SearchContact(searchText, ContactSearcher.Filter.Movil, agenda);
                break;
            case 5:
                searchText = Utility.AskString("DNI: ");
                searchText = searchText.toUpperCase();
                searched = searcher.SearchContact(searchText, ContactSearcher.Filter.DNI, agenda);
                break;
        }
        return searched;
    }
    
    private ArrayList<Contacto> FillAgendaByFile(File file) throws FileNotFoundException 
    {
        ArrayList<Contacto> agenda = new ArrayList<Contacto>();
        String[] infoFile = Utility.GetFileText(file, ",");
        
        for(int i = 0; i < infoFile.length; i+=17) 
        {
            int id = agenda.size();
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
            
            agenda.add(new Contacto(id, dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, movil, email, direccion));
        }
        return agenda;
    }
    
    private void Save() throws IOException 
    {
        FileWriter fw = new FileWriter(file);
        fw.write(toString());
        fw.close();
    }
    
    @Override
    public String toString() 
    {
        String string = "";
        for (Contacto contacto : agenda) 
        {
            String[] contactoData = {
                contacto.GetDNI(),
                contacto.GetNombre(),
                contacto.GetApellido1(),
                contacto.GetApellido2(),
                contacto.GetFechaNacimiento(),
                contacto.GetTelefonos()[0],
                contacto.GetTelefonos()[1],
                contacto.GetTelefonos()[2],
                contacto.GetTelefonos()[3],
                contacto.GetTelefonos()[4],
                contacto.GetMoviles()[0],
                contacto.GetMoviles()[1],
                contacto.GetMoviles()[2],
                contacto.GetMoviles()[3],
                contacto.GetMoviles()[4],
                contacto.GetEmail(),
                contacto.GetDireccion()
            };
            
            for(int i = 0; i < contactoData.length; i++) 
            {
                string += contactoData[i];
                string += ",";
            }
            string += "\n";
        }
        return string;
    }
}
