package models;

import utils.Utility;
import utils.Menu;

public class Contacto 
{
    private static int numberOfContactos;
    
    private int id;
    private DNI dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private String[] telefono;
    private String[] movil;
    private String email;
    private String direccion;
    
    
    public Contacto() 
    {
        this("", "", "", "", new Date(), new String[] {"", "", "", "", ""}, 
                new String[] {"", "", "", "", ""}, "", "");
    }
    
    public Contacto(
            String dni,
            String nombre,
            String apellido1,
            String apellido2,
            Date fechaNacimiento,
            String[] telefono,
            String[] movil,
            String email,
            String direccion) 
    {
        this.id = numberOfContactos++;
        this.dni = new DNI(dni);
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.movil = movil;
        this.email = email;
        this.direccion = direccion;
    }
    
    @Override
    public String toString() 
    {
        String contact = 
                "Nombre: NN \n"
                + "Primer Apellido: A1 \n"
                + "Segundo Apellido: A2 \n"
                + "Teléfono: TT \n"
                + "Móvil: MM \n"
                + "Fecha de Nacimiento: FN \n"
                + "Email: EE \n"
                + "DNI: DI \n"
                + "Dirección: DD \n";
        
        contact = contact.replace("NN", nombre);
        contact = contact.replace("A1", apellido1);
        contact = contact.replace("A2", apellido2);
        contact = contact.replace("EE", email);
        contact = contact.replace("DI", dni.getValor());
        contact = contact.replace("DD", direccion);
        contact = contact.replace("FN", fechaNacimiento.toString());
        contact = contact.replace("TT", Utility.GetStringOfArray(telefono));
        contact = contact.replace("MM", Utility.GetStringOfArray(movil));
        
        return contact;
    }
    
    public String toStringSimple() 
    {
        String contact = "NN -> TT";
        
        contact = contact.replace("NN", nombre);
        
        if(!movil[0].equals("")) 
        {
            contact = contact.replace("TT", movil[0]);
        }
        contact = contact.replace("TT", telefono[0]);
        
        return contact;
    }
    
    public String getNombre() { return nombre; }
    public String getApellido1() { return apellido1; }
    public String getApellido2() { return apellido2; }
    public String[] getTelefonos() { return telefono; }
    public String[] getMoviles() { return movil; }
    public String getDNI() { return dni.getValor(); }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public String getStringFechaNacimiento() { return fechaNacimiento.toString(); }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }
    public void setDNI(String dni) { this.dni = new DNI(dni); }
    public void setFechaNacimiento(int day, int month, int year) { this.fechaNacimiento = new Date(day, month, year); }
    public void setEmail(String email) { this.email = email; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String[] telefono) { this.telefono = telefono; }
    public void setMovil(String[] movil) { this.movil = movil; }
    
    public void setTelefono(String telefono) 
    { 
        String text = "";
        
        for(int i = 0; i < this.telefono.length; i++) 
        {
            text += (i+1) + "º " + this.telefono[i];
        }
        
        int index = new Menu(text).AskOption();
        this.telefono[index] = telefono; 
    }
    
    public void setTelefono(String telefono, int index) 
    { 
        this.telefono[index] = telefono; 
    }
    
    public void setMovil(String movil) 
    { 
        String text = "";
        
        for(int i = 0; i < this.movil.length; i++) 
        {
            text += (i+1) + "º " + this.movil[i];
        }
        
        int index = new Menu(text).AskOption();
        this.movil[index] = movil; 
    }
    
    public void setMovil(String movil, int index) 
    { 
        this.movil[index] = movil; 
    }
}
