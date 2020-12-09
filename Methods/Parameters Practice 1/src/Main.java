public class Main {
    // Prints the integers from start to stop on one line
    static void printNumberRange(int start, int stop) {
        String output = "";
        for(int i = start; i <= stop; i++) {
            output += i; // Same as output = output + i
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        // Write your solution here
        for (int i = 0; i < 8; i++) {
            printNumberRange(i, i + 2);
        }
    }
}