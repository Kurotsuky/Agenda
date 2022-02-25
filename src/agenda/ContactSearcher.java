package agenda;

import utilidad.Menu;
import utilidad.Utility;
import java.util.ArrayList;

public class ContactSearcher 
{
    public ArrayList<Contacto> SearchContact(String text, ContactFilter filter, ArrayList<Contacto> contactos) 
    {
        switch(filter) 
        {
            case Nombre:
                return SearchByName(text, contactos);
            case NombreYApellidos:
                return SearchByNameAndSurname(text, contactos);
            case Telefono:
                return SearchByTelefono(text, contactos);
            case Movil:
                return SearchByMovil(text, contactos);
            case DNI:
                return SearchByDNI(text, contactos);
        }
        return null;
    }
    
    private ArrayList<Contacto> SearchByName(String name, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<Contacto>();
        int nameSize = name.length();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            
            if(current.GetNombre().length() < nameSize) { continue; }
            
            String matchString = current.GetNombre().substring(0, nameSize);
            
            if(matchString.equals(name)) 
            {
                matches.add(current);
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> SearchByNameAndSurname(String nameAndSurnames, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<Contacto>();
        String[] _nameAndSurnames = Utility.GetArrayOfString(nameAndSurnames);
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Boolean match = false;
            Contacto current = contactos.get(i);
            String[] currentNameAndSurnames = { 
                current.GetNombre(), current.GetApellido1(), current.GetApellido2() };
            
            for(int j = 0; j < _nameAndSurnames.length; j++) 
            {
                if(_nameAndSurnames[j] == null) { continue; }
                
                if(_nameAndSurnames[j].equals(currentNameAndSurnames[j])) 
                {
                    match = true;
                    continue;
                }
                match = false;
            }
            
            if(match) 
            {
                matches.add(current);
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> SearchByTelefono(String telefono, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<Contacto>();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            String[] telefonos = current.GetTelefonos();
            
            for(int j = 0; j < telefonos.length; j++) 
            {
                if(telefonos[j].equals(telefono)) 
                {
                    matches.add(current);
                    break;
                }
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> SearchByMovil(String movil, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<Contacto>();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            String[] moviles = current.GetMoviles();
            
            for(int j = 0; j < moviles.length; j++) 
            {
                if(moviles[j].equals(movil)) 
                {
                    matches.add(current);
                    break;
                }
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> SearchByDNI(String dni, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<Contacto>();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            if(current.GetDNI().equals(dni)) 
            {
                matches.add(current);
            }
        }
        return matches;
    }
    
    public Contacto SelectContacto(ArrayList<Contacto> contactos) 
    {
        String[] contactosArray = new String[contactos.size()];
        
        for(int i = 0; i < contactosArray.length; i++) 
        {
            contactosArray[i] = contactos.get(i).toString();
        }
        return contactos.get(new Menu(contactosArray).AskOption());
    }
}
