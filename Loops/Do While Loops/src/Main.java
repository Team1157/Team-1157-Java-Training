public class Main {
   public static void main(String[] args) {
      float a;
      do {
         a = (float) Math.random(); // Get a random float from 0 to 1
      } while (a < 0.5);
      System.out.println(a);
   }
}