package view;

import controller.AgendaController;
import models.ContactSearcher;
import models.Contacto;
import models.Date;
import models.SaveAgendaSystem;
import utils.Menu;
import utils.Utility;

public class Main {
    
    public static void main(String[] args) {
        String filePath = "archivos\\Contactos.txt";
        SaveAgendaSystem saveSystem = new SaveAgendaSystem(filePath);
        AgendaController agendaController = new AgendaController(saveSystem.load());
        
        if(Utility.AskOption("¿Quieres usar interfaz grafica?", "S", "N")) {
            new AgendaForm(agendaController, saveSystem).setVisible(true);
            return;
        }
        
        int optionSelected;
        do 
        {
            optionSelected = new Menu("Crear Contacto \nBorrar Contacto \nModificar Contacto \nInsertar Contacto \nBuscar Contacto \nSalir").AskOption();
            selectFunction(agendaController, optionSelected);
            saveSystem.save();
            
        } while(optionSelected != 6);
    }
    
    private static void selectFunction(AgendaController agendaController, int selected)
    {
        switch(selected) 
        {
            case 1:
                inputContactoInfo(agendaController);
                break;
            case 2:
                agendaController.borrarContacto();
                break;
            case 3:
                Contacto contacto = new ContactSearcher().searchContactByInput(agendaController.getAgenda());
                String field = inputWhichContactoUpdate();
                String newValue = inputContactoUpdateValue(field);
                
                agendaController.modificarContacto(contacto, field, newValue);
                break;
            case 4:
                agendaController.insertarContacto();
                break;
            case 5:
                Contacto searched = new ContactSearcher().searchContactByInput(agendaController.getAgenda());
                agendaController.buscarContacto(searched);
                break;
        }
    }
    
    private static void inputContactoInfo(AgendaController agendaController) {
        String dni = Utility.AskString("DNI: ");
        String nombre = Utility.AskString("Nombre: ");
        String apellido1 = Utility.AskString("Primer Apellido: ");
        String apellido2 = Utility.AskString("Segundo Apellido: ");
        Date fechaNacimiento = new Date(Utility.AskDate(new String[] { "Fecha de Nacimiento: \n  Dia: ", "  Mes: ", "  Año: " }));
        String[] telefono = Utility.AskStringArray("Telefono", 5);
        String[] movil = Utility.AskStringArray("Movil", 5);
        String email = Utility.AskString("Email: ");
        String direccion = Utility.AskString("Dirección: ");
        
        agendaController.crearContacto(new Contacto(dni, nombre, apellido1, apellido2, fechaNacimiento, telefono, movil, email, direccion));
    }
    
    private static String inputWhichContactoUpdate() {
        String[] options = { "Nombre", "Apellido1", "Apellido2", "Telefono", "Movil", "DNI", "Fecha de Nacimiento", "Email", "Direccion" };
        System.out.println("Seleccione el campo que quiere modificar: ");
        int optionSelected = new Menu(options).AskOption();
        return options[optionSelected];
    }
    
    private static String inputContactoUpdateValue(String field) {
        if(field.equals("Fecha de Nacimiento")) {
            String newValue = "";
            newValue += Utility.AskInt("Dia: ") + " ";
            newValue += Utility.AskInt("Mes: ") + " ";
            newValue += Utility.AskInt("Año: ");
            return newValue;
        }
        
        if(field.equals("Telefono") || field.equals("Movil")) {
            String newValue = "";
            newValue += Utility.AskString("-> ") + " ";
            newValue += Utility.AskString("¿Cuál de los 5? ");
            return newValue;
        }
        
        return Utility.AskString("-> ");
    }
}
