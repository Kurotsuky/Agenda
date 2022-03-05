package utils;

import java.util.Scanner;

public class DNIGenerator 
{
    public final static char[] LETTER = {'T', 'R', 
        'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 
        'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Integer dni = sc.nextInt();
        System.out.println(dni.toString() + LETTER[dni%23]);
    }
}
