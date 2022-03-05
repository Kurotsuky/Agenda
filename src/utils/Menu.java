package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Menu 
{
    private String[] optionsText;
    private Scanner sc = new Scanner(System.in);
    
    
    public Menu(String[] optionsText) 
    {
        this.optionsText = optionsText;
    }
    
    public Menu(String optionsText) 
    {
        this.optionsText =  GetStringText(optionsText);
    }
    
    public Menu(File file) throws FileNotFoundException 
    {
        this.optionsText =  GetFileText(file);
    }
    
    
    public int AskOption() 
    {
        int optionSelected = 0;
        
        do 
        {
            WriteOptions();
            System.out.print("Elige una opción: ");
            optionSelected = sc.nextInt();
            
            if(optionSelected <= optionsText.length && optionSelected > 0) 
            {
                return optionSelected;
            }
        } 
        while(true);
    }
    
    private void WriteOptions() 
    {
        for(int i = 0; i < optionsText.length; i++) 
        {
            System.out.println((i+1) + ": " + optionsText[i]);
        }
    }
    
    private String[] GetStringText(String text) 
    {
        StringTokenizer st = new StringTokenizer(text, "\n"); 
        String[] arrayText = new String[st.countTokens()];
        
        for(int i = 0; i < arrayText.length; i++) 
        {
            arrayText[i] = st.nextToken();
        } 
        return arrayText;
    }
    
    private String[] GetFileText(File file) throws FileNotFoundException 
    {
        Scanner fileScanner = new Scanner(file);
        String text = "";
        
        while(fileScanner.hasNextLine()) 
        {
            text += fileScanner.nextLine();
            
            if(fileScanner.hasNextLine()) 
            {
                text += "\n";
            }
        }
        text = text.replace("\\n", "\n");
        return GetStringText(text);
    }
}
