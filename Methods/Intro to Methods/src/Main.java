public class Main {
    // Define exampleMethod:
    static void exampleMethod() {
        System.out.println("I'm in a method!");
    }

    public static void main(String[] args) {
        // Only the code in this block is actually run by default

        System.out.println("Before the method");
        // Call exampleMethod
        exampleMethod();

        System.out.println("Between the method calls");
        // Call it again
        exampleMethod();

        System.out.println("After the method");
    }
}