package agenda;

public enum ContactFilter 
{
    Nombre("Nombre"), NombreYApellidos("Nombre y Apellidos"), 
    Telefono("Telefono"), Movil("Movil"), DNI("DNI");
    
    private String name;
    
    private ContactFilter(String name) 
    {
        this.name = name;
    }
    
    public String getName() { return name; }
}
