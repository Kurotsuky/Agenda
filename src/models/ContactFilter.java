package models;

public enum ContactFilter 
{
    Nombre("Nombre"), NombreYApellidos("Nombre y Apellidos"), 
    Telefono("Telefono"), Movil("Movil"), DNI("DNI");
    
    private final String name;
    
    private ContactFilter(String name) 
    {
        this.name = name;
    }
    
    public String getName() { return name; }
}
