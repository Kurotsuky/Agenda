/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaTests;

import models.Contacto;
import models.Agenda;
import models.ContactSearcher;
import models.DNI;
import models.ContactFilter;
import models.Date;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class AgendaTests
{
    static Agenda agenda = new Agenda();
    static ContactSearcher searcher;

    @Before
    public void setUp() throws Exception
    {
        agenda.addContacto(
                new Contacto("54109717D", "Adalberto", "Perdomo", "Abreu", 
                        new Date(3, 5, 2001), new String[] {"822902312", "", "", "", ""}, new String[] {"630639968", "", "", "", ""}, 
                        "adalbertoperdomoabreu@gmail.com" , "Calle Rosendo Diaz Mendez"));
        searcher = new ContactSearcher();
    }
    
    @Test
    public void expected_AddContact() throws IOException {
        Contacto contacto = new Contacto(
                "43970914C", "Rodrigo", "Fernandez", "Perez", 
                new Date(5, 11, 1999), new String[] {"922807250","","","",""}, new String[] {"672679054","","","",""}, 
                "rodrigofernandez@gmail.com", "Calle San Agustin");
        agenda.addContacto(contacto);
        Contacto searched1 = searcher.searchContact("Rodrigo", ContactFilter.Nombre, agenda.getContactos()).get(0);
        
        agenda.addContacto(new Contacto(
                "62709029N", "Manuel", "de la Casa", "Castillo", 
                new Date(10, 4, 1989), new String[] {"922609125","","","",""}, new String[] {"610905834","","","",""}, 
                "manuelcasas@gmail.com", "Calle Puerta Vieja"));
        Contacto searched2 = searcher.searchContact("Manuel", ContactFilter.Nombre, agenda.getContactos()).get(0);
        
        assertEquals(true, agenda.getContactos().contains(searched1));
        assertEquals(true, agenda.getContactos().contains(searched2));
    }
    
    @Test
    public void expected_RemoveContact() {
        Contacto searched = searcher.searchContact("Adalberto", ContactFilter.Nombre, agenda.getContactos()).get(0);
        agenda.removeContacto(searched);
        
        assertEquals(false, agenda.getContactos().contains(searched));
    }
    
    @Test
    public void return_SearchedContactByName() {
        Contacto expectedSearched = agenda.getContactos().get(0);
        
        ArrayList<Contacto> searcheds1 = searcher.searchContact("Adalberto", ContactFilter.Nombre, agenda.getContactos());
        Contacto searched1 = searcheds1.get(0);
        
        ArrayList<Contacto> searcheds2 = searcher.searchContact("Adal", ContactFilter.Nombre, agenda.getContactos());
        Contacto searched2 = searcheds2.get(0);
        
        assertEquals(expectedSearched, searched1);
        assertEquals(expectedSearched, searched2);
    }
    
    @Test
    public void return_SearchedContactByNameAndSurname() {
        Contacto expectedSearched = agenda.getContactos().get(0);
        
        ArrayList<Contacto> searcheds1 = searcher.searchContact("Adalberto Perdomo Abreu", ContactFilter.NombreYApellidos, agenda.getContactos());
        Contacto searched1 = searcheds1.get(0);
        
        ArrayList<Contacto> searcheds2 = searcher.searchContact("Adal Perdo Ab", ContactFilter.NombreYApellidos, agenda.getContactos());
        Contacto searched2 = searcheds2.get(0);
        
        ArrayList<Contacto> searcheds3 = searcher.searchContact("Adal Perdo", ContactFilter.NombreYApellidos, agenda.getContactos());
        Contacto searched3 = searcheds3.get(0);
        
        ArrayList<Contacto> searcheds4 = searcher.searchContact("Adal", ContactFilter.NombreYApellidos, agenda.getContactos());
        Contacto searched4 = searcheds4.get(0);
        
        
        assertEquals(expectedSearched, searched1);
        assertEquals(expectedSearched, searched2);
        assertEquals(expectedSearched, searched3);
        assertEquals(expectedSearched, searched4);
    }
    
    @Test
    public void return_SearchedContactByTelefono() {
        Contacto expectedSearched = agenda.getContactos().get(0);
        
        ArrayList<Contacto> searcheds1 = searcher.searchContact("822902312", ContactFilter.Telefono, agenda.getContactos());
        Contacto searched1 = searcheds1.get(0);
        
        ArrayList<Contacto> searcheds2 = searcher.searchContact("822", ContactFilter.Telefono, agenda.getContactos());
        Contacto searched2 = searcheds2.get(0);
        
        assertEquals(expectedSearched, searched1);
        assertEquals(expectedSearched, searched2);
    }
    
    @Test
    public void return_SearchedContactByMovil() {
        Contacto expectedSearched = agenda.getContactos().get(0);
        
        ArrayList<Contacto> searcheds1 = searcher.searchContact("630639968", ContactFilter.Movil, agenda.getContactos());
        Contacto searched1 = searcheds1.get(0);
        
        ArrayList<Contacto> searcheds2 = searcher.searchContact("630", ContactFilter.Movil, agenda.getContactos());
        Contacto searched2 = searcheds2.get(0);
        
        assertEquals(expectedSearched, searched1);
        assertEquals(expectedSearched, searched2);
    }
    
    @Test
    public void return_SearchedContactByDNI() {
        Contacto expectedSearched = agenda.getContactos().get(0);
        
        ArrayList<Contacto> searcheds1 = searcher.searchContact("54109717D", ContactFilter.DNI, agenda.getContactos());
        Contacto searched1 = searcheds1.get(0);
        
        ArrayList<Contacto> searcheds2 = searcher.searchContact("541", ContactFilter.DNI, agenda.getContactos());
        Contacto searched2 = searcheds2.get(0);
        
        assertEquals(expectedSearched, searched1);
        assertEquals(expectedSearched, searched2);
    }
    
    @Test
    public void check_CorrectDNI() {
        DNI correctDni = new DNI("54109717d");
        String expectedDNI = "54109717D";
        
        DNI incorrectDni = new DNI("54109717f");
        String expectedIncorrectDNI = "";
        
        assertEquals(expectedDNI, correctDni.getValor());
        assertEquals(expectedIncorrectDNI, incorrectDni.getValor());
    }
   
}
