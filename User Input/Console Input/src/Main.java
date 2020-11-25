import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
        String inputString = scanner.nextLine();
        System.out.println("You entered: " + inputString);

        System.out.print("> ");
        int inputNumber = scanner.nextInt();
        System.out.println("Your number squared: " + inputNumber * inputNumber);
    }
}