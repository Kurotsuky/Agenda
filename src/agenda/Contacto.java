package agenda;

import utilidad.Utility;
import utilidad.Menu;

public class Contacto 
{
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
        this(0, "", "", "", "", new Date(), new String[] {"", "", "", "", ""}, 
                new String[] {"", "", "", "", ""}, "", "");
    }
    
    public Contacto(
            int id,
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
        this.id = id;
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
        contact = contact.replace("DI", dni.GetValor());
        contact = contact.replace("DD", direccion);
        contact = contact.replace("FN", fechaNacimiento.GetDate());
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
    
    public String GetNombre() { return nombre; }
    public String GetApellido1() { return apellido1; }
    public String GetApellido2() { return apellido2; }
    public String[] GetTelefonos() { return telefono; }
    public String[] GetMoviles() { return movil; }
    public String GetDNI() { return dni.GetValor(); }
    public Date GetFechaNacimiento() { return fechaNacimiento; }
    public String GetStringFechaNacimiento() { return fechaNacimiento.toString(); }
    public String GetEmail() { return email; }
    public String GetDireccion() { return direccion; }
    public void SetNombre(String nombre) { this.nombre = nombre; }
    public void SetApellido1(String apellido1) { this.apellido1 = apellido1; }
    public void SetApellido2(String apellido2) { this.apellido2 = apellido2; }
    public void SetDNI(String dni) { this.dni = new DNI(dni); }
    public void SetFechaNacimiento(int day, int month, int year) { this.fechaNacimiento = new Date(day, month, year); }
    public void SetEmail(String email) { this.email = email; }
    public void SetDireccion(String direccion) { this.direccion = direccion; }
    public void SetTelefono(String[] telefono) { this.telefono = telefono; }
    public void SetMovil(String[] movil) { this.movil = movil; }
    
    public void SetTelefono(String telefono) 
    { 
        String text = "";
        
        for(int i = 0; i < this.telefono.length; i++) 
        {
            text += (i+1) + "º " + this.telefono[i];
        }
        
        int index = new Menu(text).AskOption();
        this.telefono[index] = telefono; 
    }
    
    public void SetTelefono(String telefono, int index) 
    { 
        this.telefono[index] = telefono; 
    }
    
    public void SetMovil(String movil) 
    { 
        String text = "";
        
        for(int i = 0; i < this.movil.length; i++) 
        {
            text += (i+1) + "º " + this.movil[i];
        }
        
        int index = new Menu(text).AskOption();
        this.movil[index] = movil; 
    }
    
    public void SetMovil(String movil, int index) 
    { 
        this.movil[index] = movil; 
    }
}
