package controller;

import models.Agenda;
import models.ContactSearcher;
import models.Contacto;
import utils.Utility;

public class AgendaController 
{
    private Agenda agenda;
    
    
    public AgendaController() {
        this(new Agenda());
    }
    
    public AgendaController(Agenda agenda) {
        this.agenda = agenda;
    }
    
    
    public void crearContacto(Contacto contacto)
    {
        agenda.addContacto(contacto);
    }
    
    public void borrarContacto()
    {
        Contacto searched = new ContactSearcher().searchContactByInput(agenda);
        agenda.removeContacto(searched);
    }
    
    public void borrarContacto(Contacto contacto)
    {
        agenda.removeContacto(contacto);
    }
    
    public void modificarContacto(Contacto contacto, String field, String newValue)
    {
        switch(field) {
            case "Nombre":
                contacto.setNombre(newValue);
                break;
            case "Apellido1":
                contacto.setApellido1(newValue);
                break;
            case "Apellido2":
                contacto.setApellido2(newValue);
                break;
            case "Telefono":
                String[] numAndIndex = Utility.GetArrayOfString(newValue, " ");
                contacto.setTelefono(numAndIndex[0], Integer.parseInt(numAndIndex[1]));
                break;
            case "Movil":
                String[] phoneAndIndex = Utility.GetArrayOfString(newValue, " ");
                contacto.setMovil(phoneAndIndex[0], Integer.parseInt(phoneAndIndex[1]));
                break;
            case "DNI":
                contacto.setDNI(newValue);
                break;
            case "Fecha De Nacimiento":
                String[] date = Utility.GetArrayOfString(newValue, " ");
                contacto.setFechaNacimiento(Integer.parseInt(date[0]), 
                        Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                break;
            case "Email":
                contacto.setEmail(newValue);
                break;
            case "Direccion":
                contacto.setDireccion(newValue);
                break;
            
        }
    }
    
    public void insertarContacto()
    {
        
    }
    
    public void insertarContacto(Contacto contacto)
    {
        agenda.addContacto(contacto);
    }
    
    public void buscarContacto(Contacto contacto) 
    {
        if(contacto == null) 
        { 
            System.out.println("Contacto no encontrado.");
            return; 
        }
        System.out.println("\n" + contacto.toString());
    } 
    

    public Agenda getAgenda(){ return agenda; }
}
