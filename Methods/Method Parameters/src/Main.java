public class Main {
    // Define exampleMethod:
    static void printNTimes(String message, int n) {
        for(int i = 0; i < n; i++) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        // Only the code in this block is actually run by default

        // Call the method with a parameter
        printNTimes("Penguins are awesome!", 2);

        printNTimes("So is programming!", 4);
    }
}