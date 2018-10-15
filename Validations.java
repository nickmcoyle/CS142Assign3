
/**
 * A supplier class that has logic to validate all kinds of input from the user
 *
 * @author Nick Coyle
 * @version 10.16.2018
 */
public class Validations
{    
   /**
    * A method to test if a string is a valid zip code
    * Criteria:
    * 5 digits with optional 4 extra at the end
    * No letters
    */
   public static boolean isValidZip(String zip) {
       //a question mark after parenthesis makes the section optional (0 or 1 occurences)
       //a question mark inside a block means only one of the preceding characters
       return zip.matches("[0-9]{5}(-?[0-9]{4})?");
   }
   
   /**
    * A method to test if a String is a valid SSN
    * Criteria:
    * 3 digits followed by a dash followed by 2 digits and a dash followed by 4 digits and a dash
    */
   public static boolean isValidSSN(String ssn) {
       return ssn.matches("[0-9]{3}-{1}[0-9]{2}-{1}[0-9]{4}");
   }
   
   /**
    * A method to test if a string is a valid password. Here are the criteria:
    * at least 6 characters
    * at least 1 uppercase
    * at least 1 symbol
    * at least 1 digit
    * no spaces
    */
    public static boolean isValidPassword(String password) {
        //[^ ]* regex disallows any number of spaces
       return password.matches("[^ ]*");
   }   
}
