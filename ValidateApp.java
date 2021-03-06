
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
                printInstructions();
                break;
            default: 
                System.out.println("Please enter a valid menu option");
                break;
            }
   
        } while (menuChoice != 0);     
       
    }
    
    /**
     * A method to print menu options to the user
     */
    public static void printMenu() {          
        System.out.println("Please choose an option from the menu below");
        System.out.println("1. validate zip code ");
        System.out.println("2. validate SSN ");
        System.out.println("3. validate password ");
        System.out.println("4. instructions ");
        System.out.println("0. quit "); 
    }
    
    /**
     * A method to print some instructions to the user.
     */
    public static void printInstructions() {
        System.out.println();
        System.out.println("Instructions:");
        System.out.println("Choose an option from the menu. It will prompt you to enter your personal information.");
        System.out.println("Don't worry. Just enter it. It will be validated to make sure you entered valid data.");
        System.out.println("Zipcode: 5 digits with optional 4 extra at the end separated by a dash");
        System.out.println("SSN: 3 digits followed by a dash followed by 2 digits and a dash followed by 4 digits and a dash");
        System.out.println("Password: at least 6 characters upper or lowercase, at least 1 symbol, at least 1 digit, no spaces");
        System.out.println();
    }
    
    /**
     * A method to get input from the console until the input is valid
     * The problem with this is that I have to know which type of input im getting before I can properly validate it. This could lead to a typo if I 
     * use a switch method and just have string literals to keep track of all the types. It's also a nightmare to maintain later if we want to change
     * anything, you have to change it in about 3 different places. Its not very robust. Not sure how to make this better, other than making the validations
     * interface have only one method thats accept a String to know which type to validate and even that would not be better.
     * 
     * @param String msg the prompt for the user to know what to enter
     * @param String type the data type we are getting so we know which validation method to call on it.
     */
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
        }
        
        if(!isValid) {
            getInput("You did not enter a valid " + type + ". Please enter a valid " + type, type);
        }
        return in;
    }
}