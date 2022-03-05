package models;

public class DNI 
{
    public final static char[] LETTER = {'T', 'R', 
        'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    private String valor;
    
    
    public DNI() 
    {
        valor = "00000000T";
    }
    
    public DNI(String dni) 
    {
        valor = check(dni);
    }
    
    private String check(String dni) 
    {
        if(dni.length() != 9) 
        {
            System.out.println("El dni es incorrecto");
            return "";
        }
        
        int numbers = Integer.parseInt(dni.substring(0, 8));
        dni = dni.toUpperCase();
        char letter = dni.charAt(8);
        
        if(LETTER[numbers%23] == letter) 
        {
            return dni;
        }
        System.out.println("El dni es incorrecto");
        return "";
    }
    
    public String getValor() { return valor; }
}
