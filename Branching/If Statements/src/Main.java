public class Main {
    public static String solution() {
        int a = 4;
        int b = 6;

        if (b > a) {
         /*
         A return statement will always end the method,
         so the second return statement will only be reached
         if the code in this if statement did not run
          */
            return "b is greater than a";
        }

        return "a is greater than b";
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}