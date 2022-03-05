package models;
import java.util.ArrayList;

public class Agenda 
{
    private ArrayList<Contacto> contactos;
    
    
    public Agenda() 
    {
        contactos = new ArrayList<>();
    }
    
    public Agenda(ArrayList<Contacto> contactos)
    {
        this.contactos = contactos;
    }
    
    
    public void addContacto(Contacto contacto) {
        contactos.add(contacto);
    }
    
    public void removeContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
    
    public int size() {
        return contactos.size();
    }
    
    @Override
    public String toString() 
    {
        String string = "";
        for (Contacto contacto : contactos) 
        {
            String[] contactoData = {
                contacto.getDNI(),
                contacto.getNombre(),
                contacto.getApellido1(),
                contacto.getApellido2(),
                contacto.getStringFechaNacimiento(),
                contacto.getTelefonos()[0],
                contacto.getTelefonos()[1],
                contacto.getTelefonos()[2],
                contacto.getTelefonos()[3],
                contacto.getTelefonos()[4],
                contacto.getMoviles()[0],
                contacto.getMoviles()[1],
                contacto.getMoviles()[2],
                contacto.getMoviles()[3],
                contacto.getMoviles()[4],
                contacto.getEmail(),
                contacto.getDireccion()
            };
            
            for (String contactoData1 : contactoData) {
                string += contactoData1;
                string += ",";
            }
            string += "\n";
        }
        return string;
    }

    public ArrayList<Contacto> getContactos() { return contactos; }
}
