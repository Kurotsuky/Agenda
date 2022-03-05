package models;

import utils.Menu;
import java.util.ArrayList;
import utils.Utility;

public class ContactSearcher 
{
    public Contacto searchContactByInput(Agenda agenda) 
    {
        ContactFilter filter = getFilterToUse();
        String searchText = Utility.AskString(filter.getName() + ": ");
        ArrayList<Contacto> searcheds = searchContact(searchText, filter, agenda.getContactos());
        
        return checkMatches(searcheds);
    }
    
    private ContactFilter getFilterToUse() 
    {
        System.out.println("Buscar por: ");
        int optionSelected = new Menu("Nombre \nNombre y Apellidos \nTelefono \nMovil \nDNI").AskOption();
        
        switch(optionSelected) 
        {
            case 1:
                return ContactFilter.Nombre;
            case 2:
                return ContactFilter.NombreYApellidos;
            case 3:
                return ContactFilter.Telefono;
            case 4:
                return ContactFilter.Movil;
            case 5:
                return ContactFilter.DNI;
            default:
                return ContactFilter.Nombre;
        }
    }
    
    private Contacto checkMatches(ArrayList<Contacto> matches) 
    {
        switch(matches.size()) 
        {
            case 0:
                return null;
            case 1:
                return matches.get(0);
            default:
                ContactSearcher searcher = new ContactSearcher();
                return searcher.selectContacto(matches);
        }
    }
    
    public ArrayList<Contacto> searchContact(String key, ContactFilter filter, ArrayList<Contacto> contactos) 
    {
        switch(filter) 
        {
            case Nombre:
                return searchByName(key, contactos);
            case NombreYApellidos:
                return searchByNameAndSurname(key, contactos);
            case Telefono:
                return searchByTelefono(key, contactos);
            case Movil:
                return searchByMovil(key, contactos);
            case DNI:
                return searchByDNI(key, contactos);
            default:
                return searchByName(key, contactos);
        }
    }
    
    private ArrayList<Contacto> searchByName(String name, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<>();
        name = name.toUpperCase().charAt(0) + name.substring(1, name.length());
        int nameSize = name.length();
        
        for(Contacto contacto : contactos)
        {
            if((contacto.getNombre().length() < nameSize)) { continue; }
            
            String matchString = contacto.getNombre().substring(0, nameSize);
            if (matchString.equals(name)) 
            {
                matches.add(contacto);
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> searchByNameAndSurname(String nameAndSurnames, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches;
        String[] arrayNameAndSurnames = Utility.arrayToStringByUpper(nameAndSurnames);
        
        matches = searchByName(arrayNameAndSurnames[0], contactos);
        matches = searchByApellido1(arrayNameAndSurnames[1], matches);
        matches = searchByApellido2(arrayNameAndSurnames[2], matches);
        
        return matches;
    }
    
    private ArrayList<Contacto> searchByApellido1(String apellido1, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<>();
        int surnameSize = apellido1.length();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            
            if(current.getApellido1().length() < surnameSize) { continue; }
            
            String matchString = current.getApellido1().substring(0, surnameSize);
            
            if(matchString.equals(apellido1)) 
            {
                matches.add(current);
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> searchByApellido2(String apellido2, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<>();
        int surnameSize = apellido2.length();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            
            if(current.getApellido2().length() < surnameSize) { continue; }
            
            String matchString = current.getApellido2().substring(0, surnameSize);
            
            if(matchString.equals(apellido2)) 
            {
                matches.add(current);
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> searchByTelefono(String telefono, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<>();
        int telefonoSize = telefono.length();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            String[] telefonos = current.getTelefonos();
            
            for (String telefono1 : telefonos) {
                if (telefono1.length() < telefonoSize) { continue; }
                
                String matchString = telefono1.substring(0, telefonoSize);
                if(matchString.equals(telefono)) 
                {
                    matches.add(current);
                    break;
                }
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> searchByMovil(String movil, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<>();
        int movilSize = movil.length();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            String[] moviles = current.getMoviles();
            
            for (String movile : moviles) {
                if (movile.length() < movilSize) { continue; }
                String matchString = movile.substring(0, movilSize);
                if(matchString.equals(movil)) 
                {
                    matches.add(current);
                    break;
                }
            }
        }
        return matches;
    }
    
    private ArrayList<Contacto> searchByDNI(String dni, ArrayList<Contacto> contactos) 
    {
        ArrayList<Contacto> matches = new ArrayList<>();
        int dniSize = dni.length();
        
        for(int i = 0; i < contactos.size(); i++) 
        {
            Contacto current = contactos.get(i);
            
            if(current.getDNI().length() < dniSize) { continue; }
            
            String matchString = current.getDNI().substring(0, dniSize);
            
            if(matchString.equals(dni)) 
            {
                matches.add(current);
            }
        }
        return matches;
    }
    
    public Contacto selectContacto(ArrayList<Contacto> contactos) 
    {
        String[] contactosArray = new String[contactos.size()];
        
        for(int i = 0; i < contactosArray.length; i++) 
        {
            contactosArray[i] = contactos.get(i).toString();
        }
        return contactos.get((new Menu(contactosArray).AskOption()) - 1);
    }
}
