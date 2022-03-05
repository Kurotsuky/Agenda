package utils;

import java.util.Scanner;

public class DNIGenerator 
{
    public final static char[] LETTER = {'T', 'R', 
        'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    private final static int NUMBERS_LENGTH = 8;
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        String dniNumbers = getDNINumbers();
        char letter = LETTER[Integer.parseInt(dniNumbers) % LETTER.length];
        String dni = dniNumbers + letter;
        System.out.println(dni);
    }
    
    private static String getDNINumbers() {
        if(askRandomGenerate()) {
            return randomGenerate();
        }
        return inputDNI();
    }
    
    private static Boolean askRandomGenerate() {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        do {
            System.out.print("¿Random Generate? S/N ");
            answer = sc.nextLine().toUpperCase();
        } while(!answer.equals("S") && !answer.equals("N"));
        return answer.equals("S");
    }
    
    private static String randomGenerate() {
        String dniNumbers = "";
        
        for(int i = 0; i < NUMBERS_LENGTH; i++) {
            int random = Utility.RandomNumber(0, 9);
            dniNumbers += random;
        }
        return dniNumbers;
    }
    
    private static String inputDNI() {
        Scanner sc = new Scanner(System.in);
        String dniNumbers;
        
        do {
            System.out.print("DNI: ");
            dniNumbers = sc.nextLine();
        } while(!checkNumbers(dniNumbers));
        return  dniNumbers;
    }
    
    private static Boolean checkNumbers(String dniNumbers) {
        return dniNumbers.length() == NUMBERS_LENGTH;
    }
}
