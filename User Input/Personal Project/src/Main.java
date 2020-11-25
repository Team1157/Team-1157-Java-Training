// Imports go here
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      // Things that only need to happen once go outside the loop
      Scanner scanner = new Scanner(System.in);

      while (true) {
         System.out.println("Enter a string:");

         String input = scanner.nextLine();
         if (input.equals("quit")) { // use .equals instead of == for Strings
            break;
         } else {
            // Do stuff
            System.out.println("You entered: " + input);
         }
      }

      System.out.println("Quitting ...");
   }
}
