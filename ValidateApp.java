
/**
 * A class that provides a console-based menu to the user and utilizes the
 * validations class to validate input from the user.
 *
 * @author Nick Coyle
 * @version 10.12.2018
 */
import java.util.Scanner;

public class ValidateApp
{
    public static Scanner input;
    
    public static void main(String[] args) {
        input = new Scanner(System.in);
        
        int menuChoice;
        
        do {
            printMenu();
            
            menuChoice = input.nextInt();
            
            switch(menuChoice) {
            case 0:
                break;
            case 1: 
                getInput("Please enter your zipcode", "zipcode");
                break;
            case 2: 
                getInput("Please enter your Social Security Number", "ssn");
                break;
            case 3:
                getInput("Please enter your Password", "password");
                break;
            case 4:
                getInput("Please enter instructions", "instructions");
                break;
            default: 
                System.out.println("Please enter a valid menu option");
                break;
            }
   
        } while (menuChoice != 0);     
       
    }
    
    public static void printMenu() {          
        System.out.println("Please choose an option from the menu below");
        System.out.println("1. validate zip code ");
        System.out.println("2. validate SSN ");
        System.out.println("3. validate password ");
        System.out.println("4. instructions ");
        System.out.println("0. quit "); 
    }
    
    public static String getInput(String msg, String type) {
        System.out.println(msg);
        String in = input.next();        
        
        boolean isValid = false;
        
        switch(type) {
            case "zipcode":
            isValid = Validations.isValidZip(in);
            break;
            case "ssn":
            isValid = Validations.isValidSSN(in);
            break;
            case "password":
            isValid = Validations.isValidPassword(in);
            break;
            case "instructions":
            isValid = Validations.isValidInstructions(in);
            break;
        }
        
        if(!isValid) {
            getInput("You did not enter a valid " + type + ". Please enter a valid " + type, type);
        }
        return in;
    }
}